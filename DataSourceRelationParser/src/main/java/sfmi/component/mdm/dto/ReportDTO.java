package sfmi.component.mdm.dto;

import java.util.List;


/**
 * 분석, 파싱 결과 
 * @author hwbae
 *
 */
public class ReportDTO {
	/*
	 * VOB 또는 SYSTEM ID
	 */
	private String SystemId;
	/*
	 * java file명
	 */
	private String javaFileName;
	/*
	 * java file Low Path
	 */
	private String javaFileLowPath;
	/*
	 * xml file
	 */
	private String xmlFile;	
	/*
	 * SQL ID
	 */
	private String sqlId;	
	/*
	 * SQL TYPE
	 * ( SELECT, INSERT, UPDATE, DELETE)
	 */
	private String sqlType;	
	/*
	 * 프로그램 타입
	 * (ONLINE, BATCH)
	 */
	private String prgType;
	/*
	 * 등록 타입
	 * A / M (자동/수동)
	 */
	private String regType; 
	/*
	 * SQL
	 */
	private String sql; 	
	
	/*
	 * JAVA METHOD NAME
	 */
	private String methodName;	
	/*
	 * 다이나믹 쿼리
	 */
	private boolean isDynamic; 
	/*
	 * Table LIST 
	 */
	private List<TableInfo> tableInfoList;	
	
	public String getSystemId() {
		return SystemId;
	}
	public void setSystemId(String systemId) {
		SystemId = systemId;
	}
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
	public String getSqlId() {
		return sqlId;
	}
	public void setSqlId(String sqlId) {
		this.sqlId = sqlId;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getSqlType() {
		return sqlType;
	}
	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}
	public String getPrgType() {
		return prgType;
	}
	public void setPrgType(String prgType) {
		this.prgType = prgType;
	}
	
	public boolean isDynamic() {
		return isDynamic;
	}
	public void setDynamic(boolean isDynamic) {
		this.isDynamic = isDynamic;
	}
	public List<TableInfo> getTableInfoList() {
		return tableInfoList;
	}
	public void setTableInfoList(List<TableInfo> tableInfoList) {
		this.tableInfoList = tableInfoList;
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
	@Override
	public String toString() {
		return "ReportDTO [SystemId=" + SystemId + ", javaFileName="
				+ javaFileName + ", javaFileLowPath=" + javaFileLowPath
				+ ", xmlFile=" + xmlFile + ", sqlId=" + sqlId + ", sqlType="
				+ sqlType + ", prgType=" + prgType + ", regType=" + regType
				+ ", sql=" + sql + ", methodName=" + methodName
				+ ", isDynamic=" + isDynamic + ", tableInfoList="
				+ tableInfoList + "]";
	}
	
	
	
	

	
}
