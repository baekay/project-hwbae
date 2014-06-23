package sfmi.component.mdm.launcher;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.Logger;

import sfmi.component.mdm.common.util.PropertyLoader;
import sfmi.component.mdm.context.PropertyContext;

/**
 * TargetDir를 읽어 
 * 폴더 별로 실행하도록 한다.
 * @author hwbae
 *
 */
public class SQLAnalyzLauncher {
	private static Logger logger = Logger.getLogger(SQLAnalyzLauncher.class);
	
	public static void main(String[] args) {
		boolean isValid = validate();
		
		if(isValid){
			SQLAnalyzLauncherService sqlAnalyzLauncher = new SQLAnalyzLauncherService();
			String targetDir = PropertyContext.getTargetDir();
			/*
			 * 타겟 경로의 하위 폴더들 단위로 실행한다.
			 */
			File targetFile = new File(targetDir);
			File[] fileList = targetFile.listFiles();
			
			for(File file : fileList){
				sqlAnalyzLauncher.run(file.getAbsolutePath(), file.getName());
			}
		} else {
			if(logger.isInfoEnabled()) {
				logger.info("실행조건에 맞지않아 종료합니다.");
			}
			System.exit(0);
		}
	}
	
	/**
	 * 기동 가능여부 체크
	 * 1. 경로 체크 
	 * @return 
	 */
	private static boolean validate() {
		boolean isValid = false;
		Properties propertyLoader = PropertyLoader.load();
		
//		PropertyContext.setProgramType(propertyLoader.getProperty("target.source.type"));
		PropertyContext.setTargetDir(propertyLoader.getProperty("target.source.path"));
		PropertyContext.setFindVobDepth(Integer.parseInt(propertyLoader.getProperty("target.vob.depth")));
		
		// 설정파일에 경로 입력하지 않음
		if(("").equals(PropertyContext.getTargetDir())){
			isValid = false;
			logger.error("경로를 입력하지 않았습니다. 프로퍼티 파일의 target.source.path 항목에 경로를 입력해 주십시오.");
			return isValid;
//		} else if( ("".equals(PropertyContext.getProgramType())) || ( !"BATCH".equals(PropertyContext.getProgramType()) && !"ONLINE".equals(PropertyContext.getProgramType()) ) ) { 
//			logger.error("타입을 입력하지 않았습니다. 프로퍼티 파일의 target.source.type 항목을 입력해 주십시오.(ONLINE / BATCH)");
//			return isValid;
		}else {
			File checkPath = new File(PropertyContext.getTargetDir()); 

			// 존재하지 않은 경로
			if(!checkPath.exists()){
				isValid = false;
				logger.error("잘못된 경로입니다. 프로퍼티 파일의 target.source.path 항목의 경로를 확인해 주십시오.");
				return isValid;
			} else { 
				isValid = true;
			}
		}
		return isValid;
	}
}
