package sfmi.component.mdm.service.online;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.dto.ErrorDTO;
import sfmi.component.mdm.dto.JavaAnalyzeData;
import sfmi.component.mdm.dto.ReportDTO;
import sfmi.component.mdm.dto.SqlAnalyzeData;
import sfmi.component.mdm.handler.ExceptionHandler;
import sfmi.component.mdm.listener.BatchJobListener;
import sfmi.component.mdm.report.AnalysisResultReport;
import sfmi.component.mdm.report.ConsoleReport;
import sfmi.component.mdm.report.ErrorReport;
import sfmi.component.mdm.report.JobReport;
import sfmi.component.mdm.report.Report;

/**
 * 정보 매칭하여 결과 레포트 
 * @author hwbae
 *
 */
public class OnlineResultMatchService {
	private static Logger logger = Logger.getLogger(OnlineResultMatchService.class);
	
//	private static List<String> sqlMapResourceContext = SqlMapResourceContextHolder.getSqlMapResourceContext();
	
	/**
	 * 각 파일의 파싱된 정보를 매칭하여 저장한다.
	 * @return
	 */
	public void matcheAnalyzeData(List<AnalyzeData> xmlAnalyzeDataList, 
		List<AnalyzeData> javaAnalyzeDataList, String systemId){
		
		// 결과 레포트 저장 객체 
		List<ReportDTO> resultReportDTO = new ArrayList<ReportDTO>();
		ReportDTO reportDTO;
		String xmlSqlID;
		String javaSqlID;
		
		if(logger.isInfoEnabled()){
			logger.info("각 리스트의 동일한 SQLID를 추출하여 정보를 저장합니다... ");
		}
		
		// 각 리스트를 확인하여 SQL ID가 같으면 레포트에 저장한다.
		for(AnalyzeData xmlAnalyzeData : xmlAnalyzeDataList){
			xmlSqlID = ((SqlAnalyzeData) xmlAnalyzeData).getSqlID();
			
			for(AnalyzeData javaAnalyzeData : javaAnalyzeDataList){
				javaSqlID = ((JavaAnalyzeData) javaAnalyzeData).getSqlID();
				// SQLID가 같으면
				if(xmlSqlID.equals(javaSqlID)){
					
					// SQL ID 매칭
					BatchJobListener.countListener(SQLAnalyzerConstants.MATCH_SQL_ID_CNT);
					reportDTO = new ReportDTO();
//					reportDTO.setXmlFile(((SqlAnalyzeData) xmlList).getXmlFile());
					reportDTO.setSystemId(systemId);
					reportDTO.setXmlFile(((SqlAnalyzeData) xmlAnalyzeData).getXmlFile());
					reportDTO.setDynamic(((SqlAnalyzeData) xmlAnalyzeData).isDynamic());
					reportDTO.setJavaFileName(((JavaAnalyzeData) javaAnalyzeData).getJavaFileName());
					reportDTO.setJavaFileLowPath(((JavaAnalyzeData) javaAnalyzeData).getJavaFileLowPath());
					reportDTO.setSqlId(javaSqlID);
					reportDTO.setSql(((SqlAnalyzeData) xmlAnalyzeData).getSql());
					reportDTO.setSqlType( ((SqlAnalyzeData)xmlAnalyzeData).getSqlType()  );
					reportDTO.setPrgType(SQLAnalyzerConstants.PRG_TYPE_ONLINE);
					reportDTO.setRegType("A");
					reportDTO.setMethodName(((JavaAnalyzeData) javaAnalyzeData).getMethodName());
					reportDTO.setTableInfoList(((SqlAnalyzeData) xmlAnalyzeData).getTableInfoList());
					
					resultReportDTO.add(reportDTO);
				} else {
					if(logger.isDebugEnabled()) {
						logger.debug("일치하는 SQLID가 존재하지 않습니다..");
					} 
				} // end else
			}// end for ( javaList )
		}// end for(xmlList)
		
		if(logger.isInfoEnabled()) {
			logger.info("SQL ID 비교 완료");
		} 
		
		//time Listener
		BatchJobListener.timeListener(SQLAnalyzerConstants.END_TIME);
		
		// 결과 출력 및 db에 저장 
		report(resultReportDTO);
		
	}
	
	/**
	 * 물리적인 파일경로의 XML을 SQL Map Resource에 정의된 경로로 컨버팅
	 * @param xmlFilePath
	 * @return
	 */
//	private String convertXmlFilePath(String xmlFilePath) {
//		String tmp = xmlFilePath.replaceAll("\\\\", "/");
//		
//		for(String resource : sqlMapResourceContext) {
//			if(tmp.indexOf(resource) >=0 ) {
//				return resource;
//			}
//		}
//		
//		return tmp;
//	}
	
	/**
	 * 결과 레포트 메소드 
	 */
	private void report(List<ReportDTO> resultReportDTO) {
		
		// 결과 리스트를 파싱하여 콘솔에 출력
		Report consoleReport = new ConsoleReport();
		consoleReport.report(resultReportDTO);
		
		//db에 저장
		Report dbReport = new AnalysisResultReport();
		dbReport.report(resultReportDTO);
		
		// error 콘솔에 출력
		ErrorReport errorReport = new ErrorReport();
		List<ErrorDTO> errorList = new ArrayList<ErrorDTO>(ExceptionHandler.getErrorDTOMap().values());
		// 초기화
		ExceptionHandler.setInitErrorDTOMap();
		errorReport.errorReportConsole(errorList);
		
		// error db에 저장
		errorReport.errorReportDb(errorList);
		
		// job Report
		JobReport.jobReport();
		
		
	}
	
}
