package sfmi.component.mdm.common.util;

import japa.parser.ParseException;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.MethodInfo;

public class JavaSourceParserTest {
	
	@Test
	public void testJavaSourceFile() throws Exception {
//		File file = new File("src/test/resources/testPJT/src/dao/SqlMapAutoValidationPolicyDao.java");
//		File file = new File("D:\\workspace\\ITQuality\\ITQuality\\src\\sfmi\\component\\squad\\itquality\\dao\\AutoValidationPolicyDao.java");
//		File file = new File("D:\\workspace\\ITQuality\\ITQualityBDT\\src\\sfmi\\component\\squad\\itqualitybdt\\enums\\NoticePtmType.java");
//		File file = new File("D:\\ANTLR_WORK\\simple_workspace\\MS\\AppPushUIWeb\\web\\src\\sfmi\\ui\\push\\util\\DateConverter.java");
		File file = new File("D:\\ANTLR_WORK\\test_workspace\\VD\\XDCR_MyAnycarBatch\\XDMyAnycarBatch\\src\\sfmi\\xdbatch\\myanycar\\daily\\processor\\OtherSmsProcessor.java");

		try {
			ClassInfo classInfo = JavaSourceParser.parse(file); 
			
//			Assert.assertEquals("SqlMapAutoValidationPolicyDao", classInfo.getName());
//			Assert.assertEquals("sfmi.component.squad.itquality.dao.sqlmap", classInfo.getPackageName());
			
			List<MethodInfo> methodList = classInfo.getMethodInfos();

			System.out.println("ClassInfo : " + classInfo.getName()); 
			
			for(MethodInfo method : methodList) {
				
				System.out.println("Method Sig : " + method.getSignature());
				
				if(method.getBlockStmt() != null) {
					System.out.println("Method ====================================="); 
					BlockStmt stmt = method.getBlockStmt();
					
					List<Statement> statements = stmt.getStmts();
					
					if(statements != null && statements.size() > 0) {
						for(Statement state : statements) {
							System.out.println("Statement : " + state.toString()); 
						}
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
