package sfmi.component.mdm.report;

import java.util.List;

import sfmi.component.mdm.dto.ReportDTO;

/**
 *  최종 분석 결과 레포팅
 * 
 * @author hwbae
 *
 */
public interface Report {
	
	public void report(List<ReportDTO> reports) ;
}
