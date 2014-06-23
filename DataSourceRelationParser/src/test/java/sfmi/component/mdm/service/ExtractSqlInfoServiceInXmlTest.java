package sfmi.component.mdm.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import sfmi.component.mdm.context.PropertyContext;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.service.online.ExtractOnlineSqlInfoServiceInXml;

/**
 * ExtractSqlInfoServiceInXml 테스트 클래스 
 * @since 2014.03.07
 * @author hwbae
 *
 */
public class ExtractSqlInfoServiceInXmlTest {
	
	@BeforeClass
	public static void setup(){

	}
	/**
	 * extract 테스트 메소드
	 */
	@Test
	public void testExtract() {
		
		String targetDir = "src/test/resources/testPJT";
		ExtractOnlineSqlInfoServiceInXml extractSqlInfoServiceInXml = new ExtractOnlineSqlInfoServiceInXml();
		List<AnalyzeData> sqlAnalyzeDataList = new ArrayList<AnalyzeData>();
		
		PropertyContext.setTargetDir(targetDir);
//		PropertyContext.setProgramType("ONLINE");
		
		// 메서드 실행 
//		sqlAnalyzeDataList = extractSqlInfoServiceInXml.extract();
		
		assertNotNull(sqlAnalyzeDataList);
		
		// 동적 쿼리 제외, select문 제외,SQL파싱하다 오류 제외 
		Assert.assertTrue(sqlAnalyzeDataList.size() == 34);
//		System.out.println("--------------------------------------------------");
//		for(AnalyzeData data : sqlAnalyzeDataList){
//			System.out.println("XML FILE INFO : "+((SqlAnalyzeData) data).toString());
//		}
		
		
		
	}

}
