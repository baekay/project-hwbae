package sfmi.component.mdm.dto;

import java.util.List;

/**
 * table 정보
 * @author hwbae
 *
 */
public class TableInfo {
	/*
	 * 테이블 명
	 */
	private String tableName;
	/*
	 * 컬럼 리스트
	 */
	private List<String> columnList;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<String> getColumnList() {
		return columnList;
	}
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
	
}
