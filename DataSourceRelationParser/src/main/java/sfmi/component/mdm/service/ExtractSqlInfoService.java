package sfmi.component.mdm.service;

import java.util.List;

import sfmi.component.mdm.dto.AnalyzeData;

/**
 * 기본 SQL 추출 클래스 
 * @author hwbae
 *
 */
public interface ExtractSqlInfoService {
	
	/**
	 * SQL 추출 메소드 
	 * @return
	 */
	public List<AnalyzeData> extract(String targetSystemDir);
	
}
