package sfmi.component.mdm.common.util;

import japa.parser.ParseException;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.JobBeanInfo;
import sfmi.component.mdm.dto.MethodInfo;
import sfmi.component.mdm.dto.ProcessorDaoInfo;
import sfmi.component.mdm.dto.ProcessorInfo;

/**
 * 프로세서 정보 추출 테스트 작성 
 * @author hwbae
 * @since 2014.05.20
 *
 */
public class ExtractProcessorTest { 
	// XML에서 추출한 bean정보
	public static List<JobBeanInfo> beanList = new ArrayList<JobBeanInfo>();
	
	// processor정보 
//	public static List<Map<String, String>> processorInfoList = new ArrayList<Map<String,String>>();
	
	public static List<ClassInfo> classInfoList = new ArrayList<ClassInfo>();
	public static ProcessorInfo processorInfo = new ProcessorInfo();
	/*
	 * 추출된 propertyInfo
	 */
	public static Map<String, List<ProcessorDaoInfo>> processorMethodAndDaoInfo = new HashMap<String, List<ProcessorDaoInfo>>();
	
	// 추출한 XML와 sqlID 정보
	Map<String, String> xmlPathSqlIdMap = null;
	
	/**
	 * JOB info 추출 
	 * @throws Exception 
	 */
	@BeforeClass
	public static void setUp() throws Exception{
		
		/*
		 * processor의 클래스와 DAO의 클래스는 미리 선언.....
		 */
		
		String file1 = "D:\\SFMI_WORK\\indigo_workspace\\CL\\XDCCBatch\\XdClaimCarPerSecondBatch\\src\\sfmi\\xdbatch\\claim\\carpersecond\\processor\\ClaimEndSendResultProcessor.java";
		String file2 = "D:\\SFMI_WORK\\indigo_workspace\\CL\\XDCCBatch\\XdClaimCarDailyBatch\\src\\sfmi\\xdbatch\\claim\\cardaily\\processor\\dao\\JdbcClaimCarDailyDao.java";
		String file3 = "D:\\SFMI_WORK\\indigo_workspace\\CL\\XDCCBatch\\XdClaimCarDailyBatch\\src\\sfmi\\xdbatch\\claim\\cardaily\\processor\\dao\\JdbcCoopFctrInsDao.java";
		String file4 = "D:\\SFMI_WORK\\indigo_workspace\\CL\\XDCCBatch\\XdClaimCarPerSecondBatch\\src\\sfmi\\xdbatch\\claim\\carpersecond\\processor\\dao\\JdbcCarPeriodicalDao.java";
		
		
		
		ClassInfo classInfo = new ClassInfo();
		
		classInfo = JavaSourceParser.parse(new File(file1));
		classInfoList.add(classInfo);
		
		classInfo = new ClassInfo();
		classInfo = JavaSourceParser.parse(new File(file2));
		classInfoList.add(classInfo);
		
		classInfo = new ClassInfo();
		classInfo = JavaSourceParser.parse(new File(file3));
		classInfoList.add(classInfo);
		
		classInfo = new ClassInfo();
		classInfo = JavaSourceParser.parse(new File(file4));
		classInfoList.add(classInfo);
		
//		String testFile = "D:\\SFMI_WORK\\indigo_workspace\\PO\\XDGeneralBatch\\XdGeneralDailyExternalBatch\\conf\\jobs\\RREXDC.C006.xml";
//		String testFile = "D:\\SFMI_WORK\\indigo_workspace\\CL\\XDCCBatch\\XdClaimCarDailyBatch\\conf\\jobs\\CCDADC.DAX1306.xml";
		String testFile = "D:\\SFMI_WORK\\indigo_workspace\\SQLParser\\src\\test\\resources\\testPJT\\jobs\\batchJobProcessorTest.xml";
//		String testFile = "D:\\SFMI_WORK\\indigo_workspace\\SQLParser\\src\\test\\resources\\testPJT\\jobs\\PUCRMC.CRX002.xml";
		
		
		
		File xmlFile = new File(testFile);
		Document doc = XmlParser.getDocument(xmlFile);

		JobBeanInfo beanInfo;
		Map<String, String> propertyInfo;
		
		Element rootElement = doc.getDocumentElement();
		String rootElementName = rootElement.getNodeName();
		NodeList beanNodeList = rootElement.getChildNodes();
		
		if(rootElementName.equals("beans")){
			for(int i = 0; i<beanNodeList.getLength(); i++){
				Node beanNode = beanNodeList.item(i);
				if(beanNode.getNodeType() == Node.ELEMENT_NODE){
					Element beanElement = (Element)beanNode;
					
					beanInfo = new JobBeanInfo();
					propertyInfo = new HashMap<String, String>();
					String beanId = beanElement.getAttribute("id");
					String classPath = beanElement.getAttribute("class");
					
					// Bean정보 저장
					beanInfo.setBeanId(beanId);
					beanInfo.setBeanClass(classPath);
					
					Pattern propertyDaoRefPattern = Pattern.compile("(p:)(\\w+)(-ref\\=(\")(.*)(\"))");
					
//					System.out.println("beanElement.getAttribute : " + beanElement.getAttributes().toString());

					NamedNodeMap attributeMap = beanElement.getAttributes();
					
					if(attributeMap.getLength() > 2 ){
						for(int a = 0; a < attributeMap.getLength(); a++){
							
							Matcher matcher = propertyDaoRefPattern.matcher(attributeMap.item(a).toString());
							
							String propertyName = null;
							String propertyRef = null;
							
							if(matcher.matches()){
								propertyName = matcher.group(2).trim();
								propertyRef = matcher.group(5).trim();
								propertyInfo.put(propertyName, propertyRef);
							}
							
						}
						
					} else {
						
					}
					
					//property 정보 추출
					NodeList propertyNodeList = beanElement.getChildNodes();
					
					for(int p = 0; p < propertyNodeList.getLength(); p++){
						Node propertyNode = propertyNodeList.item(p);
						
						if(propertyNode.getNodeType() == Node.ELEMENT_NODE){
							Element propertyElement = (Element) propertyNode;
					
							String propertyName = propertyElement.getAttribute("name");
							String ref = propertyElement.getAttribute("ref");
							
							propertyInfo.put(propertyName, ref);
						} else {
							// NODE TYPE이 아님
						}
						
					} // end for(p)
					
					beanInfo.setPropertyInfo(propertyInfo);
					beanList.add(beanInfo);
					
				}
			}
		}
		
//		Assert.assertTrue(beanList.size() == 4);
//		Assert.assertEquals("claimEndSendResultProcessor", beanList.get(1).getBeanId());
//		Assert.assertEquals("sfmi.xdbatch.claim.carpersecond.processor.ClaimEndSendResultProcessor", beanList.get(1).getBeanClass());
//		Assert.assertEquals("carPeriodicalDao", beanList.get(1).getPropertyInfo().get("carPeriodicalDao"));
//		
//		Assert.assertEquals("carPeriodicalDao", beanList.get(2).getBeanId());
//		Assert.assertEquals("sfmi.xdbatch.claim.carpersecond.processor.dao.JdbcCarPeriodicalDao", beanList.get(2).getBeanClass());
//		Assert.assertEquals("AGDBDs", beanList.get(2).getPropertyInfo().get("dataSource"));
	}
	
