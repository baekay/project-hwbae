package sfmi.component.mdm.launcher;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.context.BatchJobContext;
import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.service.ExtractSqlInfoService;
import sfmi.component.mdm.service.batch.ExtractBatchSqlInfoService;
import sfmi.component.mdm.service.online.ExtractOnlineSqlInfoServiceInJava;
import sfmi.component.mdm.service.online.ExtractOnlineSqlInfoServiceInXml;
import sfmi.component.mdm.service.online.OnlineResultMatchService;

/**
 * SQLAnalyzer 실행기
 * 
 * @author 배혜원
 *
 */
public class SQLAnalyzLauncherService {
	private static Logger logger = Logger.getLogger(SQLAnalyzLauncherService.class);
	
	/**
	 * 서비스 구동
	 */
	public void run(String filePath, String vobName) {
		if(logger.isInfoEnabled()) {
			logger.info("SQL 영향도 분석기를 실행합니다.");
		}
		
		BatchJobContext batchJobContext = BatchJobContext.getJobContext();
		batchJobContext.setContextValue(SQLAnalyzerConstants.VOB_NAME, vobName);
		
		List<AnalyzeData> xmlAnalyzeDataList;
		List<AnalyzeData> javaAnalyzeDataList;
		
		if(logger.isInfoEnabled()) {
			logger.info("=======================================");
			logger.info(" ONLINE SERIVCE를 시작합니다.");
			logger.info("=======================================");
		}
		
		// XML 파일 Sql 정보 추출 서비스
		ExtractSqlInfoService  xmlService = new ExtractOnlineSqlInfoServiceInXml();
		xmlAnalyzeDataList = xmlService.extract(filePath);
		
		
		if(logger.isInfoEnabled()) {
			logger.info("=======================================");
			logger.info("JAVA 파일을 대상으로 SQL 정보 추출을 시작합니다.");
			logger.info("=======================================");
		}
		// JAVA 파일 Sql 정보 추출 서비스 
		ExtractSqlInfoService javaService = new ExtractOnlineSqlInfoServiceInJava();
		javaAnalyzeDataList = javaService.extract(filePath);
		
		
		if(logger.isInfoEnabled()) {
			logger.info("=======================================");
			logger.info("추출한 SQL 정보를 이용하여 결과값을 구성합니다.");
			logger.info("=======================================");
		}
		// 리스트 매칭 서비스 
		OnlineResultMatchService matchService = new OnlineResultMatchService();
		matchService.matcheAnalyzeData(xmlAnalyzeDataList, javaAnalyzeDataList, vobName);
		
		
		if(logger.isInfoEnabled()) {
			logger.info("=======================================");
			logger.info(" BATCH SERIVCE를 시작합니다.");
			logger.info("=======================================");
		}
		// batch Service
		ExtractBatchSqlInfoService batchService = new ExtractBatchSqlInfoService();
		batchService.extract(filePath);
				
		
	}
	
}
