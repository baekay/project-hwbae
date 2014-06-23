package parser.sql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegTest {

	@Test
	public void test() {
		Pattern sqlXmlFilePattern = Pattern.compile("(.*)?(\")(.*)(.xml\")(.*)");
		Pattern getSqlReturnPattern = Pattern.compile("^(return)(.*)(;)$");
		Pattern eachAssignSqlInfo = Pattern.compile("(.*)?(sqlId)(\\[\\d\\])(\\s\\=\\s)(.*)(;)");
//		Pattern assignEachArrayPattern = Pattern.compile("(.*)?(sqlId)(\\[)(\\d)(\\])(\\s+\\=\\s+)(\")(.*)(\")");
		Pattern useSqlFinderApiPattern = Pattern.compile("(.*)?(SqlFinder.getSql\\()(\\S+)(,)([^,]\\S+)(\\))(.*)");
		Pattern useDaoMethodPattern = Pattern.compile("(.*)?(carPeriodicalDao).([^\\(]\\w+)\\((.*)");
		Pattern propertyDaoRefPattern = Pattern.compile("(p:)(\\w+)(-ref)$");
		Pattern defaultSqlIdPattern = Pattern.compile("(.*)?(update|delete|insert|queryForObject|queryForList|queryForMap){1}(\\(\")(.*)(\\\"),(.*)");
		Pattern assignSqlIdPattern = Pattern.compile("(.*)?(update|delete|insert|queryForObject|queryForList|queryForMap){1}(\\()(\\w+)(.*)");
		Pattern testPattern = Pattern.compile("(.*)?(sqlId)(\\[)(\\d)(\\])(\\s+\\=\\s+)(.*)(;)$");
		Pattern methodPattern = Pattern.compile("(.*)(\\s+)(\\w+)(\\((.*)\\))");
		
		Pattern findVariableValuePattern = Pattern.compile("(.*)?(sqlId)(\\s+\\=\\s+)(\")(.*)(\")");
		Pattern stringWordTestPattern = Pattern.compile("(\")([^\"](.*))(\")");
		
		Matcher readerMatcher;
		String str = "return sqlInfo = new String[] { \"sfmi/xdbatch/close/productdesc/longterm/sqlmap/nobleFriends_dao.xml\", \"MG.selectNobleFriends\" };";
		String test1 = "sqlId[0] = \"sfmi/xdbatch/close/myanycar/sqlmap/ChkContractForLong.xml\";";
		String test2 = " sqlId[1] = \"getChkContractForLong\";";
		String test3 = "sqlInfo = new    String [    ]    {   \"sfmi/xdbatch/close/pobatchetc/sqlmap/InsureFraud07_dao.xml\",    \"MG.SELECT_PLCYNO\"};";
		String test4 = "sqlInfo = new String[] { \"sfmi/xdbatch/close/pobatchetc/sqlmap/InsureFraud07_dao.xml\", \"MG.SELECT_PLCYNO\" };";
		String test5 ="String[] sqlInfo = {sqlFile, sqlId};";
		String test6 = "updateCnt1 = getSimpleJdbcTemplate().update(SqlFinder.getSql(SQL_CONFIG, \"updatePPET07TB\"), paramSource );\"";
		String test7 = "\u25CB";
		String test8 = "return new String[]{XML_SQL, sqlId};";
		String test9 = " try { "+
				"carPeriodicalDao.updateClaimEndInfo(claimEndInfo, oDate.toString()); "+
				" outCount++;" +
				"} catch (Exception e) { " +
				"logger.error(e.toString());" + 
				"log('종결LMS전송결과 저장에러: ' + key);" + 
				"};";
		String test10 ="String sql = SqlFinder.getSql(SQL_CONFIG, \"UPDATE_CLAIMEND_PCST09TB\");";
		String test11 ="p:deliberateBatch__sdf123Dao-ref";
		String test12 = "rtnLst =  queryForList(\"EI.selectValidContract\", param);";
		String test13 = "return (List)queryForList(\"EI.readLowtaxDeleteBatchMap\", \"\" );";
		String test14 = "return queryForList(strSqlId, condition);";
		String test15 = "if (true) { "
						+ "sqlId[1] = \"PP.selectCustomerForRenewalEvent\";"
						+"} else if (false) {"
						+ "   sqlId[1] = \"PD.SQLMAP\";"
						+ "} else {"
						 + "sqlId[1] = \"PP.selectCustomerForRenewalEvent\";" 
						+"}";
		
		String test16 = "if (FCUtil.equalCase(accGubun, \"01,02,03\")) {    sqlId = \"FC.selectQUERY_1\";} else if (FCUtil.equalCase(accGubun, \"04,05,06\")) {    sqlId = \"FC.selectQUERY_2\";}";
		String test17 = "\"DSD\"";
		String testStr = "ABCD\\SCDDS\\SDF.xml";
		String test18 = "public List selectPDSV10TBCOUNT throws SFMIException";
		System.out.println("TEST : " + testStr.replace("\\", "/"));
		
//		System.out.println("특수문자 : " + test7);
		test15 = test15.replace("\r\n", "");
		readerMatcher = eachAssignSqlInfo.matcher(test15);
		
		System.out.println("readerMatcher : "+readerMatcher.matches());
//		System.out.println(readerMatcher.group());
		System.out.println("GROUP CNT : " + readerMatcher.groupCount());
		System.out.println("readerMatcher.group(4) : " + readerMatcher.group(4).trim());
		System.out.println("readerMatcher.group(5) : " + readerMatcher.group(5).trim());
//		System.out.println("result : "+result);
		System.out.println("getCanonicalName() : " + RegTest.class.getCanonicalName());
		System.out.println("getName() : " + RegTest.class.getName());
		System.out.println("getSimpleName() : " + RegTest.class.getSimpleName());
		
		
		List<String> testList = new ArrayList<String>();
		
		testList.add("test");
		testList.add("test2");
		testList.add("test3");
		testList.add("test");
		
		System.out.println("List Size : " + testList.size());
		
		List<String> sqlIdList = new ArrayList<String>(new HashSet<String>(testList));
		
		System.out.println("afterList size() : " + sqlIdList.size());
		
	}

}