	/**
	 *  JOB 정보 이용하여 Processor가 DB와 관련있는지 판단
	 */
	@Test
	public void diagonisDbProcessor() {
		
		/*
		 * beanProperty
		 */
		Map<String, String> beanProperty;
		
		/*
		 *  Step 프로퍼티에 Processor가 존재한다고 가정한다.
		 */
		String processorRef = "claimEndSendResultProcessor";
		
//		Map<String, String> processorInfo = null;
		ProcessorDaoInfo processorDaoInfo = null;
		List<ProcessorDaoInfo> processorDaoInfoList = new ArrayList<ProcessorDaoInfo>();
		
		// processor가 존재한다면
		if(processorRef != null && !("").equals(processorRef)){
			/*
			 *  1. beanList를 추출하여 ID값을 비교한다.
			 *  2. ref를 추출하여 다시 beanId값과 비교한다.
			 *  3. DataSource가 존재하는지 찾는다. 
			 */
			
			for(JobBeanInfo jobBeanInfo : beanList){
				// beanId와 processor ref가 같다.
				if(jobBeanInfo.getBeanId().equals(processorRef)){
					beanProperty = jobBeanInfo.getPropertyInfo();
					
					if(beanProperty != null){
						for(Map.Entry<String, String> property : beanProperty.entrySet()){
							// property정보를 추출
							String propertyName = property.getKey();
							String propertyRef = property.getValue();
							
							// property ref와 beanID와 비교한다.
							for(JobBeanInfo beanInfo : beanList){
								if(beanInfo.getBeanId().equals(propertyRef)){
									beanProperty = beanInfo.getPropertyInfo();
									
									if(beanProperty != null){
										// dataSource name을 가지고 있다.
										if(beanProperty.containsKey("dataSource")){
											
											// 프로퍼티 저장 
											processorDaoInfo = new ProcessorDaoInfo();
											processorDaoInfo.setDaoClass(beanInfo.getBeanClass());
											processorDaoInfo.setDaoName(propertyName);
											// daoInfoList에 저장
											processorDaoInfoList.add(processorDaoInfo);
											
											processorInfo.setProcessorClass(jobBeanInfo.getBeanClass());
											processorInfo.setProcessorMethodAndDaoInfo(processorDaoInfoList);
											
											//processorInfo 저장
//											processorInfoList.add(processorInfo);
											
										} else {
											System.out.println("dataSource 없다.");
										}
									} else {
										System.out.println("beanProperty가 존재하지 않는다.");
									}
								} else {
									System.out.println("beanId가 일치 하지 않는다.");
								}
							} //end for(beanInfo)
						}// end for(Map)
					} else {
						System.out.println("beanProperty가 존재하지 않는다.");
					}
					
				} else {
					System.out.println("processorRef 와 beanId가 같지 않다.");
				}
			}// end for( jobBeanInfo)
		} else{
			System.out.println("Step 프로퍼티에 프로세서가 존재하지 않습니다.");
		}
		
		processorInfo.setProcessorMethodAndDaoInfo(processorDaoInfoList);
		System.out.println("processorInfo : " + processorInfo.getProcessorMethodAndDaoInfo());
//		Assert.assertTrue(processorInfoList.size() == 2);
		
	}
	
