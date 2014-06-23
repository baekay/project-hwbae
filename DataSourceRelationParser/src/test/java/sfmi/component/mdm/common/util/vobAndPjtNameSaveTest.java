package sfmi.component.mdm.common.util;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import sfmi.component.mdm.context.PropertyContext;

/**
 * vob명 Pjt명 저장 테스트
 * @author hwbae
 *
 */
public class vobAndPjtNameSaveTest {

	@Test
	public void testVobAndPjtNameSave() {
		// 테스트 환경 set
		String targetDir = "D:\\SFMI_WORK\\indigo_workspace\\PO";
		String targetFileDir = "D:\\SFMI_WORK\\indigo_workspace\\PO\\XDGeneralBatch\\XdGeneralBatchCommon\\src\\sfmi\\xdbatch\\general\\mapping\\PPHK03TB.java";
		File testFile = new File(targetFileDir);
		
		int dirPjt = 2;
		
		String filePath = testFile.getAbsolutePath();
		
		System.out.println("filePath : " + filePath);
//		System.out.println("\\ : " + File.separator ) ;
		
		/*
		 * 최종 모습
		 */
		filePath = filePath.replace(targetDir, "");
		System.out.println("filePath : " + filePath);
		String str[] = filePath.split("\\\\");
		
		System.out.println("str[1] : " + str[1]);
		System.out.println("str[2] : " + str[2]);
		
//		System.out.println("VOB/PJT" + filePath);
		
		targetDir = "D:\\SFMI_WORK\\indigo_workspace";
		
//		/*
//		 * VOB별로 돌릴때
//		 */
//		String str2[] = targetDir.split("\\\\");
//		System.out.println("--------------------------------------");
//		System.out.println("str[3] : " + str2[3]);
//		
//		targetFileDir = targetFileDir.replace(targetDir, "");
//		System.out.println("targetFileDir : " + targetFileDir);
//		
//		String str3[] = targetFileDir.split("\\\\");
//		System.out.println("str3[1] : " + str3[1]);
		
		targetFileDir = "D:\\SFMI_WORK\\indigo_workspace\\PO\\XDGeneralBatch\\XdGeneralBatchCommon\\src\\sfmi\\xdbatch\\general\\mapping\\PPHK03TB.java";
		
		PropertyContext.setTargetDir("D:\\SFMI_WORK\\indigo_workspace");
		PropertyContext.setFindVobDepth(1);
		String str1 = AnalyzerStringUtil.setFileRootDir(targetFileDir);
		String str2 = AnalyzerStringUtil.setFileLowRootDir(targetFileDir);
	
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
	}

}
