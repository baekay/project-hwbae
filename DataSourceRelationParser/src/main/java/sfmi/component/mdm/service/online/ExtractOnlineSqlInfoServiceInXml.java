package sfmi.component.mdm.service.online;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import parser.sql.SQLAnalyzerLexer;
import parser.sql.SQLAnalyzerParser;
import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.AnalyzerStringUtil;
import sfmi.component.mdm.common.util.FileCollector;
import sfmi.component.mdm.common.util.XmlParser;
import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.context.SqlMapResourceContextHolder;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.dto.SqlAnalyzeData;
import sfmi.component.mdm.dto.TableInfo;
import sfmi.component.mdm.handler.ExceptionHandler;
import sfmi.component.mdm.listener.BatchJobListener;
import sfmi.component.mdm.service.ExtractSqlInfoService;

/**
 * XML 파일 파싱하여 sql 정보 추출하는 서비스
 * 
 * @author hwbae
 * 
 */
public class ExtractOnlineSqlInfoServiceInXml implements ExtractSqlInfoService {
	private static final String SQL_MAP_ROOT_ELEMENT = "sqlMap";
	private static final String SQL_MAP_CONFIG_ROOT_ELEMENT = "sqlMapConfig";
	private static final String SQL_MAP_ATTRIBUTE_RESOURCE = "resource";

	private static Logger logger = Logger
			.getLogger(ExtractOnlineSqlInfoServiceInXml.class);

	
	public List<AnalyzeData> extract(String targetSystemDir) {
		//time Listener
		BatchJobListener.timeListener(SQLAnalyzerConstants.START_TIME);
		
		// JobContext 초기화 
		BatchJobContext batchJobContext = BatchJobContext.getJobContext();
		batchJobContext.initJobContext();
		batchJobContext.setContextValue(SQLAnalyzerConstants.PRG_TYPE, SQLAnalyzerConstants.PRG_TYPE_ONLINE);
		
		// 결과 저장 객체
		List<AnalyzeData> sqlAnalyzeDataList = new ArrayList<AnalyzeData>();

//		File targetDir = new File(PropertyContext.getTargetDir());
		File targetDir = new File(targetSystemDir);

		// 파일수집
		if (logger.isInfoEnabled()) {
			logger.info("XML 파일 확장자 검사 후 수집합니다..");
		}

		// FileCollector를 사용하여 확장자가 XML인 파일을 수집한다.
		FileCollector fileCollector = new FileCollector(
				SQLAnalyzerConstants.XML_FILE_COLLECT_MODE);
		fileCollector.collectFiles(targetDir);

		// 확장자 체크 완료 파일
		List<File> fileList = fileCollector.getFileList();

		if (logger.isInfoEnabled()) {
			logger.info("XML 파일 수집 완료합니다..");
		}

		if (logger.isInfoEnabled()) {
			logger.info("XML file Name을 파싱하여 SQL 정보를 수집합니다..");
		}
		// XML fileName을 파싱하여 SQL 정보를 수집한다

		for (File file : fileList) {
				try {
					sqlAnalyzeDataList.addAll(analyzXmlFile(file.getAbsolutePath()));
				} catch (SAXException e) {
					ExceptionHandler.handle(e, null, null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null, null);
				} catch (ParserConfigurationException e) {
					ExceptionHandler.handle(e, null, null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null, null);
				} catch (IOException e) {
					ExceptionHandler.handle(e, null, null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null, XmlParser.class);
				} 
		}

		if (logger.isInfoEnabled()) {
			logger.info("SQL 정보 수집을 완료 합니다..");
		}
		return sqlAnalyzeDataList;
	}

