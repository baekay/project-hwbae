package sfmi.component.mdm.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sfmi.component.mdm.context.PropertyContext;
import sfmi.component.mdm.dto.JobBeanInfo;
import sfmi.component.mdm.dto.JobInfo;

public class NodeTest {

	@Test
	public void test() throws SAXException, ParserConfigurationException, IOException {
//		String testFile = "D:\\SFMI_WORK\\indigo_workspace\\PO\\XDGeneralBatch\\XdGeneralDailyExternalBatch\\conf\\jobs\\RREXDC.C006.xml";
		/*
		 * job XML 경로 추출 테스트 파일
		 */
		String testFile = "D:\\SFMI_WORK\\indigo_workspace\\CL\\XDCCBatch\\XdClaimCarDailyBatch\\conf\\jobs\\CCDADC.DAX1306.xml";
		/*
		 * jobBean 추출 테스트 파일
		 */
//		String testFile = "D:\\SFMI_WORK\\indigo_workspace\\SQLParser\\src\\test\\resources\\testPJT\\jobs\\PUCRMC.CRX002.xml";
		
		File xmlFile = new File(testFile);
		Document doc = XmlParser.getDocument(xmlFile);
		
		Element rootElement = doc.getDocumentElement();
		String rootElementName = rootElement.getNodeName();
		NodeList beanNodeList = rootElement.getChildNodes();
		System.out.println("rootElement : " + rootElement);
		
		JobInfo jobInfo = null;
		JobBeanInfo beanInfo;
		Map<String, String> propertyInfo;
		List<JobBeanInfo> beanList = new ArrayList<JobBeanInfo>();
		
		if(rootElementName.equals("beans")){
			
			jobInfo =  new JobInfo();
			
			PropertyContext.setTargetDir("D:\\SFMI_WORK\\indigo_workspace\\CL");
			String dir = PropertyContext.getTargetDir();
			
			if(testFile.contains(dir)){
				System.out.println("경로 포함");
			}
			
			System.out.println("INDEX : " + testFile.lastIndexOf(dir));
//			System.out.println("SPLIT : " + testFile.split(PropertyContext.getTargetDir()));
			
			
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
					
					String beanElementName = beanElement.getNodeName();
					System.out.println("beanElementName : " + beanElementName);
					
					Pattern propertyDaoRefPattern = Pattern.compile("(p:)(\\w+)(-ref\\=(\")(.*)(\"))");
					
//					System.out.println("beanElement.getAttribute : " + beanElement.getAttributes().toString());

					NamedNodeMap attributeMap = beanElement.getAttributes();
					
					if(attributeMap.getLength() > 2 ){
						for(int a = 0; a < attributeMap.getLength(); a++){
							
							System.out.println("NamedNodemap Test : " + attributeMap.item(a).toString());
							
							Matcher matcher = propertyDaoRefPattern.matcher(attributeMap.item(a).toString());
							
							String propertyName = null;
							String propertyRef = null;
							
							if(matcher.matches()){
								System.out.println("matcher.group(2) : " + matcher.group(2).trim());
								System.out.println("matcher.group(4) : " + matcher.group(5).trim());
								
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
							System.out.println("NODE TYPE이 아닙니다.");
						}
						
					} // end for(p)
					
					beanInfo.setPropertyInfo(propertyInfo);
					beanList.add(beanInfo);
					
				}
			}
		}
		
		/*
		 * JobBean추출 테스트 내용
		 */
//		for(JobBeanInfo jobBeanInfo : beanList){
//			System.out.println("-----------------------------------------------------------------");
//			System.out.println("Bean ID  : " + jobBeanInfo.getBeanId());
//			System.out.println("Bean CLASS  : " + jobBeanInfo.getBeanClass());
//			System.out.println("Bean PROPERTY  : " + jobBeanInfo.getPropertyInfo());
//			System.out.println("-----------------------------------------------------------------");
//		}
//		Assert.assertTrue(beanList.size() == 4);
//		Assert.assertEquals("deliberateConfirmProcessor", beanList.get(1).getBeanId());
//		Assert.assertEquals("sfmi.xdbatch.uw.crpoint.processor.DeliberateConfirmProcessor", beanList.get(1).getBeanClass());
//		Assert.assertEquals("deliberateBatchDao", beanList.get(1).getPropertyInfo().get("deliberateBatchDao"));
//		
//		Assert.assertEquals("deliberateBatchDao", beanList.get(2).getBeanId());
//		Assert.assertEquals("sfmi.xdbatch.uw.crpoint.processor.dao.jdbc.JdbcDeliberateConfirmDao", beanList.get(2).getBeanClass());
//		Assert.assertEquals("AGDBDs", beanList.get(2).getPropertyInfo().get("dataSource"));
	}

}
