package sfmi.component.mdm.common.util;

import java.util.ArrayList;

import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.MethodInfo;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.RootDoc;
import com.sun.tools.javadoc.Main;

/**
 * method 시그니처 추출 클래스
 * 
 * @author  이윤걸
 *
 */
public class ExtractMethodSignatureDoclet extends Doclet   {
	
	private static final String javadocProgramName = "ExtractMethodSignatureDoclet";
	private static final String customDocletName = "sfmi.component.mdm.common.util.ExtractMethodSignatureDoclet";
	private static ClassInfo classInfo = new ClassInfo();
	
	public static ClassInfo getMethodInfo(String filePath) {
		initClassInfo();
		Main.execute(javadocProgramName, customDocletName, new String[] {"-private",filePath});
		
		return classInfo;
	}
	
	private static void initClassInfo() {
		classInfo.setName("");
		classInfo.setQualifiedName("");
		classInfo.setMethodInfos(new ArrayList<MethodInfo>());
	}
	
	public static boolean start(RootDoc root)  {
		
		for (ClassDoc classDoc : root.classes()) {
//			System.out.println("===============================================");
//			System.out.println("Class  : " + classDoc.qualifiedName()); 
//			System.out.println("TEST : " + classDoc.name());
			
			classInfo.setQualifiedName(classDoc.qualifiedName());
			classInfo.setName(classDoc.name());
			
//			classInfo.getMethodInfos().add(arg0)
			
			// �޼ҵ� 
//			for (MethodDoc methodDoc : classDoc.methods(false)) {
//				MethodInfo methodInfo = new MethodInfo();
				
//				methodInfo.setModifiers(methodDoc.modifiers());
//				methodInfo.setReturnType(methodDoc.returnType().simpleTypeName());
//				methodInfo.setName(methodDoc.name());
//				methodInfo.setSignature(methodDoc.flatSignature());
//            }
			System.out.println("===============================================");
		}
		
		return true;
	}
	
//	public static void main(String[] args) {
//		
//		String filePath = "D:\\workspace\\SQLParser\\src\\test\\java\\sfmi\\component\\mdm\\common\\util\\FileCollectorTest.java";
//		
//		Main.execute("ExtractMethodSignatureDoclet","sfmi.component.mdm.common.util.ExtractMethodSignatureDoclet",new String[] {"-private",filePath});
//	}
}
