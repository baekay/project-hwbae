package sfmi.component.mdm.dto;

import java.util.List;


/**
 * SQL 분석 후 저장 클래스 
 * @author hwbae
 *
 */
public class SqlAnalyzeData implements AnalyzeData{ 
	/*
	 * 대상 XML 파일
	 */
	private String xmlFile;	
	/*
	 * SQL ID
	 */
	private String sqlID;	
	/*
	 * SQL
	 */
	private String sql;		 
	/*
	 * SQL TYPE
	 */
	private String sqlType;
	/*
	 * dynamic query
	 */
	private boolean isDynamic;
	/*
	 * SQL TABLE LIST
	 */
	private List<TableInfo> tableInfoList;	
	/*
	 * SQL 분석 결과
	 */
	private boolean SQLAnalyzeResult; 
	
	public boolean isDynamic() {
		return isDynamic;
	}
	public void setDynamic(boolean isDynamic) {
		this.isDynamic = isDynamic;
	}
	
	public List<TableInfo> getTableInfoList() {
		return tableInfoList;
	}
	public void setTableInfoList(List<TableInfo> tableList) {
		this.tableInfoList = tableList;
	}
	public String getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
	public String getSqlID() {
		return sqlID;
	}
	public void setSqlID(String sqlID) {
		this.sqlID = sqlID;
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
	public boolean isSQLAnalyzeResult() {
		return SQLAnalyzeResult;
	}
	public void setSQLAnalyzeResult(boolean sQLAnalyzeResult) {
		SQLAnalyzeResult = sQLAnalyzeResult;
	}
	@Override
	public String toString() {
		return "SqlAnalyzeData [xmlFile=" + xmlFile + ", sqlID=" + sqlID
				+ ", sql=" + sql + ", sqlType=" + sqlType + ", isDynamic="
				+ isDynamic + ", tableList=" + tableInfoList + ", selectTableList="
				+ ", SQLAnalyzeResult=" + SQLAnalyzeResult + "]";
	}
	
	
	
	
	

	
	
	
}
