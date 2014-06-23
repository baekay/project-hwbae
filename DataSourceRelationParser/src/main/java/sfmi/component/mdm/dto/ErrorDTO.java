package sfmi.component.mdm.dto;

/**
 * 프로그램 실행중 발생하는 에러를 담는 클래스
 * @author hwbae
 *
 */
public class ErrorDTO {
	private String className; // class명
	private String xmlFilePath; // xml 파일명(경로)
	private String status; // 류내역 처리 상태 (R : 등록, M : 수정, D : 완료)
	private String exceptionClassify; // exception 구분
	private String sqlId; // sql ID
	private String sqlStatement; // sql;
	private String exceptionMsg; // exception message
	/**
	 * method 명
	 */
	private String methodName;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/*
	 * ERROR 발생 시간
	 */
	private String occurTime;
	
	public String getOccurTime() {
		return occurTime;
	}
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getXmlFilePath() {
		return xmlFilePath;
	}
	public void setXmlFilePath(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExceptionClassify() {
		return exceptionClassify;
	}
	public void setExceptionClassify(String exceptionClassify) {
		this.exceptionClassify = exceptionClassify;
	}
	public String getSqlId() {
		return sqlId;
	}
	public void setSqlId(String sqlId) {
		this.sqlId = sqlId;
	}
	public String getSqlStatement() {
		return sqlStatement;
	}
	public void setSqlStatement(String sqlStatement) {
		this.sqlStatement = sqlStatement;
	}
	@Override
	public String toString() {
		return "ErrorDTO [className=" + className + ", xmlFilePath="
				+ xmlFilePath + ", status=" + status + ", exceptionClassify="
				+ exceptionClassify + ", sqlId=" + sqlId + ", sqlStatement="
				+ sqlStatement + "]";
	}

	
}