	/**
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void extractProcessInfo() throws IOException, ParseException{ 
		
		// java file qualifiedName
		String qualifiedName = null;
		String daoName = null;
		
		Matcher methodMatcher;
		
		List<Statement> statements = null;
		List<String> methodList = null;
		
		ProcessorDaoInfo processorDaoInfo = new ProcessorDaoInfo(); 
		ProcessorInfo newProcessorInfo = new ProcessorInfo();
		
		Map<String, ProcessorInfo> processorInfoMap = new HashMap<String, ProcessorInfo>();
		List<ProcessorDaoInfo> processorDaoInfoList;
		
		// Processor클래스는 찾아 processor내에 있는 메서드를 찾는다.
		for(ClassInfo classData : classInfoList){
			if(processorInfo.getProcessorClass().equals(classData.getQualifiedName())){
				/*
//				 * method process() 추출 
//				 */
				for(MethodInfo methodInfo : classData.getMethodInfos()){
					// processor의 dao정보 중 daoName을 추출하여 패턴 분석
					for(ProcessorDaoInfo daoInfo :  processorInfo.getProcessorMethodAndDaoInfo()){
						String useDaoName = daoInfo.getDaoName();
						BlockStmt blockStmt = methodInfo.getBlockStmt();
						methodList = new ArrayList<String>();
						
						if(blockStmt != null){
							// 메소드 내의 각 statement 추출 
							statements = blockStmt.getStmts();
							if(statements !=null && statements.size() > 0){
								for(Statement statement : statements){
						
									Pattern useDaoMethodPattern = Pattern.compile("(.*)?("+useDaoName+").([^\\(]\\w+)\\((.*)");
									
									String statementStr = statement.toString();
									// 개행 제거 
									statementStr = statementStr.replace("\n", "");
									statementStr = statementStr.replace("\r\n", "");
									methodMatcher = useDaoMethodPattern.matcher(statementStr);
									
									if(methodMatcher.matches()){
										String methodName = methodMatcher.group(3).trim();
										System.out.println(methodMatcher.group(3).trim());
										

										// methodName add
										if(!methodList.contains(methodName)){
											methodList.add(methodName);
										} else {
											// 이미 존재하는 method
										}
										
										newProcessorInfo = new ProcessorInfo();
										processorDaoInfo = new ProcessorDaoInfo();
										processorDaoInfoList = new ArrayList<ProcessorDaoInfo>();
										
										newProcessorInfo.setProcessorClass(processorInfo.getProcessorClass());
										newProcessorInfo.setProcessorMethodAndDaoInfo(processorDaoInfoList);
										
										processorDaoInfo.setProcessorMethod(methodInfo.getName());
										processorDaoInfo.setDaoClass(daoInfo.getDaoClass());
										processorDaoInfo.setDaoName(daoInfo.getDaoName());
										processorDaoInfo.setMethodList(methodList);
										
										processorDaoInfoList.add(processorDaoInfo);
										
										processorInfoMap.put(methodInfo.getName()+useDaoName, newProcessorInfo);
										
									} else {
										//System.out.println("NO MATCH ::");
									}
								} // end statement
							} else {
								// no Statement
							}
						} else {
							// blockStmt == null
						}
					
					} // end ProcessorDaoInfo
				
				}// end methodInfo
			} else {
				// processor관련 클래스가 아님
			}
		} //end classInfoList
	
		
