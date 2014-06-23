package sfmi.component.mdm.service.online;

import japa.parser.ParseException;
import japa.parser.TokenMgrError;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.AnalyzerStringUtil;
import sfmi.component.mdm.common.util.FileCollector;
import sfmi.component.mdm.common.util.JavaSourceParser;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.JavaAnalyzeData;
import sfmi.component.mdm.dto.MethodInfo;
import sfmi.component.mdm.handler.ExceptionHandler;
import sfmi.component.mdm.listener.BatchJobListener;
import sfmi.component.mdm.service.ExtractSqlInfoService;

/**
 * java 파일 파싱하여 sql 정보 추출하는 서비스 
 * SQL ID가 String으로 따로 선언되어 사용하고 있는 경우는 제외한다.
 * @author hwbae
 *
 */
public class ExtractOnlineSqlInfoServiceInJava implements ExtractSqlInfoService{

	private static Logger logger = Logger.getLogger(ExtractOnlineSqlInfoServiceInJava.class);
	
	public List<AnalyzeData> extract(String targetSystemDir) {
		// 결과 저장 객체 
		List<AnalyzeData> sqlAnalyzeDataList = new ArrayList<AnalyzeData>();
		
//		File targetDir = new File(PropertyContext.getTargetDir());
		File targetDir = new File(targetSystemDir);
		
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
			logger.info("java file을 파싱하여 SQL 정보를 수집합니다..");
		}		
		
		List<MethodInfo> methodList = null;
		BlockStmt stmt = null;
		List<Statement> statements = null;
		JavaAnalyzeData javaAnalyzeData = null;
		
		// 찾을 패턴
//		Pattern defaultSqlIdPattern = Pattern.compile("(.*)?(update|delete|insert|queryForObject|queryForList|queryForMap){1}(\\(\")(.*)(\\\")(.*)");
		Pattern defaultSqlIdPattern = Pattern.compile("(.*)?(update|delete|insert|queryForObject|queryForList|queryForMap){1}(\\(\")(.*)(\\\"),(.*)");
		Pattern assignSqlIdPattern = Pattern.compile("(.*)?(update|delete|insert|queryForObject|queryForList|queryForMap){1}(\\()(\\w+)(.*)");
		
//		Pattern assignSqlIdPattern = null;
		
		Matcher matcher = null;
		boolean isSqlMapExist = false;
		boolean isSqlDao = false;
		String classExtendsName = null;
		String methodName = null;
		
