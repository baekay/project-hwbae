package parser.sql;

import static org.junit.Assert.fail;

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
 * WITH STATEMENT만 테스트 한다.
 * @author 배혜원
 * @since 2014.05.13
 *
 */
public class SQLAnalyzerParserWithQueryTest {

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
		propertyLoader = PropertyLoader.loadFromXML("sqlAnalyzerTest.xml");
	}
	
	/**
	 * WithQuery 테스트1
	 */
	@Test
	public void testWithQueryOne() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.withSelectOne");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("WITH SELECT QUERY :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		// table, column 출력
		System.out.println("--------------------SELECT1 PARSER TEST------------------------------");
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		Assert.assertEquals("02",sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 2);
	}

	/**
	 * WithQuery 테스트2
	 */
	@Test
	public void testWithQueryTwo() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.withSelectTwo");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("WITH SELECT QUERY 2 :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		// table, column 출력
		System.out.println("--------------WITH SELECT2 PARSER TEST------------------------------");
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		Assert.assertEquals("02",sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 1);
	}
	
	/**
	 * WithQuery 테스트3
	 */
	@Test
	public void testWithQueryThree() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.withSelectThree");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("WITH SELECT QUERY 3 :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		// table, column 출력
		System.out.println("---------------WITH QUERY THREE-------------------------------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		System.out.println("--------------------------------------------------------------------");
		Assert.assertEquals("02",sqlParser.getStatementType());
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 7);
	}
}
