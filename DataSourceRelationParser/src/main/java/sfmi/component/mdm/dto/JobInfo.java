package sfmi.component.mdm.dto;

import java.util.List;

/**
 * Batch Xml의 jobInfo를 저장 클래스
 * @author hwbae
 *
 */
public class JobInfo implements AnalyzeData{ 
	/* 
	 * job Id
	 */
	private String jobId;
	/*
	 * job Xml Path
	 */
	private String jobXmlPath;
	/*
	 * stepList
	 */
	private List<StepInfo> stepList; 
	/*
	 * beanList
	 */
	private List<JobBeanInfo> beanList; 
	/*
	 * VOB/PJT명
	 */
	private String vobAndPjtName;
	
	public String getVobAndPjtName() {
		return vobAndPjtName;
	}
	public void setVobAndPjtName(String vobAndPjtName) {
		this.vobAndPjtName = vobAndPjtName;
	}
	public String getJobXmlPath() {
		return jobXmlPath;
	}
	public void setJobXmlPath(String jobXmlPath) {
		this.jobXmlPath = jobXmlPath;
	}
	public List<JobBeanInfo> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<JobBeanInfo> beanList) {
		this.beanList = beanList;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public List<StepInfo> getStepList() {
		return stepList;
	}
	public void setStepList(List<StepInfo> stepList) {
		this.stepList = stepList;
	}
	@Override
	public String toString() {
		return "JobInfo [jobId=" + jobId + ", jobXmlPath=" + jobXmlPath
				+ ", stepList=" + stepList + ", beanList=" + beanList
				+ ", vobAndPjtName=" + vobAndPjtName + "]";
	}
	
	
}
