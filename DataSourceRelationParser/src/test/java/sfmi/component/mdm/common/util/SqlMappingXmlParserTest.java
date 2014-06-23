package sfmi.component.mdm.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ibatis.sqlmap.engine.builder.xml.SqlMapParser;

import sfmi.component.mdm.dto.AnalyzeData;

/**
 * SqlMappingXmlParser 테스트 
 * @since 2014.03.06
 * @author hwbae
 *
 */
public class SqlMappingXmlParserTest {
	/**
	 *  Root Element를 올바르게 가지고 오는지 확인
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	@Test
	public void testAnalyzXmlFile() throws SAXException, ParserConfigurationException, IOException {
		
		// dao.xml 테스트
		File xmlFile = new File("src/test/resources/testPJT/dao/sqlmap/xml/dao.xml");
		XmlParser parser = new XmlParser();
		
		Document doc = parser.getDocument(xmlFile);
		Element rootElement = doc.getDocumentElement();
		String	rootElementName = rootElement.getNodeName();
		NodeList nodeList = doc.getElementsByTagName("property");
			
		if(nodeList != null && nodeList.getLength() > 0) {

            int nodeListLength = nodeList.getLength();
            for(int i=0; i < nodeListLength; i++) {
                Node node = nodeList.item(i);

                //property값의 value값 가져온다
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element sqlMapElement = (Element) node;
                    System.out.println("sqlMapElement : "+ sqlMapElement.getAttribute("value"));
                }
            }
            
		}
		assertNotNull(doc);
		assertEquals(rootElementName,"daoConfig");
		
		// XXX_config.xml 테스트
		xmlFile = new File("src/test/resources/testPJT/dao/sqlmap/xml/sql-map-oracle-config.xml");
		
		doc = parser.getDocument(xmlFile);
		rootElement = doc.getDocumentElement();
		rootElementName = rootElement.getNodeName();
		assertNotNull(doc);
		assertEquals(rootElementName,"sqlMapConfig");
		
		// XXXDaoMap.xml 테스트
		xmlFile = new File("src/test/resources/testPJT/dao/sqlmap/xml/oracle/AuthorityDaoMap.xml");
		doc = parser.getDocument(xmlFile);
		rootElement = doc.getDocumentElement();
		rootElementName = rootElement.getNodeName();
		
		assertNotNull(doc);
		assertEquals(rootElementName,"sqlMap");
	}
	
	/**
	 * SQLID와 SQL을 추출하여 저장
	 * SQL 분석기 실행 테스트
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	@Test
	public void testParseSqlResource() throws SAXException, ParserConfigurationException, IOException{
		List<AnalyzeData> testDataList = new ArrayList<AnalyzeData>();
		File xmlFile = new File("src/test/resources/testPJT/dao/sqlmap/xml/oracle/ChangeAdministrationDaoMap.xml");
		XmlParser parser = new XmlParser();
		Document doc = parser.getDocument(xmlFile);
		
		// 파일이 실제 존재하는지 체크
		assertTrue(xmlFile.exists());
		assertNotNull(doc);
		
		// 메서드 실행
//		testDataList = sqlMappingXmlParser.parseSqlResource(doc, xmlFile.getAbsolutePath());
		
		assertNotNull(testDataList);
		assertTrue(testDataList.size() == 8);
		
		

	}// end method
}// end class