	/**
	 * XML이 SQL파일인지 분석한다.
	 * 
	 * @param xmlFile
	 * @return
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * @throws RecognitionException 
	 */
	private List<AnalyzeData> analyzXmlFile(String filePath) throws SAXException, ParserConfigurationException, IOException {
		List<AnalyzeData> sqlAnalyzeDataList = new ArrayList<AnalyzeData>();
		File targetFile = new File(filePath);
		if (logger.isInfoEnabled()) {
			logger.info("XML 정보를 분석합니다." + targetFile);
		}

		// 파일의 존재 여부 체크
		if (targetFile.exists()) {
			Document doc = XmlParser.getDocument(targetFile);

			Element root = doc.getDocumentElement();
			String rootElementName = root.getNodeName();

			// rootelement가 sqlMap이면 Sql파싱
			if (rootElementName.equalsIgnoreCase(SQL_MAP_ROOT_ELEMENT)) {
				if (logger.isInfoEnabled()) {
					logger.info("[Start] -------------------------------------------------------------------------------------------------------------------");
					logger.info("\t대상XML 파일을 분석합니다 : " + targetFile.getName());
				}
				
				// 대상 XML 파일 개수 증가 
				BatchJobListener.countListener(SQLAnalyzerConstants.XML_FILE_CNT);
				
				// VOB명 포함한 경로로 변경
				filePath = AnalyzerStringUtil.setFileRootDir(filePath);
				sqlAnalyzeDataList = parseSqlResource(doc, filePath);

				if (logger.isInfoEnabled()) {
					logger.info("[End] -------------------------------------------------------------------------------------------------------------------");
				}
			} else if (rootElementName.equalsIgnoreCase(SQL_MAP_CONFIG_ROOT_ELEMENT)) {
				// sqlMap resource 파일목록 추출
				parseSqlMapResource(doc);
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("대상 XML이 아닙니다 : " + filePath);
				} // end if
			}// end else
		} // end if

