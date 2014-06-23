package sfmi.component.mdm.common.util;

import java.io.File;

import org.apache.log4j.Logger;

import sfmi.component.mdm.context.PropertyContext;

/**
 * ��Ʈ�� ��ƿ
 * @author hwbae
 *
 */
public class AnalyzerStringUtil {
	private static Logger logger = Logger.getLogger(AnalyzerStringUtil.class);
	
	/**
	 * VOB명부터 파일명까지 추출
	 * @param filePath
	 * @return
	 */
	public static String setFileRootDir(String filePath){
		int vobIdx = PropertyContext.getFindVobDepth();
		String targetDir = PropertyContext.getTargetDir();
		String rootFilePath = "";
		
		if(vobIdx > 0){
			
			filePath = filePath.replace(targetDir, "");
			
			// vob명추출하여 다시 경로를 만들어 준다.
			String vobAndPjt[] = filePath.split("\\\\");

			for(int i = vobIdx; i < vobAndPjt.length; i++){
				rootFilePath += vobAndPjt[i] + File.separator;
			}
			
			// 마지막에 추가된  \ 지우기
			rootFilePath = rootFilePath.substring(0,rootFilePath.lastIndexOf("\\"));
			
		} else if(vobIdx == 0){
			/*
			 *  targetDir에서 vob명 추출하여 경로에 붙인다.
			 */
//			String vobName[] = targetDir.split("\\\\");
//			filePath = filePath.replace(targetDir, "");
			
//			rootFilePath = vobName[vobName.length-1] + filePath;
			
		} else {
			// TODO:: 0보다 작을때 추가 
		}
		
		return rootFilePath;
		
	}
	
	/**
	 * VOB명 부터 파일상위의 DIR까지 추출
	 * DAO파일에만 사용 
	 * @param filePath
	 * @return
	 */
	public static String setFileLowRootDir(String filePath){
		int vobIdx = PropertyContext.getFindVobDepth();
		String targetDir = PropertyContext.getTargetDir();
		String rootFilePath = File.separator;
		
		if(vobIdx > 0){
			
			filePath = filePath.replace(targetDir, "");
			
			// vob명추출하여 다시 경로를 만들어 준다.
			String vobAndPjt[] = filePath.split("\\\\");

			for(int i = vobIdx; i < vobAndPjt.length-1; i++){
				rootFilePath += vobAndPjt[i] + File.separator;
			}
			
			// 마지막에 추가된  \ 지우기
			rootFilePath = rootFilePath.substring(0,rootFilePath.lastIndexOf("\\"));
			
		} else if(vobIdx == 0){
			/*
			 *  targetDir에서 vob명 추출하여 경로에 붙인다.
			 */
//			String vobName[] = targetDir.split("\\\\");
//			filePath = filePath.replace(targetDir, "");
			
//			rootFilePath = vobName[vobName.length-1] + filePath;
			
		} else {
			// TODO:: 0보다 작을때 추가 
		}
		
		return rootFilePath;
		
	}
	
	/**
	 * VOB명과 PJT 명을 추출한다.
	 *  - 조건 :  1. VOB명 상위를 TargetDir로 선언했을때..
	 *  	    2. property파일에 몇 depth가 들어가야 VOB명이 있는 지 선언
	 * @param filePath
	 * @return
	 */
	public static String extractVobName(String filePath){
		/*
		 * depth에 따라 다르다.
		 */
		int vobIdx = PropertyContext.getFindVobDepth();
		String targetDir = PropertyContext.getTargetDir();
		String returnVobAndPjtName = "";
		
		if(vobIdx > 0){
			
			filePath = filePath.replace(targetDir, "");
			
			String vobAndPjt[] = filePath.split("\\\\");
			
			String vobName = vobAndPjt[vobIdx];
			String pjtName = vobAndPjt[vobIdx+1];
			
			/**
			 *:: VOB명만 추출 하도록 수정함
			 * 		   PJT가 필요하면 주석 제거 
			 */
//			returnVobAndPjtName =   vobName + "/" + pjtName;
			returnVobAndPjtName =  File.separator + vobName;
			
		} else if(vobIdx == 0){
		
//			String vobName[] = targetDir.split("\\\\");
//			filePath = filePath.replace(PropertyContext.getTargetDir(), "");
			String pjtName[] = filePath.split("\\\\");
			
//			returnVobAndPjtName =  vobName[vobName.length-1] + "/" + pjtName[vobIdx+1];
//			returnVobAndPjtName = vobName[vobName.length-1];
			
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("DEPT가 올바르지 않습니다.");
			}
		}
		
		return returnVobAndPjtName;
	}
	
	
	/**
	 * local Dir을 지우고 Vob명 부터 경로를 추출한다.
	 * @param filePath
	 * @return
	 */
	public static String extractVobDir(String filePath){
		
//		/*
//		 * vob명 보다 상위 dir로 부터 실행했을 경우  
//		 */
//		String targetDir = PropertyContext.getTargetDir();
//		int idx = PropertyContext.getFindPjtDepth();
//		
//		filePath = filePath.replace(targetDir, "");
		
		
		return null;
	}
}
