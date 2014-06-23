package sfmi.component.mdm.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassInfo {

	private String name;				// 클래스명
	private String fileName;			// 클래스명(확장자포함)
	private String fileLowPath;			// 파일 low경로
	private String packageName;		// 패키지 명
	private String qualifiedName;		// 전체 클래스명
	private String extendsName;		// 상속 명
	private List<String> implementsName;	// 인터페이스 명
	private Map<String, String> variables;	// 변수명
	private List<MethodInfo> methodInfos = new ArrayList<MethodInfo>();		// 메소드 정보
	private int beginLine;				// 시작라인 
	private int endLine;				// 끝라인
	private boolean isEmpty = false;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileLowPath() {
		return fileLowPath;
	}

	public void setFileLowPath(String fileLowPath) {
		this.fileLowPath = fileLowPath;
	}

	/*
	 * PJT명 포함한 filePath
	 */
	private String pjtRootFilePath;
	
	public String getRootFilePath() {
		return pjtRootFilePath;
	}

	public void setRootFilePath(String pjtRootFilePath) {
		this.pjtRootFilePath = pjtRootFilePath;
	}

	/*
	 * SystemId, Vob명
	 */
	private String systemId;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}
	
	public String getExtendsName() {
		return extendsName;
	}

	public void setExtendsName(String extendsName) {
		this.extendsName = extendsName;
	}

	public List<String> getImplementsName() {
		return implementsName;
	}

	public void setImplementsName(List<String> implementsName) {
		this.implementsName = implementsName;
	}

	public Map<String, String> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}

	public List<MethodInfo> getMethodInfos() {
		return methodInfos;
	}

	public void setMethodInfos(List<MethodInfo> methodInfos) {
		this.methodInfos = methodInfos;
	}

	public int getBeginLine() {
		return beginLine;
	}

	public void setBeginLine(int beginLine) {
		this.beginLine = beginLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public String toString() {
		return "ClassInfo [name=" + name + ", packageName=" + packageName
				+ ", qualifiedName=" + qualifiedName + ", extendsName="
				+ extendsName + ", implementsName=" + implementsName
				+ ", methodInfos=" + methodInfos + ", beginLine=" + beginLine
				+ ", endLine=" + endLine + "]";
	}
}
