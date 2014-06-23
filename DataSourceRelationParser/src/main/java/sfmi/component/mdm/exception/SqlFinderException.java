package sfmi.component.mdm.exception;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;

/**
 * SqlFinder내에서 exception났을 경우 
 * @author hwbae
 *
 */
public class SqlFinderException extends Exception {

	private static final long serialVersionUID = -3850932296015207221L;
	
	/*
	 * 메세지 저장 변수
	 */
	private String exceptionMsg; 
	
	
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	/*
	 * SqlFinderException 구분을 위한 생성자 
	 */
	public SqlFinderException(int classifyExceptionNumber, String sqlFile, String sqlId){
		if(classifyExceptionNumber == SQLAnalyzerConstants.NO_FILE_SQLID){
			exceptionMsg = "FileName또는 SQL ID 가 존재하지 않습니다. \n sqlFile : " + sqlFile + ", sqlId : " + sqlId;
		} else if(classifyExceptionNumber == SQLAnalyzerConstants.NO_FILE){
			exceptionMsg = "File이 존재하지 않습니다. \n sqlFile : " + sqlFile + ", sqlId : " + sqlId;
		} else if(classifyExceptionNumber == SQLAnalyzerConstants.NO_SQL_STATEMENT){
			exceptionMsg = "매칭되는 SQL ID가 존재하지 않습니다. " + System.getProperty("line.separater") +
					" sqlFile : " + sqlFile + ", sqlId : " + sqlId;
		} else { /* DO NOTHING */ }
	}

}
