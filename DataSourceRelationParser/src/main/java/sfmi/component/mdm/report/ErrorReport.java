package sfmi.component.mdm.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.PropertyLoader;
import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.dto.ErrorDTO;
import sfmi.component.mdm.jdbc.DataSourceHelper;
import sfmi.component.mdm.jdbc.TransactionManagerHelper;

/**
 * 
 * ErrorDTO를 받아서 결과를 출력한다.
 * @author hwbae
 *
 */
public class ErrorReport {
	private static Logger logger = Logger.getLogger(ErrorReport.class);
	/**
	 * errorDTO 콘솔에 출력
	 * @param errorList
	 */
	public void errorReportConsole(List<ErrorDTO> errorList) {
		
	if(errorList.size() > 0){
			if(logger.isInfoEnabled()){
				logger.info("분석 실패 결과를 출력합니다....");
			}
	
			Properties propertyLoader = PropertyLoader.load();
			String targetPath = propertyLoader.getProperty("target.source.path");
			
			System.out.println("┏─────────────────────────────────────────────────────────┓");
			System.out.println("│");
			System.out.println("│     ERROR Print Start.......");
			System.out.println("│     Target Directory : " + targetPath);
			System.out.println("│");
			System.out.println("┗─────────────────────────────────────────────────────────┛");
			
			
			for(ErrorDTO report : errorList){
				System.out.println("┏─────────────────────────────────────────────────────────┓");
				System.out.println("│	CALSS NAME : " + report.getClassName());
				System.out.println("│	XML PATH : " + report.getXmlFilePath());
				System.out.println("│	EXCEPTION CLASSIFY : " + report.getExceptionClassify());
				System.out.println("│	EXCEPTION MSG : " + report.getExceptionMsg());
				System.out.println("│ 	SQL ID : " + report.getSqlId());
				System.out.println("│	SQL : " + report.getSqlStatement());
				System.out.println("┗─────────────────────────────────────────────────────────┛");
			}
			
			System.out.println("┏─────────────────────────────────────────────────────────┓");
			System.out.println("│");
			System.out.println("│     ERROR COUNT : " + errorList.size());
			System.out.println("│     Print END......");
			System.out.println("│");
			System.out.println("┗─────────────────────────────────────────────────────────┛");
	
		}
	}
	
	/**
	 * error 결과 db에 저장
	 * @param errorList
	 */
	public void errorReportDb(List<ErrorDTO> errorList){

		if(logger.isInfoEnabled()){
			logger.info("ERROR 정보를 DB에 저장합니다..");
		}
		
		
		BatchJobContext batchJobContext = BatchJobContext.getJobContext();
		String systemId = batchJobContext.getContextValue(SQLAnalyzerConstants.SYSTEM_ID).toString();
		String prgType = batchJobContext.getContextValue(SQLAnalyzerConstants.PRG_TYPE).toString();
		
		/*
		 * transaction시작
		 */
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceHelper.getDataSource());
		PlatformTransactionManager txManager = TransactionManagerHelper.getTransactionManager(DataSourceHelper.getDataSource());
		
		// 수행이력 SEQ SELECT 후 저장 
		int idx = jdbcTemplate.queryForObject("SELECT PRTL_DATA_RLT_SEQ.NEXTVAL FROM DUAL", Integer.class);
		batchJobContext.setContextValue(SQLAnalyzerConstants.DATA_RLT_SEQ, idx);
		
		String SQL_PRTL_EFFECT_ANAL_ERR = "insert into PRTL_EFFECT_ANAL_ERR values " +
				"(?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ? , ?,TO_DATE(?, 'yyyy:mm:dd hh24:mi:ss'))";
		
		List<Object[]> updateErrorArgs = getErrReport(errorList, systemId, prgType, idx);
		
		TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());	
		try { 
			// PRTL_EFFECT_ANAL_ERR 테이블에 insert
			jdbcTemplate.batchUpdate(SQL_PRTL_EFFECT_ANAL_ERR, updateErrorArgs);
			
			txManager.commit(txStatus);
		} catch (Exception e){
			txManager.rollback(txStatus);
			if(logger.isInfoEnabled()){
				logger.info("DB저장중 오류가 발생하였습니다.");
			}
		} finally {
			if(logger.isInfoEnabled()){
				logger.info("DB저장이 완료 되었습니다.");
			}
		}
		
	}
	
	/**
	 * 
	 * @param reportList
	 * @param idx
	 * @return
	 */
	private List<Object[]> getErrReport(List<ErrorDTO> errorList, String systemId, String prgType, int idx) {
		List<Object[]> updateBatchArgs = new ArrayList<Object[]>();

		// reportList에서 table정보 추출
		int errIdx = 1;
		for (ErrorDTO report : errorList) {
			Object[] insertDetailReportArgs = new Object[13];

			insertDetailReportArgs[0] = errIdx++;
			insertDetailReportArgs[1] = idx;
			insertDetailReportArgs[2] = systemId;
			insertDetailReportArgs[3] = prgType;
			insertDetailReportArgs[4] = report.getExceptionClassify();
			insertDetailReportArgs[5] = "";
			insertDetailReportArgs[6] = report.getExceptionMsg();
			insertDetailReportArgs[7] = report.getClassName();
			insertDetailReportArgs[8] = report.getMethodName();
			insertDetailReportArgs[9] = report.getXmlFilePath();
			insertDetailReportArgs[10] = report.getSqlId();
			insertDetailReportArgs[11] = report.getSqlStatement();
			insertDetailReportArgs[12] = report.getOccurTime();

			updateBatchArgs.add(insertDetailReportArgs);

		}

		return updateBatchArgs;
	}
}

