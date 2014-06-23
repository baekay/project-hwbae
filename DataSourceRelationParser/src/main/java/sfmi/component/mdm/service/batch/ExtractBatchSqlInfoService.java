package sfmi.component.mdm.service.batch;

import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import parser.sql.SQLAnalyzerLexer;
import parser.sql.SQLAnalyzerParser;
import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.AnalyzerStringUtil;
import sfmi.component.mdm.common.util.PropertyLoader;
import sfmi.component.mdm.common.util.SqlFinder;
import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.dto.BatchReportDTO;
import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.ErrorDTO;
import sfmi.component.mdm.dto.JobBeanInfo;
import sfmi.component.mdm.dto.JobInfo;
import sfmi.component.mdm.dto.MethodInfo;
import sfmi.component.mdm.dto.ProcessorDaoInfo;
import sfmi.component.mdm.dto.ProcessorInfo;
import sfmi.component.mdm.dto.ReportDTO;
import sfmi.component.mdm.dto.SqlAnalyzeData;
import sfmi.component.mdm.dto.StepInfo;
import sfmi.component.mdm.dto.TableInfo;
import sfmi.component.mdm.dto.Writer;
import sfmi.component.mdm.exception.SqlFinderException;
import sfmi.component.mdm.handler.ExceptionHandler;
import sfmi.component.mdm.listener.BatchJobListener;
import sfmi.component.mdm.report.AnalysisResultReport;
import sfmi.component.mdm.report.ConsoleReport;
import sfmi.component.mdm.report.ErrorReport;
import sfmi.component.mdm.report.JobReport;
import sfmi.component.mdm.report.Report;

/**
 * 배치 sql정보 추출 서비스 
 * @author hwbae
 *
 */
public class ExtractBatchSqlInfoService {
	
	private static Logger logger = Logger.getLogger(ExtractBatchSqlInfoService.class);
	
	
	public void extract(String targetPath) {
		//time Listener
		BatchJobListener.timeListener(SQLAnalyzerConstants.START_TIME);
		
		BatchJobContext batchJobContext = BatchJobContext.getJobContext();
		batchJobContext.initJobContext();
		batchJobContext.setContextValue(SQLAnalyzerConstants.PRG_TYPE, SQLAnalyzerConstants.PRG_TYPE_BATCH);
		
		// propertyLoader
//		Properties propertyLoader = PropertyLoader.load();
//		String targetPath = propertyLoader.getProperty("target.source.path");
		
		
		// 대상 자바 파일만 추출하기위한 filter 선언
		Map<String, List<String>> filter = new HashMap<String, List<String>>();
		List<String> extendsNameList = new ArrayList<String>();
		extendsNameList.add(SQLAnalyzerConstants.EXTENDS_NAME_DAOSUPPORT);
		extendsNameList.add(SQLAnalyzerConstants.EXTENDS_NAME_PROCESSOR);
		extendsNameList.add(SQLAnalyzerConstants.EXTENDS_NAME_READER);
		extendsNameList.add(SQLAnalyzerConstants.EXTENDS_NAME_WRITER);
		
		filter.put(SQLAnalyzerConstants.EXTENDS_NAME, extendsNameList);
		
		// 자바 파싱 서비스 
		CollectBatchJavaInfoService collectJavaInfoService = new CollectBatchJavaInfoService();
		// XML 파싱 서비스 
		CollectBatchXmlInfoService collectXmlInfoService = new CollectBatchXmlInfoService();
		
		// 서비스 실행
		Map<String, List<ClassInfo>> classInfoMap = collectJavaInfoService.collectJavaFile(targetPath, filter);
		
		/*
		 * classInfo 분리 
		 */
		List<ClassInfo> daoClassInfoList = classInfoMap.get(SQLAnalyzerConstants.BATCH_DAO_CLASS);
		List<ClassInfo> processorClassInfoList = classInfoMap.get(SQLAnalyzerConstants.BATCH_PROCESSOR_CLASS);

		/*
		 * 필터가 없을 경우 각각의 리스트에 모든 자바 파일을 넣는다.
		 */
		if(daoClassInfoList.size() < 0 || daoClassInfoList == null){
			daoClassInfoList = classInfoMap.get(SQLAnalyzerConstants.BATCH_GENERAL_CLASS);
		} else if(processorClassInfoList.size() < 0 || processorClassInfoList == null){
			processorClassInfoList = classInfoMap.get(SQLAnalyzerConstants.BATCH_GENERAL_CLASS);
		} else {/* DO NOTHING */ }
		
		Map<String, List<AnalyzeData>> xmlAnalyzeDataList = collectXmlInfoService.collectXmlData(targetPath);
		Map<String, ReportDTO> reportMap = new HashMap<String, ReportDTO>();
				
		List<AnalyzeData> extractBatchJobList = null;
		List<AnalyzeData> extractSqlAnalyzeDataList = null;
				
		extractBatchJobList = xmlAnalyzeDataList.get("BATCH");
		extractSqlAnalyzeDataList = xmlAnalyzeDataList.get("SQL");
		
		/*
		 * XML 파일 중복제거 
		 */
		List<AnalyzeData> sqlAnalyzeDataList = new ArrayList<AnalyzeData>(new HashSet<AnalyzeData>(extractSqlAnalyzeDataList));
		List<AnalyzeData> batchJobList = new ArrayList<AnalyzeData>(new HashSet<AnalyzeData>(extractBatchJobList));

		// 패턴 정의, reader, writer, Processor
		Pattern dbReaderPattern = Pattern.compile("^db.*");
		Pattern dbWriterPattern = Pattern.compile("(.*)(ToDbStep)$");
		Pattern multiWriterPattern = Pattern.compile("(.*)(ToMultiStep)$");
		Pattern stepPattern = Pattern.compile("(.*)(To)(.*)(Step)$");
		
		Matcher readerMatcher;
		Matcher writerMatcher;
		Matcher multiWriterMatcher;
		Matcher processorMatcher;
		
		if(logger.isInfoEnabled()){
			logger.info("STEP TYPE을 추출하여 분석합니다");
		}
		
		
		JobInfo batchJob = null;
		// jobInfo의 step목록을 추출하여 DB관련 정보를 추출한다.
		for(AnalyzeData analyzeData : batchJobList) {
			batchJob = (JobInfo)analyzeData;
			if(batchJob.getStepList() != null){
				for(StepInfo stepInfo : batchJob.getStepList()){
					// step Type을 매칭한다.
					readerMatcher = dbReaderPattern.matcher(stepInfo.getStepType());
					writerMatcher = dbWriterPattern.matcher(stepInfo.getStepType());
					multiWriterMatcher = multiWriterPattern.matcher(stepInfo.getStepType());
					processorMatcher = stepPattern.matcher(stepInfo.getStepType());
					
					String jobId =  batchJob.getJobId();
					String jobXmlPath = batchJob.getJobXmlPath();
					String stepId = stepInfo.getStepId();
					
					// DB Reader 체크
					if(readerMatcher.matches()){
						
						if(logger.isInfoEnabled()){
							logger.info("TARGET STEP TYPE : "+stepInfo.getStepType());
						}
						
						// DbReaderHandler 호출
						reportMap.putAll(dbReaderStepHandle(stepInfo, daoClassInfoList, sqlAnalyzeDataList, 
								jobId, jobXmlPath));
						
					} else {
						if(logger.isDebugEnabled()){
							logger.debug(" Reader 대상 STEP이 아닙니다.." +stepInfo.getStepType());
						}
					}
					// DB Writer 체크	
					if (writerMatcher.matches()){
						
						if(logger.isInfoEnabled()){
							logger.info("TARGET STEP TYPE : "+stepInfo.getStepType());
						} 
						
						if(stepInfo.getProperties().containsKey("outDao")) {
							// DbWriterHandler 호출
							String outDao =  stepInfo.getProperties().get("outDao");
							
							reportMap.putAll(dbWriterStepHandle(outDao, daoClassInfoList, sqlAnalyzeDataList, 
									jobId, stepId, jobXmlPath));
						} else {
							logger.error("DB Writer에서 outDao 를 찾을 수 없습니다.");
						}
					
					} else {
						if(logger.isDebugEnabled()){
							logger.debug(" Writer 대상 STEP이 아닙니다.." +stepInfo.getStepType());
						}
						
					}// end Writer match
					
					// 멀티스텝 체크
					if(multiWriterMatcher.matches()){
						reportMap.putAll(multiWriterStepHandle(stepInfo, daoClassInfoList, sqlAnalyzeDataList, 
								jobId, jobXmlPath));
					} else {
						if(logger.isDebugEnabled()){
							logger.debug(" Multi Writer 대상 STEP이 아닙니다.." +stepInfo.getStepType());
						}
					} // end multi Writer match
					
				
					// SqlExecuteStep 체크
					if(("sqlExecuteStep").equals(stepInfo.getStepType())){
						reportMap.putAll(sqlExecuteStepHandle(stepInfo, jobId, jobXmlPath));
					} else {
						if(logger.isDebugEnabled()){
							logger.debug(" sqlExecute 대상 STEP이 아닙니다.." +stepInfo.getStepType());
						}
					}
					
					// Processor 체크
					if(processorMatcher.matches()){
						reportMap.putAll(processorHandle(batchJob.getBeanList(), stepInfo, daoClassInfoList, 
								processorClassInfoList, sqlAnalyzeDataList, jobId, jobXmlPath));
					} else {
						if(logger.isDebugEnabled()){
							logger.debug(" Processor 대상 STEP이 아닙니다.." +stepInfo.getStepType());
						}
					}
					
				}// for(stepInfo)
				
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("Step정보가 존재하지 않습니다..");
				}
			}
		}// for (batchJobList)	
		
		//time Listener
		BatchJobListener.timeListener(SQLAnalyzerConstants.END_TIME);
		
