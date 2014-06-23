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

import org.junit.Test;

import sfmi.component.mdm.context.PropertyContext;
import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.MethodInfo;

public class DbWriterSqlFinderTest {

	@Test
	public void test() throws Exception {
//		String outDaoFile = "F:\\ANTLR_WORK\\antlr_workspace\\PO\\XDPOCloseComponent\\XdPOBatchEtcBatch\\src\\sfmi\\xdbatch\\close\\pobatchetc\\submit\\writer\\CollectChange02Writer.java";
//		String outDaoFile = "F:\\ANTLR_WORK\\antlr_workspace\\PO\\XDPOCloseComponent\\XdOrgCloseBatch\\src\\sfmi\\xdbatch\\close\\orgclose\\monthly\\writer\\LowTaxSendWriter.java";
//		String outDaoFile = "F:\\ANTLR_WORK\\antlr_workspace\\PO\\XDGeneralBatch\\XdGeneralDailyGoldcolorBatch\\src\\sfmi\\xdbatch\\general\\goldcolor\\daily\\writer\\DCDSContract0ADbWriter.java";
//		String outDaoFile = "F:\\ANTLR_WORK\\antlr_workspace\\PO\\XDPOCloseComponent\\XdPOBatchEtcBatch\\src\\sfmi\\xdbatch\\close\\pobatchetc\\submit\\writer\\PlanAdd04Writer.java";
//		String outDaoFile = "D:\\SFMI_WORK\\indigo_workspace\\FC\\XDFCBatchComponent\\XdFinanceOneCallBatch\\src\\sfmi\\xdbatch\\fc\\onecall\\writer\\PstmTempDataInsertWriter.java";
		String outDaoFile = "D:\\ANTLR_WORK\\temp_workspace\\ST\\XDCR_SmartTMBatch\\XDSmartTMBatch\\src\\sfmi\\xdbatch\\smarttm\\cust\\processor\\dao\\JdbcCustDateUploadFromCMSDao.java";
		
		
		PropertyContext.setTargetDir("D:\\ANTLR_WORK\\temp_workspace");
		/**
		 * outDao클래스 내에서 SqlFinder.getSql( , )을 패턴으로 추출한다.
		 *  1. " 여부 확인 
		 *  	if(존재시 사용)
		 *  	else (Statement 에서 변수값 바인딩 추출) -> 메소드 내에서 or 클래스 내에서 
		 */
		
		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+[^\\)])(\\))(.*);");
		Matcher matcher;
		
		List<String> xmlPathList = new ArrayList<String>();
		List<String> sqlIdList = new ArrayList<String>();
		
		try {
			ClassInfo classInfo = JavaSourceParser.parse(new File(outDaoFile));
			
			//class Field에서 찾긔 
			
			for(MethodInfo methodInfo : classInfo.getMethodInfos()){
				BlockStmt blockStmt = methodInfo.getBlockStmt();
				
				for(Statement statement : blockStmt.getStmts()){
					
					matcher = useSqlFinderApiPattern.matcher(statement.toString());
					
					if(matcher.find()){

						matcher.reset(); 
						
						while(matcher.find()) {
							
							System.out.println("statement : " + statement.toString());
							
							String xmlPath = matcher.group(3).trim();
							String sqlId = matcher.group(5).trim();
							
							// 따옴표 확인
							if(xmlPath.contains("\"")){
								// 바로 add
							} else {
								// 메소드 내에서 찾는다
								xmlPathList = returnBindingValue(blockStmt, xmlPath);
								
								// Class Field 에서 찾는다.
								if(xmlPathList.size() > 0){
	
									
								} else {
									if(classInfo.getVariables().get(xmlPath) != null){
										xmlPathList.add(classInfo.getVariables().get(xmlPath));
	
									} else {
	
									}
								}
							}
							if(sqlId.contains("\"")){
								sqlIdList.add(sqlId);
								// sql Id List에 추가한다.
	
							} else {
								sqlIdList.addAll(returnBindingValue(blockStmt, sqlId));
								
								if(sqlIdList.size() > 0){
									// sqlId 추출함
								} else { 
									// class Field내에서 선언되어있을 경우..?
								}
							}
							}
					} else {
						// 패턴이 일치하지 않는다..
					}
				}
			}
			
			System.out.println("XML PATH : " + xmlPathList);
			System.out.println("SQL ID : " + sqlIdList);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * binding된 변수의 Value를 찾는다..
	 * @param variable
	 * @return
	 */
	private List<String> returnBindingValue(BlockStmt blockStmt, String variable){
		// return 객체
		List<String> valueList = new ArrayList<String>();
		System.out.println("variable : " +variable);
		// 패턴
		String findVariableValue = "(.*)?("+variable+"){1}(\\s)(\\=)(\\s)(\")(.*)(\")";
		Pattern findVariableValuePattern = Pattern.compile(findVariableValue);
		Matcher matcher;
		
		//Statement 분석하여 value값 추출 
		for(Statement state : blockStmt.getStmts()){
			matcher = findVariableValuePattern.matcher(state.toString());
			
			// 패턴일치
			if(matcher.find()){
				matcher.reset();
				
				while(matcher.find()){
					valueList.add(matcher.group(5).trim());
				}
				
			} else {
				//로그 찍긔...
			}
		}// end for
		
		return valueList;
		
	}

}