//		System.out.println("Map : " + processorInfoMap);
		System.out.println("SIZE : " + processorInfoMap.size());
		
		for(Entry<String, ProcessorInfo> property : processorInfoMap.entrySet()){
			System.out.println("---------------------------------------");
			System.out.println("key : " + property.getKey());
//			System.out.println("size: " + property.getValue().size());
			System.out.println("DAO INFO : " + property.getValue().getProcessorMethodAndDaoInfo());
			System.out.println("PROCESSOR CLASS : " + property.getValue().getProcessorClass());
		}
		
//		System.out.println("SIZE : " + newProcessorInfoList.size());
	}
		
	/**
	 * daoClass에서 sql정보를 추출한다.
	 */
	@Test	
	public void extractSqlInfo(){ 

		/*
		 * Processor에서 method정보 추출 한 후 dao내에서 sql정보 추출한다.
		 */
		List<ProcessorDaoInfo> processorDaoInfoList = new ArrayList<ProcessorDaoInfo>();
		
		for(Map.Entry<String, List<ProcessorDaoInfo>> infoMap : processorMethodAndDaoInfo.entrySet()){
			processorDaoInfoList.addAll(infoMap.getValue());
		}
		
		System.out.println("DAO LIST : " + processorDaoInfoList);
		System.out.println("LIST SIZE : " + processorDaoInfoList.size());
				

//		processorMethodAndDaoInfo.values();
		
		Map<String, Object> resultMap = null;
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		
		for(ProcessorDaoInfo daoInfo : processorDaoInfoList){
			List<String> methodList = daoInfo.getMethodList();
			if(methodList != null){
				for(ClassInfo classInfo : classInfoList){
					if(classInfo.getQualifiedName().equals(daoInfo.getDaoClass())){
						/*
						 * methodName 비교 
						 */
						for(MethodInfo methodInfo : classInfo.getMethodInfos()){
							for(String methodName : methodList){
								if(methodInfo.getName().equals(methodName)){
									resultMap = new HashMap<String, Object>();
									resultMap = xmlPathAndSqlId(classInfo, methodInfo);
									resultMap.put("CLASSNAME", classInfo.getQualifiedName());
			
									resultList.add(resultMap);
								}
							}// end  methodName
						} // end methodInfo
					} else {
						// class명이 같지 않다.
					}
				}// end for classInfo
			}
		}// end for processorDaoInfo
		
		System.out.println("====================================================================");
		System.out.println("resultList : " + resultList);
		System.out.println("resultList.size() : " + resultList.size());
		
	}
	
	/**
	 * 
	 * ClassInfo 파라미터로 받아와 한 자바파일에 대하여 sql정보를 추출
	 * @param classInfo
	 * @param methodList
	 */
	public Map<String, Object> xmlPathAndSqlId(ClassInfo classInfo, MethodInfo methodInfo){
		List<String> xmlPathList = new ArrayList<String>();
		List<String> sqlIdList = new ArrayList<String>();
		/*
		 *  DAO 클래스명이 같다.
		 */
		List<Statement> statements = null;
		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+)(\\))(.*)");
		Matcher matcher;

		BlockStmt blockStmt = methodInfo.getBlockStmt();
		
		if(blockStmt != null){
			// 메소드 내의 각 statement 추출 
			statements = blockStmt.getStmts();
			if(statements !=null && statements.size() > 0){
				for(Statement statement : statements){
					// 패턴 체크 
					matcher = useSqlFinderApiPattern.matcher(statement.toString());
					if(matcher.matches()){
						matcher.reset();
						
						while(matcher.find()) {
							String xmlPath = matcher.group(3).trim();
							String sqlId = matcher.group(5).trim();
							
							// 따옴표 확인
							if(xmlPath.contains("\"")){
								// " 를 없애고 xmlList에 추가한다.
								xmlPath = xmlPath.replace("\"", "");
								
								if(!xmlPathList.contains(xmlPath)){
									xmlPathList.add(xmlPath);
									
								} else {
									// 이미 존재하는 xml
								}
								
							} else {
								//Class Field에서 먼저 찾는다..
								if(classInfo.getVariables().get(xmlPath) != null){
									xmlPath = classInfo.getVariables().get(xmlPath);
									xmlPath = xmlPath.replace("\"", "");
									
									if(!xmlPathList.contains(xmlPath)){
										xmlPathList.add(xmlPath);
									} else {
										// 이미 존재하는 xml
									}
									
								} else {
									//이미 존재하는 xml
									
									// 메소드 내에서 찾는다
//									xmlPathList = ExtractBatchSqlInfoService.returnBindingValue(blockStmt, xmlPath);
									
									// METHOD Field 에서 찾는다.
									if(xmlPathList.size() < 0){
										// method내에서 xml을 선언하지 않음
									} 							
								}// end else
								
							}
							
							if(sqlId.contains("\"")){
								// " 를 없애고 sqlIdList 에 추가한다.
								sqlId = sqlId.replace("\"", "");
								sqlIdList.add(sqlId);
							} else {
//								sqlIdList = ExtractBatchSqlInfoService.returnBindingValue(blockStmt, sqlId);
								
								if(sqlIdList.size() < 0){
									// class Field내에서 선언되어있을 경우..?
								} else { 
									// sqlId 추출함
								}
							}
						} //end while()

						
						
					} else {
						// SqlFinder 매칭 되지 않음
					}
				}
			}else {
				// statments가 null
			}
		} else {
			// blockStmt가 null
		}

		Map<String, Object> xmlPathAndSqlId = new HashMap<String, Object>();
		xmlPathAndSqlId.put("XML", xmlPathList);
		xmlPathAndSqlId.put("SQLID", sqlIdList);
		xmlPathAndSqlId.put("METHOD_NAME", methodInfo.getName());
		return xmlPathAndSqlId;
	
	}
		
