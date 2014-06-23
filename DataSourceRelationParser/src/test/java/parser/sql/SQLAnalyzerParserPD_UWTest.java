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
import sfmi.component.mdm.handler.ExceptionHandler;

/**
 * SQL 분석 테스트 클래스
 * PD, UW(상품, 심사)에서 사용하고 있는  SQL
 * 
 * @author 배혜원
 * @since 2014.05.16
 * 
 */
public class SQLAnalyzerParserPD_UWTest {
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
		propertyLoader = PropertyLoader.loadFromXML("sqlAnalyzerPDUWErrorTest.xml");
	}

	/**
	 * CL select Test One
	 */
	@Test
	public void testSelectQueryOne() {
		String query = propertyLoader.getProperty("sql.selectOne");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");

		System.out.println("CL SELECT ONE QUERY :" + query);

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
	}
	
	/**
	 * CL select Test Two
	 */
	@Test
	public void testSelectQueryTwo() {
		String query = propertyLoader.getProperty("sql.selectTwo");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");

		System.out.println("CL SELECT TWO QUERY :" + query);

		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);

		// 파서 실행
		try {
			sqlParser.statement();
		} catch (RecognitionException e) {
//			ExceptionHandler.handle(e, null, null, null, query, null);
		}

		// table
		System.out.println("--------------------SELECT TWO PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 1);
	}
	
	/**
	 * TD select Test Three
	 */
	@Test
	public void testSelectQueryThree() {
		String query = propertyLoader.getProperty("sql.selectThree");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");

		System.out.println("TD SELECT THREE QUERY :" + query);

		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);

		// 파서 실행
		try {
			sqlParser.statement();
		} catch (RecognitionException e) {
//			ExceptionHandler.handle(e, null, null, null, query, null);
		}

		// table
		System.out.println("--------------------SELECT THREE PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==3);
	}
	/**
	 * TD select Test Four
	 */
	@Test
	public void testSelectQueryFour() {
		String query = propertyLoader.getProperty("sql.selectFour");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("TD SELECT Four QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		try {
			sqlParser.statement();
		} catch (RecognitionException e) {
//			ExceptionHandler.handle(e, null, null, null, query, null);
		}
		
		// table
		System.out.println("--------------------SELECT FOUR PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==9);
	}
	/**
	 * TD select Test Five
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQueryFive() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectFive");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("TD SELECT FIVE QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT FIVE PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==5);
	}
	/**
	 * TD select Test Six
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQuerySix() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectSix");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("TC SELECT SIX QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT SIX PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==1);
	}
	/**
	 * TD select Test Seven
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQuerySeven() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectSeven");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("TC SELECT SEVEN QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT SEVEN PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==1);
	}
	/**
	 * TD select Test Eight
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQueryEight() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectEight");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("CS SELECT Eight QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT EIGHT PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==3);
	}
	/**
	 * TD select Test Nine
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQueryNine() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectNine");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println(".. SELECT NINE QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT NINE PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==2);
	}
	/**
	 * INSERT에 컬럼명이 존재하지 않을 때 
	 *  * 세팅 테스트 
	 * @throws RecognitionException 
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
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		System.out.println("COLUMN : " + sqlParser.getColumnList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getColumnList().size() == 1);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==0);
	}
	/**
	 * INSERT TEST, 
	 *  COLUMN ORDER, DESC
	 * @throws RecognitionException 
	 */
	@Test
	public void testInsertQueryTwo() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.insertTwo");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("INSERT Two QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------INSERT TWO PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		System.out.println("COLUMN : " + sqlParser.getColumnList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getColumnList().size() == 4);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==0);
	}
	/**
	 * UPDATE TEST, 
	 *  $, # TEST
	 * @throws RecognitionException 
	 */
	@Test
	public void testUpdateQueryTwo() throws RecognitionException {
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
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		System.out.println("COLUMN : " + sqlParser.getColumnList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getColumnList().size() == 11);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==0);
	}
	/**
	 * UPDATE TEST, 
	 *  $, # TEST
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQueryEleven() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectEleven");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("selectEleven QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------selectEleven PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		System.out.println("COLUMN : " + sqlParser.getColumnList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==1);
	}
	
	/**
	 * TD select Test Ten
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQueryTen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectTen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println(".. SELECT TEN QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT TEN PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() ==0);
}
	/**
	 * TD select Test 12
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQueryTwelve() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectTwelve");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println(".. SELECT 12 QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
			sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT 12 PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
//		Assert.assertTrue(sqlParser.getSelectTableList().size() ==3);
	}
	/**
	 * TD select Test 13
	 * @throws RecognitionException 
	 */
	@Test
	public void testSelectQueryThirteen() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.selectThirteen");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println(".. SELECT 13 QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		// 파서 실행
		sqlParser.statement();
		
		// table
		System.out.println("--------------------SELECT 13 PARSER TEST------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
//		Assert.assertTrue(sqlParser.getSelectTableList().size() ==3);
	}
}