		// SQL 관련된 파일 추출 시작
		for(File file : fileList){
			// 초기화
			isSqlDao = false;
			isSqlMapExist = false;
			
			 try {
				ClassInfo classInfo = JavaSourceParser.parse(file);
				
				if(!classInfo.isEmpty()) {
				
					// class명에 sqlMap이 포함되어있다.
					isSqlMapExist = classInfo.getName().contains("SqlMap");
					
					classExtendsName = classInfo.getExtendsName();
					
					if(classExtendsName != null){
						
					// SqlMapDaoTemplate나 sqlMapDaotemplateExt를 상속받는다.
						if(classExtendsName.equals("SqlMapDaoTemplate") || 
								classExtendsName.equals("SqlMapDaoTemplateExt")){
							
							isSqlDao = true; 
	
						} else { 
							/* Do Nothing */ 
							if(logger.isDebugEnabled()){
								logger.debug("대상 클래스가 아닙니다..");
							}
						}
					} else {
						if(logger.isDebugEnabled()){
							logger.debug("대상 클래스가 아닙니다..");
						}
					} 
					
					// SQL 관련 java파일의 method정보 추출
					if(isSqlMapExist || isSqlDao){
						// 대상 자바 파일 개수 증가 
						BatchJobListener.countListener(SQLAnalyzerConstants.JAVA_FILE_CNT);
						
						// 대상 클래스
						if(logger.isInfoEnabled()){
							logger.info("[Start] -------------------------------------------------------------------------------------------------------------------"); 
							logger.info("\t대상JAVA 파일을 분석합니다.  : ["+ classInfo.getPackageName()+"."+classInfo.getName() + "]"); 
						}
						methodList = classInfo.getMethodInfos();
						for(MethodInfo method : methodList){
							if(method.getBlockStmt() != null) {
								// 메소드 내의 각 statement 추출 
								stmt = method.getBlockStmt();
								statements = stmt.getStmts();
								
								if(statements != null && statements.size() > 0) {
									Map<String, JavaAnalyzeData> sqlIdCheck = new HashMap<String, JavaAnalyzeData>();
									
									// 메소드 내의 각 statement와 패턴 비교 
									for(Statement state : statements){
										matcher = defaultSqlIdPattern.matcher(state.toString());
										
										// 패턴 일치 
										if(matcher.find()){
											// if문에서 시퀀스가 하나 증가했기 때문에 인덱스 초기화
											matcher.reset();
											
											while(matcher.find()){
												// 패턴에서 SQL ID의 인덱스는 항상 4
												if(matcher.group().length() >= 4){
													javaAnalyzeData = new JavaAnalyzeData();
		//											javaAnalyzeData.setJavaFile(file.getAbsolutePath());
													javaAnalyzeData.setJavaFileName(classInfo.getFileName());
													javaAnalyzeData.setJavaFileLowPath(classInfo.getFileLowPath().replace("\\", "/"));
													javaAnalyzeData.setMethodName(method.getSignature());
													methodName = method.getSignature();
													javaAnalyzeData.setSqlID(matcher.group(4));
													/*
													 * TODO :: VOB단위로 분석하기 때문에 추가...
													 * 			 더 상위에서 분석될 경우 지우기..
													 */
													javaAnalyzeData.setSystemId(classInfo.getSystemId());
													if(!sqlIdCheck.containsKey(javaAnalyzeData.getSqlID())) {
														sqlIdCheck.put(javaAnalyzeData.getSqlID(), javaAnalyzeData);
														
														// 자바파일에 선언된 sqlId 건수 증가
														BatchJobListener.countListener(SQLAnalyzerConstants.JAVA_SQL_ID_CNT);
													}
													
													if(logger.isInfoEnabled()){
														logger.info("\tSQL ID : " + matcher.group(4));
													}
			
												} else { 
													if(logger.isDebugEnabled()){
														logger.debug("\tSQL ID를 찾을 수 없습니다.....??");
													}
												}
											}// end while
										} else {
											matcher = assignSqlIdPattern.matcher(state.toString());
											
											// SQL ID를 변수에 선언해 놓았을 경우 클래스 Field와 메소드 Statement 에서 다시 추출
											if(matcher.find()) {
												matcher.reset();
												
												Pattern bodyAssignSqlIdPattern = null;
												Matcher sqlIdMatcher = null;
												
												/*
												 * SqlId를 저장하는 리스트
												 */
												List<String> sqlIdList = new ArrayList<String>();
												
												while(matcher.find()){
//													javaAnalyzeData = new JavaAnalyzeData();
//													
//													javaAnalyzeData.setJavaFile(classInfo.getQualifiedName()+".java");
//													javaAnalyzeData.setMethodName(method.getSignature());
//													
													// 클래스 Field 에 선언해 놓았을 경우
													if(classInfo.getVariables().containsKey(matcher.group(4))) {
														/*
														 * sqlId를 List에 추가하도록 변경
														 */
														sqlIdList.add( classInfo.getVariables().get(matcher.group(4)).replaceAll("\"", "") );
														
//														javaAnalyzeData.setSqlID( classInfo.getVariables().get(matcher.group(4)).replaceAll("\"", "")  ); 
													} else {
														// BODY Statement 에서 검색
														bodyAssignSqlIdPattern = Pattern.compile("(.*)?("+matcher.group(4) +"){1}(\\s\\=\\s)(\")(.*)(\")");
														sqlIdMatcher = bodyAssignSqlIdPattern.matcher(stmt.toString());
														while(sqlIdMatcher.find()) {
															/*
															 * sqlId를 List에 추가하도록 변경
															 * SQL ID가 여러개 나온다.
															 */
															sqlIdList.add( sqlIdMatcher.group(5) );
															
//															javaAnalyzeData.setSqlID( sqlIdMatcher.group(5) );
														}
													}
													
													/*
													 *  sqlID를 죄다 추출해서 LIST형태로 저장
													 * 		  SQLID LIST FOR문 돌면서 javaAnalyzeData = new JavaAnalyzeData();
													 * 			객체 생성하여put한다.
													 */
													
													for(String sqlId : sqlIdList){
														if(sqlId != null && !("").equals(sqlId)){
															javaAnalyzeData = new JavaAnalyzeData();
															javaAnalyzeData.setJavaFileName(classInfo.getFileName());
															javaAnalyzeData.setJavaFileLowPath(classInfo.getFileLowPath().replace("\\", "/"));
															javaAnalyzeData.setMethodName(method.getSignature());
															javaAnalyzeData.setSqlID(sqlId);
															
															if(!sqlIdCheck.containsKey(javaAnalyzeData.getSqlID())) {
																sqlIdCheck.put(javaAnalyzeData.getSqlID(), javaAnalyzeData);
																
																// 자바파일에 선언된 sqlId 건수 증가
																BatchJobListener.countListener(SQLAnalyzerConstants.JAVA_SQL_ID_CNT);
															}
														}// end if	
													} // end for sqlIdList
													
													
//													sqlAnalyzeDataList.add(javaAnalyzeData);
												}
											} else {
												// 패턴 불일치 
												/* DO NOTHING */
												if(logger.isDebugEnabled()){
													logger.debug("\t정규식 패턴이 불일치 합니다..");
												}
											}
											
										}// end else
									}// end for( statement )
									
									// 메소드내의 중복된 SQLID 제거
									if(!sqlIdCheck.isEmpty()) {
										for(Entry<String, JavaAnalyzeData> entryData : sqlIdCheck.entrySet()){
											sqlAnalyzeDataList.add(entryData.getValue());
										}
									}
								}
							}
						}// end for( method )
						
						if(sqlAnalyzeDataList.isEmpty()) {
							if(logger.isDebugEnabled()){
								logger.info("\t관련정보가 존재하지 않습니다."); 
							}
						}
						
						if(logger.isInfoEnabled()){
							logger.info("[End] -------------------------------------------------------------------------------------------------------------------"); 
						}
						
					}//  end if
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("파일내용이 비어있습니다.");
					}
				}
						
			} catch (IOException e) {
				ExceptionHandler.handle(e, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), methodName, null, null, null, JavaSourceParser.class);
			} catch (ParseException e) {
				ExceptionHandler.handle(e, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), methodName,null, null, null, null);
			} catch (NullPointerException e) {
				ExceptionHandler.handle(e, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), methodName,null, null, null, JavaSourceParser.class);
			} catch(Exception e){
				ExceptionHandler.handle(e, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), methodName,null, null, null, null);
			} catch(TokenMgrError e){
				ExceptionHandler.handle(null, AnalyzerStringUtil.setFileRootDir(file.getAbsolutePath()), methodName,null, null, null, JavaSourceParser.class);
			}
		}
		
		return sqlAnalyzeDataList;
	}
}
