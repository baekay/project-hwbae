package sfmi.component.mdm.dto;

import java.util.Map;

/**
 * BATCH XML의 bean Info 정보 저장
 * @author hwbae
 *
 */
public class JobBeanInfo {
	String beanId;
	String beanClass;
	// bean의 property 정보 저장 key : name, value : ref 또는 class
	Map<String, String> propertyInfo;

	
	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	public Map<String, String> getPropertyInfo() {
		return propertyInfo;
	}

	public void setPropertyInfo(Map<String, String> propertyInfo) {
		this.propertyInfo = propertyInfo;
	}
	
	
}