		// 결과 레포팅
		report(reportMap, targetPath);
	}
	
	
	/**
	 * Processor 처리 메소드
	 * @param stepInfo
	 * @param jobId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, ReportDTO> processorHandle(List<JobBeanInfo> jobBeanList, StepInfo stepInfo, 
			List<ClassInfo> daoClassInfoList, List<ClassInfo> processorClassInfoList, 
			List<AnalyzeData> sqlAnalyzeDataList, String jobId, String jobXmlPath){
		if(logger.isInfoEnabled()){
			logger.info(" Processor를 처리 합니다.." +stepInfo.getStepType());
		}
		
		/*
		 * 1. dbProecesor인지 판단 후 method 추출
		 * 		- analzyeProcessor() 호출
		 * 		- extractProcessInfo() 호출
		 * 
		 * 2. Dao에서 sqlAndXml 추출 
		 * 		- getSqlIdAndXmlPathInProcessor() 호출
		 * 
		 * 3. SQL 분석 하여 REPORT 
		 */		
		
		/*
		 * xml 리스트
		 */
		List<String> sqlXmlList;
		/*
		 * sqlIdList
		 */
		List<String> sqlIdList;
		/*
		 * Sql, Xml 추출 저장
		 */
		Map<String, Object> sqlAndXmlResultMap;
		Map<String, ReportDTO> reportMap = new HashMap<String, ReportDTO>();
		List<ProcessorDaoInfo> newProcessorDaoInfoList;
		ReportDTO reportDTO;
		
		String primarykey = null;
		String dot = ".";
		
		/*
		 * db관련 processor인지 판단한다
		 */
		ProcessorInfo processorInfo = analyzeProcessor(jobBeanList, stepInfo);
		
		/*
		 * dao관련 Processor
		 */
		if(processorInfo.isDbProcessor()){
			/*
			 * DAO가 사용하는 method 추출 
			 */
			List<ProcessorInfo> processorInfoList = extractProcessInfo(processorClassInfoList, processorInfo);
			
			for(ProcessorInfo newProcessorInfo : processorInfoList){
				// Processor의 daoList정보 추출
				newProcessorDaoInfoList = newProcessorInfo.getProcessorMethodAndDaoInfo();
				
				for(ProcessorDaoInfo newProcessorDaoInfo : newProcessorDaoInfoList){
					newProcessorInfo.getProcessorMethodAndDaoInfo();
					List<String> methodList = newProcessorDaoInfo.getMethodList();
					
					if(methodList != null && methodList.size() > 0){
						for(ClassInfo classInfo : daoClassInfoList){
							
							String qualifiedName = classInfo.getQualifiedName();
							String classLowFilePath = classInfo.getFileLowPath();
							String className = classInfo.getFileName();
							// 자바 파일과 vob명 비교
							if(qualifiedName.equals(newProcessorDaoInfo.getDaoClass())){
								
								for(MethodInfo methodInfo : classInfo.getMethodInfos()){
									for(String methodName : methodList){
										
										// Method Name비교								
										if(methodInfo.getName().equals(methodName)){
											/*
											 * method명이 같으면 DAO클래스 에서 sql정보 추출 
											 */
											if(logger.isInfoEnabled()){
												logger.info("[START]----------------------------------------------------------");
											}
											
											sqlAndXmlResultMap = getSqlIdAndXmlPathInProcessor(classInfo, methodInfo);
											
											if(logger.isInfoEnabled()){
												logger.info("[END]----------------------------------------------------------");
											}
											
											// 사용하는 SQL XML파일 및 SQL ID 정보 추출
											sqlXmlList = (List<String>)sqlAndXmlResultMap.get("XMLPATH");
											sqlIdList = (List<String>)sqlAndXmlResultMap.get("SQLID");
											String sqlIdAndXmlMethodName = (String)sqlAndXmlResultMap.get("METHOD_NAME");
											
											if(sqlXmlList != null && sqlXmlList.size() > 0){
												for(String xmlFilePathInProcessorDao : sqlXmlList){
													
													xmlFilePathInProcessorDao = xmlFilePathInProcessorDao.replace("/", "\\");
													SqlAnalyzeData sqlAnalyzeData = null;
													String realXmlFilePath = null;
													
													// SQL 관련 XML에서 추출한 XML을 찾는다.
													for(AnalyzeData sqlData : sqlAnalyzeDataList){
														sqlAnalyzeData = (SqlAnalyzeData)sqlData;
														realXmlFilePath = sqlAnalyzeData.getXmlFile();
														
														if(realXmlFilePath.contains(xmlFilePathInProcessorDao)){
															/*
															 * TargetDir을 지운 경로
															 */
															String rootFilePath = AnalyzerStringUtil.setFileRootDir(realXmlFilePath);
															
															// SQL File 내에 해당 SQL ID가 있는지 체크하여 존재할 경우 SQL 구문분석
															String query = null;
															
															for(String sqlId : sqlIdList){
																
																if(logger.isInfoEnabled()){
																	logger.info("SQL ID :"  + sqlId);
																}
																
																try{
																	query = SqlFinder.getSql(realXmlFilePath, sqlId);

																	/*
																	 * query를 파라미터로 넘긴 후 reportDTO를 리턴받는다.
																	 */
																	reportDTO = analzyerSql(query, SQLAnalyzerConstants.BATCH_PROCESSOR);
																	
																	((BatchReportDTO) reportDTO).setJobId(jobId);
																	((BatchReportDTO) reportDTO).setStepId(stepInfo.getStepId());
																	((BatchReportDTO) reportDTO).setFileType(SQLAnalyzerConstants.BATCH_PROCESSOR);
																	((BatchReportDTO) reportDTO).setSqlId(sqlId);
																	((BatchReportDTO) reportDTO).setParentMethod(newProcessorDaoInfo.getProcessorMethodSig());
																	((BatchReportDTO) reportDTO).setParentClass(newProcessorInfo.getProcessorClass().replace("\\", "/"));
																	((BatchReportDTO) reportDTO).setJobXmlPath(jobXmlPath.replace("\\", "/"));
																	reportDTO.setJavaFileName(className);
																	reportDTO.setJavaFileLowPath(classLowFilePath.replace("\\", "/"));
																	reportDTO.setMethodName(sqlIdAndXmlMethodName);
																	reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_BATCH);
																	reportDTO.setRegType("A");
																	reportDTO.setSql(query);
																	reportDTO.setXmlFile(rootFilePath.replace("\\", "/"));
																	
																	if(logger.isInfoEnabled()){
																		logger.info("\t결과를 저장합니다.. [ " + reportDTO + " ] ");
																	}
																	
																	// primaryKey값을 모두 합쳐서  Map의 Key로 만든다. 
																	primarykey = jobId + dot + stepInfo.getStepId() + dot + sqlId+dot+
																			classLowFilePath+dot+className+dot+sqlIdAndXmlMethodName+dot+
																			rootFilePath+dot+reportDTO.getSqlType()+
																			dot + newProcessorInfo.getProcessorClass() + 
																			dot + newProcessorDaoInfo.getProcessorMethodSig() + 
																			dot + jobXmlPath;
																	
																	/*
																	 * key가 존재 하지 않으면 report카운트 증가
																	 */
																	if(!reportMap.containsKey(primarykey)){
																		// report 카운트 
																		BatchJobListener.countListener(SQLAnalyzerConstants.REPORT_CNT);
																		
																		// reportDTO Map에 저장
																		reportMap.put(primarykey, reportDTO);
																		
																	} else {
																		// TODO :: 지우기
																		System.out.println("primaryKey : " + primarykey);
																		System.exit(0);
																	}
																	
																	
																	
//																	// 한글 제거
//																	query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
//																	
//																	// SQL 분석기 실행을 위한 객체 생성
//																	SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(new ANTLRStringStream(query));
//																	CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
//																	SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
//																	
//																	sqlParser.statement();
//																	// query 분석 성공 증가 
//																	BatchJobListener.countListener(SQLAnalyzerConstants.SQL_ANALYZE_SUCESS_CNT);
//																	
//																	// ReportDTO에 저장
//																	reportDTO = new BatchReportDTO();
//																	
//																	primarykey = sqlId+dot+qualifiedName+dot+methodName+dot+
//																			xmlFilePathInProcessorDao+dot+sqlParser.getStatementType() +
//																			newProcessorInfo.getProcessorClass() + 
//																			newProcessorDaoInfo.getProcessorMethod();
//																	
//																	// report 카운트 
//																	BatchJobListener.countListener(SQLAnalyzerConstants.REPORT_CNT);
//																	
//																	((BatchReportDTO) reportDTO).setJobId(jobId);
//																	((BatchReportDTO) reportDTO).setStepId(stepInfo.getStepId());
//																	((BatchReportDTO) reportDTO).setFileType(SQLAnalyzerConstants.BATCH_PROCESSOR);
//																	((BatchReportDTO) reportDTO).setParentMethod(newProcessorDaoInfo.getProcessorMethod());
//																	((BatchReportDTO) reportDTO).setParentClass(newProcessorInfo.getProcessorClass());
//																	reportDTO.setSqlId(sqlId);
//																	reportDTO.setColumnList(sqlParser.getColumnList()); 
//																	reportDTO.setJavaFile(qualifiedName);
//																	reportDTO.setMethodName(methodName);
//																	reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_BATCH);
//																	reportDTO.setRegType("A");
//																	reportDTO.setSql(query);
//																	reportDTO.setSqlType(sqlParser.getStatementType());
//																	reportDTO.setSelectTableList(sqlParser.getSelectTableList());
//																	reportDTO.setTableList(sqlParser.getTableList());
//																	reportDTO.setXmlFile(xmlFilePathInProcessorDao);
//																	
																	// reportDTO Map에 저장
//																	reportMap.put(primarykey, reportDTO);
																	
																} catch (RecognitionException e){ 
																	ExceptionHandler.handle(e, classLowFilePath+className, sqlIdAndXmlMethodName, rootFilePath ,sqlId, query ,null);
																} catch (FileNotFoundException e) {
																	ExceptionHandler.handle(e, classLowFilePath+className, sqlIdAndXmlMethodName,rootFilePath ,sqlId, query , SqlFinder.class);
																} catch (SqlFinderException e) {
																	ExceptionHandler.handle(e, classLowFilePath+className, sqlIdAndXmlMethodName,rootFilePath ,sqlId, query , SqlFinder.class);
																} catch (SAXException e) {
																	ExceptionHandler.handle(e, classLowFilePath+className, sqlIdAndXmlMethodName,rootFilePath ,sqlId, query , SqlFinder.class);
																} catch (IOException e) {
																	ExceptionHandler.handle(e, classLowFilePath+className, sqlIdAndXmlMethodName,rootFilePath ,sqlId, query , SqlFinder.class);
																} catch (ParserConfigurationException e) {
																	ExceptionHandler.handle(e, classLowFilePath+className, sqlIdAndXmlMethodName,rootFilePath ,sqlId, query , SqlFinder.class);
																} 
															}// end sqlIdList
														} else {
															if(logger.isDebugEnabled()){
																logger.debug("대상 XML 파일이 아닙니다.");
															}
														}
													} // end for sqlAnalyzeDataList
													
												} // end for xmlList
											} else {
												if(logger.isDebugEnabled()){
													logger.debug("Xml 리스트가 존재하지 않습니다.");
												}
											}
											
										} else {
											if(logger.isDebugEnabled()){
												logger.debug("method명이 일치하지 않습니다.");
											}
										}
									}// end methodList
								}// end methodInfos
							} else {
								if(logger.isDebugEnabled()){
									logger.debug("비교 대상 JAVA파일이 아닙니다..");
								}
							}
						} // end classInfoList
					} else {
						if(logger.isDebugEnabled()){
							logger.debug("Method가 존재하지 않습니다.");
						}
					}
				}// end daoProcessorInfoList
			}// end ProcessorInfoList
			
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("DB 관련 Processor가 아닙니다. Processor : " + processorInfo.getProcessorClass());
			}
		}
		
		return reportMap;
	}
	
	/**
	 * class에서 XML, SQLID, METHOD추출한다.
	 * @param classInfo
	 * @param methodInfo
	 * @return
	 */
	private Map<String, Object> getSqlIdAndXmlPathInProcessor(ClassInfo classInfo, MethodInfo methodInfo){
		if(logger.isInfoEnabled()){
			logger.info("\t [CLASS] : " + classInfo.getFileLowPath() + classInfo.getFileName() );
		}
		
		/*
		 * xml 리스트
		 */
		List<String> extractXmlPathList = new ArrayList<String>();
		/*
		 * SQL ID 리스트
		 */
		List<String> extractSqlIdList = new ArrayList<String>();
		/*
		 * 결과 저장
		 */
		Map<String, Object> xmlPathAndSqlId = new HashMap<String, Object>();		
		List<Statement> statements = null;
		
//		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+)(\\))(.*)");
		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+[^\\)])(\\))(.*);");
		Matcher matcher;
		
		BlockStmt blockStmt = methodInfo.getBlockStmt();
		String methodName = null;
		
		if(blockStmt != null){
			// 메소드 내의 각 statement추출
			statements = blockStmt.getStmts();
			
			if(statements !=null && statements.size() > 0){
				for(Statement statement : statements){
					
					//패턴 체크 
					matcher = useSqlFinderApiPattern.matcher(statement.toString());
					if(matcher.matches()){
						matcher.reset();
						
						while(matcher.find()) {
							methodName = methodInfo.getSignature();
							
							String xmlPath = matcher.group(3).trim();
							String sqlId = matcher.group(5).trim();
							
							// 따옴표 확인
							if(xmlPath.contains("\"")){
								// " 를 없애고 xmlList에 추가한다.
								xmlPath = xmlPath.replace("\"", "");
								xmlPath = xmlPath.trim();
								
								if(!("").equals(xmlPath) && !extractXmlPathList.contains(xmlPath)){
									extractXmlPathList.add(xmlPath);
									
									if(logger.isDebugEnabled()){
										logger.debug(" XML PATH : " + xmlPath);
									}
								} else {
									if(logger.isDebugEnabled()){
										logger.debug("이미 존재하는 XML입니다.");
									}
								}
								
							} else {
								/*
								 * method내에서 찾는다.
								 */
								//return xmlPath
								extractXmlPathList.addAll(returnBindingValue(blockStmt, xmlPath));
								
								//Class Field에서  찾는다..
								String classXmlPath = classInfo.getVariables().get(xmlPath);
								
								// 존재 여부 체크 
								if(classXmlPath != null && !("").equals(classXmlPath)){
									classXmlPath = classXmlPath.replace("\"", "");
									classXmlPath = classXmlPath.trim();
									
									if(!("").equals(classXmlPath)){
										extractXmlPathList.add(classXmlPath);
									}
						
								} else {
									if(logger.isDebugEnabled()){
										logger.debug(" CLASS FILED에 선언된 내용이 없습니다. : " + classXmlPath);
									}
								}
								
								if(logger.isDebugEnabled()){
									logger.debug(" XML PATH : " + extractXmlPathList);
								}		
								
							}
							
							if(sqlId.contains("\"")){
								// " 를 없애고 sqlIdList 에 추가한다.
								sqlId = sqlId.replace("\"", "");
								sqlId = sqlId.trim();
								
								if(!("").equals(sqlId)){
									extractSqlIdList.add(sqlId);
									
									if(logger.isDebugEnabled()){
										logger.debug(" SQL ID : " + sqlId);
									}
								}
								
							} else {
								/*
								 * method내에서 찾는다.
								 */
								
								//return sqlIdList
								extractSqlIdList.addAll(returnBindingValue(blockStmt, sqlId));
								
								//Class Field에서  찾는다..
								String classFieldSqlId = classInfo.getVariables().get(sqlId);
								
								// 문자열인지 체크한다.
								if(classFieldSqlId != null && !classFieldSqlId.equals("")){
									/*
									 * 비어있는경우 제외한다.
									 */
									classFieldSqlId = classFieldSqlId.replace("\"", "");
									classFieldSqlId = classFieldSqlId.trim();
									
									if(!("").equals(classFieldSqlId)){
										extractSqlIdList.add(classFieldSqlId);
									}
						
								} else {
									if(logger.isDebugEnabled()){
										logger.debug(" CLASS FILED에 선언된 내용이 없습니다. : " + classFieldSqlId);
									}
								}
								
								if(logger.isDebugEnabled()){
									logger.debug(" SQL ID : " + extractSqlIdList);
								}
							} // end else
						} //end while()
					} else {
						if(logger.isDebugEnabled()){
							logger.debug("SqlFinder 패턴이 일치하지 않습니다.");
						}
					}
				} // end statements
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("메서드 내용이 존재하지 않습니다.");
				}
			}
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("메서드 내용이 존재하지 않습니다.");
			}
		}
		
		/*
		 * 중복제거 
		 */
		List<String> sqlIdList = new ArrayList<String>(new HashSet<String>(extractSqlIdList));
		List<String> xmlPathList = new ArrayList<String>(new HashSet<String>(extractXmlPathList));
		
		if(logger.isInfoEnabled()){
			logger.info("\t SQL ID LIST : " + sqlIdList);
			logger.info("\t XML FILE LIST : " + xmlPathList);
		}
		
		xmlPathAndSqlId.put("XMLPATH", xmlPathList);
		xmlPathAndSqlId.put("SQLID", sqlIdList);
		xmlPathAndSqlId.put("METHOD_NAME", methodName);
		return xmlPathAndSqlId;
		
	}
	
	
	/**
	 * processor를 분석한다.
	 * db정보가 존재하는지 판단
	 * @return
	 */
	private ProcessorInfo analyzeProcessor(List<JobBeanInfo> jobBeanList,  StepInfo stepInfo){ 
		
		/*
		 * step의 processor정보
		 */
		ProcessorInfo processorInfo = new ProcessorInfo();
		/*
		 * processor내의 dao정보
		 */
		List<ProcessorDaoInfo> processorDaoInfoList = new ArrayList<ProcessorDaoInfo>();
		/*
		 * 각 dao정보
		 */
		ProcessorDaoInfo processorDaoInfo = null;
		/*
		 * 각 bean Property
		 */
		Map<String, String> beanProperty = null;
		
		/*
		 * 1. Step Property정보 추출
		 * 2. processor가 존재 유무 확인
		 * 3. Processor가 DB관련 processor인지 판단하여 processorInfo를 리턴한다.
		 */

		// step property정보 추출
		Map<String, String> stepProperty = stepInfo.getProperties();
		
		if(stepProperty != null){
			// processor 정보 추출
			String 	processorRef = stepProperty.get("processor");
			
			// processor가 존재 
			if(processorRef != null && !("").equals(processorRef)){
				if(logger.isInfoEnabled()){
					logger.info("processor : " + processorRef);
				}
				
				for(JobBeanInfo jobBeanInfo : jobBeanList){
					// beanId와 processorRef가 같다
					if(jobBeanInfo.getBeanId().equals(processorRef)){
						
						beanProperty = jobBeanInfo.getPropertyInfo();

						/*
						 * 프로세서 클래스명 저장 
						 */
						processorInfo.setProcessorClass(jobBeanInfo.getBeanClass());
						
						if(beanProperty.size() > 0 && !(beanProperty.isEmpty())){
							for(Map.Entry<String, String> property : beanProperty.entrySet()){
								// 프로퍼티 정보를 추출
								String propertyName = property.getKey();
								String propertyRef = property.getValue();
								
								//property ref와 beanId를 비교한다.
								for(JobBeanInfo beanInfo : jobBeanList){
									if(beanInfo.getBeanId().equals(propertyRef)){
										beanProperty = beanInfo.getPropertyInfo();
										
										if(beanProperty.size() > 0 && !(beanProperty.isEmpty())){
											// dataSource 정보 존재하는지 check
											if(beanProperty.containsKey("dataSource")){
												
												// 프로퍼티 저장
												processorDaoInfo = new ProcessorDaoInfo();
												processorDaoInfo.setDaoClass(beanInfo.getBeanClass());
												processorDaoInfo.setDaoName(propertyName);
												
												//daoInfoList에 저장
												processorDaoInfoList.add(processorDaoInfo);
												
												processorInfo.setProcessorMethodAndDaoInfo(processorDaoInfoList);
												
												if(logger.isInfoEnabled()){
													logger.info("PROCESSOR INFO : " + processorInfo);
												}
											} else {
												if(logger.isDebugEnabled()){
													logger.debug("dataSource가 존재하지 않습니다.");
												}
											}
										}else {
											if(logger.isDebugEnabled()){
												logger.debug("bean property 정보가 존재하지 않습니다.");
											}
											// bean property 정보가 없으므로 종료
											break;
										}
									}else {
										if(logger.isDebugEnabled()){
											logger.debug("bean Id와 processor정보가 일치하지 않습니다." + beanInfo.getBeanId());
										}
									}
								}// end for jobBeanList
							} // end for beanProperty
						} else {
							if(logger.isDebugEnabled()){
								logger.debug("bean property 정보가 존재하지 않습니다.");
							}
							// bean property 정보가 없으므로 종료
							break;
						}
					} else {
						if(logger.isDebugEnabled()){
							logger.debug("bean Id와 processor정보가 일치하지 않습니다." + jobBeanInfo.getBeanId());
						}
					}
				}// end for JobBeanList
				
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("processor 정보가 존재하지 않습니다..");
				}
			}
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("step정보가 존재하지 않습니다..");
			}
		}
		
		if(processorDaoInfo == null){
			processorInfo.setDbProcessor(false);
			
			if(logger.isDebugEnabled()){
				logger.debug("db관련 processor가 아닙니다. " + processorInfo.getProcessorClass());
			}
			
		} else {
			processorInfo.setDbProcessor(true);
			if(logger.isInfoEnabled()){
				logger.info("DB 관련 processor :  " + processorInfo.getProcessorClass());
			}
		}
		return processorInfo;
	}
	
	/**
	 * process() 메서드에서 사용하는 
	 * dao.XXX 메서드 추출
	 * @param classInfoList
	 * @param processorInfo
	 * @return
	 */
	private List<ProcessorInfo> extractProcessInfo(List<ClassInfo> processorClassInfoList, ProcessorInfo processorInfo){
		
		if(logger.isDebugEnabled()){
			logger.debug(" Processor를 분석하여 Dao메서드를 추출합니다." + processorInfo.getProcessorClass());
		}
		/*
		 * method를 추출하기 위한 matcher
		 */
		Matcher methodMatcher;
		
		List<Statement> statements = null;
		/*
		 * processor에서 추출한 methodList
		 */
		List<String> methodList = null;
		
		ProcessorDaoInfo processorDaoInfo = new ProcessorDaoInfo(); 
		ProcessorInfo newProcessorInfo = new ProcessorInfo();
		
		/*
		 * 최종 결과 저장 Map
		 */
		Map<String, ProcessorInfo> processorInfoMap = new HashMap<String, ProcessorInfo>();
		List<ProcessorDaoInfo> processorDaoInfoList;
		
		// processor내에 있는 메서드를 찾는다.
		for(ClassInfo classInfo : processorClassInfoList){
			if(processorInfo.getProcessorClass().equals(classInfo.getQualifiedName())){
				
				String classFilePath = classInfo.getRootFilePath();
				
				// process() method내에서 dao.XXX() 추출
				List<MethodInfo> methodInfoList = classInfo.getMethodInfos();
				
				if(methodInfoList != null && methodInfoList.size() >0){
					for(MethodInfo methodInfo : methodInfoList){
							
						// processor dao정보중 daoName을 추출하여 패턴 분석
						for(ProcessorDaoInfo daoInfo : processorInfo.getProcessorMethodAndDaoInfo()){
							String useDaoName = daoInfo.getDaoName();
							BlockStmt blockStmt = methodInfo.getBlockStmt();
							methodList = new ArrayList<String>();
							
							if(blockStmt != null){
								// method내의 statement추출
								statements = blockStmt.getStmts();
								
								if(statements != null && statements.size() > 0){
									for(Statement statement : statements){
										Pattern useDaoMethodPattern = Pattern.compile("(.*)?("+useDaoName+").([^\\(]\\w+)\\((.*)");
										
										String statementStr = statement.toString();
										// 개행제거
										statementStr = statementStr.replace("\n", "");
										statementStr = statementStr.replace("\r\n", "");
										methodMatcher = useDaoMethodPattern.matcher(statementStr);
										
										if(methodMatcher.matches()){
											String methodName = methodMatcher.group(3).trim();
											
											// 리스트에 존재하지 않으면
											if(!methodList.contains(methodName)){
												if(logger.isInfoEnabled()){
													logger.info("\t METHOD NAME : " + methodName);
												}
												
												// methodName add
												methodList.add(methodName);
												
											} else {
												if(logger.isDebugEnabled()){
													logger.debug("이미 존재하는 method명입니다.");
												}
											}
											
											newProcessorInfo = new ProcessorInfo();
											processorDaoInfo = new ProcessorDaoInfo();
											processorDaoInfoList = new ArrayList<ProcessorDaoInfo>();
											
											processorDaoInfo.setProcessorMethod(methodInfo.getName());
											processorDaoInfo.setProcessorMethodSig(methodInfo.getSignature());
											processorDaoInfo.setDaoClass(daoInfo.getDaoClass());
											processorDaoInfo.setDaoName(daoInfo.getDaoName());
											processorDaoInfo.setMethodList(methodList);
											
											processorDaoInfoList.add(processorDaoInfo);
											
											newProcessorInfo.setProcessorClass(classFilePath);
											newProcessorInfo.setProcessorMethodAndDaoInfo(processorDaoInfoList);
											processorInfoMap.put(methodInfo.getName()+useDaoName, newProcessorInfo);
											
										} else {
											if(logger.isDebugEnabled()){
												logger.debug("패턴이 일치하지 않습니다.");
											}
										}
									}//  end for Statements
								} else {
									if(logger.isDebugEnabled()){
										logger.debug("method 내용이 존재하지 않습니다.");
									}
								}
							} else {
								if(logger.isDebugEnabled()){
									logger.debug("method 내용이 존재하지 않습니다.");
								}
							}
						}// end for processorDaoInfoList
					} // end methodInfo
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("method정보가 존재하지 않습니다.");
					}
				}
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("대상 Processor파일이 아닙니다.");
				}
			}
		}// end classInfoList
		
		/*
		 * map정보의 Value값을 List정보로 변환 후 
		 * return 
		 */
		List<ProcessorInfo> resultProcessorInfoList = new ArrayList<ProcessorInfo>();
		
		for(Entry<String, ProcessorInfo> infoMap : processorInfoMap.entrySet()){
			resultProcessorInfoList.add(infoMap.getValue());
		}
		
		return resultProcessorInfoList;
	}
	
	
	
	/**
	 * SqlExcuteStep을 처리하는 메소드
	 * @param stepInfo
	 * @return
	 */
	private Map<String, ReportDTO> sqlExecuteStepHandle(StepInfo stepInfo, String jobId, String jobXmlPath){
		if(logger.isInfoEnabled()){
			logger.info(" sqlExecuteStep을 처리 합니다.." +stepInfo.getStepType());
		}
		
		Map<String, ReportDTO> reportMap = new HashMap<String, ReportDTO>();
		ReportDTO reportDTO;
		
		String query = stepInfo.getSql();
		
		if(query !=null){
			try{
				/*
				 * query를 파라미터로 넘긴 후 reportDTO를 리턴받는다.
				 */
				reportDTO = analzyerSql(query, SQLAnalyzerConstants.BATCH_EXECUTE_STEP);
				
				((BatchReportDTO) reportDTO).setJobId(jobId);
				((BatchReportDTO) reportDTO).setStepId(stepInfo.getStepId());
				((BatchReportDTO) reportDTO).setFileType(SQLAnalyzerConstants.BATCH_EXECUTE_STEP);
				((BatchReportDTO) reportDTO).setJobXmlPath(jobXmlPath.replace("\\", "/"));
				reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_BATCH);
				reportDTO.setRegType("A");
				reportDTO.setSql(query);
				
				if(logger.isInfoEnabled()){
					logger.info("\t결과를 저장합니다.. [ " + reportDTO + " ] ");
				}
				
				// primaryKey값을 모두 합쳐서  Map의 Key로 만든다. 
				String dot = ".";
				String primarykey = jobId+dot+stepInfo.getStepId()+dot+
						reportDTO.getSqlType() + dot + jobXmlPath + dot + query;
				
				/*
				 * key가 존재 하지 않으면 report카운트 증가
				 */
				if(!reportMap.containsKey(primarykey)){
					// report 카운트 
					BatchJobListener.countListener(SQLAnalyzerConstants.REPORT_CNT);
					
					// reportDTO Map에 저장
					reportMap.put(primarykey, reportDTO);
				}
				
			} catch (RecognitionException e) {
				// sqlExecuteStep은 sqlId가 없으므로 jobId+stepId로 넘긴다.
				ExceptionHandler.handle(e, null, null,jobXmlPath ,jobId+stepInfo.getStepId(), query ,null);
			}
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("QUERY가 존재하지 않습니다.");
			}
		}
		
		return reportMap;
	}
	
	
	/**
	 * MultiWriter Step을 처리하는 메소드
	 * 
	 * @param stepInfo
	 * @param classInfoList
	 * @param sqlAnalyzeDataList
	 */
	private Map<String, ReportDTO> multiWriterStepHandle(StepInfo stepInfo, List<ClassInfo> classInfoList, 
			List<AnalyzeData> sqlAnalyzeDataList, String jobId, 
			String jobXmlPath) {
		
		Map<String, ReportDTO> reportMap = new HashMap<String, ReportDTO>();
		if(stepInfo != null && stepInfo.getWriters() != null) {
			String writerClass = null;
			for(Writer writer : stepInfo.getWriters()) {
				// MultiWriter 중 DB Writer를 사용할 경우
				if(writer.getWriterProperties().containsKey("outDao")) {
					writerClass = writer.getWriterProperties().get("outDao");
					
					// Writer Class 에서 SQL 정보 추출
					reportMap = dbWriterStepHandle(writerClass, classInfoList, sqlAnalyzeDataList, 
							jobId, stepInfo.getStepId(), jobXmlPath);
				} else {
					writerClass = null;
				}
			}
		}
		
		return reportMap;
	}

	/**
	 * DB Writer(outDao) 에서 SQL 정보추출
	 * 
	 * @param outDao			DBWriter 클래스
	 * @param classInfoList	파싱된 클래스정보
	 */
	@SuppressWarnings({"unchecked"})
	private Map<String, ReportDTO> dbWriterStepHandle(String outDao, List<ClassInfo> classInfoList,
			List<AnalyzeData> sqlAnalyzeDataList, String jobId, String stepId, 
			String jobXmlPath) {
		
		List<String> sqlXmlList;
		List<String> sqlIdList;
		Map<String, Object> sqlInfo = null;
		String qualifiedName = null;
		
		Map<String, ReportDTO> reportMap = new HashMap<String, ReportDTO>();
		ReportDTO reportDTO;
		
		String primarykey = null;
		String dot = ".";
		
		for(ClassInfo classInfo : classInfoList) {
			qualifiedName = classInfo.getQualifiedName();
			String classFileLowPath = classInfo.getFileLowPath();
			String classFileName = classInfo.getFileName();
			
			// outDao 파일정보를 찾는다.
			if(qualifiedName != null && qualifiedName.equals(outDao)){
				// outDao에서 사용하는 SQL정보를 추출한다.
				
				if(logger.isInfoEnabled()){
					logger.info("[START]----------------------------------------------------------");
				}
				
				sqlInfo = getSqlIdAndXmlPathInWriter(classInfo);
				
				if(logger.isInfoEnabled()){
					logger.info("[END]----------------------------------------------------------");
				}
				
				// 사용하는 SQL XML 파일 및 SQL ID 정보추출
				sqlXmlList = (List<String>) sqlInfo.get("XMLPATH");
				sqlIdList = (List<String>) sqlInfo.get("SQLID");
				String methodName = (String)sqlInfo.get("METHOD_NAME");
				
				if( sqlXmlList.size() > 0){
					for(String sqlXmlFilePathInDao : sqlXmlList ) {
						sqlXmlFilePathInDao = sqlXmlFilePathInDao.replace("/", "\\");
						
						SqlAnalyzeData sqlAnalyzeData = null;
						String realXmlFilePath = null;
						
						// SQL 관련 XML에서 outDao에서 가져온 xml을 찾는다..
						for(AnalyzeData sqlData : sqlAnalyzeDataList){
							sqlAnalyzeData = (SqlAnalyzeData)sqlData;
							
							realXmlFilePath = sqlAnalyzeData.getXmlFile();
							
							if(realXmlFilePath.contains(sqlXmlFilePathInDao)) {
								
								/*
								 * TargetDir을 지운 경로
								 */
								String rootFilePath = AnalyzerStringUtil.setFileRootDir(realXmlFilePath);
								
								// SQL File 내에 해당 SQL ID가 있는지 체크하여 존재할 경우 SQL 구문분석
								String query = null;
								for(String sqlId : sqlIdList) {
									try {
										
										if(logger.isInfoEnabled()){
											logger.info("SQL ID를 분석합니다. SQL ID :  " + sqlId);
										}
										
										query = SqlFinder.getSql(realXmlFilePath, sqlId);
										
										/*
										 * query를 파라미터로 넘긴 후 reportDTO를 리턴받는다.
										 */
										reportDTO = analzyerSql(query, SQLAnalyzerConstants.BATCH_WRITER);
										
										((BatchReportDTO) reportDTO).setJobId(jobId);
										((BatchReportDTO) reportDTO).setStepId(stepId);
										((BatchReportDTO) reportDTO).setFileType(SQLAnalyzerConstants.BATCH_WRITER);
										((BatchReportDTO) reportDTO).setJobXmlPath(jobXmlPath.replace("\\", "/"));
										reportDTO.setSqlId(sqlId);
										reportDTO.setJavaFileLowPath(classFileLowPath.replace("\\", "/"));
										reportDTO.setJavaFileName(classFileName);
										reportDTO.setMethodName(methodName);
										reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_BATCH);
										reportDTO.setRegType("A");
										reportDTO.setSql(query);
										reportDTO.setXmlFile(rootFilePath.replace("\\", "/"));
										
										if(logger.isInfoEnabled()){
											logger.info("\t결과를 저장합니다.. [ " + reportDTO + " ] ");
										}
										
										// primaryKey값을 모두 합쳐서  Map의 Key로 만든다. 
										primarykey = jobId + dot+ stepId + dot+ sqlId+dot+classFileLowPath + dot 
												+classFileName+dot+methodName+dot+
												rootFilePath+dot+reportDTO.getSqlType() + jobXmlPath;
										
										/*
										 * key가 존재 하지 않으면 report카운트 증가
										 */
										if(!reportMap.containsKey(primarykey)){
											// report 카운트 
											BatchJobListener.countListener(SQLAnalyzerConstants.REPORT_CNT);
											
											// reportDTO Map에 저장
											reportMap.put(primarykey, reportDTO);
										} else {
											// TODO :: 지우기
											System.out.println("primaryKey : " + primarykey);
											System.exit(0);
										}
										
//										// 한글을 지운다.
//										query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
////										query = query.replaceAll("(\\#|\\$){1}(\\S+)(\\#|\\$){1}","\'\'");
////										query = query.replaceAll("'([^'\\s]+)'", "\'\'");
//										
//										// SQL 분석기 실행을 위한 객체 생성
//										SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(new ANTLRStringStream(query));
//										CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
//										SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
//										
//										sqlParser.statement();
//										// query 분석 성공 증가 
//										BatchJobListener.countListener(SQLAnalyzerConstants.SQL_ANALYZE_SUCESS_CNT);
//										
//
//										// ReportDTO에 저장
//										reportDTO = new BatchReportDTO();
//										primarykey = sqlId+dot+qualifiedName+dot+methodName+dot+sqlXmlFilePathInDao+dot+sqlParser.getStatementType();
//										
//										// report 카운트 
//										BatchJobListener.countListener(SQLAnalyzerConstants.REPORT_CNT);
//										
//										((BatchReportDTO) reportDTO).setJobId(jobId);
//										((BatchReportDTO) reportDTO).setStepId(stepId);
//										((BatchReportDTO) reportDTO).setFileType(SQLAnalyzerConstants.BATCH_WRITER);
//										reportDTO.setSqlId(sqlId);
//										reportDTO.setColumnList(sqlParser.getColumnList());
//										reportDTO.setJavaFile(qualifiedName);
//										reportDTO.setMethodName(methodName);
//										reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_BATCH);
//										reportDTO.setRegType("A");
//										reportDTO.setSql(query);
//										reportDTO.setSqlType(sqlParser.getStatementType());
//										reportDTO.setTableList(sqlParser.getTableList());
//										reportDTO.setSelectTableList(sqlParser.getSelectTableList());
//										reportDTO.setXmlFile(sqlXmlFilePathInDao);
//										
//										
//										if(logger.isInfoEnabled()){
//											logger.info("\t결과를 저장합니다.. [ " + reportDTO + " ] ");
//										}
//										
//										// reportDTO Map에 저장
//										reportMap.put(primarykey, reportDTO);
									} catch (RecognitionException e){ 
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName ,rootFilePath ,sqlId, query ,null);
									} catch (FileNotFoundException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName ,rootFilePath ,sqlId, query , SqlFinder.class);
									} catch (SqlFinderException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName ,rootFilePath ,sqlId, query , SqlFinder.class);
									} catch (SAXException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName ,rootFilePath ,sqlId, query , SqlFinder.class);
									} catch (IOException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName ,rootFilePath ,sqlId, query , SqlFinder.class);
									} catch (ParserConfigurationException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName ,rootFilePath ,sqlId, query , SqlFinder.class);
									} 
									
									
								}//end for(sqlList)
							} else {
								if(logger.isDebugEnabled()){
									logger.info("비교대상 XML 파일이 아닙니다.." );
								}
							}
						} // end for(sqlAnalyzeDataList)
					} // end for(sqlXmlList)
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("XML PATH를 찾을 수 없습니다..");
					}
				}
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("비교대상 JAVA 파일이 아닙니다..");
				}
			}
		} // end classInfo List
		return reportMap;
	}
	
	/**
	 * DbReader Step을 처리하는 메소드 
	 * InHelper에서 정보를 추출하여
	 * SQL을 파싱하여 분석한다.
	 */
	@SuppressWarnings("unchecked")
	private Map<String, ReportDTO> dbReaderStepHandle(StepInfo stepInfo, List<ClassInfo> classInfoList, 
			List<AnalyzeData> sqlAnalyzeDataList, String jobId, String jobXmlPath){
		
		List<String> xmlList = new ArrayList<String>();
		List<String> sqlIdList = new ArrayList<String>();
		
		Map<String,String> propertyInfo = new HashMap<String, String>();
		Map<String, Object> sqlInfoMap = null;
		Map<String, ReportDTO> reportMap = new HashMap<String, ReportDTO>();
		ReportDTO reportDTO;
		
		String primarykey = null;
		String dot = ".";
		
		// step의 property목록을 가져온다.
		propertyInfo = stepInfo.getProperties();
		String inHelperClass = propertyInfo.get("inHelper");
		
		// ClassInfo에서 javaFile을 찾는다.
		for(ClassInfo classInfo : classInfoList){
			String qualifiedName = classInfo.getQualifiedName();
			String classFileName = classInfo.getFileName();
			String classFileLowPath = classInfo.getFileLowPath();
			
			// classInfo의 javaFile의 qualifiedName과 비교해서 같으면 
			if(qualifiedName != null && qualifiedName.equals(inHelperClass)){
				
				if(logger.isInfoEnabled()){
					logger.info("[START]----------------------------------------------------------");
				}
				
				// ClassInfo를 파라미터로 넘겨 SQL정보를 추출한다.
				sqlInfoMap = getSqlIdAndXmlPathInReader(classInfo);
				
				if(logger.isInfoEnabled()){
					logger.info("[END]----------------------------------------------------------");
				}
				
				// 사용하는 SQL XML, SQL ID, METHOD NAME 정보추출
				xmlList = (List<String>) sqlInfoMap.get("XMLPATH");
				sqlIdList = (List<String>) sqlInfoMap.get("SQLID");
				String methodName = (String)sqlInfoMap.get("METHOD_NAME");
				
				if( xmlList != null ){
					for(String sqlXmlFilePathInHelper : xmlList ) {
						sqlXmlFilePathInHelper = sqlXmlFilePathInHelper.replace("/", "\\");
						
						SqlAnalyzeData sqlAnalyzeData = null;
						String realXmlFilePath = null;
						
						// SQL 관련 XML에서 outDao에서 가져온 xml을 찾는다..
						for(AnalyzeData sqlData : sqlAnalyzeDataList){
							sqlAnalyzeData = (SqlAnalyzeData)sqlData;
							
							realXmlFilePath = sqlAnalyzeData.getXmlFile();
							
							if(realXmlFilePath.contains(sqlXmlFilePathInHelper)) {
								
								/*
								 * TargetDir을 지운 경로
								 */
								String rootFilePath = AnalyzerStringUtil.setFileRootDir(realXmlFilePath);
								
								// SQL File 내에 해당 SQL ID가 있는지 체크하여 존재할 경우 SQL 구문분석
								String query = null;
								for(String sqlId : sqlIdList) {									
									try {
										query = SqlFinder.getSql(realXmlFilePath, sqlId);
										
										if(logger.isInfoEnabled()){
											logger.info("SQL ID를 분석합니다. SQL ID :  " + sqlId);
										}
										/*
										 * query를 파라미터로 넘긴 후 reportDTO를 리턴받는다.
										 */
										reportDTO = analzyerSql(query, SQLAnalyzerConstants.BATCH_READER);
										
										((BatchReportDTO) reportDTO).setJobId(jobId);
										((BatchReportDTO) reportDTO).setStepId(stepInfo.getStepId());
										((BatchReportDTO) reportDTO).setFileType(SQLAnalyzerConstants.BATCH_READER);
										((BatchReportDTO) reportDTO).setJobXmlPath(jobXmlPath.replace("\\", "/"));
										reportDTO.setSqlId(sqlId);
										reportDTO.setJavaFileName(classFileName);
										reportDTO.setJavaFileLowPath(classFileLowPath.replace("\\", "/"));
										reportDTO.setMethodName(methodName);
										reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_BATCH);
										reportDTO.setRegType("A");
										reportDTO.setSql(query);
										reportDTO.setXmlFile(rootFilePath.replace("\\", "/"));
										
										
										if(logger.isInfoEnabled()){
											logger.info("\t결과를 저장합니다.. [ " + reportDTO + " ] SQL ID : " + sqlId);
										}
										
										// primaryKey값을 모두 합쳐서  Map의 Key로 만든다. 
										primarykey = jobId + dot + stepInfo.getStepId() + dot+ sqlId+dot+
												classFileName+dot + classFileLowPath+dot+methodName+dot+
												rootFilePath+dot+reportDTO.getSqlType() + dot +jobXmlPath;
										
										/*
										 * key가 존재 하지 않으면 report카운트 증가
										 */
										if(!reportMap.containsKey(primarykey)){
											// report 카운트 
											BatchJobListener.countListener(SQLAnalyzerConstants.REPORT_CNT);
											
											// reportDTO Map에 저장
											reportMap.put(primarykey, reportDTO);
										} else {
											// TODO : 지우기
											System.out.println("primaryKey : " + primarykey);
											System.exit(0);
										}
										
										
										
//										// '' 따옴표 내의 한글을 지운다.
//										queryReplace = query.replaceAll("(\')[ㄱ-ㅎㅏ-ㅣ가-힣]+(\')", "\'\'");
//										
//										// SQL 분석기 실행을 위한 객체 생성
//										SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(new ANTLRStringStream(queryReplace));
//										CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
//										SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
//										
//										sqlParser.statement();
//										
//										// query 분석 성공 증가 
//										BatchJobListener.countListener(SQLAnalyzerConstants.SQL_ANALYZE_SUCESS_CNT);
//									
//										// ReportDTO에 저장
//										reportDTO = new BatchReportDTO();
//										
//										// report 카운트 
//										BatchJobListener.countListener(SQLAnalyzerConstants.REPORT_CNT);
										
										
									} catch (RecognitionException e){ 
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName,rootFilePath ,sqlId, query ,null);
									} catch (FileNotFoundException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName,rootFilePath ,sqlId, query , null);
									} catch (SqlFinderException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName,rootFilePath ,sqlId, query , null);
									} catch (SAXException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName,rootFilePath ,sqlId, query , null);
									} catch (IOException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName,rootFilePath ,sqlId, query , SqlFinder.class);
									} catch (ParserConfigurationException e) {
										ExceptionHandler.handle(e, classFileLowPath+classFileName, methodName,rootFilePath ,sqlId, query , null);
									} 
								}//end for(sqlList)
							} else {
								if(logger.isDebugEnabled()){
									logger.debug("비교대상 XML 파일이 아닙니다.");
								}
							}
						} // end for(sqlAnalyzeDataList)
					} // end for(sqlXmlList)
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("XML PATH를 찾을 수 없습니다..");
					}
				}
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("비교대상 JAVA 파일이 아닙니다.");
				}
			}
		} // end classInfo List
		
		return reportMap;
}
	
	/**
	 * outDao클래스 정보를 파라미터로 받아 
	 * XML Path와 SQL ID를 추출하여 리턴한다.
	 * @param classInfo
	 * @return
	 * @throws NullPointerException
	 */
	private Map<String, Object> getSqlIdAndXmlPathInWriter(ClassInfo classInfo) {
		/**
		 * outDao클래스 내에서 SqlFinder.getSql( , )을 패턴으로 추출한다.
		 *  1. " 여부 확인 
		 *  	if(존재시 사용)
		 *  	else (Statement 에서 변수값 바인딩 추출) -> 메소드 내에서 or 클래스 내에서 
		 */
		Map<String, Object> xmlPathAndSqlId = new HashMap<String, Object>();
		List<String> extractXmlPathList = new ArrayList<String>();
		List<String> extractSqlIdList = new ArrayList<String>();
		String methodName = null;
		
//		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+)(\\))");
//		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+)(\\))(.*)");
		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+[^\\)])(\\))(.*);");
		
		Matcher matcher;
		
		if(logger.isDebugEnabled()){
			logger.debug("\t DBWriter : SQL ID와 XML FILE PATH를 추출합니다.."+classInfo.getQualifiedName());
		}
		
		for(MethodInfo methodInfo : classInfo.getMethodInfos()){
			BlockStmt blockStmt = methodInfo.getBlockStmt();
				if(blockStmt.getStmts() != null){	
					for(Statement statement : blockStmt.getStmts()){			
						
						matcher = useSqlFinderApiPattern.matcher(statement.toString());		
						
						if(matcher.find()){
							// method명 저장 
							methodName = methodInfo.getSignature();
							
							matcher.reset();
							
							while(matcher.find()) {
								
								String xmlPath = matcher.group(3).trim();
								String sqlId = matcher.group(5).trim();
								
								// 따옴표 확인
								if(xmlPath.contains("\"")){
									// " 를 없애고 xmlList에 추가한다.
									xmlPath = xmlPath.replace("\"", "");
									xmlPath = xmlPath.trim();
									
									if(!extractXmlPathList.contains(xmlPath)){
										extractXmlPathList.add(xmlPath);
										
										if(logger.isDebugEnabled()){
											logger.debug("XML PATH : " + xmlPath);
										}
										
									} else {
										if(logger.isDebugEnabled()){
											logger.debug("이미 존재하는 XML PATH 입니다..");
										}
									}
									
								} else {
									/*
									 * method내에서 찾는다.
									 */
									//return xmlPath
									extractXmlPathList.addAll(returnBindingValue(blockStmt, xmlPath));
									
									//Class Field에서  찾는다..
									String classXmlPath = classInfo.getVariables().get(xmlPath);
									
									if(classXmlPath != null && !("").equals(classXmlPath)){
										classXmlPath = classXmlPath.replace("\"", "");
										classXmlPath = classXmlPath.trim();
										
										// 존재 할때
										if(!("").equals(classXmlPath)){
											extractXmlPathList.add(classXmlPath);
										}
							
									} else {
										if(logger.isDebugEnabled()){
											logger.debug(" CLASS FILED에 선언된 내용이 없습니다. : " + classXmlPath);
										}
									}
									
									if(logger.isDebugEnabled()){
										logger.debug(" XML PATH : " + extractXmlPathList);
									}		
								} // end xml Path 저장
								
								
								if(sqlId.contains("\"")){
									// " 를 없애고 sqlIdList 에 추가한다.
									sqlId = sqlId.replace("\"", "");
									sqlId = sqlId.trim();
									
									if(!("").equals(sqlId) && !extractSqlIdList.contains(sqlId)){
										extractSqlIdList.add(sqlId);
										
										if(logger.isDebugEnabled()){
											logger.debug(" SQL ID : " + sqlId);
										}
									} else {
										if(logger.isDebugEnabled()){
											logger.debug("이미 존재하는 SQLID입니다.");
										}
									}
								} else {
									/*
									 * method내에서 찾는다.
									 */
									
									//return sqlIdList
									extractSqlIdList.addAll(returnBindingValue(blockStmt, sqlId));
									
									//Class Field에서  찾는다..
									String classFieldSqlId = classInfo.getVariables().get(sqlId);
									
									// 문자열인지 체크한다.
									if(classFieldSqlId != null && !classFieldSqlId.equals("")){
										classFieldSqlId = classFieldSqlId.replace("\"", "");
										classFieldSqlId = classFieldSqlId.trim();
										
										if(!("").equals(classFieldSqlId)){
											extractSqlIdList.add(classFieldSqlId);
										}
							
									} else {
										if(logger.isDebugEnabled()){
											logger.debug(" CLASS FILED에 선언된 내용이 없습니다. : " + classFieldSqlId);
										}
									}
									
									if(logger.isDebugEnabled()){
										logger.debug(" SQL ID : " + extractSqlIdList);
									}
									
								}
							} //end while()
						} else {
							if(logger.isDebugEnabled()){
								logger.debug("패턴이 일치하지 않습니다...");
							}
						}
					} //end for(Stmt)
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("\tMethod의 내용이 비어있습니다.");
					}
				}
			} // end for(method)
			
			if(logger.isDebugEnabled()){
				logger.debug("\tXML PATH : "+  extractXmlPathList + ", SQL ID : " + extractSqlIdList);
			}
		
		/*
		 * 중복제거 
		 */
		List<String> sqlIdList = new ArrayList<String>(new HashSet<String>(extractSqlIdList));
		List<String> xmlFilePathList = new ArrayList<String>(new HashSet<String>(extractXmlPathList));
		
		if(logger.isDebugEnabled()){
			logger.debug("\t SQL ID LIST  : "+  sqlIdList);
			logger.debug("\t XML FIL LIST : "+ extractSqlIdList);
		}
		
		// 결과에 저장 후 리턴 
		xmlPathAndSqlId.put("XMLPATH", xmlFilePathList);
		xmlPathAndSqlId.put("SQLID", sqlIdList);
		xmlPathAndSqlId.put("METHOD_NAME", methodName);
		
		return xmlPathAndSqlId;
	}
	
	
	/**
	 * InHelper클래스 정보를 파라미터로 받아 
	 * SQL관련 XML과 SQLID를 추출하여 리턴한다.
	 * @return
	 */
	private  Map<String, Object> getSqlIdAndXmlPathInReader(ClassInfo classInfo) {

		/**
		 *  inHelper 에서 데이터 추출 
		 * 
		 * 1. String[]{   ,   } 패턴으로 추출...
		 *   1-1. 추출이 되었을경우 각각 따옴표여부 추가확인
		 *       if (존재할 경우 그대로) 사용
		 *       else (존재하지 않을경우) Statement 에서 변수값 바인딩 추출
		 * 2. 1번으로 추출이 안 되었을 경우 word[Digit] 패턴으로 추출
		 *    (return 되는 변수명을 word 키워드로 사용)
		 *   2-1. 추출이 되었을경우 각각 따옴표여부 추가확인
		 *   	 if (존재할 경우 그대로) 사용 -> Loop 돌려서 List에 넣는다
		 *   	 else (존재하지 않을경우) Statement 에서 변수값 바인딩 추출
		 *   
		 */
		if(logger.isDebugEnabled()){
			logger.debug("\t DBReader : SQL ID와 XML FILE PATH를 추출합니다.."+classInfo.getQualifiedName());
		}

		// 클래스의 메소드 정보를 추출한다.
		List<MethodInfo> methodList = classInfo.getMethodInfos();
		// 리턴 객체
		Map<String, Object> xmlPathAndSqlId = new HashMap<String, Object>();
		
		// 결과 저장 객체
		List<String> extractXmlFilePathList = new ArrayList<String>();
		List<String> extractSqlIdList = new ArrayList<String>();
		
		// String[] { , } 찾는 패턴
		Pattern assignInBracePattern = Pattern.compile("(.*)?(String(\\s+)?\\[(\\s+)?\\](.*)?\\{)(.*)(,)(.*)(\\}.*)");
		Pattern assignOneStringPattern;
		// sql[0] = "ABCD.xml" 찾는 패턴
		Pattern assignEachArrayPattern;
		Matcher matcher;
		String methodName = null;
		
		for(MethodInfo methodInfo : methodList) {
			if(methodInfo.getName().equals("getSqlInfo")) {
				BlockStmt blockStmt = methodInfo.getBlockStmt();

				for(Statement statement : blockStmt.getStmts()) {
					matcher = assignInBracePattern.matcher(statement.toString());
					
					if(matcher.find()) {
						
						matcher.reset();
						
						while(matcher.find()){
								
							// method명 저장 
							methodName = methodInfo.getSignature();
							
							String xmlPath = matcher.group(6).trim();
							String sqlId = matcher.group(8).trim();
							
							if(logger.isDebugEnabled()){
								logger.debug("XMLPATH : " + xmlPath);
								logger.debug("sqlId : " + sqlId);
							}
							
							// xmlpath 따옴표 존재 
							if(xmlPath.contains("\"")){
								// 따옴표 제거 후 add
								xmlPath = xmlPath.replace("\"", "");
								xmlPath = xmlPath.trim();
								
								extractXmlFilePathList.add(xmlPath);
								
							} else {
								
								/*
								 * method내에서 찾는다.
								 */
								//return xmlPath
								extractXmlFilePathList.addAll(returnBindingValue(blockStmt, xmlPath));
								
								//Class Field에서  찾는다..
								String classXmlPath = classInfo.getVariables().get(xmlPath);
								
								// 존재 여부 체크 
								if(classXmlPath != null && !("").equals(classXmlPath)){
									/*
									 * 비어있는경우 제외 
									 */
									classXmlPath = classXmlPath.replace("\"", "");
									classXmlPath = classXmlPath.trim();
									
									if(!("").equals(classXmlPath)){
										extractXmlFilePathList.add(classXmlPath);
									} 
						
								} else {
									if(logger.isDebugEnabled()){
										logger.debug(" CLASS FILED에 선언된 내용이 없습니다. : " + classXmlPath);
									}
								}
								
								if(logger.isDebugEnabled()){
									logger.debug(" XML PATH : " + classXmlPath);
								}
								
							}// end XML PATH에 ""가 없을때
							
							// sqlId 따옴표 존재 
							if(sqlId.contains("\"")){
								// 따옴표 제거 후 add
								sqlId = sqlId.replace("\"", "");
								sqlId = sqlId.trim();
								
								if(!extractSqlIdList.contains(sqlId)){
									extractSqlIdList.add(sqlId);
									
									if(logger.isDebugEnabled()){
										logger.debug(" SQL ID : " + sqlId);
									}
								} else {
									if(logger.isDebugEnabled()){
										logger.debug("이미 존재하는 SQLID입니다.");
									}
								}
								
							} else {
								/*
								 * method내에서 찾는다.
								 */
								
								//return sqlIdList
								extractSqlIdList.addAll(returnBindingValue(blockStmt, sqlId));
								
								//Class Field에서  찾는다..
								String classFieldSqlId = classInfo.getVariables().get(sqlId);
								
								// 문자열인지 체크한다.
								if(classFieldSqlId != null && !classFieldSqlId.equals("")){
									/*
									 * 비어있는 경우 제외
									 */
									classFieldSqlId = classFieldSqlId.replace("\"", "");
									classFieldSqlId = classFieldSqlId.trim();
									
									if(!("").equals(classFieldSqlId)){
										extractSqlIdList.add(classFieldSqlId);
									}
						
								} else {
									if(logger.isDebugEnabled()){
										logger.debug(" CLASS FILED에 선언된 내용이 없습니다. : " + classFieldSqlId);
									}
								}
								
								if(logger.isDebugEnabled()){
									logger.debug(" SQL ID : " + extractSqlIdList);
								}
								
							}// end else
							
						}// end while
						
					} else{
						// return variable 값 추출
						String returnVariable = returnVariable(blockStmt);
						
						// return variable값이 온전한 문자 인지 체크
						assignOneStringPattern = Pattern.compile("(\\s)+ | (\\W)");
						
						// return variable값이 있을때만 체크 
						if(returnVariable != null && !("").equals(returnVariable)){
							Matcher assignOneMatcher = assignOneStringPattern.matcher(returnVariable);
							/*
							 * 패턴이 포함이면 올바르지 않은 return variable값이다
							 */
							if(!assignOneMatcher.find()){
								
								//return value값으로 returnValue[0] = "~.xml"; 을 찾는다 
								assignEachArrayPattern = Pattern.compile("(.*)?("+returnVariable+")(\\[)(\\d)(\\])(\\s\\=\\s)(.*)(;)");
								
								/*
								 * 개행문자 제거 
								 */
//							String beforeReplaceStr = statement.toString();
//							String afterStr = beforeReplaceStr.replace("\n", "");
//							afterStr = afterStr.replace("\r\n", "");
								
								Matcher arrayMatcher = assignEachArrayPattern.matcher(statement.toString());
								
								if(arrayMatcher.find()) {
									
									// index 초기화 
									arrayMatcher.reset();
									
									while(arrayMatcher.find()){
										String sqlInfoValue = arrayMatcher.group(7);
										String index = arrayMatcher.group(4);
										
										
										// xmlPath인지 sqlId 인지 판단
										if(index.equals("0")){
											// 따옴표 존재 
											if(sqlInfoValue.contains("\"")){
												sqlInfoValue = sqlInfoValue.replace("\"", "");
												sqlInfoValue = sqlInfoValue.trim();
												
												if(!("").equals(sqlInfoValue)){
													extractXmlFilePathList.add(sqlInfoValue);
													if(logger.isDebugEnabled()){
														logger.debug(" SQL ID : " + sqlInfoValue);
													}
												}
												
											} else {
												extractXmlFilePathList.addAll(returnBindingValue(blockStmt, sqlInfoValue));
											}
										} else if(index.equals("1")){
											// 따옴표 존재 
											if(sqlInfoValue.contains("\"")){
												sqlInfoValue = sqlInfoValue.replace("\"", "");
												sqlInfoValue = sqlInfoValue.trim();
												
												if(!("").equals(sqlInfoValue)){
													extractSqlIdList.add(sqlInfoValue);
													if(logger.isDebugEnabled()){
														logger.debug(" SQL ID : " + sqlInfoValue);
													}
												}
												
											} else {
												extractSqlIdList.addAll(returnBindingValue(blockStmt, sqlInfoValue));
											}
											
											
										} else {
											if(logger.isDebugEnabled()){
												logger.debug("패턴이 일치하지 않습니다.");
											}
										}
										
										
										if(logger.isDebugEnabled()){
											logger.info("SQL ID LIST : " + extractSqlIdList + "XML FILE LIST : " + extractXmlFilePathList);
											
										}
										
									} //end while
									
								}else {
									if(logger.isDebugEnabled()){
										logger.debug("패턴이 일치하지 않습니다.");
									}
								} // sql[0] 패턴 체크
							} else{
								if(logger.isDebugEnabled()){
									logger.debug("return value값이 올바른 형태가 아닙니다.");
								}
							}// return value값이 올바른 형태인지 체크
						} else {
							if(logger.isDebugEnabled()){
								logger.debug("return value값이 존재하지 않습니다.");
							}
						}
					}// end else, 2가지 패턴 일치가 아님 
				}// end for statement
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("getSqlInfo method가 아닙니다.");
				}
			}
		}// end for method Info
		
		/*
		 * 중복제거 
		 */
		List<String> sqlIdList = new ArrayList<String>(new HashSet<String>(extractSqlIdList));
		List<String> xmlFilePathList = new ArrayList<String>(new HashSet<String>(extractXmlFilePathList));
		
		if(logger.isInfoEnabled()){
			logger.info("SQL ID LIST : " + extractSqlIdList);
			logger.info("XML FILE LIST : " + extractXmlFilePathList);
			
		}
		
		// 결과에 저장 후 리턴 
		xmlPathAndSqlId.put("XMLPATH",xmlFilePathList);
		xmlPathAndSqlId.put("METHOD_NAME", methodName);
		xmlPathAndSqlId.put("SQLID",sqlIdList);
		
	 return xmlPathAndSqlId;
}
	/**
	 * sql을 파라미터로 받아 분석 후 
	 * ReportDTO로 리턴
	 * @param query
	 * @return
	 * @throws RecognitionException 
	 */
	private ReportDTO analzyerSql(String query, String batchType) throws RecognitionException{

		ReportDTO reportDTO = new BatchReportDTO();
		List<TableInfo> tableInfoList = new ArrayList<TableInfo>(); 
		TableInfo tableInfo;
		
		if(query != null){
			query = query.replaceAll("(\')[ㄱ-ㅎㅏ-ㅣ가-힣]+(\')", "\'\'");
			
			// SQL 분석기 실행을 위한 객체 생성
			SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(new ANTLRStringStream(query));
			CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
			SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
			
			sqlParser.statement();
			
			// query 분석 성공 증가 
			BatchJobListener.countListener(SQLAnalyzerConstants.SQL_ANALYZE_SUCESS_CNT);
			
			List<String> selectTableList = sqlParser.getSelectTableList();
			List<String> tableList = sqlParser.getTableList();
			
			/*
			 * tableInfo에 저장 후 리스트에 추가
			 */
			if(tableList.size() > 0){
				String tableName = tableList.get(0);
				/*
				 * selectTable명이 같은게 존재하면 제거 
				 */
				if( selectTableList.contains(tableName) ){
					selectTableList.remove(tableName);
				}
				
				tableInfo = new TableInfo();
				tableInfo.setTableName(tableName);
				tableInfo.setColumnList(sqlParser.getColumnList());
				tableInfoList.add(tableInfo);
				
				if (selectTableList.size() > 0 ){
					for(String selectTableName : selectTableList){
						tableInfo = new TableInfo();
						tableInfo.setTableName(selectTableName);
						tableInfoList.add(tableInfo);
					}// end for
				} else {
					if(logger.isDebugEnabled()){
						logger.debug("SELECT TABLE이 존재하지 않습니다.");
					}
				}
					
			} else if(selectTableList.size() > 0) {
				for(String selectTableName : selectTableList){
					tableInfo = new TableInfo();
					tableInfo.setTableName(selectTableName);
					tableInfoList.add(tableInfo);
				}
			}
			
			// ReportDTO에 저장
			((BatchReportDTO) reportDTO).setFileType(batchType);
			reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_BATCH);
			reportDTO.setRegType("A");
			reportDTO.setSql(query);
			reportDTO.setSqlType(sqlParser.getStatementType());
			reportDTO.setTableInfoList(tableInfoList);
			reportDTO.setSystemId(BatchJobContext.getJobContext().getContextValue(SQLAnalyzerConstants.SYSTEM_ID).toString());
			
			
			/*
			 * 각 sqlType 개수 증가
			 */
			String sqlType = sqlParser.getStatementType();
			if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_SELECT)){
				BatchJobListener.countListener(SQLAnalyzerConstants.SELECT_SQL_CNT);
			} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_UPDATE)){
				BatchJobListener.countListener(SQLAnalyzerConstants.UPDATE_SQL_CNT);
			} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_DELETE)){
				BatchJobListener.countListener(SQLAnalyzerConstants.DELETE_SQL_CNT);
			} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_INSERT)){
				BatchJobListener.countListener(SQLAnalyzerConstants.INSERT_SQL_CNT);
			} else if(sqlType.equals(SQLAnalyzerConstants.SQL_TYPE_MERGE)){
				BatchJobListener.countListener(SQLAnalyzerConstants.MERGE_SQL_CNT);
			}
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("QUERY가 NULL 입니다.");
			}
		}
		return reportDTO;
	}
	
	/**
	 * binding된 변수의 Value를 찾는다..
	 * @param variable
	 * @return
	 */
	private List<String> returnBindingValue(BlockStmt blockStmt, String variable){
		// return 객체
		List<String> valueList = new ArrayList<String>();
		// 패턴
		String findVariableValue = "(.*)?("+variable+"){1}(\\s\\=\\s)(\")(.*)(\")";
		Pattern findVariableValuePattern = Pattern.compile(findVariableValue);
		Matcher matcher;
		
		if(logger.isDebugEnabled()){
			logger.debug("METHOD에서 variable추출합니다.");
		}
		
		//Statement 분석하여 value값 추출 
		for(Statement state : blockStmt.getStmts()){
			
			/*
			 * 개행제거
			 */
//			String beforeReplaceStr = state.toString();
//			String afterStr = beforeReplaceStr.replace("\n", "");
//			afterStr = afterStr.replace("\r\n", "");
			
			matcher = findVariableValuePattern.matcher(state.toString());
			
			// 패턴일치
			if(matcher.find()){
				matcher.reset();
				
				while(matcher.find()){
					String matcherValue = matcher.group(5).trim();
					if(matcherValue != null && !("").equals(matcherValue)){
						
						if(!valueList.contains(matcherValue)){
							
							if(logger.isDebugEnabled()){
								logger.debug("\t matcherValue : " + matcherValue);
							}
							
							valueList.add(matcherValue);
						} 
					}
				}
				
			} else {
				if(logger.isDebugEnabled()){
					logger.debug("METHOD내에서 패턴이 일치하지 않습니다.");
				}
			}
		}// end for
		
		return valueList;
		
	}
	
	/**
	 * return Variable값 추출
	 * @return
	 */
	private String returnVariable(BlockStmt blockStmt){
		Pattern assignReturnValuePattern = Pattern.compile("(return)(.*)(;)");
		Matcher matcher;
		String returnVariable = null;
		
		//return variable 값 리턴 
		for(Statement state : blockStmt.getStmts()){
			matcher = assignReturnValuePattern.matcher(state.toString());
			
			if(matcher.find()){
				returnVariable = matcher.group(2).trim();
				return returnVariable;
			} else {

			}
		}
		return returnVariable;
	}
	
	/**
	 * 결과 레포팅 메소드 
	 * @param targetPath 
	 */
	private void report(Map<String,ReportDTO> reportMap, String targetPath){
		// propertyLoader
		Properties propertyLoader = PropertyLoader.load();
		String programClassify = propertyLoader.getProperty("target.source.type");
		// Map의 결과를 List로 변경한다.
		List<ReportDTO> reportList = new ArrayList<ReportDTO>(reportMap.values());

		Report consoleReport = new ConsoleReport();
		consoleReport.report(reportList);
		
		//결과 db에 저장
		Report dbReport = new AnalysisResultReport();
		dbReport.report(reportList);
		
		// error 콘솔에 출력
		ErrorReport errorReport = new ErrorReport();
		List<ErrorDTO> errorList = new ArrayList<ErrorDTO>(ExceptionHandler.getErrorDTOMap().values());
		ExceptionHandler.setInitErrorDTOMap();
		errorReport.errorReportConsole(errorList);
		
		// error db에 저장
		errorReport.errorReportDb(errorList);
		
		System.out.println("┏────────────────────────────────────────────────────────────────┓");
		System.out.println("│");
		System.out.println("│    [ 수행결과 ]");
		System.out.println("│");
		System.out.println("│    TARGET DIRECTORY : " + targetPath);
		System.out.println("│    PROGRAM CLASSIFY : " + programClassify);
		System.out.println("│    SUCCESS COUNT : " + reportList.size());
		System.out.println("│    FAIL    COUNT : " + errorList.size());
		System.out.println("│");
		System.out.println("┗────────────────────────────────────────────────────────────────┛");
		
		// job Report
		JobReport.jobReport();
		
	}


}
