package sfmi.component.mdm.dto;

import java.util.List;

/**
 * BATCH Processor내 dao정보
 * @author 배혜원
 *
 */
public class ProcessorDaoInfo {
	/*
	 * processor method명
	 */
	private String processorMethod;
	/*
	 * processor Method signature
	 */
	private String processorMethodSig;
	
	/*
	 * dao명 
	 */
	private String daoName;
	/*
	 * dao 클래스명
	 */
	private String daoClass; 
	
	/*
	 * method 리스트
	 */
	private List<String> methodList;

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public String getDaoClass() {
		return daoClass;
	}

	public void setDaoClass(String daoClass) {
		this.daoClass = daoClass;
	}

	public List<String> getMethodList() {
		return methodList;
	}

	public void setMethodList(List<String> methodList) {
		this.methodList = methodList;
	}
	
	public String getProcessorMethod() {
		return processorMethod;
	}

	public void setProcessorMethod(String processorMethod) {
		this.processorMethod = processorMethod;
	}
	

	public String getProcessorMethodSig() {
		return processorMethodSig;
	}

	public void setProcessorMethodSig(String processorMethodSig) {
		this.processorMethodSig = processorMethodSig;
	}

	@Override
	public String toString() {
		return "ProcessorDaoInfo [processorMethod=" + processorMethod
				+ ", daoName=" + daoName + ", daoClass=" + daoClass
				+ ", methodList=" + methodList + "]";
	}

	
	
	
}
