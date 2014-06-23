package sfmi.component.mdm.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sfmi.component.mdm.context.PropertyContext;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.service.online.ExtractOnlineSqlInfoServiceInJava;

/**
 * ExtractSqlInfoServiceInJava 테스트 클래스 
 * @since 2014.03.10
 * @author hwbae
 *
 */
public class ExtractSqlInfoServiceInJavaTest {

	@Test
	public void testExtract() {
		String targetDir = "src/test/resources/testPJT";
		
		ExtractOnlineSqlInfoServiceInJava extractSqlInfoServiceInJava = new ExtractOnlineSqlInfoServiceInJava();
		List<AnalyzeData> javaAnalyzeDataList = new ArrayList<AnalyzeData>();
		
		PropertyContext.setTargetDir(targetDir);
//		PropertyContext.setProgramType("ONLINE");
		// 메서드 실행 
//		javaAnalyzeDataList = extractSqlInfoServiceInJava.extract();
		
		
		// SQL ID 개수 
		Assert.assertTrue(javaAnalyzeDataList.size() == 7);
		for(AnalyzeData analyzeDataList : javaAnalyzeDataList){
			System.out.println("analyzeDataList 정보 : "+ analyzeDataList.toString());
		}
			
	}

}
