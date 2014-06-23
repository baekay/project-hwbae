package sfmi.component.mdm.dto;

import java.util.List;
import java.util.Map;


/**
 * BATCH의 Processor정보 
 * @author 배혜원
 *
 */
public class ProcessorInfo { 
	
	/*
	 * processor 클래스명
	 */
	private String processorClass;
	/*
	 * processor method명을 키로 ProcessorDaoInfo 리스트를 갖는다.
	 */
	private List<ProcessorDaoInfo> processorMethodAndDaoInfo;

	
	/*
	 * db관련 processor
	 */
	boolean isDbProcessor;
	
	public boolean isDbProcessor() {
		return isDbProcessor;
	}
	public void setDbProcessor(boolean isDbProcessor) {
		this.isDbProcessor = isDbProcessor;
	}
	public String getProcessorClass() {
		return processorClass;
	}
	public void setProcessorClass(String processorClass) {
		this.processorClass = processorClass;
	}
	public List<ProcessorDaoInfo> getProcessorMethodAndDaoInfo() {
		return processorMethodAndDaoInfo;
	}
	public void setProcessorMethodAndDaoInfo(
			List<ProcessorDaoInfo> processorMethodAndDaoInfo) {
		this.processorMethodAndDaoInfo = processorMethodAndDaoInfo;
	}

	


	
	
	
	
	
}
