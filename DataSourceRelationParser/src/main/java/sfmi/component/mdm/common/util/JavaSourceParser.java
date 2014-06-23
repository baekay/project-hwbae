package sfmi.component.mdm.common.util;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.TokenMgrError;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.body.AnnotationDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.EnumDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.MethodInfo;

/**
 * 자바소스파일을 파싱하여 클래스 / 메소드 정보를 추출하는 유틸클래스  
 * 
 * @since 2014.03.07
 * @author 이윤걸
 *
 */
public class JavaSourceParser {
	private static Logger logger = Logger.getLogger(JavaSourceParser.class);
	
	/**
	 * 자바소스파일을 파싱하여 정보추출
	 * 
	 * @param file	파싱할 자바소스
	 * @return {@link ClassInfo}  
	 * @throws IOException
	 * @throws ParseException 
	 */
	public static ClassInfo parse(File file) throws IOException, ParseException, TokenMgrError  {
		if(logger.isDebugEnabled()) 
			logger.debug("Extract Class / Method Info from JavaSource");
			
		ClassInfo classInfo = null; 
		FileInputStream fis = null;
		
		if(file.exists()) {
			fis = new FileInputStream(file);
			
			CompilationUnit unit = null;
			
			if(logger.isInfoEnabled()){
//				logger.info("file : " + file.getAbsolutePath());
			}
			unit = JavaParser.parse(fis);
			
			classInfo = new ClassVisitor().getClassInfo(unit);
			
			String filePath = file.getAbsolutePath();
			/*
			 * vob명 및 pjt명 저장, 클래스의 PJT명까지 포함한 경로
			 */
			classInfo.setSystemId(AnalyzerStringUtil.extractVobName(filePath));
			classInfo.setRootFilePath(AnalyzerStringUtil.setFileRootDir(filePath));
			classInfo.setFileLowPath(AnalyzerStringUtil.setFileLowRootDir(filePath));
		} else {
			if(logger.isInfoEnabled()) 
				logger.info("File Not Found....");
		}
			

		fis.close();
		
		if(logger.isDebugEnabled()) 
			logger.debug(classInfo.toString());
		
		return classInfo;
	}

	/**
	 * @author 이윤걸
	 *
	 */
	@SuppressWarnings("rawtypes")
	private static class ClassVisitor extends VoidVisitorAdapter {
		
		private ClassInfo classInfo = new ClassInfo();
		