//		// processor의 daoinfo추출
//		List<ProcessorDaoInfo> processorDaoInfoList = processorInfo.getProcessorDaoList();
//		
//		if(processorDaoInfoList != null && processorDaoInfoList.size() > 0){
//			for(ProcessorDaoInfo processorDaoInfo : processorDaoInfoList){
//				for(ClassInfo classData : classInfoList){
//					// class명이 같으면 methodInfo를 추출한다.
//					if(processorDaoInfo.getDaoClass().equals(classData.getQualifiedName())){
//						/*
////						 * method process() 추출 
////						 */
//						for(MethodInfo methodInfo : classData.getMethodInfos()){
//							if(("process").equals(methodInfo.getName())){
//								System.out.println("process method : " + methodInfo.getName());
//							}
//						}
//						
//						
//					}
//				}// end classInfoList
//			}// end processorDaoInfoList
//		} else {
//			// processorDAO 정보가 존재하지 않는다.
//		}
		
		
		
		/*
		 *  processorList정보를 하나씩 꺼낸다.
		 *   1. processorClass에서 process() method내에서 daoName.XXX 메서드 저장
		 *   2. DAO 파일 -> XXX메서드 내에서 SqlFinder.getSql 찾아서 xml Path와 sql아이디 추출 
		 */
//		for(Map<String, String> processorMap : processorInfoList){
//			for(ClassInfo classData : classInfoList){
//				// processor Class명, daoName
//				qualifiedName = processorMap.get("processorClass");
//				daoName = processorMap.get("daoName");
//				if(classData.getQualifiedName().equals(qualifiedName)){
//					/*
//					 * method process() 추출 
//					 */
//					for(MethodInfo methodInfo : classData.getMethodInfos()){
//						if(("process").equals(methodInfo.getName())){
//							System.out.println("process method");
//							
//							BlockStmt blockStmt = methodInfo.getBlockStmt();
//							if(blockStmt != null){
//								// 메소드 내의 각 statement 추출 
//								statements = blockStmt.getStmts();
//								if(statements !=null && statements.size() > 0){
//									for(Statement statement : statements){
//										/*
//										 * dao.XXXX() 메서드를 찾기 위한 패턴
//										 */
//										
//										Pattern useDaoMethodPattern = Pattern.compile("(.*)?("+daoName+").([^\\(]\\w+)\\((.*)");
//										
//										String statementStr = statement.toString();
//										// 개행 제거 
//										statementStr = statementStr.replace("\n", "");
//										statementStr = statementStr.replace("\r\n", "");
//										methodMatcher = useDaoMethodPattern.matcher(statementStr);
//										
//										if(methodMatcher.matches()){
//											System.out.println(methodMatcher.group(3).trim());
//											// methodName add
//											methodList.add(methodMatcher.group(3).trim());
//										} else {
//											System.out.println("NO MATCH ::");
//										}
//									
//									}
//								}else {
//									// statments가 null;
//								}
//							}else {
//								// method 내용이 null
//							}
//						} else {
//							// process() 메서드가 아닙니다.
//						}
//					} //end for(methodInfo)
//				} else {
//					// className이 다르다
//				}
//			} //end classInfoList
//		}// end processorInfoList
		

}
