package sfmi.component.mdm.dto;

import java.util.List;
import java.util.Map;

/**
 * Batch XML FILE Steps 정보 저장 클래스
 * @author hwbae
 *
 */
public class StepInfo { 
	private String stepId;	// step id
	private String stepType;	// step type
	private String sql;	// sqlExcuteStep의 sql
	private Map<String, String> stepProperties;	// key : propertyName, value : value, ref
	private List<Writer> writers;		// Multi Writer의 정보를 담는다.
	
	
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getStepType() {
		return stepType;
	}
	public void setStepType(String stepType) {
		this.stepType = stepType;
	}
	
	public Map<String, String> getProperties() {
		return stepProperties;
	}
	public void setProperties(Map<String, String> stepProperties) {
		this.stepProperties = stepProperties;
	}
	public List<Writer> getWriters() {
		return writers;
	}
	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}
	@Override
	public String toString() {
		return "Step [stepId=" + stepId + ", stepType=" + stepType
				+ ", stepList=" + stepProperties + "]";
	}
	
	
	
}