		return sqlAnalyzeDataList;
	}

	/**
	 * SQL 정의된 파일 추출
	 * 
	 * @param doc
	 */
	private void parseSqlMapResource(Document doc) {
		NodeList nodeList = doc.getElementsByTagName("sqlMap");

		for (int i = 0; i < nodeList.getLength(); i++) {
			NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
			// Context 에 Resource 정보를 담는다.
			SqlMapResourceContextHolder.setSqlMapResource(nodeMap.getNamedItem(
					SQL_MAP_ATTRIBUTE_RESOURCE).getNodeValue());
		}
	}

	/**
	 * SQL ID, SQL 파싱 SQL 분석기 실행 Dynamic 쿼리일 경우 분석하지 않는다.
	 * 
	 * @param doc
	 * @return
	 * @throws RecognitionException 
	 */
	private List<AnalyzeData> parseSqlResource(Document doc, String filePath) {
		String ELEMENT_SQL_STATEMENT = "statement";
		String ELEMENT_SQL_UPDATE = "update";
		String ELEMENT_SQL_DELETE = "delete";
		String ELEMENT_SQL_INSERT = "insert";
		String ELEMENT_SQL_SELECT = "select";
		String ATTRIBUTE_ID = "id";

		// SQL 정보 저장을 위한 객체
		SqlAnalyzeData sqlData = null;
		TableInfo tableInfo = null;
		List<TableInfo> tableInfoList = null;
		
		List<AnalyzeData> sqlDataList = new ArrayList<AnalyzeData>();

		// sqlMap의 자식 노드
		NodeList nodeList = doc.getElementsByTagName(SQL_MAP_ROOT_ELEMENT);
		NodeList sqlNodeList = nodeList.item(0).getChildNodes();
		int sqlNodeListLength = sqlNodeList.getLength();

		for (int i = 0; i < sqlNodeListLength; i++) {
				Node node = sqlNodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
		
						try {
							// SQL 관련 ELEMENT 만 체크
							if ((element.getNodeName()).equalsIgnoreCase(ELEMENT_SQL_STATEMENT)
									|| (element.getNodeName()).equalsIgnoreCase(ELEMENT_SQL_INSERT)
									|| (element.getNodeName()).equalsIgnoreCase(ELEMENT_SQL_UPDATE)
									|| (element.getNodeName()).equalsIgnoreCase(ELEMENT_SQL_SELECT)
									|| (element.getNodeName()).equalsIgnoreCase(ELEMENT_SQL_DELETE)) {
			
								// XML에 선언된 sqlId 증가 
								BatchJobListener.countListener(SQLAnalyzerConstants.XML_SQL_ID_CNT);
								
								boolean isDynamicSql = false;
			
								if (element.hasChildNodes()) {
									NodeList checkNodeList = node.getChildNodes();
									int checkNodeListLength = checkNodeList.getLength();
			
									for (int j = 0; j < checkNodeListLength; j++) {
										Node checkNode = checkNodeList.item(j);
			
										if (checkNode.getNodeType() == Node.ELEMENT_NODE) {
											isDynamicSql = true;
										} else { /* Do NOTHING */
										}
									}// end for
								}// end if
			
								// 동적 쿼리
								if (isDynamicSql) {
									
									// 동적 쿼리 건수 증가 
									BatchJobListener.countListener(SQLAnalyzerConstants.DYNAMIC_SQL_ID_CNT);
									
									if (logger.isDebugEnabled()) {
										logger.debug("\t동적 쿼리 입니다. SQL ID : "
												+ element.getAttribute(ATTRIBUTE_ID));
									}
									
									/*
									 * 동적 쿼리 추출
									 */
									setElementContext(element);
//									continue;
									
								}
			
								if (logger.isInfoEnabled()) {
									logger.info("\tSQL분석을 실행합니다. SQL ID : "
											+ element.getAttribute(ATTRIBUTE_ID));
								}
								// 동적 쿼리가 아닌 경우 분석기 실행
								String query = element.getTextContent();
								//  한글을 지운다.
								query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
//								query = query.replaceAll("(\\#|\\$){1}(\\S+)(\\#|\\$){1}","\'\'");
//								query = query.replaceAll("'([^'\\s]+)'", "\'\'");
								
								/**
								 *  TODO :: SQL 저장만 하고 JAVA파일과 매칭이 된 경우에만 SQL을 파싱한다.
								 *  		현재는 쿼리 분석기 성능 향상을 위해 모든 SQL을 파싱한다.
								 */
								// SQL 분석기 실행을 위한 객체 생성
								SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(new ANTLRStringStream(query));
								CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
								SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);

								// 분석기 실행
								sqlParser.statement();
								
								// query 분석 성공 증가 
								BatchJobListener.countListener(SQLAnalyzerConstants.SQL_ANALYZE_SUCESS_CNT);
			
								// 분석후 정보 저장
								sqlData = new SqlAnalyzeData();
								tableInfoList = new ArrayList<TableInfo>(); 
								
								List<String> selectTableList = sqlParser.getSelectTableList();
								List<String> tableList = sqlParser.getTableList();
								/*
								 * tableInfo에 저장 후 리스트에 추가
								 */
								if(tableList.size() > 0){
									String tableName = tableList.get(0);
									/*
									 * selectTable명이 같은게 존재하면 제거 
									 */
									if( selectTableList.contains(tableName) ){
										selectTableList.remove(tableName);
									}
									
									tableInfo = new TableInfo();
									tableInfo.setTableName(tableName);
									tableInfo.setColumnList(sqlParser.getColumnList());
									tableInfoList.add(tableInfo);
									
									if (selectTableList.size() > 0 ){
										for(String selectTableName : selectTableList){
											tableInfo = new TableInfo();
											tableInfo.setTableName(selectTableName);
											tableInfoList.add(tableInfo);
										}// end for
									} else {
										if(logger.isDebugEnabled()){
											logger.debug("SELECT TABLE이 존재하지 않습니다.");
										}
									}
										
								} else if(selectTableList.size() > 0) {
									for(String selectTableName : selectTableList){
										tableInfo = new TableInfo();
										tableInfo.setTableName(selectTableName);
										tableInfoList.add(tableInfo);
									}
								}
								sqlData.setDynamic(isDynamicSql);
								sqlData.setSqlID(element.getAttribute(ATTRIBUTE_ID));
								sqlData.setSqlType(sqlParser.getStatementType());
								sqlData.setSql(element.getTextContent());
								sqlData.setXmlFile(filePath.replace("\\", "/"));
								sqlData.setTableInfoList(tableInfoList);
								
								/*
								 * 각 sqlType 개수 증가
								 */
								String sqlType = sqlParser.getStatementType();
								if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_SELECT)){
									BatchJobListener.countListener(SQLAnalyzerConstants.SELECT_SQL_CNT);
								} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_UPDATE)){
									BatchJobListener.countListener(SQLAnalyzerConstants.UPDATE_SQL_CNT);
								} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_DELETE)){
									BatchJobListener.countListener(SQLAnalyzerConstants.DELETE_SQL_CNT);
								} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_INSERT)){
									BatchJobListener.countListener(SQLAnalyzerConstants.INSERT_SQL_CNT);
								} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_MERGE)){
									BatchJobListener.countListener(SQLAnalyzerConstants.MERGE_SQL_CNT);
								}
		
								if (logger.isDebugEnabled()) {
									logger.debug("\tSQL분석 정보를 저장합니다.. ");
								}
								sqlDataList.add(sqlData);

							} // end if
						} catch (RecognitionException e) {
							/*
							 * TODO :: SQL 분석 실패해도 SQL ID매칭하고 실패 REPORT한다.
							 * 			실패 FLAG를 두도록 한다.
							 */
							ExceptionHandler.handle(e, null, null, filePath, element.getAttribute(ATTRIBUTE_ID), element.getTextContent(), null);
						}
					} // end if(node)
			} // end for
		return sqlDataList;
	}
	
	/**
	 * dynamic 쿼리의 노드를 받아
	 * prepend를 추출 하여 setContext를 한다.
	 * @param checkNode
	 * @return
	 */
	private void setElementContext(Element element){
		StringBuilder query = new StringBuilder();
		/*
		 * prepend속성 추출
		 */
		if (element.hasChildNodes()) {
			NodeList checkNodeList = element.getChildNodes();
			int checkNodeListLength = checkNodeList.getLength();
				
			Map<String, String> ElementInfoMap = new HashMap<String, String>();
			
			for (int j = checkNodeListLength-1; j >= 0; j--) {
				Node childNode = checkNodeList.item(j);
				
				if (childNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element childElement = (Element)childNode;
					
					/*
					 * Element명과 property명을 비교하여 중복된 Element가 있으면
					 * 노드를 삭제한다.
					 */
					if(ElementInfoMap.containsKey(childNode.getNodeName())){
						String propertyValue = ElementInfoMap.get(childNode.getNodeName());
						
						if(propertyValue.equals(childElement.getAttribute("property"))){
							/*
							 * 삭제할 노드의 부모노드에서 childeNode를 삭제한다.
							 */
							
							/*
							 * nodeName이 iterate면 삭제하지 않는다.
							 */
							if(childNode.getNodeName().equals("iterate")) {
								setElementContext(childElement);
							} else {
								childNode.getParentNode().removeChild(childNode);
							}
							
						} else {
							ElementInfoMap.put(childNode.getNodeName(), childElement.getAttribute("property"));
							setElementContext(childElement);
						}
					} else {
						String nodeName = "";
						if(childNode.getNodeName().equals("isNotEqual")){
							nodeName = "isEqual";
						} else {
							nodeName = childNode.getNodeName();
						}
						
						ElementInfoMap.put(nodeName, childElement.getAttribute("property"));
						setElementContext(childElement);


					}
					
				} else if(childNode.getNodeType() == Node.TEXT_NODE) {
					if(element.getTextContent() != null && !("").equals(element.getTextContent())){
						
						/*
						 * NodeName이 iterate면 
						 * open, close attribute의 value값을 앞뒤로 setting
						 */
						String openStr = "";
						String closeStr = "";
						
						if(element.getNodeName().equals("iterate")){
							openStr = element.getAttribute("open");
							closeStr = element.getAttribute("close");
						}
						
						String prepend = element.getAttribute("prepend");
						
						/*
						 * 최상위 Element인 경우 현재까지의 Text내용 지우고 새로 append
						 * getTextContent()는 모든 하위의 Text내용을 추출하기 때문 
						 */
						if(j != checkNodeListLength-1){
							query.delete(0, query.length());
							query.append(prepend + openStr + element.getTextContent() + closeStr);
						} else { 
							query.append(prepend + openStr + element.getTextContent() + closeStr);
						}


					} else {
						if(logger.isDebugEnabled()){
							logger.debug("TextNode 내용이 비어있습니다.");
						}
					}
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("NodeType이 TextNode, ElementNode가 아닙니다.");
					}
				}
			}// end for
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("자식 노드가 존재하지 않습니다.");
			}
		}
		element.setTextContent(query.toString());
	}

}
