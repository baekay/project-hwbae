package sfmi.component.mdm.dto;

/**
 * BATCH 결과 저장 REPORT
 * @author 배혜원
 *
 */
public class BatchReportDTO extends ReportDTO {

	/*
	 * JOB ID
	 */
	private String jobId;
	/*
	 * STEP ID
	 */
	private String stepId;
	/*
	 * BATCH 파일 유형
	 * 
	 * READER
	 * PROCESSOR
	 * WRITER
	 */
	private String fileType; 
	
	/*
	 * Parent CLASS
	 */
	private String parentClass;
	
	/*
	 * Parent METHOD
	 */
	private String parentMethod;
	/*
	 * job XML PATH
	 */
	private String jobXmlPath;

	public String getJobXmlPath() {
		return jobXmlPath;
	}

	public void setJobXmlPath(String jobXmlPath) {
		this.jobXmlPath = jobXmlPath;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getParentClass() {
		return parentClass;
	}

	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

	public String getParentMethod() {
		return parentMethod;
	}

	public void setParentMethod(String parentMethod) {
		this.parentMethod = parentMethod;
	}

	@Override
	public String toString() {
		return "BatchReportDTO [jobId=" + jobId + ", stepId=" + stepId
				+ ", fileType=" + fileType + ", parentClass=" + parentClass
				+ ", parentMethod=" + parentMethod + "]";
	}
	
	
}