		/**
		 * 클래스 정보추출
		 * @param unit
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public ClassInfo getClassInfo(CompilationUnit unit) throws NullPointerException {
			// 파일내용이 비어있을 경우
			if(unit.getEndLine() == 1 && unit.getEndColumn() == 0) {
				classInfo.setEmpty(true);
				return classInfo;
			}
			
			classInfo.setPackageName( (PackageDeclaration)unit.getPackage() !=null ? ((PackageDeclaration)unit.getPackage()).getName().toString() : "" );
			
			
			// 클래스명 추출
			List<TypeDeclaration> typeDeclarations = unit.getTypes();
			
			if(typeDeclarations != null){
				for (TypeDeclaration type : typeDeclarations) {
					if(type instanceof ClassOrInterfaceDeclaration || type instanceof EnumDeclaration || type instanceof AnnotationDeclaration) {
						classInfo.setName(type.getName());
						classInfo.setFileName(type.getName()+".java");
					}
				}
				this.classInfo.setQualifiedName(this.classInfo.getPackageName()+"."+this.classInfo.getName());
				
				new ClassVisitor().visit(unit, classInfo);
			}
			return this.classInfo;
		}
		
		@Override
		public void visit(ClassOrInterfaceDeclaration classDeclaration, Object classInfo) {
			this.classInfo = (ClassInfo) classInfo;
			
			this.classInfo.setBeginLine(classDeclaration.getBeginLine());	// 클래스 시작 라인
			this.classInfo.setEndLine(classDeclaration.getEndLine());		// 클래스 끝 라인
			
			// 상속 클래스 추출
			List<ClassOrInterfaceType> extendsList = classDeclaration.getExtends();
			
			if(extendsList != null && extendsList.size() > 0) {
				// 상속은 한 개만 가능
				for(ClassOrInterfaceType type : extendsList) {
					this.classInfo.setExtendsName(type.getName());
				}
			} 
			
			// 인터페이스 추출
			List<ClassOrInterfaceType> impleList = classDeclaration.getImplements(); 
			if(impleList != null && impleList.size() > 0) {
				List<String> implementsList = new ArrayList<String>();
				
				for(ClassOrInterfaceType type : impleList) {
					implementsList.add(type.getName());
				}
				
				this.classInfo.setImplementsName(implementsList);
			}
			
			// 메소드 정보 추출
			List<BodyDeclaration> members = classDeclaration.getMembers();
			
			if(members != null && members.size() > 0) {
				
				List<MethodInfo> methodInfoList = new ArrayList<MethodInfo>();
				MethodInfo methodInfo = null;
				Map<String, String> variableInfo = new HashMap<String, String>();
				
				for (BodyDeclaration member : members) {
					
					// 메소드 타입에서 정보 추출
					if (member instanceof MethodDeclaration) {
						methodInfo = new MethodInfo();	
						
						MethodDeclaration method = (MethodDeclaration) member;
						
						// Modifier 추출
						methodInfo.setModifier(java.lang.reflect.Modifier.toString(method.getModifiers()));

						// Return Type 추출
						methodInfo.setReturnType(method.getType().toString());
						
						// 메소드 명 추출
						methodInfo.setName(method.getName());

						// 메소드 시그니처 구성 접근제어, 리턴타입 제거 
//						String signature = methodInfo.getModifier() + " " + methodInfo.getReturnType() + " " + methodInfo.getName();
						String signature = methodInfo.getName();
						
						// 파라미터 추출
						List<Parameter> paramList = method.getParameters();
						
						if(paramList != null && paramList.size() > 0) {
							List<String> parameters = new ArrayList<String>();
							
		                    for(Parameter param : paramList) {
		                    	parameters.add(param.toString());
		                    }

		                    signature += "(" + paramList.toString().replaceAll("\\[|\\]", "") + ")"; 
		                    
		                    methodInfo.setParameters(parameters);
						} else {
							signature += "()";
						}
						
						// throws 제외 시그니처 구성
//						List<NameExpr> throwList =  method.getThrows();
//						if(throwList != null && throwList.size() > 0) {
//							List<String> tList = new ArrayList<String>();
//							for(NameExpr nameExpr : throwList) {
//								tList.add(nameExpr.getName());
//							}
//							
//							signature += " throws " + throwList.toString().replaceAll("\\[|\\]", ""); 
//						}
						
						methodInfo.setSignature( signature  );
						
						// 메소드 정보 추출
						BlockStmt blockStmt = method.getBody();
						if(blockStmt != null) {
							methodInfo.setBlockStmt(method.getBody());			// 메소드 내용
							methodInfo.setBeginLine(blockStmt.getBeginLine());		// 메소드 시작 라인
							methodInfo.setEndLine(blockStmt.getEndLine());			// 메소드 끝 라인
						}
						
						methodInfoList.add(methodInfo);
					} else if (member instanceof FieldDeclaration) {
						// 클래스 내에 선언한 변수
						List<VariableDeclarator> variables = ((FieldDeclaration) member).getVariables();
						
						for(VariableDeclarator variable : variables) {
							if(variable.getInit() == null) {
								variableInfo.put(variable.getId().toString(), null);
							} else {
								variableInfo.put(variable.getId().toString(), variable.getInit().toString());
							}
						}
					}
				}
				
				this.classInfo.setVariables(variableInfo);
				
				if(methodInfoList.size() > 0) {
					this.classInfo.setMethodInfos(methodInfoList);
				}
			}
		}
	}
}
