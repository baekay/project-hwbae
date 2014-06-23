package sfmi.component.mdm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.service.batch.CollectBatchXmlInfoService;

public class CollectBatchXmlInfoServiceTest {

	@Test 
	public void test() {
		CollectBatchXmlInfoService service = new CollectBatchXmlInfoService();
		Map<String,List<AnalyzeData>> resultMap = new HashMap<String, List<AnalyzeData>>();
		
		Map<String, AnalyzeData> map = new HashMap<String, AnalyzeData>();
		
		resultMap = service.collectXmlData("F:\\test");
		
//		map = resultMap.get(1);
//		for(Map<String, AnalyzeData> list : resultMap){
//			if(list.get("BATCH") != null){
//				System.out.println(list.get("BATCH"));
//				System.out.println("------------------------------------------------------------------");
//			}  if (list.get("SQL") != null){
//				System.out.println(list.get("SQL"));
//				System.out.println("------------------------------------------------------------------");
//				
//			}
//		}
		
		
		
	
	}

}
