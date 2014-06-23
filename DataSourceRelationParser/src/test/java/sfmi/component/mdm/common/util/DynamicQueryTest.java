package sfmi.component.mdm.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import parser.sql.SQLAnalyzerLexer;
import parser.sql.SQLAnalyzerParser;

/**
 * 다이나믹 쿼리 테스트 클래스 
 * @author hwbae
 *
 */
public class DynamicQueryTest {

	/**
	 * 각 Element에 getContext()
	 *  -> prepend값 추가하여 setContext() 
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * @throws RecognitionException 
	 */
	@Test
	public void testDynamicQuery() throws SAXException, ParserConfigurationException, IOException  {
		// dao.xml 테스트
		File xmlFile = new File("src/test/resources/dynamicQueryTest.xml");
		XmlParser parser = new XmlParser();
		
		Document doc = parser.getDocument(xmlFile);
		Element rootElement = doc.getDocumentElement();
		String rootElementName = rootElement.getNodeName();
		
		assertNotNull(doc);
		assertEquals(rootElementName,"sqlMap");
		
		
		// sqlMap의 자식 노드
		NodeList nodeList = doc.getElementsByTagName("sqlMap");
		NodeList sqlNodeList = nodeList.item(0).getChildNodes();
		int sqlNodeListLength = sqlNodeList.getLength();

		for (int i = 0; i < sqlNodeListLength; i++) {
			Node node = sqlNodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
		
					// SQL 관련 ELEMENT 만 체크
					if ((element.getNodeName()).equalsIgnoreCase("statement")
						|| (element.getNodeName()).equalsIgnoreCase("insert")
						|| (element.getNodeName()).equalsIgnoreCase("update")
						|| (element.getNodeName()).equalsIgnoreCase("select")
						|| (element.getNodeName()).equalsIgnoreCase("delete")) {

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

					String query = element.getTextContent();
					// 동적 쿼리
					if (isDynamicSql) {
						
						setElementContext(element, false);
						System.out.println("동적쿼리닷..");
//						System.out.println("query : " + element.getTextContent());
						
					} else {
						
//						System.out.println("QUERY : " + query);
					}
					query = element.getTextContent();
					CharStream charStream = new ANTLRStringStream(query);
					SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
					TokenStream tokenStream = new CommonTokenStream(sqlLexer);
					SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);

					// 파서 실행
					try {
						sqlParser.statement();
					} catch (RecognitionException e) {
						System.out.println("query : " + query);
						e.printStackTrace();
					}
				}// statment가 쿼리가 아님
			} else {
				//node가 아님
			}
		}
	}
	
	/**
	 * dynamic 쿼리의 노드를 받아
	 * prepend를 추출 하여 setContext를 한다.
	 * @param checkNode
	 * @return
	 */
	private void setElementContext(Element element, boolean isFirstChild){
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
							
							setElementContext(childElement, false);
								
								
								
						} else {
							ElementInfoMap.put(childNode.getNodeName(), childElement.getAttribute("property"));
							setElementContext(childElement, true);
						}
					} else {
						String nodeName = "";
						if(childNode.getNodeName().equals("isNotEqual")){
							nodeName = "isEqual";
						} else {
							nodeName = childNode.getNodeName();
						}
						
						ElementInfoMap.put(nodeName, childElement.getAttribute("property"));
						setElementContext(childElement, true);

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
						String parentPrepend = ((Element) element.getParentNode()).getAttribute("prepend");
						
						/*
						 * 부모의 prepend를 불러와서 
						 * 존재하면 append한다.
						 */
						if(parentPrepend != null && !("").equals(parentPrepend)){
//							prepend = parentPrepend + prepend;
							/*
							((Element) element.getParentNode()).getFirstChild();
							Node node = (Node)element;
							*/
							if(isFirstChild) {
								prepend = parentPrepend + prepend;
							}
							
						} else {
							System.out.println("부모 Element의 prepend가 존재하지 않습니다.");
						}
						
					
						
						

						/*
						 * 최상위 Element인 경우 현재까지의 Text내용 지우고 새로 append
						 * getTextContent()는 모든 하위의 Text내용을 추출하기 때문 
						 */
						if(j != checkNodeListLength-1){
							query.delete(0, query.length());
						}
						
						query.append(prepend + openStr + element.getTextContent() + closeStr);
//						} else { 
//							query.append(prepend + openStr + element.getTextContent() + closeStr);
//						}

					} else {
						/*if(logger.isInfoEnabled()){
							logger.info("TextNode 내용이 비어있습니다.");
						}*/
					}
				} else {
//					if(logger.isInfoEnabled()){
//						logger.info("NodeType이 TextNode, ElementNode가 아닙니다.");
//					}
				}
			}// end for
		} else {
			/*if(logger.isInfoEnabled()){
				logger.info("자식 노드가 존재하지 않습니다.");
			}*/
		}
		element.setTextContent(query.toString());
	}
}
