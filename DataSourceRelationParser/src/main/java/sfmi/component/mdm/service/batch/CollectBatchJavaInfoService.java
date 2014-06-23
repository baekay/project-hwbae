package sfmi.component.mdm.service.batch;

import japa.parser.ParseException;
import japa.parser.TokenMgrError;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.AnalyzerStringUtil;
import sfmi.component.mdm.common.util.FileCollector;
import sfmi.component.mdm.common.util.JavaSourceParser;
import sfmi.component.mdm.common.util.PropertyLoader;
import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.handler.ExceptionHandler;
import sfmi.component.mdm.listener.BatchJobListener;

/**
 * Batch의 JAVA 파일을 수집한다.
 * @author hwbae
 *
 */
public class CollectBatchJavaInfoService { 
	
	private static Logger logger = Logger.getLogger(CollectBatchJavaInfoService.class);

	/**
	 * @return
	 */
	public Map<String, List<ClassInfo>> collectJavaFile() {
		Properties propertyLoader = PropertyLoader.load();
		return collectJavaFile(propertyLoader.getProperty("target.source.path"));
	}
	
	/**
	 * @param targetSourcePath
	 * @return
	 */
	public Map<String, List<ClassInfo>> collectJavaFile(String targetSourcePath) {
		return collectJavaFile(targetSourcePath, null);
	}
	
	/**
	 * @param targetSourcePath
	 * @param filter
	 * @return
	 */
	public Map<String, List<ClassInfo>> collectJavaFile(String targetSourcePath, Map<String, List<String>> filter) {
		// 저장 리스트
		List<ClassInfo> generalClassInfoList = new ArrayList<ClassInfo>();
		List<ClassInfo> daoClassInfoList = new ArrayList<ClassInfo>();
		List<ClassInfo> processorClassInfoList = new ArrayList<ClassInfo>();
		
		Map<String, List<ClassInfo>> classInfoMap = new HashMap<String, List<ClassInfo>>();
		
		if(targetSourcePath == null) {
			Properties propertyLoader = PropertyLoader.load();
			propertyLoader.getProperty("target.source.path");
		}
		
		File targetDir = new File(targetSourcePath);
		
		// 파일수집 
		if(logger.isInfoEnabled()){
			logger.info("JAVA 파일 확장자 검사 후 수집합니다..");
		}
		
		// FileCollector를 사용하여 확장자가 JAVA인 파일을 수집한다. 
		FileCollector fileCollector = new FileCollector(SQLAnalyzerConstants.JAVA_FILE_COLLECT_MODE);
		fileCollector.collectFiles(targetDir);
		
		// 확장자 체크 완료 파일
		List<File> fileList = fileCollector.getFileList();
		
		if(logger.isInfoEnabled()){
			logger.info("JAVA 파일을 수집 완료합니다..");
		}
		
		if(logger.isInfoEnabled()){
			logger.info("java file을 파싱하여 CLASS 정보를 수집합니다.");
			logger.info("[START]------------------------------------------------");
		}	
		
		// 자바 파일 파싱 
		for(File file : fileList){
			if(logger.isDebugEnabled()){
				logger.debug("자바 파일을 파싱 합니다.. : " + file.getPath());
			}	
			
			ClassInfo classInfo = null;
			
			try {
				classInfo = JavaSourceParser.parse(file);
			} catch (IOException e) {
				ExceptionHandler.handle(e, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null ,null, null, JavaSourceParser.class);
			} catch (ParseException e) {
				ExceptionHandler.handle(e, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null ,null, null, null);
			} catch (Exception e) {
				ExceptionHandler.handle(e, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null ,null, null, null);
			} catch (TokenMgrError e){
				ExceptionHandler.handle(null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), null, null ,null, null, JavaSourceParser.class);
			}
			
			List<String> extendsNameList;
			
			if(logger.isDebugEnabled()){
				logger.debug(" ClassInfo를 비교하여 대상JAVA 파일인지 확인합니다.");
			}
			
			// class정보를 비교하여 대상 class 파일만 추출한다.
			if(filter == null) {
				generalClassInfoList.add(classInfo);

				// 대상 자바 파일 카운트 
				BatchJobListener.countListener(SQLAnalyzerConstants.JAVA_FILE_CNT);
			} else if(!filter.isEmpty()) {
				extendsNameList = new ArrayList<String>();
				extendsNameList = filter.get(SQLAnalyzerConstants.EXTENDS_NAME); 
				
				for(String extendsName : extendsNameList){
					if(classInfo == null) {
						if(logger.isDebugEnabled()){
							logger.debug("\t ExtendsName이 존재하지 않습니다. ");
						}
					} else {
						String classExtendsName = classInfo.getExtendsName();
						if(classExtendsName!= null && classInfo.getExtendsName().equals(extendsName)){
							if(logger.isInfoEnabled()){
								logger.info("\t [CLASS] : "  + classInfo.getName());
							}
							
							/*
							 * processor class와 나머지 class분류 
							 */
							if(classExtendsName.equals(SQLAnalyzerConstants.EXTENDS_NAME_PROCESSOR)){
								processorClassInfoList.add(classInfo);
							} else {
								daoClassInfoList.add(classInfo);
							}
									
							// 대상 자바 파일 카운트 
							BatchJobListener.countListener(SQLAnalyzerConstants.JAVA_FILE_CNT);
							
							break;
						} else {
							if(logger.isDebugEnabled()){
								logger.debug("\t대상 ExtendsName이 아닙니다. " + classInfo.getExtendsName());
							}
						}//  end else
					}
				}// end for(extendsNameList)
			}
			
		}//end for
		
		if(logger.isInfoEnabled()){
			logger.info("[END]------------------------------------------------");
		}	
		
		classInfoMap.put(SQLAnalyzerConstants.BATCH_DAO_CLASS, daoClassInfoList);
		classInfoMap.put(SQLAnalyzerConstants.BATCH_PROCESSOR_CLASS, processorClassInfoList);
		classInfoMap.put(SQLAnalyzerConstants.BATCH_GENERAL_CLASS, generalClassInfoList);
		
		return classInfoMap;
	}

}
