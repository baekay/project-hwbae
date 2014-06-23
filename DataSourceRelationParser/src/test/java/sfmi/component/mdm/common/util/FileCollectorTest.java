package sfmi.component.mdm.common.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;

public class FileCollectorTest {
	
	@BeforeClass
	public static void setup(){
	}
	
	@Test
	public void testCollectFiles() {
		// 테스트 환경 set
		String targetDir = "src/test/resources/testPJT";
		File testFile = new File(targetDir);
		
		// 파일 수집 테스트 java 모드 
		FileCollector fileCollector = new FileCollector(SQLAnalyzerConstants.JAVA_FILE_COLLECT_MODE);
		fileCollector.collectFiles(testFile);
		assertNotNull(fileCollector.getFileList());
		assertTrue(fileCollector.getFileList().size() == 16);

		
		// 파일 수집 테스트 xml 모드 
		fileCollector = new FileCollector(SQLAnalyzerConstants.XML_FILE_COLLECT_MODE);
		fileCollector.collectFiles(testFile);
		assertNotNull(fileCollector.getFileList());
		assertTrue(fileCollector.getFileList().size() == 10);
		
	}

}
