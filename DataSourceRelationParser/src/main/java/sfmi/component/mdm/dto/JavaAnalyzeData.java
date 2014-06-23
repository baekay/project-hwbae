package sfmi.component.mdm.dto;

/**
 * Java 파일 분석 후 저장 클래스 
 * @author hwbae
 *
 */
public class JavaAnalyzeData implements AnalyzeData {
	private String javaFileName;	// 대상파일명
	private String javaFileLowPath; // low경로
	private String sqlID;		// sqlID
	private String methodName; 	// 메소드명
	/*
	 * systemID, VOB명
	 */
	public String systemId;
	
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getSqlID() {
		return sqlID;
	}
	public void setSqlID(String sqlID) {
		this.sqlID = sqlID;
	}
	public String getJavaFileName() {
		return javaFileName;
	}
	public void setJavaFileName(String javaFileName) {
		this.javaFileName = javaFileName;
	}
	public String getJavaFileLowPath() {
		return javaFileLowPath;
	}
	public void setJavaFileLowPath(String javaFileLowPath) {
		this.javaFileLowPath = javaFileLowPath;
	}

	
	
	
}
