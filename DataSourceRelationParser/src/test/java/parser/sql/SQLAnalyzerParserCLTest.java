package parser.sql;

import java.util.Properties;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import sfmi.component.mdm.common.util.PropertyLoader;

/**
 * SQL 분석 테스트 클래스
 * CL에서 사용하고 있는  SQL
 * 
 * @author 배혜원
 * @since 2014.05.14
 * 
 */
public class SQLAnalyzerParserCLTest {
	static SQLAnalyzerLexer sqlLexer;
	static CommonTokenStream tokenStream;
	static SQLAnalyzerParser sqlParser;
	static Properties propertyLoader;

	/**
	 * 초기화 메서드
	 */
	@BeforeClass
	public static void setUp() {
		System.out.println("=============== 초기화 ===============");
		sqlLexer = new SQLAnalyzerLexer();
		tokenStream = new CommonTokenStream();
		sqlParser = new SQLAnalyzerParser(tokenStream);
		propertyLoader = PropertyLoader.loadFromXML("sqlAnalyzerCLErrorTest.xml");
	}

	/**
	 * CL select Test One
	 */
	@Test
	public void testSelectQueryOne() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectOne");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");

		System.out.println("CL SELECT ONE QUERY :" + query);

		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);

		// 파서 실행
		sqlParser.statement();

		// table
		System.out.println("--------------------SELECT ONE PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 11);
	}
	
	/**
	 * CL select Test Two
	 */
	@Test
	public void testSelectQueryTwo() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectTwo");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("CL SELECT TWO QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT TWO PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 6);
	}
	
	/**
	 * CL select Test Three
	 */
	@Test
	public void testSelectQueryThree() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectThree");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT THREE QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT THREE PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 9);
	}
	
	/**
	 * CL select Test Four
	 */
	@Test
	public void testSelectQueryFour() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectFour");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Four QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT Four PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 9);
	}
	
	/**
	 * CL select Test Five
	 */
	@Test
	public void testSelectQueryFive() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectFive");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT FIVE QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT FIVE PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 9);
	}
	
	/**
	 * CL select Test Siz
	 */
	@Test
	public void testSelectQuerySix() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectSix");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Six QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT SIX PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 4);
	}
	
	/**
	 * CL select Test Seven
	 */
	@Test
	public void testSelectQuerySeven() {
		String query = propertyLoader.getProperty("sql.selectSeven");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT SEVEN QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		boolean result = true;
		
		// 파서 실행
		try {
			sqlParser.statement();
		} catch (RecognitionException e) {
			result = false;
		}
		
		Assert.assertTrue(result);
		
		// table
		System.out.println("--------------------SELECT SEVEN PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 1);
	}
	
	/**
	 * CL select Test Eight
	 */
	@Test
	public void testSelectQueryEight() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectEight");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Eight QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT Eight PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 9);
	}
	
	
	
	/**
	 * CL select Test Nine
	 */
	@Test
	public void testSelectQueryNine() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectNine");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT NINE QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT NINE PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 9);
	}
	
	/**
	 * CL select Test TEN
	 */
	@Test
	public void testSelectQueryTen() {
		String query = propertyLoader.getProperty("sql.selectTen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT TEN QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		boolean result = true;
		
		// 파서 실행
		try {
			sqlParser.statement();
		} catch (RecognitionException e) {
			result = false;
		}
		
		Assert.assertTrue(result);
		// table
		System.out.println("--------------------SELECT TEN PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 4);
	}
	
	/**
	 * CL select Test Eleven
	 */
	@Test
	public void testSelectQueryEleven() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectEleven");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT ELEVEN QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT ELEVEN PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 8);
	}
	
	/**
	 * CL select Test Twelve
	 */
	@Test
	public void testSelectQueryTwelve() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectTwelve");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Twelve QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT Twelve PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 1);
	}
	
	/**
	 * CL select Test Thirteen
	 */
	@Test
	public void testSelectQueryThirteen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectThirteen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Thirteen QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT Thirteen PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 8);
	}
	
	/**
	 * CL select Test Fourteen
	 */
	@Test
	public void testSelectQueryFourteen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectFourteen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Fourteen QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT Fourteen PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 7);
	}
	
	/**
	 * CL select Test Fifteen
	 */
	@Test
	public void testSelectQueryFifteen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectFifteen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Fifteen QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT Fifteen PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 5);
	}
	/**
	 * CL select Test sixteen
	 */
	@Test
	public void testSelectQuerySixteen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectSixteen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT Sixteen QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT Sixteen PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 5);
	}
	/**
	 * CL select Test seventeen
	 */
	@Test
	public void testSelectQuerySeventeen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectSevenTeen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT selectSevenTeen QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT selectSeventeen PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 6);
	}
	/**
	 * CL select Test selectEightTeen
	 */
	@Test
	public void testSelectQuerySevenEigthTeen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectEightTeen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("SELECT selectEightTeen QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT selectEightTeen PARSER TEST------------------------------");
		Assert.assertEquals("02", sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 1);
	}
	
	/**
	 * CL Update Test ONE
	 */
	@Test
	public void testUpdateQueryOne() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.updateOne");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("UPDATE ONE QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------UPDATE ONE PARSER TEST------------------------------");
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertEquals("03", sqlParser.getStatementType());
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 3);
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getColumnList().size() == 6);
	}
	
	/**
	 * CL Insert Test ONE
	 */
	@Test
	public void testInsertQueryOne() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.insertOne");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("INSERT ONE QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------INSERT ONE PARSER TEST------------------------------");
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertEquals("01", sqlParser.getStatementType());
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 0);
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getColumnList().size() == 12);
	}
	
	
	/**
	 * Test SQL
	 */
//	@Test
//	public void testQuery() throws RecognitionException {
//		String query = propertyLoader.getProperty("testSQL");
//		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
//		
//		System.out.println("TEST QUERY :" + query);
//		
//		CharStream charStream = new ANTLRStringStream(query);
//		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
//		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
//		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
//		
//		// 파서 실행
//		sqlParser.statement();
//		
//		// table
//		System.out.println("--------------------TEST QUERY TEST------------------------------");
//		Assert.assertEquals("SELECT", sqlParser.getStatementType());
//		System.out.println("TABLE : " + sqlParser.getTableList());
//		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
//		
//		System.out.println("--------------------------------------------------------------------");
//		Assert.assertTrue(sqlParser.getTableList().size() == 0);
//		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
//		Assert.assertTrue(sqlParser.getSelectTableList().size() == 6);
//	}

}
