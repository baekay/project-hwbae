package sfmi.component.mdm.service.batch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.AnalyzerStringUtil;
import sfmi.component.mdm.common.util.FileCollector;
import sfmi.component.mdm.common.util.PropertyLoader;
import sfmi.component.mdm.common.util.XmlParser;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.dto.JobBeanInfo;
import sfmi.component.mdm.dto.JobInfo;
import sfmi.component.mdm.dto.SqlAnalyzeData;
import sfmi.component.mdm.dto.StepInfo;
import sfmi.component.mdm.dto.Writer;
import sfmi.component.mdm.handler.ExceptionHandler;
import sfmi.component.mdm.listener.BatchJobListener;

/**
 * Batch의 XML 파일을 파싱하여 정보를 저장한다.
 * @author hwbae
 *
 */
public class CollectBatchXmlInfoService{
	
	private static Logger logger = Logger.getLogger(CollectBatchXmlInfoService.class);
	
	final String SFMI_BATCH_JOB = "sfmiJob";
	final String BEAN_PARENT_ATTRIBUTE = "parent";
	final String BEAN_ID_VALUE = "id";
	final String PROPERTY_NAME_ATTRIBUTE = "name";
	final String PROPERTY_STEP_VALUE = "steps";
	final String PROPERTY_VALUE = "value";
	final String PROPERTY_REF = "ref";
	final String UTIL_STEPLISTENERS_VALUE = "stepListeners";
	final String PROPERTY_INDATASOURCE = "inDataSource";
	final String PROPERTY_OUTDATASOURCE = "outDataSource";
	final String PROPERTY_PREOCESSOR = "processor";
	
	public Map<String, List<AnalyzeData>> collectXmlData() {
		Properties propertyLoader = PropertyLoader.load();
		return collectXmlData(propertyLoader.getProperty("target.source.path"));
	}
	
