package sfmi.component.mdm.dto;

import japa.parser.ast.stmt.BlockStmt;

import java.util.List;

/**
 * 메소드 정보를 담는 DTO
 * 
 * @author 이윤걸
 *
 */
public class MethodInfo {

	private String name;					// 메소드명
	private String modifier;				// Modifier
	private String returnType;				// 리턴타입
	private List<String> parameters;		// 파라미터
	private List<String> throwList;		// throws
	private String signature;				// 메소드 시그니쳐
	private BlockStmt blockStmt;			// 메소드 내용
	private int beginLine;					// 시작라인
	private int endLine;					// 끝라인

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	
	public List<String> getThrowList() {
		return throwList;
	}

	public void setThrowList(List<String> throwList) {
		this.throwList = throwList;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public BlockStmt getBlockStmt() {
		return blockStmt;
	}

	public void setBlockStmt(BlockStmt blockStmt) {
		this.blockStmt = blockStmt;
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

	@Override
	public String toString() {
		return "MethodInfo [name=" + name + ", returnType=" + returnType
				+ ", parameters=" + parameters + ", blockStmt=" + blockStmt
				+ ", beginLine=" + beginLine + ", endLine=" + endLine + "]";
	}
}
