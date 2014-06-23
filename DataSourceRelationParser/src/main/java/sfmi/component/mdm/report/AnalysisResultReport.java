package sfmi.component.mdm.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.dto.BatchReportDTO;
import sfmi.component.mdm.dto.ReportDTO;
import sfmi.component.mdm.dto.TableInfo;
import sfmi.component.mdm.jdbc.DataSourceHelper;
import sfmi.component.mdm.jdbc.TransactionManagerHelper;

/**
 * 최종 분석 결과를 DB에 저장한다.
 * 
 * @author hwbae
 * 
 */
public class AnalysisResultReport implements Report {

	private static Logger logger = Logger.getLogger(AnalysisResultReport.class);

	BatchJobContext batchJobContext = BatchJobContext.getJobContext();
	String vobName = batchJobContext.getContextValue(SQLAnalyzerConstants.VOB_NAME).toString();
	String prgType = batchJobContext.getContextValue(SQLAnalyzerConstants.PRG_TYPE).toString();

	public void report(final List<ReportDTO> reports) {

		if (logger.isInfoEnabled()) {
			logger.info("결과를 DB에 저장합니다.");
		}

		/*
		 * 영향도 분석 테이블 INSERT 쿼리
		 */
		String SQL_INSERT_PRTL_EFFECT_ANAL = "INSERT INTO PRTL_EFFECT_ANAL values "
				+ "(?,'01',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate, sysdate)";

		/*
		 * 영향도 분석 상세 테이블 INSERT쿼리
		 */
		String SQL_INSERT_PRTL_EFFECT_ANAL_DETAIL = "INSERT INTO PRTL_EFFECT_ANAL_DETAIL values "
				+ "(?, ?, ?, ?)";

		/*
		 * transaction시작
		 */
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceHelper.getDataSource());
		PlatformTransactionManager txManager = TransactionManagerHelper.getTransactionManager(DataSourceHelper.getDataSource());
				
		
		/*
		 * 영향도 분석 ANAL_ID 최고값 추출
		 */
		String SQL_SELECT_MAX_ANAL_ID = "SELECT MAX(ANAL_ID) FROM PRTL_EFFECT_ANAL";
		String maxAnalId = jdbcTemplate.queryForObject(SQL_SELECT_MAX_ANAL_ID, String.class);
		
		/*
		 * vob명으로 SYSTEM_ID추출
		 */
		System.out.println("vobName : " + vobName);
		String SQL_SELECT_SYSTEM_ID = "SELECT MAX(SYS_ID) FROM TB_CAST_GRP WHERE REPO = ?";
		String systemId = jdbcTemplate.queryForObject(SQL_SELECT_SYSTEM_ID, String.class ,vobName);
		
		/*
		 * 존재 하지 않으면 VOB명으로 추가
		 */
		if(systemId == null || ("").equals(systemId)){
			systemId = "-";
		}
		batchJobContext.setContextValue(SQLAnalyzerConstants.SYSTEM_ID, systemId);
		
		int resultAnalId;
		
		/*
		 * int로 변경
		 */
		if(maxAnalId == null || maxAnalId.equals("")){
			resultAnalId = 0;
		} else {
			resultAnalId = Integer.parseInt(maxAnalId);
		}

		Map<String, List<Object[]>> resultMap = null;
		List<Object[]> updateBatchArgs;
		List<Object[]> updateDetailBatchArgs;
		/*
		 * 프로그램 타입에 따라 파라미터 추출
		 */
		if (prgType.equals(SQLAnalyzerConstants.PRG_TYPE_ONLINE)) {
			resultMap = getListOnlineReport(reports, resultAnalId);
		} else {
			resultMap = getListBatchReport(reports, resultAnalId);
		}

		updateBatchArgs = resultMap.get("EFFECT_ANAL_TABLE");
		updateDetailBatchArgs = resultMap.get("EFFECT_ANAL_DETAIL_TABLE");
		
		TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());

		try { 
			// PRTL_EFFECT_ANAL 테이블에 insert			
			jdbcTemplate.batchUpdate(SQL_INSERT_PRTL_EFFECT_ANAL, updateBatchArgs);
			
			//PRTL_EFFECT_ANAL_DETAIL 테이블에 insert
			jdbcTemplate.batchUpdate(SQL_INSERT_PRTL_EFFECT_ANAL_DETAIL, updateDetailBatchArgs);
			
			txManager.commit(txStatus);
		} catch (Exception e){
			txManager.rollback(txStatus);
			if(logger.isInfoEnabled()){
				logger.info("DB저장중 오류가 발생하였습니다.");
			}
			e.printStackTrace();
			System.exit(0);
		} finally {
			if(logger.isInfoEnabled()){
				logger.info("DB저장이 완료 되었습니다.");
			}			
			
		}

	}

	/**
	 * Online Report 추출
	 * 
	 * @param reportList
	 * @param idx
	 * @return
	 */
	private Map<String, List<Object[]>> getListOnlineReport(List<ReportDTO> reportList,
			int idx) {
		// return 객체 
		Map<String, List<Object[]>> resultMap = new HashMap<String, List<Object[]>>();
		List<Object[]> updateBatchArgs = new ArrayList<Object[]>();
		List<Object[]> updateDetailArgs = new ArrayList<Object[]>();
		
		for (ReportDTO report : reportList) {
			idx++;
			Object[] insertReportArgs = new Object[24];

			insertReportArgs[0] = idx;
			insertReportArgs[1] = prgType;
			insertReportArgs[2] = batchJobContext.getContextValue(SQLAnalyzerConstants.SYSTEM_ID).toString();
			insertReportArgs[3] = report.getSqlId();
			insertReportArgs[4] = "";
			insertReportArgs[5] = "";
			insertReportArgs[6] = "";
			insertReportArgs[7] = "/" + vobName;
			insertReportArgs[8] = report.getJavaFileLowPath();
			insertReportArgs[9] = report.getJavaFileName();
			insertReportArgs[10] = report.getMethodName();
			insertReportArgs[11] = report.getXmlFile();
			insertReportArgs[12] = "";
			insertReportArgs[13] = "";
			insertReportArgs[14] = "";
			insertReportArgs[15] = report.getSqlType();
			insertReportArgs[16] = report.getSql();
			insertReportArgs[17] = "";
			insertReportArgs[18] = "";
			insertReportArgs[19] = "";
			insertReportArgs[20] = "";
			insertReportArgs[21] = "";
			insertReportArgs[22] = "";
			insertReportArgs[23] = "";

			updateBatchArgs.add(insertReportArgs);
			updateDetailArgs.addAll(getListDetailReport(report, idx));
		}

		resultMap.put("EFFECT_ANAL_TABLE", updateBatchArgs);
		resultMap.put("EFFECT_ANAL_DETAIL_TABLE", updateDetailArgs);
		return resultMap;
	}

	/**
	 * Batch report정보 추출
	 * 
	 * @param reportList
	 * @param idx
	 * @return
	 */
	private Map<String, List<Object[]>> getListBatchReport(List<ReportDTO> reportList,
			int idx) {
		
		Map<String, List<Object[]>> resultMap = new HashMap<String, List<Object[]>>();
		
		List<Object[]> updateBatchArgs = new ArrayList<Object[]>();
		List<Object[]> updateDetailArgs = new ArrayList<Object[]>();

		BatchReportDTO batchReport;

		for (ReportDTO report : reportList) {
			idx++;
			Object[] insertReportArgs = new Object[24];
			batchReport = (BatchReportDTO) report;

			insertReportArgs[0] = idx;
			insertReportArgs[1] = prgType;
			insertReportArgs[2] = batchJobContext.getContextValue(SQLAnalyzerConstants.SYSTEM_ID).toString();
			insertReportArgs[3] = batchReport.getSqlId();
			insertReportArgs[4] = batchReport.getParentClass();
			insertReportArgs[5] = batchReport.getParentMethod();
			insertReportArgs[6] = batchReport.getFileType();
			insertReportArgs[7] = "/" + vobName;
			insertReportArgs[8] = batchReport.getJavaFileLowPath();
			insertReportArgs[9] = batchReport.getJavaFileName();
			insertReportArgs[10] = batchReport.getMethodName();
			insertReportArgs[11] = batchReport.getXmlFile();
			insertReportArgs[12] = batchReport.getJobId();
			insertReportArgs[13] = batchReport.getStepId();
			insertReportArgs[14] = batchReport.getJobXmlPath();
			insertReportArgs[15] = batchReport.getSqlType();
			insertReportArgs[16] = batchReport.getSql();
			insertReportArgs[17] = "";
			insertReportArgs[18] = "";
			insertReportArgs[19] = "";
			insertReportArgs[20] = "";
			insertReportArgs[21] = "";
			insertReportArgs[22] = "";
			insertReportArgs[23] = "";

			updateBatchArgs.add(insertReportArgs);
			
			updateDetailArgs.addAll(getListDetailReport(report, idx));
		}

		resultMap.put("EFFECT_ANAL_TABLE", updateBatchArgs);
		resultMap.put("EFFECT_ANAL_DETAIL_TABLE", updateDetailArgs);
		
		return resultMap;
	}

	/**
	 * 
	 * @param reportList
	 * @param idx
	 * @return
	 */
	private List<Object[]> getListDetailReport(ReportDTO report, int idx) {
		List<Object[]> updateBatchArgs = new ArrayList<Object[]>();

		// reportList에서 table정보 추출
		for (TableInfo tableInfo : report.getTableInfoList()) {
			int columnIdx = 1;
			Object[] insertDetailReportArgs = new Object[4];

			if (tableInfo.getColumnList() != null) {
				for (String column : tableInfo.getColumnList()) {
					insertDetailReportArgs = new Object[4];
					insertDetailReportArgs[0] = idx;
					insertDetailReportArgs[1] = columnIdx++;
					insertDetailReportArgs[2] = tableInfo.getTableName();
					insertDetailReportArgs[3] = column;

					updateBatchArgs.add(insertDetailReportArgs);
				}
			} else {
				insertDetailReportArgs[0] = idx;
				insertDetailReportArgs[1] = columnIdx++;
				insertDetailReportArgs[2] = tableInfo.getTableName();
				insertDetailReportArgs[3] = "";

				updateBatchArgs.add(insertDetailReportArgs);
			}

		}

		return updateBatchArgs;
	}

}
