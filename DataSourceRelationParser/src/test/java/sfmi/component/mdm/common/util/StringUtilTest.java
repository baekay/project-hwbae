package sfmi.component.mdm.common.util;

import japa.parser.ParseException;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.Test;

import sfmi.component.mdm.dto.AnalyzeData;
import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.JavaAnalyzeData;
import sfmi.component.mdm.dto.MethodInfo;

public class StringUtilTest {
	
	/**
	 * java 파일의 SQL 아이디 추출
	 * @throws Exception 
	 */
	@Test
	public void testExtractSqlId() throws Exception {
		File file = new File("D:\\SFMI_WORK\\indigo_workspace\\CL\\ClaimComponent\\AccidentProcess\\src\\sfmi\\component\\claim\\accidentprocess\\dao\\sqlmap\\SqlMapCarPartnerNetworktProcessDao.java");
		List<AnalyzeData> dataList = new ArrayList<AnalyzeData>();
		
		JavaAnalyzeData javaAnalyzeData = null;
		
		try {
			ClassInfo classInfo = JavaSourceParser.parse(file); 
			List<MethodInfo> methodList = classInfo.getMethodInfos();
			
			Pattern pattern = Pattern.compile("(.*)?(update|delete|insert|queryForList|queryForObject|queryForMap){1}(\\(\")(\\w+)(.*)");
			Pattern assignSqlIdPattern = Pattern.compile("(.*)?(update|delete|insert|queryForObject|queryForList|queryForMap){1}(\\()(\\w+)(.*)");
			
			for(MethodInfo method : methodList) {
				BlockStmt stmt = method.getBlockStmt();
				
				List<Statement> statements = stmt.getStmts();
				
				for(Statement state : statements) {
					
					Matcher matcher = assignSqlIdPattern.matcher(state.toString());
					
					if(matcher.find()) {
						
						matcher.reset();
						
						Pattern bodyAssignSqlIdPattern = null;
						Matcher sqlIdMatcher = null;
						
						while(matcher.find()){
							javaAnalyzeData = new JavaAnalyzeData();
							
//							javaAnalyzeData.setJavaFile(classInfo.getQualifiedName()+".java");
							javaAnalyzeData.setMethodName(method.getSignature());
							
							// 클래스 Field 에 선언해 놓았을 경우
							if(classInfo.getVariables().containsKey(matcher.group(4))) {
								javaAnalyzeData.setSqlID( classInfo.getVariables().get(matcher.group(4)).replaceAll("\"", "")  ); 
							} else {
								// BODY Statement 에서 검색
								bodyAssignSqlIdPattern = Pattern.compile("(.*)?("+matcher.group(4) +"){1}(\\s\\=\\s)(\")(.*)(\")");
								sqlIdMatcher = bodyAssignSqlIdPattern.matcher(stmt.toString());
								while(sqlIdMatcher.find()) {
									System.out.println("SQL ID : " + sqlIdMatcher.group(5));
									javaAnalyzeData.setSqlID( sqlIdMatcher.group(5) );
								}
							}
						// if문에서 시퀀스가 하나 증가했기 때문에 인덱스 초기화
//						matcher.reset();
//						
//						System.out.println("---------------------------------------------------");
//						while(matcher.find()) {
//							System.out.println("Match.... : " + matcher.group() );
//							System.out.println("SQL ID : " + matcher.group(4)); 
//							System.out.println("System.getProperty() : " + System.getProperty("user.name")); 
//
//							// SQL ID 및 메소드 명 추출하여 담는다.
//							javaAnalyzeData = new JavaAnalyzeData();
//							javaAnalyzeData.setSqlID(matcher.group(4));
//							javaAnalyzeData.setMethodName(method.getName());
//							dataList.add(javaAnalyzeData);
//						}
//						System.out.println(""); 
//						System.out.println("Statement : " + state.toString()); 
//						System.out.println("---------------------------------------------------");
					}// end if
				}// end for(statement)
			}// end for(method)
//			Assert.assertTrue(dataList.size() == 6);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
