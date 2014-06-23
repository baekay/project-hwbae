package sfmi.component.mdm.report;


import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.jdbc.DataSourceHelper;


/**
 * Listener 결과 레포트 
 * @author hwbae
 *
 */
public class JobReport {
	private static Logger logger = Logger.getLogger(JobReport.class);
	/**
	 * 프로그램 종료시 제일 마지막에 저장된 결과값 출력
	 * 
	 */
	public static void jobReport(){
		
		BatchJobContext jobContext = BatchJobContext.getJobContext();
		
		String systemId = jobContext.getContextValue(SQLAnalyzerConstants.SYSTEM_ID).toString();
		String prgType = jobContext.getContextValue(SQLAnalyzerConstants.PRG_TYPE).toString(); 
		String startDttm = jobContext.getContextValue(SQLAnalyzerConstants.START_TIME).toString(); 
		String endDttm = jobContext.getContextValue(SQLAnalyzerConstants.END_TIME).toString(); 
		int javaCnt = (Integer) jobContext.getContextValue(SQLAnalyzerConstants.JAVA_FILE_CNT);
		int xmlCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.XML_FILE_CNT);
		int javaSqlId = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.JAVA_SQL_ID_CNT);
		int xmlSqlId = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.XML_SQL_ID_CNT);
		int dynamicSqlId = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.DYNAMIC_SQL_ID_CNT);
		int matchSqlId = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.MATCH_SQL_ID_CNT);
		int jobXmlFile = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.JOB_XML_FILE_CNT);
		int reportCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.REPORT_CNT);
		int sqlSucessCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.SQL_ANALYZE_SUCESS_CNT);
		int selectCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.SELECT_SQL_CNT);
		int insertCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.INSERT_SQL_CNT);
		int updateCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.UPDATE_SQL_CNT);
		int deleteCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.DELETE_SQL_CNT);
		int mergeCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.MERGE_SQL_CNT);
		int sqlFailCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.SQL_ANALYZE_FAIL_CNT);
		int sqlNoExistCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.NOT_EXIST_SQL_CNT);
		int javaParseErrCnt = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.JAVA_PARSE_FAIL_CNT);
		int xmlParseErrCnt =(Integer)jobContext.getContextValue(SQLAnalyzerConstants.XML_PARSE_FAIL_CNT);
		int dataRltIdx = (Integer)jobContext.getContextValue(SQLAnalyzerConstants.DATA_RLT_SEQ);
		
		
		
		if(logger.isInfoEnabled()){
			logger.info("JOB 정보를 DB에 저장합니다..");
		}
		
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceHelper.getDataSource()); 
		String SQL_PRTL_DATA_RLT_ANAL = "insert into PRTL_DATA_RLT_ANAL values " +
				"(?, ?, ?, ?, ?, ?, ?," +
				"? , ?, ? ,? , ? , ? , ? , TO_DATE(?,'yyyy:mm:dd hh24:mi:ss'), TO_DATE(?,'yyyy:mm:dd hh24:mi:ss'))";
		
		// PRTL_DATA_RLT_ANAL
		
		jdbcTemplate.update(SQL_PRTL_DATA_RLT_ANAL, 
				new Object[] { 
					dataRltIdx,	
					prgType,
					systemId,
					"", 
					sqlSucessCnt + sqlFailCnt,
					sqlSucessCnt,
					sqlFailCnt,
					javaCnt,
					xmlCnt,
					insertCnt,
					selectCnt,
					deleteCnt,
					mergeCnt,
					updateCnt,
					startDttm,
					endDttm
				}
		);
		
		if(logger.isInfoEnabled()){
			logger.info("┏────────────────────────────────────────────────────────────────┓");
			logger.info("│");
			logger.info("│    [ RESULT REPORT ]");
			logger.info("│");
			logger.info("│    시작 시간 : " + jobContext.getContextValue(SQLAnalyzerConstants.START_TIME));
			logger.info("│    대상 시스템 : " + jobContext.getContextValue(SQLAnalyzerConstants.SYSTEM_ID));
			logger.info("│");
			logger.info("│    실행 타입(01 : ONLINE, 02 : BATCH) : " + prgType);
			logger.info("│    대상 JAVA 파일 : " + javaCnt);
			logger.info("│    대상 SQL XML 파일 : " + xmlCnt);
			logger.info("│");
			if(prgType.equals(SQLAnalyzerConstants.PRG_TYPE_ONLINE)){
				logger.info("│    JAVA에 선언된 SQL ID : " + javaSqlId);
				logger.info("│    XML에 선언된 SQL ID : " + xmlSqlId);
				logger.info("│    XML에 선언된 DYNAMIC SQL ID : " + dynamicSqlId);
				logger.info("│");
				logger.info("│    SQL ID 매칭  : " + matchSqlId);
				logger.info("│");
			} else if(prgType.equals(SQLAnalyzerConstants.PRG_TYPE_BATCH)){
				logger.info("│    JOB XML FILE  : " + jobXmlFile);
			}
			logger.info("│    REPORT COUNT  : " + reportCnt);
			logger.info("│      - SQL 분석 성공 : " + sqlSucessCnt);
			logger.info("│	 		SELECT : " + selectCnt);
			logger.info("│	  		INSERT : " + insertCnt);
			logger.info("│	  		UPDATE : " + updateCnt);
			logger.info("│	  		DELETE : " + deleteCnt);
			logger.info("│	  		MERGE : " + mergeCnt);
			logger.info("│");
			logger.info("│      - SQL 분석 실패  : " + sqlFailCnt);
			logger.info("│      - SQL 미존재  : " + sqlNoExistCnt);
			logger.info("│");
			logger.info("│");
			logger.info("│");
			logger.info("│    JAVA 파일 파싱 오류  : " + javaParseErrCnt);
			logger.info("│    XML 파일 파싱 오류  : " + xmlParseErrCnt);
			logger.info("│");
			logger.info("│    종료 시간 : " + jobContext.getContextValue(SQLAnalyzerConstants.END_TIME));
			logger.info("│");
			logger.info("┗────────────────────────────────────────────────────────────────┛");
		}
	}
}