	public Map<String, List<AnalyzeData>> collectXmlData(String targetSourcePath) {
		// 결과 저장 객체 
		Map<String, List<AnalyzeData>> xmlAnalyzeDataMap = new HashMap<String, List<AnalyzeData>>(); 
		List<AnalyzeData> sqlXmlList = new ArrayList<AnalyzeData>();		// sql xml 데이터
		List<AnalyzeData> batchJobList = new ArrayList<AnalyzeData>();					// BatchJob 데이터
		
		if(targetSourcePath == null){
			Properties propertyLoader = PropertyLoader.load();
			targetSourcePath = propertyLoader.getProperty("target.source.path");
		}
		
		File targetDir = new File(targetSourcePath);
		
		// 파일 수집 
		if(logger.isInfoEnabled()){
			logger.info("XML 파일 확장자 검사 후 수집합니다..");
		}
		
		// FileCollector를 사용하여 확장자가 XML인 파일을 수집한다.
		FileCollector fileCollector = new FileCollector(SQLAnalyzerConstants.XML_FILE_COLLECT_MODE);
		fileCollector.collectFiles(targetDir);
		
		// 확장자 체크 완료 파일 
		List<File> fileList = fileCollector.getFileList();
		
		if(logger.isInfoEnabled()) {
			logger.info("XML 파일 수집 완료 합니다.");
		}
		
		if(logger.isInfoEnabled()){
			logger.info("XML FILE NAME을 파싱하여 SQL 정보를 수집합니다.");
		}
		
		AnalyzeData analyzeData = null;
		
		// XML fileName을 파싱하여 SQL, BATCH XML을 판단한다.

		for(File file : fileList){
			// 파일이름으로 넘겨 XML 파싱한다.
			try {
				if(logger.isInfoEnabled()){
					logger.info("XML PATH :" + file.getAbsolutePath());
					logger.info("\t[START]----------------------------------------------");
				}
				
				analyzeData = analyzeXml(file.getAbsolutePath());
				
				if(logger.isInfoEnabled()){
					logger.info("\t[END]----------------------------------------------");
				}
				
				
			} catch (SAXException e) {
				ExceptionHandler.handle(e, null, null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null, null);
			} catch (ParserConfigurationException e) {
				ExceptionHandler.handle(e, null, null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null, null);
			} catch (IOException e) {
				 ExceptionHandler.handle(e, null, null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null, XmlParser.class);
			}
			
			if(analyzeData instanceof SqlAnalyzeData) {
				sqlXmlList.add(analyzeData);
			} else if(analyzeData instanceof JobInfo) {
				batchJobList.add(analyzeData);
			} else {
				
				if(logger.isDebugEnabled()){
					logger.debug("관련 없는 XML 입니다.");
				}
			}
		}
		
		xmlAnalyzeDataMap.put("SQL", sqlXmlList);
		xmlAnalyzeDataMap.put("BATCH", batchJobList);
		
		
		if(logger.isInfoEnabled()){
			logger.info("XML 분석을 종료 합니다");
		}
		
		
		return xmlAnalyzeDataMap;
	}
	
	
	/**
	 * XML 파일을 분석하여 Batch, SQL 파일여부를 판단한다.
	 * @param filePath
	 * @return
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	private AnalyzeData analyzeXml(String filePath) throws SAXException, ParserConfigurationException, IOException{
		final String SQL_XML_ROOT_ELEMENT = "DAOConfiguration";
		
		// 결과저장 
		AnalyzeData analyzeData = null;
		
		File targetFile = new File(filePath);
		
		// 파일의 존재 여부 체크 
		if(targetFile.exists()){
			Document doc;
			
			if (logger.isDebugEnabled()) {
				logger.debug("XML 파일을 파싱합니다.  [ " + targetFile + " ]");
			}
			
			doc = XmlParser.getDocument(targetFile);
			
			Element rootElement = doc.getDocumentElement();
			String rootElementName = rootElement.getNodeName();
			
			// SQL 관련 XML
			if(rootElementName.equals(SQL_XML_ROOT_ELEMENT)){
				if(logger.isDebugEnabled()){
					logger.debug("\tSQL관련 XML 입니다. [ " + targetFile + " ]");
				}
				analyzeData = new SqlAnalyzeData();
				((SqlAnalyzeData)analyzeData).setXmlFile(filePath);
				
				if(logger.isInfoEnabled()){
					logger.debug("\t\tXML FILE [" + targetFile + " ]");
				}
				
				// 대상 XML 파일 카운트 
				BatchJobListener.countListener(SQLAnalyzerConstants.XML_FILE_CNT);
				
				return analyzeData;
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("\tSQL관련 XML이 아닙니다. [ " + targetFile + " ]");
				}
				
				if(logger.isDebugEnabled()){
					logger.debug("\tBATCH관련 XML인지 체크 합니다.");
				}
				// Batch관련 XML 파일인지 체크
				analyzeData = analyzeBatchJob(doc, filePath);
				
				// Job ID 가 존재하면 Batch 파일이라고 판단한다.
				if(((JobInfo)analyzeData) != null){
					// 대상 XML (JOB)파일 카운트 
					BatchJobListener.countListener(SQLAnalyzerConstants.JOB_XML_FILE_CNT);
					return analyzeData;
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("\t대상 XML 파일이 아닙니다..");
					}
				}
			}//
		} else {
			/* DO NOTHING */
			if(logger.isDebugEnabled()){
				logger.debug("파일이 존재하지 않습니다.  [ " + targetFile + " ] ");
			}
		}
		
		return analyzeData;
	}
	
	/**
	 * Batch관련 XML인지 판단하여 정보 분석, 저장한다.
	 * TODO :: 단순하게 리팩토링 해보자... 
	 * @param doc
	 * @return
	 */
	private JobInfo analyzeBatchJob(Document doc, String filePath){
		List<StepInfo> stepList = new ArrayList<StepInfo>();
		List<JobBeanInfo> beanList = new ArrayList<JobBeanInfo>();
		JobInfo jobInfo = null;
		StepInfo stepInfo = null;
		JobBeanInfo beanInfo = null;
		Map<String, String> stepPropertyInfo = null;
		Map<String, String> writerPropertyInfo = null;
		Map<String, String> propertyInfo = null;
		
		// rootElement의 자식 노드를 가지고 온다.
		Element rootElement = doc.getDocumentElement();
		String rootElementName = rootElement.getNodeName();
		NodeList beanNodeList = rootElement.getChildNodes();
		
		if(rootElementName.equals("beans")){
			jobInfo = new JobInfo();
				
			/*
			 * jobXmlPath를 저장한다.
			 */
			jobInfo.setJobXmlPath(AnalyzerStringUtil.setFileRootDir(filePath));
			
			for(int i = 0; i < beanNodeList.getLength(); i++){
				Node beanNode = beanNodeList.item(i);
				
				if(beanNode.getNodeType() == Node.ELEMENT_NODE){
					Element beanElement = (Element)beanNode;
					String beanNodeName = beanElement.getNodeName();
					String beanParentValue = beanElement.getAttribute(BEAN_PARENT_ATTRIBUTE);
					
					// parent의 value가 sfmiJob이면 Batch관련 XML이다.
					if(beanParentValue.equals(SFMI_BATCH_JOB)){
						if(logger.isDebugEnabled()){
							logger.debug("BATCH관련 XML입니다. " +" [ " +filePath+ " ] ");
						}
						// JobID저장
						jobInfo.setJobId(beanElement.getAttribute(BEAN_ID_VALUE));
						// VOB명과 PJT명 저장
						jobInfo.setVobAndPjtName(AnalyzerStringUtil.extractVobName(filePath));
						
						if(logger.isInfoEnabled()){
							logger.info("\t\t[ JOB ID : " + jobInfo.getJobId()+" ] ");
						}
	
						//steps 정보 추출
						NodeList stepsNodeList = beanElement.getChildNodes();
						
						for(int j = 0; j < stepsNodeList.getLength(); j++){
							Node stepsNode = stepsNodeList.item(j);
							
							if(stepsNode.getNodeType() == Node.ELEMENT_NODE){
								Element stepsElement = (Element) stepsNode;
								String propertyNameValue = stepsElement.getAttribute(PROPERTY_NAME_ATTRIBUTE);
								
								// property name이 steps이면 자식 노드를 가지고 와서 체크한다.
								if(propertyNameValue.equals(PROPERTY_STEP_VALUE)){
									NodeList stepListenersList = stepsElement.getChildNodes();
									
									for(int k=0; k < stepListenersList.getLength(); k++){
										Node stepListenerNode = stepListenersList.item(k);
										
										if(stepListenerNode.getNodeType() == Node.ELEMENT_NODE){
											Element listenerElement = (Element) stepListenerNode;
											String utilListId = listenerElement.getAttribute(BEAN_ID_VALUE);
											
											// util:list id가 stepListeners이면 다시 자식 노드 가지고 온다.
											if(utilListId.equals(UTIL_STEPLISTENERS_VALUE)){
												NodeList stepNodeList = listenerElement.getChildNodes();
												
												for(int l = 0; l < stepNodeList.getLength(); l++){
													Node stepNode = stepNodeList.item(l);
													
													if(stepNode.getNodeType() == Node.ELEMENT_NODE){
														Element stepBeanElement = (Element) stepNode;
														
														// Step 정보 저장, Id와 TYPE
														stepInfo = new StepInfo();
														stepInfo.setStepId(stepBeanElement.getAttribute(BEAN_ID_VALUE));
														stepInfo.setStepType(stepBeanElement.getAttribute(BEAN_PARENT_ATTRIBUTE));
														
														if(logger.isInfoEnabled()){
															logger.info("\t\t[ Step ID :" + stepInfo.getStepId()+" , STEP TYPE : "+stepInfo.getStepType()+" ] ");
														}
														
														// step의 property정보를 가져오기위해 자식노드 가지고 온다.
														NodeList propertyList = stepBeanElement.getChildNodes();
														
														stepPropertyInfo = new HashMap<String, String>();
														for(int m = 0; m < propertyList.getLength(); m++){
															Node propertyNode = propertyList.item(m);
															
															if(propertyNode.getNodeType() == Node.ELEMENT_NODE){
																Element propertyElement= (Element) propertyNode;
																
																// step의 property 정보를 저장한다.
																String propertyName = propertyElement.getAttribute(PROPERTY_NAME_ATTRIBUTE);
																// value 혹은 ref 값을 저장
																stepPropertyInfo.put(propertyName, (propertyElement.getAttribute(PROPERTY_VALUE) != null && !propertyElement.getAttribute(PROPERTY_VALUE).equals(""))? propertyElement.getAttribute(PROPERTY_VALUE) : propertyElement.getAttribute(PROPERTY_REF));
																
																/*
																 * Multi Writer 정보저장
																 * 
																 * 
																 */
																if("writers".equals(propertyName)) {
																	
																	if(logger.isDebugEnabled()){
																		logger.debug("MultiWriter의 property정보를 추출합니다. ");
																	}
																	
																	NodeList writers = propertyElement.getChildNodes();
																	
																	if( writers !=null && writers.getLength() > 0 ) {
																		Node list = writers.item(0);
																		if(list.getNodeType() == Node.ELEMENT_NODE) {
																			NodeList writerList = ((Element)list).getChildNodes();
																			
																			Writer writerInfo = null;
																			List<Writer> stepWriters = new ArrayList<Writer>();
																			for(int n = 0; n < writerList.getLength(); n++) {
																				// 각 Writer 노드
																				if(writerList.item(n).getNodeType() == Node.ELEMENT_NODE){
																					Element writer = (Element) writerList.item(n);
																					writerInfo = new Writer();
																					
																					writerInfo.setClassName( writer.getAttribute("class") );
																					// Writer 의 Property Element 추출
																					NodeList writerPropertyList = writer.getChildNodes();
																					
																					writerPropertyInfo = new HashMap<String, String>();
																					
																					for(int o = 0; o < writerPropertyList.getLength(); o++) {
																						if( writerPropertyList.item(o).getNodeType() == Node.ELEMENT_NODE ) {
																							Element writerProperty = (Element)writerPropertyList.item(o);
																							
																							// Writer Property 정보추출
																							writerPropertyInfo.put(writerProperty.getAttribute(PROPERTY_NAME_ATTRIBUTE), 
																													writerProperty.getAttribute(PROPERTY_VALUE) != null ? writerProperty.getAttribute(PROPERTY_VALUE) : writerProperty.getAttribute(PROPERTY_REF));
																						}
																					}
																					
																					if(logger.isDebugEnabled()){
																						logger.debug("MultiWriter의 property정보를 저장합니다. [" + writerPropertyInfo + "]");
																					}
																					
																					// Writer DTO 에 프로퍼티 정보저장
																					writerInfo.setWriterProperties(writerPropertyInfo);
																					stepWriters.add(writerInfo);
																				}
																			}
																			
																			if(logger.isDebugEnabled()){
																				logger.debug("MultiWriter의 property정보를 Step정보에 저장합니다. [ " +stepWriters + "]");
																			}
																			
																			// 추출한 Writer 정보를 Step 정보에 담는다.
																			stepInfo.setWriters(stepWriters);
																		}
																	} 
																} // end of Multi Writer 정보저장
																
																/*
																 * SqlExecuteStep의 SQL쿼리 저장 
																 */
																if("inSql".equals(propertyName)) {
																	stepInfo.setSql(propertyElement.getTextContent());
																}
																
																if(logger.isInfoEnabled()){
																	logger.info("\t\t[ PROPERTY NAME : " + propertyName+" , PROPERTY VALUE : "+ stepPropertyInfo.get(propertyName) +" ] ");
																}
															} else {
																if(logger.isDebugEnabled()){
																	logger.debug("NODE TYPE이 아닙니다..");
																}
															}
														
														} // end for( m )
														
														//step property저장 
														stepInfo.setProperties(stepPropertyInfo);
														if(logger.isInfoEnabled()){
															logger.info("\t\t[STEP PROPERTY] : " + stepInfo.getProperties());
														}
														
													} else { 
														if(logger.isDebugEnabled()) {
															logger.debug("NODE TYPE이 아닙니다..");
														} 
													}// end else 
													
													//steps 정보를 job에 저장한다.
													if(!stepList.contains(stepInfo) && stepInfo != null){
														stepList.add(stepInfo);
													}
													if(logger.isDebugEnabled()){
														logger.info(" STEP 정보를 저장합니다.");
													}
												}// end for( l )
											} else {
												if(logger.isDebugEnabled()){
													logger.debug("자식 노드가 올바르지 않습니다.");
												}
											}// end else
											
										} else {
											if(logger.isDebugEnabled()) {
												logger.debug("NODE TYPE이 아닙니다..");
											} 
										}
									}
								} else {
									if(logger.isDebugEnabled()) {
										logger.debug("자식 노드가 올바르지 않습니다..");
									} 
								}
							} else {
								if(logger.isDebugEnabled()) {
									logger.debug("NODE TYPE이 아닙니다..");
								} 
							}
							// 각 step들을 jobInfo에 저장한다.
							jobInfo.setStepList(stepList);
							if(logger.isDebugEnabled()){
								logger.debug("\t\tJOB 정보를 저장합니다.");
							}
						}
					} else {
						if(logger.isDebugEnabled()) {
							logger.debug("Batch관련 XML이 아닙니다.");
						} 
					}
					
					/**
					 * bean의 정보들을 저장한다...
					 */
					if(beanNodeName.equals("bean")){
						beanInfo = new JobBeanInfo();
						propertyInfo = new HashMap<String, String>();
						
						String beanId = beanElement.getAttribute(BEAN_ID_VALUE);
						String classPath = beanElement.getAttribute("class");
						
						// Bean정보 저장
						beanInfo.setBeanId(beanId);
						beanInfo.setBeanClass(classPath);
						
						Pattern propertyDaoRefPattern = Pattern.compile("(p:)(\\w+)(-ref\\=(\")(.*)(\"))");
						
//						System.out.println("beanElement.getAttribute : " + beanElement.getAttributes().toString());

						NamedNodeMap attributeMap = beanElement.getAttributes();
						
						/*
						 * 프로퍼티 설정을 Custom 태그를 사용 하였을 경우 attribute의 길이가 2보다 크다.
						 */
						if(attributeMap.getLength() > 2 ){
							for(int a = 0; a < attributeMap.getLength(); a++){
								
								Matcher matcher = propertyDaoRefPattern.matcher(attributeMap.item(a).toString());
								
								String propertyName = null;
								String propertyRef = null;
								
								if(matcher.matches()){
									propertyName = matcher.group(2).trim();
									propertyRef = matcher.group(5).trim();

									propertyInfo.put(propertyName, propertyRef);
								} else {
									if(logger.isDebugEnabled()){
										logger.debug("Custom 태그 패턴이 일치하지 않습니다." + attributeMap.item(a).toString());
									}
								}
							} // end attributeMap
							
						} else {
							if(logger.isDebugEnabled()){
								logger.debug("Custom 태그를 이용하지 않았습니다.");
							}
						}

						//property 정보 추출
						NodeList propertyNodeList = beanElement.getChildNodes();
						
						for(int p = 0; p < propertyNodeList.getLength(); p++){
							Node propertyNode = propertyNodeList.item(p);
							
							if(propertyNode.getNodeType() == Node.ELEMENT_NODE){
								Element propertyElement = (Element) propertyNode;
						
								String propertyName = propertyElement.getAttribute(PROPERTY_NAME_ATTRIBUTE);
								String ref = propertyElement.getAttribute(PROPERTY_REF);
								
								if(logger.isInfoEnabled()){
									logger.info("\t\t[PROPERTY NAME : " + propertyName + ", propertyRef : " + ref + "]");
								}
								
								propertyInfo.put(propertyName, ref);
							} else {
								if(logger.isDebugEnabled()) {
									logger.debug("NODE TYPE이 아닙니다..");
								} 
							}
							
						} // end for(p)
						
						beanInfo.setPropertyInfo(propertyInfo);
						beanList.add(beanInfo);
						
					} else {
						if(logger.isDebugEnabled()) {
							logger.debug("NODE NAME이 bean이 아닙니다");
						} 
					}
					
				} else {
					if(logger.isDebugEnabled()) {
						logger.debug("NODE TYPE이 아닙니다..");
					} 
				}
			}// end for(i)
		}else {
			if(logger.isDebugEnabled()){
				logger.debug(" 올바른 ROOTElement가 아닙니다.");
			}
		}
		
		if(jobInfo != null){
			jobInfo.setBeanList(beanList);
		} else { /* DO NOTHING */ }
		
		return jobInfo;
	}

}
