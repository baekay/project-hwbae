package sfmi.component.mdm.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.dto.JobBeanInfo;
import sfmi.component.mdm.dto.JobInfo;
import sfmi.component.mdm.dto.StepInfo;
import sfmi.component.mdm.service.batch.CollectBatchXmlInfoService;

public class JobInfoTest {

	@Test
	public void test() throws SAXException, ParserConfigurationException, IOException {
		BatchJobContext.getJobContext().initJobContext();
		//F:\ANTLR_WORK\antlr_workspace\PO\XDBatchScript\xdcontrolm\jobs
		CollectBatchXmlInfoService service = new CollectBatchXmlInfoService();
		Map<String, List<AnalyzeData>> resultMap = service.collectXmlData("F:\\ANTLR_WORK\\antlr_workspace\\PO\\XDBatchScript\\xdcontrolm\\jobs");
		
		List<AnalyzeData> resultList = resultMap.get("BATCH");
		JobInfo data;
		
		for(AnalyzeData batchInfo : resultList){
			data = (JobInfo)batchInfo;
//			System.out.println("JobData : "+ data.getJobId());
//			System.out.println("STEP DATA : "+ data.getStepList());
			
			for(StepInfo step : data.getStepList()){
				System.out.println("JOB INFO : " + data.getJobId());
				System.out.println("STEP TYPE : " + step.getStepType());
				System.out.println("STEP ID : " + step.getStepId());
				System.out.println("SQL : " + step.getSql());
				System.out.println("STEP PROCESSOR : " + step.getProperties().get("processor"));
			}
//			System.out.println("-===============================================================");
//			for(JobBeanInfo bean : data.getBeanList()){
//				System.out.println("BEAN ID : " + bean.getBeanId());
//				System.out.println("BEAN CLASS : " + bean.getBeanClass());
//				System.out.println("PROPERTY : " + bean.getPropertyInfo());
//			}
//			System.out.println("-===============================================================");
//			
		}
//		
//		String filePath = "F:\\ANTLR_WORK\\antlr_workspace\\PO\\XDBatchScript\\xdcontrolm\\jobs\\PPDIMC.MJU023.xml";
//		File file = new File(filePath);
//		Document doc;
//		
//		doc = XmlParser.getDocument(file);
//		
//		service.analyzeBatchJob(doc, filePath);
	}

}
