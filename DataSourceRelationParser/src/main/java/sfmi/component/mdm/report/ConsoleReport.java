package sfmi.component.mdm.report;

import java.util.List;

import org.apache.log4j.Logger;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.dto.BatchReportDTO;
import sfmi.component.mdm.dto.ReportDTO;
import sfmi.component.mdm.dto.TableInfo;

/**
 * 최종 분석 결과를 콘솔에 출력한다.
 * @author hwbae
 *
 */
public class ConsoleReport implements Report {
	private static Logger logger = Logger.getLogger(ConsoleReport.class);
	/**
	 * 레포트 리스트에 담긴 정보를 출력한다.
	 * @param reportList
	 */
	public void report(List<ReportDTO> reportList) {
		if(logger.isInfoEnabled()){
			logger.info("최종 분석 결과를 출력합니다....");
		}
		BatchJobContext jobContext = BatchJobContext.getJobContext();
		String vobName = jobContext.getContextValue(SQLAnalyzerConstants.VOB_NAME).toString();
		String prgType = jobContext.getContextValue(SQLAnalyzerConstants.PRG_TYPE).toString();
		
		if(logger.isInfoEnabled()){
			logger.info("┏─────────────────────────────────────────────────────────┓");
			logger.info("│");
			logger.info("│     Print Start.......");
			logger.info("│     Target System : " + vobName);
			logger.info("│");
			logger.info("┗─────────────────────────────────────────────────────────┛");
		}
		
		
		/*
		 * online 리포트
		 */
		if(prgType.equals(SQLAnalyzerConstants.PRG_TYPE_ONLINE)){
			for(ReportDTO report : reportList){
				if(logger.isInfoEnabled()){
					logger.info("┏─────────────────────────────────────────────────────────┓");
					logger.info("│	SQL ID : " + report.getSqlId());
					logger.info("│	IS DYNAMIC : " + report.isDynamic());
					logger.info("│	HIGH PATH : " + "/"+vobName);
					logger.info("│	JAVA FILE : " + report.getJavaFileLowPath() + "/"+ report.getJavaFileName());
					logger.info("│	METHOD NAME : " + report.getMethodName());
					logger.info("│ 	XML FILE : " + report.getXmlFile());
					for(TableInfo tableInfo : report.getTableInfoList()){
						logger.info("│	TABLE NAME : " + tableInfo.getTableName());
						logger.info("│	TABLE COLUMN LIST : " + tableInfo.getColumnList());
					}
					logger.info("│	STATEMENT TYPE : " + report.getSqlType());
					logger.info("│	SQL : " + report.getSql());
					logger.info("┗─────────────────────────────────────────────────────────┛");
				}
			}
		/*
		 * batch 리포트
		 */
		} else {
			BatchReportDTO batchReport;
			for(ReportDTO report : reportList){
				if(logger.isInfoEnabled()){
					batchReport = (BatchReportDTO)report;
					logger.info("┏─────────────────────────────────────────────────────────┓");
					logger.info("│	JOB ID : " + batchReport.getJobId());
					logger.info("│	STEP ID : " + batchReport.getStepId());
					logger.info("│	SQL ID : " + batchReport.getSqlId());
					logger.info("│	FILE TYPE : " + batchReport.getFileType());
					logger.info("│	JOB FILE : " + batchReport.getJobXmlPath());
					logger.info("│	PRAENT CLASS : " + batchReport.getParentClass());
					logger.info("│	PARENT METHOD : " + batchReport.getParentMethod());
					logger.info("│	HIGH PATH : " + "/" + vobName);
					logger.info("│	JAVA FILE : " + batchReport.getJavaFileLowPath() + "/" +batchReport.getJavaFileName());
					logger.info("│	METHOD NAME : " + batchReport.getMethodName());
					logger.info("│ 	XML FILE : " + batchReport.getXmlFile());
					for(TableInfo tableInfo : report.getTableInfoList()){
						logger.info("│	TABLE NAME : " + tableInfo.getTableName());
						logger.info("│	TABLE COLUMN LIST : " + tableInfo.getColumnList());
					}
					logger.info("│	STATEMENT TYPE : " + batchReport.getSqlType());
					logger.info("│	SQL : " + batchReport.getSql());
					logger.info("┗─────────────────────────────────────────────────────────┛");
				}
			}
		}
		
		
		if(logger.isInfoEnabled()){
			logger.info("┏─────────────────────────────────────────────────────────┓");
			logger.info("│");
			logger.info("│     REPORT COUNT : " + reportList.size());
			logger.info("│     Print END......");
			logger.info("│");
			logger.info("┗─────────────────────────────────────────────────────────┛");
		}
		
		if(logger.isInfoEnabled()){
			logger.info("출력을 종료합니다....");
		}
	}
}
