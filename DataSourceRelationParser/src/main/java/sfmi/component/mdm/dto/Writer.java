package sfmi.component.mdm.dto;

import java.util.Map;

/**
 * Batch Writer 정보를 담는 DTO
 * @author 이윤걸
 *
 */
public class Writer {

	public String className;										// Writer Ŭ클래스명
	public Map<String, String>	writerProperties;				// Writer 프로퍼티
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Map<String, String> getWriterProperties() {
		return writerProperties;
	}
	public void setWriterProperties(Map<String, String> writerProperties) {
		this.writerProperties = writerProperties;
	}
	
}
