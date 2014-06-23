// $ANTLR 3.5.1 parser\\sql\\SQLAnalyzer.g 2014-06-15 18:16:16

package parser.sql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class SQLAnalyzerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AND", "ANY", "AS", "ASC", 
		"ASSIGNEQUAL", "AVG", "A_", "AsciiStringLiteral", "AsciiStringRun", "BETWEEN", 
		"BY", "B_", "CASE", "CAST", "COLON", "COMMA", "CONNECT", "CROSS", "CURRENT", 
		"CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "C_", "DASH", "DATE", 
		"DAY", "DECODE", "DEFAULT", "DELETE", "DENSE", "DESC", "DISTINCT", "DIVIDE", 
		"DOT", "DOT_STAR", "D_", "Digit", "ELSE", "END", "ESCAPE", "EXISTS", "EXTRACT", 
		"E_", "Exponent", "FETCH", "FIRST", "FOR", "FROM", "FULL", "F_", "GREATERTHAN", 
		"GREATERTHANOREQUALTO1", "GROUP", "G_", "HAVING", "HOUR", "H_", "HexLiteral", 
		"IN", "INNER", "INSERT", "INT", "INTERVAL", "INTO", "IS", "I_", "Integer", 
		"Iso8601DateTime", "JOIN", "J_", "K_", "LEFT", "LESSTHAN", "LESSTHANOREQUALTO1", 
		"LIKE", "LPAREN", "L_", "Letter", "MATCHED", "MAX", "MAccessDateTime", 
		"MERGE", "MIN", "MINUS", "MINUTE", "MOD", "MONTH", "M_", "MultiLineComment", 
		"MultiLineComment2", "NEXT", "NOT", "NOTEQUAL1", "NOTEQUAL2", "NULL", 
		"NULLS", "NUMBER", "NVL", "N_", "NonQuotedIdentifier", "Number", "ON", 
		"ONLY", "OPTIMIZE", "OR", "ORDER", "OUTER", "OVER", "O_", "PARTITION", 
		"PLACEHOLDER", "PLUS", "PRIOR", "P_", "Q_", "QuotedIdentifier", "RANK", 
		"READ", "RIGHT", "ROW", "ROWS", "RPAREN", "R_", "Real", "SECOND", "SELECT", 
		"SEMICOLON", "SET", "SOME", "STAR", "START", "STRCONCAT", "SUBSTRING", 
		"SUM", "SYSDATE", "S_", "SingleLineComment", "TABLE", "THEN", "TIME", 
		"TIMESTAMP", "T_", "UNDERSCOPE", "UNDER_", "UNION", "UPDATE", "UR", "USING", 
		"U_", "UicodeValueLiteral", "UnicodeColumnValue", "UnicodeStringLiteral", 
		"UnicodeStringRun", "UnicodeStringValue", "VALUE", "VALUES", "V_", "Variable", 
		"WHEN", "WHERE", "WITH", "W_", "Whitespace", "WordTail", "X_", "YEAR", 
		"YEARS", "Y_", "Z_"
	};
	public static final int EOF=-1;
	public static final int ALL=4;
	public static final int AND=5;
	public static final int ANY=6;
	public static final int AS=7;
	public static final int ASC=8;
	public static final int ASSIGNEQUAL=9;
	public static final int AVG=10;
	public static final int A_=11;
	public static final int AsciiStringLiteral=12;
	public static final int AsciiStringRun=13;
	public static final int BETWEEN=14;
	public static final int BY=15;
	public static final int B_=16;
	public static final int CASE=17;
	public static final int CAST=18;
	public static final int COLON=19;
	public static final int COMMA=20;
	public static final int CONNECT=21;
	public static final int CROSS=22;
	public static final int CURRENT=23;
	public static final int CURRENT_DATE=24;
	public static final int CURRENT_TIME=25;
	public static final int CURRENT_TIMESTAMP=26;
	public static final int C_=27;
	public static final int DASH=28;
	public static final int DATE=29;
	public static final int DAY=30;
	public static final int DECODE=31;
	public static final int DEFAULT=32;
	public static final int DELETE=33;
	public static final int DENSE=34;
	public static final int DESC=35;
	public static final int DISTINCT=36;
	public static final int DIVIDE=37;
	public static final int DOT=38;
	public static final int DOT_STAR=39;
	public static final int D_=40;
	public static final int Digit=41;
	public static final int ELSE=42;
	public static final int END=43;
	public static final int ESCAPE=44;
	public static final int EXISTS=45;
	public static final int EXTRACT=46;
	public static final int E_=47;
	public static final int Exponent=48;
	public static final int FETCH=49;
	public static final int FIRST=50;
	public static final int FOR=51;
	public static final int FROM=52;
	public static final int FULL=53;
	public static final int F_=54;
	public static final int GREATERTHAN=55;
	public static final int GREATERTHANOREQUALTO1=56;
	public static final int GROUP=57;
	public static final int G_=58;
	public static final int HAVING=59;
	public static final int HOUR=60;
	public static final int H_=61;
	public static final int HexLiteral=62;
	public static final int IN=63;
	public static final int INNER=64;
	public static final int INSERT=65;
	public static final int INT=66;
	public static final int INTERVAL=67;
	public static final int INTO=68;
	public static final int IS=69;
	public static final int I_=70;
	public static final int Integer=71;
	public static final int Iso8601DateTime=72;
	public static final int JOIN=73;
	public static final int J_=74;
	public static final int K_=75;
	public static final int LEFT=76;
	public static final int LESSTHAN=77;
	public static final int LESSTHANOREQUALTO1=78;
	public static final int LIKE=79;
	public static final int LPAREN=80;
	public static final int L_=81;
	public static final int Letter=82;
	public static final int MATCHED=83;
	public static final int MAX=84;
	public static final int MAccessDateTime=85;
	public static final int MERGE=86;
	public static final int MIN=87;
	public static final int MINUS=88;
	public static final int MINUTE=89;
	public static final int MOD=90;
	public static final int MONTH=91;
	public static final int M_=92;
	public static final int MultiLineComment=93;
	public static final int MultiLineComment2=94;
	public static final int NEXT=95;
	public static final int NOT=96;
	public static final int NOTEQUAL1=97;
	public static final int NOTEQUAL2=98;
	public static final int NULL=99;
	public static final int NULLS=100;
	public static final int NUMBER=101;
	public static final int NVL=102;
	public static final int N_=103;
	public static final int NonQuotedIdentifier=104;
	public static final int Number=105;
	public static final int ON=106;
	public static final int ONLY=107;
	public static final int OPTIMIZE=108;
	public static final int OR=109;
	public static final int ORDER=110;
	public static final int OUTER=111;
	public static final int OVER=112;
	public static final int O_=113;
	public static final int PARTITION=114;
	public static final int PLACEHOLDER=115;
	public static final int PLUS=116;
	public static final int PRIOR=117;
	public static final int P_=118;
	public static final int Q_=119;
	public static final int QuotedIdentifier=120;
	public static final int RANK=121;
	public static final int READ=122;
	public static final int RIGHT=123;
	public static final int ROW=124;
	public static final int ROWS=125;
	public static final int RPAREN=126;
	public static final int R_=127;
	public static final int Real=128;
	public static final int SECOND=129;
	public static final int SELECT=130;
	public static final int SEMICOLON=131;
	public static final int SET=132;
	public static final int SOME=133;
	public static final int STAR=134;
	public static final int START=135;
	public static final int STRCONCAT=136;
	public static final int SUBSTRING=137;
	public static final int SUM=138;
	public static final int SYSDATE=139;
	public static final int S_=140;
	public static final int SingleLineComment=141;
	public static final int TABLE=142;
	public static final int THEN=143;
	public static final int TIME=144;
	public static final int TIMESTAMP=145;
	public static final int T_=146;
	public static final int UNDERSCOPE=147;
	public static final int UNDER_=148;
	public static final int UNION=149;
	public static final int UPDATE=150;
	public static final int UR=151;
	public static final int USING=152;
	public static final int U_=153;
	public static final int UicodeValueLiteral=154;
	public static final int UnicodeColumnValue=155;
	public static final int UnicodeStringLiteral=156;
	public static final int UnicodeStringRun=157;
	public static final int UnicodeStringValue=158;
	public static final int VALUE=159;
	public static final int VALUES=160;
	public static final int V_=161;
	public static final int Variable=162;
	public static final int WHEN=163;
	public static final int WHERE=164;
	public static final int WITH=165;
	public static final int W_=166;
	public static final int Whitespace=167;
	public static final int WordTail=168;
	public static final int X_=169;
	public static final int YEAR=170;
	public static final int YEARS=171;
	public static final int Y_=172;
	public static final int Z_=173;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SQLAnalyzerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SQLAnalyzerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[327+1];


	}

	@Override public String[] getTokenNames() { return SQLAnalyzerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "parser\\sql\\SQLAnalyzer.g"; }


	/*
	 * Ïª¨Îüº ?ïÎ≥¥
	 */
	private ArrayList <String> columnList = new ArrayList<String>();
	/*
	 * alias ?åÏù¥Î∏??ïÎ≥¥
	 */
	private ArrayList<String> aliasTableList = new ArrayList<String>();
	/*
	 * select?åÏù¥Î∏??ïÎ≥¥
	 */
	private ArrayList<String> selectTableList  = new ArrayList<String>();
	/*
	 * ?åÏù¥Î∏??ïÎ≥¥
	 */
	private ArrayList<String> tableList = new ArrayList<String>();
	/*
	 * statementType ?ïÎ≥¥ 
	 */
	private ArrayList<String> statementTypeList = new ArrayList<String>();
	private boolean isExistColumnName = false;
	/*
	 * db2 ?îÎ? ?åÏù¥Î∏?
	 */
	private String db2DummyTableNameOne =  "SYSIBM.SYSDUMMY1";
	private String db2DummyTableNameTwo =  "SYSDUMMY1";
	private String db2DummyTableNameThree =  "DUMMY";
	/*
	 * ?ÑÏû¨ statementType ?ïÎ≥¥ 
	 */
	private String statementType;
	/*
	 * Statement ?∏Îç±??
	 */
	private int statementIdx = 0 ;

	public List<String> getTableList() {
	  return tableList;
	}

	public List<String> getAliasTableList() {
	  return aliasTableList;
	}

	public List<String> getColumnList() {
	  return columnList;
	}

	public List<String> getSelectTableList(){
	  return selectTableList;
	}

	public void setStatementType(String type) {
	  this.statementType = type;
	}

	public String getStatementType() {
	  return this.statementType;
	}




	// $ANTLR start "statement"
	// parser\\sql\\SQLAnalyzer.g:83:1: statement : (i= insertStatement ( SEMICOLON )? |s= selectStatement ( SEMICOLON )? |o= updateStatement ( SEMICOLON )? |d= deleteStatement ( SEMICOLON )? |m= mergeStatement ( SEMICOLON )? |s= withStatement ( SEMICOLON )? );
	public final void statement() throws RecognitionException {
		int statement_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:83:11: (i= insertStatement ( SEMICOLON )? |s= selectStatement ( SEMICOLON )? |o= updateStatement ( SEMICOLON )? |d= deleteStatement ( SEMICOLON )? |m= mergeStatement ( SEMICOLON )? |s= withStatement ( SEMICOLON )? )
			int alt7=6;
			switch ( input.LA(1) ) {
			case INSERT:
				{
				alt7=1;
				}
				break;
			case LPAREN:
			case SELECT:
				{
				alt7=2;
				}
				break;
			case UPDATE:
				{
				alt7=3;
				}
				break;
			case DELETE:
				{
				alt7=4;
				}
				break;
			case MERGE:
				{
				alt7=5;
				}
				break;
			case WITH:
				{
				alt7=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:84:4: i= insertStatement ( SEMICOLON )?
					{
					if ( state.backtracking==0 ) { setStatementType("01");}
					pushFollow(FOLLOW_insertStatement_in_statement78);
					insertStatement();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:84:51: ( SEMICOLON )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==SEMICOLON) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:84:52: SEMICOLON
							{
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement81); if (state.failed) return;
							}
							break;

					}

					if ( state.backtracking==0 ) {
					        /*
					         * columnNameListÎ•??†Ïñ∏?òÏ? ?äÏïò?ºÎ©¥
					         * Î™®Îì† Ïª¨Îüº???¨Ïö©?òÎäî Ïª¨Îüº?¥Î?Î°?
					         * '*'Î•?column??Ï∂îÍ??úÎã§.
					         */
					        if(!isExistColumnName){
					           columnList.add("*");
					        } else {
					          // DO NOTHING 
					        }
					   }
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:96:5: s= selectStatement ( SEMICOLON )?
					{
					if ( state.backtracking==0 ) { setStatementType("02");}
					pushFollow(FOLLOW_selectStatement_in_statement97);
					selectStatement();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:96:52: ( SEMICOLON )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==SEMICOLON) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:96:53: SEMICOLON
							{
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement100); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:97:5: o= updateStatement ( SEMICOLON )?
					{
					if ( state.backtracking==0 ) { setStatementType("03");}
					pushFollow(FOLLOW_updateStatement_in_statement119);
					updateStatement();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:97:53: ( SEMICOLON )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==SEMICOLON) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:97:54: SEMICOLON
							{
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement122); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:98:5: d= deleteStatement ( SEMICOLON )?
					{
					if ( state.backtracking==0 ) { setStatementType("04");}
					pushFollow(FOLLOW_deleteStatement_in_statement137);
					deleteStatement();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:98:53: ( SEMICOLON )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==SEMICOLON) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:98:54: SEMICOLON
							{
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement140); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 5 :
					// parser\\sql\\SQLAnalyzer.g:99:5: m= mergeStatement ( SEMICOLON )?
					{
					if ( state.backtracking==0 ) { setStatementType("05");}
					pushFollow(FOLLOW_mergeStatement_in_statement156);
					mergeStatement();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:99:51: ( SEMICOLON )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==SEMICOLON) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:99:52: SEMICOLON
							{
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement159); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 6 :
					// parser\\sql\\SQLAnalyzer.g:100:5: s= withStatement ( SEMICOLON )?
					{
					if ( state.backtracking==0 ) { setStatementType("02");}
					pushFollow(FOLLOW_withStatement_in_statement173);
					withStatement();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:100:50: ( SEMICOLON )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==SEMICOLON) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:100:51: SEMICOLON
							{
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement176); if (state.failed) return;
							}
							break;

					}

					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, statement_StartIndex); }

		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "insertStatement"
	// parser\\sql\\SQLAnalyzer.g:103:1: insertStatement : INSERT ( INTO )? (o= dbObject )? ( LPAREN c= columnNameList RPAREN )? ( WITH al= alias1 ( AS )? )? ( VALUES LPAREN e= columnValueList RPAREN | ( selectStatement )* ) ;
	public final void insertStatement() throws RecognitionException {
		int insertStatement_StartIndex = input.index();

		ParserRuleReturnScope o =null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope al =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:103:17: ( INSERT ( INTO )? (o= dbObject )? ( LPAREN c= columnNameList RPAREN )? ( WITH al= alias1 ( AS )? )? ( VALUES LPAREN e= columnValueList RPAREN | ( selectStatement )* ) )
			// parser\\sql\\SQLAnalyzer.g:104:3: INSERT ( INTO )? (o= dbObject )? ( LPAREN c= columnNameList RPAREN )? ( WITH al= alias1 ( AS )? )? ( VALUES LPAREN e= columnValueList RPAREN | ( selectStatement )* )
			{
			match(input,INSERT,FOLLOW_INSERT_in_insertStatement192); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:104:10: ( INTO )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==INTO) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:104:12: INTO
					{
					match(input,INTO,FOLLOW_INTO_in_insertStatement196); if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:105:5: (o= dbObject )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==AVG||(LA9_0 >= CURRENT && LA9_0 <= CURRENT_TIMESTAMP)||(LA9_0 >= DATE && LA9_0 <= DECODE)||(LA9_0 >= DENSE && LA9_0 <= DESC)||LA9_0==GROUP||LA9_0==HOUR||(LA9_0 >= INT && LA9_0 <= INTERVAL)||LA9_0==MAX||LA9_0==MIN||LA9_0==MINUTE||LA9_0==MONTH||LA9_0==NEXT||LA9_0==NVL||LA9_0==NonQuotedIdentifier||LA9_0==ORDER||LA9_0==OVER||(LA9_0 >= QuotedIdentifier && LA9_0 <= RANK)||LA9_0==ROW||LA9_0==SECOND||(LA9_0 >= SUM && LA9_0 <= SYSDATE)||(LA9_0 >= TIME && LA9_0 <= TIMESTAMP)||LA9_0==UPDATE||LA9_0==VALUE||(LA9_0 >= YEAR && LA9_0 <= YEARS)) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:105:6: o= dbObject
					{
					pushFollow(FOLLOW_dbObject_in_insertStatement210);
					o=dbObject();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			if ( state.backtracking==0 ) {
			      //insert table add withStatement
			      // not null, not dual, not exist
			      if(((o!=null?input.toString(o.start,o.stop):null)) != null && !(("dual").equalsIgnoreCase((o!=null?input.toString(o.start,o.stop):null)))
			          &&!((db2DummyTableNameOne).equalsIgnoreCase((o!=null?input.toString(o.start,o.stop):null))) 
			          &&!((db2DummyTableNameTwo).equalsIgnoreCase((o!=null?input.toString(o.start,o.stop):null))) 
			          &&!((db2DummyTableNameThree).equalsIgnoreCase((o!=null?input.toString(o.start,o.stop):null)))){
			        String tableName = (o!=null?input.toString(o.start,o.stop):null);
			        // ??¨∏?êÎ°ú Î≥?≤Ω
			        tableName = tableName.toUpperCase();
			        // erase DB LINK
			        if(tableName.contains("@")){
			            String [] splitTableName = tableName.split("@");
			            tableName = splitTableName[0];
			        } 
			        if(!tableList.contains(tableName)){
			            tableList.add(tableName);
			        }// end if
			      }// end if 
			    }
			// parser\\sql\\SQLAnalyzer.g:126:5: ( LPAREN c= columnNameList RPAREN )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==LPAREN) ) {
				int LA10_1 = input.LA(2);
				if ( (synpred14_SQLAnalyzer()) ) {
					alt10=1;
				}
			}
			switch (alt10) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:126:6: LPAREN c= columnNameList RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_insertStatement228); if (state.failed) return;
					pushFollow(FOLLOW_columnNameList_in_insertStatement234);
					c=columnNameList();
					state._fsp--;
					if (state.failed) return;
					match(input,RPAREN,FOLLOW_RPAREN_in_insertStatement236); if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:126:42: ( WITH al= alias1 ( AS )? )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==WITH) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:126:44: WITH al= alias1 ( AS )?
					{
					match(input,WITH,FOLLOW_WITH_in_insertStatement243); if (state.failed) return;
					pushFollow(FOLLOW_alias1_in_insertStatement249);
					al=alias1();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:126:61: ( AS )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==AS) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:126:62: AS
							{
							match(input,AS,FOLLOW_AS_in_insertStatement252); if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			      // aliasÍ∞?Ï°¥Ïû¨?òÎ©¥ aliastable??add
			      String alias = (al!=null?input.toString(al.start,al.stop):null);
			      aliasTableList.add(alias);
			    
			    }
			// parser\\sql\\SQLAnalyzer.g:133:6: ( VALUES LPAREN e= columnValueList RPAREN | ( selectStatement )* )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==VALUES) ) {
				alt14=1;
			}
			else if ( (LA14_0==EOF||LA14_0==LPAREN||(LA14_0 >= SELECT && LA14_0 <= SEMICOLON)) ) {
				alt14=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:133:8: VALUES LPAREN e= columnValueList RPAREN
					{
					match(input,VALUES,FOLLOW_VALUES_in_insertStatement272); if (state.failed) return;
					match(input,LPAREN,FOLLOW_LPAREN_in_insertStatement274); if (state.failed) return;
					pushFollow(FOLLOW_columnValueList_in_insertStatement280);
					columnValueList();
					state._fsp--;
					if (state.failed) return;
					match(input,RPAREN,FOLLOW_RPAREN_in_insertStatement282); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:134:7: ( selectStatement )*
					{
					// parser\\sql\\SQLAnalyzer.g:134:7: ( selectStatement )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==LPAREN||LA13_0==SELECT) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:134:9: selectStatement
							{
							pushFollow(FOLLOW_selectStatement_in_insertStatement293);
							selectStatement();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop13;
						}
					}

					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, insertStatement_StartIndex); }

		}
	}
	// $ANTLR end "insertStatement"



	// $ANTLR start "selectStatement"
	// parser\\sql\\SQLAnalyzer.g:138:1: selectStatement :q= queryExpression ;
	public final void selectStatement() throws RecognitionException {
		int selectStatement_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:138:18: (q= queryExpression )
			// parser\\sql\\SQLAnalyzer.g:139:1: q= queryExpression
			{
			if ( state.backtracking==0 ) { 
			  // ?êÎûò??StatementType??Î¶¨Ïä§?∏Ïóê ??û•?òÍ≥† Type??SELECTÎ°?SET?úÎã§.
			  statementTypeList.add(statementIdx, getStatementType());
			  setStatementType("02"); 
			  statementIdx++;

			 }
			pushFollow(FOLLOW_queryExpression_in_selectStatement319);
			queryExpression();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {
			     // SelectStatementÍ∞?Ï¢ÖÎ£å?úÌõÑ?êÎäî Type???¥Ï†Ñ????û•?àÎçò StatementÎ°?Î≥?≤Ω?úÎã§.
			      statementIdx--;
			      setStatementType(statementTypeList.get(statementIdx)); 
			    }
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, selectStatement_StartIndex); }

		}
	}
	// $ANTLR end "selectStatement"



	// $ANTLR start "updateStatement"
	// parser\\sql\\SQLAnalyzer.g:154:1: updateStatement : UPDATE (t= tableSource )? SET a= assignmentList (w= whereClause )? ;
	public final void updateStatement() throws RecognitionException {
		int updateStatement_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:154:17: ( UPDATE (t= tableSource )? SET a= assignmentList (w= whereClause )? )
			// parser\\sql\\SQLAnalyzer.g:155:3: UPDATE (t= tableSource )? SET a= assignmentList (w= whereClause )?
			{
			match(input,UPDATE,FOLLOW_UPDATE_in_updateStatement339); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:156:4: (t= tableSource )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==AVG||(LA15_0 >= CURRENT && LA15_0 <= CURRENT_TIMESTAMP)||(LA15_0 >= DATE && LA15_0 <= DECODE)||(LA15_0 >= DENSE && LA15_0 <= DESC)||LA15_0==EXTRACT||LA15_0==GROUP||LA15_0==HOUR||(LA15_0 >= INT && LA15_0 <= INTERVAL)||LA15_0==LEFT||LA15_0==LPAREN||LA15_0==MAX||LA15_0==MIN||LA15_0==MINUTE||LA15_0==MONTH||LA15_0==NEXT||LA15_0==NVL||LA15_0==NonQuotedIdentifier||LA15_0==ORDER||LA15_0==OVER||(LA15_0 >= QuotedIdentifier && LA15_0 <= RANK)||(LA15_0 >= RIGHT && LA15_0 <= ROW)||LA15_0==SECOND||(LA15_0 >= SUBSTRING && LA15_0 <= SYSDATE)||(LA15_0 >= TIME && LA15_0 <= TIMESTAMP)||LA15_0==UPDATE||LA15_0==VALUE||(LA15_0 >= YEAR && LA15_0 <= YEARS)) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:156:6: t= tableSource
					{
					pushFollow(FOLLOW_tableSource_in_updateStatement351);
					tableSource();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,SET,FOLLOW_SET_in_updateStatement361); if (state.failed) return;
			pushFollow(FOLLOW_assignmentList_in_updateStatement367);
			assignmentList();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:158:5: (w= whereClause )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==WHERE) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:159:7: w= whereClause
					{
					pushFollow(FOLLOW_whereClause_in_updateStatement387);
					whereClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, updateStatement_StartIndex); }

		}
	}
	// $ANTLR end "updateStatement"



	// $ANTLR start "deleteStatement"
	// parser\\sql\\SQLAnalyzer.g:163:1: deleteStatement : DELETE ( FROM )? t= tableSource (w= whereClause )? ;
	public final void deleteStatement() throws RecognitionException {
		int deleteStatement_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:163:17: ( DELETE ( FROM )? t= tableSource (w= whereClause )? )
			// parser\\sql\\SQLAnalyzer.g:164:3: DELETE ( FROM )? t= tableSource (w= whereClause )?
			{
			match(input,DELETE,FOLLOW_DELETE_in_deleteStatement408); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:164:11: ( FROM )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==FROM) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:164:13: FROM
					{
					match(input,FROM,FOLLOW_FROM_in_deleteStatement413); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_tableSource_in_deleteStatement426);
			tableSource();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:166:5: (w= whereClause )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==WHERE) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:167:7: w= whereClause
					{
					pushFollow(FOLLOW_whereClause_in_deleteStatement446);
					whereClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, deleteStatement_StartIndex); }

		}
	}
	// $ANTLR end "deleteStatement"



	// $ANTLR start "mergeStatement"
	// parser\\sql\\SQLAnalyzer.g:171:1: mergeStatement : ( MERGE INTO ) tableSource USING ( selectStatement )? identifier ON searchCondition ( ( WHEN MATCHED THEN ) updateStatement )? ( ( WHEN NOT MATCHED THEN ) insertStatement )? ;
	public final void mergeStatement() throws RecognitionException {
		int mergeStatement_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:171:17: ( ( MERGE INTO ) tableSource USING ( selectStatement )? identifier ON searchCondition ( ( WHEN MATCHED THEN ) updateStatement )? ( ( WHEN NOT MATCHED THEN ) insertStatement )? )
			// parser\\sql\\SQLAnalyzer.g:172:3: ( MERGE INTO ) tableSource USING ( selectStatement )? identifier ON searchCondition ( ( WHEN MATCHED THEN ) updateStatement )? ( ( WHEN NOT MATCHED THEN ) insertStatement )?
			{
			// parser\\sql\\SQLAnalyzer.g:172:3: ( MERGE INTO )
			// parser\\sql\\SQLAnalyzer.g:172:4: MERGE INTO
			{
			match(input,MERGE,FOLLOW_MERGE_in_mergeStatement471); if (state.failed) return;
			match(input,INTO,FOLLOW_INTO_in_mergeStatement473); if (state.failed) return;
			}

			pushFollow(FOLLOW_tableSource_in_mergeStatement476);
			tableSource();
			state._fsp--;
			if (state.failed) return;
			match(input,USING,FOLLOW_USING_in_mergeStatement480); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:173:9: ( selectStatement )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==LPAREN||LA19_0==SELECT) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:173:10: selectStatement
					{
					pushFollow(FOLLOW_selectStatement_in_mergeStatement483);
					selectStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_identifier_in_mergeStatement487);
			identifier();
			state._fsp--;
			if (state.failed) return;
			match(input,ON,FOLLOW_ON_in_mergeStatement489); if (state.failed) return;
			pushFollow(FOLLOW_searchCondition_in_mergeStatement491);
			searchCondition();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:174:3: ( ( WHEN MATCHED THEN ) updateStatement )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==WHEN) ) {
				int LA20_1 = input.LA(2);
				if ( (LA20_1==MATCHED) ) {
					alt20=1;
				}
			}
			switch (alt20) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:174:4: ( WHEN MATCHED THEN ) updateStatement
					{
					// parser\\sql\\SQLAnalyzer.g:174:4: ( WHEN MATCHED THEN )
					// parser\\sql\\SQLAnalyzer.g:174:5: WHEN MATCHED THEN
					{
					match(input,WHEN,FOLLOW_WHEN_in_mergeStatement498); if (state.failed) return;
					match(input,MATCHED,FOLLOW_MATCHED_in_mergeStatement500); if (state.failed) return;
					match(input,THEN,FOLLOW_THEN_in_mergeStatement502); if (state.failed) return;
					}

					pushFollow(FOLLOW_updateStatement_in_mergeStatement505);
					updateStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:175:3: ( ( WHEN NOT MATCHED THEN ) insertStatement )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==WHEN) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:175:4: ( WHEN NOT MATCHED THEN ) insertStatement
					{
					// parser\\sql\\SQLAnalyzer.g:175:4: ( WHEN NOT MATCHED THEN )
					// parser\\sql\\SQLAnalyzer.g:175:5: WHEN NOT MATCHED THEN
					{
					match(input,WHEN,FOLLOW_WHEN_in_mergeStatement513); if (state.failed) return;
					match(input,NOT,FOLLOW_NOT_in_mergeStatement515); if (state.failed) return;
					match(input,MATCHED,FOLLOW_MATCHED_in_mergeStatement517); if (state.failed) return;
					match(input,THEN,FOLLOW_THEN_in_mergeStatement519); if (state.failed) return;
					}

					pushFollow(FOLLOW_insertStatement_in_mergeStatement522);
					insertStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, mergeStatement_StartIndex); }

		}
	}
	// $ANTLR end "mergeStatement"



	// $ANTLR start "withStatement"
	// parser\\sql\\SQLAnalyzer.g:178:1: withStatement : WITH ( ( COMMA )? a= identifier ( LPAREN ( ( COMMA )? identifier )+ RPAREN )? ( AS )? LPAREN ( selectStatement | ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN )+ RPAREN )+ ( selectStatement )* ;
	public final void withStatement() throws RecognitionException {
		int withStatement_StartIndex = input.index();

		ParserRuleReturnScope a =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:178:17: ( WITH ( ( COMMA )? a= identifier ( LPAREN ( ( COMMA )? identifier )+ RPAREN )? ( AS )? LPAREN ( selectStatement | ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN )+ RPAREN )+ ( selectStatement )* )
			// parser\\sql\\SQLAnalyzer.g:179:3: WITH ( ( COMMA )? a= identifier ( LPAREN ( ( COMMA )? identifier )+ RPAREN )? ( AS )? LPAREN ( selectStatement | ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN )+ RPAREN )+ ( selectStatement )*
			{
			match(input,WITH,FOLLOW_WITH_in_withStatement543); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:179:9: ( ( COMMA )? a= identifier ( LPAREN ( ( COMMA )? identifier )+ RPAREN )? ( AS )? LPAREN ( selectStatement | ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN )+ RPAREN )+
			int cnt32=0;
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==AVG||LA32_0==COMMA||(LA32_0 >= CURRENT && LA32_0 <= CURRENT_TIMESTAMP)||(LA32_0 >= DATE && LA32_0 <= DECODE)||(LA32_0 >= DENSE && LA32_0 <= DESC)||LA32_0==GROUP||LA32_0==HOUR||(LA32_0 >= INT && LA32_0 <= INTERVAL)||LA32_0==MAX||LA32_0==MIN||LA32_0==MINUTE||LA32_0==MONTH||LA32_0==NEXT||LA32_0==NVL||LA32_0==NonQuotedIdentifier||LA32_0==ORDER||LA32_0==OVER||(LA32_0 >= QuotedIdentifier && LA32_0 <= RANK)||LA32_0==ROW||LA32_0==SECOND||(LA32_0 >= SUM && LA32_0 <= SYSDATE)||(LA32_0 >= TIME && LA32_0 <= TIMESTAMP)||LA32_0==UPDATE||LA32_0==VALUE||(LA32_0 >= YEAR && LA32_0 <= YEARS)) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:179:11: ( COMMA )? a= identifier ( LPAREN ( ( COMMA )? identifier )+ RPAREN )? ( AS )? LPAREN ( selectStatement | ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN )+ RPAREN
					{
					// parser\\sql\\SQLAnalyzer.g:179:11: ( COMMA )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==COMMA) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:179:12: COMMA
							{
							match(input,COMMA,FOLLOW_COMMA_in_withStatement549); if (state.failed) return;
							}
							break;

					}

					pushFollow(FOLLOW_identifier_in_withStatement563);
					a=identifier();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:181:4: ( LPAREN ( ( COMMA )? identifier )+ RPAREN )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==LPAREN) ) {
						int LA25_1 = input.LA(2);
						if ( (LA25_1==COMMA) ) {
							int LA25_3 = input.LA(3);
							if ( (LA25_3==AVG||(LA25_3 >= CURRENT && LA25_3 <= CURRENT_TIMESTAMP)||(LA25_3 >= DATE && LA25_3 <= DECODE)||(LA25_3 >= DENSE && LA25_3 <= DESC)||LA25_3==GROUP||LA25_3==HOUR||(LA25_3 >= INT && LA25_3 <= INTERVAL)||LA25_3==MAX||LA25_3==MIN||LA25_3==MINUTE||LA25_3==MONTH||LA25_3==NEXT||LA25_3==NVL||LA25_3==NonQuotedIdentifier||LA25_3==ORDER||LA25_3==OVER||(LA25_3 >= QuotedIdentifier && LA25_3 <= RANK)||LA25_3==ROW||LA25_3==SECOND||(LA25_3 >= SUM && LA25_3 <= SYSDATE)||(LA25_3 >= TIME && LA25_3 <= TIMESTAMP)||LA25_3==UPDATE||LA25_3==VALUE||(LA25_3 >= YEAR && LA25_3 <= YEARS)) ) {
								alt25=1;
							}
						}
						else if ( (LA25_1==AVG||(LA25_1 >= CURRENT && LA25_1 <= CURRENT_TIMESTAMP)||(LA25_1 >= DATE && LA25_1 <= DECODE)||(LA25_1 >= DENSE && LA25_1 <= DESC)||LA25_1==GROUP||LA25_1==HOUR||(LA25_1 >= INT && LA25_1 <= INTERVAL)||LA25_1==MAX||LA25_1==MIN||LA25_1==MINUTE||LA25_1==MONTH||LA25_1==NEXT||LA25_1==NVL||LA25_1==NonQuotedIdentifier||LA25_1==ORDER||LA25_1==OVER||(LA25_1 >= QuotedIdentifier && LA25_1 <= RANK)||LA25_1==ROW||LA25_1==SECOND||(LA25_1 >= SUM && LA25_1 <= SYSDATE)||(LA25_1 >= TIME && LA25_1 <= TIMESTAMP)||LA25_1==UPDATE||LA25_1==VALUE||(LA25_1 >= YEAR && LA25_1 <= YEARS)) ) {
							alt25=1;
						}
					}
					switch (alt25) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:181:6: LPAREN ( ( COMMA )? identifier )+ RPAREN
							{
							match(input,LPAREN,FOLLOW_LPAREN_in_withStatement571); if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:181:13: ( ( COMMA )? identifier )+
							int cnt24=0;
							loop24:
							while (true) {
								int alt24=2;
								int LA24_0 = input.LA(1);
								if ( (LA24_0==AVG||LA24_0==COMMA||(LA24_0 >= CURRENT && LA24_0 <= CURRENT_TIMESTAMP)||(LA24_0 >= DATE && LA24_0 <= DECODE)||(LA24_0 >= DENSE && LA24_0 <= DESC)||LA24_0==GROUP||LA24_0==HOUR||(LA24_0 >= INT && LA24_0 <= INTERVAL)||LA24_0==MAX||LA24_0==MIN||LA24_0==MINUTE||LA24_0==MONTH||LA24_0==NEXT||LA24_0==NVL||LA24_0==NonQuotedIdentifier||LA24_0==ORDER||LA24_0==OVER||(LA24_0 >= QuotedIdentifier && LA24_0 <= RANK)||LA24_0==ROW||LA24_0==SECOND||(LA24_0 >= SUM && LA24_0 <= SYSDATE)||(LA24_0 >= TIME && LA24_0 <= TIMESTAMP)||LA24_0==UPDATE||LA24_0==VALUE||(LA24_0 >= YEAR && LA24_0 <= YEARS)) ) {
									alt24=1;
								}

								switch (alt24) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:181:14: ( COMMA )? identifier
									{
									// parser\\sql\\SQLAnalyzer.g:181:14: ( COMMA )?
									int alt23=2;
									int LA23_0 = input.LA(1);
									if ( (LA23_0==COMMA) ) {
										alt23=1;
									}
									switch (alt23) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:181:16: COMMA
											{
											match(input,COMMA,FOLLOW_COMMA_in_withStatement576); if (state.failed) return;
											}
											break;

									}

									pushFollow(FOLLOW_identifier_in_withStatement581);
									identifier();
									state._fsp--;
									if (state.failed) return;
									}
									break;

								default :
									if ( cnt24 >= 1 ) break loop24;
									if (state.backtracking>0) {state.failed=true; return;}
									EarlyExitException eee = new EarlyExitException(24, input);
									throw eee;
								}
								cnt24++;
							}

							match(input,RPAREN,FOLLOW_RPAREN_in_withStatement586); if (state.failed) return;
							}
							break;

					}

					// parser\\sql\\SQLAnalyzer.g:182:7: ( AS )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==AS) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:182:8: AS
							{
							match(input,AS,FOLLOW_AS_in_withStatement598); if (state.failed) return;
							}
							break;

					}

					match(input,LPAREN,FOLLOW_LPAREN_in_withStatement602); if (state.failed) return;
					if ( state.backtracking==0 ) {
					      String aliasTableName = (a!=null?input.toString(a.start,a.stop):null);
					      aliasTableList.add(aliasTableName);
					     }
					// parser\\sql\\SQLAnalyzer.g:188:7: ( selectStatement | ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN )+
					int cnt31=0;
					loop31:
					while (true) {
						int alt31=3;
						switch ( input.LA(1) ) {
						case SELECT:
							{
							alt31=1;
							}
							break;
						case LPAREN:
							{
							int LA31_3 = input.LA(2);
							if ( (synpred31_SQLAnalyzer()) ) {
								alt31=1;
							}
							else if ( (synpred37_SQLAnalyzer()) ) {
								alt31=2;
							}

							}
							break;
						case COMMA:
						case VALUES:
							{
							alt31=2;
							}
							break;
						}
						switch (alt31) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:188:9: selectStatement
							{
							pushFollow(FOLLOW_selectStatement_in_withStatement624);
							selectStatement();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// parser\\sql\\SQLAnalyzer.g:189:11: ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN
							{
							// parser\\sql\\SQLAnalyzer.g:189:11: ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+
							int cnt30=0;
							loop30:
							while (true) {
								int alt30=2;
								int LA30_0 = input.LA(1);
								if ( (LA30_0==COMMA||LA30_0==LPAREN||LA30_0==VALUES) ) {
									alt30=1;
								}

								switch (alt30) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:189:12: ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )*
									{
									// parser\\sql\\SQLAnalyzer.g:189:12: ( VALUES | COMMA )?
									int alt27=2;
									int LA27_0 = input.LA(1);
									if ( (LA27_0==COMMA||LA27_0==VALUES) ) {
										alt27=1;
									}
									switch (alt27) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:
											{
											if ( input.LA(1)==COMMA||input.LA(1)==VALUES ) {
												input.consume();
												state.errorRecovery=false;
												state.failed=false;
											}
											else {
												if (state.backtracking>0) {state.failed=true; return;}
												MismatchedSetException mse = new MismatchedSetException(null,input);
												throw mse;
											}
											}
											break;

									}

									match(input,LPAREN,FOLLOW_LPAREN_in_withStatement647); if (state.failed) return;
									// parser\\sql\\SQLAnalyzer.g:189:37: ( ( COMMA )? subExpression )*
									loop29:
									while (true) {
										int alt29=2;
										switch ( input.LA(1) ) {
										case COMMA:
											{
											int LA29_2 = input.LA(2);
											if ( (synpred35_SQLAnalyzer()) ) {
												alt29=1;
											}

											}
											break;
										case LPAREN:
											{
											int LA29_3 = input.LA(2);
											if ( (synpred35_SQLAnalyzer()) ) {
												alt29=1;
											}

											}
											break;
										case AVG:
										case AsciiStringLiteral:
										case CASE:
										case CAST:
										case CURRENT:
										case CURRENT_DATE:
										case CURRENT_TIME:
										case CURRENT_TIMESTAMP:
										case DASH:
										case DATE:
										case DAY:
										case DECODE:
										case DENSE:
										case DESC:
										case EXTRACT:
										case GROUP:
										case HOUR:
										case HexLiteral:
										case INT:
										case INTERVAL:
										case Integer:
										case Iso8601DateTime:
										case LEFT:
										case MAX:
										case MAccessDateTime:
										case MIN:
										case MINUTE:
										case MONTH:
										case NEXT:
										case NULL:
										case NVL:
										case NonQuotedIdentifier:
										case ORDER:
										case OVER:
										case PLACEHOLDER:
										case PLUS:
										case QuotedIdentifier:
										case RANK:
										case RIGHT:
										case ROW:
										case Real:
										case SECOND:
										case SUBSTRING:
										case SUM:
										case SYSDATE:
										case TIME:
										case TIMESTAMP:
										case UPDATE:
										case UicodeValueLiteral:
										case UnicodeStringLiteral:
										case VALUE:
										case Variable:
										case YEAR:
										case YEARS:
											{
											alt29=1;
											}
											break;
										}
										switch (alt29) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:190:11: ( COMMA )? subExpression
											{
											// parser\\sql\\SQLAnalyzer.g:190:11: ( COMMA )?
											int alt28=2;
											int LA28_0 = input.LA(1);
											if ( (LA28_0==COMMA) ) {
												alt28=1;
											}
											switch (alt28) {
												case 1 :
													// parser\\sql\\SQLAnalyzer.g:190:12: COMMA
													{
													match(input,COMMA,FOLLOW_COMMA_in_withStatement663); if (state.failed) return;
													}
													break;

											}

											pushFollow(FOLLOW_subExpression_in_withStatement667);
											subExpression();
											state._fsp--;
											if (state.failed) return;
											}
											break;

										default :
											break loop29;
										}
									}

									}
									break;

								default :
									if ( cnt30 >= 1 ) break loop30;
									if (state.backtracking>0) {state.failed=true; return;}
									EarlyExitException eee = new EarlyExitException(30, input);
									throw eee;
								}
								cnt30++;
							}

							match(input,RPAREN,FOLLOW_RPAREN_in_withStatement674); if (state.failed) return;
							}
							break;

						default :
							if ( cnt31 >= 1 ) break loop31;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(31, input);
							throw eee;
						}
						cnt31++;
					}

					match(input,RPAREN,FOLLOW_RPAREN_in_withStatement686); if (state.failed) return;
					}
					break;

				default :
					if ( cnt32 >= 1 ) break loop32;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(32, input);
					throw eee;
				}
				cnt32++;
			}

			// parser\\sql\\SQLAnalyzer.g:192:6: ( selectStatement )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==LPAREN||LA33_0==SELECT) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:192:7: selectStatement
					{
					pushFollow(FOLLOW_selectStatement_in_withStatement699);
					selectStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop33;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, withStatement_StartIndex); }

		}
	}
	// $ANTLR end "withStatement"



	// $ANTLR start "assignmentList"
	// parser\\sql\\SQLAnalyzer.g:196:1: assignmentList : a= assignment ( COMMA a= assignment )* ;
	public final void assignmentList() throws RecognitionException {
		int assignmentList_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:196:17: (a= assignment ( COMMA a= assignment )* )
			// parser\\sql\\SQLAnalyzer.g:197:3: a= assignment ( COMMA a= assignment )*
			{
			pushFollow(FOLLOW_assignment_in_assignmentList723);
			assignment();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:197:19: ( COMMA a= assignment )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==COMMA) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:197:20: COMMA a= assignment
					{
					match(input,COMMA,FOLLOW_COMMA_in_assignmentList727); if (state.failed) return;
					pushFollow(FOLLOW_assignment_in_assignmentList733);
					assignment();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop34;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, assignmentList_StartIndex); }

		}
	}
	// $ANTLR end "assignmentList"



	// $ANTLR start "assignment"
	// parser\\sql\\SQLAnalyzer.g:200:1: assignment : (c= column ASSIGNEQUAL v= columnValue ) ;
	public final void assignment() throws RecognitionException {
		int assignment_StartIndex = input.index();

		ParserRuleReturnScope c =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:200:13: ( (c= column ASSIGNEQUAL v= columnValue ) )
			// parser\\sql\\SQLAnalyzer.g:201:3: (c= column ASSIGNEQUAL v= columnValue )
			{
			// parser\\sql\\SQLAnalyzer.g:201:3: (c= column ASSIGNEQUAL v= columnValue )
			// parser\\sql\\SQLAnalyzer.g:201:5: c= column ASSIGNEQUAL v= columnValue
			{
			pushFollow(FOLLOW_column_in_assignment755);
			c=column();
			state._fsp--;
			if (state.failed) return;
			match(input,ASSIGNEQUAL,FOLLOW_ASSIGNEQUAL_in_assignment758); if (state.failed) return;
			pushFollow(FOLLOW_columnValue_in_assignment764);
			columnValue();
			state._fsp--;
			if (state.failed) return;
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, assignment_StartIndex); }

		}
	}
	// $ANTLR end "assignment"


	public static class columnNameList_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "columnNameList"
	// parser\\sql\\SQLAnalyzer.g:204:1: columnNameList : c= column ( COMMA c= column )* ;
	public final SQLAnalyzerParser.columnNameList_return columnNameList() throws RecognitionException {
		SQLAnalyzerParser.columnNameList_return retval = new SQLAnalyzerParser.columnNameList_return();
		retval.start = input.LT(1);
		int columnNameList_StartIndex = input.index();

		ParserRuleReturnScope c =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// parser\\sql\\SQLAnalyzer.g:204:17: (c= column ( COMMA c= column )* )
			// parser\\sql\\SQLAnalyzer.g:205:3: c= column ( COMMA c= column )*
			{
			pushFollow(FOLLOW_column_in_columnNameList786);
			c=column();
			state._fsp--;
			if (state.failed) return retval;
			// parser\\sql\\SQLAnalyzer.g:206:5: ( COMMA c= column )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0==COMMA) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:206:7: COMMA c= column
					{
					match(input,COMMA,FOLLOW_COMMA_in_columnNameList795); if (state.failed) return retval;
					pushFollow(FOLLOW_column_in_columnNameList801);
					c=column();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop35;
				}
			}

			if ( state.backtracking==0 ) {
			    isExistColumnName = true;
			    // Insert Column add
			    String column = input.toString(retval.start,input.LT(-1));
			     if(column !=null && !(column).equals("\\'\\'")){ 
			        String[] tmps = column.split("\\,");
			        
			        for(String columns : tmps) {
			          String trimColumn = columns.trim();
			            if(trimColumn.contains(".")){
			              String [] splitColumn = columns.split("\\.");
			              trimColumn = splitColumn[1];
			              
			              if(trimColumn.equals("NEXTVAL")){
			                trimColumn = splitColumn[0];
			              }
			            }
			            // Ï∂îÍ??ÅÏúºÎ°?trim?§Ìñâ
			            trimColumn = trimColumn.trim();
			            trimColumn = trimColumn.toUpperCase();
			            if(!columnList.contains(trimColumn)){
			              columnList.add(trimColumn);
			            }
			        } 
			      }
			     }
			}

			retval.stop = input.LT(-1);

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, columnNameList_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "columnNameList"



	// $ANTLR start "columnValueList"
	// parser\\sql\\SQLAnalyzer.g:235:1: columnValueList : v= columnValue ( COMMA v= columnValue )* ;
	public final void columnValueList() throws RecognitionException {
		int columnValueList_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:235:18: (v= columnValue ( COMMA v= columnValue )* )
			// parser\\sql\\SQLAnalyzer.g:236:3: v= columnValue ( COMMA v= columnValue )*
			{
			pushFollow(FOLLOW_columnValue_in_columnValueList831);
			columnValue();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:236:20: ( COMMA v= columnValue )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==COMMA) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:236:22: COMMA v= columnValue
					{
					match(input,COMMA,FOLLOW_COMMA_in_columnValueList836); if (state.failed) return;
					pushFollow(FOLLOW_columnValue_in_columnValueList842);
					columnValue();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop36;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, columnValueList_StartIndex); }

		}
	}
	// $ANTLR end "columnValueList"



	// $ANTLR start "columnValue"
	// parser\\sql\\SQLAnalyzer.g:240:1: columnValue : ( DEFAULT |e= expression );
	public final void columnValue() throws RecognitionException {
		int columnValue_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:240:14: ( DEFAULT |e= expression )
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==DEFAULT) ) {
				alt37=1;
			}
			else if ( (LA37_0==AVG||LA37_0==AsciiStringLiteral||(LA37_0 >= CASE && LA37_0 <= CAST)||(LA37_0 >= CURRENT && LA37_0 <= CURRENT_TIMESTAMP)||(LA37_0 >= DASH && LA37_0 <= DECODE)||(LA37_0 >= DENSE && LA37_0 <= DESC)||LA37_0==EXTRACT||LA37_0==GROUP||LA37_0==HOUR||LA37_0==HexLiteral||(LA37_0 >= INT && LA37_0 <= INTERVAL)||(LA37_0 >= Integer && LA37_0 <= Iso8601DateTime)||LA37_0==LEFT||LA37_0==LPAREN||(LA37_0 >= MAX && LA37_0 <= MAccessDateTime)||LA37_0==MIN||LA37_0==MINUTE||LA37_0==MONTH||LA37_0==NEXT||LA37_0==NULL||LA37_0==NVL||LA37_0==NonQuotedIdentifier||LA37_0==ORDER||LA37_0==OVER||(LA37_0 >= PLACEHOLDER && LA37_0 <= PLUS)||(LA37_0 >= QuotedIdentifier && LA37_0 <= RANK)||(LA37_0 >= RIGHT && LA37_0 <= ROW)||(LA37_0 >= Real && LA37_0 <= SECOND)||(LA37_0 >= SUBSTRING && LA37_0 <= SYSDATE)||(LA37_0 >= TIME && LA37_0 <= TIMESTAMP)||LA37_0==UPDATE||LA37_0==UicodeValueLiteral||LA37_0==UnicodeStringLiteral||LA37_0==VALUE||LA37_0==Variable||(LA37_0 >= YEAR && LA37_0 <= YEARS)) ) {
				alt37=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:241:3: DEFAULT
					{
					match(input,DEFAULT,FOLLOW_DEFAULT_in_columnValue863); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:242:5: e= expression
					{
					pushFollow(FOLLOW_expression_in_columnValue874);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, columnValue_StartIndex); }

		}
	}
	// $ANTLR end "columnValue"



	// $ANTLR start "queryExpression"
	// parser\\sql\\SQLAnalyzer.g:245:1: queryExpression : s= subQueryExpression (u= unionOperator s= subQueryExpression )* (o= orderByClause )? ( fetchClause )? ( optimizeClause )? ( withClause )? ( startClause )? ;
	public final void queryExpression() throws RecognitionException {
		int queryExpression_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:245:18: (s= subQueryExpression (u= unionOperator s= subQueryExpression )* (o= orderByClause )? ( fetchClause )? ( optimizeClause )? ( withClause )? ( startClause )? )
			// parser\\sql\\SQLAnalyzer.g:246:3: s= subQueryExpression (u= unionOperator s= subQueryExpression )* (o= orderByClause )? ( fetchClause )? ( optimizeClause )? ( withClause )? ( startClause )?
			{
			pushFollow(FOLLOW_subQueryExpression_in_queryExpression893);
			subQueryExpression();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:247:3: (u= unionOperator s= subQueryExpression )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( (LA38_0==UNION) ) {
					int LA38_2 = input.LA(2);
					if ( (synpred44_SQLAnalyzer()) ) {
						alt38=1;
					}

				}
				else if ( (LA38_0==MINUS) ) {
					int LA38_3 = input.LA(2);
					if ( (synpred44_SQLAnalyzer()) ) {
						alt38=1;
					}

				}

				switch (alt38) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:247:5: u= unionOperator s= subQueryExpression
					{
					pushFollow(FOLLOW_unionOperator_in_queryExpression905);
					unionOperator();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_subQueryExpression_in_queryExpression915);
					subQueryExpression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop38;
				}
			}

			// parser\\sql\\SQLAnalyzer.g:250:5: (o= orderByClause )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==ORDER) ) {
				int LA39_1 = input.LA(2);
				if ( (synpred45_SQLAnalyzer()) ) {
					alt39=1;
				}
			}
			switch (alt39) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:250:7: o= orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_queryExpression933);
					orderByClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:251:3: ( fetchClause )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==FOR) ) {
				int LA40_1 = input.LA(2);
				if ( (synpred46_SQLAnalyzer()) ) {
					alt40=1;
				}
			}
			else if ( (LA40_0==FETCH) ) {
				int LA40_2 = input.LA(2);
				if ( (synpred46_SQLAnalyzer()) ) {
					alt40=1;
				}
			}
			switch (alt40) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:251:5: fetchClause
					{
					pushFollow(FOLLOW_fetchClause_in_queryExpression942);
					fetchClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:252:3: ( optimizeClause )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==OPTIMIZE) ) {
				int LA41_1 = input.LA(2);
				if ( (synpred47_SQLAnalyzer()) ) {
					alt41=1;
				}
			}
			switch (alt41) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:252:5: optimizeClause
					{
					pushFollow(FOLLOW_optimizeClause_in_queryExpression951);
					optimizeClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:253:3: ( withClause )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==FOR) ) {
				int LA42_1 = input.LA(2);
				if ( (synpred48_SQLAnalyzer()) ) {
					alt42=1;
				}
			}
			else if ( (LA42_0==WITH) ) {
				int LA42_2 = input.LA(2);
				if ( (synpred48_SQLAnalyzer()) ) {
					alt42=1;
				}
			}
			switch (alt42) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:253:5: withClause
					{
					pushFollow(FOLLOW_withClause_in_queryExpression960);
					withClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:254:3: ( startClause )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==START) ) {
				int LA43_1 = input.LA(2);
				if ( (synpred49_SQLAnalyzer()) ) {
					alt43=1;
				}
			}
			switch (alt43) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:254:5: startClause
					{
					pushFollow(FOLLOW_startClause_in_queryExpression969);
					startClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, queryExpression_StartIndex); }

		}
	}
	// $ANTLR end "queryExpression"



	// $ANTLR start "subQueryExpression"
	// parser\\sql\\SQLAnalyzer.g:257:1: subQueryExpression : (s= querySpecification | LPAREN s= queryExpression RPAREN );
	public final void subQueryExpression() throws RecognitionException {
		int subQueryExpression_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:257:21: (s= querySpecification | LPAREN s= queryExpression RPAREN )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==SELECT) ) {
				alt44=1;
			}
			else if ( (LA44_0==LPAREN) ) {
				alt44=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:258:4: s= querySpecification
					{
					pushFollow(FOLLOW_querySpecification_in_subQueryExpression991);
					querySpecification();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:259:5: LPAREN s= queryExpression RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_subQueryExpression999); if (state.failed) return;
					pushFollow(FOLLOW_queryExpression_in_subQueryExpression1005);
					queryExpression();
					state._fsp--;
					if (state.failed) return;
					match(input,RPAREN,FOLLOW_RPAREN_in_subQueryExpression1007); if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, subQueryExpression_StartIndex); }

		}
	}
	// $ANTLR end "subQueryExpression"



	// $ANTLR start "querySpecification"
	// parser\\sql\\SQLAnalyzer.g:262:1: querySpecification : s= selectClause (f= fromClause )? (w= whereClause )? (g= groupByClause )? (h= havingClause )? (o= orderByClause )? ( fetchClause )? ( optimizeClause )? ( withClause )? ( startClause )? ;
	public final void querySpecification() throws RecognitionException {
		int querySpecification_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:262:21: (s= selectClause (f= fromClause )? (w= whereClause )? (g= groupByClause )? (h= havingClause )? (o= orderByClause )? ( fetchClause )? ( optimizeClause )? ( withClause )? ( startClause )? )
			// parser\\sql\\SQLAnalyzer.g:263:3: s= selectClause (f= fromClause )? (w= whereClause )? (g= groupByClause )? (h= havingClause )? (o= orderByClause )? ( fetchClause )? ( optimizeClause )? ( withClause )? ( startClause )?
			{
			pushFollow(FOLLOW_selectClause_in_querySpecification1026);
			selectClause();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:264:3: (f= fromClause )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==FROM) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:264:5: f= fromClause
					{
					pushFollow(FOLLOW_fromClause_in_querySpecification1037);
					fromClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:265:3: (w= whereClause )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==WHERE) ) {
				int LA46_1 = input.LA(2);
				if ( (synpred52_SQLAnalyzer()) ) {
					alt46=1;
				}
			}
			switch (alt46) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:265:5: w= whereClause
					{
					pushFollow(FOLLOW_whereClause_in_querySpecification1051);
					whereClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:266:3: (g= groupByClause )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==GROUP) ) {
				int LA47_1 = input.LA(2);
				if ( (synpred53_SQLAnalyzer()) ) {
					alt47=1;
				}
			}
			switch (alt47) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:266:5: g= groupByClause
					{
					pushFollow(FOLLOW_groupByClause_in_querySpecification1065);
					groupByClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:267:5: (h= havingClause )?
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==HAVING) ) {
				int LA48_1 = input.LA(2);
				if ( (synpred54_SQLAnalyzer()) ) {
					alt48=1;
				}
			}
			switch (alt48) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:267:7: h= havingClause
					{
					pushFollow(FOLLOW_havingClause_in_querySpecification1080);
					havingClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:268:5: (o= orderByClause )?
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==ORDER) ) {
				int LA49_1 = input.LA(2);
				if ( (synpred55_SQLAnalyzer()) ) {
					alt49=1;
				}
			}
			switch (alt49) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:268:7: o= orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_querySpecification1096);
					orderByClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:269:3: ( fetchClause )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==FOR) ) {
				int LA50_1 = input.LA(2);
				if ( (synpred56_SQLAnalyzer()) ) {
					alt50=1;
				}
			}
			else if ( (LA50_0==FETCH) ) {
				int LA50_2 = input.LA(2);
				if ( (synpred56_SQLAnalyzer()) ) {
					alt50=1;
				}
			}
			switch (alt50) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:269:5: fetchClause
					{
					pushFollow(FOLLOW_fetchClause_in_querySpecification1105);
					fetchClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:270:3: ( optimizeClause )?
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==OPTIMIZE) ) {
				int LA51_1 = input.LA(2);
				if ( (synpred57_SQLAnalyzer()) ) {
					alt51=1;
				}
			}
			switch (alt51) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:270:5: optimizeClause
					{
					pushFollow(FOLLOW_optimizeClause_in_querySpecification1114);
					optimizeClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:271:3: ( withClause )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==FOR) ) {
				int LA52_1 = input.LA(2);
				if ( (synpred58_SQLAnalyzer()) ) {
					alt52=1;
				}
			}
			else if ( (LA52_0==WITH) ) {
				int LA52_2 = input.LA(2);
				if ( (synpred58_SQLAnalyzer()) ) {
					alt52=1;
				}
			}
			switch (alt52) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:271:5: withClause
					{
					pushFollow(FOLLOW_withClause_in_querySpecification1123);
					withClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:272:3: ( startClause )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==START) ) {
				int LA53_1 = input.LA(2);
				if ( (synpred59_SQLAnalyzer()) ) {
					alt53=1;
				}
			}
			switch (alt53) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:272:5: startClause
					{
					pushFollow(FOLLOW_startClause_in_querySpecification1132);
					startClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, querySpecification_StartIndex); }

		}
	}
	// $ANTLR end "querySpecification"



	// $ANTLR start "selectClause"
	// parser\\sql\\SQLAnalyzer.g:276:1: selectClause : SELECT ( ALL | DISTINCT )? s= selectList ;
	public final void selectClause() throws RecognitionException {
		int selectClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:276:15: ( SELECT ( ALL | DISTINCT )? s= selectList )
			// parser\\sql\\SQLAnalyzer.g:277:3: SELECT ( ALL | DISTINCT )? s= selectList
			{
			match(input,SELECT,FOLLOW_SELECT_in_selectClause1152); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:278:3: ( ALL | DISTINCT )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==ALL||LA54_0==DISTINCT) ) {
				alt54=1;
			}
			switch (alt54) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( input.LA(1)==ALL||input.LA(1)==DISTINCT ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			pushFollow(FOLLOW_selectList_in_selectClause1178);
			selectList();
			state._fsp--;
			if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 16, selectClause_StartIndex); }

		}
	}
	// $ANTLR end "selectClause"



	// $ANTLR start "whereClause"
	// parser\\sql\\SQLAnalyzer.g:283:1: whereClause : WHERE c= searchCondition ;
	public final void whereClause() throws RecognitionException {
		int whereClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:283:14: ( WHERE c= searchCondition )
			// parser\\sql\\SQLAnalyzer.g:284:3: WHERE c= searchCondition
			{
			match(input,WHERE,FOLLOW_WHERE_in_whereClause1193); if (state.failed) return;
			pushFollow(FOLLOW_searchCondition_in_whereClause1199);
			searchCondition();
			state._fsp--;
			if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 17, whereClause_StartIndex); }

		}
	}
	// $ANTLR end "whereClause"



	// $ANTLR start "orderByClause"
	// parser\\sql\\SQLAnalyzer.g:287:1: orderByClause : ORDER BY e= orderExpression ( COMMA e= orderExpression )* ;
	public final void orderByClause() throws RecognitionException {
		int orderByClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:287:16: ( ORDER BY e= orderExpression ( COMMA e= orderExpression )* )
			// parser\\sql\\SQLAnalyzer.g:288:3: ORDER BY e= orderExpression ( COMMA e= orderExpression )*
			{
			match(input,ORDER,FOLLOW_ORDER_in_orderByClause1214); if (state.failed) return;
			match(input,BY,FOLLOW_BY_in_orderByClause1216); if (state.failed) return;
			pushFollow(FOLLOW_orderExpression_in_orderByClause1224);
			orderExpression();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:290:3: ( COMMA e= orderExpression )*
			loop55:
			while (true) {
				int alt55=2;
				int LA55_0 = input.LA(1);
				if ( (LA55_0==COMMA) ) {
					int LA55_2 = input.LA(2);
					if ( (synpred62_SQLAnalyzer()) ) {
						alt55=1;
					}

				}

				switch (alt55) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:290:5: COMMA e= orderExpression
					{
					match(input,COMMA,FOLLOW_COMMA_in_orderByClause1231); if (state.failed) return;
					pushFollow(FOLLOW_orderExpression_in_orderByClause1237);
					orderExpression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop55;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 18, orderByClause_StartIndex); }

		}
	}
	// $ANTLR end "orderByClause"



	// $ANTLR start "orderExpression"
	// parser\\sql\\SQLAnalyzer.g:293:1: orderExpression : e= expression ( ASC | DESC | NULLS FIRST )? ;
	public final void orderExpression() throws RecognitionException {
		int orderExpression_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:293:18: (e= expression ( ASC | DESC | NULLS FIRST )? )
			// parser\\sql\\SQLAnalyzer.g:294:3: e= expression ( ASC | DESC | NULLS FIRST )?
			{
			pushFollow(FOLLOW_expression_in_orderExpression1259);
			expression();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:295:3: ( ASC | DESC | NULLS FIRST )?
			int alt56=4;
			switch ( input.LA(1) ) {
				case ASC:
					{
					int LA56_1 = input.LA(2);
					if ( (synpred63_SQLAnalyzer()) ) {
						alt56=1;
					}
					}
					break;
				case DESC:
					{
					int LA56_2 = input.LA(2);
					if ( (synpred64_SQLAnalyzer()) ) {
						alt56=2;
					}
					}
					break;
				case NULLS:
					{
					int LA56_3 = input.LA(2);
					if ( (synpred65_SQLAnalyzer()) ) {
						alt56=3;
					}
					}
					break;
			}
			switch (alt56) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:295:5: ASC
					{
					match(input,ASC,FOLLOW_ASC_in_orderExpression1267); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:295:11: DESC
					{
					match(input,DESC,FOLLOW_DESC_in_orderExpression1271); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:295:19: NULLS FIRST
					{
					match(input,NULLS,FOLLOW_NULLS_in_orderExpression1276); if (state.failed) return;
					match(input,FIRST,FOLLOW_FIRST_in_orderExpression1278); if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 19, orderExpression_StartIndex); }

		}
	}
	// $ANTLR end "orderExpression"



	// $ANTLR start "groupByClause"
	// parser\\sql\\SQLAnalyzer.g:298:1: groupByClause : GROUP BY ( ALL )? e= expression ( COMMA ie= expression )* ;
	public final void groupByClause() throws RecognitionException {
		int groupByClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:298:16: ( GROUP BY ( ALL )? e= expression ( COMMA ie= expression )* )
			// parser\\sql\\SQLAnalyzer.g:299:3: GROUP BY ( ALL )? e= expression ( COMMA ie= expression )*
			{
			match(input,GROUP,FOLLOW_GROUP_in_groupByClause1294); if (state.failed) return;
			match(input,BY,FOLLOW_BY_in_groupByClause1296); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:300:5: ( ALL )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==ALL) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:300:7: ALL
					{
					match(input,ALL,FOLLOW_ALL_in_groupByClause1305); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_expression_in_groupByClause1318);
			expression();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:301:20: ( COMMA ie= expression )*
			loop58:
			while (true) {
				int alt58=2;
				int LA58_0 = input.LA(1);
				if ( (LA58_0==COMMA) ) {
					int LA58_2 = input.LA(2);
					if ( (synpred67_SQLAnalyzer()) ) {
						alt58=1;
					}

				}

				switch (alt58) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:301:22: COMMA ie= expression
					{
					match(input,COMMA,FOLLOW_COMMA_in_groupByClause1323); if (state.failed) return;
					pushFollow(FOLLOW_expression_in_groupByClause1330);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop58;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 20, groupByClause_StartIndex); }

		}
	}
	// $ANTLR end "groupByClause"



	// $ANTLR start "havingClause"
	// parser\\sql\\SQLAnalyzer.g:305:1: havingClause : HAVING c= searchCondition ;
	public final void havingClause() throws RecognitionException {
		int havingClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:305:15: ( HAVING c= searchCondition )
			// parser\\sql\\SQLAnalyzer.g:306:3: HAVING c= searchCondition
			{
			match(input,HAVING,FOLLOW_HAVING_in_havingClause1349); if (state.failed) return;
			pushFollow(FOLLOW_searchCondition_in_havingClause1355);
			searchCondition();
			state._fsp--;
			if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 21, havingClause_StartIndex); }

		}
	}
	// $ANTLR end "havingClause"



	// $ANTLR start "fetchClause"
	// parser\\sql\\SQLAnalyzer.g:310:1: fetchClause : ( FOR )? FETCH ( FIRST )? ( expression )? ( rowAndRows )? ONLY ;
	public final void fetchClause() throws RecognitionException {
		int fetchClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:310:13: ( ( FOR )? FETCH ( FIRST )? ( expression )? ( rowAndRows )? ONLY )
			// parser\\sql\\SQLAnalyzer.g:311:3: ( FOR )? FETCH ( FIRST )? ( expression )? ( rowAndRows )? ONLY
			{
			// parser\\sql\\SQLAnalyzer.g:311:3: ( FOR )?
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==FOR) ) {
				alt59=1;
			}
			switch (alt59) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:311:3: FOR
					{
					match(input,FOR,FOLLOW_FOR_in_fetchClause1372); if (state.failed) return;
					}
					break;

			}

			match(input,FETCH,FOLLOW_FETCH_in_fetchClause1375); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:311:14: ( FIRST )?
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==FIRST) ) {
				alt60=1;
			}
			switch (alt60) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:311:14: FIRST
					{
					match(input,FIRST,FOLLOW_FIRST_in_fetchClause1377); if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:311:21: ( expression )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==AVG||LA61_0==AsciiStringLiteral||(LA61_0 >= CASE && LA61_0 <= CAST)||(LA61_0 >= CURRENT && LA61_0 <= CURRENT_TIMESTAMP)||(LA61_0 >= DASH && LA61_0 <= DECODE)||(LA61_0 >= DENSE && LA61_0 <= DESC)||LA61_0==EXTRACT||LA61_0==GROUP||LA61_0==HOUR||LA61_0==HexLiteral||(LA61_0 >= INT && LA61_0 <= INTERVAL)||(LA61_0 >= Integer && LA61_0 <= Iso8601DateTime)||LA61_0==LEFT||LA61_0==LPAREN||(LA61_0 >= MAX && LA61_0 <= MAccessDateTime)||LA61_0==MIN||LA61_0==MINUTE||LA61_0==MONTH||LA61_0==NEXT||LA61_0==NULL||LA61_0==NVL||LA61_0==NonQuotedIdentifier||LA61_0==ORDER||LA61_0==OVER||(LA61_0 >= PLACEHOLDER && LA61_0 <= PLUS)||(LA61_0 >= QuotedIdentifier && LA61_0 <= RANK)||LA61_0==RIGHT||(LA61_0 >= Real && LA61_0 <= SECOND)||(LA61_0 >= SUBSTRING && LA61_0 <= SYSDATE)||(LA61_0 >= TIME && LA61_0 <= TIMESTAMP)||LA61_0==UPDATE||LA61_0==UicodeValueLiteral||LA61_0==UnicodeStringLiteral||LA61_0==VALUE||LA61_0==Variable||(LA61_0 >= YEAR && LA61_0 <= YEARS)) ) {
				alt61=1;
			}
			else if ( (LA61_0==ROW) ) {
				int LA61_2 = input.LA(2);
				if ( (LA61_2==UNDERSCOPE) ) {
					alt61=1;
				}
			}
			switch (alt61) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:311:21: expression
					{
					pushFollow(FOLLOW_expression_in_fetchClause1380);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:311:33: ( rowAndRows )?
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( ((LA62_0 >= ROW && LA62_0 <= ROWS)) ) {
				alt62=1;
			}
			switch (alt62) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:311:33: rowAndRows
					{
					pushFollow(FOLLOW_rowAndRows_in_fetchClause1383);
					rowAndRows();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,ONLY,FOLLOW_ONLY_in_fetchClause1386); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 22, fetchClause_StartIndex); }

		}
	}
	// $ANTLR end "fetchClause"



	// $ANTLR start "optimizeClause"
	// parser\\sql\\SQLAnalyzer.g:314:1: optimizeClause : OPTIMIZE FOR expression rowAndRows ;
	public final void optimizeClause() throws RecognitionException {
		int optimizeClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:314:16: ( OPTIMIZE FOR expression rowAndRows )
			// parser\\sql\\SQLAnalyzer.g:315:1: OPTIMIZE FOR expression rowAndRows
			{
			match(input,OPTIMIZE,FOLLOW_OPTIMIZE_in_optimizeClause1397); if (state.failed) return;
			match(input,FOR,FOLLOW_FOR_in_optimizeClause1399); if (state.failed) return;
			pushFollow(FOLLOW_expression_in_optimizeClause1401);
			expression();
			state._fsp--;
			if (state.failed) return;
			pushFollow(FOLLOW_rowAndRows_in_optimizeClause1403);
			rowAndRows();
			state._fsp--;
			if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 23, optimizeClause_StartIndex); }

		}
	}
	// $ANTLR end "optimizeClause"



	// $ANTLR start "withClause"
	// parser\\sql\\SQLAnalyzer.g:318:1: withClause : ( FOR READ ONLY )? WITH UR ;
	public final void withClause() throws RecognitionException {
		int withClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:318:12: ( ( FOR READ ONLY )? WITH UR )
			// parser\\sql\\SQLAnalyzer.g:319:3: ( FOR READ ONLY )? WITH UR
			{
			// parser\\sql\\SQLAnalyzer.g:319:3: ( FOR READ ONLY )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==FOR) ) {
				alt63=1;
			}
			switch (alt63) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:319:4: FOR READ ONLY
					{
					match(input,FOR,FOLLOW_FOR_in_withClause1418); if (state.failed) return;
					match(input,READ,FOLLOW_READ_in_withClause1420); if (state.failed) return;
					match(input,ONLY,FOLLOW_ONLY_in_withClause1422); if (state.failed) return;
					}
					break;

			}

			match(input,WITH,FOLLOW_WITH_in_withClause1426); if (state.failed) return;
			match(input,UR,FOLLOW_UR_in_withClause1428); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 24, withClause_StartIndex); }

		}
	}
	// $ANTLR end "withClause"



	// $ANTLR start "startClause"
	// parser\\sql\\SQLAnalyzer.g:321:1: startClause : START WITH searchCondition CONNECT BY PRIOR searchCondition ;
	public final void startClause() throws RecognitionException {
		int startClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:321:13: ( START WITH searchCondition CONNECT BY PRIOR searchCondition )
			// parser\\sql\\SQLAnalyzer.g:322:3: START WITH searchCondition CONNECT BY PRIOR searchCondition
			{
			match(input,START,FOLLOW_START_in_startClause1440); if (state.failed) return;
			match(input,WITH,FOLLOW_WITH_in_startClause1442); if (state.failed) return;
			pushFollow(FOLLOW_searchCondition_in_startClause1444);
			searchCondition();
			state._fsp--;
			if (state.failed) return;
			match(input,CONNECT,FOLLOW_CONNECT_in_startClause1446); if (state.failed) return;
			match(input,BY,FOLLOW_BY_in_startClause1448); if (state.failed) return;
			match(input,PRIOR,FOLLOW_PRIOR_in_startClause1450); if (state.failed) return;
			pushFollow(FOLLOW_searchCondition_in_startClause1452);
			searchCondition();
			state._fsp--;
			if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 25, startClause_StartIndex); }

		}
	}
	// $ANTLR end "startClause"



	// $ANTLR start "rowAndRows"
	// parser\\sql\\SQLAnalyzer.g:324:1: rowAndRows : ( ROW | ROWS );
	public final void rowAndRows() throws RecognitionException {
		int rowAndRows_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:324:12: ( ROW | ROWS )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( (input.LA(1) >= ROW && input.LA(1) <= ROWS) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 26, rowAndRows_StartIndex); }

		}
	}
	// $ANTLR end "rowAndRows"



	// $ANTLR start "searchCondition"
	// parser\\sql\\SQLAnalyzer.g:328:1: searchCondition : e= additiveSubSearchCondition ( OR r= additiveSubSearchCondition )* ;
	public final void searchCondition() throws RecognitionException {
		int searchCondition_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:328:18: (e= additiveSubSearchCondition ( OR r= additiveSubSearchCondition )* )
			// parser\\sql\\SQLAnalyzer.g:329:3: e= additiveSubSearchCondition ( OR r= additiveSubSearchCondition )*
			{
			pushFollow(FOLLOW_additiveSubSearchCondition_in_searchCondition1485);
			additiveSubSearchCondition();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:330:5: ( OR r= additiveSubSearchCondition )*
			loop64:
			while (true) {
				int alt64=2;
				int LA64_0 = input.LA(1);
				if ( (LA64_0==OR) ) {
					int LA64_2 = input.LA(2);
					if ( (synpred74_SQLAnalyzer()) ) {
						alt64=1;
					}

				}

				switch (alt64) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:330:7: OR r= additiveSubSearchCondition
					{
					match(input,OR,FOLLOW_OR_in_searchCondition1494); if (state.failed) return;
					pushFollow(FOLLOW_additiveSubSearchCondition_in_searchCondition1500);
					additiveSubSearchCondition();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop64;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 27, searchCondition_StartIndex); }

		}
	}
	// $ANTLR end "searchCondition"



	// $ANTLR start "additiveSubSearchCondition"
	// parser\\sql\\SQLAnalyzer.g:334:1: additiveSubSearchCondition : e= subSearchCondition ( AND r= subSearchCondition )* ;
	public final void additiveSubSearchCondition() throws RecognitionException {
		int additiveSubSearchCondition_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:334:29: (e= subSearchCondition ( AND r= subSearchCondition )* )
			// parser\\sql\\SQLAnalyzer.g:335:3: e= subSearchCondition ( AND r= subSearchCondition )*
			{
			pushFollow(FOLLOW_subSearchCondition_in_additiveSubSearchCondition1525);
			subSearchCondition();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:336:5: ( AND r= subSearchCondition )*
			loop65:
			while (true) {
				int alt65=2;
				int LA65_0 = input.LA(1);
				if ( (LA65_0==AND) ) {
					int LA65_2 = input.LA(2);
					if ( (synpred75_SQLAnalyzer()) ) {
						alt65=1;
					}

				}

				switch (alt65) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:336:7: AND r= subSearchCondition
					{
					match(input,AND,FOLLOW_AND_in_additiveSubSearchCondition1534); if (state.failed) return;
					pushFollow(FOLLOW_subSearchCondition_in_additiveSubSearchCondition1540);
					subSearchCondition();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop65;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 28, additiveSubSearchCondition_StartIndex); }

		}
	}
	// $ANTLR end "additiveSubSearchCondition"



	// $ANTLR start "bracketedSearchCondition"
	// parser\\sql\\SQLAnalyzer.g:340:1: bracketedSearchCondition : LPAREN e= searchCondition RPAREN ;
	public final void bracketedSearchCondition() throws RecognitionException {
		int bracketedSearchCondition_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:340:27: ( LPAREN e= searchCondition RPAREN )
			// parser\\sql\\SQLAnalyzer.g:341:3: LPAREN e= searchCondition RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_bracketedSearchCondition1562); if (state.failed) return;
			pushFollow(FOLLOW_searchCondition_in_bracketedSearchCondition1568);
			searchCondition();
			state._fsp--;
			if (state.failed) return;
			match(input,RPAREN,FOLLOW_RPAREN_in_bracketedSearchCondition1570); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 29, bracketedSearchCondition_StartIndex); }

		}
	}
	// $ANTLR end "bracketedSearchCondition"



	// $ANTLR start "subSearchCondition"
	// parser\\sql\\SQLAnalyzer.g:344:1: subSearchCondition : ( NOT )? ( ( bracketedSearchCondition )=>e= bracketedSearchCondition ( comparisonOperator expression )? |p= predicate ) ;
	public final void subSearchCondition() throws RecognitionException {
		int subSearchCondition_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:344:21: ( ( NOT )? ( ( bracketedSearchCondition )=>e= bracketedSearchCondition ( comparisonOperator expression )? |p= predicate ) )
			// parser\\sql\\SQLAnalyzer.g:345:3: ( NOT )? ( ( bracketedSearchCondition )=>e= bracketedSearchCondition ( comparisonOperator expression )? |p= predicate )
			{
			// parser\\sql\\SQLAnalyzer.g:345:3: ( NOT )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==NOT) ) {
				alt66=1;
			}
			switch (alt66) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:345:5: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_subSearchCondition1587); if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:345:12: ( ( bracketedSearchCondition )=>e= bracketedSearchCondition ( comparisonOperator expression )? |p= predicate )
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==LPAREN) ) {
				int LA68_1 = input.LA(2);
				if ( (synpred77_SQLAnalyzer()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

			}
			else if ( (LA68_0==AVG||LA68_0==AsciiStringLiteral||(LA68_0 >= CASE && LA68_0 <= CAST)||(LA68_0 >= CURRENT && LA68_0 <= CURRENT_TIMESTAMP)||(LA68_0 >= DASH && LA68_0 <= DECODE)||(LA68_0 >= DENSE && LA68_0 <= DESC)||(LA68_0 >= EXISTS && LA68_0 <= EXTRACT)||LA68_0==GROUP||LA68_0==HOUR||LA68_0==HexLiteral||(LA68_0 >= INT && LA68_0 <= INTERVAL)||(LA68_0 >= Integer && LA68_0 <= Iso8601DateTime)||LA68_0==LEFT||(LA68_0 >= MAX && LA68_0 <= MAccessDateTime)||LA68_0==MIN||LA68_0==MINUTE||LA68_0==MONTH||LA68_0==NEXT||LA68_0==NULL||LA68_0==NVL||LA68_0==NonQuotedIdentifier||LA68_0==ORDER||LA68_0==OVER||(LA68_0 >= PLACEHOLDER && LA68_0 <= PLUS)||(LA68_0 >= QuotedIdentifier && LA68_0 <= RANK)||(LA68_0 >= RIGHT && LA68_0 <= ROW)||(LA68_0 >= Real && LA68_0 <= SECOND)||LA68_0==START||(LA68_0 >= SUBSTRING && LA68_0 <= SYSDATE)||(LA68_0 >= TIME && LA68_0 <= TIMESTAMP)||LA68_0==UPDATE||LA68_0==UicodeValueLiteral||LA68_0==UnicodeStringLiteral||LA68_0==VALUE||LA68_0==Variable||(LA68_0 >= YEAR && LA68_0 <= YEARS)) ) {
				alt68=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:346:5: ( bracketedSearchCondition )=>e= bracketedSearchCondition ( comparisonOperator expression )?
					{
					pushFollow(FOLLOW_bracketedSearchCondition_in_subSearchCondition1614);
					bracketedSearchCondition();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:347:37: ( comparisonOperator expression )?
					int alt67=2;
					alt67 = dfa67.predict(input);
					switch (alt67) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:347:38: comparisonOperator expression
							{
							pushFollow(FOLLOW_comparisonOperator_in_subSearchCondition1618);
							comparisonOperator();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_expression_in_subSearchCondition1620);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:348:7: p= predicate
					{
					pushFollow(FOLLOW_predicate_in_subSearchCondition1634);
					predicate();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 30, subSearchCondition_StartIndex); }

		}
	}
	// $ANTLR end "subSearchCondition"



	// $ANTLR start "predicate"
	// parser\\sql\\SQLAnalyzer.g:353:1: predicate : (l= expression ( plusSignature )? (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) | IS ( NOT )? NULL | ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? ) ) | EXISTS LPAREN s= selectStatement RPAREN | function | startClause );
	public final void predicate() throws RecognitionException {
		int predicate_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:353:12: (l= expression ( plusSignature )? (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) | IS ( NOT )? NULL | ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? ) ) | EXISTS LPAREN s= selectStatement RPAREN | function | startClause )
			int alt82=4;
			switch ( input.LA(1) ) {
			case AVG:
			case AsciiStringLiteral:
			case CASE:
			case CAST:
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DASH:
			case DATE:
			case DAY:
			case DECODE:
			case DENSE:
			case DESC:
			case GROUP:
			case HOUR:
			case HexLiteral:
			case INT:
			case INTERVAL:
			case Integer:
			case Iso8601DateTime:
			case MAX:
			case MAccessDateTime:
			case MIN:
			case MINUTE:
			case MONTH:
			case NEXT:
			case NULL:
			case NVL:
			case ORDER:
			case OVER:
			case PLACEHOLDER:
			case PLUS:
			case QuotedIdentifier:
			case RANK:
			case ROW:
			case Real:
			case SECOND:
			case SUM:
			case SYSDATE:
			case TIME:
			case TIMESTAMP:
			case UPDATE:
			case UicodeValueLiteral:
			case UnicodeStringLiteral:
			case VALUE:
			case Variable:
			case YEAR:
			case YEARS:
				{
				alt82=1;
				}
				break;
			case NonQuotedIdentifier:
				{
				int LA82_11 = input.LA(2);
				if ( (synpred95_SQLAnalyzer()) ) {
					alt82=1;
				}
				else if ( (synpred97_SQLAnalyzer()) ) {
					alt82=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 82, 11, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case SUBSTRING:
				{
				int LA82_44 = input.LA(2);
				if ( (synpred95_SQLAnalyzer()) ) {
					alt82=1;
				}
				else if ( (synpred97_SQLAnalyzer()) ) {
					alt82=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 82, 44, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case EXTRACT:
				{
				int LA82_45 = input.LA(2);
				if ( (synpred95_SQLAnalyzer()) ) {
					alt82=1;
				}
				else if ( (synpred97_SQLAnalyzer()) ) {
					alt82=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 82, 45, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LPAREN:
				{
				int LA82_46 = input.LA(2);
				if ( (synpred95_SQLAnalyzer()) ) {
					alt82=1;
				}
				else if ( (synpred97_SQLAnalyzer()) ) {
					alt82=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 82, 46, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LEFT:
				{
				int LA82_47 = input.LA(2);
				if ( (synpred95_SQLAnalyzer()) ) {
					alt82=1;
				}
				else if ( (synpred97_SQLAnalyzer()) ) {
					alt82=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 82, 47, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RIGHT:
				{
				int LA82_48 = input.LA(2);
				if ( (synpred95_SQLAnalyzer()) ) {
					alt82=1;
				}
				else if ( (synpred97_SQLAnalyzer()) ) {
					alt82=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 82, 48, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case EXISTS:
				{
				alt82=2;
				}
				break;
			case START:
				{
				alt82=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 82, 0, input);
				throw nvae;
			}
			switch (alt82) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:354:5: l= expression ( plusSignature )? (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) | IS ( NOT )? NULL | ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? ) )
					{
					pushFollow(FOLLOW_expression_in_predicate1664);
					expression();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:354:21: ( plusSignature )?
					int alt69=2;
					int LA69_0 = input.LA(1);
					if ( (LA69_0==LPAREN) ) {
						alt69=1;
					}
					switch (alt69) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:354:22: plusSignature
							{
							pushFollow(FOLLOW_plusSignature_in_predicate1668);
							plusSignature();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// parser\\sql\\SQLAnalyzer.g:355:4: (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) | IS ( NOT )? NULL | ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? ) )
					int alt81=3;
					switch ( input.LA(1) ) {
					case ASSIGNEQUAL:
					case GREATERTHAN:
					case GREATERTHANOREQUALTO1:
					case LESSTHAN:
					case LESSTHANOREQUALTO1:
					case NOTEQUAL1:
					case NOTEQUAL2:
						{
						alt81=1;
						}
						break;
					case BETWEEN:
						{
						int LA81_8 = input.LA(2);
						if ( (synpred82_SQLAnalyzer()) ) {
							alt81=1;
						}
						else if ( (true) ) {
							alt81=3;
						}

						}
						break;
					case IS:
						{
						alt81=2;
						}
						break;
					case IN:
					case LIKE:
					case NOT:
						{
						alt81=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 81, 0, input);
						throw nvae;
					}
					switch (alt81) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:356:11: o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN )
							{
							pushFollow(FOLLOW_comparisonOperator_in_predicate1696);
							comparisonOperator();
							state._fsp--;
							if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:356:34: (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN )
							int alt71=2;
							int LA71_0 = input.LA(1);
							if ( (LA71_0==AVG||LA71_0==AsciiStringLiteral||(LA71_0 >= CASE && LA71_0 <= CAST)||(LA71_0 >= CURRENT && LA71_0 <= CURRENT_TIMESTAMP)||(LA71_0 >= DASH && LA71_0 <= DECODE)||(LA71_0 >= DENSE && LA71_0 <= DESC)||LA71_0==EXTRACT||LA71_0==GROUP||LA71_0==HOUR||LA71_0==HexLiteral||(LA71_0 >= INT && LA71_0 <= INTERVAL)||(LA71_0 >= Integer && LA71_0 <= Iso8601DateTime)||LA71_0==LEFT||LA71_0==LPAREN||(LA71_0 >= MAX && LA71_0 <= MAccessDateTime)||LA71_0==MIN||LA71_0==MINUTE||LA71_0==MONTH||LA71_0==NEXT||LA71_0==NULL||LA71_0==NVL||LA71_0==NonQuotedIdentifier||LA71_0==ORDER||LA71_0==OVER||(LA71_0 >= PLACEHOLDER && LA71_0 <= PLUS)||(LA71_0 >= QuotedIdentifier && LA71_0 <= RANK)||(LA71_0 >= RIGHT && LA71_0 <= ROW)||(LA71_0 >= Real && LA71_0 <= SECOND)||(LA71_0 >= SUBSTRING && LA71_0 <= SYSDATE)||(LA71_0 >= TIME && LA71_0 <= TIMESTAMP)||LA71_0==UPDATE||LA71_0==UicodeValueLiteral||LA71_0==UnicodeStringLiteral||LA71_0==VALUE||LA71_0==Variable||(LA71_0 >= YEAR && LA71_0 <= YEARS)) ) {
								alt71=1;
							}
							else if ( (LA71_0==ALL||LA71_0==ANY||LA71_0==SOME) ) {
								alt71=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return;}
								NoViableAltException nvae =
									new NoViableAltException("", 71, 0, input);
								throw nvae;
							}

							switch (alt71) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:357:17: r= expression ( plusSignature )?
									{
									pushFollow(FOLLOW_expression_in_predicate1720);
									expression();
									state._fsp--;
									if (state.failed) return;
									// parser\\sql\\SQLAnalyzer.g:357:32: ( plusSignature )?
									int alt70=2;
									int LA70_0 = input.LA(1);
									if ( (LA70_0==LPAREN) ) {
										int LA70_1 = input.LA(2);
										if ( (LA70_1==PLUS) ) {
											int LA70_3 = input.LA(3);
											if ( (LA70_3==RPAREN) ) {
												alt70=1;
											}
										}
									}
									switch (alt70) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:357:33: plusSignature
											{
											pushFollow(FOLLOW_plusSignature_in_predicate1723);
											plusSignature();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									}
									break;
								case 2 :
									// parser\\sql\\SQLAnalyzer.g:358:9: q= quantifierSpec LPAREN s= selectStatement RPAREN
									{
									pushFollow(FOLLOW_quantifierSpec_in_predicate1739);
									quantifierSpec();
									state._fsp--;
									if (state.failed) return;
									match(input,LPAREN,FOLLOW_LPAREN_in_predicate1749); if (state.failed) return;
									pushFollow(FOLLOW_selectStatement_in_predicate1755);
									selectStatement();
									state._fsp--;
									if (state.failed) return;
									match(input,RPAREN,FOLLOW_RPAREN_in_predicate1757); if (state.failed) return;
									}
									break;

							}

							}
							break;
						case 2 :
							// parser\\sql\\SQLAnalyzer.g:361:7: IS ( NOT )? NULL
							{
							match(input,IS,FOLLOW_IS_in_predicate1780); if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:362:7: ( NOT )?
							int alt72=2;
							int LA72_0 = input.LA(1);
							if ( (LA72_0==NOT) ) {
								alt72=1;
							}
							switch (alt72) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:362:9: NOT
									{
									match(input,NOT,FOLLOW_NOT_in_predicate1791); if (state.failed) return;
									}
									break;

							}

							match(input,NULL,FOLLOW_NULL_in_predicate1796); if (state.failed) return;
							}
							break;
						case 3 :
							// parser\\sql\\SQLAnalyzer.g:363:7: ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? )
							{
							// parser\\sql\\SQLAnalyzer.g:363:7: ( NOT )?
							int alt73=2;
							int LA73_0 = input.LA(1);
							if ( (LA73_0==NOT) ) {
								alt73=1;
							}
							switch (alt73) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:363:9: NOT
									{
									match(input,NOT,FOLLOW_NOT_in_predicate1806); if (state.failed) return;
									}
									break;

							}

							// parser\\sql\\SQLAnalyzer.g:363:16: ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? )
							int alt80=3;
							switch ( input.LA(1) ) {
							case LIKE:
								{
								alt80=1;
								}
								break;
							case BETWEEN:
								{
								alt80=2;
								}
								break;
							case IN:
								{
								alt80=3;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return;}
								NoViableAltException nvae =
									new NoViableAltException("", 80, 0, input);
								throw nvae;
							}
							switch (alt80) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:364:7: LIKE e= expression ( ESCAPE f= expression )?
									{
									match(input,LIKE,FOLLOW_LIKE_in_predicate1819); if (state.failed) return;
									pushFollow(FOLLOW_expression_in_predicate1825);
									expression();
									state._fsp--;
									if (state.failed) return;
									// parser\\sql\\SQLAnalyzer.g:365:9: ( ESCAPE f= expression )?
									int alt74=2;
									int LA74_0 = input.LA(1);
									if ( (LA74_0==ESCAPE) ) {
										alt74=1;
									}
									switch (alt74) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:365:11: ESCAPE f= expression
											{
											match(input,ESCAPE,FOLLOW_ESCAPE_in_predicate1838); if (state.failed) return;
											pushFollow(FOLLOW_expression_in_predicate1844);
											expression();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									}
									break;
								case 2 :
									// parser\\sql\\SQLAnalyzer.g:366:9: BETWEEN e= expression AND f= expression
									{
									match(input,BETWEEN,FOLLOW_BETWEEN_in_predicate1858); if (state.failed) return;
									pushFollow(FOLLOW_expression_in_predicate1864);
									expression();
									state._fsp--;
									if (state.failed) return;
									match(input,AND,FOLLOW_AND_in_predicate1866); if (state.failed) return;
									pushFollow(FOLLOW_expression_in_predicate1872);
									expression();
									state._fsp--;
									if (state.failed) return;
									}
									break;
								case 3 :
									// parser\\sql\\SQLAnalyzer.g:367:9: IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )?
									{
									match(input,IN,FOLLOW_IN_in_predicate1883); if (state.failed) return;
									// parser\\sql\\SQLAnalyzer.g:367:12: ( LPAREN )?
									int alt75=2;
									int LA75_0 = input.LA(1);
									if ( (LA75_0==LPAREN) ) {
										int LA75_1 = input.LA(2);
										if ( (synpred89_SQLAnalyzer()) ) {
											alt75=1;
										}
									}
									switch (alt75) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:367:14: LPAREN
											{
											match(input,LPAREN,FOLLOW_LPAREN_in_predicate1887); if (state.failed) return;
											}
											break;

									}

									// parser\\sql\\SQLAnalyzer.g:367:24: ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* )
									int alt78=2;
									int LA78_0 = input.LA(1);
									if ( (LA78_0==SELECT) && (synpred90_SQLAnalyzer())) {
										alt78=1;
									}
									else if ( (LA78_0==LPAREN) ) {
										int LA78_2 = input.LA(2);
										if ( (synpred90_SQLAnalyzer()) ) {
											alt78=1;
										}
										else if ( (true) ) {
											alt78=2;
										}

									}
									else if ( (LA78_0==AVG||LA78_0==AsciiStringLiteral||(LA78_0 >= CASE && LA78_0 <= CAST)||LA78_0==COMMA||(LA78_0 >= CURRENT && LA78_0 <= CURRENT_TIMESTAMP)||(LA78_0 >= DASH && LA78_0 <= DECODE)||(LA78_0 >= DENSE && LA78_0 <= DESC)||LA78_0==EXTRACT||LA78_0==GROUP||LA78_0==HOUR||LA78_0==HexLiteral||(LA78_0 >= INT && LA78_0 <= INTERVAL)||(LA78_0 >= Integer && LA78_0 <= Iso8601DateTime)||LA78_0==LEFT||(LA78_0 >= MAX && LA78_0 <= MAccessDateTime)||LA78_0==MIN||LA78_0==MINUTE||LA78_0==MONTH||LA78_0==NEXT||LA78_0==NULL||LA78_0==NVL||LA78_0==NonQuotedIdentifier||LA78_0==ORDER||LA78_0==OVER||(LA78_0 >= PLACEHOLDER && LA78_0 <= PLUS)||(LA78_0 >= QuotedIdentifier && LA78_0 <= RANK)||(LA78_0 >= RIGHT && LA78_0 <= ROW)||(LA78_0 >= Real && LA78_0 <= SECOND)||(LA78_0 >= SUBSTRING && LA78_0 <= SYSDATE)||(LA78_0 >= TIME && LA78_0 <= TIMESTAMP)||LA78_0==UPDATE||LA78_0==UicodeValueLiteral||LA78_0==UnicodeStringLiteral||(LA78_0 >= VALUE && LA78_0 <= VALUES)||LA78_0==Variable||(LA78_0 >= YEAR && LA78_0 <= YEARS)) ) {
										alt78=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return;}
										NoViableAltException nvae =
											new NoViableAltException("", 78, 0, input);
										throw nvae;
									}

									switch (alt78) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:368:9: ( selectStatement )=>s= selectStatement
											{
											pushFollow(FOLLOW_selectStatement_in_predicate1924);
											selectStatement();
											state._fsp--;
											if (state.failed) return;
											}
											break;
										case 2 :
											// parser\\sql\\SQLAnalyzer.g:370:11: ( VALUES | COMMA )? e= expression ( COMMA e= expression )*
											{
											// parser\\sql\\SQLAnalyzer.g:370:11: ( VALUES | COMMA )?
											int alt76=2;
											int LA76_0 = input.LA(1);
											if ( (LA76_0==COMMA||LA76_0==VALUES) ) {
												alt76=1;
											}
											switch (alt76) {
												case 1 :
													// parser\\sql\\SQLAnalyzer.g:
													{
													if ( input.LA(1)==COMMA||input.LA(1)==VALUES ) {
														input.consume();
														state.errorRecovery=false;
														state.failed=false;
													}
													else {
														if (state.backtracking>0) {state.failed=true; return;}
														MismatchedSetException mse = new MismatchedSetException(null,input);
														throw mse;
													}
													}
													break;

											}

											pushFollow(FOLLOW_expression_in_predicate1950);
											expression();
											state._fsp--;
											if (state.failed) return;
											// parser\\sql\\SQLAnalyzer.g:371:11: ( COMMA e= expression )*
											loop77:
											while (true) {
												int alt77=2;
												alt77 = dfa77.predict(input);
												switch (alt77) {
												case 1 :
													// parser\\sql\\SQLAnalyzer.g:371:13: COMMA e= expression
													{
													match(input,COMMA,FOLLOW_COMMA_in_predicate1965); if (state.failed) return;
													pushFollow(FOLLOW_expression_in_predicate1971);
													expression();
													state._fsp--;
													if (state.failed) return;
													}
													break;

												default :
													break loop77;
												}
											}

											}
											break;

									}

									// parser\\sql\\SQLAnalyzer.g:372:11: ( RPAREN )?
									int alt79=2;
									int LA79_0 = input.LA(1);
									if ( (LA79_0==RPAREN) ) {
										int LA79_1 = input.LA(2);
										if ( (synpred94_SQLAnalyzer()) ) {
											alt79=1;
										}
									}
									switch (alt79) {
										case 1 :
											// parser\\sql\\SQLAnalyzer.g:372:13: RPAREN
											{
											match(input,RPAREN,FOLLOW_RPAREN_in_predicate1988); if (state.failed) return;
											}
											break;

									}

									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:373:9: EXISTS LPAREN s= selectStatement RPAREN
					{
					match(input,EXISTS,FOLLOW_EXISTS_in_predicate2004); if (state.failed) return;
					match(input,LPAREN,FOLLOW_LPAREN_in_predicate2006); if (state.failed) return;
					pushFollow(FOLLOW_selectStatement_in_predicate2012);
					selectStatement();
					state._fsp--;
					if (state.failed) return;
					match(input,RPAREN,FOLLOW_RPAREN_in_predicate2014); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:374:9: function
					{
					pushFollow(FOLLOW_function_in_predicate2025);
					function();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:375:9: startClause
					{
					pushFollow(FOLLOW_startClause_in_predicate2035);
					startClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 31, predicate_StartIndex); }

		}
	}
	// $ANTLR end "predicate"



	// $ANTLR start "quantifierSpec"
	// parser\\sql\\SQLAnalyzer.g:378:1: quantifierSpec : ( ALL | SOME | ANY );
	public final void quantifierSpec() throws RecognitionException {
		int quantifierSpec_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:378:17: ( ALL | SOME | ANY )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)==ALL||input.LA(1)==ANY||input.LA(1)==SOME ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 32, quantifierSpec_StartIndex); }

		}
	}
	// $ANTLR end "quantifierSpec"



	// $ANTLR start "selectList"
	// parser\\sql\\SQLAnalyzer.g:384:1: selectList : s= selectItem ( COMMA t= selectItem )* ;
	public final void selectList() throws RecognitionException {
		int selectList_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:384:13: (s= selectItem ( COMMA t= selectItem )* )
			// parser\\sql\\SQLAnalyzer.g:385:3: s= selectItem ( COMMA t= selectItem )*
			{
			pushFollow(FOLLOW_selectItem_in_selectList2082);
			selectItem();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:386:5: ( COMMA t= selectItem )*
			loop83:
			while (true) {
				int alt83=2;
				alt83 = dfa83.predict(input);
				switch (alt83) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:386:7: COMMA t= selectItem
					{
					match(input,COMMA,FOLLOW_COMMA_in_selectList2091); if (state.failed) return;
					pushFollow(FOLLOW_selectItem_in_selectList2097);
					selectItem();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop83;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 33, selectList_StartIndex); }

		}
	}
	// $ANTLR end "selectList"



	// $ANTLR start "selectItem"
	// parser\\sql\\SQLAnalyzer.g:389:1: selectItem : ( STAR | dbObject DOT_STAR | ( ( alias2 )=> (a= alias2 e= expression ) | ( tableColumns )=>t= tableColumns |id= expression ( db2Element )? (a= alias1 )? ) );
	public final void selectItem() throws RecognitionException {
		int selectItem_StartIndex = input.index();

		ParserRuleReturnScope a =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:389:13: ( STAR | dbObject DOT_STAR | ( ( alias2 )=> (a= alias2 e= expression ) | ( tableColumns )=>t= tableColumns |id= expression ( db2Element )? (a= alias1 )? ) )
			int alt87=3;
			switch ( input.LA(1) ) {
			case STAR:
				{
				alt87=1;
				}
				break;
			case NonQuotedIdentifier:
				{
				int LA87_2 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case QuotedIdentifier:
				{
				int LA87_3 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case DESC:
				{
				int LA87_4 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case ORDER:
				{
				int LA87_5 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case GROUP:
				{
				int LA87_6 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case MAX:
				{
				int LA87_7 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case SUM:
				{
				int LA87_8 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case AVG:
				{
				int LA87_9 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case MIN:
				{
				int LA87_10 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case NVL:
				{
				int LA87_11 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case DATE:
				{
				int LA87_12 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case TIME:
				{
				int LA87_13 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case TIMESTAMP:
				{
				int LA87_14 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case MONTH:
				{
				int LA87_15 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case INT:
				{
				int LA87_16 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case VALUE:
				{
				int LA87_17 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case OVER:
				{
				int LA87_18 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case ROW:
				{
				int LA87_19 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case DENSE:
				{
				int LA87_20 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case RANK:
				{
				int LA87_21 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case DECODE:
				{
				int LA87_22 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case YEAR:
				{
				int LA87_23 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case CURRENT:
				{
				int LA87_24 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case UPDATE:
				{
				int LA87_25 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case SYSDATE:
				{
				int LA87_26 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case YEARS:
				{
				int LA87_27 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case DAY:
			case HOUR:
			case MINUTE:
			case SECOND:
				{
				int LA87_28 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case CURRENT_DATE:
				{
				int LA87_29 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case CURRENT_TIME:
				{
				int LA87_30 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case CURRENT_TIMESTAMP:
				{
				int LA87_31 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case NEXT:
				{
				int LA87_32 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case INTERVAL:
				{
				int LA87_33 = input.LA(2);
				if ( (synpred102_SQLAnalyzer()) ) {
					alt87=2;
				}
				else if ( (true) ) {
					alt87=3;
				}

				}
				break;
			case AsciiStringLiteral:
			case CASE:
			case CAST:
			case DASH:
			case EXTRACT:
			case HexLiteral:
			case Integer:
			case Iso8601DateTime:
			case LEFT:
			case LPAREN:
			case MAccessDateTime:
			case NULL:
			case PLACEHOLDER:
			case PLUS:
			case RIGHT:
			case Real:
			case SUBSTRING:
			case UicodeValueLiteral:
			case UnicodeStringLiteral:
			case Variable:
				{
				alt87=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 87, 0, input);
				throw nvae;
			}
			switch (alt87) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:390:4: STAR
					{
					match(input,STAR,FOLLOW_STAR_in_selectItem2115); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:391:5: dbObject DOT_STAR
					{
					pushFollow(FOLLOW_dbObject_in_selectItem2121);
					dbObject();
					state._fsp--;
					if (state.failed) return;
					match(input,DOT_STAR,FOLLOW_DOT_STAR_in_selectItem2123); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:392:5: ( ( alias2 )=> (a= alias2 e= expression ) | ( tableColumns )=>t= tableColumns |id= expression ( db2Element )? (a= alias1 )? )
					{
					// parser\\sql\\SQLAnalyzer.g:392:5: ( ( alias2 )=> (a= alias2 e= expression ) | ( tableColumns )=>t= tableColumns |id= expression ( db2Element )? (a= alias1 )? )
					int alt86=3;
					switch ( input.LA(1) ) {
					case NonQuotedIdentifier:
						{
						int LA86_1 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case QuotedIdentifier:
						{
						int LA86_2 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case DESC:
						{
						int LA86_3 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case ORDER:
						{
						int LA86_4 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case GROUP:
						{
						int LA86_5 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case MAX:
						{
						int LA86_6 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case SUM:
						{
						int LA86_7 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case AVG:
						{
						int LA86_8 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case MIN:
						{
						int LA86_9 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case NVL:
						{
						int LA86_10 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case DATE:
						{
						int LA86_11 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case TIME:
						{
						int LA86_12 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case TIMESTAMP:
						{
						int LA86_13 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case MONTH:
						{
						int LA86_14 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case INT:
						{
						int LA86_15 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case VALUE:
						{
						int LA86_16 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case OVER:
						{
						int LA86_17 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case ROW:
						{
						int LA86_18 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case DENSE:
						{
						int LA86_19 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case RANK:
						{
						int LA86_20 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case DECODE:
						{
						int LA86_21 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case YEAR:
						{
						int LA86_22 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case CURRENT:
						{
						int LA86_23 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case UPDATE:
						{
						int LA86_24 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case SYSDATE:
						{
						int LA86_25 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case YEARS:
						{
						int LA86_26 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case DAY:
					case HOUR:
					case MINUTE:
					case SECOND:
						{
						int LA86_27 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case CURRENT_DATE:
						{
						int LA86_28 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case CURRENT_TIME:
						{
						int LA86_29 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case CURRENT_TIMESTAMP:
						{
						int LA86_30 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case NEXT:
						{
						int LA86_31 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case INTERVAL:
						{
						int LA86_32 = input.LA(2);
						if ( (synpred103_SQLAnalyzer()) ) {
							alt86=1;
						}
						else if ( (synpred104_SQLAnalyzer()) ) {
							alt86=2;
						}
						else if ( (true) ) {
							alt86=3;
						}

						}
						break;
					case AsciiStringLiteral:
					case CASE:
					case CAST:
					case DASH:
					case EXTRACT:
					case HexLiteral:
					case Integer:
					case Iso8601DateTime:
					case LEFT:
					case LPAREN:
					case MAccessDateTime:
					case NULL:
					case PLACEHOLDER:
					case PLUS:
					case RIGHT:
					case Real:
					case SUBSTRING:
					case UicodeValueLiteral:
					case UnicodeStringLiteral:
					case Variable:
						{
						alt86=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 86, 0, input);
						throw nvae;
					}
					switch (alt86) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:393:5: ( alias2 )=> (a= alias2 e= expression )
							{
							// parser\\sql\\SQLAnalyzer.g:393:17: (a= alias2 e= expression )
							// parser\\sql\\SQLAnalyzer.g:394:7: a= alias2 e= expression
							{
							pushFollow(FOLLOW_alias2_in_selectItem2156);
							alias2();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_expression_in_selectItem2162);
							expression();
							state._fsp--;
							if (state.failed) return;
							}

							}
							break;
						case 2 :
							// parser\\sql\\SQLAnalyzer.g:396:7: ( tableColumns )=>t= tableColumns
							{
							pushFollow(FOLLOW_tableColumns_in_selectItem2187);
							tableColumns();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 3 :
							// parser\\sql\\SQLAnalyzer.g:397:7: id= expression ( db2Element )? (a= alias1 )?
							{
							pushFollow(FOLLOW_expression_in_selectItem2200);
							expression();
							state._fsp--;
							if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:397:23: ( db2Element )?
							int alt84=2;
							switch ( input.LA(1) ) {
								case CURRENT:
									{
									int LA84_1 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case UPDATE:
									{
									int LA84_2 = input.LA(2);
									if ( (LA84_2==DATE||(LA84_2 >= TIME && LA84_2 <= TIMESTAMP)) ) {
										int LA84_15 = input.LA(3);
										if ( (synpred105_SQLAnalyzer()) ) {
											alt84=1;
										}
									}
									}
									break;
								case TIMESTAMP:
									{
									int LA84_3 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case SYSDATE:
									{
									int LA84_4 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case DATE:
									{
									int LA84_5 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case INT:
									{
									int LA84_6 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case YEARS:
									{
									int LA84_7 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case YEAR:
									{
									int LA84_8 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case CURRENT_DATE:
									{
									int LA84_9 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case CURRENT_TIME:
									{
									int LA84_10 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case CURRENT_TIMESTAMP:
									{
									int LA84_11 = input.LA(2);
									if ( (synpred105_SQLAnalyzer()) ) {
										alt84=1;
									}
									}
									break;
								case NEXT:
									{
									int LA84_12 = input.LA(2);
									if ( (LA84_12==VALUE) ) {
										int LA84_16 = input.LA(3);
										if ( (LA84_16==FOR) ) {
											int LA84_17 = input.LA(4);
											if ( (synpred105_SQLAnalyzer()) ) {
												alt84=1;
											}
										}
									}
									}
									break;
							}
							switch (alt84) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:397:25: db2Element
									{
									pushFollow(FOLLOW_db2Element_in_selectItem2204);
									db2Element();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							// parser\\sql\\SQLAnalyzer.g:397:39: (a= alias1 )?
							int alt85=2;
							switch ( input.LA(1) ) {
								case AS:
									{
									alt85=1;
									}
									break;
								case NonQuotedIdentifier:
									{
									int LA85_2 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case QuotedIdentifier:
									{
									int LA85_3 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case DESC:
									{
									int LA85_4 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case ORDER:
									{
									int LA85_5 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case GROUP:
									{
									int LA85_6 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case MAX:
									{
									int LA85_7 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case SUM:
									{
									int LA85_8 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case AVG:
									{
									int LA85_9 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case MIN:
									{
									int LA85_10 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case NVL:
									{
									int LA85_11 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case DATE:
									{
									int LA85_12 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case TIME:
									{
									int LA85_13 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case TIMESTAMP:
									{
									int LA85_14 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case MONTH:
									{
									int LA85_15 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case INT:
									{
									int LA85_16 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case VALUE:
									{
									int LA85_17 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case OVER:
									{
									int LA85_18 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case ROW:
									{
									int LA85_19 = input.LA(2);
									if ( (LA85_19==UNDERSCOPE) ) {
										int LA85_35 = input.LA(3);
										if ( (LA85_35==NUMBER) ) {
											int LA85_39 = input.LA(4);
											if ( (synpred106_SQLAnalyzer()) ) {
												alt85=1;
											}
										}
									}
									}
									break;
								case DENSE:
									{
									int LA85_20 = input.LA(2);
									if ( (LA85_20==UNDERSCOPE) ) {
										int LA85_36 = input.LA(3);
										if ( (LA85_36==RANK) ) {
											int LA85_40 = input.LA(4);
											if ( (synpred106_SQLAnalyzer()) ) {
												alt85=1;
											}
										}
									}
									}
									break;
								case RANK:
									{
									int LA85_21 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case DECODE:
									{
									int LA85_22 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case YEAR:
									{
									int LA85_23 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case CURRENT:
									{
									int LA85_24 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case UPDATE:
									{
									int LA85_25 = input.LA(2);
									if ( (LA85_25==DATE||(LA85_25 >= TIME && LA85_25 <= TIMESTAMP)) ) {
										int LA85_37 = input.LA(3);
										if ( (synpred106_SQLAnalyzer()) ) {
											alt85=1;
										}
									}
									}
									break;
								case SYSDATE:
									{
									int LA85_26 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case YEARS:
									{
									int LA85_27 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case DAY:
								case HOUR:
								case MINUTE:
								case SECOND:
									{
									int LA85_28 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case CURRENT_DATE:
									{
									int LA85_29 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case CURRENT_TIME:
									{
									int LA85_30 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case CURRENT_TIMESTAMP:
									{
									int LA85_31 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
								case NEXT:
									{
									int LA85_32 = input.LA(2);
									if ( (LA85_32==VALUE) ) {
										int LA85_38 = input.LA(3);
										if ( (LA85_38==FOR) ) {
											int LA85_41 = input.LA(4);
											if ( (synpred106_SQLAnalyzer()) ) {
												alt85=1;
											}
										}
									}
									}
									break;
								case INTERVAL:
									{
									int LA85_33 = input.LA(2);
									if ( (synpred106_SQLAnalyzer()) ) {
										alt85=1;
									}
									}
									break;
							}
							switch (alt85) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:397:40: a= alias1
									{
									pushFollow(FOLLOW_alias1_in_selectItem2214);
									a=alias1();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							}
							break;

					}

					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 34, selectItem_StartIndex); }

		}
	}
	// $ANTLR end "selectItem"



	// $ANTLR start "fromClause"
	// parser\\sql\\SQLAnalyzer.g:401:1: fromClause : FROM ( TABLE )? tableSource ( COMMA t= tableSource )* ;
	public final void fromClause() throws RecognitionException {
		int fromClause_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:401:13: ( FROM ( TABLE )? tableSource ( COMMA t= tableSource )* )
			// parser\\sql\\SQLAnalyzer.g:402:3: FROM ( TABLE )? tableSource ( COMMA t= tableSource )*
			{
			match(input,FROM,FOLLOW_FROM_in_fromClause2236); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:402:8: ( TABLE )?
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==TABLE) ) {
				alt88=1;
			}
			switch (alt88) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:402:10: TABLE
					{
					match(input,TABLE,FOLLOW_TABLE_in_fromClause2240); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_tableSource_in_fromClause2245);
			tableSource();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:403:3: ( COMMA t= tableSource )*
			loop89:
			while (true) {
				int alt89=2;
				int LA89_0 = input.LA(1);
				if ( (LA89_0==COMMA) ) {
					int LA89_2 = input.LA(2);
					if ( (synpred108_SQLAnalyzer()) ) {
						alt89=1;
					}

				}

				switch (alt89) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:403:5: COMMA t= tableSource
					{
					match(input,COMMA,FOLLOW_COMMA_in_fromClause2252); if (state.failed) return;
					pushFollow(FOLLOW_tableSource_in_fromClause2258);
					tableSource();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop89;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 35, fromClause_StartIndex); }

		}
	}
	// $ANTLR end "fromClause"



	// $ANTLR start "tableSource"
	// parser\\sql\\SQLAnalyzer.g:406:1: tableSource : t= subTableSource (t= joinedTable )* ;
	public final void tableSource() throws RecognitionException {
		int tableSource_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:406:14: (t= subTableSource (t= joinedTable )* )
			// parser\\sql\\SQLAnalyzer.g:407:3: t= subTableSource (t= joinedTable )*
			{
			pushFollow(FOLLOW_subTableSource_in_tableSource2279);
			subTableSource();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:408:3: (t= joinedTable )*
			loop90:
			while (true) {
				int alt90=2;
				switch ( input.LA(1) ) {
				case CROSS:
					{
					int LA90_2 = input.LA(2);
					if ( (synpred109_SQLAnalyzer()) ) {
						alt90=1;
					}

					}
					break;
				case INNER:
					{
					int LA90_3 = input.LA(2);
					if ( (synpred109_SQLAnalyzer()) ) {
						alt90=1;
					}

					}
					break;
				case LEFT:
					{
					int LA90_4 = input.LA(2);
					if ( (synpred109_SQLAnalyzer()) ) {
						alt90=1;
					}

					}
					break;
				case JOIN:
					{
					int LA90_5 = input.LA(2);
					if ( (synpred109_SQLAnalyzer()) ) {
						alt90=1;
					}

					}
					break;
				case RIGHT:
					{
					int LA90_6 = input.LA(2);
					if ( (synpred109_SQLAnalyzer()) ) {
						alt90=1;
					}

					}
					break;
				case FULL:
					{
					int LA90_7 = input.LA(2);
					if ( (synpred109_SQLAnalyzer()) ) {
						alt90=1;
					}

					}
					break;
				}
				switch (alt90) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:408:5: t= joinedTable
					{
					pushFollow(FOLLOW_joinedTable_in_tableSource2290);
					joinedTable();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop90;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 36, tableSource_StartIndex); }

		}
	}
	// $ANTLR end "tableSource"



	// $ANTLR start "subTableSource"
	// parser\\sql\\SQLAnalyzer.g:411:1: subTableSource : ( LPAREN ( ( joinedTables )=>t= joinedTables RPAREN |q= queryExpression RPAREN (al= alias1 )? ) |f= function (a= alias1 )? | LPAREN VALUES constant RPAREN (al= alias1 ) |ta= dbObject (al= alias1 )? );
	public final void subTableSource() throws RecognitionException {
		int subTableSource_StartIndex = input.index();

		ParserRuleReturnScope al =null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope ta =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:411:17: ( LPAREN ( ( joinedTables )=>t= joinedTables RPAREN |q= queryExpression RPAREN (al= alias1 )? ) |f= function (a= alias1 )? | LPAREN VALUES constant RPAREN (al= alias1 ) |ta= dbObject (al= alias1 )? )
			int alt95=4;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				int LA95_1 = input.LA(2);
				if ( (synpred112_SQLAnalyzer()) ) {
					alt95=1;
				}
				else if ( (synpred114_SQLAnalyzer()) ) {
					alt95=2;
				}
				else if ( (synpred115_SQLAnalyzer()) ) {
					alt95=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 95, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case EXTRACT:
			case LEFT:
			case RIGHT:
			case SUBSTRING:
				{
				alt95=2;
				}
				break;
			case NonQuotedIdentifier:
				{
				int LA95_4 = input.LA(2);
				if ( (synpred114_SQLAnalyzer()) ) {
					alt95=2;
				}
				else if ( (true) ) {
					alt95=4;
				}

				}
				break;
			case AVG:
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATE:
			case DAY:
			case DECODE:
			case DENSE:
			case DESC:
			case GROUP:
			case HOUR:
			case INT:
			case INTERVAL:
			case MAX:
			case MIN:
			case MINUTE:
			case MONTH:
			case NEXT:
			case NVL:
			case ORDER:
			case OVER:
			case QuotedIdentifier:
			case RANK:
			case ROW:
			case SECOND:
			case SUM:
			case SYSDATE:
			case TIME:
			case TIMESTAMP:
			case UPDATE:
			case VALUE:
			case YEAR:
			case YEARS:
				{
				alt95=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 95, 0, input);
				throw nvae;
			}
			switch (alt95) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:412:3: LPAREN ( ( joinedTables )=>t= joinedTables RPAREN |q= queryExpression RPAREN (al= alias1 )? )
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_subTableSource2308); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:412:10: ( ( joinedTables )=>t= joinedTables RPAREN |q= queryExpression RPAREN (al= alias1 )? )
					int alt92=2;
					int LA92_0 = input.LA(1);
					if ( (LA92_0==LPAREN) ) {
						int LA92_1 = input.LA(2);
						if ( (synpred110_SQLAnalyzer()) ) {
							alt92=1;
						}
						else if ( (true) ) {
							alt92=2;
						}

					}
					else if ( (LA92_0==SUBSTRING) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==EXTRACT) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==NonQuotedIdentifier) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==LEFT) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==RIGHT) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==QuotedIdentifier) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==DESC) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==ORDER) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==GROUP) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==MAX) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==SUM) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==AVG) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==MIN) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==NVL) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==DATE) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==TIME) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==TIMESTAMP) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==MONTH) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==INT) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==VALUE) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==OVER) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==ROW) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==DENSE) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==RANK) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==DECODE) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==YEAR) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==CURRENT) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==UPDATE) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==SYSDATE) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==YEARS) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==DAY||LA92_0==HOUR||LA92_0==MINUTE||LA92_0==SECOND) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==CURRENT_DATE) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==CURRENT_TIME) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==CURRENT_TIMESTAMP) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==NEXT) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==INTERVAL) && (synpred110_SQLAnalyzer())) {
						alt92=1;
					}
					else if ( (LA92_0==SELECT) ) {
						alt92=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 92, 0, input);
						throw nvae;
					}

					switch (alt92) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:413:5: ( joinedTables )=>t= joinedTables RPAREN
							{
							pushFollow(FOLLOW_joinedTables_in_subTableSource2332);
							joinedTables();
							state._fsp--;
							if (state.failed) return;
							match(input,RPAREN,FOLLOW_RPAREN_in_subTableSource2334); if (state.failed) return;
							}
							break;
						case 2 :
							// parser\\sql\\SQLAnalyzer.g:415:7: q= queryExpression RPAREN (al= alias1 )?
							{
							pushFollow(FOLLOW_queryExpression_in_subTableSource2347);
							queryExpression();
							state._fsp--;
							if (state.failed) return;
							match(input,RPAREN,FOLLOW_RPAREN_in_subTableSource2349); if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:415:34: (al= alias1 )?
							int alt91=2;
							switch ( input.LA(1) ) {
								case AS:
									{
									alt91=1;
									}
									break;
								case NonQuotedIdentifier:
									{
									int LA91_2 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case QuotedIdentifier:
									{
									int LA91_3 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case DESC:
									{
									int LA91_4 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case ORDER:
									{
									int LA91_5 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case GROUP:
									{
									int LA91_6 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case MAX:
									{
									int LA91_7 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case SUM:
									{
									int LA91_8 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case AVG:
									{
									int LA91_9 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case MIN:
									{
									int LA91_10 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case NVL:
									{
									int LA91_11 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case DATE:
									{
									int LA91_12 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case TIME:
									{
									int LA91_13 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case TIMESTAMP:
									{
									int LA91_14 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case MONTH:
									{
									int LA91_15 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case INT:
									{
									int LA91_16 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case VALUE:
									{
									int LA91_17 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case OVER:
									{
									int LA91_18 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case ROW:
									{
									int LA91_19 = input.LA(2);
									if ( (LA91_19==UNDERSCOPE) ) {
										int LA91_35 = input.LA(3);
										if ( (LA91_35==NUMBER) ) {
											int LA91_39 = input.LA(4);
											if ( (synpred111_SQLAnalyzer()) ) {
												alt91=1;
											}
										}
									}
									}
									break;
								case DENSE:
									{
									int LA91_20 = input.LA(2);
									if ( (LA91_20==UNDERSCOPE) ) {
										int LA91_36 = input.LA(3);
										if ( (LA91_36==RANK) ) {
											int LA91_40 = input.LA(4);
											if ( (synpred111_SQLAnalyzer()) ) {
												alt91=1;
											}
										}
									}
									}
									break;
								case RANK:
									{
									int LA91_21 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case DECODE:
									{
									int LA91_22 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case YEAR:
									{
									int LA91_23 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case CURRENT:
									{
									int LA91_24 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case UPDATE:
									{
									int LA91_25 = input.LA(2);
									if ( (LA91_25==DATE||(LA91_25 >= TIME && LA91_25 <= TIMESTAMP)) ) {
										int LA91_37 = input.LA(3);
										if ( (synpred111_SQLAnalyzer()) ) {
											alt91=1;
										}
									}
									}
									break;
								case SYSDATE:
									{
									int LA91_26 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case YEARS:
									{
									int LA91_27 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case DAY:
								case HOUR:
								case MINUTE:
								case SECOND:
									{
									int LA91_28 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case CURRENT_DATE:
									{
									int LA91_29 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case CURRENT_TIME:
									{
									int LA91_30 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case CURRENT_TIMESTAMP:
									{
									int LA91_31 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
								case NEXT:
									{
									int LA91_32 = input.LA(2);
									if ( (LA91_32==VALUE) ) {
										int LA91_38 = input.LA(3);
										if ( (LA91_38==FOR) ) {
											int LA91_41 = input.LA(4);
											if ( (synpred111_SQLAnalyzer()) ) {
												alt91=1;
											}
										}
									}
									}
									break;
								case INTERVAL:
									{
									int LA91_33 = input.LA(2);
									if ( (synpred111_SQLAnalyzer()) ) {
										alt91=1;
									}
									}
									break;
							}
							switch (alt91) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:415:35: al= alias1
									{
									pushFollow(FOLLOW_alias1_in_subTableSource2356);
									al=alias1();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:417:6: f= function (a= alias1 )?
					{
					pushFollow(FOLLOW_function_in_subTableSource2380);
					function();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:417:19: (a= alias1 )?
					int alt93=2;
					switch ( input.LA(1) ) {
						case AS:
							{
							alt93=1;
							}
							break;
						case NonQuotedIdentifier:
							{
							int LA93_2 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case QuotedIdentifier:
							{
							int LA93_3 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case DESC:
							{
							int LA93_4 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case ORDER:
							{
							int LA93_5 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case GROUP:
							{
							int LA93_6 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case MAX:
							{
							int LA93_7 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case SUM:
							{
							int LA93_8 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case AVG:
							{
							int LA93_9 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case MIN:
							{
							int LA93_10 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case NVL:
							{
							int LA93_11 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case DATE:
							{
							int LA93_12 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case TIME:
							{
							int LA93_13 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case TIMESTAMP:
							{
							int LA93_14 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case MONTH:
							{
							int LA93_15 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case INT:
							{
							int LA93_16 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case VALUE:
							{
							int LA93_17 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case OVER:
							{
							int LA93_18 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case ROW:
							{
							int LA93_19 = input.LA(2);
							if ( (LA93_19==UNDERSCOPE) ) {
								int LA93_35 = input.LA(3);
								if ( (LA93_35==NUMBER) ) {
									int LA93_39 = input.LA(4);
									if ( (synpred113_SQLAnalyzer()) ) {
										alt93=1;
									}
								}
							}
							}
							break;
						case DENSE:
							{
							int LA93_20 = input.LA(2);
							if ( (LA93_20==UNDERSCOPE) ) {
								int LA93_36 = input.LA(3);
								if ( (LA93_36==RANK) ) {
									int LA93_40 = input.LA(4);
									if ( (synpred113_SQLAnalyzer()) ) {
										alt93=1;
									}
								}
							}
							}
							break;
						case RANK:
							{
							int LA93_21 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case DECODE:
							{
							int LA93_22 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case YEAR:
							{
							int LA93_23 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case CURRENT:
							{
							int LA93_24 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case UPDATE:
							{
							int LA93_25 = input.LA(2);
							if ( (LA93_25==DATE||(LA93_25 >= TIME && LA93_25 <= TIMESTAMP)) ) {
								int LA93_37 = input.LA(3);
								if ( (synpred113_SQLAnalyzer()) ) {
									alt93=1;
								}
							}
							}
							break;
						case SYSDATE:
							{
							int LA93_26 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case YEARS:
							{
							int LA93_27 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case DAY:
						case HOUR:
						case MINUTE:
						case SECOND:
							{
							int LA93_28 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case CURRENT_DATE:
							{
							int LA93_29 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case CURRENT_TIME:
							{
							int LA93_30 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case CURRENT_TIMESTAMP:
							{
							int LA93_31 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
						case NEXT:
							{
							int LA93_32 = input.LA(2);
							if ( (LA93_32==VALUE) ) {
								int LA93_38 = input.LA(3);
								if ( (LA93_38==FOR) ) {
									int LA93_41 = input.LA(4);
									if ( (synpred113_SQLAnalyzer()) ) {
										alt93=1;
									}
								}
							}
							}
							break;
						case INTERVAL:
							{
							int LA93_33 = input.LA(2);
							if ( (synpred113_SQLAnalyzer()) ) {
								alt93=1;
							}
							}
							break;
					}
					switch (alt93) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:417:21: a= alias1
							{
							pushFollow(FOLLOW_alias1_in_subTableSource2388);
							a=alias1();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:418:5: LPAREN VALUES constant RPAREN (al= alias1 )
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_subTableSource2398); if (state.failed) return;
					match(input,VALUES,FOLLOW_VALUES_in_subTableSource2400); if (state.failed) return;
					pushFollow(FOLLOW_constant_in_subTableSource2402);
					constant();
					state._fsp--;
					if (state.failed) return;
					match(input,RPAREN,FOLLOW_RPAREN_in_subTableSource2404); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:418:35: (al= alias1 )
					// parser\\sql\\SQLAnalyzer.g:418:36: al= alias1
					{
					pushFollow(FOLLOW_alias1_in_subTableSource2411);
					al=alias1();
					state._fsp--;
					if (state.failed) return;
					}

					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:419:5: ta= dbObject (al= alias1 )?
					{
					pushFollow(FOLLOW_dbObject_in_subTableSource2423);
					ta=dbObject();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:419:20: (al= alias1 )?
					int alt94=2;
					switch ( input.LA(1) ) {
						case AS:
							{
							alt94=1;
							}
							break;
						case NonQuotedIdentifier:
							{
							int LA94_2 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case QuotedIdentifier:
							{
							int LA94_3 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case DESC:
							{
							int LA94_4 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case ORDER:
							{
							int LA94_5 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case GROUP:
							{
							int LA94_6 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case MAX:
							{
							int LA94_7 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case SUM:
							{
							int LA94_8 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case AVG:
							{
							int LA94_9 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case MIN:
							{
							int LA94_10 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case NVL:
							{
							int LA94_11 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case DATE:
							{
							int LA94_12 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case TIME:
							{
							int LA94_13 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case TIMESTAMP:
							{
							int LA94_14 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case MONTH:
							{
							int LA94_15 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case INT:
							{
							int LA94_16 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case VALUE:
							{
							int LA94_17 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case OVER:
							{
							int LA94_18 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case ROW:
							{
							int LA94_19 = input.LA(2);
							if ( (LA94_19==UNDERSCOPE) ) {
								int LA94_35 = input.LA(3);
								if ( (LA94_35==NUMBER) ) {
									int LA94_39 = input.LA(4);
									if ( (synpred116_SQLAnalyzer()) ) {
										alt94=1;
									}
								}
							}
							}
							break;
						case DENSE:
							{
							int LA94_20 = input.LA(2);
							if ( (LA94_20==UNDERSCOPE) ) {
								int LA94_36 = input.LA(3);
								if ( (LA94_36==RANK) ) {
									int LA94_40 = input.LA(4);
									if ( (synpred116_SQLAnalyzer()) ) {
										alt94=1;
									}
								}
							}
							}
							break;
						case RANK:
							{
							int LA94_21 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case DECODE:
							{
							int LA94_22 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case YEAR:
							{
							int LA94_23 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case CURRENT:
							{
							int LA94_24 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case UPDATE:
							{
							int LA94_25 = input.LA(2);
							if ( (LA94_25==DATE||(LA94_25 >= TIME && LA94_25 <= TIMESTAMP)) ) {
								int LA94_37 = input.LA(3);
								if ( (synpred116_SQLAnalyzer()) ) {
									alt94=1;
								}
							}
							}
							break;
						case SYSDATE:
							{
							int LA94_26 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case YEARS:
							{
							int LA94_27 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case DAY:
						case HOUR:
						case MINUTE:
						case SECOND:
							{
							int LA94_28 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case CURRENT_DATE:
							{
							int LA94_29 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case CURRENT_TIME:
							{
							int LA94_30 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case CURRENT_TIMESTAMP:
							{
							int LA94_31 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
						case NEXT:
							{
							int LA94_32 = input.LA(2);
							if ( (LA94_32==VALUE) ) {
								int LA94_38 = input.LA(3);
								if ( (LA94_38==FOR) ) {
									int LA94_41 = input.LA(4);
									if ( (synpred116_SQLAnalyzer()) ) {
										alt94=1;
									}
								}
							}
							}
							break;
						case INTERVAL:
							{
							int LA94_33 = input.LA(2);
							if ( (synpred116_SQLAnalyzer()) ) {
								alt94=1;
							}
							}
							break;
					}
					switch (alt94) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:419:22: al= alias1
							{
							pushFollow(FOLLOW_alias1_in_subTableSource2431);
							al=alias1();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					if ( state.backtracking==0 ) {
					  // select, DELETE, UPDATE table add
					      // not null, not dual, not exist
					//      if(((ta!=null?input.toString(ta.start,ta.stop):null)) != null && !(("dual").equalsIgnoreCase((ta!=null?input.toString(ta.start,ta.stop):null)))
					//        &&("")){
					        if(((ta!=null?input.toString(ta.start,ta.stop):null)) != null && !(("dual").equalsIgnoreCase((ta!=null?input.toString(ta.start,ta.stop):null)))
					          && !((db2DummyTableNameOne).equalsIgnoreCase((ta!=null?input.toString(ta.start,ta.stop):null)))
					          && !((db2DummyTableNameTwo).equalsIgnoreCase((ta!=null?input.toString(ta.start,ta.stop):null)))
					           && !((db2DummyTableNameThree).equalsIgnoreCase((ta!=null?input.toString(ta.start,ta.stop):null)))){
					        String tableName = (ta!=null?input.toString(ta.start,ta.stop):null);
					        String alias = (al!=null?input.toString(al.start,al.stop):null);
					        
					        // erase DB LINK
					        if(tableName.contains("@")){
					            String [] splitTableName = tableName.split("@");
					            tableName = splitTableName[0];
					        } 

					        // alias Í∞?null???ÑÎãàÎ©?aliasList??add
					        if(alias != null){
					          aliasTableList.add(alias);
					        } 

					        // ??¨∏?êÎ°ú Î≥?ôò
					        tableName = tableName.toUpperCase();
					        // alias Table??Ï°¥Ïû¨?òÏ? ?äÎäî??
					        if(!aliasTableList.contains(tableName)) {
					          // type??select?¥Îã§.
					          if(getStatementType().equals("02")){
					            // Ï§ëÎ≥µ ?òÎäî ?åÏù¥Î∏îÏù¥ ?ÜÎã§.
					            if(!selectTableList.contains(tableName)){
					              selectTableList.add(tableName);
					            } else {/* DO NOTHING */}
					          } else {
					            // selectÍ∞??ÑÎãàÍ≥?Ï§ëÎ≥µ ?òÎäî ?åÏù¥Î∏îÏù¥ ?ÜÎã§.
					            if(!tableList.contains(tableName)){
					              tableList.add(tableName);
					            } else { /* DO NOTHING */ }
					         }
					        } else {/* DO NOTHING */} 
					        
					      }// end if 
					     }
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 37, subTableSource_StartIndex); }

		}
	}
	// $ANTLR end "subTableSource"



	// $ANTLR start "joinOn"
	// parser\\sql\\SQLAnalyzer.g:465:1: joinOn : ( INNER | ( LEFT | RIGHT | FULL ) ( OUTER )? )? JOIN ( TABLE )? ;
	public final void joinOn() throws RecognitionException {
		int joinOn_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:465:8: ( ( INNER | ( LEFT | RIGHT | FULL ) ( OUTER )? )? JOIN ( TABLE )? )
			// parser\\sql\\SQLAnalyzer.g:466:3: ( INNER | ( LEFT | RIGHT | FULL ) ( OUTER )? )? JOIN ( TABLE )?
			{
			// parser\\sql\\SQLAnalyzer.g:466:3: ( INNER | ( LEFT | RIGHT | FULL ) ( OUTER )? )?
			int alt97=3;
			int LA97_0 = input.LA(1);
			if ( (LA97_0==INNER) ) {
				alt97=1;
			}
			else if ( (LA97_0==FULL||LA97_0==LEFT||LA97_0==RIGHT) ) {
				alt97=2;
			}
			switch (alt97) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:466:5: INNER
					{
					match(input,INNER,FOLLOW_INNER_in_joinOn2454); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:467:5: ( LEFT | RIGHT | FULL ) ( OUTER )?
					{
					if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// parser\\sql\\SQLAnalyzer.g:470:5: ( OUTER )?
					int alt96=2;
					int LA96_0 = input.LA(1);
					if ( (LA96_0==OUTER) ) {
						alt96=1;
					}
					switch (alt96) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:470:7: OUTER
							{
							match(input,OUTER,FOLLOW_OUTER_in_joinOn2490); if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			match(input,JOIN,FOLLOW_JOIN_in_joinOn2501); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:471:11: ( TABLE )?
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==TABLE) ) {
				alt98=1;
			}
			switch (alt98) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:471:13: TABLE
					{
					match(input,TABLE,FOLLOW_TABLE_in_joinOn2505); if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 38, joinOn_StartIndex); }

		}
	}
	// $ANTLR end "joinOn"



	// $ANTLR start "joinedTable"
	// parser\\sql\\SQLAnalyzer.g:474:1: joinedTable : ( CROSS JOIN t= subTableSource | (j= joinOn t= tableSource ON c= searchCondition ) );
	public final void joinedTable() throws RecognitionException {
		int joinedTable_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:474:13: ( CROSS JOIN t= subTableSource | (j= joinOn t= tableSource ON c= searchCondition ) )
			int alt99=2;
			int LA99_0 = input.LA(1);
			if ( (LA99_0==CROSS) ) {
				alt99=1;
			}
			else if ( (LA99_0==FULL||LA99_0==INNER||LA99_0==JOIN||LA99_0==LEFT||LA99_0==RIGHT) ) {
				alt99=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 99, 0, input);
				throw nvae;
			}

			switch (alt99) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:475:3: CROSS JOIN t= subTableSource
					{
					match(input,CROSS,FOLLOW_CROSS_in_joinedTable2521); if (state.failed) return;
					match(input,JOIN,FOLLOW_JOIN_in_joinedTable2523); if (state.failed) return;
					pushFollow(FOLLOW_subTableSource_in_joinedTable2529);
					subTableSource();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:476:5: (j= joinOn t= tableSource ON c= searchCondition )
					{
					// parser\\sql\\SQLAnalyzer.g:476:5: (j= joinOn t= tableSource ON c= searchCondition )
					// parser\\sql\\SQLAnalyzer.g:477:5: j= joinOn t= tableSource ON c= searchCondition
					{
					pushFollow(FOLLOW_joinOn_in_joinedTable2546);
					joinOn();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_tableSource_in_joinedTable2558);
					tableSource();
					state._fsp--;
					if (state.failed) return;
					match(input,ON,FOLLOW_ON_in_joinedTable2567); if (state.failed) return;
					pushFollow(FOLLOW_searchCondition_in_joinedTable2573);
					searchCondition();
					state._fsp--;
					if (state.failed) return;
					}

					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 39, joinedTable_StartIndex); }

		}
	}
	// $ANTLR end "joinedTable"



	// $ANTLR start "joinedTables"
	// parser\\sql\\SQLAnalyzer.g:483:1: joinedTables : t= subTableSource (t= joinedTable )+ ;
	public final void joinedTables() throws RecognitionException {
		int joinedTables_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:483:14: (t= subTableSource (t= joinedTable )+ )
			// parser\\sql\\SQLAnalyzer.g:484:3: t= subTableSource (t= joinedTable )+
			{
			pushFollow(FOLLOW_subTableSource_in_joinedTables2597);
			subTableSource();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:485:5: (t= joinedTable )+
			int cnt100=0;
			loop100:
			while (true) {
				int alt100=2;
				int LA100_0 = input.LA(1);
				if ( (LA100_0==CROSS||LA100_0==FULL||LA100_0==INNER||LA100_0==JOIN||LA100_0==LEFT||LA100_0==RIGHT) ) {
					alt100=1;
				}

				switch (alt100) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:485:7: t= joinedTable
					{
					pushFollow(FOLLOW_joinedTable_in_joinedTables2610);
					joinedTable();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt100 >= 1 ) break loop100;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(100, input);
					throw eee;
				}
				cnt100++;
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 40, joinedTables_StartIndex); }

		}
	}
	// $ANTLR end "joinedTables"


	public static class alias1_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "alias1"
	// parser\\sql\\SQLAnalyzer.g:490:1: alias1 : ( AS )? i= identifier ( AS )? ;
	public final SQLAnalyzerParser.alias1_return alias1() throws RecognitionException {
		SQLAnalyzerParser.alias1_return retval = new SQLAnalyzerParser.alias1_return();
		retval.start = input.LT(1);
		int alias1_StartIndex = input.index();

		ParserRuleReturnScope i =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }

			// parser\\sql\\SQLAnalyzer.g:490:9: ( ( AS )? i= identifier ( AS )? )
			// parser\\sql\\SQLAnalyzer.g:491:3: ( AS )? i= identifier ( AS )?
			{
			// parser\\sql\\SQLAnalyzer.g:491:3: ( AS )?
			int alt101=2;
			int LA101_0 = input.LA(1);
			if ( (LA101_0==AS) ) {
				alt101=1;
			}
			switch (alt101) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:491:4: AS
					{
					match(input,AS,FOLLOW_AS_in_alias12630); if (state.failed) return retval;
					}
					break;

			}

			pushFollow(FOLLOW_identifier_in_alias12638);
			i=identifier();
			state._fsp--;
			if (state.failed) return retval;
			// parser\\sql\\SQLAnalyzer.g:491:24: ( AS )?
			int alt102=2;
			int LA102_0 = input.LA(1);
			if ( (LA102_0==AS) ) {
				int LA102_1 = input.LA(2);
				if ( (synpred126_SQLAnalyzer()) ) {
					alt102=1;
				}
			}
			switch (alt102) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:491:25: AS
					{
					match(input,AS,FOLLOW_AS_in_alias12641); if (state.failed) return retval;
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 41, alias1_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "alias1"



	// $ANTLR start "alias2"
	// parser\\sql\\SQLAnalyzer.g:494:1: alias2 : i= identifier ASSIGNEQUAL ;
	public final void alias2() throws RecognitionException {
		int alias2_StartIndex = input.index();

		ParserRuleReturnScope i =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:494:9: (i= identifier ASSIGNEQUAL )
			// parser\\sql\\SQLAnalyzer.g:495:3: i= identifier ASSIGNEQUAL
			{
			pushFollow(FOLLOW_identifier_in_alias22661);
			i=identifier();
			state._fsp--;
			if (state.failed) return;
			match(input,ASSIGNEQUAL,FOLLOW_ASSIGNEQUAL_in_alias22666); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 42, alias2_StartIndex); }

		}
	}
	// $ANTLR end "alias2"



	// $ANTLR start "tableColumns"
	// parser\\sql\\SQLAnalyzer.g:499:1: tableColumns : o= dbObject DOT_STAR ;
	public final void tableColumns() throws RecognitionException {
		int tableColumns_StartIndex = input.index();

		ParserRuleReturnScope o =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:499:14: (o= dbObject DOT_STAR )
			// parser\\sql\\SQLAnalyzer.g:500:3: o= dbObject DOT_STAR
			{
			pushFollow(FOLLOW_dbObject_in_tableColumns2683);
			o=dbObject();
			state._fsp--;
			if (state.failed) return;
			match(input,DOT_STAR,FOLLOW_DOT_STAR_in_tableColumns2685); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 43, tableColumns_StartIndex); }

		}
	}
	// $ANTLR end "tableColumns"


	public static class column_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "column"
	// parser\\sql\\SQLAnalyzer.g:504:1: column : (d= dbObject | LPAREN o= column ( COMMA o= column )* RPAREN );
	public final SQLAnalyzerParser.column_return column() throws RecognitionException {
		SQLAnalyzerParser.column_return retval = new SQLAnalyzerParser.column_return();
		retval.start = input.LT(1);
		int column_StartIndex = input.index();

		ParserRuleReturnScope d =null;
		ParserRuleReturnScope o =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }

			// parser\\sql\\SQLAnalyzer.g:504:9: (d= dbObject | LPAREN o= column ( COMMA o= column )* RPAREN )
			int alt104=2;
			int LA104_0 = input.LA(1);
			if ( (LA104_0==AVG||(LA104_0 >= CURRENT && LA104_0 <= CURRENT_TIMESTAMP)||(LA104_0 >= DATE && LA104_0 <= DECODE)||(LA104_0 >= DENSE && LA104_0 <= DESC)||LA104_0==GROUP||LA104_0==HOUR||(LA104_0 >= INT && LA104_0 <= INTERVAL)||LA104_0==MAX||LA104_0==MIN||LA104_0==MINUTE||LA104_0==MONTH||LA104_0==NEXT||LA104_0==NVL||LA104_0==NonQuotedIdentifier||LA104_0==ORDER||LA104_0==OVER||(LA104_0 >= QuotedIdentifier && LA104_0 <= RANK)||LA104_0==ROW||LA104_0==SECOND||(LA104_0 >= SUM && LA104_0 <= SYSDATE)||(LA104_0 >= TIME && LA104_0 <= TIMESTAMP)||LA104_0==UPDATE||LA104_0==VALUE||(LA104_0 >= YEAR && LA104_0 <= YEARS)) ) {
				alt104=1;
			}
			else if ( (LA104_0==LPAREN) ) {
				alt104=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 104, 0, input);
				throw nvae;
			}

			switch (alt104) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:505:3: d= dbObject
					{
					pushFollow(FOLLOW_dbObject_in_column2706);
					d=dbObject();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					    String column = (d!=null?input.toString(d.start,d.stop):null);
					    //select Column???ÑÎãå Í≤ΩÏö∞ 
					    if(!getStatementType().equals("02")){
					      if(column !=null && !(column).equals("\\'\\'")) {
					           if(column.contains(".")){
					             String [] splitColumn = column.split("\\.");
					             column = splitColumn[1];
					             
					             // NEXTVAL ?¥Î©¥, . ?ûÏù¥ Ïª¨Îüº
					             if(column.equals("NEXTVAL")){
					              column = splitColumn[0];
					            }
					           }
					          column = column.toUpperCase();
					          if(!columnList.contains(column)){
					              columnList.add(column);
					           }
					         } 
					    
					    } else {
					      //selectColumn??Í≤ΩÏö∞ ?¥Ï? ?äÎäî??
					    }
					   }
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:529:5: LPAREN o= column ( COMMA o= column )* RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_column2714); if (state.failed) return retval;
					pushFollow(FOLLOW_column_in_column2720);
					o=column();
					state._fsp--;
					if (state.failed) return retval;
					// parser\\sql\\SQLAnalyzer.g:529:23: ( COMMA o= column )*
					loop103:
					while (true) {
						int alt103=2;
						int LA103_0 = input.LA(1);
						if ( (LA103_0==COMMA) ) {
							alt103=1;
						}

						switch (alt103) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:529:25: COMMA o= column
							{
							match(input,COMMA,FOLLOW_COMMA_in_column2724); if (state.failed) return retval;
							pushFollow(FOLLOW_column_in_column2730);
							o=column();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

						default :
							break loop103;
						}
					}

					match(input,RPAREN,FOLLOW_RPAREN_in_column2735); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					    String column = (o!=null?input.toString(o.start,o.stop):null);
					      //select Column???ÑÎãå Í≤ΩÏö∞ 
					if(!getStatementType().equals("02")){
					      if(column !=null && !(column).equals("\\'\\'")) {
					           if(column.contains(".")){
					             String [] splitColumn = column.split("\\.");
					             column = splitColumn[1];
					              
					              // NEXTVAL ?¥Î©¥, . ?ûÏù¥ Ïª¨Îüº
					             if(column.equals("NEXTVAL")){
					              column = splitColumn[0];
					            }
					           }
					          column = column.toUpperCase(); 
					          if(!columnList.contains(column)){
					              columnList.add(column);
					           }
					       }// end if 
					     } // selectType???ÑÎãê??ColumnAdd
					   }
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 44, column_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "column"



	// $ANTLR start "expression"
	// parser\\sql\\SQLAnalyzer.g:552:1: expression : e= additiveSubExpression (o= additiveOperator r= additiveSubExpression )* ;
	public final void expression() throws RecognitionException {
		int expression_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:552:12: (e= additiveSubExpression (o= additiveOperator r= additiveSubExpression )* )
			// parser\\sql\\SQLAnalyzer.g:553:3: e= additiveSubExpression (o= additiveOperator r= additiveSubExpression )*
			{
			pushFollow(FOLLOW_additiveSubExpression_in_expression2755);
			additiveSubExpression();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:554:3: (o= additiveOperator r= additiveSubExpression )*
			loop105:
			while (true) {
				int alt105=2;
				int LA105_0 = input.LA(1);
				if ( (LA105_0==DASH||LA105_0==PLUS) ) {
					int LA105_2 = input.LA(2);
					if ( (synpred129_SQLAnalyzer()) ) {
						alt105=1;
					}

				}
				else if ( (LA105_0==STRCONCAT) ) {
					int LA105_3 = input.LA(2);
					if ( (synpred129_SQLAnalyzer()) ) {
						alt105=1;
					}

				}

				switch (alt105) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:554:5: o= additiveOperator r= additiveSubExpression
					{
					pushFollow(FOLLOW_additiveOperator_in_expression2767);
					additiveOperator();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_additiveSubExpression_in_expression2773);
					additiveSubExpression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop105;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 45, expression_StartIndex); }

		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "additiveSubExpression"
	// parser\\sql\\SQLAnalyzer.g:557:1: additiveSubExpression : e= subExpression ( (o= multiplicativeArithmeticOperator )? r= subExpression )* ;
	public final void additiveSubExpression() throws RecognitionException {
		int additiveSubExpression_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:557:24: (e= subExpression ( (o= multiplicativeArithmeticOperator )? r= subExpression )* )
			// parser\\sql\\SQLAnalyzer.g:558:3: e= subExpression ( (o= multiplicativeArithmeticOperator )? r= subExpression )*
			{
			pushFollow(FOLLOW_subExpression_in_additiveSubExpression2794);
			subExpression();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:559:3: ( (o= multiplicativeArithmeticOperator )? r= subExpression )*
			loop107:
			while (true) {
				int alt107=2;
				alt107 = dfa107.predict(input);
				switch (alt107) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:559:5: (o= multiplicativeArithmeticOperator )? r= subExpression
					{
					// parser\\sql\\SQLAnalyzer.g:559:5: (o= multiplicativeArithmeticOperator )?
					int alt106=2;
					int LA106_0 = input.LA(1);
					if ( (LA106_0==DIVIDE||LA106_0==MOD||LA106_0==STAR) ) {
						alt106=1;
					}
					switch (alt106) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:559:7: o= multiplicativeArithmeticOperator
							{
							pushFollow(FOLLOW_multiplicativeArithmeticOperator_in_additiveSubExpression2807);
							multiplicativeArithmeticOperator();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					pushFollow(FOLLOW_subExpression_in_additiveSubExpression2816);
					subExpression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop107;
				}
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 46, additiveSubExpression_StartIndex); }

		}
	}
	// $ANTLR end "additiveSubExpression"



	// $ANTLR start "bracketedTerm"
	// parser\\sql\\SQLAnalyzer.g:562:1: bracketedTerm : LPAREN ( selectStatement ( expression )? | (e= functionArgument )* ( COMMA expression )* ) RPAREN ;
	public final void bracketedTerm() throws RecognitionException {
		int bracketedTerm_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:562:16: ( LPAREN ( selectStatement ( expression )? | (e= functionArgument )* ( COMMA expression )* ) RPAREN )
			// parser\\sql\\SQLAnalyzer.g:563:3: LPAREN ( selectStatement ( expression )? | (e= functionArgument )* ( COMMA expression )* ) RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_bracketedTerm2834); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:563:10: ( selectStatement ( expression )? | (e= functionArgument )* ( COMMA expression )* )
			int alt111=2;
			switch ( input.LA(1) ) {
			case SELECT:
				{
				alt111=1;
				}
				break;
			case LPAREN:
				{
				int LA111_2 = input.LA(2);
				if ( (synpred133_SQLAnalyzer()) ) {
					alt111=1;
				}
				else if ( (true) ) {
					alt111=2;
				}

				}
				break;
			case AVG:
			case AsciiStringLiteral:
			case CASE:
			case CAST:
			case COMMA:
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DASH:
			case DATE:
			case DAY:
			case DECODE:
			case DENSE:
			case DESC:
			case EXTRACT:
			case GROUP:
			case HOUR:
			case HexLiteral:
			case INT:
			case INTERVAL:
			case Integer:
			case Iso8601DateTime:
			case LEFT:
			case MAX:
			case MAccessDateTime:
			case MIN:
			case MINUTE:
			case MONTH:
			case NEXT:
			case NULL:
			case NVL:
			case NonQuotedIdentifier:
			case ORDER:
			case OVER:
			case PLACEHOLDER:
			case PLUS:
			case QuotedIdentifier:
			case RANK:
			case RIGHT:
			case ROW:
			case RPAREN:
			case Real:
			case SECOND:
			case SUBSTRING:
			case SUM:
			case SYSDATE:
			case TIME:
			case TIMESTAMP:
			case UPDATE:
			case UicodeValueLiteral:
			case UnicodeStringLiteral:
			case VALUE:
			case Variable:
			case YEAR:
			case YEARS:
				{
				alt111=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 111, 0, input);
				throw nvae;
			}
			switch (alt111) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:563:12: selectStatement ( expression )?
					{
					pushFollow(FOLLOW_selectStatement_in_bracketedTerm2838);
					selectStatement();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:563:28: ( expression )?
					int alt108=2;
					int LA108_0 = input.LA(1);
					if ( (LA108_0==AVG||LA108_0==AsciiStringLiteral||(LA108_0 >= CASE && LA108_0 <= CAST)||(LA108_0 >= CURRENT && LA108_0 <= CURRENT_TIMESTAMP)||(LA108_0 >= DASH && LA108_0 <= DECODE)||(LA108_0 >= DENSE && LA108_0 <= DESC)||LA108_0==EXTRACT||LA108_0==GROUP||LA108_0==HOUR||LA108_0==HexLiteral||(LA108_0 >= INT && LA108_0 <= INTERVAL)||(LA108_0 >= Integer && LA108_0 <= Iso8601DateTime)||LA108_0==LEFT||LA108_0==LPAREN||(LA108_0 >= MAX && LA108_0 <= MAccessDateTime)||LA108_0==MIN||LA108_0==MINUTE||LA108_0==MONTH||LA108_0==NEXT||LA108_0==NULL||LA108_0==NVL||LA108_0==NonQuotedIdentifier||LA108_0==ORDER||LA108_0==OVER||(LA108_0 >= PLACEHOLDER && LA108_0 <= PLUS)||(LA108_0 >= QuotedIdentifier && LA108_0 <= RANK)||(LA108_0 >= RIGHT && LA108_0 <= ROW)||(LA108_0 >= Real && LA108_0 <= SECOND)||(LA108_0 >= SUBSTRING && LA108_0 <= SYSDATE)||(LA108_0 >= TIME && LA108_0 <= TIMESTAMP)||LA108_0==UPDATE||LA108_0==UicodeValueLiteral||LA108_0==UnicodeStringLiteral||LA108_0==VALUE||LA108_0==Variable||(LA108_0 >= YEAR && LA108_0 <= YEARS)) ) {
						alt108=1;
					}
					switch (alt108) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:563:29: expression
							{
							pushFollow(FOLLOW_expression_in_bracketedTerm2841);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:563:44: (e= functionArgument )* ( COMMA expression )*
					{
					// parser\\sql\\SQLAnalyzer.g:563:46: (e= functionArgument )*
					loop109:
					while (true) {
						int alt109=2;
						int LA109_0 = input.LA(1);
						if ( (LA109_0==AVG||LA109_0==AsciiStringLiteral||(LA109_0 >= CASE && LA109_0 <= CAST)||(LA109_0 >= CURRENT && LA109_0 <= CURRENT_TIMESTAMP)||(LA109_0 >= DASH && LA109_0 <= DECODE)||(LA109_0 >= DENSE && LA109_0 <= DESC)||LA109_0==EXTRACT||LA109_0==GROUP||LA109_0==HOUR||LA109_0==HexLiteral||(LA109_0 >= INT && LA109_0 <= INTERVAL)||(LA109_0 >= Integer && LA109_0 <= Iso8601DateTime)||LA109_0==LEFT||LA109_0==LPAREN||(LA109_0 >= MAX && LA109_0 <= MAccessDateTime)||LA109_0==MIN||LA109_0==MINUTE||LA109_0==MONTH||LA109_0==NEXT||LA109_0==NULL||LA109_0==NVL||LA109_0==NonQuotedIdentifier||LA109_0==ORDER||LA109_0==OVER||(LA109_0 >= PLACEHOLDER && LA109_0 <= PLUS)||(LA109_0 >= QuotedIdentifier && LA109_0 <= RANK)||(LA109_0 >= RIGHT && LA109_0 <= ROW)||(LA109_0 >= Real && LA109_0 <= SECOND)||(LA109_0 >= SUBSTRING && LA109_0 <= SYSDATE)||(LA109_0 >= TIME && LA109_0 <= TIMESTAMP)||LA109_0==UPDATE||LA109_0==UicodeValueLiteral||LA109_0==UnicodeStringLiteral||LA109_0==VALUE||LA109_0==Variable||(LA109_0 >= YEAR && LA109_0 <= YEARS)) ) {
							alt109=1;
						}

						switch (alt109) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:563:46: e= functionArgument
							{
							pushFollow(FOLLOW_functionArgument_in_bracketedTerm2851);
							functionArgument();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop109;
						}
					}

					// parser\\sql\\SQLAnalyzer.g:563:66: ( COMMA expression )*
					loop110:
					while (true) {
						int alt110=2;
						int LA110_0 = input.LA(1);
						if ( (LA110_0==COMMA) ) {
							alt110=1;
						}

						switch (alt110) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:563:68: COMMA expression
							{
							match(input,COMMA,FOLLOW_COMMA_in_bracketedTerm2856); if (state.failed) return;
							pushFollow(FOLLOW_expression_in_bracketedTerm2858);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop110;
						}
					}

					}
					break;

			}

			match(input,RPAREN,FOLLOW_RPAREN_in_bracketedTerm2865); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 47, bracketedTerm_StartIndex); }

		}
	}
	// $ANTLR end "bracketedTerm"



	// $ANTLR start "subExpression"
	// parser\\sql\\SQLAnalyzer.g:566:1: subExpression : (o= unaryOperator )? (c= constant |a= sharpObject |g= groupFunction |da= datetimeField |t= db2Element |v= variableReference | PLACEHOLDER | ( function )=>f= function |e= bracketedTerm |d= dbObject ( plusSignature )? |p= caseFunction |q= castFunction ) ;
	public final void subExpression() throws RecognitionException {
		int subExpression_StartIndex = input.index();

		ParserRuleReturnScope d =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:566:16: ( (o= unaryOperator )? (c= constant |a= sharpObject |g= groupFunction |da= datetimeField |t= db2Element |v= variableReference | PLACEHOLDER | ( function )=>f= function |e= bracketedTerm |d= dbObject ( plusSignature )? |p= caseFunction |q= castFunction ) )
			// parser\\sql\\SQLAnalyzer.g:567:3: (o= unaryOperator )? (c= constant |a= sharpObject |g= groupFunction |da= datetimeField |t= db2Element |v= variableReference | PLACEHOLDER | ( function )=>f= function |e= bracketedTerm |d= dbObject ( plusSignature )? |p= caseFunction |q= castFunction )
			{
			// parser\\sql\\SQLAnalyzer.g:567:3: (o= unaryOperator )?
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( (LA112_0==DASH||LA112_0==PLUS) ) {
				alt112=1;
			}
			switch (alt112) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:567:5: o= unaryOperator
					{
					pushFollow(FOLLOW_unaryOperator_in_subExpression2886);
					unaryOperator();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:567:26: (c= constant |a= sharpObject |g= groupFunction |da= datetimeField |t= db2Element |v= variableReference | PLACEHOLDER | ( function )=>f= function |e= bracketedTerm |d= dbObject ( plusSignature )? |p= caseFunction |q= castFunction )
			int alt114=12;
			int LA114_0 = input.LA(1);
			if ( (LA114_0==AsciiStringLiteral||LA114_0==HexLiteral||(LA114_0 >= Integer && LA114_0 <= Iso8601DateTime)||LA114_0==MAccessDateTime||LA114_0==NULL||LA114_0==Real||LA114_0==UnicodeStringLiteral) ) {
				alt114=1;
			}
			else if ( (LA114_0==INTERVAL) ) {
				int LA114_5 = input.LA(2);
				if ( (synpred137_SQLAnalyzer()) ) {
					alt114=1;
				}
				else if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==TIMESTAMP) ) {
				int LA114_9 = input.LA(2);
				if ( (synpred137_SQLAnalyzer()) ) {
					alt114=1;
				}
				else if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 9, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==NonQuotedIdentifier) ) {
				int LA114_10 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred144_SQLAnalyzer()) ) {
					alt114=8;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==QuotedIdentifier) ) {
				int LA114_11 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 11, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==DESC) ) {
				int LA114_12 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 12, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==ORDER) ) {
				int LA114_13 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 13, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==GROUP) ) {
				int LA114_14 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 14, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==MAX) ) {
				int LA114_15 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 15, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==SUM) ) {
				int LA114_16 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 16, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==AVG) ) {
				int LA114_17 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 17, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==MIN) ) {
				int LA114_18 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 18, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==NVL) ) {
				int LA114_19 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 19, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==DATE) ) {
				int LA114_20 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred140_SQLAnalyzer()) ) {
					alt114=4;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 20, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==TIME) ) {
				int LA114_21 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 21, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==MONTH) ) {
				int LA114_22 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred140_SQLAnalyzer()) ) {
					alt114=4;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 22, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==INT) ) {
				int LA114_23 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 23, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==VALUE) ) {
				int LA114_24 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 24, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==OVER) ) {
				int LA114_25 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 25, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==ROW) ) {
				int LA114_26 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 26, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==DENSE) ) {
				int LA114_27 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 27, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==RANK) ) {
				int LA114_28 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 28, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==DECODE) ) {
				int LA114_29 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred139_SQLAnalyzer()) ) {
					alt114=3;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 29, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==YEAR) ) {
				int LA114_30 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred140_SQLAnalyzer()) ) {
					alt114=4;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 30, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==CURRENT) ) {
				int LA114_31 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 31, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==UPDATE) ) {
				int LA114_32 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 32, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==SYSDATE) ) {
				int LA114_33 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 33, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==YEARS) ) {
				int LA114_34 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 34, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==DAY||LA114_0==HOUR||LA114_0==MINUTE||LA114_0==SECOND) ) {
				int LA114_35 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred140_SQLAnalyzer()) ) {
					alt114=4;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 35, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==CURRENT_DATE) ) {
				int LA114_36 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 36, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==CURRENT_TIME) ) {
				int LA114_37 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 37, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==CURRENT_TIMESTAMP) ) {
				int LA114_38 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 38, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==NEXT) ) {
				int LA114_39 = input.LA(2);
				if ( (synpred138_SQLAnalyzer()) ) {
					alt114=2;
				}
				else if ( (synpred141_SQLAnalyzer()) ) {
					alt114=5;
				}
				else if ( (synpred147_SQLAnalyzer()) ) {
					alt114=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 39, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==UicodeValueLiteral) ) {
				alt114=2;
			}
			else if ( (LA114_0==Variable) ) {
				alt114=6;
			}
			else if ( (LA114_0==PLACEHOLDER) ) {
				alt114=7;
			}
			else if ( (LA114_0==SUBSTRING) && (synpred144_SQLAnalyzer())) {
				alt114=8;
			}
			else if ( (LA114_0==EXTRACT) && (synpred144_SQLAnalyzer())) {
				alt114=8;
			}
			else if ( (LA114_0==LPAREN) ) {
				int LA114_45 = input.LA(2);
				if ( (synpred144_SQLAnalyzer()) ) {
					alt114=8;
				}
				else if ( (synpred145_SQLAnalyzer()) ) {
					alt114=9;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 45, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA114_0==LEFT) && (synpred144_SQLAnalyzer())) {
				alt114=8;
			}
			else if ( (LA114_0==RIGHT) && (synpred144_SQLAnalyzer())) {
				alt114=8;
			}
			else if ( (LA114_0==CASE) ) {
				alt114=11;
			}
			else if ( (LA114_0==CAST) ) {
				alt114=12;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 114, 0, input);
				throw nvae;
			}

			switch (alt114) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:568:5: c= constant
					{
					pushFollow(FOLLOW_constant_in_subExpression2901);
					constant();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:569:7: a= sharpObject
					{
					pushFollow(FOLLOW_sharpObject_in_subExpression2914);
					sharpObject();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:570:7: g= groupFunction
					{
					pushFollow(FOLLOW_groupFunction_in_subExpression2926);
					groupFunction();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:571:7: da= datetimeField
					{
					pushFollow(FOLLOW_datetimeField_in_subExpression2938);
					datetimeField();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// parser\\sql\\SQLAnalyzer.g:572:7: t= db2Element
					{
					pushFollow(FOLLOW_db2Element_in_subExpression2951);
					db2Element();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 6 :
					// parser\\sql\\SQLAnalyzer.g:573:7: v= variableReference
					{
					pushFollow(FOLLOW_variableReference_in_subExpression2963);
					variableReference();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 7 :
					// parser\\sql\\SQLAnalyzer.g:574:7: PLACEHOLDER
					{
					match(input,PLACEHOLDER,FOLLOW_PLACEHOLDER_in_subExpression2972); if (state.failed) return;
					}
					break;
				case 8 :
					// parser\\sql\\SQLAnalyzer.g:575:7: ( function )=>f= function
					{
					pushFollow(FOLLOW_function_in_subExpression2997);
					function();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 9 :
					// parser\\sql\\SQLAnalyzer.g:577:7: e= bracketedTerm
					{
					pushFollow(FOLLOW_bracketedTerm_in_subExpression3010);
					bracketedTerm();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 10 :
					// parser\\sql\\SQLAnalyzer.g:578:7: d= dbObject ( plusSignature )?
					{
					pushFollow(FOLLOW_dbObject_in_subExpression3023);
					d=dbObject();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:578:20: ( plusSignature )?
					int alt113=2;
					int LA113_0 = input.LA(1);
					if ( (LA113_0==LPAREN) ) {
						int LA113_1 = input.LA(2);
						if ( (synpred146_SQLAnalyzer()) ) {
							alt113=1;
						}
					}
					switch (alt113) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:578:21: plusSignature
							{
							pushFollow(FOLLOW_plusSignature_in_subExpression3026);
							plusSignature();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					if ( state.backtracking==0 ) {
					       String column = (d!=null?input.toString(d.start,d.stop):null);
					       
					    // update Column, GROUPBY COLUMN add
					if(!getStatementType().equals("02")){
					        if(column !=null && !(column).equals("\\'\\'")) {
					           if(column.contains(".")){
					             String [] splitColumn = column.split("\\.");
					             column = splitColumn[1];
					             
					              // NEXTVAL ?¥Î©¥, . ?ûÏù¥ Ïª¨Îüº
					             if(column.equals("NEXTVAL")){
					              column = splitColumn[0];
					            }
					           }
					          column = column.toUpperCase(); 
					          if(!columnList.contains(column)){
					              columnList.add(column);
					           }
					         } 
					    
					    } else {
					       //statementType??select?¥Î©¥ add?é„ÖèÏß??äÎäî??
					    }
					   }
					}
					break;
				case 11 :
					// parser\\sql\\SQLAnalyzer.g:607:7: p= caseFunction
					{
					pushFollow(FOLLOW_caseFunction_in_subExpression3084);
					caseFunction();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 12 :
					// parser\\sql\\SQLAnalyzer.g:608:7: q= castFunction
					{
					pushFollow(FOLLOW_castFunction_in_subExpression3096);
					castFunction();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 48, subExpression_StartIndex); }

		}
	}
	// $ANTLR end "subExpression"



	// $ANTLR start "variableReference"
	// parser\\sql\\SQLAnalyzer.g:613:1: variableReference : Variable ;
	public final void variableReference() throws RecognitionException {
		int variableReference_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:613:20: ( Variable )
			// parser\\sql\\SQLAnalyzer.g:614:3: Variable
			{
			match(input,Variable,FOLLOW_Variable_in_variableReference3116); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 49, variableReference_StartIndex); }

		}
	}
	// $ANTLR end "variableReference"



	// $ANTLR start "function"
	// parser\\sql\\SQLAnalyzer.g:618:1: function : ( SUBSTRING LPAREN v= expression FROM s= expression ( FOR l= expression )? RPAREN | ( EXTRACT )? LPAREN d= datetimeField ( FROM )? s= expression RPAREN |f= genericFunction );
	public final void function() throws RecognitionException {
		int function_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:618:11: ( SUBSTRING LPAREN v= expression FROM s= expression ( FOR l= expression )? RPAREN | ( EXTRACT )? LPAREN d= datetimeField ( FROM )? s= expression RPAREN |f= genericFunction )
			int alt118=3;
			switch ( input.LA(1) ) {
			case SUBSTRING:
				{
				alt118=1;
				}
				break;
			case EXTRACT:
			case LPAREN:
				{
				alt118=2;
				}
				break;
			case LEFT:
			case NonQuotedIdentifier:
			case RIGHT:
				{
				alt118=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 118, 0, input);
				throw nvae;
			}
			switch (alt118) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:619:3: SUBSTRING LPAREN v= expression FROM s= expression ( FOR l= expression )? RPAREN
					{
					match(input,SUBSTRING,FOLLOW_SUBSTRING_in_function3132); if (state.failed) return;
					match(input,LPAREN,FOLLOW_LPAREN_in_function3135); if (state.failed) return;
					pushFollow(FOLLOW_expression_in_function3141);
					expression();
					state._fsp--;
					if (state.failed) return;
					match(input,FROM,FOLLOW_FROM_in_function3144); if (state.failed) return;
					pushFollow(FOLLOW_expression_in_function3150);
					expression();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:619:58: ( FOR l= expression )?
					int alt115=2;
					int LA115_0 = input.LA(1);
					if ( (LA115_0==FOR) ) {
						alt115=1;
					}
					switch (alt115) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:619:60: FOR l= expression
							{
							match(input,FOR,FOLLOW_FOR_in_function3155); if (state.failed) return;
							pushFollow(FOLLOW_expression_in_function3161);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_function3166); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:620:5: ( EXTRACT )? LPAREN d= datetimeField ( FROM )? s= expression RPAREN
					{
					// parser\\sql\\SQLAnalyzer.g:620:5: ( EXTRACT )?
					int alt116=2;
					int LA116_0 = input.LA(1);
					if ( (LA116_0==EXTRACT) ) {
						alt116=1;
					}
					switch (alt116) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:620:6: EXTRACT
							{
							match(input,EXTRACT,FOLLOW_EXTRACT_in_function3173); if (state.failed) return;
							}
							break;

					}

					match(input,LPAREN,FOLLOW_LPAREN_in_function3177); if (state.failed) return;
					pushFollow(FOLLOW_datetimeField_in_function3183);
					datetimeField();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:620:41: ( FROM )?
					int alt117=2;
					int LA117_0 = input.LA(1);
					if ( (LA117_0==FROM) ) {
						alt117=1;
					}
					switch (alt117) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:620:42: FROM
							{
							match(input,FROM,FOLLOW_FROM_in_function3186); if (state.failed) return;
							}
							break;

					}

					pushFollow(FOLLOW_expression_in_function3194);
					expression();
					state._fsp--;
					if (state.failed) return;
					match(input,RPAREN,FOLLOW_RPAREN_in_function3197); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:621:5: f= genericFunction
					{
					pushFollow(FOLLOW_genericFunction_in_function3207);
					genericFunction();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 50, function_StartIndex); }

		}
	}
	// $ANTLR end "function"



	// $ANTLR start "genericFunction"
	// parser\\sql\\SQLAnalyzer.g:624:1: genericFunction : ( ( NonQuotedIdentifier DOT )? NonQuotedIdentifier | LEFT | RIGHT ) LPAREN (e= functionArgument ( functionArgument )? ( COMMA e= functionArgument )* | STAR | ( ALL | DISTINCT ) ( STAR |e= expression ) )? RPAREN ( expression )? ;
	public final void genericFunction() throws RecognitionException {
		int genericFunction_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:624:17: ( ( ( NonQuotedIdentifier DOT )? NonQuotedIdentifier | LEFT | RIGHT ) LPAREN (e= functionArgument ( functionArgument )? ( COMMA e= functionArgument )* | STAR | ( ALL | DISTINCT ) ( STAR |e= expression ) )? RPAREN ( expression )? )
			// parser\\sql\\SQLAnalyzer.g:626:3: ( ( NonQuotedIdentifier DOT )? NonQuotedIdentifier | LEFT | RIGHT ) LPAREN (e= functionArgument ( functionArgument )? ( COMMA e= functionArgument )* | STAR | ( ALL | DISTINCT ) ( STAR |e= expression ) )? RPAREN ( expression )?
			{
			// parser\\sql\\SQLAnalyzer.g:626:3: ( ( NonQuotedIdentifier DOT )? NonQuotedIdentifier | LEFT | RIGHT )
			int alt120=3;
			switch ( input.LA(1) ) {
			case NonQuotedIdentifier:
				{
				alt120=1;
				}
				break;
			case LEFT:
				{
				alt120=2;
				}
				break;
			case RIGHT:
				{
				alt120=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 120, 0, input);
				throw nvae;
			}
			switch (alt120) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:629:5: ( NonQuotedIdentifier DOT )? NonQuotedIdentifier
					{
					// parser\\sql\\SQLAnalyzer.g:629:5: ( NonQuotedIdentifier DOT )?
					int alt119=2;
					int LA119_0 = input.LA(1);
					if ( (LA119_0==NonQuotedIdentifier) ) {
						int LA119_1 = input.LA(2);
						if ( (LA119_1==DOT) ) {
							alt119=1;
						}
					}
					switch (alt119) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:629:6: NonQuotedIdentifier DOT
							{
							match(input,NonQuotedIdentifier,FOLLOW_NonQuotedIdentifier_in_genericFunction3240); if (state.failed) return;
							match(input,DOT,FOLLOW_DOT_in_genericFunction3242); if (state.failed) return;
							}
							break;

					}

					match(input,NonQuotedIdentifier,FOLLOW_NonQuotedIdentifier_in_genericFunction3246); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:630:7: LEFT
					{
					match(input,LEFT,FOLLOW_LEFT_in_genericFunction3255); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:631:7: RIGHT
					{
					match(input,RIGHT,FOLLOW_RIGHT_in_genericFunction3264); if (state.failed) return;
					}
					break;

			}

			match(input,LPAREN,FOLLOW_LPAREN_in_genericFunction3271); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:632:12: (e= functionArgument ( functionArgument )? ( COMMA e= functionArgument )* | STAR | ( ALL | DISTINCT ) ( STAR |e= expression ) )?
			int alt124=4;
			switch ( input.LA(1) ) {
				case AVG:
				case AsciiStringLiteral:
				case CASE:
				case CAST:
				case CURRENT:
				case CURRENT_DATE:
				case CURRENT_TIME:
				case CURRENT_TIMESTAMP:
				case DASH:
				case DATE:
				case DAY:
				case DECODE:
				case DENSE:
				case DESC:
				case EXTRACT:
				case GROUP:
				case HOUR:
				case HexLiteral:
				case INT:
				case INTERVAL:
				case Integer:
				case Iso8601DateTime:
				case LEFT:
				case LPAREN:
				case MAX:
				case MAccessDateTime:
				case MIN:
				case MINUTE:
				case MONTH:
				case NEXT:
				case NULL:
				case NVL:
				case NonQuotedIdentifier:
				case ORDER:
				case OVER:
				case PLACEHOLDER:
				case PLUS:
				case QuotedIdentifier:
				case RANK:
				case RIGHT:
				case ROW:
				case Real:
				case SECOND:
				case SUBSTRING:
				case SUM:
				case SYSDATE:
				case TIME:
				case TIMESTAMP:
				case UPDATE:
				case UicodeValueLiteral:
				case UnicodeStringLiteral:
				case VALUE:
				case Variable:
				case YEAR:
				case YEARS:
					{
					alt124=1;
					}
					break;
				case STAR:
					{
					alt124=2;
					}
					break;
				case ALL:
				case DISTINCT:
					{
					alt124=3;
					}
					break;
			}
			switch (alt124) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:633:5: e= functionArgument ( functionArgument )? ( COMMA e= functionArgument )*
					{
					pushFollow(FOLLOW_functionArgument_in_genericFunction3283);
					functionArgument();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:633:28: ( functionArgument )?
					int alt121=2;
					int LA121_0 = input.LA(1);
					if ( (LA121_0==AVG||LA121_0==AsciiStringLiteral||(LA121_0 >= CASE && LA121_0 <= CAST)||(LA121_0 >= CURRENT && LA121_0 <= CURRENT_TIMESTAMP)||(LA121_0 >= DASH && LA121_0 <= DECODE)||(LA121_0 >= DENSE && LA121_0 <= DESC)||LA121_0==EXTRACT||LA121_0==GROUP||LA121_0==HOUR||LA121_0==HexLiteral||(LA121_0 >= INT && LA121_0 <= INTERVAL)||(LA121_0 >= Integer && LA121_0 <= Iso8601DateTime)||LA121_0==LEFT||LA121_0==LPAREN||(LA121_0 >= MAX && LA121_0 <= MAccessDateTime)||LA121_0==MIN||LA121_0==MINUTE||LA121_0==MONTH||LA121_0==NEXT||LA121_0==NULL||LA121_0==NVL||LA121_0==NonQuotedIdentifier||LA121_0==ORDER||LA121_0==OVER||(LA121_0 >= PLACEHOLDER && LA121_0 <= PLUS)||(LA121_0 >= QuotedIdentifier && LA121_0 <= RANK)||(LA121_0 >= RIGHT && LA121_0 <= ROW)||(LA121_0 >= Real && LA121_0 <= SECOND)||(LA121_0 >= SUBSTRING && LA121_0 <= SYSDATE)||(LA121_0 >= TIME && LA121_0 <= TIMESTAMP)||LA121_0==UPDATE||LA121_0==UicodeValueLiteral||LA121_0==UnicodeStringLiteral||LA121_0==VALUE||LA121_0==Variable||(LA121_0 >= YEAR && LA121_0 <= YEARS)) ) {
						alt121=1;
					}
					switch (alt121) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:633:30: functionArgument
							{
							pushFollow(FOLLOW_functionArgument_in_genericFunction3289);
							functionArgument();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// parser\\sql\\SQLAnalyzer.g:634:7: ( COMMA e= functionArgument )*
					loop122:
					while (true) {
						int alt122=2;
						int LA122_0 = input.LA(1);
						if ( (LA122_0==COMMA) ) {
							alt122=1;
						}

						switch (alt122) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:634:9: COMMA e= functionArgument
							{
							match(input,COMMA,FOLLOW_COMMA_in_genericFunction3303); if (state.failed) return;
							pushFollow(FOLLOW_functionArgument_in_genericFunction3309);
							functionArgument();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop122;
						}
					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:637:7: STAR
					{
					match(input,STAR,FOLLOW_STAR_in_genericFunction3330); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:638:13: ( ALL | DISTINCT ) ( STAR |e= expression )
					{
					if ( input.LA(1)==ALL||input.LA(1)==DISTINCT ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// parser\\sql\\SQLAnalyzer.g:638:31: ( STAR |e= expression )
					int alt123=2;
					int LA123_0 = input.LA(1);
					if ( (LA123_0==STAR) ) {
						alt123=1;
					}
					else if ( (LA123_0==AVG||LA123_0==AsciiStringLiteral||(LA123_0 >= CASE && LA123_0 <= CAST)||(LA123_0 >= CURRENT && LA123_0 <= CURRENT_TIMESTAMP)||(LA123_0 >= DASH && LA123_0 <= DECODE)||(LA123_0 >= DENSE && LA123_0 <= DESC)||LA123_0==EXTRACT||LA123_0==GROUP||LA123_0==HOUR||LA123_0==HexLiteral||(LA123_0 >= INT && LA123_0 <= INTERVAL)||(LA123_0 >= Integer && LA123_0 <= Iso8601DateTime)||LA123_0==LEFT||LA123_0==LPAREN||(LA123_0 >= MAX && LA123_0 <= MAccessDateTime)||LA123_0==MIN||LA123_0==MINUTE||LA123_0==MONTH||LA123_0==NEXT||LA123_0==NULL||LA123_0==NVL||LA123_0==NonQuotedIdentifier||LA123_0==ORDER||LA123_0==OVER||(LA123_0 >= PLACEHOLDER && LA123_0 <= PLUS)||(LA123_0 >= QuotedIdentifier && LA123_0 <= RANK)||(LA123_0 >= RIGHT && LA123_0 <= ROW)||(LA123_0 >= Real && LA123_0 <= SECOND)||(LA123_0 >= SUBSTRING && LA123_0 <= SYSDATE)||(LA123_0 >= TIME && LA123_0 <= TIMESTAMP)||LA123_0==UPDATE||LA123_0==UicodeValueLiteral||LA123_0==UnicodeStringLiteral||LA123_0==VALUE||LA123_0==Variable||(LA123_0 >= YEAR && LA123_0 <= YEARS)) ) {
						alt123=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 123, 0, input);
						throw nvae;
					}

					switch (alt123) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:639:7: STAR
							{
							match(input,STAR,FOLLOW_STAR_in_genericFunction3362); if (state.failed) return;
							}
							break;
						case 2 :
							// parser\\sql\\SQLAnalyzer.g:641:9: e= expression
							{
							pushFollow(FOLLOW_expression_in_genericFunction3384);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			match(input,RPAREN,FOLLOW_RPAREN_in_genericFunction3409); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:644:19: ( expression )?
			int alt125=2;
			alt125 = dfa125.predict(input);
			switch (alt125) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:644:21: expression
					{
					pushFollow(FOLLOW_expression_in_genericFunction3413);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 51, genericFunction_StartIndex); }

		}
	}
	// $ANTLR end "genericFunction"



	// $ANTLR start "functionArgument"
	// parser\\sql\\SQLAnalyzer.g:647:1: functionArgument : (e= expression |d= datetimeField );
	public final void functionArgument() throws RecognitionException {
		int functionArgument_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:648:3: (e= expression |d= datetimeField )
			int alt126=2;
			switch ( input.LA(1) ) {
			case AVG:
			case AsciiStringLiteral:
			case CASE:
			case CAST:
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DASH:
			case DECODE:
			case DENSE:
			case DESC:
			case EXTRACT:
			case GROUP:
			case HexLiteral:
			case INT:
			case INTERVAL:
			case Integer:
			case Iso8601DateTime:
			case LEFT:
			case LPAREN:
			case MAX:
			case MAccessDateTime:
			case MIN:
			case NEXT:
			case NULL:
			case NVL:
			case NonQuotedIdentifier:
			case ORDER:
			case OVER:
			case PLACEHOLDER:
			case PLUS:
			case QuotedIdentifier:
			case RANK:
			case RIGHT:
			case ROW:
			case Real:
			case SUBSTRING:
			case SUM:
			case SYSDATE:
			case TIME:
			case TIMESTAMP:
			case UPDATE:
			case UicodeValueLiteral:
			case UnicodeStringLiteral:
			case VALUE:
			case Variable:
			case YEARS:
				{
				alt126=1;
				}
				break;
			case DATE:
				{
				int LA126_2 = input.LA(2);
				if ( (synpred165_SQLAnalyzer()) ) {
					alt126=1;
				}
				else if ( (true) ) {
					alt126=2;
				}

				}
				break;
			case MONTH:
				{
				int LA126_3 = input.LA(2);
				if ( (synpred165_SQLAnalyzer()) ) {
					alt126=1;
				}
				else if ( (true) ) {
					alt126=2;
				}

				}
				break;
			case YEAR:
				{
				int LA126_4 = input.LA(2);
				if ( (synpred165_SQLAnalyzer()) ) {
					alt126=1;
				}
				else if ( (true) ) {
					alt126=2;
				}

				}
				break;
			case DAY:
			case HOUR:
			case MINUTE:
			case SECOND:
				{
				int LA126_5 = input.LA(2);
				if ( (synpred165_SQLAnalyzer()) ) {
					alt126=1;
				}
				else if ( (true) ) {
					alt126=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 126, 0, input);
				throw nvae;
			}
			switch (alt126) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:648:3: e= expression
					{
					pushFollow(FOLLOW_expression_in_functionArgument3433);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:649:5: d= datetimeField
					{
					pushFollow(FOLLOW_datetimeField_in_functionArgument3444);
					datetimeField();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 52, functionArgument_StartIndex); }

		}
	}
	// $ANTLR end "functionArgument"



	// $ANTLR start "groupName"
	// parser\\sql\\SQLAnalyzer.g:652:1: groupName : ( MAX | SUM | AVG | MIN | NVL | DATE | TIME | TIMESTAMP | MONTH | INT | VALUE | OVER | ROW UNDERSCOPE NUMBER | DENSE UNDERSCOPE RANK | RANK | DECODE );
	public final void groupName() throws RecognitionException {
		int groupName_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:652:11: ( MAX | SUM | AVG | MIN | NVL | DATE | TIME | TIMESTAMP | MONTH | INT | VALUE | OVER | ROW UNDERSCOPE NUMBER | DENSE UNDERSCOPE RANK | RANK | DECODE )
			int alt127=16;
			switch ( input.LA(1) ) {
			case MAX:
				{
				alt127=1;
				}
				break;
			case SUM:
				{
				alt127=2;
				}
				break;
			case AVG:
				{
				alt127=3;
				}
				break;
			case MIN:
				{
				alt127=4;
				}
				break;
			case NVL:
				{
				alt127=5;
				}
				break;
			case DATE:
				{
				alt127=6;
				}
				break;
			case TIME:
				{
				alt127=7;
				}
				break;
			case TIMESTAMP:
				{
				alt127=8;
				}
				break;
			case MONTH:
				{
				alt127=9;
				}
				break;
			case INT:
				{
				alt127=10;
				}
				break;
			case VALUE:
				{
				alt127=11;
				}
				break;
			case OVER:
				{
				alt127=12;
				}
				break;
			case ROW:
				{
				alt127=13;
				}
				break;
			case DENSE:
				{
				alt127=14;
				}
				break;
			case RANK:
				{
				alt127=15;
				}
				break;
			case DECODE:
				{
				alt127=16;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 127, 0, input);
				throw nvae;
			}
			switch (alt127) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:653:5: MAX
					{
					match(input,MAX,FOLLOW_MAX_in_groupName3462); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:654:8: SUM
					{
					match(input,SUM,FOLLOW_SUM_in_groupName3472); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:655:8: AVG
					{
					match(input,AVG,FOLLOW_AVG_in_groupName3482); if (state.failed) return;
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:656:8: MIN
					{
					match(input,MIN,FOLLOW_MIN_in_groupName3493); if (state.failed) return;
					}
					break;
				case 5 :
					// parser\\sql\\SQLAnalyzer.g:657:8: NVL
					{
					match(input,NVL,FOLLOW_NVL_in_groupName3503); if (state.failed) return;
					}
					break;
				case 6 :
					// parser\\sql\\SQLAnalyzer.g:658:8: DATE
					{
					match(input,DATE,FOLLOW_DATE_in_groupName3514); if (state.failed) return;
					}
					break;
				case 7 :
					// parser\\sql\\SQLAnalyzer.g:659:8: TIME
					{
					match(input,TIME,FOLLOW_TIME_in_groupName3523); if (state.failed) return;
					}
					break;
				case 8 :
					// parser\\sql\\SQLAnalyzer.g:660:8: TIMESTAMP
					{
					match(input,TIMESTAMP,FOLLOW_TIMESTAMP_in_groupName3533); if (state.failed) return;
					}
					break;
				case 9 :
					// parser\\sql\\SQLAnalyzer.g:661:8: MONTH
					{
					match(input,MONTH,FOLLOW_MONTH_in_groupName3542); if (state.failed) return;
					}
					break;
				case 10 :
					// parser\\sql\\SQLAnalyzer.g:662:8: INT
					{
					match(input,INT,FOLLOW_INT_in_groupName3551); if (state.failed) return;
					}
					break;
				case 11 :
					// parser\\sql\\SQLAnalyzer.g:663:8: VALUE
					{
					match(input,VALUE,FOLLOW_VALUE_in_groupName3560); if (state.failed) return;
					}
					break;
				case 12 :
					// parser\\sql\\SQLAnalyzer.g:664:8: OVER
					{
					match(input,OVER,FOLLOW_OVER_in_groupName3569); if (state.failed) return;
					}
					break;
				case 13 :
					// parser\\sql\\SQLAnalyzer.g:665:8: ROW UNDERSCOPE NUMBER
					{
					match(input,ROW,FOLLOW_ROW_in_groupName3578); if (state.failed) return;
					match(input,UNDERSCOPE,FOLLOW_UNDERSCOPE_in_groupName3580); if (state.failed) return;
					match(input,NUMBER,FOLLOW_NUMBER_in_groupName3582); if (state.failed) return;
					}
					break;
				case 14 :
					// parser\\sql\\SQLAnalyzer.g:666:8: DENSE UNDERSCOPE RANK
					{
					match(input,DENSE,FOLLOW_DENSE_in_groupName3591); if (state.failed) return;
					match(input,UNDERSCOPE,FOLLOW_UNDERSCOPE_in_groupName3593); if (state.failed) return;
					match(input,RANK,FOLLOW_RANK_in_groupName3595); if (state.failed) return;
					}
					break;
				case 15 :
					// parser\\sql\\SQLAnalyzer.g:667:8: RANK
					{
					match(input,RANK,FOLLOW_RANK_in_groupName3604); if (state.failed) return;
					}
					break;
				case 16 :
					// parser\\sql\\SQLAnalyzer.g:668:8: DECODE
					{
					match(input,DECODE,FOLLOW_DECODE_in_groupName3613); if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 53, groupName_StartIndex); }

		}
	}
	// $ANTLR end "groupName"



	// $ANTLR start "groupFunction"
	// parser\\sql\\SQLAnalyzer.g:671:1: groupFunction : groupName LPAREN ( ALL | DISTINCT | PARTITION BY )? (c= functionArgument ( COMMA b= functionArgument )* )? ( orderByClause )? RPAREN ;
	public final void groupFunction() throws RecognitionException {
		int groupFunction_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:671:16: ( groupName LPAREN ( ALL | DISTINCT | PARTITION BY )? (c= functionArgument ( COMMA b= functionArgument )* )? ( orderByClause )? RPAREN )
			// parser\\sql\\SQLAnalyzer.g:672:3: groupName LPAREN ( ALL | DISTINCT | PARTITION BY )? (c= functionArgument ( COMMA b= functionArgument )* )? ( orderByClause )? RPAREN
			{
			pushFollow(FOLLOW_groupName_in_groupFunction3634);
			groupName();
			state._fsp--;
			if (state.failed) return;
			match(input,LPAREN,FOLLOW_LPAREN_in_groupFunction3636); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:673:5: ( ALL | DISTINCT | PARTITION BY )?
			int alt128=4;
			switch ( input.LA(1) ) {
				case ALL:
					{
					alt128=1;
					}
					break;
				case DISTINCT:
					{
					alt128=2;
					}
					break;
				case PARTITION:
					{
					alt128=3;
					}
					break;
			}
			switch (alt128) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:673:6: ALL
					{
					match(input,ALL,FOLLOW_ALL_in_groupFunction3644); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:673:12: DISTINCT
					{
					match(input,DISTINCT,FOLLOW_DISTINCT_in_groupFunction3648); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:673:23: PARTITION BY
					{
					match(input,PARTITION,FOLLOW_PARTITION_in_groupFunction3652); if (state.failed) return;
					match(input,BY,FOLLOW_BY_in_groupFunction3654); if (state.failed) return;
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:674:5: (c= functionArgument ( COMMA b= functionArgument )* )?
			int alt130=2;
			int LA130_0 = input.LA(1);
			if ( (LA130_0==AVG||LA130_0==AsciiStringLiteral||(LA130_0 >= CASE && LA130_0 <= CAST)||(LA130_0 >= CURRENT && LA130_0 <= CURRENT_TIMESTAMP)||(LA130_0 >= DASH && LA130_0 <= DECODE)||(LA130_0 >= DENSE && LA130_0 <= DESC)||LA130_0==EXTRACT||LA130_0==GROUP||LA130_0==HOUR||LA130_0==HexLiteral||(LA130_0 >= INT && LA130_0 <= INTERVAL)||(LA130_0 >= Integer && LA130_0 <= Iso8601DateTime)||LA130_0==LEFT||LA130_0==LPAREN||(LA130_0 >= MAX && LA130_0 <= MAccessDateTime)||LA130_0==MIN||LA130_0==MINUTE||LA130_0==MONTH||LA130_0==NEXT||LA130_0==NULL||LA130_0==NVL||LA130_0==NonQuotedIdentifier||LA130_0==OVER||(LA130_0 >= PLACEHOLDER && LA130_0 <= PLUS)||(LA130_0 >= QuotedIdentifier && LA130_0 <= RANK)||(LA130_0 >= RIGHT && LA130_0 <= ROW)||(LA130_0 >= Real && LA130_0 <= SECOND)||(LA130_0 >= SUBSTRING && LA130_0 <= SYSDATE)||(LA130_0 >= TIME && LA130_0 <= TIMESTAMP)||LA130_0==UPDATE||LA130_0==UicodeValueLiteral||LA130_0==UnicodeStringLiteral||LA130_0==VALUE||LA130_0==Variable||(LA130_0 >= YEAR && LA130_0 <= YEARS)) ) {
				alt130=1;
			}
			else if ( (LA130_0==ORDER) ) {
				int LA130_14 = input.LA(2);
				if ( (synpred185_SQLAnalyzer()) ) {
					alt130=1;
				}
			}
			switch (alt130) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:674:7: c= functionArgument ( COMMA b= functionArgument )*
					{
					pushFollow(FOLLOW_functionArgument_in_groupFunction3669);
					functionArgument();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:674:28: ( COMMA b= functionArgument )*
					loop129:
					while (true) {
						int alt129=2;
						int LA129_0 = input.LA(1);
						if ( (LA129_0==COMMA) ) {
							alt129=1;
						}

						switch (alt129) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:674:29: COMMA b= functionArgument
							{
							match(input,COMMA,FOLLOW_COMMA_in_groupFunction3672); if (state.failed) return;
							pushFollow(FOLLOW_functionArgument_in_groupFunction3678);
							functionArgument();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop129;
						}
					}

					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:675:5: ( orderByClause )?
			int alt131=2;
			int LA131_0 = input.LA(1);
			if ( (LA131_0==ORDER) ) {
				alt131=1;
			}
			switch (alt131) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:675:7: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_groupFunction3693);
					orderByClause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,RPAREN,FOLLOW_RPAREN_in_groupFunction3703); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 54, groupFunction_StartIndex); }

		}
	}
	// $ANTLR end "groupFunction"



	// $ANTLR start "caseFunction"
	// parser\\sql\\SQLAnalyzer.g:679:1: caseFunction : CASE (a= expression ( WHEN e= expression THEN f= expression )+ | ( WHEN e= searchCondition ( comparisonOperator expression )? THEN f= expression )+ ) ( ELSE e= expression )? END ( CASE )? ;
	public final void caseFunction() throws RecognitionException {
		int caseFunction_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:679:15: ( CASE (a= expression ( WHEN e= expression THEN f= expression )+ | ( WHEN e= searchCondition ( comparisonOperator expression )? THEN f= expression )+ ) ( ELSE e= expression )? END ( CASE )? )
			// parser\\sql\\SQLAnalyzer.g:680:3: CASE (a= expression ( WHEN e= expression THEN f= expression )+ | ( WHEN e= searchCondition ( comparisonOperator expression )? THEN f= expression )+ ) ( ELSE e= expression )? END ( CASE )?
			{
			match(input,CASE,FOLLOW_CASE_in_caseFunction3718); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:680:9: (a= expression ( WHEN e= expression THEN f= expression )+ | ( WHEN e= searchCondition ( comparisonOperator expression )? THEN f= expression )+ )
			int alt135=2;
			int LA135_0 = input.LA(1);
			if ( (LA135_0==AVG||LA135_0==AsciiStringLiteral||(LA135_0 >= CASE && LA135_0 <= CAST)||(LA135_0 >= CURRENT && LA135_0 <= CURRENT_TIMESTAMP)||(LA135_0 >= DASH && LA135_0 <= DECODE)||(LA135_0 >= DENSE && LA135_0 <= DESC)||LA135_0==EXTRACT||LA135_0==GROUP||LA135_0==HOUR||LA135_0==HexLiteral||(LA135_0 >= INT && LA135_0 <= INTERVAL)||(LA135_0 >= Integer && LA135_0 <= Iso8601DateTime)||LA135_0==LEFT||LA135_0==LPAREN||(LA135_0 >= MAX && LA135_0 <= MAccessDateTime)||LA135_0==MIN||LA135_0==MINUTE||LA135_0==MONTH||LA135_0==NEXT||LA135_0==NULL||LA135_0==NVL||LA135_0==NonQuotedIdentifier||LA135_0==ORDER||LA135_0==OVER||(LA135_0 >= PLACEHOLDER && LA135_0 <= PLUS)||(LA135_0 >= QuotedIdentifier && LA135_0 <= RANK)||(LA135_0 >= RIGHT && LA135_0 <= ROW)||(LA135_0 >= Real && LA135_0 <= SECOND)||(LA135_0 >= SUBSTRING && LA135_0 <= SYSDATE)||(LA135_0 >= TIME && LA135_0 <= TIMESTAMP)||LA135_0==UPDATE||LA135_0==UicodeValueLiteral||LA135_0==UnicodeStringLiteral||LA135_0==VALUE||LA135_0==Variable||(LA135_0 >= YEAR && LA135_0 <= YEARS)) ) {
				alt135=1;
			}
			else if ( (LA135_0==WHEN) ) {
				alt135=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 135, 0, input);
				throw nvae;
			}

			switch (alt135) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:681:5: a= expression ( WHEN e= expression THEN f= expression )+
					{
					pushFollow(FOLLOW_expression_in_caseFunction3731);
					expression();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:682:7: ( WHEN e= expression THEN f= expression )+
					int cnt132=0;
					loop132:
					while (true) {
						int alt132=2;
						int LA132_0 = input.LA(1);
						if ( (LA132_0==WHEN) ) {
							alt132=1;
						}

						switch (alt132) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:682:9: WHEN e= expression THEN f= expression
							{
							match(input,WHEN,FOLLOW_WHEN_in_caseFunction3742); if (state.failed) return;
							pushFollow(FOLLOW_expression_in_caseFunction3748);
							expression();
							state._fsp--;
							if (state.failed) return;
							match(input,THEN,FOLLOW_THEN_in_caseFunction3750); if (state.failed) return;
							pushFollow(FOLLOW_expression_in_caseFunction3756);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt132 >= 1 ) break loop132;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(132, input);
							throw eee;
						}
						cnt132++;
					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:684:11: ( WHEN e= searchCondition ( comparisonOperator expression )? THEN f= expression )+
					{
					// parser\\sql\\SQLAnalyzer.g:684:11: ( WHEN e= searchCondition ( comparisonOperator expression )? THEN f= expression )+
					int cnt134=0;
					loop134:
					while (true) {
						int alt134=2;
						int LA134_0 = input.LA(1);
						if ( (LA134_0==WHEN) ) {
							alt134=1;
						}

						switch (alt134) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:684:13: WHEN e= searchCondition ( comparisonOperator expression )? THEN f= expression
							{
							match(input,WHEN,FOLLOW_WHEN_in_caseFunction3776); if (state.failed) return;
							pushFollow(FOLLOW_searchCondition_in_caseFunction3782);
							searchCondition();
							state._fsp--;
							if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:684:38: ( comparisonOperator expression )?
							int alt133=2;
							int LA133_0 = input.LA(1);
							if ( (LA133_0==ASSIGNEQUAL||LA133_0==BETWEEN||(LA133_0 >= GREATERTHAN && LA133_0 <= GREATERTHANOREQUALTO1)||(LA133_0 >= LESSTHAN && LA133_0 <= LESSTHANOREQUALTO1)||(LA133_0 >= NOTEQUAL1 && LA133_0 <= NOTEQUAL2)) ) {
								alt133=1;
							}
							switch (alt133) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:684:39: comparisonOperator expression
									{
									pushFollow(FOLLOW_comparisonOperator_in_caseFunction3785);
									comparisonOperator();
									state._fsp--;
									if (state.failed) return;
									pushFollow(FOLLOW_expression_in_caseFunction3787);
									expression();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							match(input,THEN,FOLLOW_THEN_in_caseFunction3791); if (state.failed) return;
							pushFollow(FOLLOW_expression_in_caseFunction3797);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt134 >= 1 ) break loop134;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(134, input);
							throw eee;
						}
						cnt134++;
					}

					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:686:5: ( ELSE e= expression )?
			int alt136=2;
			int LA136_0 = input.LA(1);
			if ( (LA136_0==ELSE) ) {
				alt136=1;
			}
			switch (alt136) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:686:7: ELSE e= expression
					{
					match(input,ELSE,FOLLOW_ELSE_in_caseFunction3818); if (state.failed) return;
					pushFollow(FOLLOW_expression_in_caseFunction3824);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,END,FOLLOW_END_in_caseFunction3829); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:686:34: ( CASE )?
			int alt137=2;
			int LA137_0 = input.LA(1);
			if ( (LA137_0==CASE) ) {
				int LA137_1 = input.LA(2);
				if ( (synpred192_SQLAnalyzer()) ) {
					alt137=1;
				}
			}
			switch (alt137) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:686:36: CASE
					{
					match(input,CASE,FOLLOW_CASE_in_caseFunction3833); if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 55, caseFunction_StartIndex); }

		}
	}
	// $ANTLR end "caseFunction"



	// $ANTLR start "castFunction"
	// parser\\sql\\SQLAnalyzer.g:699:1: castFunction : CAST LPAREN e= expression AS t= expression ( LPAREN p= nonNegativeInteger ( COMMA p= nonNegativeInteger )? RPAREN )? RPAREN ;
	public final void castFunction() throws RecognitionException {
		int castFunction_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:699:15: ( CAST LPAREN e= expression AS t= expression ( LPAREN p= nonNegativeInteger ( COMMA p= nonNegativeInteger )? RPAREN )? RPAREN )
			// parser\\sql\\SQLAnalyzer.g:700:3: CAST LPAREN e= expression AS t= expression ( LPAREN p= nonNegativeInteger ( COMMA p= nonNegativeInteger )? RPAREN )? RPAREN
			{
			match(input,CAST,FOLLOW_CAST_in_castFunction3861); if (state.failed) return;
			match(input,LPAREN,FOLLOW_LPAREN_in_castFunction3863); if (state.failed) return;
			pushFollow(FOLLOW_expression_in_castFunction3869);
			expression();
			state._fsp--;
			if (state.failed) return;
			match(input,AS,FOLLOW_AS_in_castFunction3871); if (state.failed) return;
			pushFollow(FOLLOW_expression_in_castFunction3877);
			expression();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:701:5: ( LPAREN p= nonNegativeInteger ( COMMA p= nonNegativeInteger )? RPAREN )?
			int alt139=2;
			int LA139_0 = input.LA(1);
			if ( (LA139_0==LPAREN) ) {
				alt139=1;
			}
			switch (alt139) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:701:7: LPAREN p= nonNegativeInteger ( COMMA p= nonNegativeInteger )? RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_castFunction3886); if (state.failed) return;
					pushFollow(FOLLOW_nonNegativeInteger_in_castFunction3892);
					nonNegativeInteger();
					state._fsp--;
					if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:701:38: ( COMMA p= nonNegativeInteger )?
					int alt138=2;
					int LA138_0 = input.LA(1);
					if ( (LA138_0==COMMA) ) {
						alt138=1;
					}
					switch (alt138) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:701:40: COMMA p= nonNegativeInteger
							{
							match(input,COMMA,FOLLOW_COMMA_in_castFunction3897); if (state.failed) return;
							pushFollow(FOLLOW_nonNegativeInteger_in_castFunction3903);
							nonNegativeInteger();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_castFunction3908); if (state.failed) return;
					}
					break;

			}

			match(input,RPAREN,FOLLOW_RPAREN_in_castFunction3918); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 56, castFunction_StartIndex); }

		}
	}
	// $ANTLR end "castFunction"



	// $ANTLR start "sharpObject"
	// parser\\sql\\SQLAnalyzer.g:717:1: sharpObject : ( identifier DOT )? UicodeValueLiteral ;
	public final void sharpObject() throws RecognitionException {
		int sharpObject_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:717:13: ( ( identifier DOT )? UicodeValueLiteral )
			// parser\\sql\\SQLAnalyzer.g:718:3: ( identifier DOT )? UicodeValueLiteral
			{
			// parser\\sql\\SQLAnalyzer.g:718:3: ( identifier DOT )?
			int alt140=2;
			int LA140_0 = input.LA(1);
			if ( (LA140_0==AVG||(LA140_0 >= CURRENT && LA140_0 <= CURRENT_TIMESTAMP)||(LA140_0 >= DATE && LA140_0 <= DECODE)||(LA140_0 >= DENSE && LA140_0 <= DESC)||LA140_0==GROUP||LA140_0==HOUR||(LA140_0 >= INT && LA140_0 <= INTERVAL)||LA140_0==MAX||LA140_0==MIN||LA140_0==MINUTE||LA140_0==MONTH||LA140_0==NEXT||LA140_0==NVL||LA140_0==NonQuotedIdentifier||LA140_0==ORDER||LA140_0==OVER||(LA140_0 >= QuotedIdentifier && LA140_0 <= RANK)||LA140_0==ROW||LA140_0==SECOND||(LA140_0 >= SUM && LA140_0 <= SYSDATE)||(LA140_0 >= TIME && LA140_0 <= TIMESTAMP)||LA140_0==UPDATE||LA140_0==VALUE||(LA140_0 >= YEAR && LA140_0 <= YEARS)) ) {
				alt140=1;
			}
			switch (alt140) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:718:4: identifier DOT
					{
					pushFollow(FOLLOW_identifier_in_sharpObject3937);
					identifier();
					state._fsp--;
					if (state.failed) return;
					match(input,DOT,FOLLOW_DOT_in_sharpObject3939); if (state.failed) return;
					}
					break;

			}

			match(input,UicodeValueLiteral,FOLLOW_UicodeValueLiteral_in_sharpObject3943); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 57, sharpObject_StartIndex); }

		}
	}
	// $ANTLR end "sharpObject"


	public static class dbObject_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "dbObject"
	// parser\\sql\\SQLAnalyzer.g:721:1: dbObject : i= identifier ( DOT ic= identifier )? ;
	public final SQLAnalyzerParser.dbObject_return dbObject() throws RecognitionException {
		SQLAnalyzerParser.dbObject_return retval = new SQLAnalyzerParser.dbObject_return();
		retval.start = input.LT(1);
		int dbObject_StartIndex = input.index();

		ParserRuleReturnScope i =null;
		ParserRuleReturnScope ic =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }

			// parser\\sql\\SQLAnalyzer.g:721:11: (i= identifier ( DOT ic= identifier )? )
			// parser\\sql\\SQLAnalyzer.g:722:4: i= identifier ( DOT ic= identifier )?
			{
			pushFollow(FOLLOW_identifier_in_dbObject3963);
			i=identifier();
			state._fsp--;
			if (state.failed) return retval;
			// parser\\sql\\SQLAnalyzer.g:723:3: ( DOT ic= identifier )?
			int alt141=2;
			int LA141_0 = input.LA(1);
			if ( (LA141_0==DOT) ) {
				int LA141_1 = input.LA(2);
				if ( (synpred196_SQLAnalyzer()) ) {
					alt141=1;
				}
			}
			switch (alt141) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:723:5: DOT ic= identifier
					{
					match(input,DOT,FOLLOW_DOT_in_dbObject3972); if (state.failed) return retval;
					pushFollow(FOLLOW_identifier_in_dbObject3978);
					ic=identifier();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 58, dbObject_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "dbObject"



	// $ANTLR start "plusSignature"
	// parser\\sql\\SQLAnalyzer.g:729:1: plusSignature : LPAREN PLUS RPAREN ;
	public final void plusSignature() throws RecognitionException {
		int plusSignature_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:730:3: ( LPAREN PLUS RPAREN )
			// parser\\sql\\SQLAnalyzer.g:730:5: LPAREN PLUS RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_plusSignature3999); if (state.failed) return;
			match(input,PLUS,FOLLOW_PLUS_in_plusSignature4001); if (state.failed) return;
			match(input,RPAREN,FOLLOW_RPAREN_in_plusSignature4003); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 59, plusSignature_StartIndex); }

		}
	}
	// $ANTLR end "plusSignature"



	// $ANTLR start "stringLiteral"
	// parser\\sql\\SQLAnalyzer.g:735:1: stringLiteral : (s= singleStringLiteral )+ ;
	public final void stringLiteral() throws RecognitionException {
		int stringLiteral_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:735:16: ( (s= singleStringLiteral )+ )
			// parser\\sql\\SQLAnalyzer.g:736:3: (s= singleStringLiteral )+
			{
			// parser\\sql\\SQLAnalyzer.g:736:3: (s= singleStringLiteral )+
			int cnt142=0;
			loop142:
			while (true) {
				int alt142=2;
				int LA142_0 = input.LA(1);
				if ( (LA142_0==AsciiStringLiteral||LA142_0==UnicodeStringLiteral) ) {
					int LA142_2 = input.LA(2);
					if ( (synpred197_SQLAnalyzer()) ) {
						alt142=1;
					}

				}

				switch (alt142) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:736:4: s= singleStringLiteral
					{
					pushFollow(FOLLOW_singleStringLiteral_in_stringLiteral4025);
					singleStringLiteral();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt142 >= 1 ) break loop142;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(142, input);
					throw eee;
				}
				cnt142++;
			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 60, stringLiteral_StartIndex); }

		}
	}
	// $ANTLR end "stringLiteral"



	// $ANTLR start "singleStringLiteral"
	// parser\\sql\\SQLAnalyzer.g:739:1: singleStringLiteral : ( UnicodeStringLiteral | AsciiStringLiteral );
	public final void singleStringLiteral() throws RecognitionException {
		int singleStringLiteral_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:739:22: ( UnicodeStringLiteral | AsciiStringLiteral )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)==AsciiStringLiteral||input.LA(1)==UnicodeStringLiteral ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 61, singleStringLiteral_StartIndex); }

		}
	}
	// $ANTLR end "singleStringLiteral"


	public static class identifier_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "identifier"
	// parser\\sql\\SQLAnalyzer.g:744:1: identifier : ( NonQuotedIdentifier | QuotedIdentifier | DESC | ORDER | orderByClause | GROUP | groupByClause | groupName | datetimeField | db2Element | INTERVAL );
	public final SQLAnalyzerParser.identifier_return identifier() throws RecognitionException {
		SQLAnalyzerParser.identifier_return retval = new SQLAnalyzerParser.identifier_return();
		retval.start = input.LT(1);
		int identifier_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }

			// parser\\sql\\SQLAnalyzer.g:744:13: ( NonQuotedIdentifier | QuotedIdentifier | DESC | ORDER | orderByClause | GROUP | groupByClause | groupName | datetimeField | db2Element | INTERVAL )
			int alt143=11;
			switch ( input.LA(1) ) {
			case NonQuotedIdentifier:
				{
				alt143=1;
				}
				break;
			case QuotedIdentifier:
				{
				alt143=2;
				}
				break;
			case DESC:
				{
				alt143=3;
				}
				break;
			case ORDER:
				{
				int LA143_4 = input.LA(2);
				if ( (LA143_4==BY) ) {
					alt143=5;
				}
				else if ( (LA143_4==EOF||LA143_4==AND||(LA143_4 >= AS && LA143_4 <= AVG)||LA143_4==AsciiStringLiteral||LA143_4==BETWEEN||(LA143_4 >= CASE && LA143_4 <= CAST)||(LA143_4 >= COMMA && LA143_4 <= CURRENT_TIMESTAMP)||(LA143_4 >= DASH && LA143_4 <= DECODE)||(LA143_4 >= DENSE && LA143_4 <= DESC)||(LA143_4 >= DIVIDE && LA143_4 <= DOT_STAR)||(LA143_4 >= ELSE && LA143_4 <= ESCAPE)||LA143_4==EXTRACT||LA143_4==FETCH||(LA143_4 >= FOR && LA143_4 <= FULL)||(LA143_4 >= GREATERTHAN && LA143_4 <= GROUP)||(LA143_4 >= HAVING && LA143_4 <= HOUR)||(LA143_4 >= HexLiteral && LA143_4 <= INNER)||(LA143_4 >= INT && LA143_4 <= INTERVAL)||LA143_4==IS||(LA143_4 >= Integer && LA143_4 <= JOIN)||(LA143_4 >= LEFT && LA143_4 <= LPAREN)||(LA143_4 >= MAX && LA143_4 <= MAccessDateTime)||(LA143_4 >= MIN && LA143_4 <= MONTH)||(LA143_4 >= NEXT && LA143_4 <= NULLS)||LA143_4==NVL||LA143_4==NonQuotedIdentifier||(LA143_4 >= ON && LA143_4 <= ORDER)||LA143_4==OVER||(LA143_4 >= PLACEHOLDER && LA143_4 <= PLUS)||(LA143_4 >= QuotedIdentifier && LA143_4 <= RANK)||(LA143_4 >= RIGHT && LA143_4 <= RPAREN)||(LA143_4 >= Real && LA143_4 <= SET)||(LA143_4 >= STAR && LA143_4 <= SYSDATE)||(LA143_4 >= THEN && LA143_4 <= TIMESTAMP)||(LA143_4 >= UNION && LA143_4 <= UPDATE)||LA143_4==USING||LA143_4==UicodeValueLiteral||LA143_4==UnicodeStringLiteral||(LA143_4 >= VALUE && LA143_4 <= VALUES)||(LA143_4 >= Variable && LA143_4 <= WITH)||(LA143_4 >= YEAR && LA143_4 <= YEARS)) ) {
					alt143=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 143, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case GROUP:
				{
				int LA143_5 = input.LA(2);
				if ( (LA143_5==BY) ) {
					alt143=7;
				}
				else if ( (LA143_5==EOF||LA143_5==AND||(LA143_5 >= AS && LA143_5 <= AVG)||LA143_5==AsciiStringLiteral||LA143_5==BETWEEN||(LA143_5 >= CASE && LA143_5 <= CAST)||(LA143_5 >= COMMA && LA143_5 <= CURRENT_TIMESTAMP)||(LA143_5 >= DASH && LA143_5 <= DECODE)||(LA143_5 >= DENSE && LA143_5 <= DESC)||(LA143_5 >= DIVIDE && LA143_5 <= DOT_STAR)||(LA143_5 >= ELSE && LA143_5 <= ESCAPE)||LA143_5==EXTRACT||LA143_5==FETCH||(LA143_5 >= FOR && LA143_5 <= FULL)||(LA143_5 >= GREATERTHAN && LA143_5 <= GROUP)||(LA143_5 >= HAVING && LA143_5 <= HOUR)||(LA143_5 >= HexLiteral && LA143_5 <= INNER)||(LA143_5 >= INT && LA143_5 <= INTERVAL)||LA143_5==IS||(LA143_5 >= Integer && LA143_5 <= JOIN)||(LA143_5 >= LEFT && LA143_5 <= LPAREN)||(LA143_5 >= MAX && LA143_5 <= MAccessDateTime)||(LA143_5 >= MIN && LA143_5 <= MONTH)||(LA143_5 >= NEXT && LA143_5 <= NULLS)||LA143_5==NVL||LA143_5==NonQuotedIdentifier||(LA143_5 >= ON && LA143_5 <= ORDER)||LA143_5==OVER||(LA143_5 >= PLACEHOLDER && LA143_5 <= PLUS)||(LA143_5 >= QuotedIdentifier && LA143_5 <= RANK)||(LA143_5 >= RIGHT && LA143_5 <= RPAREN)||(LA143_5 >= Real && LA143_5 <= SET)||(LA143_5 >= STAR && LA143_5 <= SYSDATE)||(LA143_5 >= THEN && LA143_5 <= TIMESTAMP)||(LA143_5 >= UNION && LA143_5 <= UPDATE)||LA143_5==USING||LA143_5==UicodeValueLiteral||LA143_5==UnicodeStringLiteral||(LA143_5 >= VALUE && LA143_5 <= VALUES)||(LA143_5 >= Variable && LA143_5 <= WITH)||(LA143_5 >= YEAR && LA143_5 <= YEARS)) ) {
					alt143=6;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 143, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case AVG:
			case DECODE:
			case DENSE:
			case MAX:
			case MIN:
			case NVL:
			case OVER:
			case RANK:
			case ROW:
			case SUM:
			case TIME:
			case VALUE:
				{
				alt143=8;
				}
				break;
			case DATE:
				{
				int LA143_7 = input.LA(2);
				if ( (synpred206_SQLAnalyzer()) ) {
					alt143=8;
				}
				else if ( (synpred207_SQLAnalyzer()) ) {
					alt143=9;
				}
				else if ( (synpred208_SQLAnalyzer()) ) {
					alt143=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 143, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case TIMESTAMP:
				{
				int LA143_8 = input.LA(2);
				if ( (synpred206_SQLAnalyzer()) ) {
					alt143=8;
				}
				else if ( (synpred208_SQLAnalyzer()) ) {
					alt143=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 143, 8, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case MONTH:
				{
				int LA143_9 = input.LA(2);
				if ( (synpred206_SQLAnalyzer()) ) {
					alt143=8;
				}
				else if ( (synpred207_SQLAnalyzer()) ) {
					alt143=9;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 143, 9, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case INT:
				{
				int LA143_10 = input.LA(2);
				if ( (synpred206_SQLAnalyzer()) ) {
					alt143=8;
				}
				else if ( (synpred208_SQLAnalyzer()) ) {
					alt143=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 143, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case YEAR:
				{
				int LA143_11 = input.LA(2);
				if ( (synpred207_SQLAnalyzer()) ) {
					alt143=9;
				}
				else if ( (synpred208_SQLAnalyzer()) ) {
					alt143=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 143, 11, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case NEXT:
			case SYSDATE:
			case UPDATE:
			case YEARS:
				{
				alt143=10;
				}
				break;
			case DAY:
			case HOUR:
			case MINUTE:
			case SECOND:
				{
				alt143=9;
				}
				break;
			case INTERVAL:
				{
				alt143=11;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 143, 0, input);
				throw nvae;
			}
			switch (alt143) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:745:3: NonQuotedIdentifier
					{
					match(input,NonQuotedIdentifier,FOLLOW_NonQuotedIdentifier_in_identifier4064); if (state.failed) return retval;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:746:5: QuotedIdentifier
					{
					match(input,QuotedIdentifier,FOLLOW_QuotedIdentifier_in_identifier4071); if (state.failed) return retval;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:747:5: DESC
					{
					match(input,DESC,FOLLOW_DESC_in_identifier4077); if (state.failed) return retval;
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:748:5: ORDER
					{
					match(input,ORDER,FOLLOW_ORDER_in_identifier4083); if (state.failed) return retval;
					}
					break;
				case 5 :
					// parser\\sql\\SQLAnalyzer.g:749:5: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_identifier4089);
					orderByClause();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 6 :
					// parser\\sql\\SQLAnalyzer.g:750:5: GROUP
					{
					match(input,GROUP,FOLLOW_GROUP_in_identifier4096); if (state.failed) return retval;
					}
					break;
				case 7 :
					// parser\\sql\\SQLAnalyzer.g:751:5: groupByClause
					{
					pushFollow(FOLLOW_groupByClause_in_identifier4103);
					groupByClause();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 8 :
					// parser\\sql\\SQLAnalyzer.g:752:5: groupName
					{
					pushFollow(FOLLOW_groupName_in_identifier4109);
					groupName();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 9 :
					// parser\\sql\\SQLAnalyzer.g:753:5: datetimeField
					{
					pushFollow(FOLLOW_datetimeField_in_identifier4115);
					datetimeField();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 10 :
					// parser\\sql\\SQLAnalyzer.g:754:5: db2Element
					{
					pushFollow(FOLLOW_db2Element_in_identifier4121);
					db2Element();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 11 :
					// parser\\sql\\SQLAnalyzer.g:755:5: INTERVAL
					{
					match(input,INTERVAL,FOLLOW_INTERVAL_in_identifier4127); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 62, identifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "identifier"



	// $ANTLR start "typeIdentifier"
	// parser\\sql\\SQLAnalyzer.g:758:1: typeIdentifier : NonQuotedIdentifier ;
	public final void typeIdentifier() throws RecognitionException {
		int typeIdentifier_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:758:17: ( NonQuotedIdentifier )
			// parser\\sql\\SQLAnalyzer.g:759:3: NonQuotedIdentifier
			{
			match(input,NonQuotedIdentifier,FOLLOW_NonQuotedIdentifier_in_typeIdentifier4140); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 63, typeIdentifier_StartIndex); }

		}
	}
	// $ANTLR end "typeIdentifier"



	// $ANTLR start "constant"
	// parser\\sql\\SQLAnalyzer.g:762:1: constant : (i= nonNegativeInteger | Real | NULL |s= stringLiteral |j= intervalLiteral | HexLiteral | MAccessDateTime | Iso8601DateTime | TIMESTAMP s= stringLiteral );
	public final void constant() throws RecognitionException {
		int constant_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:762:11: (i= nonNegativeInteger | Real | NULL |s= stringLiteral |j= intervalLiteral | HexLiteral | MAccessDateTime | Iso8601DateTime | TIMESTAMP s= stringLiteral )
			int alt144=9;
			switch ( input.LA(1) ) {
			case Integer:
				{
				alt144=1;
				}
				break;
			case Real:
				{
				alt144=2;
				}
				break;
			case NULL:
				{
				alt144=3;
				}
				break;
			case AsciiStringLiteral:
			case UnicodeStringLiteral:
				{
				alt144=4;
				}
				break;
			case INTERVAL:
				{
				alt144=5;
				}
				break;
			case HexLiteral:
				{
				alt144=6;
				}
				break;
			case MAccessDateTime:
				{
				alt144=7;
				}
				break;
			case Iso8601DateTime:
				{
				alt144=8;
				}
				break;
			case TIMESTAMP:
				{
				alt144=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 144, 0, input);
				throw nvae;
			}
			switch (alt144) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:763:3: i= nonNegativeInteger
					{
					pushFollow(FOLLOW_nonNegativeInteger_in_constant4159);
					nonNegativeInteger();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:764:5: Real
					{
					match(input,Real,FOLLOW_Real_in_constant4166); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:765:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_constant4173); if (state.failed) return;
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:766:5: s= stringLiteral
					{
					pushFollow(FOLLOW_stringLiteral_in_constant4184);
					stringLiteral();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// parser\\sql\\SQLAnalyzer.g:767:5: j= intervalLiteral
					{
					pushFollow(FOLLOW_intervalLiteral_in_constant4195);
					intervalLiteral();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 6 :
					// parser\\sql\\SQLAnalyzer.g:768:5: HexLiteral
					{
					match(input,HexLiteral,FOLLOW_HexLiteral_in_constant4202); if (state.failed) return;
					}
					break;
				case 7 :
					// parser\\sql\\SQLAnalyzer.g:770:5: MAccessDateTime
					{
					match(input,MAccessDateTime,FOLLOW_MAccessDateTime_in_constant4212); if (state.failed) return;
					}
					break;
				case 8 :
					// parser\\sql\\SQLAnalyzer.g:772:5: Iso8601DateTime
					{
					match(input,Iso8601DateTime,FOLLOW_Iso8601DateTime_in_constant4222); if (state.failed) return;
					}
					break;
				case 9 :
					// parser\\sql\\SQLAnalyzer.g:773:5: TIMESTAMP s= stringLiteral
					{
					match(input,TIMESTAMP,FOLLOW_TIMESTAMP_in_constant4229); if (state.failed) return;
					pushFollow(FOLLOW_stringLiteral_in_constant4235);
					stringLiteral();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 64, constant_StartIndex); }

		}
	}
	// $ANTLR end "constant"



	// $ANTLR start "intervalLiteral"
	// parser\\sql\\SQLAnalyzer.g:777:1: intervalLiteral : INTERVAL (u= unaryOperator )? AsciiStringLiteral d= datetimeField ( LPAREN Integer RPAREN )? ;
	public final void intervalLiteral() throws RecognitionException {
		int intervalLiteral_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:777:18: ( INTERVAL (u= unaryOperator )? AsciiStringLiteral d= datetimeField ( LPAREN Integer RPAREN )? )
			// parser\\sql\\SQLAnalyzer.g:778:3: INTERVAL (u= unaryOperator )? AsciiStringLiteral d= datetimeField ( LPAREN Integer RPAREN )?
			{
			match(input,INTERVAL,FOLLOW_INTERVAL_in_intervalLiteral4253); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:778:12: (u= unaryOperator )?
			int alt145=2;
			int LA145_0 = input.LA(1);
			if ( (LA145_0==DASH||LA145_0==PLUS) ) {
				alt145=1;
			}
			switch (alt145) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:778:14: u= unaryOperator
					{
					pushFollow(FOLLOW_unaryOperator_in_intervalLiteral4261);
					unaryOperator();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,AsciiStringLiteral,FOLLOW_AsciiStringLiteral_in_intervalLiteral4267); if (state.failed) return;
			pushFollow(FOLLOW_datetimeField_in_intervalLiteral4274);
			datetimeField();
			state._fsp--;
			if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:778:75: ( LPAREN Integer RPAREN )?
			int alt146=2;
			int LA146_0 = input.LA(1);
			if ( (LA146_0==LPAREN) ) {
				int LA146_1 = input.LA(2);
				if ( (LA146_1==Integer) ) {
					int LA146_3 = input.LA(3);
					if ( (LA146_3==RPAREN) ) {
						int LA146_4 = input.LA(4);
						if ( (synpred218_SQLAnalyzer()) ) {
							alt146=1;
						}
					}
				}
			}
			switch (alt146) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:778:77: LPAREN Integer RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_intervalLiteral4279); if (state.failed) return;
					match(input,Integer,FOLLOW_Integer_in_intervalLiteral4281); if (state.failed) return;
					match(input,RPAREN,FOLLOW_RPAREN_in_intervalLiteral4284); if (state.failed) return;
					}
					break;

			}

			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 65, intervalLiteral_StartIndex); }

		}
	}
	// $ANTLR end "intervalLiteral"



	// $ANTLR start "nonNegativeInteger"
	// parser\\sql\\SQLAnalyzer.g:781:1: nonNegativeInteger : Integer ;
	public final void nonNegativeInteger() throws RecognitionException {
		int nonNegativeInteger_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:781:21: ( Integer )
			// parser\\sql\\SQLAnalyzer.g:782:3: Integer
			{
			match(input,Integer,FOLLOW_Integer_in_nonNegativeInteger4301); if (state.failed) return;
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 66, nonNegativeInteger_StartIndex); }

		}
	}
	// $ANTLR end "nonNegativeInteger"



	// $ANTLR start "unaryOperator"
	// parser\\sql\\SQLAnalyzer.g:785:1: unaryOperator : ( PLUS | DASH );
	public final void unaryOperator() throws RecognitionException {
		int unaryOperator_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:785:16: ( PLUS | DASH )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)==DASH||input.LA(1)==PLUS ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 67, unaryOperator_StartIndex); }

		}
	}
	// $ANTLR end "unaryOperator"



	// $ANTLR start "additiveOperator"
	// parser\\sql\\SQLAnalyzer.g:790:1: additiveOperator : ( PLUS | DASH | STRCONCAT );
	public final void additiveOperator() throws RecognitionException {
		int additiveOperator_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:790:19: ( PLUS | DASH | STRCONCAT )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)==DASH||input.LA(1)==PLUS||input.LA(1)==STRCONCAT ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 68, additiveOperator_StartIndex); }

		}
	}
	// $ANTLR end "additiveOperator"



	// $ANTLR start "multiplicativeArithmeticOperator"
	// parser\\sql\\SQLAnalyzer.g:796:1: multiplicativeArithmeticOperator : ( STAR | DIVIDE | MOD );
	public final void multiplicativeArithmeticOperator() throws RecognitionException {
		int multiplicativeArithmeticOperator_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:796:34: ( STAR | DIVIDE | MOD )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)==DIVIDE||input.LA(1)==MOD||input.LA(1)==STAR ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 69, multiplicativeArithmeticOperator_StartIndex); }

		}
	}
	// $ANTLR end "multiplicativeArithmeticOperator"



	// $ANTLR start "comparisonOperator"
	// parser\\sql\\SQLAnalyzer.g:802:1: comparisonOperator : ( ASSIGNEQUAL | NOTEQUAL1 | NOTEQUAL2 | LESSTHAN | LESSTHANOREQUALTO1 | GREATERTHANOREQUALTO1 | GREATERTHAN | BETWEEN subExpression AND );
	public final void comparisonOperator() throws RecognitionException {
		int comparisonOperator_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:802:21: ( ASSIGNEQUAL | NOTEQUAL1 | NOTEQUAL2 | LESSTHAN | LESSTHANOREQUALTO1 | GREATERTHANOREQUALTO1 | GREATERTHAN | BETWEEN subExpression AND )
			int alt147=8;
			switch ( input.LA(1) ) {
			case ASSIGNEQUAL:
				{
				alt147=1;
				}
				break;
			case NOTEQUAL1:
				{
				alt147=2;
				}
				break;
			case NOTEQUAL2:
				{
				alt147=3;
				}
				break;
			case LESSTHAN:
				{
				alt147=4;
				}
				break;
			case LESSTHANOREQUALTO1:
				{
				alt147=5;
				}
				break;
			case GREATERTHANOREQUALTO1:
				{
				alt147=6;
				}
				break;
			case GREATERTHAN:
				{
				alt147=7;
				}
				break;
			case BETWEEN:
				{
				alt147=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 147, 0, input);
				throw nvae;
			}
			switch (alt147) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:803:3: ASSIGNEQUAL
					{
					match(input,ASSIGNEQUAL,FOLLOW_ASSIGNEQUAL_in_comparisonOperator4402); if (state.failed) return;
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:804:5: NOTEQUAL1
					{
					match(input,NOTEQUAL1,FOLLOW_NOTEQUAL1_in_comparisonOperator4409); if (state.failed) return;
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:805:5: NOTEQUAL2
					{
					match(input,NOTEQUAL2,FOLLOW_NOTEQUAL2_in_comparisonOperator4416); if (state.failed) return;
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:806:5: LESSTHAN
					{
					match(input,LESSTHAN,FOLLOW_LESSTHAN_in_comparisonOperator4423); if (state.failed) return;
					}
					break;
				case 5 :
					// parser\\sql\\SQLAnalyzer.g:807:5: LESSTHANOREQUALTO1
					{
					match(input,LESSTHANOREQUALTO1,FOLLOW_LESSTHANOREQUALTO1_in_comparisonOperator4430); if (state.failed) return;
					}
					break;
				case 6 :
					// parser\\sql\\SQLAnalyzer.g:808:5: GREATERTHANOREQUALTO1
					{
					match(input,GREATERTHANOREQUALTO1,FOLLOW_GREATERTHANOREQUALTO1_in_comparisonOperator4436); if (state.failed) return;
					}
					break;
				case 7 :
					// parser\\sql\\SQLAnalyzer.g:809:5: GREATERTHAN
					{
					match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_comparisonOperator4443); if (state.failed) return;
					}
					break;
				case 8 :
					// parser\\sql\\SQLAnalyzer.g:810:5: BETWEEN subExpression AND
					{
					match(input,BETWEEN,FOLLOW_BETWEEN_in_comparisonOperator4450); if (state.failed) return;
					pushFollow(FOLLOW_subExpression_in_comparisonOperator4452);
					subExpression();
					state._fsp--;
					if (state.failed) return;
					match(input,AND,FOLLOW_AND_in_comparisonOperator4454); if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 70, comparisonOperator_StartIndex); }

		}
	}
	// $ANTLR end "comparisonOperator"



	// $ANTLR start "unionOperator"
	// parser\\sql\\SQLAnalyzer.g:813:1: unionOperator : ( UNION ( ALL )? | MINUS );
	public final void unionOperator() throws RecognitionException {
		int unionOperator_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:813:16: ( UNION ( ALL )? | MINUS )
			int alt149=2;
			int LA149_0 = input.LA(1);
			if ( (LA149_0==UNION) ) {
				alt149=1;
			}
			else if ( (LA149_0==MINUS) ) {
				alt149=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 149, 0, input);
				throw nvae;
			}

			switch (alt149) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:814:3: UNION ( ALL )?
					{
					match(input,UNION,FOLLOW_UNION_in_unionOperator4469); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:815:3: ( ALL )?
					int alt148=2;
					int LA148_0 = input.LA(1);
					if ( (LA148_0==ALL) ) {
						alt148=1;
					}
					switch (alt148) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:815:5: ALL
							{
							match(input,ALL,FOLLOW_ALL_in_unionOperator4476); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:816:5: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_unionOperator4485); if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 71, unionOperator_StartIndex); }

		}
	}
	// $ANTLR end "unionOperator"



	// $ANTLR start "datetimeField"
	// parser\\sql\\SQLAnalyzer.g:819:1: datetimeField : ( YEAR | MONTH | DAY | HOUR | MINUTE | SECOND | DATE );
	public final void datetimeField() throws RecognitionException {
		int datetimeField_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:819:16: ( YEAR | MONTH | DAY | HOUR | MINUTE | SECOND | DATE )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( (input.LA(1) >= DATE && input.LA(1) <= DAY)||input.LA(1)==HOUR||input.LA(1)==MINUTE||input.LA(1)==MONTH||input.LA(1)==SECOND||input.LA(1)==YEAR ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 72, datetimeField_StartIndex); }

		}
	}
	// $ANTLR end "datetimeField"



	// $ANTLR start "db2Element"
	// parser\\sql\\SQLAnalyzer.g:828:1: db2Element : ( CURRENT ( TIMESTAMP | DATE | TIME ) | UPDATE ( TIMESTAMP | DATE | TIME ) | CURRENT | TIMESTAMP | SYSDATE | DATE | INT | YEARS | YEAR | CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | NEXT VALUE FOR );
	public final void db2Element() throws RecognitionException {
		int db2Element_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return; }

			// parser\\sql\\SQLAnalyzer.g:828:13: ( CURRENT ( TIMESTAMP | DATE | TIME ) | UPDATE ( TIMESTAMP | DATE | TIME ) | CURRENT | TIMESTAMP | SYSDATE | DATE | INT | YEARS | YEAR | CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | NEXT VALUE FOR )
			int alt150=13;
			switch ( input.LA(1) ) {
			case CURRENT:
				{
				switch ( input.LA(2) ) {
				case DATE:
					{
					int LA150_13 = input.LA(3);
					if ( (synpred241_SQLAnalyzer()) ) {
						alt150=1;
					}
					else if ( (synpred245_SQLAnalyzer()) ) {
						alt150=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 150, 13, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case EOF:
				case AND:
				case AS:
				case ASC:
				case ASSIGNEQUAL:
				case AVG:
				case AsciiStringLiteral:
				case BETWEEN:
				case CASE:
				case CAST:
				case COMMA:
				case CONNECT:
				case CROSS:
				case CURRENT:
				case CURRENT_DATE:
				case CURRENT_TIME:
				case CURRENT_TIMESTAMP:
				case DASH:
				case DAY:
				case DECODE:
				case DENSE:
				case DESC:
				case DIVIDE:
				case DOT:
				case DOT_STAR:
				case ELSE:
				case END:
				case ESCAPE:
				case EXTRACT:
				case FETCH:
				case FOR:
				case FROM:
				case FULL:
				case GREATERTHAN:
				case GREATERTHANOREQUALTO1:
				case GROUP:
				case HAVING:
				case HOUR:
				case HexLiteral:
				case IN:
				case INNER:
				case INT:
				case INTERVAL:
				case IS:
				case Integer:
				case Iso8601DateTime:
				case JOIN:
				case LEFT:
				case LESSTHAN:
				case LESSTHANOREQUALTO1:
				case LIKE:
				case LPAREN:
				case MAX:
				case MAccessDateTime:
				case MIN:
				case MINUS:
				case MINUTE:
				case MOD:
				case MONTH:
				case NEXT:
				case NOT:
				case NOTEQUAL1:
				case NOTEQUAL2:
				case NULL:
				case NULLS:
				case NVL:
				case NonQuotedIdentifier:
				case ON:
				case ONLY:
				case OPTIMIZE:
				case OR:
				case ORDER:
				case OVER:
				case PLACEHOLDER:
				case PLUS:
				case QuotedIdentifier:
				case RANK:
				case RIGHT:
				case ROW:
				case ROWS:
				case RPAREN:
				case Real:
				case SECOND:
				case SELECT:
				case SEMICOLON:
				case SET:
				case STAR:
				case START:
				case STRCONCAT:
				case SUBSTRING:
				case SUM:
				case SYSDATE:
				case THEN:
				case UNION:
				case UPDATE:
				case USING:
				case UicodeValueLiteral:
				case UnicodeStringLiteral:
				case VALUE:
				case VALUES:
				case Variable:
				case WHEN:
				case WHERE:
				case WITH:
				case YEAR:
				case YEARS:
					{
					alt150=3;
					}
					break;
				case TIME:
					{
					int LA150_15 = input.LA(3);
					if ( (synpred241_SQLAnalyzer()) ) {
						alt150=1;
					}
					else if ( (synpred245_SQLAnalyzer()) ) {
						alt150=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 150, 15, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case TIMESTAMP:
					{
					int LA150_16 = input.LA(3);
					if ( (synpred241_SQLAnalyzer()) ) {
						alt150=1;
					}
					else if ( (synpred245_SQLAnalyzer()) ) {
						alt150=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 150, 16, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 150, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case UPDATE:
				{
				alt150=2;
				}
				break;
			case TIMESTAMP:
				{
				alt150=4;
				}
				break;
			case SYSDATE:
				{
				alt150=5;
				}
				break;
			case DATE:
				{
				alt150=6;
				}
				break;
			case INT:
				{
				alt150=7;
				}
				break;
			case YEARS:
				{
				alt150=8;
				}
				break;
			case YEAR:
				{
				alt150=9;
				}
				break;
			case CURRENT_DATE:
				{
				alt150=10;
				}
				break;
			case CURRENT_TIME:
				{
				alt150=11;
				}
				break;
			case CURRENT_TIMESTAMP:
				{
				alt150=12;
				}
				break;
			case NEXT:
				{
				alt150=13;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 150, 0, input);
				throw nvae;
			}
			switch (alt150) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:829:3: CURRENT ( TIMESTAMP | DATE | TIME )
					{
					match(input,CURRENT,FOLLOW_CURRENT_in_db2Element4554); if (state.failed) return;
					if ( input.LA(1)==DATE||(input.LA(1) >= TIME && input.LA(1) <= TIMESTAMP) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:830:5: UPDATE ( TIMESTAMP | DATE | TIME )
					{
					match(input,UPDATE,FOLLOW_UPDATE_in_db2Element4572); if (state.failed) return;
					if ( input.LA(1)==DATE||(input.LA(1) >= TIME && input.LA(1) <= TIMESTAMP) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:831:5: CURRENT
					{
					match(input,CURRENT,FOLLOW_CURRENT_in_db2Element4590); if (state.failed) return;
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:832:5: TIMESTAMP
					{
					match(input,TIMESTAMP,FOLLOW_TIMESTAMP_in_db2Element4596); if (state.failed) return;
					}
					break;
				case 5 :
					// parser\\sql\\SQLAnalyzer.g:833:5: SYSDATE
					{
					match(input,SYSDATE,FOLLOW_SYSDATE_in_db2Element4602); if (state.failed) return;
					}
					break;
				case 6 :
					// parser\\sql\\SQLAnalyzer.g:834:5: DATE
					{
					match(input,DATE,FOLLOW_DATE_in_db2Element4608); if (state.failed) return;
					}
					break;
				case 7 :
					// parser\\sql\\SQLAnalyzer.g:835:5: INT
					{
					match(input,INT,FOLLOW_INT_in_db2Element4614); if (state.failed) return;
					}
					break;
				case 8 :
					// parser\\sql\\SQLAnalyzer.g:836:5: YEARS
					{
					match(input,YEARS,FOLLOW_YEARS_in_db2Element4620); if (state.failed) return;
					}
					break;
				case 9 :
					// parser\\sql\\SQLAnalyzer.g:837:5: YEAR
					{
					match(input,YEAR,FOLLOW_YEAR_in_db2Element4626); if (state.failed) return;
					}
					break;
				case 10 :
					// parser\\sql\\SQLAnalyzer.g:838:5: CURRENT_DATE
					{
					match(input,CURRENT_DATE,FOLLOW_CURRENT_DATE_in_db2Element4632); if (state.failed) return;
					}
					break;
				case 11 :
					// parser\\sql\\SQLAnalyzer.g:839:5: CURRENT_TIME
					{
					match(input,CURRENT_TIME,FOLLOW_CURRENT_TIME_in_db2Element4638); if (state.failed) return;
					}
					break;
				case 12 :
					// parser\\sql\\SQLAnalyzer.g:840:5: CURRENT_TIMESTAMP
					{
					match(input,CURRENT_TIMESTAMP,FOLLOW_CURRENT_TIMESTAMP_in_db2Element4644); if (state.failed) return;
					}
					break;
				case 13 :
					// parser\\sql\\SQLAnalyzer.g:841:5: NEXT VALUE FOR
					{
					match(input,NEXT,FOLLOW_NEXT_in_db2Element4650); if (state.failed) return;
					match(input,VALUE,FOLLOW_VALUE_in_db2Element4652); if (state.failed) return;
					match(input,FOR,FOLLOW_FOR_in_db2Element4654); if (state.failed) return;
					}
					break;

			}
		}
		 catch (RecognitionException re) { throw re; } 
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 73, db2Element_StartIndex); }

		}
	}
	// $ANTLR end "db2Element"

	// $ANTLR start synpred14_SQLAnalyzer
	public final void synpred14_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope c =null;

		// parser\\sql\\SQLAnalyzer.g:126:6: ( LPAREN c= columnNameList RPAREN )
		// parser\\sql\\SQLAnalyzer.g:126:6: LPAREN c= columnNameList RPAREN
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred14_SQLAnalyzer228); if (state.failed) return;
		pushFollow(FOLLOW_columnNameList_in_synpred14_SQLAnalyzer234);
		c=columnNameList();
		state._fsp--;
		if (state.failed) return;
		match(input,RPAREN,FOLLOW_RPAREN_in_synpred14_SQLAnalyzer236); if (state.failed) return;
		}

	}
	// $ANTLR end synpred14_SQLAnalyzer

	// $ANTLR start synpred31_SQLAnalyzer
	public final void synpred31_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:188:9: ( selectStatement )
		// parser\\sql\\SQLAnalyzer.g:188:9: selectStatement
		{
		pushFollow(FOLLOW_selectStatement_in_synpred31_SQLAnalyzer624);
		selectStatement();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred31_SQLAnalyzer

	// $ANTLR start synpred35_SQLAnalyzer
	public final void synpred35_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:190:11: ( ( COMMA )? subExpression )
		// parser\\sql\\SQLAnalyzer.g:190:11: ( COMMA )? subExpression
		{
		// parser\\sql\\SQLAnalyzer.g:190:11: ( COMMA )?
		int alt160=2;
		int LA160_0 = input.LA(1);
		if ( (LA160_0==COMMA) ) {
			alt160=1;
		}
		switch (alt160) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:190:12: COMMA
				{
				match(input,COMMA,FOLLOW_COMMA_in_synpred35_SQLAnalyzer663); if (state.failed) return;
				}
				break;

		}

		pushFollow(FOLLOW_subExpression_in_synpred35_SQLAnalyzer667);
		subExpression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred35_SQLAnalyzer

	// $ANTLR start synpred37_SQLAnalyzer
	public final void synpred37_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:189:11: ( ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN )
		// parser\\sql\\SQLAnalyzer.g:189:11: ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+ RPAREN
		{
		// parser\\sql\\SQLAnalyzer.g:189:11: ( ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )* )+
		int cnt167=0;
		loop167:
		while (true) {
			int alt167=2;
			int LA167_0 = input.LA(1);
			if ( (LA167_0==COMMA||LA167_0==LPAREN||LA167_0==VALUES) ) {
				alt167=1;
			}

			switch (alt167) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:189:12: ( VALUES | COMMA )? LPAREN ( ( COMMA )? subExpression )*
				{
				// parser\\sql\\SQLAnalyzer.g:189:12: ( VALUES | COMMA )?
				int alt164=2;
				int LA164_0 = input.LA(1);
				if ( (LA164_0==COMMA||LA164_0==VALUES) ) {
					alt164=1;
				}
				switch (alt164) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:
						{
						if ( input.LA(1)==COMMA||input.LA(1)==VALUES ) {
							input.consume();
							state.errorRecovery=false;
							state.failed=false;
						}
						else {
							if (state.backtracking>0) {state.failed=true; return;}
							MismatchedSetException mse = new MismatchedSetException(null,input);
							throw mse;
						}
						}
						break;

				}

				match(input,LPAREN,FOLLOW_LPAREN_in_synpred37_SQLAnalyzer647); if (state.failed) return;
				// parser\\sql\\SQLAnalyzer.g:189:37: ( ( COMMA )? subExpression )*
				loop166:
				while (true) {
					int alt166=2;
					switch ( input.LA(1) ) {
					case COMMA:
						{
						int LA166_2 = input.LA(2);
						if ( (synpred35_SQLAnalyzer()) ) {
							alt166=1;
						}

						}
						break;
					case LPAREN:
						{
						int LA166_3 = input.LA(2);
						if ( (synpred35_SQLAnalyzer()) ) {
							alt166=1;
						}

						}
						break;
					case AVG:
					case AsciiStringLiteral:
					case CASE:
					case CAST:
					case CURRENT:
					case CURRENT_DATE:
					case CURRENT_TIME:
					case CURRENT_TIMESTAMP:
					case DASH:
					case DATE:
					case DAY:
					case DECODE:
					case DENSE:
					case DESC:
					case EXTRACT:
					case GROUP:
					case HOUR:
					case HexLiteral:
					case INT:
					case INTERVAL:
					case Integer:
					case Iso8601DateTime:
					case LEFT:
					case MAX:
					case MAccessDateTime:
					case MIN:
					case MINUTE:
					case MONTH:
					case NEXT:
					case NULL:
					case NVL:
					case NonQuotedIdentifier:
					case ORDER:
					case OVER:
					case PLACEHOLDER:
					case PLUS:
					case QuotedIdentifier:
					case RANK:
					case RIGHT:
					case ROW:
					case Real:
					case SECOND:
					case SUBSTRING:
					case SUM:
					case SYSDATE:
					case TIME:
					case TIMESTAMP:
					case UPDATE:
					case UicodeValueLiteral:
					case UnicodeStringLiteral:
					case VALUE:
					case Variable:
					case YEAR:
					case YEARS:
						{
						alt166=1;
						}
						break;
					}
					switch (alt166) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:190:11: ( COMMA )? subExpression
						{
						// parser\\sql\\SQLAnalyzer.g:190:11: ( COMMA )?
						int alt165=2;
						int LA165_0 = input.LA(1);
						if ( (LA165_0==COMMA) ) {
							alt165=1;
						}
						switch (alt165) {
							case 1 :
								// parser\\sql\\SQLAnalyzer.g:190:12: COMMA
								{
								match(input,COMMA,FOLLOW_COMMA_in_synpred37_SQLAnalyzer663); if (state.failed) return;
								}
								break;

						}

						pushFollow(FOLLOW_subExpression_in_synpred37_SQLAnalyzer667);
						subExpression();
						state._fsp--;
						if (state.failed) return;
						}
						break;

					default :
						break loop166;
					}
				}

				}
				break;

			default :
				if ( cnt167 >= 1 ) break loop167;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(167, input);
				throw eee;
			}
			cnt167++;
		}

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred37_SQLAnalyzer674); if (state.failed) return;
		}

	}
	// $ANTLR end synpred37_SQLAnalyzer

	// $ANTLR start synpred44_SQLAnalyzer
	public final void synpred44_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:247:5: (u= unionOperator s= subQueryExpression )
		// parser\\sql\\SQLAnalyzer.g:247:5: u= unionOperator s= subQueryExpression
		{
		pushFollow(FOLLOW_unionOperator_in_synpred44_SQLAnalyzer905);
		unionOperator();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_subQueryExpression_in_synpred44_SQLAnalyzer915);
		subQueryExpression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred44_SQLAnalyzer

	// $ANTLR start synpred45_SQLAnalyzer
	public final void synpred45_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:250:7: (o= orderByClause )
		// parser\\sql\\SQLAnalyzer.g:250:7: o= orderByClause
		{
		pushFollow(FOLLOW_orderByClause_in_synpred45_SQLAnalyzer933);
		orderByClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred45_SQLAnalyzer

	// $ANTLR start synpred46_SQLAnalyzer
	public final void synpred46_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:251:5: ( fetchClause )
		// parser\\sql\\SQLAnalyzer.g:251:5: fetchClause
		{
		pushFollow(FOLLOW_fetchClause_in_synpred46_SQLAnalyzer942);
		fetchClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred46_SQLAnalyzer

	// $ANTLR start synpred47_SQLAnalyzer
	public final void synpred47_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:252:5: ( optimizeClause )
		// parser\\sql\\SQLAnalyzer.g:252:5: optimizeClause
		{
		pushFollow(FOLLOW_optimizeClause_in_synpred47_SQLAnalyzer951);
		optimizeClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred47_SQLAnalyzer

	// $ANTLR start synpred48_SQLAnalyzer
	public final void synpred48_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:253:5: ( withClause )
		// parser\\sql\\SQLAnalyzer.g:253:5: withClause
		{
		pushFollow(FOLLOW_withClause_in_synpred48_SQLAnalyzer960);
		withClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred48_SQLAnalyzer

	// $ANTLR start synpred49_SQLAnalyzer
	public final void synpred49_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:254:5: ( startClause )
		// parser\\sql\\SQLAnalyzer.g:254:5: startClause
		{
		pushFollow(FOLLOW_startClause_in_synpred49_SQLAnalyzer969);
		startClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred49_SQLAnalyzer

	// $ANTLR start synpred52_SQLAnalyzer
	public final void synpred52_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:265:5: (w= whereClause )
		// parser\\sql\\SQLAnalyzer.g:265:5: w= whereClause
		{
		pushFollow(FOLLOW_whereClause_in_synpred52_SQLAnalyzer1051);
		whereClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred52_SQLAnalyzer

	// $ANTLR start synpred53_SQLAnalyzer
	public final void synpred53_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:266:5: (g= groupByClause )
		// parser\\sql\\SQLAnalyzer.g:266:5: g= groupByClause
		{
		pushFollow(FOLLOW_groupByClause_in_synpred53_SQLAnalyzer1065);
		groupByClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred53_SQLAnalyzer

	// $ANTLR start synpred54_SQLAnalyzer
	public final void synpred54_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:267:7: (h= havingClause )
		// parser\\sql\\SQLAnalyzer.g:267:7: h= havingClause
		{
		pushFollow(FOLLOW_havingClause_in_synpred54_SQLAnalyzer1080);
		havingClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred54_SQLAnalyzer

	// $ANTLR start synpred55_SQLAnalyzer
	public final void synpred55_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:268:7: (o= orderByClause )
		// parser\\sql\\SQLAnalyzer.g:268:7: o= orderByClause
		{
		pushFollow(FOLLOW_orderByClause_in_synpred55_SQLAnalyzer1096);
		orderByClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred55_SQLAnalyzer

	// $ANTLR start synpred56_SQLAnalyzer
	public final void synpred56_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:269:5: ( fetchClause )
		// parser\\sql\\SQLAnalyzer.g:269:5: fetchClause
		{
		pushFollow(FOLLOW_fetchClause_in_synpred56_SQLAnalyzer1105);
		fetchClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred56_SQLAnalyzer

	// $ANTLR start synpred57_SQLAnalyzer
	public final void synpred57_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:270:5: ( optimizeClause )
		// parser\\sql\\SQLAnalyzer.g:270:5: optimizeClause
		{
		pushFollow(FOLLOW_optimizeClause_in_synpred57_SQLAnalyzer1114);
		optimizeClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred57_SQLAnalyzer

	// $ANTLR start synpred58_SQLAnalyzer
	public final void synpred58_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:271:5: ( withClause )
		// parser\\sql\\SQLAnalyzer.g:271:5: withClause
		{
		pushFollow(FOLLOW_withClause_in_synpred58_SQLAnalyzer1123);
		withClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred58_SQLAnalyzer

	// $ANTLR start synpred59_SQLAnalyzer
	public final void synpred59_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:272:5: ( startClause )
		// parser\\sql\\SQLAnalyzer.g:272:5: startClause
		{
		pushFollow(FOLLOW_startClause_in_synpred59_SQLAnalyzer1132);
		startClause();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred59_SQLAnalyzer

	// $ANTLR start synpred62_SQLAnalyzer
	public final void synpred62_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:290:5: ( COMMA e= orderExpression )
		// parser\\sql\\SQLAnalyzer.g:290:5: COMMA e= orderExpression
		{
		match(input,COMMA,FOLLOW_COMMA_in_synpred62_SQLAnalyzer1231); if (state.failed) return;
		pushFollow(FOLLOW_orderExpression_in_synpred62_SQLAnalyzer1237);
		orderExpression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred62_SQLAnalyzer

	// $ANTLR start synpred63_SQLAnalyzer
	public final void synpred63_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:295:5: ( ASC )
		// parser\\sql\\SQLAnalyzer.g:295:5: ASC
		{
		match(input,ASC,FOLLOW_ASC_in_synpred63_SQLAnalyzer1267); if (state.failed) return;
		}

	}
	// $ANTLR end synpred63_SQLAnalyzer

	// $ANTLR start synpred64_SQLAnalyzer
	public final void synpred64_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:295:11: ( DESC )
		// parser\\sql\\SQLAnalyzer.g:295:11: DESC
		{
		match(input,DESC,FOLLOW_DESC_in_synpred64_SQLAnalyzer1271); if (state.failed) return;
		}

	}
	// $ANTLR end synpred64_SQLAnalyzer

	// $ANTLR start synpred65_SQLAnalyzer
	public final void synpred65_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:295:19: ( NULLS FIRST )
		// parser\\sql\\SQLAnalyzer.g:295:19: NULLS FIRST
		{
		match(input,NULLS,FOLLOW_NULLS_in_synpred65_SQLAnalyzer1276); if (state.failed) return;
		match(input,FIRST,FOLLOW_FIRST_in_synpred65_SQLAnalyzer1278); if (state.failed) return;
		}

	}
	// $ANTLR end synpred65_SQLAnalyzer

	// $ANTLR start synpred67_SQLAnalyzer
	public final void synpred67_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:301:22: ( COMMA ie= expression )
		// parser\\sql\\SQLAnalyzer.g:301:22: COMMA ie= expression
		{
		match(input,COMMA,FOLLOW_COMMA_in_synpred67_SQLAnalyzer1323); if (state.failed) return;
		pushFollow(FOLLOW_expression_in_synpred67_SQLAnalyzer1330);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred67_SQLAnalyzer

	// $ANTLR start synpred74_SQLAnalyzer
	public final void synpred74_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:330:7: ( OR r= additiveSubSearchCondition )
		// parser\\sql\\SQLAnalyzer.g:330:7: OR r= additiveSubSearchCondition
		{
		match(input,OR,FOLLOW_OR_in_synpred74_SQLAnalyzer1494); if (state.failed) return;
		pushFollow(FOLLOW_additiveSubSearchCondition_in_synpred74_SQLAnalyzer1500);
		additiveSubSearchCondition();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred74_SQLAnalyzer

	// $ANTLR start synpred75_SQLAnalyzer
	public final void synpred75_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:336:7: ( AND r= subSearchCondition )
		// parser\\sql\\SQLAnalyzer.g:336:7: AND r= subSearchCondition
		{
		match(input,AND,FOLLOW_AND_in_synpred75_SQLAnalyzer1534); if (state.failed) return;
		pushFollow(FOLLOW_subSearchCondition_in_synpred75_SQLAnalyzer1540);
		subSearchCondition();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred75_SQLAnalyzer

	// $ANTLR start synpred77_SQLAnalyzer
	public final void synpred77_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:346:5: ( bracketedSearchCondition )
		// parser\\sql\\SQLAnalyzer.g:346:6: bracketedSearchCondition
		{
		pushFollow(FOLLOW_bracketedSearchCondition_in_synpred77_SQLAnalyzer1599);
		bracketedSearchCondition();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred77_SQLAnalyzer

	// $ANTLR start synpred78_SQLAnalyzer
	public final void synpred78_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:347:38: ( comparisonOperator expression )
		// parser\\sql\\SQLAnalyzer.g:347:38: comparisonOperator expression
		{
		pushFollow(FOLLOW_comparisonOperator_in_synpred78_SQLAnalyzer1618);
		comparisonOperator();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_expression_in_synpred78_SQLAnalyzer1620);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred78_SQLAnalyzer

	// $ANTLR start synpred82_SQLAnalyzer
	public final void synpred82_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:356:11: (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) )
		// parser\\sql\\SQLAnalyzer.g:356:11: o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN )
		{
		pushFollow(FOLLOW_comparisonOperator_in_synpred82_SQLAnalyzer1696);
		comparisonOperator();
		state._fsp--;
		if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:356:34: (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN )
		int alt180=2;
		int LA180_0 = input.LA(1);
		if ( (LA180_0==AVG||LA180_0==AsciiStringLiteral||(LA180_0 >= CASE && LA180_0 <= CAST)||(LA180_0 >= CURRENT && LA180_0 <= CURRENT_TIMESTAMP)||(LA180_0 >= DASH && LA180_0 <= DECODE)||(LA180_0 >= DENSE && LA180_0 <= DESC)||LA180_0==EXTRACT||LA180_0==GROUP||LA180_0==HOUR||LA180_0==HexLiteral||(LA180_0 >= INT && LA180_0 <= INTERVAL)||(LA180_0 >= Integer && LA180_0 <= Iso8601DateTime)||LA180_0==LEFT||LA180_0==LPAREN||(LA180_0 >= MAX && LA180_0 <= MAccessDateTime)||LA180_0==MIN||LA180_0==MINUTE||LA180_0==MONTH||LA180_0==NEXT||LA180_0==NULL||LA180_0==NVL||LA180_0==NonQuotedIdentifier||LA180_0==ORDER||LA180_0==OVER||(LA180_0 >= PLACEHOLDER && LA180_0 <= PLUS)||(LA180_0 >= QuotedIdentifier && LA180_0 <= RANK)||(LA180_0 >= RIGHT && LA180_0 <= ROW)||(LA180_0 >= Real && LA180_0 <= SECOND)||(LA180_0 >= SUBSTRING && LA180_0 <= SYSDATE)||(LA180_0 >= TIME && LA180_0 <= TIMESTAMP)||LA180_0==UPDATE||LA180_0==UicodeValueLiteral||LA180_0==UnicodeStringLiteral||LA180_0==VALUE||LA180_0==Variable||(LA180_0 >= YEAR && LA180_0 <= YEARS)) ) {
			alt180=1;
		}
		else if ( (LA180_0==ALL||LA180_0==ANY||LA180_0==SOME) ) {
			alt180=2;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 180, 0, input);
			throw nvae;
		}

		switch (alt180) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:357:17: r= expression ( plusSignature )?
				{
				pushFollow(FOLLOW_expression_in_synpred82_SQLAnalyzer1720);
				expression();
				state._fsp--;
				if (state.failed) return;
				// parser\\sql\\SQLAnalyzer.g:357:32: ( plusSignature )?
				int alt179=2;
				int LA179_0 = input.LA(1);
				if ( (LA179_0==LPAREN) ) {
					alt179=1;
				}
				switch (alt179) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:357:33: plusSignature
						{
						pushFollow(FOLLOW_plusSignature_in_synpred82_SQLAnalyzer1723);
						plusSignature();
						state._fsp--;
						if (state.failed) return;
						}
						break;

				}

				}
				break;
			case 2 :
				// parser\\sql\\SQLAnalyzer.g:358:9: q= quantifierSpec LPAREN s= selectStatement RPAREN
				{
				pushFollow(FOLLOW_quantifierSpec_in_synpred82_SQLAnalyzer1739);
				quantifierSpec();
				state._fsp--;
				if (state.failed) return;
				match(input,LPAREN,FOLLOW_LPAREN_in_synpred82_SQLAnalyzer1749); if (state.failed) return;
				pushFollow(FOLLOW_selectStatement_in_synpred82_SQLAnalyzer1755);
				selectStatement();
				state._fsp--;
				if (state.failed) return;
				match(input,RPAREN,FOLLOW_RPAREN_in_synpred82_SQLAnalyzer1757); if (state.failed) return;
				}
				break;

		}

		}

	}
	// $ANTLR end synpred82_SQLAnalyzer

	// $ANTLR start synpred89_SQLAnalyzer
	public final void synpred89_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:367:14: ( LPAREN )
		// parser\\sql\\SQLAnalyzer.g:367:14: LPAREN
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred89_SQLAnalyzer1887); if (state.failed) return;
		}

	}
	// $ANTLR end synpred89_SQLAnalyzer

	// $ANTLR start synpred90_SQLAnalyzer
	public final void synpred90_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:368:9: ( selectStatement )
		// parser\\sql\\SQLAnalyzer.g:368:11: selectStatement
		{
		pushFollow(FOLLOW_selectStatement_in_synpred90_SQLAnalyzer1904);
		selectStatement();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred90_SQLAnalyzer

	// $ANTLR start synpred93_SQLAnalyzer
	public final void synpred93_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:371:13: ( COMMA e= expression )
		// parser\\sql\\SQLAnalyzer.g:371:13: COMMA e= expression
		{
		match(input,COMMA,FOLLOW_COMMA_in_synpred93_SQLAnalyzer1965); if (state.failed) return;
		pushFollow(FOLLOW_expression_in_synpred93_SQLAnalyzer1971);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred93_SQLAnalyzer

	// $ANTLR start synpred94_SQLAnalyzer
	public final void synpred94_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:372:13: ( RPAREN )
		// parser\\sql\\SQLAnalyzer.g:372:13: RPAREN
		{
		match(input,RPAREN,FOLLOW_RPAREN_in_synpred94_SQLAnalyzer1988); if (state.failed) return;
		}

	}
	// $ANTLR end synpred94_SQLAnalyzer

	// $ANTLR start synpred95_SQLAnalyzer
	public final void synpred95_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:354:5: (l= expression ( plusSignature )? (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) | IS ( NOT )? NULL | ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? ) ) )
		// parser\\sql\\SQLAnalyzer.g:354:5: l= expression ( plusSignature )? (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) | IS ( NOT )? NULL | ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? ) )
		{
		pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1664);
		expression();
		state._fsp--;
		if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:354:21: ( plusSignature )?
		int alt183=2;
		int LA183_0 = input.LA(1);
		if ( (LA183_0==LPAREN) ) {
			alt183=1;
		}
		switch (alt183) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:354:22: plusSignature
				{
				pushFollow(FOLLOW_plusSignature_in_synpred95_SQLAnalyzer1668);
				plusSignature();
				state._fsp--;
				if (state.failed) return;
				}
				break;

		}

		// parser\\sql\\SQLAnalyzer.g:355:4: (o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN ) | IS ( NOT )? NULL | ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? ) )
		int alt195=3;
		switch ( input.LA(1) ) {
		case ASSIGNEQUAL:
		case GREATERTHAN:
		case GREATERTHANOREQUALTO1:
		case LESSTHAN:
		case LESSTHANOREQUALTO1:
		case NOTEQUAL1:
		case NOTEQUAL2:
			{
			alt195=1;
			}
			break;
		case BETWEEN:
			{
			int LA195_8 = input.LA(2);
			if ( (synpred82_SQLAnalyzer()) ) {
				alt195=1;
			}
			else if ( (true) ) {
				alt195=3;
			}

			}
			break;
		case IS:
			{
			alt195=2;
			}
			break;
		case IN:
		case LIKE:
		case NOT:
			{
			alt195=3;
			}
			break;
		default:
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 195, 0, input);
			throw nvae;
		}
		switch (alt195) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:356:11: o= comparisonOperator (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN )
				{
				pushFollow(FOLLOW_comparisonOperator_in_synpred95_SQLAnalyzer1696);
				comparisonOperator();
				state._fsp--;
				if (state.failed) return;
				// parser\\sql\\SQLAnalyzer.g:356:34: (r= expression ( plusSignature )? |q= quantifierSpec LPAREN s= selectStatement RPAREN )
				int alt185=2;
				int LA185_0 = input.LA(1);
				if ( (LA185_0==AVG||LA185_0==AsciiStringLiteral||(LA185_0 >= CASE && LA185_0 <= CAST)||(LA185_0 >= CURRENT && LA185_0 <= CURRENT_TIMESTAMP)||(LA185_0 >= DASH && LA185_0 <= DECODE)||(LA185_0 >= DENSE && LA185_0 <= DESC)||LA185_0==EXTRACT||LA185_0==GROUP||LA185_0==HOUR||LA185_0==HexLiteral||(LA185_0 >= INT && LA185_0 <= INTERVAL)||(LA185_0 >= Integer && LA185_0 <= Iso8601DateTime)||LA185_0==LEFT||LA185_0==LPAREN||(LA185_0 >= MAX && LA185_0 <= MAccessDateTime)||LA185_0==MIN||LA185_0==MINUTE||LA185_0==MONTH||LA185_0==NEXT||LA185_0==NULL||LA185_0==NVL||LA185_0==NonQuotedIdentifier||LA185_0==ORDER||LA185_0==OVER||(LA185_0 >= PLACEHOLDER && LA185_0 <= PLUS)||(LA185_0 >= QuotedIdentifier && LA185_0 <= RANK)||(LA185_0 >= RIGHT && LA185_0 <= ROW)||(LA185_0 >= Real && LA185_0 <= SECOND)||(LA185_0 >= SUBSTRING && LA185_0 <= SYSDATE)||(LA185_0 >= TIME && LA185_0 <= TIMESTAMP)||LA185_0==UPDATE||LA185_0==UicodeValueLiteral||LA185_0==UnicodeStringLiteral||LA185_0==VALUE||LA185_0==Variable||(LA185_0 >= YEAR && LA185_0 <= YEARS)) ) {
					alt185=1;
				}
				else if ( (LA185_0==ALL||LA185_0==ANY||LA185_0==SOME) ) {
					alt185=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					NoViableAltException nvae =
						new NoViableAltException("", 185, 0, input);
					throw nvae;
				}

				switch (alt185) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:357:17: r= expression ( plusSignature )?
						{
						pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1720);
						expression();
						state._fsp--;
						if (state.failed) return;
						// parser\\sql\\SQLAnalyzer.g:357:32: ( plusSignature )?
						int alt184=2;
						int LA184_0 = input.LA(1);
						if ( (LA184_0==LPAREN) ) {
							alt184=1;
						}
						switch (alt184) {
							case 1 :
								// parser\\sql\\SQLAnalyzer.g:357:33: plusSignature
								{
								pushFollow(FOLLOW_plusSignature_in_synpred95_SQLAnalyzer1723);
								plusSignature();
								state._fsp--;
								if (state.failed) return;
								}
								break;

						}

						}
						break;
					case 2 :
						// parser\\sql\\SQLAnalyzer.g:358:9: q= quantifierSpec LPAREN s= selectStatement RPAREN
						{
						pushFollow(FOLLOW_quantifierSpec_in_synpred95_SQLAnalyzer1739);
						quantifierSpec();
						state._fsp--;
						if (state.failed) return;
						match(input,LPAREN,FOLLOW_LPAREN_in_synpred95_SQLAnalyzer1749); if (state.failed) return;
						pushFollow(FOLLOW_selectStatement_in_synpred95_SQLAnalyzer1755);
						selectStatement();
						state._fsp--;
						if (state.failed) return;
						match(input,RPAREN,FOLLOW_RPAREN_in_synpred95_SQLAnalyzer1757); if (state.failed) return;
						}
						break;

				}

				}
				break;
			case 2 :
				// parser\\sql\\SQLAnalyzer.g:361:7: IS ( NOT )? NULL
				{
				match(input,IS,FOLLOW_IS_in_synpred95_SQLAnalyzer1780); if (state.failed) return;
				// parser\\sql\\SQLAnalyzer.g:362:7: ( NOT )?
				int alt186=2;
				int LA186_0 = input.LA(1);
				if ( (LA186_0==NOT) ) {
					alt186=1;
				}
				switch (alt186) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:362:9: NOT
						{
						match(input,NOT,FOLLOW_NOT_in_synpred95_SQLAnalyzer1791); if (state.failed) return;
						}
						break;

				}

				match(input,NULL,FOLLOW_NULL_in_synpred95_SQLAnalyzer1796); if (state.failed) return;
				}
				break;
			case 3 :
				// parser\\sql\\SQLAnalyzer.g:363:7: ( NOT )? ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? )
				{
				// parser\\sql\\SQLAnalyzer.g:363:7: ( NOT )?
				int alt187=2;
				int LA187_0 = input.LA(1);
				if ( (LA187_0==NOT) ) {
					alt187=1;
				}
				switch (alt187) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:363:9: NOT
						{
						match(input,NOT,FOLLOW_NOT_in_synpred95_SQLAnalyzer1806); if (state.failed) return;
						}
						break;

				}

				// parser\\sql\\SQLAnalyzer.g:363:16: ( LIKE e= expression ( ESCAPE f= expression )? | BETWEEN e= expression AND f= expression | IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )? )
				int alt194=3;
				switch ( input.LA(1) ) {
				case LIKE:
					{
					alt194=1;
					}
					break;
				case BETWEEN:
					{
					alt194=2;
					}
					break;
				case IN:
					{
					alt194=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return;}
					NoViableAltException nvae =
						new NoViableAltException("", 194, 0, input);
					throw nvae;
				}
				switch (alt194) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:364:7: LIKE e= expression ( ESCAPE f= expression )?
						{
						match(input,LIKE,FOLLOW_LIKE_in_synpred95_SQLAnalyzer1819); if (state.failed) return;
						pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1825);
						expression();
						state._fsp--;
						if (state.failed) return;
						// parser\\sql\\SQLAnalyzer.g:365:9: ( ESCAPE f= expression )?
						int alt188=2;
						int LA188_0 = input.LA(1);
						if ( (LA188_0==ESCAPE) ) {
							alt188=1;
						}
						switch (alt188) {
							case 1 :
								// parser\\sql\\SQLAnalyzer.g:365:11: ESCAPE f= expression
								{
								match(input,ESCAPE,FOLLOW_ESCAPE_in_synpred95_SQLAnalyzer1838); if (state.failed) return;
								pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1844);
								expression();
								state._fsp--;
								if (state.failed) return;
								}
								break;

						}

						}
						break;
					case 2 :
						// parser\\sql\\SQLAnalyzer.g:366:9: BETWEEN e= expression AND f= expression
						{
						match(input,BETWEEN,FOLLOW_BETWEEN_in_synpred95_SQLAnalyzer1858); if (state.failed) return;
						pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1864);
						expression();
						state._fsp--;
						if (state.failed) return;
						match(input,AND,FOLLOW_AND_in_synpred95_SQLAnalyzer1866); if (state.failed) return;
						pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1872);
						expression();
						state._fsp--;
						if (state.failed) return;
						}
						break;
					case 3 :
						// parser\\sql\\SQLAnalyzer.g:367:9: IN ( LPAREN )? ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* ) ( RPAREN )?
						{
						match(input,IN,FOLLOW_IN_in_synpred95_SQLAnalyzer1883); if (state.failed) return;
						// parser\\sql\\SQLAnalyzer.g:367:12: ( LPAREN )?
						int alt189=2;
						int LA189_0 = input.LA(1);
						if ( (LA189_0==LPAREN) ) {
							int LA189_1 = input.LA(2);
							if ( (synpred89_SQLAnalyzer()) ) {
								alt189=1;
							}
						}
						switch (alt189) {
							case 1 :
								// parser\\sql\\SQLAnalyzer.g:367:14: LPAREN
								{
								match(input,LPAREN,FOLLOW_LPAREN_in_synpred95_SQLAnalyzer1887); if (state.failed) return;
								}
								break;

						}

						// parser\\sql\\SQLAnalyzer.g:367:24: ( ( selectStatement )=>s= selectStatement | ( VALUES | COMMA )? e= expression ( COMMA e= expression )* )
						int alt192=2;
						int LA192_0 = input.LA(1);
						if ( (LA192_0==SELECT) && (synpred90_SQLAnalyzer())) {
							alt192=1;
						}
						else if ( (LA192_0==LPAREN) ) {
							int LA192_2 = input.LA(2);
							if ( (synpred90_SQLAnalyzer()) ) {
								alt192=1;
							}
							else if ( (true) ) {
								alt192=2;
							}

						}
						else if ( (LA192_0==AVG||LA192_0==AsciiStringLiteral||(LA192_0 >= CASE && LA192_0 <= CAST)||LA192_0==COMMA||(LA192_0 >= CURRENT && LA192_0 <= CURRENT_TIMESTAMP)||(LA192_0 >= DASH && LA192_0 <= DECODE)||(LA192_0 >= DENSE && LA192_0 <= DESC)||LA192_0==EXTRACT||LA192_0==GROUP||LA192_0==HOUR||LA192_0==HexLiteral||(LA192_0 >= INT && LA192_0 <= INTERVAL)||(LA192_0 >= Integer && LA192_0 <= Iso8601DateTime)||LA192_0==LEFT||(LA192_0 >= MAX && LA192_0 <= MAccessDateTime)||LA192_0==MIN||LA192_0==MINUTE||LA192_0==MONTH||LA192_0==NEXT||LA192_0==NULL||LA192_0==NVL||LA192_0==NonQuotedIdentifier||LA192_0==ORDER||LA192_0==OVER||(LA192_0 >= PLACEHOLDER && LA192_0 <= PLUS)||(LA192_0 >= QuotedIdentifier && LA192_0 <= RANK)||(LA192_0 >= RIGHT && LA192_0 <= ROW)||(LA192_0 >= Real && LA192_0 <= SECOND)||(LA192_0 >= SUBSTRING && LA192_0 <= SYSDATE)||(LA192_0 >= TIME && LA192_0 <= TIMESTAMP)||LA192_0==UPDATE||LA192_0==UicodeValueLiteral||LA192_0==UnicodeStringLiteral||(LA192_0 >= VALUE && LA192_0 <= VALUES)||LA192_0==Variable||(LA192_0 >= YEAR && LA192_0 <= YEARS)) ) {
							alt192=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							NoViableAltException nvae =
								new NoViableAltException("", 192, 0, input);
							throw nvae;
						}

						switch (alt192) {
							case 1 :
								// parser\\sql\\SQLAnalyzer.g:368:9: ( selectStatement )=>s= selectStatement
								{
								pushFollow(FOLLOW_selectStatement_in_synpred95_SQLAnalyzer1924);
								selectStatement();
								state._fsp--;
								if (state.failed) return;
								}
								break;
							case 2 :
								// parser\\sql\\SQLAnalyzer.g:370:11: ( VALUES | COMMA )? e= expression ( COMMA e= expression )*
								{
								// parser\\sql\\SQLAnalyzer.g:370:11: ( VALUES | COMMA )?
								int alt190=2;
								int LA190_0 = input.LA(1);
								if ( (LA190_0==COMMA||LA190_0==VALUES) ) {
									alt190=1;
								}
								switch (alt190) {
									case 1 :
										// parser\\sql\\SQLAnalyzer.g:
										{
										if ( input.LA(1)==COMMA||input.LA(1)==VALUES ) {
											input.consume();
											state.errorRecovery=false;
											state.failed=false;
										}
										else {
											if (state.backtracking>0) {state.failed=true; return;}
											MismatchedSetException mse = new MismatchedSetException(null,input);
											throw mse;
										}
										}
										break;

								}

								pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1950);
								expression();
								state._fsp--;
								if (state.failed) return;
								// parser\\sql\\SQLAnalyzer.g:371:11: ( COMMA e= expression )*
								loop191:
								while (true) {
									int alt191=2;
									int LA191_0 = input.LA(1);
									if ( (LA191_0==COMMA) ) {
										alt191=1;
									}

									switch (alt191) {
									case 1 :
										// parser\\sql\\SQLAnalyzer.g:371:13: COMMA e= expression
										{
										match(input,COMMA,FOLLOW_COMMA_in_synpred95_SQLAnalyzer1965); if (state.failed) return;
										pushFollow(FOLLOW_expression_in_synpred95_SQLAnalyzer1971);
										expression();
										state._fsp--;
										if (state.failed) return;
										}
										break;

									default :
										break loop191;
									}
								}

								}
								break;

						}

						// parser\\sql\\SQLAnalyzer.g:372:11: ( RPAREN )?
						int alt193=2;
						int LA193_0 = input.LA(1);
						if ( (LA193_0==RPAREN) ) {
							alt193=1;
						}
						switch (alt193) {
							case 1 :
								// parser\\sql\\SQLAnalyzer.g:372:13: RPAREN
								{
								match(input,RPAREN,FOLLOW_RPAREN_in_synpred95_SQLAnalyzer1988); if (state.failed) return;
								}
								break;

						}

						}
						break;

				}

				}
				break;

		}

		}

	}
	// $ANTLR end synpred95_SQLAnalyzer

	// $ANTLR start synpred97_SQLAnalyzer
	public final void synpred97_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:374:9: ( function )
		// parser\\sql\\SQLAnalyzer.g:374:9: function
		{
		pushFollow(FOLLOW_function_in_synpred97_SQLAnalyzer2025);
		function();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred97_SQLAnalyzer

	// $ANTLR start synpred100_SQLAnalyzer
	public final void synpred100_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:386:7: ( COMMA t= selectItem )
		// parser\\sql\\SQLAnalyzer.g:386:7: COMMA t= selectItem
		{
		match(input,COMMA,FOLLOW_COMMA_in_synpred100_SQLAnalyzer2091); if (state.failed) return;
		pushFollow(FOLLOW_selectItem_in_synpred100_SQLAnalyzer2097);
		selectItem();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred100_SQLAnalyzer

	// $ANTLR start synpred102_SQLAnalyzer
	public final void synpred102_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:391:5: ( dbObject DOT_STAR )
		// parser\\sql\\SQLAnalyzer.g:391:5: dbObject DOT_STAR
		{
		pushFollow(FOLLOW_dbObject_in_synpred102_SQLAnalyzer2121);
		dbObject();
		state._fsp--;
		if (state.failed) return;
		match(input,DOT_STAR,FOLLOW_DOT_STAR_in_synpred102_SQLAnalyzer2123); if (state.failed) return;
		}

	}
	// $ANTLR end synpred102_SQLAnalyzer

	// $ANTLR start synpred103_SQLAnalyzer
	public final void synpred103_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:393:5: ( alias2 )
		// parser\\sql\\SQLAnalyzer.g:393:6: alias2
		{
		pushFollow(FOLLOW_alias2_in_synpred103_SQLAnalyzer2139);
		alias2();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred103_SQLAnalyzer

	// $ANTLR start synpred104_SQLAnalyzer
	public final void synpred104_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:396:7: ( tableColumns )
		// parser\\sql\\SQLAnalyzer.g:396:8: tableColumns
		{
		pushFollow(FOLLOW_tableColumns_in_synpred104_SQLAnalyzer2178);
		tableColumns();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred104_SQLAnalyzer

	// $ANTLR start synpred105_SQLAnalyzer
	public final void synpred105_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:397:25: ( db2Element )
		// parser\\sql\\SQLAnalyzer.g:397:25: db2Element
		{
		pushFollow(FOLLOW_db2Element_in_synpred105_SQLAnalyzer2204);
		db2Element();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred105_SQLAnalyzer

	// $ANTLR start synpred106_SQLAnalyzer
	public final void synpred106_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope a =null;

		// parser\\sql\\SQLAnalyzer.g:397:40: (a= alias1 )
		// parser\\sql\\SQLAnalyzer.g:397:40: a= alias1
		{
		pushFollow(FOLLOW_alias1_in_synpred106_SQLAnalyzer2214);
		a=alias1();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred106_SQLAnalyzer

	// $ANTLR start synpred108_SQLAnalyzer
	public final void synpred108_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:403:5: ( COMMA t= tableSource )
		// parser\\sql\\SQLAnalyzer.g:403:5: COMMA t= tableSource
		{
		match(input,COMMA,FOLLOW_COMMA_in_synpred108_SQLAnalyzer2252); if (state.failed) return;
		pushFollow(FOLLOW_tableSource_in_synpred108_SQLAnalyzer2258);
		tableSource();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred108_SQLAnalyzer

	// $ANTLR start synpred109_SQLAnalyzer
	public final void synpred109_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:408:5: (t= joinedTable )
		// parser\\sql\\SQLAnalyzer.g:408:5: t= joinedTable
		{
		pushFollow(FOLLOW_joinedTable_in_synpred109_SQLAnalyzer2290);
		joinedTable();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred109_SQLAnalyzer

	// $ANTLR start synpred110_SQLAnalyzer
	public final void synpred110_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:413:5: ( joinedTables )
		// parser\\sql\\SQLAnalyzer.g:413:6: joinedTables
		{
		pushFollow(FOLLOW_joinedTables_in_synpred110_SQLAnalyzer2317);
		joinedTables();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred110_SQLAnalyzer

	// $ANTLR start synpred111_SQLAnalyzer
	public final void synpred111_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope al =null;

		// parser\\sql\\SQLAnalyzer.g:415:35: (al= alias1 )
		// parser\\sql\\SQLAnalyzer.g:415:35: al= alias1
		{
		pushFollow(FOLLOW_alias1_in_synpred111_SQLAnalyzer2356);
		al=alias1();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred111_SQLAnalyzer

	// $ANTLR start synpred112_SQLAnalyzer
	public final void synpred112_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope al =null;

		// parser\\sql\\SQLAnalyzer.g:412:3: ( LPAREN ( ( joinedTables )=>t= joinedTables RPAREN |q= queryExpression RPAREN (al= alias1 )? ) )
		// parser\\sql\\SQLAnalyzer.g:412:3: LPAREN ( ( joinedTables )=>t= joinedTables RPAREN |q= queryExpression RPAREN (al= alias1 )? )
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred112_SQLAnalyzer2308); if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:412:10: ( ( joinedTables )=>t= joinedTables RPAREN |q= queryExpression RPAREN (al= alias1 )? )
		int alt197=2;
		int LA197_0 = input.LA(1);
		if ( (LA197_0==LPAREN) ) {
			int LA197_1 = input.LA(2);
			if ( (synpred110_SQLAnalyzer()) ) {
				alt197=1;
			}
			else if ( (true) ) {
				alt197=2;
			}

		}
		else if ( (LA197_0==SUBSTRING) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==EXTRACT) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==NonQuotedIdentifier) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==LEFT) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==RIGHT) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==QuotedIdentifier) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==DESC) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==ORDER) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==GROUP) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==MAX) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==SUM) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==AVG) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==MIN) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==NVL) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==DATE) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==TIME) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==TIMESTAMP) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==MONTH) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==INT) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==VALUE) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==OVER) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==ROW) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==DENSE) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==RANK) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==DECODE) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==YEAR) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==CURRENT) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==UPDATE) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==SYSDATE) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==YEARS) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==DAY||LA197_0==HOUR||LA197_0==MINUTE||LA197_0==SECOND) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==CURRENT_DATE) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==CURRENT_TIME) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==CURRENT_TIMESTAMP) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==NEXT) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==INTERVAL) && (synpred110_SQLAnalyzer())) {
			alt197=1;
		}
		else if ( (LA197_0==SELECT) ) {
			alt197=2;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 197, 0, input);
			throw nvae;
		}

		switch (alt197) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:413:5: ( joinedTables )=>t= joinedTables RPAREN
				{
				pushFollow(FOLLOW_joinedTables_in_synpred112_SQLAnalyzer2332);
				joinedTables();
				state._fsp--;
				if (state.failed) return;
				match(input,RPAREN,FOLLOW_RPAREN_in_synpred112_SQLAnalyzer2334); if (state.failed) return;
				}
				break;
			case 2 :
				// parser\\sql\\SQLAnalyzer.g:415:7: q= queryExpression RPAREN (al= alias1 )?
				{
				pushFollow(FOLLOW_queryExpression_in_synpred112_SQLAnalyzer2347);
				queryExpression();
				state._fsp--;
				if (state.failed) return;
				match(input,RPAREN,FOLLOW_RPAREN_in_synpred112_SQLAnalyzer2349); if (state.failed) return;
				// parser\\sql\\SQLAnalyzer.g:415:34: (al= alias1 )?
				int alt196=2;
				int LA196_0 = input.LA(1);
				if ( (LA196_0==AS||LA196_0==AVG||(LA196_0 >= CURRENT && LA196_0 <= CURRENT_TIMESTAMP)||(LA196_0 >= DATE && LA196_0 <= DECODE)||(LA196_0 >= DENSE && LA196_0 <= DESC)||LA196_0==GROUP||LA196_0==HOUR||(LA196_0 >= INT && LA196_0 <= INTERVAL)||LA196_0==MAX||LA196_0==MIN||LA196_0==MINUTE||LA196_0==MONTH||LA196_0==NEXT||LA196_0==NVL||LA196_0==NonQuotedIdentifier||LA196_0==ORDER||LA196_0==OVER||(LA196_0 >= QuotedIdentifier && LA196_0 <= RANK)||LA196_0==ROW||LA196_0==SECOND||(LA196_0 >= SUM && LA196_0 <= SYSDATE)||(LA196_0 >= TIME && LA196_0 <= TIMESTAMP)||LA196_0==UPDATE||LA196_0==VALUE||(LA196_0 >= YEAR && LA196_0 <= YEARS)) ) {
					alt196=1;
				}
				switch (alt196) {
					case 1 :
						// parser\\sql\\SQLAnalyzer.g:415:35: al= alias1
						{
						pushFollow(FOLLOW_alias1_in_synpred112_SQLAnalyzer2356);
						al=alias1();
						state._fsp--;
						if (state.failed) return;
						}
						break;

				}

				}
				break;

		}

		}

	}
	// $ANTLR end synpred112_SQLAnalyzer

	// $ANTLR start synpred113_SQLAnalyzer
	public final void synpred113_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope a =null;

		// parser\\sql\\SQLAnalyzer.g:417:21: (a= alias1 )
		// parser\\sql\\SQLAnalyzer.g:417:21: a= alias1
		{
		pushFollow(FOLLOW_alias1_in_synpred113_SQLAnalyzer2388);
		a=alias1();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred113_SQLAnalyzer

	// $ANTLR start synpred114_SQLAnalyzer
	public final void synpred114_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope a =null;

		// parser\\sql\\SQLAnalyzer.g:417:6: (f= function (a= alias1 )? )
		// parser\\sql\\SQLAnalyzer.g:417:6: f= function (a= alias1 )?
		{
		pushFollow(FOLLOW_function_in_synpred114_SQLAnalyzer2380);
		function();
		state._fsp--;
		if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:417:19: (a= alias1 )?
		int alt198=2;
		int LA198_0 = input.LA(1);
		if ( (LA198_0==AS||LA198_0==AVG||(LA198_0 >= CURRENT && LA198_0 <= CURRENT_TIMESTAMP)||(LA198_0 >= DATE && LA198_0 <= DECODE)||(LA198_0 >= DENSE && LA198_0 <= DESC)||LA198_0==GROUP||LA198_0==HOUR||(LA198_0 >= INT && LA198_0 <= INTERVAL)||LA198_0==MAX||LA198_0==MIN||LA198_0==MINUTE||LA198_0==MONTH||LA198_0==NEXT||LA198_0==NVL||LA198_0==NonQuotedIdentifier||LA198_0==ORDER||LA198_0==OVER||(LA198_0 >= QuotedIdentifier && LA198_0 <= RANK)||LA198_0==ROW||LA198_0==SECOND||(LA198_0 >= SUM && LA198_0 <= SYSDATE)||(LA198_0 >= TIME && LA198_0 <= TIMESTAMP)||LA198_0==UPDATE||LA198_0==VALUE||(LA198_0 >= YEAR && LA198_0 <= YEARS)) ) {
			alt198=1;
		}
		switch (alt198) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:417:21: a= alias1
				{
				pushFollow(FOLLOW_alias1_in_synpred114_SQLAnalyzer2388);
				a=alias1();
				state._fsp--;
				if (state.failed) return;
				}
				break;

		}

		}

	}
	// $ANTLR end synpred114_SQLAnalyzer

	// $ANTLR start synpred115_SQLAnalyzer
	public final void synpred115_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope al =null;

		// parser\\sql\\SQLAnalyzer.g:418:5: ( LPAREN VALUES constant RPAREN (al= alias1 ) )
		// parser\\sql\\SQLAnalyzer.g:418:5: LPAREN VALUES constant RPAREN (al= alias1 )
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred115_SQLAnalyzer2398); if (state.failed) return;
		match(input,VALUES,FOLLOW_VALUES_in_synpred115_SQLAnalyzer2400); if (state.failed) return;
		pushFollow(FOLLOW_constant_in_synpred115_SQLAnalyzer2402);
		constant();
		state._fsp--;
		if (state.failed) return;
		match(input,RPAREN,FOLLOW_RPAREN_in_synpred115_SQLAnalyzer2404); if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:418:35: (al= alias1 )
		// parser\\sql\\SQLAnalyzer.g:418:36: al= alias1
		{
		pushFollow(FOLLOW_alias1_in_synpred115_SQLAnalyzer2411);
		al=alias1();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred115_SQLAnalyzer

	// $ANTLR start synpred116_SQLAnalyzer
	public final void synpred116_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope al =null;

		// parser\\sql\\SQLAnalyzer.g:419:22: (al= alias1 )
		// parser\\sql\\SQLAnalyzer.g:419:22: al= alias1
		{
		pushFollow(FOLLOW_alias1_in_synpred116_SQLAnalyzer2431);
		al=alias1();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred116_SQLAnalyzer

	// $ANTLR start synpred126_SQLAnalyzer
	public final void synpred126_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:491:25: ( AS )
		// parser\\sql\\SQLAnalyzer.g:491:25: AS
		{
		match(input,AS,FOLLOW_AS_in_synpred126_SQLAnalyzer2641); if (state.failed) return;
		}

	}
	// $ANTLR end synpred126_SQLAnalyzer

	// $ANTLR start synpred129_SQLAnalyzer
	public final void synpred129_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:554:5: (o= additiveOperator r= additiveSubExpression )
		// parser\\sql\\SQLAnalyzer.g:554:5: o= additiveOperator r= additiveSubExpression
		{
		pushFollow(FOLLOW_additiveOperator_in_synpred129_SQLAnalyzer2767);
		additiveOperator();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_additiveSubExpression_in_synpred129_SQLAnalyzer2773);
		additiveSubExpression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred129_SQLAnalyzer

	// $ANTLR start synpred131_SQLAnalyzer
	public final void synpred131_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:559:5: ( (o= multiplicativeArithmeticOperator )? r= subExpression )
		// parser\\sql\\SQLAnalyzer.g:559:5: (o= multiplicativeArithmeticOperator )? r= subExpression
		{
		// parser\\sql\\SQLAnalyzer.g:559:5: (o= multiplicativeArithmeticOperator )?
		int alt200=2;
		int LA200_0 = input.LA(1);
		if ( (LA200_0==DIVIDE||LA200_0==MOD||LA200_0==STAR) ) {
			alt200=1;
		}
		switch (alt200) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:559:7: o= multiplicativeArithmeticOperator
				{
				pushFollow(FOLLOW_multiplicativeArithmeticOperator_in_synpred131_SQLAnalyzer2807);
				multiplicativeArithmeticOperator();
				state._fsp--;
				if (state.failed) return;
				}
				break;

		}

		pushFollow(FOLLOW_subExpression_in_synpred131_SQLAnalyzer2816);
		subExpression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred131_SQLAnalyzer

	// $ANTLR start synpred133_SQLAnalyzer
	public final void synpred133_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:563:12: ( selectStatement ( expression )? )
		// parser\\sql\\SQLAnalyzer.g:563:12: selectStatement ( expression )?
		{
		pushFollow(FOLLOW_selectStatement_in_synpred133_SQLAnalyzer2838);
		selectStatement();
		state._fsp--;
		if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:563:28: ( expression )?
		int alt201=2;
		int LA201_0 = input.LA(1);
		if ( (LA201_0==AVG||LA201_0==AsciiStringLiteral||(LA201_0 >= CASE && LA201_0 <= CAST)||(LA201_0 >= CURRENT && LA201_0 <= CURRENT_TIMESTAMP)||(LA201_0 >= DASH && LA201_0 <= DECODE)||(LA201_0 >= DENSE && LA201_0 <= DESC)||LA201_0==EXTRACT||LA201_0==GROUP||LA201_0==HOUR||LA201_0==HexLiteral||(LA201_0 >= INT && LA201_0 <= INTERVAL)||(LA201_0 >= Integer && LA201_0 <= Iso8601DateTime)||LA201_0==LEFT||LA201_0==LPAREN||(LA201_0 >= MAX && LA201_0 <= MAccessDateTime)||LA201_0==MIN||LA201_0==MINUTE||LA201_0==MONTH||LA201_0==NEXT||LA201_0==NULL||LA201_0==NVL||LA201_0==NonQuotedIdentifier||LA201_0==ORDER||LA201_0==OVER||(LA201_0 >= PLACEHOLDER && LA201_0 <= PLUS)||(LA201_0 >= QuotedIdentifier && LA201_0 <= RANK)||(LA201_0 >= RIGHT && LA201_0 <= ROW)||(LA201_0 >= Real && LA201_0 <= SECOND)||(LA201_0 >= SUBSTRING && LA201_0 <= SYSDATE)||(LA201_0 >= TIME && LA201_0 <= TIMESTAMP)||LA201_0==UPDATE||LA201_0==UicodeValueLiteral||LA201_0==UnicodeStringLiteral||LA201_0==VALUE||LA201_0==Variable||(LA201_0 >= YEAR && LA201_0 <= YEARS)) ) {
			alt201=1;
		}
		switch (alt201) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:563:29: expression
				{
				pushFollow(FOLLOW_expression_in_synpred133_SQLAnalyzer2841);
				expression();
				state._fsp--;
				if (state.failed) return;
				}
				break;

		}

		}

	}
	// $ANTLR end synpred133_SQLAnalyzer

	// $ANTLR start synpred137_SQLAnalyzer
	public final void synpred137_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:568:5: (c= constant )
		// parser\\sql\\SQLAnalyzer.g:568:5: c= constant
		{
		pushFollow(FOLLOW_constant_in_synpred137_SQLAnalyzer2901);
		constant();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred137_SQLAnalyzer

	// $ANTLR start synpred138_SQLAnalyzer
	public final void synpred138_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:569:7: (a= sharpObject )
		// parser\\sql\\SQLAnalyzer.g:569:7: a= sharpObject
		{
		pushFollow(FOLLOW_sharpObject_in_synpred138_SQLAnalyzer2914);
		sharpObject();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred138_SQLAnalyzer

	// $ANTLR start synpred139_SQLAnalyzer
	public final void synpred139_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:570:7: (g= groupFunction )
		// parser\\sql\\SQLAnalyzer.g:570:7: g= groupFunction
		{
		pushFollow(FOLLOW_groupFunction_in_synpred139_SQLAnalyzer2926);
		groupFunction();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred139_SQLAnalyzer

	// $ANTLR start synpred140_SQLAnalyzer
	public final void synpred140_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:571:7: (da= datetimeField )
		// parser\\sql\\SQLAnalyzer.g:571:7: da= datetimeField
		{
		pushFollow(FOLLOW_datetimeField_in_synpred140_SQLAnalyzer2938);
		datetimeField();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred140_SQLAnalyzer

	// $ANTLR start synpred141_SQLAnalyzer
	public final void synpred141_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:572:7: (t= db2Element )
		// parser\\sql\\SQLAnalyzer.g:572:7: t= db2Element
		{
		pushFollow(FOLLOW_db2Element_in_synpred141_SQLAnalyzer2951);
		db2Element();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred141_SQLAnalyzer

	// $ANTLR start synpred144_SQLAnalyzer
	public final void synpred144_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:575:7: ( function )
		// parser\\sql\\SQLAnalyzer.g:575:8: function
		{
		pushFollow(FOLLOW_function_in_synpred144_SQLAnalyzer2982);
		function();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred144_SQLAnalyzer

	// $ANTLR start synpred145_SQLAnalyzer
	public final void synpred145_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:577:7: (e= bracketedTerm )
		// parser\\sql\\SQLAnalyzer.g:577:7: e= bracketedTerm
		{
		pushFollow(FOLLOW_bracketedTerm_in_synpred145_SQLAnalyzer3010);
		bracketedTerm();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred145_SQLAnalyzer

	// $ANTLR start synpred146_SQLAnalyzer
	public final void synpred146_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:578:21: ( plusSignature )
		// parser\\sql\\SQLAnalyzer.g:578:21: plusSignature
		{
		pushFollow(FOLLOW_plusSignature_in_synpred146_SQLAnalyzer3026);
		plusSignature();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred146_SQLAnalyzer

	// $ANTLR start synpred147_SQLAnalyzer
	public final void synpred147_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope d =null;

		// parser\\sql\\SQLAnalyzer.g:578:7: (d= dbObject ( plusSignature )? )
		// parser\\sql\\SQLAnalyzer.g:578:7: d= dbObject ( plusSignature )?
		{
		pushFollow(FOLLOW_dbObject_in_synpred147_SQLAnalyzer3023);
		d=dbObject();
		state._fsp--;
		if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:578:20: ( plusSignature )?
		int alt202=2;
		int LA202_0 = input.LA(1);
		if ( (LA202_0==LPAREN) ) {
			alt202=1;
		}
		switch (alt202) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:578:21: plusSignature
				{
				pushFollow(FOLLOW_plusSignature_in_synpred147_SQLAnalyzer3026);
				plusSignature();
				state._fsp--;
				if (state.failed) return;
				}
				break;

		}

		}

	}
	// $ANTLR end synpred147_SQLAnalyzer

	// $ANTLR start synpred164_SQLAnalyzer
	public final void synpred164_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:644:21: ( expression )
		// parser\\sql\\SQLAnalyzer.g:644:21: expression
		{
		pushFollow(FOLLOW_expression_in_synpred164_SQLAnalyzer3413);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred164_SQLAnalyzer

	// $ANTLR start synpred165_SQLAnalyzer
	public final void synpred165_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:648:3: (e= expression )
		// parser\\sql\\SQLAnalyzer.g:648:3: e= expression
		{
		pushFollow(FOLLOW_expression_in_synpred165_SQLAnalyzer3433);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred165_SQLAnalyzer

	// $ANTLR start synpred185_SQLAnalyzer
	public final void synpred185_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:674:7: (c= functionArgument ( COMMA b= functionArgument )* )
		// parser\\sql\\SQLAnalyzer.g:674:7: c= functionArgument ( COMMA b= functionArgument )*
		{
		pushFollow(FOLLOW_functionArgument_in_synpred185_SQLAnalyzer3669);
		functionArgument();
		state._fsp--;
		if (state.failed) return;
		// parser\\sql\\SQLAnalyzer.g:674:28: ( COMMA b= functionArgument )*
		loop210:
		while (true) {
			int alt210=2;
			int LA210_0 = input.LA(1);
			if ( (LA210_0==COMMA) ) {
				alt210=1;
			}

			switch (alt210) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:674:29: COMMA b= functionArgument
				{
				match(input,COMMA,FOLLOW_COMMA_in_synpred185_SQLAnalyzer3672); if (state.failed) return;
				pushFollow(FOLLOW_functionArgument_in_synpred185_SQLAnalyzer3678);
				functionArgument();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				break loop210;
			}
		}

		}

	}
	// $ANTLR end synpred185_SQLAnalyzer

	// $ANTLR start synpred192_SQLAnalyzer
	public final void synpred192_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:686:36: ( CASE )
		// parser\\sql\\SQLAnalyzer.g:686:36: CASE
		{
		match(input,CASE,FOLLOW_CASE_in_synpred192_SQLAnalyzer3833); if (state.failed) return;
		}

	}
	// $ANTLR end synpred192_SQLAnalyzer

	// $ANTLR start synpred196_SQLAnalyzer
	public final void synpred196_SQLAnalyzer_fragment() throws RecognitionException {
		ParserRuleReturnScope ic =null;

		// parser\\sql\\SQLAnalyzer.g:723:5: ( DOT ic= identifier )
		// parser\\sql\\SQLAnalyzer.g:723:5: DOT ic= identifier
		{
		match(input,DOT,FOLLOW_DOT_in_synpred196_SQLAnalyzer3972); if (state.failed) return;
		pushFollow(FOLLOW_identifier_in_synpred196_SQLAnalyzer3978);
		ic=identifier();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred196_SQLAnalyzer

	// $ANTLR start synpred197_SQLAnalyzer
	public final void synpred197_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:736:4: (s= singleStringLiteral )
		// parser\\sql\\SQLAnalyzer.g:736:4: s= singleStringLiteral
		{
		pushFollow(FOLLOW_singleStringLiteral_in_synpred197_SQLAnalyzer4025);
		singleStringLiteral();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred197_SQLAnalyzer

	// $ANTLR start synpred206_SQLAnalyzer
	public final void synpred206_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:752:5: ( groupName )
		// parser\\sql\\SQLAnalyzer.g:752:5: groupName
		{
		pushFollow(FOLLOW_groupName_in_synpred206_SQLAnalyzer4109);
		groupName();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred206_SQLAnalyzer

	// $ANTLR start synpred207_SQLAnalyzer
	public final void synpred207_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:753:5: ( datetimeField )
		// parser\\sql\\SQLAnalyzer.g:753:5: datetimeField
		{
		pushFollow(FOLLOW_datetimeField_in_synpred207_SQLAnalyzer4115);
		datetimeField();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred207_SQLAnalyzer

	// $ANTLR start synpred208_SQLAnalyzer
	public final void synpred208_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:754:5: ( db2Element )
		// parser\\sql\\SQLAnalyzer.g:754:5: db2Element
		{
		pushFollow(FOLLOW_db2Element_in_synpred208_SQLAnalyzer4121);
		db2Element();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred208_SQLAnalyzer

	// $ANTLR start synpred218_SQLAnalyzer
	public final void synpred218_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:778:77: ( LPAREN Integer RPAREN )
		// parser\\sql\\SQLAnalyzer.g:778:77: LPAREN Integer RPAREN
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred218_SQLAnalyzer4279); if (state.failed) return;
		match(input,Integer,FOLLOW_Integer_in_synpred218_SQLAnalyzer4281); if (state.failed) return;
		match(input,RPAREN,FOLLOW_RPAREN_in_synpred218_SQLAnalyzer4284); if (state.failed) return;
		}

	}
	// $ANTLR end synpred218_SQLAnalyzer

	// $ANTLR start synpred241_SQLAnalyzer
	public final void synpred241_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:829:3: ( CURRENT ( TIMESTAMP | DATE | TIME ) )
		// parser\\sql\\SQLAnalyzer.g:829:3: CURRENT ( TIMESTAMP | DATE | TIME )
		{
		match(input,CURRENT,FOLLOW_CURRENT_in_synpred241_SQLAnalyzer4554); if (state.failed) return;
		if ( input.LA(1)==DATE||(input.LA(1) >= TIME && input.LA(1) <= TIMESTAMP) ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}
		}

	}
	// $ANTLR end synpred241_SQLAnalyzer

	// $ANTLR start synpred245_SQLAnalyzer
	public final void synpred245_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:831:5: ( CURRENT )
		// parser\\sql\\SQLAnalyzer.g:831:5: CURRENT
		{
		match(input,CURRENT,FOLLOW_CURRENT_in_synpred245_SQLAnalyzer4590); if (state.failed) return;
		}

	}
	// $ANTLR end synpred245_SQLAnalyzer

	// Delegated rules

	public final boolean synpred37_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred37_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred147_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred147_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred105_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred105_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred90_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred90_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred192_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred192_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred104_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred104_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred164_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred164_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred48_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred48_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred126_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred126_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred54_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred54_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred31_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred31_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred59_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred59_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred196_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred196_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred116_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred116_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred133_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred133_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred95_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred95_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred65_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred65_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred165_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred165_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred108_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred108_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred206_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred206_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred89_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred89_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred78_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred78_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred208_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred208_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred113_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred113_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred137_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred137_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred245_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred245_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred197_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred197_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred82_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred82_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred46_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred46_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred45_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred45_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred139_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred139_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred74_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred74_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred100_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred100_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred138_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred138_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred35_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred35_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred140_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred140_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred75_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred75_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred93_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred93_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred115_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred115_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred131_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred131_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred63_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred63_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred57_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred57_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred185_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred185_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred64_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred64_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred44_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred44_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred207_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred207_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred58_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred58_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred144_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred144_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred67_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred67_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred94_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred94_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred112_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred112_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred56_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred56_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred49_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred49_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred102_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred102_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred103_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred103_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred97_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred97_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred241_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred241_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred53_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred53_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred77_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred77_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred47_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred47_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred146_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred146_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred129_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred129_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred145_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred145_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred218_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred218_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred109_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred109_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred110_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred110_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred55_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred55_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred114_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred114_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred106_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred106_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred111_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred111_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred141_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred141_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred62_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred62_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred14_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred52_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred52_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA67 dfa67 = new DFA67(this);
	protected DFA77 dfa77 = new DFA77(this);
	protected DFA83 dfa83 = new DFA83(this);
	protected DFA107 dfa107 = new DFA107(this);
	protected DFA125 dfa125 = new DFA125(this);
	static final String DFA67_eotS =
		"\127\uffff";
	static final String DFA67_eofS =
		"\1\11\126\uffff";
	static final String DFA67_minS =
		"\1\5\10\0\116\uffff";
	static final String DFA67_maxS =
		"\1\u00ab\10\0\116\uffff";
	static final String DFA67_acceptS =
		"\11\uffff\1\2\114\uffff\1\1";
	static final String DFA67_specialS =
		"\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\116\uffff}>";
	static final String[] DFA67_transitionS = {
			"\1\11\3\uffff\1\1\1\11\1\uffff\1\11\1\uffff\1\10\2\uffff\2\11\1\uffff"+
			"\7\11\1\uffff\4\11\2\uffff\2\11\12\uffff\1\11\2\uffff\1\11\1\uffff\1"+
			"\11\1\uffff\1\11\1\uffff\1\7\1\6\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff"+
			"\1\11\1\uffff\2\11\3\uffff\3\11\2\uffff\1\11\1\4\1\5\1\uffff\1\11\3\uffff"+
			"\2\11\1\uffff\3\11\1\uffff\1\11\3\uffff\1\11\1\uffff\1\2\1\3\1\11\2\uffff"+
			"\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\3\11\1\uffff\1\11\2\uffff\2\11"+
			"\3\uffff\2\11\1\uffff\2\11\1\uffff\1\11\1\uffff\5\11\2\uffff\1\11\1\uffff"+
			"\3\11\3\uffff\3\11\3\uffff\2\11\1\uffff\1\11\1\uffff\1\11\1\uffff\1\11"+
			"\2\uffff\2\11\1\uffff\4\11\4\uffff\2\11",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
	static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
	static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
	static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
	static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
	static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
	static final short[][] DFA67_transition;

	static {
		int numStates = DFA67_transitionS.length;
		DFA67_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
		}
	}

	protected class DFA67 extends DFA {

		public DFA67(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 67;
			this.eot = DFA67_eot;
			this.eof = DFA67_eof;
			this.min = DFA67_min;
			this.max = DFA67_max;
			this.accept = DFA67_accept;
			this.special = DFA67_special;
			this.transition = DFA67_transition;
		}
		@Override
		public String getDescription() {
			return "347:37: ( comparisonOperator expression )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA67_1 = input.LA(1);
						 
						int index67_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_1);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA67_2 = input.LA(1);
						 
						int index67_2 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_2);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA67_3 = input.LA(1);
						 
						int index67_3 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_3);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA67_4 = input.LA(1);
						 
						int index67_4 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_4);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA67_5 = input.LA(1);
						 
						int index67_5 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_5);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA67_6 = input.LA(1);
						 
						int index67_6 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_6);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA67_7 = input.LA(1);
						 
						int index67_7 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_7);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA67_8 = input.LA(1);
						 
						int index67_8 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred78_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index67_8);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 67, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA77_eotS =
		"\127\uffff";
	static final String DFA77_eofS =
		"\1\1\126\uffff";
	static final String DFA77_minS =
		"\1\5\60\uffff\1\0\45\uffff";
	static final String DFA77_maxS =
		"\1\u00ab\60\uffff\1\0\45\uffff";
	static final String DFA77_acceptS =
		"\1\uffff\1\2\124\uffff\1\1";
	static final String DFA77_specialS =
		"\61\uffff\1\0\45\uffff}>";
	static final String[] DFA77_transitionS = {
			"\1\1\3\uffff\2\1\1\uffff\1\1\1\uffff\1\1\2\uffff\2\1\1\uffff\1\61\6\1"+
			"\1\uffff\4\1\2\uffff\2\1\12\uffff\1\1\2\uffff\1\1\1\uffff\1\1\1\uffff"+
			"\1\1\1\uffff\3\1\1\uffff\2\1\1\uffff\1\1\1\uffff\1\1\1\uffff\2\1\3\uffff"+
			"\3\1\2\uffff\3\1\1\uffff\1\1\3\uffff\2\1\1\uffff\3\1\1\uffff\1\1\3\uffff"+
			"\1\1\1\uffff\3\1\2\uffff\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\3\1\1\uffff"+
			"\1\1\2\uffff\2\1\3\uffff\2\1\1\uffff\2\1\1\uffff\1\1\1\uffff\5\1\2\uffff"+
			"\1\1\1\uffff\3\1\3\uffff\3\1\3\uffff\2\1\1\uffff\1\1\1\uffff\1\1\1\uffff"+
			"\1\1\2\uffff\2\1\1\uffff\4\1\4\uffff\2\1",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA77_eot = DFA.unpackEncodedString(DFA77_eotS);
	static final short[] DFA77_eof = DFA.unpackEncodedString(DFA77_eofS);
	static final char[] DFA77_min = DFA.unpackEncodedStringToUnsignedChars(DFA77_minS);
	static final char[] DFA77_max = DFA.unpackEncodedStringToUnsignedChars(DFA77_maxS);
	static final short[] DFA77_accept = DFA.unpackEncodedString(DFA77_acceptS);
	static final short[] DFA77_special = DFA.unpackEncodedString(DFA77_specialS);
	static final short[][] DFA77_transition;

	static {
		int numStates = DFA77_transitionS.length;
		DFA77_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA77_transition[i] = DFA.unpackEncodedString(DFA77_transitionS[i]);
		}
	}

	protected class DFA77 extends DFA {

		public DFA77(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 77;
			this.eot = DFA77_eot;
			this.eof = DFA77_eof;
			this.min = DFA77_min;
			this.max = DFA77_max;
			this.accept = DFA77_accept;
			this.special = DFA77_special;
			this.transition = DFA77_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 371:11: ( COMMA e= expression )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA77_49 = input.LA(1);
						 
						int index77_49 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred93_SQLAnalyzer()) ) {s = 86;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index77_49);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 77, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA83_eotS =
		"\130\uffff";
	static final String DFA83_eofS =
		"\1\1\127\uffff";
	static final String DFA83_minS =
		"\1\5\57\uffff\1\0\47\uffff";
	static final String DFA83_maxS =
		"\1\u00ab\57\uffff\1\0\47\uffff";
	static final String DFA83_acceptS =
		"\1\uffff\1\2\125\uffff\1\1";
	static final String DFA83_specialS =
		"\60\uffff\1\0\47\uffff}>";
	static final String[] DFA83_transitionS = {
			"\1\1\3\uffff\2\1\1\uffff\1\1\1\uffff\1\1\2\uffff\2\1\1\uffff\1\60\6\1"+
			"\1\uffff\4\1\2\uffff\2\1\12\uffff\1\1\2\uffff\1\1\1\uffff\3\1\1\uffff"+
			"\3\1\1\uffff\2\1\1\uffff\1\1\1\uffff\1\1\1\uffff\2\1\3\uffff\3\1\2\uffff"+
			"\3\1\1\uffff\1\1\3\uffff\2\1\1\uffff\3\1\1\uffff\1\1\3\uffff\1\1\1\uffff"+
			"\3\1\2\uffff\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\3\1\1\uffff\1\1\2\uffff"+
			"\2\1\3\uffff\2\1\1\uffff\2\1\1\uffff\1\1\1\uffff\5\1\2\uffff\1\1\1\uffff"+
			"\3\1\3\uffff\3\1\3\uffff\2\1\1\uffff\1\1\1\uffff\1\1\1\uffff\1\1\2\uffff"+
			"\2\1\1\uffff\4\1\4\uffff\2\1",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA83_eot = DFA.unpackEncodedString(DFA83_eotS);
	static final short[] DFA83_eof = DFA.unpackEncodedString(DFA83_eofS);
	static final char[] DFA83_min = DFA.unpackEncodedStringToUnsignedChars(DFA83_minS);
	static final char[] DFA83_max = DFA.unpackEncodedStringToUnsignedChars(DFA83_maxS);
	static final short[] DFA83_accept = DFA.unpackEncodedString(DFA83_acceptS);
	static final short[] DFA83_special = DFA.unpackEncodedString(DFA83_specialS);
	static final short[][] DFA83_transition;

	static {
		int numStates = DFA83_transitionS.length;
		DFA83_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA83_transition[i] = DFA.unpackEncodedString(DFA83_transitionS[i]);
		}
	}

	protected class DFA83 extends DFA {

		public DFA83(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 83;
			this.eot = DFA83_eot;
			this.eof = DFA83_eof;
			this.min = DFA83_min;
			this.max = DFA83_max;
			this.accept = DFA83_accept;
			this.special = DFA83_special;
			this.transition = DFA83_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 386:5: ( COMMA t= selectItem )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA83_48 = input.LA(1);
						 
						int index83_48 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred100_SQLAnalyzer()) ) {s = 87;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index83_48);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 83, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA107_eotS =
		"\150\uffff";
	static final String DFA107_eofS =
		"\1\2\147\uffff";
	static final String DFA107_minS =
		"\1\5\1\0\7\uffff\1\0\7\uffff\40\0\14\uffff\1\0\13\uffff\15\0\1\uffff\2"+
		"\0\4\uffff\1\0\12\uffff";
	static final String DFA107_maxS =
		"\1\u00ab\1\0\7\uffff\1\0\7\uffff\40\0\14\uffff\1\0\13\uffff\15\0\1\uffff"+
		"\2\0\4\uffff\1\0\12\uffff";
	static final String DFA107_acceptS =
		"\2\uffff\1\2\144\uffff\1\1";
	static final String DFA107_specialS =
		"\1\uffff\1\0\7\uffff\1\1\7\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
		"\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
		"\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\14\uffff\1\42\13\uffff\1"+
		"\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\uffff"+
		"\1\60\1\61\4\uffff\1\62\12\uffff}>";
	static final String[] DFA107_transitionS = {
			"\1\2\1\uffff\3\2\1\30\1\uffff\1\114\1\uffff\1\2\2\uffff\1\127\1\130\1"+
			"\uffff\3\2\1\47\1\54\1\55\1\56\1\uffff\1\1\1\33\1\53\1\45\2\uffff\1\43"+
			"\1\11\1\uffff\1\135\2\2\2\uffff\3\2\1\uffff\1\124\2\uffff\1\2\1\uffff"+
			"\3\2\1\uffff\2\2\1\25\1\uffff\1\2\1\53\1\uffff\1\115\2\2\1\uffff\1\37"+
			"\1\60\1\uffff\1\2\1\uffff\1\111\1\117\1\2\2\uffff\1\75\3\2\1\21\3\uffff"+
			"\1\26\1\116\1\uffff\1\31\1\2\1\53\1\135\1\36\3\uffff\1\57\3\2\1\113\1"+
			"\2\1\uffff\1\32\1\uffff\1\22\1\uffff\4\2\1\24\1\uffff\1\41\2\uffff\1"+
			"\122\1\1\3\uffff\1\23\1\44\1\uffff\1\125\1\42\2\2\1\uffff\1\112\1\53"+
			"\3\2\1\uffff\1\135\2\2\1\123\1\27\1\51\3\uffff\1\2\1\34\1\35\3\uffff"+
			"\1\2\1\50\1\uffff\1\2\1\uffff\1\120\1\uffff\1\114\2\uffff\1\40\1\2\1"+
			"\uffff\1\121\3\2\4\uffff\1\46\1\52",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA107_eot = DFA.unpackEncodedString(DFA107_eotS);
	static final short[] DFA107_eof = DFA.unpackEncodedString(DFA107_eofS);
	static final char[] DFA107_min = DFA.unpackEncodedStringToUnsignedChars(DFA107_minS);
	static final char[] DFA107_max = DFA.unpackEncodedStringToUnsignedChars(DFA107_maxS);
	static final short[] DFA107_accept = DFA.unpackEncodedString(DFA107_acceptS);
	static final short[] DFA107_special = DFA.unpackEncodedString(DFA107_specialS);
	static final short[][] DFA107_transition;

	static {
		int numStates = DFA107_transitionS.length;
		DFA107_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA107_transition[i] = DFA.unpackEncodedString(DFA107_transitionS[i]);
		}
	}

	protected class DFA107 extends DFA {

		public DFA107(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 107;
			this.eot = DFA107_eot;
			this.eof = DFA107_eof;
			this.min = DFA107_min;
			this.max = DFA107_max;
			this.accept = DFA107_accept;
			this.special = DFA107_special;
			this.transition = DFA107_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 559:3: ( (o= multiplicativeArithmeticOperator )? r= subExpression )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA107_1 = input.LA(1);
						 
						int index107_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_1);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA107_9 = input.LA(1);
						 
						int index107_9 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_9);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA107_17 = input.LA(1);
						 
						int index107_17 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_17);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA107_18 = input.LA(1);
						 
						int index107_18 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_18);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA107_19 = input.LA(1);
						 
						int index107_19 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_19);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA107_20 = input.LA(1);
						 
						int index107_20 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_20);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA107_21 = input.LA(1);
						 
						int index107_21 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_21);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA107_22 = input.LA(1);
						 
						int index107_22 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_22);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA107_23 = input.LA(1);
						 
						int index107_23 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_23);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA107_24 = input.LA(1);
						 
						int index107_24 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_24);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA107_25 = input.LA(1);
						 
						int index107_25 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_25);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA107_26 = input.LA(1);
						 
						int index107_26 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_26);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA107_27 = input.LA(1);
						 
						int index107_27 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_27);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA107_28 = input.LA(1);
						 
						int index107_28 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_28);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA107_29 = input.LA(1);
						 
						int index107_29 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_29);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA107_30 = input.LA(1);
						 
						int index107_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_30);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA107_31 = input.LA(1);
						 
						int index107_31 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_31);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA107_32 = input.LA(1);
						 
						int index107_32 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_32);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA107_33 = input.LA(1);
						 
						int index107_33 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_33);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA107_34 = input.LA(1);
						 
						int index107_34 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_34);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA107_35 = input.LA(1);
						 
						int index107_35 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_35);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA107_36 = input.LA(1);
						 
						int index107_36 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_36);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA107_37 = input.LA(1);
						 
						int index107_37 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_37);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA107_38 = input.LA(1);
						 
						int index107_38 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_38);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA107_39 = input.LA(1);
						 
						int index107_39 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_39);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA107_40 = input.LA(1);
						 
						int index107_40 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_40);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA107_41 = input.LA(1);
						 
						int index107_41 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_41);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA107_42 = input.LA(1);
						 
						int index107_42 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_42);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA107_43 = input.LA(1);
						 
						int index107_43 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_43);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA107_44 = input.LA(1);
						 
						int index107_44 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_44);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA107_45 = input.LA(1);
						 
						int index107_45 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_45);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA107_46 = input.LA(1);
						 
						int index107_46 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_46);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA107_47 = input.LA(1);
						 
						int index107_47 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_47);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA107_48 = input.LA(1);
						 
						int index107_48 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_48);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA107_61 = input.LA(1);
						 
						int index107_61 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_61);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA107_73 = input.LA(1);
						 
						int index107_73 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_73);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA107_74 = input.LA(1);
						 
						int index107_74 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_74);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA107_75 = input.LA(1);
						 
						int index107_75 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_75);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA107_76 = input.LA(1);
						 
						int index107_76 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_76);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA107_77 = input.LA(1);
						 
						int index107_77 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_77);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA107_78 = input.LA(1);
						 
						int index107_78 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_78);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA107_79 = input.LA(1);
						 
						int index107_79 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_79);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA107_80 = input.LA(1);
						 
						int index107_80 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_80);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA107_81 = input.LA(1);
						 
						int index107_81 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_81);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA107_82 = input.LA(1);
						 
						int index107_82 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_82);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA107_83 = input.LA(1);
						 
						int index107_83 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_83);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA107_84 = input.LA(1);
						 
						int index107_84 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_84);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA107_85 = input.LA(1);
						 
						int index107_85 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_85);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA107_87 = input.LA(1);
						 
						int index107_87 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_87);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA107_88 = input.LA(1);
						 
						int index107_88 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_88);
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA107_93 = input.LA(1);
						 
						int index107_93 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred131_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index107_93);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 107, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA125_eotS =
		"\150\uffff";
	static final String DFA125_eofS =
		"\1\63\147\uffff";
	static final String DFA125_minS =
		"\1\5\62\0\65\uffff";
	static final String DFA125_maxS =
		"\1\u00ab\62\0\65\uffff";
	static final String DFA125_acceptS =
		"\63\uffff\1\2\63\uffff\1\1";
	static final String DFA125_specialS =
		"\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
		"\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
		"\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
		"\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\65\uffff}>";
	static final String[] DFA125_transitionS = {
			"\1\63\1\uffff\3\63\1\22\1\uffff\1\5\1\uffff\1\63\2\uffff\1\61\1\62\1"+
			"\uffff\3\63\1\40\1\45\1\46\1\47\1\uffff\1\1\1\25\1\44\1\36\2\uffff\1"+
			"\34\1\15\1\uffff\3\63\2\uffff\3\63\1\uffff\1\55\2\uffff\1\63\1\uffff"+
			"\3\63\1\uffff\2\63\1\17\1\uffff\1\63\1\44\1\uffff\1\7\2\63\1\uffff\1"+
			"\30\1\6\1\uffff\1\63\1\uffff\1\2\1\11\1\63\2\uffff\1\57\3\63\1\56\3\uffff"+
			"\1\20\1\10\1\uffff\1\23\1\63\1\44\1\63\1\27\3\uffff\1\50\3\63\1\4\1\63"+
			"\1\uffff\1\24\1\uffff\1\13\1\uffff\4\63\1\16\1\uffff\1\32\2\uffff\1\53"+
			"\1\1\3\uffff\1\14\1\35\1\uffff\1\60\1\33\2\63\1\uffff\1\3\1\44\3\63\1"+
			"\uffff\3\63\1\54\1\21\1\42\3\uffff\1\63\1\26\1\12\3\uffff\1\63\1\41\1"+
			"\uffff\1\63\1\uffff\1\51\1\uffff\1\5\2\uffff\1\31\1\63\1\uffff\1\52\3"+
			"\63\4\uffff\1\37\1\43",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA125_eot = DFA.unpackEncodedString(DFA125_eotS);
	static final short[] DFA125_eof = DFA.unpackEncodedString(DFA125_eofS);
	static final char[] DFA125_min = DFA.unpackEncodedStringToUnsignedChars(DFA125_minS);
	static final char[] DFA125_max = DFA.unpackEncodedStringToUnsignedChars(DFA125_maxS);
	static final short[] DFA125_accept = DFA.unpackEncodedString(DFA125_acceptS);
	static final short[] DFA125_special = DFA.unpackEncodedString(DFA125_specialS);
	static final short[][] DFA125_transition;

	static {
		int numStates = DFA125_transitionS.length;
		DFA125_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA125_transition[i] = DFA.unpackEncodedString(DFA125_transitionS[i]);
		}
	}

	protected class DFA125 extends DFA {

		public DFA125(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 125;
			this.eot = DFA125_eot;
			this.eof = DFA125_eof;
			this.min = DFA125_min;
			this.max = DFA125_max;
			this.accept = DFA125_accept;
			this.special = DFA125_special;
			this.transition = DFA125_transition;
		}
		@Override
		public String getDescription() {
			return "644:19: ( expression )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA125_1 = input.LA(1);
						 
						int index125_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_1);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA125_2 = input.LA(1);
						 
						int index125_2 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_2);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA125_3 = input.LA(1);
						 
						int index125_3 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_3);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA125_4 = input.LA(1);
						 
						int index125_4 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_4);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA125_5 = input.LA(1);
						 
						int index125_5 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_5);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA125_6 = input.LA(1);
						 
						int index125_6 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_6);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA125_7 = input.LA(1);
						 
						int index125_7 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_7);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA125_8 = input.LA(1);
						 
						int index125_8 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_8);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA125_9 = input.LA(1);
						 
						int index125_9 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_9);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA125_10 = input.LA(1);
						 
						int index125_10 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_10);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA125_11 = input.LA(1);
						 
						int index125_11 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_11);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA125_12 = input.LA(1);
						 
						int index125_12 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_12);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA125_13 = input.LA(1);
						 
						int index125_13 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_13);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA125_14 = input.LA(1);
						 
						int index125_14 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_14);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA125_15 = input.LA(1);
						 
						int index125_15 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_15);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA125_16 = input.LA(1);
						 
						int index125_16 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_16);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA125_17 = input.LA(1);
						 
						int index125_17 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_17);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA125_18 = input.LA(1);
						 
						int index125_18 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_18);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA125_19 = input.LA(1);
						 
						int index125_19 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_19);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA125_20 = input.LA(1);
						 
						int index125_20 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_20);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA125_21 = input.LA(1);
						 
						int index125_21 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_21);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA125_22 = input.LA(1);
						 
						int index125_22 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_22);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA125_23 = input.LA(1);
						 
						int index125_23 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_23);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA125_24 = input.LA(1);
						 
						int index125_24 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_24);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA125_25 = input.LA(1);
						 
						int index125_25 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_25);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA125_26 = input.LA(1);
						 
						int index125_26 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_26);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA125_27 = input.LA(1);
						 
						int index125_27 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_27);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA125_28 = input.LA(1);
						 
						int index125_28 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_28);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA125_29 = input.LA(1);
						 
						int index125_29 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_29);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA125_30 = input.LA(1);
						 
						int index125_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_30);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA125_31 = input.LA(1);
						 
						int index125_31 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_31);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA125_32 = input.LA(1);
						 
						int index125_32 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_32);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA125_33 = input.LA(1);
						 
						int index125_33 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_33);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA125_34 = input.LA(1);
						 
						int index125_34 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_34);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA125_35 = input.LA(1);
						 
						int index125_35 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_35);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA125_36 = input.LA(1);
						 
						int index125_36 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_36);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA125_37 = input.LA(1);
						 
						int index125_37 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_37);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA125_38 = input.LA(1);
						 
						int index125_38 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_38);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA125_39 = input.LA(1);
						 
						int index125_39 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_39);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA125_40 = input.LA(1);
						 
						int index125_40 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_40);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA125_41 = input.LA(1);
						 
						int index125_41 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_41);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA125_42 = input.LA(1);
						 
						int index125_42 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_42);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA125_43 = input.LA(1);
						 
						int index125_43 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_43);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA125_44 = input.LA(1);
						 
						int index125_44 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_44);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA125_45 = input.LA(1);
						 
						int index125_45 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_45);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA125_46 = input.LA(1);
						 
						int index125_46 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_46);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA125_47 = input.LA(1);
						 
						int index125_47 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_47);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA125_48 = input.LA(1);
						 
						int index125_48 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_48);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA125_49 = input.LA(1);
						 
						int index125_49 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_49);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA125_50 = input.LA(1);
						 
						int index125_50 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred164_SQLAnalyzer()) ) {s = 103;}
						else if ( (true) ) {s = 51;}
						 
						input.seek(index125_50);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 125, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_insertStatement_in_statement78 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement81 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_statement97 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateStatement_in_statement119 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_deleteStatement_in_statement137 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mergeStatement_in_statement156 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_withStatement_in_statement173 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_in_insertStatement192 = new BitSet(new long[]{0x1200000CE7800402L,0x130141408A91001CL,0x00000C2180430C06L});
	public static final BitSet FOLLOW_INTO_in_insertStatement196 = new BitSet(new long[]{0x1200000CE7800402L,0x130141408A91000CL,0x00000C2180430C06L});
	public static final BitSet FOLLOW_dbObject_in_insertStatement210 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L,0x0000002100000004L});
	public static final BitSet FOLLOW_LPAREN_in_insertStatement228 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_columnNameList_in_insertStatement234 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertStatement236 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L,0x0000002100000004L});
	public static final BitSet FOLLOW_WITH_in_insertStatement243 = new BitSet(new long[]{0x1200000CE7800480L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_insertStatement249 = new BitSet(new long[]{0x0000000000000082L,0x0000000000010000L,0x0000000100000004L});
	public static final BitSet FOLLOW_AS_in_insertStatement252 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L,0x0000000100000004L});
	public static final BitSet FOLLOW_VALUES_in_insertStatement272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_insertStatement274 = new BitSet(new long[]{0x5200400DF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_columnValueList_in_insertStatement280 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertStatement282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_insertStatement293 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_queryExpression_in_selectStatement319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_updateStatement339 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E12L});
	public static final BitSet FOLLOW_tableSource_in_updateStatement351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_SET_in_updateStatement361 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_assignmentList_in_updateStatement367 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_whereClause_in_updateStatement387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_deleteStatement408 = new BitSet(new long[]{0x1210400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_FROM_in_deleteStatement413 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_tableSource_in_deleteStatement426 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_whereClause_in_deleteStatement446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MERGE_in_mergeStatement471 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_INTO_in_mergeStatement473 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_tableSource_in_mergeStatement476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_USING_in_mergeStatement480 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C06L});
	public static final BitSet FOLLOW_selectStatement_in_mergeStatement483 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_identifier_in_mergeStatement487 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_ON_in_mergeStatement489 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_mergeStatement491 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_WHEN_in_mergeStatement498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_MATCHED_in_mergeStatement500 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_THEN_in_mergeStatement502 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_updateStatement_in_mergeStatement505 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_WHEN_in_mergeStatement513 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_NOT_in_mergeStatement515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_MATCHED_in_mergeStatement517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_THEN_in_mergeStatement519 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_insertStatement_in_mergeStatement522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WITH_in_withStatement543 = new BitSet(new long[]{0x1200000CE7900400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_COMMA_in_withStatement549 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_identifier_in_withStatement563 = new BitSet(new long[]{0x0000000000000080L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_withStatement571 = new BitSet(new long[]{0x1200000CE7900400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_COMMA_in_withStatement576 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_identifier_in_withStatement581 = new BitSet(new long[]{0x1200000CE7900400L,0x530141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_RPAREN_in_withStatement586 = new BitSet(new long[]{0x0000000000000080L,0x0000000000010000L});
	public static final BitSet FOLLOW_AS_in_withStatement598 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_withStatement602 = new BitSet(new long[]{0x0000000000100000L,0x0000000000010000L,0x0000000100000004L});
	public static final BitSet FOLLOW_selectStatement_in_withStatement624 = new BitSet(new long[]{0x0000000000100000L,0x4000000000010000L,0x0000000100000004L});
	public static final BitSet FOLLOW_LPAREN_in_withStatement647 = new BitSet(new long[]{0x5200400CF7961400L,0x5B1941488AB1118CL,0x00000C0594430E03L});
	public static final BitSet FOLLOW_COMMA_in_withStatement663 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_subExpression_in_withStatement667 = new BitSet(new long[]{0x5200400CF7961400L,0x5B1941488AB1118CL,0x00000C0594430E03L});
	public static final BitSet FOLLOW_RPAREN_in_withStatement674 = new BitSet(new long[]{0x0000000000100000L,0x4000000000010000L,0x0000000100000004L});
	public static final BitSet FOLLOW_RPAREN_in_withStatement686 = new BitSet(new long[]{0x1200000CE7900402L,0x130141408A91000CL,0x00000C0080430C06L});
	public static final BitSet FOLLOW_selectStatement_in_withStatement699 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_assignment_in_assignmentList723 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_assignmentList727 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_assignment_in_assignmentList733 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_column_in_assignment755 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ASSIGNEQUAL_in_assignment758 = new BitSet(new long[]{0x5200400DF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_columnValue_in_assignment764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columnNameList786 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_columnNameList795 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_column_in_columnNameList801 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_columnValue_in_columnValueList831 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_columnValueList836 = new BitSet(new long[]{0x5200400DF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_columnValue_in_columnValueList842 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_DEFAULT_in_columnValue863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_columnValue874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subQueryExpression_in_queryExpression893 = new BitSet(new long[]{0x000A000000000002L,0x0000500001000000L,0x0000002000200080L});
	public static final BitSet FOLLOW_unionOperator_in_queryExpression905 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_subQueryExpression_in_queryExpression915 = new BitSet(new long[]{0x000A000000000002L,0x0000500001000000L,0x0000002000200080L});
	public static final BitSet FOLLOW_orderByClause_in_queryExpression933 = new BitSet(new long[]{0x000A000000000002L,0x0000100000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_fetchClause_in_queryExpression942 = new BitSet(new long[]{0x0008000000000002L,0x0000100000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_optimizeClause_in_queryExpression951 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_withClause_in_queryExpression960 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_startClause_in_queryExpression969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_querySpecification_in_subQueryExpression991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_subQueryExpression999 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_queryExpression_in_subQueryExpression1005 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_subQueryExpression1007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectClause_in_querySpecification1026 = new BitSet(new long[]{0x0A1A000000000002L,0x0000500000000000L,0x0000003000000080L});
	public static final BitSet FOLLOW_fromClause_in_querySpecification1037 = new BitSet(new long[]{0x0A0A000000000002L,0x0000500000000000L,0x0000003000000080L});
	public static final BitSet FOLLOW_whereClause_in_querySpecification1051 = new BitSet(new long[]{0x0A0A000000000002L,0x0000500000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_groupByClause_in_querySpecification1065 = new BitSet(new long[]{0x080A000000000002L,0x0000500000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_havingClause_in_querySpecification1080 = new BitSet(new long[]{0x000A000000000002L,0x0000500000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_orderByClause_in_querySpecification1096 = new BitSet(new long[]{0x000A000000000002L,0x0000100000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_fetchClause_in_querySpecification1105 = new BitSet(new long[]{0x0008000000000002L,0x0000100000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_optimizeClause_in_querySpecification1114 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000000L,0x0000002000000080L});
	public static final BitSet FOLLOW_withClause_in_querySpecification1123 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_startClause_in_querySpecification1132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_selectClause1152 = new BitSet(new long[]{0x5200401CF7861410L,0x1B1941488AB1118CL,0x00000C0494430E43L});
	public static final BitSet FOLLOW_selectList_in_selectClause1178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause1193 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_whereClause1199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_orderByClause1214 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_BY_in_orderByClause1216 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_orderExpression_in_orderByClause1224 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_orderByClause1231 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_orderExpression_in_orderByClause1237 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_expression_in_orderExpression1259 = new BitSet(new long[]{0x0000000800000102L,0x0000001000000000L});
	public static final BitSet FOLLOW_ASC_in_orderExpression1267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_orderExpression1271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULLS_in_orderExpression1276 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_FIRST_in_orderExpression1278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_groupByClause1294 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_BY_in_groupByClause1296 = new BitSet(new long[]{0x5200400CF7861410L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_ALL_in_groupByClause1305 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_groupByClause1318 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_groupByClause1323 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_groupByClause1330 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_HAVING_in_havingClause1349 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_havingClause1355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_fetchClause1372 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_FETCH_in_fetchClause1375 = new BitSet(new long[]{0x5204400CF7861400L,0x3B1949488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_FIRST_in_fetchClause1377 = new BitSet(new long[]{0x5200400CF7861400L,0x3B1949488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_fetchClause1380 = new BitSet(new long[]{0x0000000000000000L,0x3000080000000000L});
	public static final BitSet FOLLOW_rowAndRows_in_fetchClause1383 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_ONLY_in_fetchClause1386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIMIZE_in_optimizeClause1397 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_FOR_in_optimizeClause1399 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_optimizeClause1401 = new BitSet(new long[]{0x0000000000000000L,0x3000000000000000L});
	public static final BitSet FOLLOW_rowAndRows_in_optimizeClause1403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_withClause1418 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_READ_in_withClause1420 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_ONLY_in_withClause1422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_WITH_in_withClause1426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_UR_in_withClause1428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_START_in_startClause1440 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_WITH_in_startClause1442 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_startClause1444 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CONNECT_in_startClause1446 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_BY_in_startClause1448 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_PRIOR_in_startClause1450 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_startClause1452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_additiveSubSearchCondition_in_searchCondition1485 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
	public static final BitSet FOLLOW_OR_in_searchCondition1494 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_additiveSubSearchCondition_in_searchCondition1500 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
	public static final BitSet FOLLOW_subSearchCondition_in_additiveSubSearchCondition1525 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_AND_in_additiveSubSearchCondition1534 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_subSearchCondition_in_additiveSubSearchCondition1540 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_LPAREN_in_bracketedSearchCondition1562 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_bracketedSearchCondition1568 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_bracketedSearchCondition1570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_subSearchCondition1587 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_bracketedSearchCondition_in_subSearchCondition1614 = new BitSet(new long[]{0x0180000000004202L,0x0000000600006000L});
	public static final BitSet FOLLOW_comparisonOperator_in_subSearchCondition1618 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_subSearchCondition1620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_predicate_in_subSearchCondition1634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_predicate1664 = new BitSet(new long[]{0x8180000000004200L,0x000000070001E020L});
	public static final BitSet FOLLOW_plusSignature_in_predicate1668 = new BitSet(new long[]{0x8180000000004200L,0x000000070000E020L});
	public static final BitSet FOLLOW_comparisonOperator_in_predicate1696 = new BitSet(new long[]{0x5200400CF7861450L,0x1B1941488AB1118CL,0x00000C0494430E23L});
	public static final BitSet FOLLOW_expression_in_predicate1720 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_plusSignature_in_predicate1723 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_quantifierSpec_in_predicate1739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_predicate1749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_selectStatement_in_predicate1755 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_predicate1757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_predicate1780 = new BitSet(new long[]{0x0000000000000000L,0x0000000900000000L});
	public static final BitSet FOLLOW_NOT_in_predicate1791 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_NULL_in_predicate1796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_predicate1806 = new BitSet(new long[]{0x8000000000004000L,0x0000000000008000L});
	public static final BitSet FOLLOW_LIKE_in_predicate1819 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_predicate1825 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_ESCAPE_in_predicate1838 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_predicate1844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BETWEEN_in_predicate1858 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_predicate1864 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_predicate1866 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_predicate1872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IN_in_predicate1883 = new BitSet(new long[]{0x5200400CF7961400L,0x1B1941488AB1118CL,0x00000C0594430E07L});
	public static final BitSet FOLLOW_LPAREN_in_predicate1887 = new BitSet(new long[]{0x5200400CF7961400L,0x1B1941488AB1118CL,0x00000C0594430E07L});
	public static final BitSet FOLLOW_selectStatement_in_predicate1924 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
	public static final BitSet FOLLOW_expression_in_predicate1950 = new BitSet(new long[]{0x0000000000100002L,0x4000000000000000L});
	public static final BitSet FOLLOW_COMMA_in_predicate1965 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_predicate1971 = new BitSet(new long[]{0x0000000000100002L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_predicate1988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXISTS_in_predicate2004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_predicate2006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_selectStatement_in_predicate2012 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_predicate2014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_predicate2025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startClause_in_predicate2035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectItem_in_selectList2082 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_selectList2091 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E43L});
	public static final BitSet FOLLOW_selectItem_in_selectList2097 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_STAR_in_selectItem2115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dbObject_in_selectItem2121 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_DOT_STAR_in_selectItem2123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias2_in_selectItem2156 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_selectItem2162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableColumns_in_selectItem2187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_selectItem2200 = new BitSet(new long[]{0x1200000CE7800482L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_db2Element_in_selectItem2204 = new BitSet(new long[]{0x1200000CE7800482L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_selectItem2214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_fromClause2236 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080434E02L});
	public static final BitSet FOLLOW_TABLE_in_fromClause2240 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_tableSource_in_fromClause2245 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_fromClause2252 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_tableSource_in_fromClause2258 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_subTableSource_in_tableSource2279 = new BitSet(new long[]{0x0020000000400002L,0x0800000000001201L});
	public static final BitSet FOLLOW_joinedTable_in_tableSource2290 = new BitSet(new long[]{0x0020000000400002L,0x0800000000001201L});
	public static final BitSet FOLLOW_LPAREN_in_subTableSource2308 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E06L});
	public static final BitSet FOLLOW_joinedTables_in_subTableSource2332 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_subTableSource2334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_queryExpression_in_subTableSource2347 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_subTableSource2349 = new BitSet(new long[]{0x1200000CE7800482L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_subTableSource2356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_subTableSource2380 = new BitSet(new long[]{0x1200000CE7800482L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_subTableSource2388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_subTableSource2398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_VALUES_in_subTableSource2400 = new BitSet(new long[]{0x4000000000001000L,0x0000000800200188L,0x0000000010020001L});
	public static final BitSet FOLLOW_constant_in_subTableSource2402 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_subTableSource2404 = new BitSet(new long[]{0x1200000CE7800480L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_subTableSource2411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dbObject_in_subTableSource2423 = new BitSet(new long[]{0x1200000CE7800482L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_subTableSource2431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INNER_in_joinOn2454 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_set_in_joinOn2460 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000200L});
	public static final BitSet FOLLOW_OUTER_in_joinOn2490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_JOIN_in_joinOn2501 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_TABLE_in_joinOn2505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CROSS_in_joinedTable2521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_JOIN_in_joinedTable2523 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_subTableSource_in_joinedTable2529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_joinOn_in_joinedTable2546 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_tableSource_in_joinedTable2558 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_ON_in_joinedTable2567 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_joinedTable2573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subTableSource_in_joinedTables2597 = new BitSet(new long[]{0x0020000000400000L,0x0800000000001201L});
	public static final BitSet FOLLOW_joinedTable_in_joinedTables2610 = new BitSet(new long[]{0x0020000000400002L,0x0800000000001201L});
	public static final BitSet FOLLOW_AS_in_alias12630 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_identifier_in_alias12638 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_AS_in_alias12641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_alias22661 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ASSIGNEQUAL_in_alias22666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dbObject_in_tableColumns2683 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_DOT_STAR_in_tableColumns2685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dbObject_in_column2706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_column2714 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_column_in_column2720 = new BitSet(new long[]{0x0000000000100000L,0x4000000000000000L});
	public static final BitSet FOLLOW_COMMA_in_column2724 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_column_in_column2730 = new BitSet(new long[]{0x0000000000100000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_column2735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_additiveSubExpression_in_expression2755 = new BitSet(new long[]{0x0000000010000002L,0x0010000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_additiveOperator_in_expression2767 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_additiveSubExpression_in_expression2773 = new BitSet(new long[]{0x0000000010000002L,0x0010000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_subExpression_in_additiveSubExpression2794 = new BitSet(new long[]{0x5200402CF7861402L,0x1B1941488EB1118CL,0x00000C0494430E43L});
	public static final BitSet FOLLOW_multiplicativeArithmeticOperator_in_additiveSubExpression2807 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_subExpression_in_additiveSubExpression2816 = new BitSet(new long[]{0x5200402CF7861402L,0x1B1941488EB1118CL,0x00000C0494430E43L});
	public static final BitSet FOLLOW_LPAREN_in_bracketedTerm2834 = new BitSet(new long[]{0x5200400CF7961400L,0x5B1941488AB1118CL,0x00000C0494430E07L});
	public static final BitSet FOLLOW_selectStatement_in_bracketedTerm2838 = new BitSet(new long[]{0x5200400CF7861400L,0x5B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_bracketedTerm2841 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_functionArgument_in_bracketedTerm2851 = new BitSet(new long[]{0x5200400CF7961400L,0x5B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_COMMA_in_bracketedTerm2856 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_bracketedTerm2858 = new BitSet(new long[]{0x0000000000100000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_bracketedTerm2865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unaryOperator_in_subExpression2886 = new BitSet(new long[]{0x5200400CE7861400L,0x1B0941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_constant_in_subExpression2901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sharpObject_in_subExpression2914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupFunction_in_subExpression2926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_datetimeField_in_subExpression2938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_db2Element_in_subExpression2951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variableReference_in_subExpression2963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLACEHOLDER_in_subExpression2972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_subExpression2997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bracketedTerm_in_subExpression3010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dbObject_in_subExpression3023 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_plusSignature_in_subExpression3026 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_caseFunction_in_subExpression3084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_castFunction_in_subExpression3096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_variableReference3116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUBSTRING_in_function3132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_function3135 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_function3141 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_FROM_in_function3144 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_function3150 = new BitSet(new long[]{0x0008000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_FOR_in_function3155 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_function3161 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_function3166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXTRACT_in_function3173 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_function3177 = new BitSet(new long[]{0x1000000060000000L,0x000000000A000000L,0x0000040000000002L});
	public static final BitSet FOLLOW_datetimeField_in_function3183 = new BitSet(new long[]{0x5210400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_FROM_in_function3186 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_function3194 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_function3197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_genericFunction_in_function3207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NonQuotedIdentifier_in_genericFunction3240 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_DOT_in_genericFunction3242 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_NonQuotedIdentifier_in_genericFunction3246 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LEFT_in_genericFunction3255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_RIGHT_in_genericFunction3264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_genericFunction3271 = new BitSet(new long[]{0x5200401CF7861410L,0x5B1941488AB1118CL,0x00000C0494430E43L});
	public static final BitSet FOLLOW_functionArgument_in_genericFunction3283 = new BitSet(new long[]{0x5200400CF7961400L,0x5B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_functionArgument_in_genericFunction3289 = new BitSet(new long[]{0x0000000000100000L,0x4000000000000000L});
	public static final BitSet FOLLOW_COMMA_in_genericFunction3303 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_functionArgument_in_genericFunction3309 = new BitSet(new long[]{0x0000000000100000L,0x4000000000000000L});
	public static final BitSet FOLLOW_STAR_in_genericFunction3330 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_set_in_genericFunction3345 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E43L});
	public static final BitSet FOLLOW_STAR_in_genericFunction3362 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_expression_in_genericFunction3384 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_genericFunction3409 = new BitSet(new long[]{0x5200400CF7861402L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_genericFunction3413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_functionArgument3433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_datetimeField_in_functionArgument3444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAX_in_groupName3462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUM_in_groupName3472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AVG_in_groupName3482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MIN_in_groupName3493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NVL_in_groupName3503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATE_in_groupName3514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIME_in_groupName3523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMESTAMP_in_groupName3533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_in_groupName3542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_groupName3551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUE_in_groupName3560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OVER_in_groupName3569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROW_in_groupName3578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_UNDERSCOPE_in_groupName3580 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_groupName3582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DENSE_in_groupName3591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_UNDERSCOPE_in_groupName3593 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_RANK_in_groupName3595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANK_in_groupName3604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECODE_in_groupName3613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupName_in_groupFunction3634 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_groupFunction3636 = new BitSet(new long[]{0x5200401CF7861410L,0x5B1D41488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_ALL_in_groupFunction3644 = new BitSet(new long[]{0x5200400CF7861400L,0x5B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_DISTINCT_in_groupFunction3648 = new BitSet(new long[]{0x5200400CF7861400L,0x5B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_PARTITION_in_groupFunction3652 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_BY_in_groupFunction3654 = new BitSet(new long[]{0x5200400CF7861400L,0x5B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_functionArgument_in_groupFunction3669 = new BitSet(new long[]{0x0000000000100000L,0x4000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_groupFunction3672 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_functionArgument_in_groupFunction3678 = new BitSet(new long[]{0x0000000000100000L,0x4000400000000000L});
	public static final BitSet FOLLOW_orderByClause_in_groupFunction3693 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_groupFunction3703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_caseFunction3718 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0C94430E03L});
	public static final BitSet FOLLOW_expression_in_caseFunction3731 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_WHEN_in_caseFunction3742 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_caseFunction3748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_THEN_in_caseFunction3750 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_caseFunction3756 = new BitSet(new long[]{0x00000C0000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_WHEN_in_caseFunction3776 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_searchCondition_in_caseFunction3782 = new BitSet(new long[]{0x0180000000004200L,0x0000000600006000L,0x0000000000008000L});
	public static final BitSet FOLLOW_comparisonOperator_in_caseFunction3785 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_caseFunction3787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_THEN_in_caseFunction3791 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_caseFunction3797 = new BitSet(new long[]{0x00000C0000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_ELSE_in_caseFunction3818 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_caseFunction3824 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_END_in_caseFunction3829 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_CASE_in_caseFunction3833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAST_in_castFunction3861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_castFunction3863 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_castFunction3869 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_AS_in_castFunction3871 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_castFunction3877 = new BitSet(new long[]{0x0000000000000000L,0x4000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_castFunction3886 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_nonNegativeInteger_in_castFunction3892 = new BitSet(new long[]{0x0000000000100000L,0x4000000000000000L});
	public static final BitSet FOLLOW_COMMA_in_castFunction3897 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_nonNegativeInteger_in_castFunction3903 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_castFunction3908 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_castFunction3918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_sharpObject3937 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_DOT_in_sharpObject3939 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_UicodeValueLiteral_in_sharpObject3943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_dbObject3963 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_DOT_in_dbObject3972 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_identifier_in_dbObject3978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_plusSignature3999 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_PLUS_in_plusSignature4001 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_plusSignature4003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_singleStringLiteral_in_stringLiteral4025 = new BitSet(new long[]{0x0000000000001002L,0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_NonQuotedIdentifier_in_identifier4064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuotedIdentifier_in_identifier4071 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_identifier4077 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_identifier4083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orderByClause_in_identifier4089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_identifier4096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupByClause_in_identifier4103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupName_in_identifier4109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_datetimeField_in_identifier4115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_db2Element_in_identifier4121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTERVAL_in_identifier4127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NonQuotedIdentifier_in_typeIdentifier4140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nonNegativeInteger_in_constant4159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Real_in_constant4166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_constant4173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringLiteral_in_constant4184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intervalLiteral_in_constant4195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HexLiteral_in_constant4202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAccessDateTime_in_constant4212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Iso8601DateTime_in_constant4222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMESTAMP_in_constant4229 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_stringLiteral_in_constant4235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTERVAL_in_intervalLiteral4253 = new BitSet(new long[]{0x0000000010001000L,0x0010000000000000L});
	public static final BitSet FOLLOW_unaryOperator_in_intervalLiteral4261 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_AsciiStringLiteral_in_intervalLiteral4267 = new BitSet(new long[]{0x1000000060000000L,0x000000000A000000L,0x0000040000000002L});
	public static final BitSet FOLLOW_datetimeField_in_intervalLiteral4274 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_intervalLiteral4279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_Integer_in_intervalLiteral4281 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_intervalLiteral4284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_in_nonNegativeInteger4301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGNEQUAL_in_comparisonOperator4402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTEQUAL1_in_comparisonOperator4409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTEQUAL2_in_comparisonOperator4416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSTHAN_in_comparisonOperator4423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSTHANOREQUALTO1_in_comparisonOperator4430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATERTHANOREQUALTO1_in_comparisonOperator4436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATERTHAN_in_comparisonOperator4443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BETWEEN_in_comparisonOperator4450 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_subExpression_in_comparisonOperator4452 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_comparisonOperator4454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNION_in_unionOperator4469 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ALL_in_unionOperator4476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_unionOperator4485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURRENT_in_db2Element4554 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000030000L});
	public static final BitSet FOLLOW_set_in_db2Element4556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_db2Element4572 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000030000L});
	public static final BitSet FOLLOW_set_in_db2Element4574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURRENT_in_db2Element4590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMESTAMP_in_db2Element4596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYSDATE_in_db2Element4602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATE_in_db2Element4608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_db2Element4614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEARS_in_db2Element4620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEAR_in_db2Element4626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURRENT_DATE_in_db2Element4632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURRENT_TIME_in_db2Element4638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURRENT_TIMESTAMP_in_db2Element4644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEXT_in_db2Element4650 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_VALUE_in_db2Element4652 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_FOR_in_db2Element4654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred14_SQLAnalyzer228 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A91000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_columnNameList_in_synpred14_SQLAnalyzer234 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred14_SQLAnalyzer236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_synpred31_SQLAnalyzer624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred35_SQLAnalyzer663 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_subExpression_in_synpred35_SQLAnalyzer667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred37_SQLAnalyzer647 = new BitSet(new long[]{0x5200400CF7961400L,0x5B1941488AB1118CL,0x00000C0594430E03L});
	public static final BitSet FOLLOW_COMMA_in_synpred37_SQLAnalyzer663 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_subExpression_in_synpred37_SQLAnalyzer667 = new BitSet(new long[]{0x5200400CF7961400L,0x5B1941488AB1118CL,0x00000C0594430E03L});
	public static final BitSet FOLLOW_RPAREN_in_synpred37_SQLAnalyzer674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unionOperator_in_synpred44_SQLAnalyzer905 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_subQueryExpression_in_synpred44_SQLAnalyzer915 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orderByClause_in_synpred45_SQLAnalyzer933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fetchClause_in_synpred46_SQLAnalyzer942 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_optimizeClause_in_synpred47_SQLAnalyzer951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_withClause_in_synpred48_SQLAnalyzer960 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startClause_in_synpred49_SQLAnalyzer969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whereClause_in_synpred52_SQLAnalyzer1051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupByClause_in_synpred53_SQLAnalyzer1065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_havingClause_in_synpred54_SQLAnalyzer1080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orderByClause_in_synpred55_SQLAnalyzer1096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fetchClause_in_synpred56_SQLAnalyzer1105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_optimizeClause_in_synpred57_SQLAnalyzer1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_withClause_in_synpred58_SQLAnalyzer1123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startClause_in_synpred59_SQLAnalyzer1132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred62_SQLAnalyzer1231 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_orderExpression_in_synpred62_SQLAnalyzer1237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASC_in_synpred63_SQLAnalyzer1267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_synpred64_SQLAnalyzer1271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULLS_in_synpred65_SQLAnalyzer1276 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_FIRST_in_synpred65_SQLAnalyzer1278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred67_SQLAnalyzer1323 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred67_SQLAnalyzer1330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_synpred74_SQLAnalyzer1494 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_additiveSubSearchCondition_in_synpred74_SQLAnalyzer1500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_synpred75_SQLAnalyzer1534 = new BitSet(new long[]{0x5200600CF7861400L,0x1B1941498AB1118CL,0x00000C0494430E83L});
	public static final BitSet FOLLOW_subSearchCondition_in_synpred75_SQLAnalyzer1540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bracketedSearchCondition_in_synpred77_SQLAnalyzer1599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comparisonOperator_in_synpred78_SQLAnalyzer1618 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred78_SQLAnalyzer1620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comparisonOperator_in_synpred82_SQLAnalyzer1696 = new BitSet(new long[]{0x5200400CF7861450L,0x1B1941488AB1118CL,0x00000C0494430E23L});
	public static final BitSet FOLLOW_expression_in_synpred82_SQLAnalyzer1720 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_plusSignature_in_synpred82_SQLAnalyzer1723 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_quantifierSpec_in_synpred82_SQLAnalyzer1739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_synpred82_SQLAnalyzer1749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_selectStatement_in_synpred82_SQLAnalyzer1755 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred82_SQLAnalyzer1757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred89_SQLAnalyzer1887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_synpred90_SQLAnalyzer1904 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred93_SQLAnalyzer1965 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred93_SQLAnalyzer1971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RPAREN_in_synpred94_SQLAnalyzer1988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1664 = new BitSet(new long[]{0x8180000000004200L,0x000000070001E020L});
	public static final BitSet FOLLOW_plusSignature_in_synpred95_SQLAnalyzer1668 = new BitSet(new long[]{0x8180000000004200L,0x000000070000E020L});
	public static final BitSet FOLLOW_comparisonOperator_in_synpred95_SQLAnalyzer1696 = new BitSet(new long[]{0x5200400CF7861450L,0x1B1941488AB1118CL,0x00000C0494430E23L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1720 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_plusSignature_in_synpred95_SQLAnalyzer1723 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_quantifierSpec_in_synpred95_SQLAnalyzer1739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_synpred95_SQLAnalyzer1749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_selectStatement_in_synpred95_SQLAnalyzer1755 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred95_SQLAnalyzer1757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_synpred95_SQLAnalyzer1780 = new BitSet(new long[]{0x0000000000000000L,0x0000000900000000L});
	public static final BitSet FOLLOW_NOT_in_synpred95_SQLAnalyzer1791 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_NULL_in_synpred95_SQLAnalyzer1796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_synpred95_SQLAnalyzer1806 = new BitSet(new long[]{0x8000000000004000L,0x0000000000008000L});
	public static final BitSet FOLLOW_LIKE_in_synpred95_SQLAnalyzer1819 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1825 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_ESCAPE_in_synpred95_SQLAnalyzer1838 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BETWEEN_in_synpred95_SQLAnalyzer1858 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1864 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_synpred95_SQLAnalyzer1866 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IN_in_synpred95_SQLAnalyzer1883 = new BitSet(new long[]{0x5200400CF7961400L,0x1B1941488AB1118CL,0x00000C0594430E07L});
	public static final BitSet FOLLOW_LPAREN_in_synpred95_SQLAnalyzer1887 = new BitSet(new long[]{0x5200400CF7961400L,0x1B1941488AB1118CL,0x00000C0594430E07L});
	public static final BitSet FOLLOW_selectStatement_in_synpred95_SQLAnalyzer1924 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1950 = new BitSet(new long[]{0x0000000000100002L,0x4000000000000000L});
	public static final BitSet FOLLOW_COMMA_in_synpred95_SQLAnalyzer1965 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred95_SQLAnalyzer1971 = new BitSet(new long[]{0x0000000000100002L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred95_SQLAnalyzer1988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_synpred97_SQLAnalyzer2025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred100_SQLAnalyzer2091 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E43L});
	public static final BitSet FOLLOW_selectItem_in_synpred100_SQLAnalyzer2097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dbObject_in_synpred102_SQLAnalyzer2121 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_DOT_STAR_in_synpred102_SQLAnalyzer2123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias2_in_synpred103_SQLAnalyzer2139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableColumns_in_synpred104_SQLAnalyzer2178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_db2Element_in_synpred105_SQLAnalyzer2204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias1_in_synpred106_SQLAnalyzer2214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred108_SQLAnalyzer2252 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E02L});
	public static final BitSet FOLLOW_tableSource_in_synpred108_SQLAnalyzer2258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_joinedTable_in_synpred109_SQLAnalyzer2290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_joinedTables_in_synpred110_SQLAnalyzer2317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias1_in_synpred111_SQLAnalyzer2356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred112_SQLAnalyzer2308 = new BitSet(new long[]{0x1200400CE7800400L,0x1B0141408A91100CL,0x00000C0080430E06L});
	public static final BitSet FOLLOW_joinedTables_in_synpred112_SQLAnalyzer2332 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred112_SQLAnalyzer2334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_queryExpression_in_synpred112_SQLAnalyzer2347 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred112_SQLAnalyzer2349 = new BitSet(new long[]{0x1200000CE7800482L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_synpred112_SQLAnalyzer2356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias1_in_synpred113_SQLAnalyzer2388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_synpred114_SQLAnalyzer2380 = new BitSet(new long[]{0x1200000CE7800482L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_synpred114_SQLAnalyzer2388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred115_SQLAnalyzer2398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_VALUES_in_synpred115_SQLAnalyzer2400 = new BitSet(new long[]{0x4000000000001000L,0x0000000800200188L,0x0000000010020001L});
	public static final BitSet FOLLOW_constant_in_synpred115_SQLAnalyzer2402 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred115_SQLAnalyzer2404 = new BitSet(new long[]{0x1200000CE7800480L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_alias1_in_synpred115_SQLAnalyzer2411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias1_in_synpred116_SQLAnalyzer2431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AS_in_synpred126_SQLAnalyzer2641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_additiveOperator_in_synpred129_SQLAnalyzer2767 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_additiveSubExpression_in_synpred129_SQLAnalyzer2773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multiplicativeArithmeticOperator_in_synpred131_SQLAnalyzer2807 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_subExpression_in_synpred131_SQLAnalyzer2816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_synpred133_SQLAnalyzer2838 = new BitSet(new long[]{0x5200400CF7861402L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_expression_in_synpred133_SQLAnalyzer2841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_in_synpred137_SQLAnalyzer2901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sharpObject_in_synpred138_SQLAnalyzer2914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupFunction_in_synpred139_SQLAnalyzer2926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_datetimeField_in_synpred140_SQLAnalyzer2938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_db2Element_in_synpred141_SQLAnalyzer2951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_synpred144_SQLAnalyzer2982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bracketedTerm_in_synpred145_SQLAnalyzer3010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_plusSignature_in_synpred146_SQLAnalyzer3026 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dbObject_in_synpred147_SQLAnalyzer3023 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_plusSignature_in_synpred147_SQLAnalyzer3026 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred164_SQLAnalyzer3413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred165_SQLAnalyzer3433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionArgument_in_synpred185_SQLAnalyzer3669 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_COMMA_in_synpred185_SQLAnalyzer3672 = new BitSet(new long[]{0x5200400CF7861400L,0x1B1941488AB1118CL,0x00000C0494430E03L});
	public static final BitSet FOLLOW_functionArgument_in_synpred185_SQLAnalyzer3678 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_CASE_in_synpred192_SQLAnalyzer3833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_synpred196_SQLAnalyzer3972 = new BitSet(new long[]{0x1200000CE7800400L,0x130141408A90000CL,0x00000C0080430C02L});
	public static final BitSet FOLLOW_identifier_in_synpred196_SQLAnalyzer3978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_singleStringLiteral_in_synpred197_SQLAnalyzer4025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupName_in_synpred206_SQLAnalyzer4109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_datetimeField_in_synpred207_SQLAnalyzer4115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_db2Element_in_synpred208_SQLAnalyzer4121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred218_SQLAnalyzer4279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_Integer_in_synpred218_SQLAnalyzer4281 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred218_SQLAnalyzer4284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURRENT_in_synpred241_SQLAnalyzer4554 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000030000L});
	public static final BitSet FOLLOW_set_in_synpred241_SQLAnalyzer4556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURRENT_in_synpred245_SQLAnalyzer4590 = new BitSet(new long[]{0x0000000000000002L});
}
