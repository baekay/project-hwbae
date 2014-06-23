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

import org.junit.Assert;
import org.junit.Test;

import sfmi.component.mdm.dto.ClassInfo;
import sfmi.component.mdm.dto.MethodInfo;

/**
 * Batch Reader(InHelper) 
 * 클래스에서 XML 파일과 SQL ID 추출 테스트 
 * @author hwbae
 *
 */
public class SqlFinderTest {
	
	@Test
	public void testSqlFileLoad() {
		String sqlFile = "D:\\workspace\\PO\\XDPOCloseComponent\\XdCarRenewalBatch\\conf\\sfmi\\xdbatch\\close\\renewal\\sqlmap\\CarRenewalRate_dao.xml";
		
		try {
			String sql = SqlFinder.getSql(sqlFile, "MG.selectPPKD06TB");
			Assert.assertNotNull(sql);
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testGetSqlInfo() throws Exception {
//		String helperFile = "D:\\ANTLR_WORK\\test_workspace\\PO\\XDPOCloseComponent\\XdOrgCloseBatch\\src\\sfmi\\xdbatch\\close\\orgclose\\monthly\\reader\\LowTaxSendListExtractReadHelper.java";
//		String helperFile = "F:\\ANTLR_WORK\\antlr_workspace\\PO\\XDPOCloseComponent\\XdNewAgrmBatch\\src\\sfmi\\xdbatch\\close\\newagrm\\effectForm\\reader\\EffectForm1Helper.java";
//		String helperFile = "D:\\SFMI_WORK\\indigo_workspace\\PO\\XDPOCloseComponent\\XdPOCarETCBatch\\src\\sfmi\\xdbatch\\close\\pocaretc\\reader\\CustomerForRenewalEventHlper.java";
//		String helperFile = "D:\\SFMI_WORK\\indigo_workspace\\PO\\XDPOCloseComponent\\XdPOBatchEtcBatch\\src\\sfmi\\xdbatch\\close\\pobatchetc\\submit\\reader\\InsureFraud07Helper.java";
//		String helperFile = "D:\\SFMI_WORK\\indigo_workspace\\PD\\XDProductBatch\\XdProductInfo\\src\\sfmi\\xdbatch\\product\\productinfo\\reader\\PrdChangeInfoReaderHelper.java";
//		String helperFile = "D:\\SFMI_WORK\\indigo_workspace\\PO\\XDPOCloseComponent\\XdPOCarETCBatch\\src\\sfmi\\xdbatch\\close\\pocaretc\\reader\\CustomerForRenewalEventHlper.java";
//		String helperFile = "D:\\SFMI_WORK\\indigo_workspace\\FC\\XDFCBatchComponent\\XdFinanceClosingBatch\\src\\sfmi\\xdbatch\\fc\\closing\\reader\\PstmChkAcc1424DataHelper.java";
//		String helperFile = "D:\\SFMI_WORK\\indigo_workspace\\CL\\XDCCBatch\\XdClaimCarMonthlyBatch\\src\\sfmi\\xdbatch\\claim\\carmonthly\\reader\\ClaimCarMonthlyDbReader.java";
		String helperFile = "D:\\ANTLR_WORK\\test_workspace\\LC\\XDLoanBatchComponent\\XdLoanAutoTransferBatch\\src\\sfmi\\xdbatch\\loan\\autotransfer\\reader\\AutoTransferSmsExtractFillingHelper.java";

		
			ClassInfo classInfo = JavaSourceParser.parse(new File(helperFile));
//			String pattern = "(.*)?(\\{)(\\s)?(\")(.*.xml)(\")(.*)(,)(\\s)?(\")(.*)(\")(.*)";
			
//			new String[]{   ,   }
			
			/**
			 * 
			 * 1. String[]{   ,   } 패턴으로 추출...
			 *   1-1. 추출이 되었을경우 각각 따옴표여부 추가확인
			 *       if (존재할 경우 그대로) 사용
			 *       else (존재하지 않을경우) Statement 에서 변수값 바인딩 추출
			 * 2. 1번으로 추출이 안 되었을 경우 word[Digit] 패턴으로 추출
			 *    (return 되는 변수명을 word 키워드로 사용)
			 *   2-1. 추출이 되었을경우 각각 따옴표여부 추가확인
			 *   	 if (존재할 경우 그대로) 사용 -> Loop 돌려서 List에 넣는다
			 *   	 else (존재하지 않을경우) Statement 에서 변수값 바인딩 추출
			 *   
			 */
			
			// String[] { , } 찾는 패턴
			Pattern assignInBracePattern = Pattern.compile("(.*)?(String(\\s+)?\\[(\\s+)?\\](.*)?\\{)(.*)(,)(.*)(\\}.*)");
//			String pattern2 = "word[Digit]";
			
			Pattern assignEachArrayPattern;
			// return값이 온전한 String인지 체크하는 패턴
			Pattern assignOneStringPattern;
			Matcher matcher;
			// 결과 저장 객체
			List<String> xmlFilePathList = new ArrayList<String>();
			List<String> sqlIdList = new ArrayList<String>();

			for(MethodInfo methodInfo : classInfo.getMethodInfos() ) {
				if(methodInfo.getName().equals("getSqlInfo")) {
					BlockStmt blockStmt = methodInfo.getBlockStmt();
					for(Statement statement : blockStmt.getStmts()) {
						matcher = assignInBracePattern.matcher(statement.toString());
						
						if(matcher.find()) {
							
							matcher.reset();
							
							while(matcher.find()){
								String xmlPath = matcher.group(6).trim();
								String sqlId = matcher.group(8).trim();
								
								
								// xmlpath 따옴표 존재 
								if(xmlPath.contains("\"")){
									// 따옴표 제거 후 add
									xmlPath = xmlPath.replace("\"", "");
									xmlFilePathList.add(xmlPath);
								} else {
									//Class Field에서 먼저 찾는다..
									if(classInfo.getVariables().get(xmlPath) != null){
										xmlPath = classInfo.getVariables().get(xmlPath);
										xmlPath = xmlPath.replace("\"", "");
										xmlFilePathList.add(xmlPath);
										
									} else {
										// 메소드 내에서 찾는다
										xmlFilePathList = returnBindingValue(blockStmt, xmlPath);
										
									}// end else
									
	
								}
								
								// sqlId 따옴표 존재 
								if(sqlId.contains("\"")){
									// 따옴표 제거 후 add
									sqlId = sqlId.replace("\"", "");
									sqlIdList.add(sqlId);
								} else {
									//return sqlId
									sqlIdList = returnBindingValue(blockStmt, sqlId);
								}
							

							}// end while
						} else{
//							matcher = assignSqlInfoPattern2.matcher(statement.toString());
							// return variable 값 추출
							String returnVariable = returnVariable(methodInfo.getBlockStmt());
							
							// return variable값이 온전한 문자 인지 체크
							assignOneStringPattern = Pattern.compile("(\\s)+ | (\\W)");
							Matcher variableMatcher = assignOneStringPattern.matcher(returnVariable);
							
							/*
							 * 패턴이 포함이면 올바르지 않은 return variable값이다
							 */
							if(!variableMatcher.find()){
								//return value값으로 returnValue[0] = "~.xml"; 을 찾는다 
								assignEachArrayPattern = Pattern.compile("(.*)?("+returnVariable+")(\\[)(\\d)(\\])(\\s\\=\\s)(.*)(;)");
								
//								String beforeReplaceStr = statement.toString();
//								String afterStr = beforeReplaceStr.replace("\n", "");
//								afterStr = afterStr.replace("\r\n", "");
								
//								Matcher arrayMatcher = assignEachArrayPattern.matcher(afterStr);
								Matcher arrayMatcher = assignEachArrayPattern.matcher(statement.toString());
								
								if(arrayMatcher.find()) {
									
									// index 초기화 
									arrayMatcher.reset();
									
									while(arrayMatcher.find()){
										
										for(int i =0; i < arrayMatcher.groupCount(); i++){
											System.out.println("group(" + i + ")" + arrayMatcher.group(i));
										}
										
										System.out.println("----------------------------------------------------");
										String sqlInfoValue = arrayMatcher.group(7);
										String index = arrayMatcher.group(4);
										
										System.out.println("index : " + index);
										
										// xmlPath인지 sqlId 인지 판단
										if(index.equals("0")){
											// 따옴표 존재 
											if(sqlInfoValue.contains("\"")){
												sqlInfoValue = sqlInfoValue.replace("\"", "");
												xmlFilePathList.add(sqlInfoValue);
												
											} else {
												xmlFilePathList = returnBindingValue(blockStmt, sqlInfoValue);
											}
										} else if(index.equals("1")){
											
											if(sqlInfoValue.contains("\"")){
												sqlInfoValue = sqlInfoValue.replace("\"", "");
												sqlInfoValue = sqlInfoValue.trim();
												
												if(!("").equals(sqlInfoValue)){
													sqlIdList.add(sqlInfoValue);
													System.out
															.println("SQL ID : " + sqlInfoValue);
												}
												
											} else {
												sqlIdList.addAll(returnBindingValue(blockStmt, sqlInfoValue));
											}
											
											
										} else {
											// 로그찍어랏..
											
										}
		
											// 초기화
		
										/*
										 * 2.1 
										 * 2.2
										 */
									}// end while
								}else {
									// log만 찍는다. 패턴에 들어오지 않음. 추출값이 없음.
								}
							} else{
								// return variable값이 올바르지 않음.
							}
						} 
					}
				}
			}
			System.out.println("xmlFilePath : "+xmlFilePathList + ", sqlIdList : " + sqlIdList);
//			Assert.assertEquals("sfmi/xdbatch/product/productinfo/dao/sqlmap/productDBSelectmpl_dao.xml", xmlFilePathList.get(0));
//			Assert.assertEquals("PD.selectPrdChangeInfo",sqlIdList.get(0));
			
		
	}
	
	/**
	 * binding된 변수의 Value를 찾는다..
	 * @param variable
	 * @return
	 */
	private List<String> returnBindingValue(BlockStmt blockStmt, String variable){
		// return 객체
		List<String> valueList = new ArrayList<String>();
		// 패턴
		String findVariableValue = "(.*)?("+variable+"){1}(\\s\\=\\s)(\")(.*)(\")";
		Pattern findVariableValuePattern = Pattern.compile(findVariableValue);
		Matcher matcher;
		
		//Statement 분석하여 value값 추출 
		for(Statement state : blockStmt.getStmts()){
			matcher = findVariableValuePattern.matcher(state.toString());
			
			// 패턴일치
			if(matcher.find()){
				matcher.reset();
				
				while(matcher.find()){
					String matcherValue = matcher.group(5).trim();
					if(matcherValue != null && !("").equals(matcherValue)){
						
						if(!valueList.contains(matcherValue)){
							valueList.add(matcherValue);
						} 
					}
				}
				
			} else {
				//로그 찍긔...
			}
		}// end for
		
		return valueList;
		
	}
	
	/**
	 * return Variable값 추출
	 * @return
	 */
	private String returnVariable(BlockStmt blockStmt){
		Pattern assignReturnValuePattern = Pattern.compile("(return)(.*)(;)");
		Matcher matcher;
		String returnVariable = null;
		
		//return variable 값 리턴 
		for(Statement state : blockStmt.getStmts()){
			String str  = state.toString().replace("\r\n", "");
			matcher = assignReturnValuePattern.matcher(str);
			
			if(matcher.find()){
				returnVariable = matcher.group(2).trim();
				return returnVariable;
			} else {

			}
		}
		return returnVariable;
	}
	
}
