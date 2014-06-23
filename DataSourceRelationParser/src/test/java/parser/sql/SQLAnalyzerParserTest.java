package parser.sql;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import sfmi.component.mdm.common.util.PropertyLoader;


/**
 * SQLParserGrammerParser 테스트클래스
 * @author 배혜원
 * @since 2014.02.19
 */
public class SQLAnalyzerParserTest {
	
	static SQLAnalyzerLexer sqlLexer;
	static CommonTokenStream tokenStream;
	static SQLAnalyzerParser sqlParser;
	static Properties propertyLoader;
	
	/**
	 *  초기화 메서드 xt
	 */
	@BeforeClass
	public static void setup() {
		System.out.println("=============== 초기화 ===============");
		sqlLexer = new SQLAnalyzerLexer();
		tokenStream = new CommonTokenStream();
		sqlParser = new SQLAnalyzerParser(tokenStream);
		propertyLoader = PropertyLoader.loadFromXML("sqlAnalyzerTest.xml");
	}
	
	
	/**
	 * TODO : 정리할 리소스 있으면 넣어주세요....
	 */
	@AfterClass
	public static void release() {
		System.out.println("=============== 끝 ===============");
	}
	
	
	/**
	 * select1 쿼리 테스트 메서드 
	 * 
	 * @throws RecognitionException
	 */
	@Test
	public void testSelectQuery1() throws RecognitionException{
		String query = propertyLoader.getProperty("sql.selectTest1");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
//		query = query.replaceAll("(\\#|\\$){1}(\\S+)(\\#|\\$){1}","\'\'");
//		query = query.replaceAll("'([^'\\s]+)'", "\'\'");
		
		System.out.println("select1 Query  :" + query);
		
		sqlLexer.setCharStream(new ANTLRStringStream(query)); 
		tokenStream.setTokenSource(sqlLexer);
		sqlParser.setTokenStream(tokenStream);
		
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
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 6);
	}
	
	/**
	 * selectTest2 쿼리 테스트 메소드
	 * @throws RecognitionException
	 */
	@Test
	public void testSelectQuery2() throws RecognitionException{
		String query = propertyLoader.getProperty("sql.selectTest2");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
//		query = query.replaceAll("(\\#|\\$){1}(\\S+)(\\#|\\$){1}","\'\'");
//		query = query.replaceAll("'([^'\\s]+)'", "\'\'");
		
		System.out.println("selectTest2 Query  :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		// table, column 출력
		System.out.println("--------------------SELECT2 PARSER TEST------------------------------");
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		Assert.assertEquals("02",sqlParser.getStatementType());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 6);
	}
	
	/**
	 * selectTest3 쿼리 테스트 메소드
	 * @throws RecognitionException
	 */
	@Test
	public void testSelectQuery3() throws RecognitionException{
		String query = propertyLoader.getProperty("sql.selectTest3");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
//		query = query.replaceAll("(\\#|\\$){1}(\\S+)(\\#|\\$){1}","\'\'");
//		query = query.replaceAll("'([^'\\s]+)'", "\'\'");
		
		System.out.println("selectTest3 Query  :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		System.out.println("TABLE : " + sqlParser.getTableList());
		Assert.assertEquals("02",sqlParser.getStatementType());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 4);
	}
	
	/**
	 * selectTest4 쿼리 테스트 메소드
	 * @throws RecognitionException
	 */
	@Test
	public void testSelectQuery4() throws RecognitionException{
		String query = propertyLoader.getProperty("sql.selectTest4");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
//		query = query.replaceAll("(\\#|\\$){1}(\\S+)(\\#|\\$){1}","\'\'");
//		query = query.replaceAll("'([^'\\s]+)'", "\'\'");
		
		System.out.println("selectTest4 Query  :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		System.out.println("----------------------SELECT TEST 4----------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		Assert.assertEquals("02",sqlParser.getStatementType());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 2);
	}
	
	/**
	 * selectTest5 쿼리 테스트 메소드
	 * @throws RecognitionException
	 */
	@Test
	public void testSelectQuery5() throws RecognitionException{
		String query = propertyLoader.getProperty("sql.selectTest5");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("selectTest5 Query  :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		System.out.println("----------------------SELECT TEST 5----------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		Assert.assertEquals("02",sqlParser.getStatementType());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 4);
	}
	
	/**
	 * selectTest6 쿼리 테스트 메소드
	 * @throws RecognitionException
	 */
	@Test
	public void testSelectQuery6() throws RecognitionException{
		String query = propertyLoader.getProperty("sql.selectTest6");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		
		System.out.println("selectTest6 Query  :" + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		//파서 실행
		sqlParser.statement();
		
		System.out.println("----------------------SELECT TEST 6----------------------");
		System.out.println("TABLE : " + sqlParser.getTableList());
		Assert.assertEquals("02",sqlParser.getStatementType());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		

		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 0);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 4);
	}
	
	
	/**
	 * Merge 쿼리 테스트 메서드 
	 * 
	 * @throws RecognitionException
	 * @throws IOException 
	 */
	@Test
	public void testMergeQuery() throws RecognitionException, IOException{
		String query = propertyLoader.getProperty("sql.merge");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
//		query = query.replaceAll("(\\#|\\$){1}(.*)(\\#|\\$){1}","\'\'");
//		query = query.replaceAll("((\\')(.*)(\\'))", "\'\'");
//		ANTLRInputStream stream = new ANTLRInputStream( new ByteArrayInputStream(query.getBytes()), "utf-8");
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		sqlParser.statement();

		System.out.println("MERGE QUERY : "+query);

		System.out.println("--------------------MERGE INTO PARSER TEST------------------------------");
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		
		System.out.println("COLUMN : " + sqlParser.getColumnList());

		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		Assert.assertEquals("05",sqlParser.getStatementType());
		System.out.println("--------------------------------------------------------------------");
		
		Assert.assertEquals("NCDP00TB_D", sqlParser.getTableList().get(0));
		Assert.assertTrue(sqlParser.getColumnList().size() == 25);
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
	}
	
	
	/**
	 * insert 쿼리 테스트 메서드
	 * @throws RecognitionException
	 */ 
	@Test
	public void testInsertQuery() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.insert");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");

		System.out.println("INSERT QUERY : " + query);
		
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		sqlParser.statement();


		System.out.println("--------------------INSERT PARSER TEST------------------------------");
		
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		Assert.assertEquals("01",sqlParser.getStatementType());
		
		
		System.out.println("--------------------------------------------------------------------");
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getColumnList().size() == 24);
	}
	
	/**
	 * Delete 쿼리 테스트 메서드
	 * @throws RecognitionException
	 */
	@Test
	public void testDeleteQuery() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.delete");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		System.out.println("query : " + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		sqlParser.statement();

		Assert.assertEquals("PQRT04TB", sqlParser.getTableList().get(0));

		System.out.println("--------------------DELETE PARSER TEST------------------------------");
		
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		Assert.assertEquals("04",sqlParser.getStatementType());
		Assert.assertTrue(sqlParser.getColumnList().size() == 4);
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 3);
		System.out.println("--------------------------------------------------------------------");
	}
	
	/**
	 * update 쿼리 테스트 메서드
	 * @throws RecognitionException
	 */
	@Test
	public void testUpdateQuery() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.update");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		System.out.println("query : " + query);
