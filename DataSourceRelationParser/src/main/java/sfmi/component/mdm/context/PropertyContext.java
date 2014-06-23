package sfmi.component.mdm.context;

/**
 * 프로퍼티 저장 Context
 * @author hwbae
 *
 */
public class PropertyContext {
	/*
	 * 저장 디렉토리
	 */
	private static String targetDir;

	/*
	 * target dir에서 pjt 뎁스정보
	 */
	private static int findVobDepth;

	public static int getFindVobDepth() {
		return findVobDepth;
	}
	public static void setFindVobDepth(int findVobDepth) {
		PropertyContext.findVobDepth = findVobDepth;
	}
	public static String getTargetDir() {
		return targetDir;
	}
	public static void setTargetDir(String targetDir) {
		PropertyContext.targetDir = targetDir;
	}
	/*
	 * 실행 타입
	 */
//	private static String programType;  
//	public static String getProgramType() {
//		return programType;
//	}
//	public static void setProgramType(String programType) {
//		PropertyContext.programType = programType;
//	}
	/*
	 * systemId또는 VOB명 
	 */
//	private static String systemId;
	
//	public static String getSystemId() {
//		return systemId;
//	}
//	public static void setSystemId(String systemId) {
//		PropertyContext.systemId = systemId;
//	}
	
	
}
