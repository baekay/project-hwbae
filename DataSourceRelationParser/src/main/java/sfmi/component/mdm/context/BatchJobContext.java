package sfmi.component.mdm.context;

import java.util.HashMap;
import java.util.Map;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;

/**
 * JOB Context
 * @author hwbae
 *
 */
public class BatchJobContext {
	
	private static BatchJobContext jobContext;
	private static Map<String, Object> batchJobContext = new HashMap<String, Object>();
	
	private BatchJobContext(){}
	
	public static BatchJobContext getJobContext(){
		
		if(jobContext == null){
			jobContext = new BatchJobContext();
		}
		
		return jobContext;
	}
	
	
	/**
	 * Key값을 파라미터로 받아 Map에 저장되어있는 value값 리턴
	 * @param key
	 * @return
	 */
	public Object getContextValue(String key){ return batchJobContext.get(key);
	}

	/**
	 * key값과 value 값을 파라미터로 받아 Map에 저장 
	 * @param key
	 * @param value
	 */
	public void setContextValue(String key, Object value)  {
		batchJobContext.put(key, value);
	}
	
	/**
	 * JobContext 초기화
	 */
	public void initJobContext(){
		setContextValue(SQLAnalyzerConstants.JAVA_FILE_CNT, 0);
		setContextValue(SQLAnalyzerConstants.JAVA_PARSE_FAIL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.JAVA_SQL_ID_CNT, 0);
		setContextValue(SQLAnalyzerConstants.MATCH_SQL_ID_CNT, 0);
		setContextValue(SQLAnalyzerConstants.SQL_ANALYZE_FAIL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.SQL_ANALYZE_SUCESS_CNT, 0);
		setContextValue(SQLAnalyzerConstants.SQL_ID_CNT, 0);
		setContextValue(SQLAnalyzerConstants.XML_FILE_CNT, 0);
		setContextValue(SQLAnalyzerConstants.XML_PARSE_FAIL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.XML_SQL_ID_CNT, 0);
		setContextValue(SQLAnalyzerConstants.DYNAMIC_SQL_ID_CNT, 0);
		setContextValue(SQLAnalyzerConstants.JOB_XML_FILE_CNT, 0);
		setContextValue(SQLAnalyzerConstants.REPORT_CNT, 0);
		setContextValue(SQLAnalyzerConstants.ETC_FAIL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.NOT_EXIST_SQL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.INSERT_SQL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.UPDATE_SQL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.DELETE_SQL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.SELECT_SQL_CNT, 0);
		setContextValue(SQLAnalyzerConstants.MERGE_SQL_CNT, 0);
	}
	
}