//		query = query.replaceAll("(\\#|\\$){1}(\\w+)(\\#|\\$){1}$","\'\'");
//		query = query.replaceAll("'([^'\\s]+)'", "\'\'");
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		sqlParser.statement();
		

		Assert.assertEquals("PPAG04TB", sqlParser.getTableList().get(0));

		System.out.println("--------------------UPDATE PARSER TEST------------------------------");
		
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		
		Assert.assertTrue(sqlParser.getColumnList().size() == 2);
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		Assert.assertEquals("03",sqlParser.getStatementType());
		System.out.println("--------------------------------------------------------------------");
	}
	
	/**
	 * update2 쿼리 테스트 메서드
	 * @throws RecognitionException
	 */
	@Test
	public void testUpdateQuery2() throws RecognitionException {
		String query = propertyLoader.getProperty("sql.updateTest2");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		System.out.println("UPDATE QUERY2: " + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		sqlParser.statement();

//		Assert.assertEquals("PPAG04TB", sqlParser.getTableList().get(0));

		System.out.println("--------------------UPDATE PARSER TEST------------------------------");
		
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 0);
		Assert.assertTrue(sqlParser.getColumnList().size() == 4);
		Assert.assertEquals("03",sqlParser.getStatementType());
		System.out.println("--------------------------------------------------------------------");
	}
	
	
	/**
	 * Merge쿼리 테스트
	 * select 테이블 분리 테스트
	 * @throws RecognitionException
	 */
	@Test
	public void testMergeQueryTables() throws RecognitionException{
		String query = propertyLoader.getProperty("sql.mergeTest2");
		query = query.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");
		System.out.println("query : " + query);
		
		CharStream charStream = new ANTLRStringStream(query);
		SQLAnalyzerLexer sqlLexer = new SQLAnalyzerLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(sqlLexer);
		SQLAnalyzerParser sqlParser = new SQLAnalyzerParser(tokenStream);
		
		sqlParser.statement();
		


		System.out.println("-----------------Merge Query select Table 분리 테스트-----------------");
		
		for(int i=0; i < sqlParser.getColumnList().size() ; i++) {
			System.out.println("COLUMN " + i + " : " + sqlParser.getColumnList().get(i));
		}
		
		System.out.println("COLUMN : " + sqlParser.getColumnList());
		System.out.println("TABLE : " + sqlParser.getTableList());
		System.out.println("SELECT TABLE : " + sqlParser.getSelectTableList());
		Assert.assertEquals("05",sqlParser.getStatementType());
		Assert.assertTrue(sqlParser.getTableList().size() == 1);
		Assert.assertTrue(sqlParser.getSelectTableList().size() == 1);
		Assert.assertTrue(sqlParser.getColumnList().size() == 13);
		System.out.println("----------------------------------------------------------------------");
	}
	

	
}
