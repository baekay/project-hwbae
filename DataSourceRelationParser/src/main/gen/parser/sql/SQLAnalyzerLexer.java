// $ANTLR 3.5.1 parser\\sql\\SQLAnalyzer.g 2014-06-15 18:16:16

package parser.sql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class SQLAnalyzerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SQLAnalyzerLexer() {} 
	public SQLAnalyzerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SQLAnalyzerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "parser\\sql\\SQLAnalyzer.g"; }

	// $ANTLR start "ALL"
	public final void mALL() throws RecognitionException {
		try {
			int _type = ALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:844:5: ( A_ L_ L_ )
			// parser\\sql\\SQLAnalyzer.g:844:7: A_ L_ L_
			{
			mA_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALL"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:845:5: ( A_ N_ D_ )
			// parser\\sql\\SQLAnalyzer.g:845:7: A_ N_ D_
			{
			mA_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "ANY"
	public final void mANY() throws RecognitionException {
		try {
			int _type = ANY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:846:5: ( A_ N_ Y_ )
			// parser\\sql\\SQLAnalyzer.g:846:7: A_ N_ Y_
			{
			mA_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mY_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ANY"

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:847:4: ( A_ S_ )
			// parser\\sql\\SQLAnalyzer.g:847:6: A_ S_
			{
			mA_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "ASC"
	public final void mASC() throws RecognitionException {
		try {
			int _type = ASC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:848:5: ( A_ S_ C_ )
			// parser\\sql\\SQLAnalyzer.g:848:7: A_ S_ C_
			{
			mA_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASC"

	// $ANTLR start "AVG"
	public final void mAVG() throws RecognitionException {
		try {
			int _type = AVG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:849:5: ( A_ V_ G_ )
			// parser\\sql\\SQLAnalyzer.g:849:7: A_ V_ G_
			{
			mA_(); if (state.failed) return;

			mV_(); if (state.failed) return;

			mG_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AVG"

	// $ANTLR start "BETWEEN"
	public final void mBETWEEN() throws RecognitionException {
		try {
			int _type = BETWEEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:850:9: ( B_ E_ T_ W_ E_ E_ N_ )
			// parser\\sql\\SQLAnalyzer.g:850:11: B_ E_ T_ W_ E_ E_ N_
			{
			mB_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mW_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BETWEEN"

	// $ANTLR start "BY"
	public final void mBY() throws RecognitionException {
		try {
			int _type = BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:851:4: ( B_ Y_ )
			// parser\\sql\\SQLAnalyzer.g:851:6: B_ Y_
			{
			mB_(); if (state.failed) return;

			mY_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BY"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:852:6: ( C_ A_ S_ E_ )
			// parser\\sql\\SQLAnalyzer.g:852:8: C_ A_ S_ E_
			{
			mC_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "CAST"
	public final void mCAST() throws RecognitionException {
		try {
			int _type = CAST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:853:6: ( C_ A_ S_ T_ )
			// parser\\sql\\SQLAnalyzer.g:853:8: C_ A_ S_ T_
			{
			mC_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CAST"

	// $ANTLR start "CONNECT"
	public final void mCONNECT() throws RecognitionException {
		try {
			int _type = CONNECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:854:9: ( C_ O_ N_ N_ E_ C_ T_ )
			// parser\\sql\\SQLAnalyzer.g:854:11: C_ O_ N_ N_ E_ C_ T_
			{
			mC_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONNECT"

	// $ANTLR start "CROSS"
	public final void mCROSS() throws RecognitionException {
		try {
			int _type = CROSS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:855:7: ( C_ R_ O_ S_ S_ )
			// parser\\sql\\SQLAnalyzer.g:855:9: C_ R_ O_ S_ S_
			{
			mC_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CROSS"

	// $ANTLR start "CURRENT"
	public final void mCURRENT() throws RecognitionException {
		try {
			int _type = CURRENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:856:9: ( C_ U_ R_ R_ E_ N_ T_ )
			// parser\\sql\\SQLAnalyzer.g:856:11: C_ U_ R_ R_ E_ N_ T_
			{
			mC_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURRENT"

	// $ANTLR start "CURRENT_DATE"
	public final void mCURRENT_DATE() throws RecognitionException {
		try {
			int _type = CURRENT_DATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:857:14: ( C_ U_ R_ R_ E_ N_ T_ UNDER_ D_ A_ T_ E_ )
			// parser\\sql\\SQLAnalyzer.g:857:16: C_ U_ R_ R_ E_ N_ T_ UNDER_ D_ A_ T_ E_
			{
			mC_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mUNDER_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURRENT_DATE"

	// $ANTLR start "CURRENT_TIME"
	public final void mCURRENT_TIME() throws RecognitionException {
		try {
			int _type = CURRENT_TIME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:858:14: ( C_ U_ R_ R_ E_ N_ T_ UNDER_ T_ I_ M_ E_ )
			// parser\\sql\\SQLAnalyzer.g:858:16: C_ U_ R_ R_ E_ N_ T_ UNDER_ T_ I_ M_ E_
			{
			mC_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mUNDER_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURRENT_TIME"

	// $ANTLR start "CURRENT_TIMESTAMP"
	public final void mCURRENT_TIMESTAMP() throws RecognitionException {
		try {
			int _type = CURRENT_TIMESTAMP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:859:19: ( C_ U_ R_ R_ E_ N_ T_ UNDER_ T_ I_ M_ E_ S_ T_ A_ M_ P_ )
			// parser\\sql\\SQLAnalyzer.g:859:21: C_ U_ R_ R_ E_ N_ T_ UNDER_ T_ I_ M_ E_ S_ T_ A_ M_ P_
			{
			mC_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mUNDER_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mP_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURRENT_TIMESTAMP"

	// $ANTLR start "DATE"
	public final void mDATE() throws RecognitionException {
		try {
			int _type = DATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:860:6: ( D_ A_ T_ E_ )
			// parser\\sql\\SQLAnalyzer.g:860:8: D_ A_ T_ E_
			{
			mD_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATE"

	// $ANTLR start "DAY"
	public final void mDAY() throws RecognitionException {
		try {
			int _type = DAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:861:5: ( D_ A_ Y_ )
			// parser\\sql\\SQLAnalyzer.g:861:7: D_ A_ Y_
			{
			mD_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mY_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DAY"

	// $ANTLR start "DECODE"
	public final void mDECODE() throws RecognitionException {
		try {
			int _type = DECODE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:862:8: ( D_ E_ C_ O_ D_ E_ )
			// parser\\sql\\SQLAnalyzer.g:862:10: D_ E_ C_ O_ D_ E_
			{
			mD_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECODE"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:863:9: ( D_ E_ F_ A_ U_ L_ T_ )
			// parser\\sql\\SQLAnalyzer.g:863:11: D_ E_ F_ A_ U_ L_ T_
			{
			mD_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mF_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "DELETE"
	public final void mDELETE() throws RecognitionException {
		try {
			int _type = DELETE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:864:8: ( D_ E_ L_ E_ T_ E_ )
			// parser\\sql\\SQLAnalyzer.g:864:10: D_ E_ L_ E_ T_ E_
			{
			mD_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DELETE"

	// $ANTLR start "DENSE"
	public final void mDENSE() throws RecognitionException {
		try {
			int _type = DENSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:865:7: ( D_ E_ N_ S_ E_ )
			// parser\\sql\\SQLAnalyzer.g:865:9: D_ E_ N_ S_ E_
			{
			mD_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DENSE"

	// $ANTLR start "DESC"
	public final void mDESC() throws RecognitionException {
		try {
			int _type = DESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:866:6: ( D_ E_ S_ C_ )
			// parser\\sql\\SQLAnalyzer.g:866:8: D_ E_ S_ C_
			{
			mD_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DESC"

	// $ANTLR start "DISTINCT"
	public final void mDISTINCT() throws RecognitionException {
		try {
			int _type = DISTINCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:867:10: ( D_ I_ S_ T_ I_ N_ C_ T_ )
			// parser\\sql\\SQLAnalyzer.g:867:12: D_ I_ S_ T_ I_ N_ C_ T_
			{
			mD_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DISTINCT"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:868:6: ( E_ L_ S_ E_ )
			// parser\\sql\\SQLAnalyzer.g:868:8: E_ L_ S_ E_
			{
			mE_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:869:5: ( E_ N_ D_ )
			// parser\\sql\\SQLAnalyzer.g:869:7: E_ N_ D_
			{
			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "ESCAPE"
	public final void mESCAPE() throws RecognitionException {
		try {
			int _type = ESCAPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:870:8: ( E_ S_ C_ A_ P_ E_ )
			// parser\\sql\\SQLAnalyzer.g:870:10: E_ S_ C_ A_ P_ E_
			{
			mE_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mP_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESCAPE"

	// $ANTLR start "EXISTS"
	public final void mEXISTS() throws RecognitionException {
		try {
			int _type = EXISTS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:871:8: ( E_ X_ I_ S_ T_ S_ )
			// parser\\sql\\SQLAnalyzer.g:871:10: E_ X_ I_ S_ T_ S_
			{
			mE_(); if (state.failed) return;

			mX_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXISTS"

	// $ANTLR start "EXTRACT"
	public final void mEXTRACT() throws RecognitionException {
		try {
			int _type = EXTRACT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:872:9: ( E_ X_ T_ R_ A_ C_ T_ )
			// parser\\sql\\SQLAnalyzer.g:872:11: E_ X_ T_ R_ A_ C_ T_
			{
			mE_(); if (state.failed) return;

			mX_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRACT"

	// $ANTLR start "FETCH"
	public final void mFETCH() throws RecognitionException {
		try {
			int _type = FETCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:873:7: ( F_ E_ T_ C_ H_ )
			// parser\\sql\\SQLAnalyzer.g:873:9: F_ E_ T_ C_ H_
			{
			mF_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FETCH"

	// $ANTLR start "FIRST"
	public final void mFIRST() throws RecognitionException {
		try {
			int _type = FIRST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:874:7: ( F_ I_ R_ S_ T_ )
			// parser\\sql\\SQLAnalyzer.g:874:9: F_ I_ R_ S_ T_
			{
			mF_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIRST"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:875:5: ( F_ O_ R_ )
			// parser\\sql\\SQLAnalyzer.g:875:7: F_ O_ R_
			{
			mF_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "FROM"
	public final void mFROM() throws RecognitionException {
		try {
			int _type = FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:876:6: ( F_ R_ O_ M_ )
			// parser\\sql\\SQLAnalyzer.g:876:8: F_ R_ O_ M_
			{
			mF_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FROM"

	// $ANTLR start "FULL"
	public final void mFULL() throws RecognitionException {
		try {
			int _type = FULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:877:6: ( F_ U_ L_ L_ )
			// parser\\sql\\SQLAnalyzer.g:877:8: F_ U_ L_ L_
			{
			mF_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FULL"

	// $ANTLR start "GROUP"
	public final void mGROUP() throws RecognitionException {
		try {
			int _type = GROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:878:7: ( G_ R_ O_ U_ P_ )
			// parser\\sql\\SQLAnalyzer.g:878:9: G_ R_ O_ U_ P_
			{
			mG_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mP_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GROUP"

	// $ANTLR start "HAVING"
	public final void mHAVING() throws RecognitionException {
		try {
			int _type = HAVING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:879:8: ( H_ A_ V_ I_ N_ G_ )
			// parser\\sql\\SQLAnalyzer.g:879:10: H_ A_ V_ I_ N_ G_
			{
			mH_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mV_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mG_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HAVING"

	// $ANTLR start "HOUR"
	public final void mHOUR() throws RecognitionException {
		try {
			int _type = HOUR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:880:6: ( H_ O_ U_ R_ )
			// parser\\sql\\SQLAnalyzer.g:880:8: H_ O_ U_ R_
			{
			mH_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HOUR"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:881:4: ( I_ N_ )
			// parser\\sql\\SQLAnalyzer.g:881:6: I_ N_
			{
			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "INNER"
	public final void mINNER() throws RecognitionException {
		try {
			int _type = INNER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:882:7: ( I_ N_ N_ E_ R_ )
			// parser\\sql\\SQLAnalyzer.g:882:9: I_ N_ N_ E_ R_
			{
			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INNER"

	// $ANTLR start "INSERT"
	public final void mINSERT() throws RecognitionException {
		try {
			int _type = INSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:883:8: ( I_ N_ S_ E_ R_ T_ )
			// parser\\sql\\SQLAnalyzer.g:883:10: I_ N_ S_ E_ R_ T_
			{
			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INSERT"

	// $ANTLR start "INTERVAL"
	public final void mINTERVAL() throws RecognitionException {
		try {
			int _type = INTERVAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:884:10: ( I_ N_ T_ E_ R_ V_ A_ L_ )
			// parser\\sql\\SQLAnalyzer.g:884:12: I_ N_ T_ E_ R_ V_ A_ L_
			{
			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mV_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTERVAL"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:885:5: ( I_ N_ T_ )
			// parser\\sql\\SQLAnalyzer.g:885:7: I_ N_ T_
			{
			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "INTO"
	public final void mINTO() throws RecognitionException {
		try {
			int _type = INTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:886:6: ( I_ N_ T_ O_ )
			// parser\\sql\\SQLAnalyzer.g:886:8: I_ N_ T_ O_
			{
			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTO"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:887:4: ( I_ S_ )
			// parser\\sql\\SQLAnalyzer.g:887:6: I_ S_
			{
			mI_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "JOIN"
	public final void mJOIN() throws RecognitionException {
		try {
			int _type = JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:888:6: ( J_ O_ I_ N_ )
			// parser\\sql\\SQLAnalyzer.g:888:8: J_ O_ I_ N_
			{
			mJ_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOIN"

	// $ANTLR start "LEFT"
	public final void mLEFT() throws RecognitionException {
		try {
			int _type = LEFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:889:6: ( L_ E_ F_ T_ )
			// parser\\sql\\SQLAnalyzer.g:889:8: L_ E_ F_ T_
			{
			mL_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mF_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT"

	// $ANTLR start "LIKE"
	public final void mLIKE() throws RecognitionException {
		try {
			int _type = LIKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:890:6: ( L_ I_ K_ E_ )
			// parser\\sql\\SQLAnalyzer.g:890:8: L_ I_ K_ E_
			{
			mL_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mK_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIKE"

	// $ANTLR start "MATCHED"
	public final void mMATCHED() throws RecognitionException {
		try {
			int _type = MATCHED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:891:9: ( M_ A_ T_ C_ H_ E_ D_ )
			// parser\\sql\\SQLAnalyzer.g:891:11: M_ A_ T_ C_ H_ E_ D_
			{
			mM_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MATCHED"

	// $ANTLR start "MAX"
	public final void mMAX() throws RecognitionException {
		try {
			int _type = MAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:892:5: ( M_ A_ X_ )
			// parser\\sql\\SQLAnalyzer.g:892:7: M_ A_ X_
			{
			mM_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mX_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAX"

	// $ANTLR start "MERGE"
	public final void mMERGE() throws RecognitionException {
		try {
			int _type = MERGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:893:7: ( M_ E_ R_ G_ E_ )
			// parser\\sql\\SQLAnalyzer.g:893:9: M_ E_ R_ G_ E_
			{
			mM_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mG_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MERGE"

	// $ANTLR start "MIN"
	public final void mMIN() throws RecognitionException {
		try {
			int _type = MIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:894:5: ( M_ I_ N_ )
			// parser\\sql\\SQLAnalyzer.g:894:7: M_ I_ N_
			{
			mM_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MIN"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:895:7: ( M_ I_ N_ U_ S_ )
			// parser\\sql\\SQLAnalyzer.g:895:9: M_ I_ N_ U_ S_
			{
			mM_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MINUTE"
	public final void mMINUTE() throws RecognitionException {
		try {
			int _type = MINUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:896:8: ( M_ I_ N_ U_ T_ E_ )
			// parser\\sql\\SQLAnalyzer.g:896:10: M_ I_ N_ U_ T_ E_
			{
			mM_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUTE"

	// $ANTLR start "MONTH"
	public final void mMONTH() throws RecognitionException {
		try {
			int _type = MONTH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:897:7: ( M_ O_ N_ T_ H_ )
			// parser\\sql\\SQLAnalyzer.g:897:9: M_ O_ N_ T_ H_
			{
			mM_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MONTH"

	// $ANTLR start "NEXT"
	public final void mNEXT() throws RecognitionException {
		try {
			int _type = NEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:898:6: ( N_ E_ X_ T_ )
			// parser\\sql\\SQLAnalyzer.g:898:8: N_ E_ X_ T_
			{
			mN_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mX_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEXT"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:899:5: ( N_ O_ T_ )
			// parser\\sql\\SQLAnalyzer.g:899:7: N_ O_ T_
			{
			mN_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:900:6: ( N_ U_ L_ L_ )
			// parser\\sql\\SQLAnalyzer.g:900:8: N_ U_ L_ L_
			{
			mN_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "NULLS"
	public final void mNULLS() throws RecognitionException {
		try {
			int _type = NULLS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:901:7: ( N_ U_ L_ L_ S_ )
			// parser\\sql\\SQLAnalyzer.g:901:9: N_ U_ L_ L_ S_
			{
			mN_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULLS"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:902:9: ( N_ U_ M_ B_ E_ R_ )
			// parser\\sql\\SQLAnalyzer.g:902:11: N_ U_ M_ B_ E_ R_
			{
			mN_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mB_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "NVL"
	public final void mNVL() throws RecognitionException {
		try {
			int _type = NVL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:903:5: ( N_ V_ L_ )
			// parser\\sql\\SQLAnalyzer.g:903:7: N_ V_ L_
			{
			mN_(); if (state.failed) return;

			mV_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NVL"

	// $ANTLR start "ON"
	public final void mON() throws RecognitionException {
		try {
			int _type = ON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:904:4: ( O_ N_ )
			// parser\\sql\\SQLAnalyzer.g:904:6: O_ N_
			{
			mO_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ON"

	// $ANTLR start "ONLY"
	public final void mONLY() throws RecognitionException {
		try {
			int _type = ONLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:905:6: ( O_ N_ L_ Y_ )
			// parser\\sql\\SQLAnalyzer.g:905:8: O_ N_ L_ Y_
			{
			mO_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mY_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ONLY"

	// $ANTLR start "OPTIMIZE"
	public final void mOPTIMIZE() throws RecognitionException {
		try {
			int _type = OPTIMIZE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:906:10: ( O_ P_ T_ I_ M_ I_ Z_ E_ )
			// parser\\sql\\SQLAnalyzer.g:906:12: O_ P_ T_ I_ M_ I_ Z_ E_
			{
			mO_(); if (state.failed) return;

			mP_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mZ_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTIMIZE"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:907:4: ( O_ R_ )
			// parser\\sql\\SQLAnalyzer.g:907:6: O_ R_
			{
			mO_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "ORDER"
	public final void mORDER() throws RecognitionException {
		try {
			int _type = ORDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:908:7: ( O_ R_ D_ E_ R_ )
			// parser\\sql\\SQLAnalyzer.g:908:9: O_ R_ D_ E_ R_
			{
			mO_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORDER"

	// $ANTLR start "OUTER"
	public final void mOUTER() throws RecognitionException {
		try {
			int _type = OUTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:909:7: ( O_ U_ T_ E_ R_ )
			// parser\\sql\\SQLAnalyzer.g:909:9: O_ U_ T_ E_ R_
			{
			mO_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTER"

	// $ANTLR start "OVER"
	public final void mOVER() throws RecognitionException {
		try {
			int _type = OVER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:910:6: ( O_ V_ E_ R_ )
			// parser\\sql\\SQLAnalyzer.g:910:8: O_ V_ E_ R_
			{
			mO_(); if (state.failed) return;

			mV_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OVER"

	// $ANTLR start "PARTITION"
	public final void mPARTITION() throws RecognitionException {
		try {
			int _type = PARTITION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:911:11: ( P_ A_ R_ T_ I_ T_ I_ O_ N_ )
			// parser\\sql\\SQLAnalyzer.g:911:13: P_ A_ R_ T_ I_ T_ I_ O_ N_
			{
			mP_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PARTITION"

	// $ANTLR start "PRIOR"
	public final void mPRIOR() throws RecognitionException {
		try {
			int _type = PRIOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:912:7: ( P_ R_ I_ O_ R_ )
			// parser\\sql\\SQLAnalyzer.g:912:9: P_ R_ I_ O_ R_
			{
			mP_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRIOR"

	// $ANTLR start "RANK"
	public final void mRANK() throws RecognitionException {
		try {
			int _type = RANK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:913:6: ( R_ A_ N_ K_ )
			// parser\\sql\\SQLAnalyzer.g:913:8: R_ A_ N_ K_
			{
			mR_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mK_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANK"

	// $ANTLR start "READ"
	public final void mREAD() throws RecognitionException {
		try {
			int _type = READ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:914:6: ( R_ E_ A_ D_ )
			// parser\\sql\\SQLAnalyzer.g:914:8: R_ E_ A_ D_
			{
			mR_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "READ"

	// $ANTLR start "ROW"
	public final void mROW() throws RecognitionException {
		try {
			int _type = ROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:915:5: ( R_ O_ W_ )
			// parser\\sql\\SQLAnalyzer.g:915:7: R_ O_ W_
			{
			mR_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mW_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROW"

	// $ANTLR start "ROWS"
	public final void mROWS() throws RecognitionException {
		try {
			int _type = ROWS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:916:6: ( R_ O_ W_ S_ )
			// parser\\sql\\SQLAnalyzer.g:916:8: R_ O_ W_ S_
			{
			mR_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mW_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROWS"

	// $ANTLR start "RIGHT"
	public final void mRIGHT() throws RecognitionException {
		try {
			int _type = RIGHT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:917:7: ( R_ I_ G_ H_ T_ )
			// parser\\sql\\SQLAnalyzer.g:917:9: R_ I_ G_ H_ T_
			{
			mR_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mG_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT"

	// $ANTLR start "SECOND"
	public final void mSECOND() throws RecognitionException {
		try {
			int _type = SECOND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:918:8: ( S_ E_ C_ O_ N_ D_ )
			// parser\\sql\\SQLAnalyzer.g:918:10: S_ E_ C_ O_ N_ D_
			{
			mS_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SECOND"

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:919:8: ( S_ E_ L_ E_ C_ T_ )
			// parser\\sql\\SQLAnalyzer.g:919:10: S_ E_ L_ E_ C_ T_
			{
			mS_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mC_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "SET"
	public final void mSET() throws RecognitionException {
		try {
			int _type = SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:920:5: ( S_ E_ T_ )
			// parser\\sql\\SQLAnalyzer.g:920:7: S_ E_ T_
			{
			mS_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET"

	// $ANTLR start "SOME"
	public final void mSOME() throws RecognitionException {
		try {
			int _type = SOME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:921:6: ( S_ O_ M_ E_ )
			// parser\\sql\\SQLAnalyzer.g:921:8: S_ O_ M_ E_
			{
			mS_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SOME"

	// $ANTLR start "START"
	public final void mSTART() throws RecognitionException {
		try {
			int _type = START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:922:7: ( S_ T_ A_ R_ T_ )
			// parser\\sql\\SQLAnalyzer.g:922:9: S_ T_ A_ R_ T_
			{
			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "START"

	// $ANTLR start "SUBSTRING"
	public final void mSUBSTRING() throws RecognitionException {
		try {
			int _type = SUBSTRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:923:11: ( S_ U_ B_ S_ T_ R_ I_ N_ G_ )
			// parser\\sql\\SQLAnalyzer.g:923:13: S_ U_ B_ S_ T_ R_ I_ N_ G_
			{
			mS_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mB_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mG_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBSTRING"

	// $ANTLR start "SUM"
	public final void mSUM() throws RecognitionException {
		try {
			int _type = SUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:924:5: ( S_ U_ M_ )
			// parser\\sql\\SQLAnalyzer.g:924:7: S_ U_ M_
			{
			mS_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUM"

	// $ANTLR start "SYSDATE"
	public final void mSYSDATE() throws RecognitionException {
		try {
			int _type = SYSDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:925:9: ( S_ Y_ S_ D_ A_ T_ E_ )
			// parser\\sql\\SQLAnalyzer.g:925:11: S_ Y_ S_ D_ A_ T_ E_
			{
			mS_(); if (state.failed) return;

			mY_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SYSDATE"

	// $ANTLR start "TABLE"
	public final void mTABLE() throws RecognitionException {
		try {
			int _type = TABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:926:7: ( T_ A_ B_ L_ E_ )
			// parser\\sql\\SQLAnalyzer.g:926:9: T_ A_ B_ L_ E_
			{
			mT_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mB_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TABLE"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:927:6: ( T_ H_ E_ N_ )
			// parser\\sql\\SQLAnalyzer.g:927:8: T_ H_ E_ N_
			{
			mT_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "TIME"
	public final void mTIME() throws RecognitionException {
		try {
			int _type = TIME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:928:6: ( T_ I_ M_ E_ )
			// parser\\sql\\SQLAnalyzer.g:928:8: T_ I_ M_ E_
			{
			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIME"

	// $ANTLR start "TIMESTAMP"
	public final void mTIMESTAMP() throws RecognitionException {
		try {
			int _type = TIMESTAMP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:929:10: ( T_ I_ M_ E_ S_ T_ A_ M_ P_ )
			// parser\\sql\\SQLAnalyzer.g:929:12: T_ I_ M_ E_ S_ T_ A_ M_ P_
			{
			mT_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mM_(); if (state.failed) return;

			mP_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMESTAMP"

	// $ANTLR start "UNION"
	public final void mUNION() throws RecognitionException {
		try {
			int _type = UNION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:930:7: ( U_ N_ I_ O_ N_ )
			// parser\\sql\\SQLAnalyzer.g:930:9: U_ N_ I_ O_ N_
			{
			mU_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mO_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNION"

	// $ANTLR start "UPDATE"
	public final void mUPDATE() throws RecognitionException {
		try {
			int _type = UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:931:8: ( U_ P_ D_ A_ T_ E_ )
			// parser\\sql\\SQLAnalyzer.g:931:10: U_ P_ D_ A_ T_ E_
			{
			mU_(); if (state.failed) return;

			mP_(); if (state.failed) return;

			mD_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPDATE"

	// $ANTLR start "UR"
	public final void mUR() throws RecognitionException {
		try {
			int _type = UR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:932:4: ( U_ R_ )
			// parser\\sql\\SQLAnalyzer.g:932:6: U_ R_
			{
			mU_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UR"

	// $ANTLR start "USING"
	public final void mUSING() throws RecognitionException {
		try {
			int _type = USING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:933:7: ( U_ S_ I_ N_ G_ )
			// parser\\sql\\SQLAnalyzer.g:933:9: U_ S_ I_ N_ G_
			{
			mU_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			mG_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USING"

	// $ANTLR start "VALUE"
	public final void mVALUE() throws RecognitionException {
		try {
			int _type = VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:934:7: ( V_ A_ L_ U_ E_ )
			// parser\\sql\\SQLAnalyzer.g:934:9: V_ A_ L_ U_ E_
			{
			mV_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUE"

	// $ANTLR start "VALUES"
	public final void mVALUES() throws RecognitionException {
		try {
			int _type = VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:935:8: ( V_ A_ L_ U_ E_ S_ )
			// parser\\sql\\SQLAnalyzer.g:935:10: V_ A_ L_ U_ E_ S_
			{
			mV_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mL_(); if (state.failed) return;

			mU_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUES"

	// $ANTLR start "WHEN"
	public final void mWHEN() throws RecognitionException {
		try {
			int _type = WHEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:936:6: ( W_ H_ E_ N_ )
			// parser\\sql\\SQLAnalyzer.g:936:8: W_ H_ E_ N_
			{
			mW_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mN_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHEN"

	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:937:7: ( W_ H_ E_ R_ E_ )
			// parser\\sql\\SQLAnalyzer.g:937:9: W_ H_ E_ R_ E_
			{
			mW_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHERE"

	// $ANTLR start "WITH"
	public final void mWITH() throws RecognitionException {
		try {
			int _type = WITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:938:7: ( W_ I_ T_ H_ )
			// parser\\sql\\SQLAnalyzer.g:938:9: W_ I_ T_ H_
			{
			mW_(); if (state.failed) return;

			mI_(); if (state.failed) return;

			mT_(); if (state.failed) return;

			mH_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WITH"

	// $ANTLR start "YEAR"
	public final void mYEAR() throws RecognitionException {
		try {
			int _type = YEAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:939:6: ( Y_ E_ A_ R_ )
			// parser\\sql\\SQLAnalyzer.g:939:8: Y_ E_ A_ R_
			{
			mY_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "YEAR"

	// $ANTLR start "YEARS"
	public final void mYEARS() throws RecognitionException {
		try {
			int _type = YEARS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:940:7: ( Y_ E_ A_ R_ S_ )
			// parser\\sql\\SQLAnalyzer.g:940:9: Y_ E_ A_ R_ S_
			{
			mY_(); if (state.failed) return;

			mE_(); if (state.failed) return;

			mA_(); if (state.failed) return;

			mR_(); if (state.failed) return;

			mS_(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "YEARS"

	// $ANTLR start "DOT_STAR"
	public final void mDOT_STAR() throws RecognitionException {
		try {
			int _type = DOT_STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:942:9: ( '.*' )
			// parser\\sql\\SQLAnalyzer.g:942:11: '.*'
			{
			match(".*"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT_STAR"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:943:5: ( '.' )
			// parser\\sql\\SQLAnalyzer.g:943:7: '.'
			{
			match('.'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:944:7: ( ',' )
			// parser\\sql\\SQLAnalyzer.g:944:9: ','
			{
			match(','); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:945:8: ( '(' )
			// parser\\sql\\SQLAnalyzer.g:945:10: '('
			{
			match('('); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:946:8: ( ')' )
			// parser\\sql\\SQLAnalyzer.g:946:10: ')'
			{
			match(')'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "UNDERSCOPE"
	public final void mUNDERSCOPE() throws RecognitionException {
		try {
			int _type = UNDERSCOPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:948:12: ( '_' )
			// parser\\sql\\SQLAnalyzer.g:948:14: '_'
			{
			match('_'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNDERSCOPE"

	// $ANTLR start "DASH"
	public final void mDASH() throws RecognitionException {
		try {
			int _type = DASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:949:6: ( '-' )
			// parser\\sql\\SQLAnalyzer.g:949:8: '-'
			{
			match('-'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DASH"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:950:7: ( ':' )
			// parser\\sql\\SQLAnalyzer.g:950:9: ':'
			{
			match(':'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:951:11: ( ';' )
			// parser\\sql\\SQLAnalyzer.g:951:13: ';'
			{
			match(';'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "ASSIGNEQUAL"
	public final void mASSIGNEQUAL() throws RecognitionException {
		try {
			int _type = ASSIGNEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:953:13: ( '=' )
			// parser\\sql\\SQLAnalyzer.g:953:15: '='
			{
			match('='); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGNEQUAL"

	// $ANTLR start "NOTEQUAL1"
	public final void mNOTEQUAL1() throws RecognitionException {
		try {
			int _type = NOTEQUAL1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:954:11: ( '<>' )
			// parser\\sql\\SQLAnalyzer.g:954:13: '<>'
			{
			match("<>"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTEQUAL1"

	// $ANTLR start "NOTEQUAL2"
	public final void mNOTEQUAL2() throws RecognitionException {
		try {
			int _type = NOTEQUAL2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:955:11: ( '!=' )
			// parser\\sql\\SQLAnalyzer.g:955:13: '!='
			{
			match("!="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTEQUAL2"

	// $ANTLR start "LESSTHANOREQUALTO1"
	public final void mLESSTHANOREQUALTO1() throws RecognitionException {
		try {
			int _type = LESSTHANOREQUALTO1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:956:20: ( '<=' )
			// parser\\sql\\SQLAnalyzer.g:956:22: '<='
			{
			match("<="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSTHANOREQUALTO1"

	// $ANTLR start "LESSTHAN"
	public final void mLESSTHAN() throws RecognitionException {
		try {
			int _type = LESSTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:957:10: ( '<' )
			// parser\\sql\\SQLAnalyzer.g:957:12: '<'
			{
			match('<'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSTHAN"

	// $ANTLR start "GREATERTHANOREQUALTO1"
	public final void mGREATERTHANOREQUALTO1() throws RecognitionException {
		try {
			int _type = GREATERTHANOREQUALTO1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:958:23: ( '>=' )
			// parser\\sql\\SQLAnalyzer.g:958:25: '>='
			{
			match(">="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATERTHANOREQUALTO1"

	// $ANTLR start "GREATERTHAN"
	public final void mGREATERTHAN() throws RecognitionException {
		try {
			int _type = GREATERTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:959:13: ( '>' )
			// parser\\sql\\SQLAnalyzer.g:959:15: '>'
			{
			match('>'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATERTHAN"

	// $ANTLR start "DIVIDE"
	public final void mDIVIDE() throws RecognitionException {
		try {
			int _type = DIVIDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:961:8: ( '/' )
			// parser\\sql\\SQLAnalyzer.g:961:10: '/'
			{
			match('/'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVIDE"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:962:6: ( '+' )
			// parser\\sql\\SQLAnalyzer.g:962:8: '+'
			{
			match('+'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:963:6: ( '*' )
			// parser\\sql\\SQLAnalyzer.g:963:8: '*'
			{
			match('*'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:964:5: ( '%' )
			// parser\\sql\\SQLAnalyzer.g:964:7: '%'
			{
			match('%'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "STRCONCAT"
	public final void mSTRCONCAT() throws RecognitionException {
		try {
			int _type = STRCONCAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:966:11: ( '||' )
			// parser\\sql\\SQLAnalyzer.g:966:13: '||'
			{
			match("||"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRCONCAT"

	// $ANTLR start "PLACEHOLDER"
	public final void mPLACEHOLDER() throws RecognitionException {
		try {
			int _type = PLACEHOLDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:968:12: ( '?' )
			// parser\\sql\\SQLAnalyzer.g:968:14: '?'
			{
			match('?'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLACEHOLDER"

	// $ANTLR start "Letter"
	public final void mLetter() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:972:8: ( 'a' .. 'z' | 'A' .. 'Z' | '\\u3131' .. '\\u318E' | '\\uAC00' .. '\\uD7A3' | '@' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( (input.LA(1) >= '@' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u3131' && input.LA(1) <= '\u318E')||(input.LA(1) >= '\uAC00' && input.LA(1) <= '\uD7A3') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Letter"

	// $ANTLR start "Digit"
	public final void mDigit() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:975:7: ( '0' .. '9' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Digit"

	// $ANTLR start "Integer"
	public final void mInteger() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:978:9: ()
			// parser\\sql\\SQLAnalyzer.g:978:10: 
			{
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Integer"

	// $ANTLR start "Real"
	public final void mReal() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:981:6: ()
			// parser\\sql\\SQLAnalyzer.g:981:7: 
			{
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Real"

	// $ANTLR start "Exponent"
	public final void mExponent() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:984:10: ( 'e' ( '+' | '-' )? ( Digit )+ )
			// parser\\sql\\SQLAnalyzer.g:985:3: 'e' ( '+' | '-' )? ( Digit )+
			{
			match('e'); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:985:7: ( '+' | '-' )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='+'||LA1_0=='-') ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// parser\\sql\\SQLAnalyzer.g:985:22: ( Digit )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Exponent"

	// $ANTLR start "A_"
	public final void mA_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:987:13: ( 'A' | 'a' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "A_"

	// $ANTLR start "B_"
	public final void mB_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:988:13: ( 'B' | 'b' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "B_"

	// $ANTLR start "C_"
	public final void mC_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:989:13: ( 'C' | 'c' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "C_"

	// $ANTLR start "D_"
	public final void mD_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:990:13: ( 'D' | 'd' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D_"

	// $ANTLR start "E_"
	public final void mE_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:991:13: ( 'E' | 'e' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "E_"

	// $ANTLR start "F_"
	public final void mF_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:992:13: ( 'F' | 'f' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "F_"

	// $ANTLR start "G_"
	public final void mG_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:993:13: ( 'G' | 'g' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "G_"

	// $ANTLR start "H_"
	public final void mH_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:994:13: ( 'H' | 'h' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "H_"

	// $ANTLR start "I_"
	public final void mI_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:995:13: ( 'I' | 'i' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "I_"

	// $ANTLR start "J_"
	public final void mJ_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:996:13: ( 'J' | 'j' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "J_"

	// $ANTLR start "K_"
	public final void mK_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:997:13: ( 'K' | 'k' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_"

	// $ANTLR start "L_"
	public final void mL_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:998:13: ( 'L' | 'l' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "L_"

	// $ANTLR start "M_"
	public final void mM_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:999:13: ( 'M' | 'm' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "M_"

	// $ANTLR start "N_"
	public final void mN_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1000:13: ( 'N' | 'n' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "N_"

	// $ANTLR start "O_"
	public final void mO_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1001:13: ( 'O' | 'o' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "O_"

	// $ANTLR start "P_"
	public final void mP_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1002:13: ( 'P' | 'p' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "P_"

	// $ANTLR start "Q_"
	public final void mQ_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1003:13: ( 'Q' | 'q' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Q_"

	// $ANTLR start "R_"
	public final void mR_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1004:13: ( 'R' | 'r' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "R_"

	// $ANTLR start "S_"
	public final void mS_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1005:13: ( 'S' | 's' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "S_"

	// $ANTLR start "T_"
	public final void mT_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1006:13: ( 'T' | 't' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T_"

	// $ANTLR start "U_"
	public final void mU_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1007:13: ( 'U' | 'u' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "U_"

	// $ANTLR start "V_"
	public final void mV_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1008:13: ( 'V' | 'v' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "V_"

	// $ANTLR start "W_"
	public final void mW_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1009:13: ( 'W' | 'w' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "W_"

	// $ANTLR start "X_"
	public final void mX_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1010:13: ( 'X' | 'x' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "X_"

	// $ANTLR start "Y_"
	public final void mY_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1011:13: ( 'Y' | 'y' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Y_"

	// $ANTLR start "Z_"
	public final void mZ_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1012:13: ( 'Z' | 'z' )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Z_"

	// $ANTLR start "UNDER_"
	public final void mUNDER_() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1013:17: ( '_' )
			// parser\\sql\\SQLAnalyzer.g:1013:19: '_'
			{
			match('_'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNDER_"

	// $ANTLR start "MAccessDateTime"
	public final void mMAccessDateTime() throws RecognitionException {
		try {
			int _type = MAccessDateTime;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1015:17: ( '#' Digit Digit Digit Digit '-' Digit Digit '-' Digit Digit ' ' Digit Digit ':' Digit Digit ':' Digit Digit '#' )
			// parser\\sql\\SQLAnalyzer.g:1016:3: '#' Digit Digit Digit Digit '-' Digit Digit '-' Digit Digit ' ' Digit Digit ':' Digit Digit ':' Digit Digit '#'
			{
			match('#'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match('-'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match('-'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match(' '); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match(':'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match(':'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match('#'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAccessDateTime"

	// $ANTLR start "Iso8601DateTime"
	public final void mIso8601DateTime() throws RecognitionException {
		try {
			int _type = Iso8601DateTime;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1022:17: ( Digit Digit Digit Digit '-' Digit Digit '-' Digit Digit ( 't' | ' ' ) Digit Digit ':' Digit Digit ':' Digit Digit )
			// parser\\sql\\SQLAnalyzer.g:1023:3: Digit Digit Digit Digit '-' Digit Digit '-' Digit Digit ( 't' | ' ' ) Digit Digit ':' Digit Digit ':' Digit Digit
			{
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match('-'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match('-'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			if ( input.LA(1)==' '||input.LA(1)=='t' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match(':'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			match(':'); if (state.failed) return;
			mDigit(); if (state.failed) return;

			mDigit(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Iso8601DateTime"

	// $ANTLR start "Number"
	public final void mNumber() throws RecognitionException {
		try {
			int _type = Number;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1028:8: ( ( ( Digit )+ ( '.' | 'e' ) )=> ( Digit )+ ( '.' ( Digit )* ( Exponent )? | Exponent ) | '.' ( ( Digit )+ ( Exponent )? )? | ( Digit )+ | '0x' ( 'a' .. 'f' | Digit )* )
			int alt12=4;
			alt12 = dfa12.predict(input);
			switch (alt12) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:1029:3: ( ( Digit )+ ( '.' | 'e' ) )=> ( Digit )+ ( '.' ( Digit )* ( Exponent )? | Exponent )
					{
					// parser\\sql\\SQLAnalyzer.g:1029:31: ( Digit )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					// parser\\sql\\SQLAnalyzer.g:1029:40: ( '.' ( Digit )* ( Exponent )? | Exponent )
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0=='.') ) {
						alt6=1;
					}
					else if ( (LA6_0=='e') ) {
						alt6=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						throw nvae;
					}

					switch (alt6) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:1029:42: '.' ( Digit )* ( Exponent )?
							{
							match('.'); if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:1029:46: ( Digit )*
							loop4:
							while (true) {
								int alt4=2;
								int LA4_0 = input.LA(1);
								if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
									alt4=1;
								}

								switch (alt4) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
										state.failed=false;
									}
									else {
										if (state.backtracking>0) {state.failed=true; return;}
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									break loop4;
								}
							}

							// parser\\sql\\SQLAnalyzer.g:1029:55: ( Exponent )?
							int alt5=2;
							int LA5_0 = input.LA(1);
							if ( (LA5_0=='e') ) {
								alt5=1;
							}
							switch (alt5) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:1029:56: Exponent
									{
									mExponent(); if (state.failed) return;

									}
									break;

							}

							}
							break;
						case 2 :
							// parser\\sql\\SQLAnalyzer.g:1029:69: Exponent
							{
							mExponent(); if (state.failed) return;

							}
							break;

					}

					if ( state.backtracking==0 ) { _type = Real; }
					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:1030:5: '.' ( ( Digit )+ ( Exponent )? )?
					{
					match('.'); if (state.failed) return;
					if ( state.backtracking==0 ) { _type = DOT; }
					// parser\\sql\\SQLAnalyzer.g:1030:26: ( ( Digit )+ ( Exponent )? )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:1030:28: ( Digit )+ ( Exponent )?
							{
							// parser\\sql\\SQLAnalyzer.g:1030:28: ( Digit )+
							int cnt7=0;
							loop7:
							while (true) {
								int alt7=2;
								int LA7_0 = input.LA(1);
								if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
									alt7=1;
								}

								switch (alt7) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
										state.failed=false;
									}
									else {
										if (state.backtracking>0) {state.failed=true; return;}
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									if ( cnt7 >= 1 ) break loop7;
									if (state.backtracking>0) {state.failed=true; return;}
									EarlyExitException eee = new EarlyExitException(7, input);
									throw eee;
								}
								cnt7++;
							}

							// parser\\sql\\SQLAnalyzer.g:1030:37: ( Exponent )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0=='e') ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:1030:38: Exponent
									{
									mExponent(); if (state.failed) return;

									}
									break;

							}

							if ( state.backtracking==0 ) { _type = Real; }
							}
							break;

					}

					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:1031:5: ( Digit )+
					{
					// parser\\sql\\SQLAnalyzer.g:1031:5: ( Digit )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					if ( state.backtracking==0 ) { _type = Integer; }
					}
					break;
				case 4 :
					// parser\\sql\\SQLAnalyzer.g:1032:5: '0x' ( 'a' .. 'f' | Digit )*
					{
					match("0x"); if (state.failed) return;

					// parser\\sql\\SQLAnalyzer.g:1032:10: ( 'a' .. 'f' | Digit )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'a' && LA11_0 <= 'f')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop11;
						}
					}

					if ( state.backtracking==0 ) { _type = HexLiteral; }
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Number"

	// $ANTLR start "WordTail"
	public final void mWordTail() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1037:10: ( ( Letter | Digit | UNDERSCOPE | COLON )* )
			// parser\\sql\\SQLAnalyzer.g:1038:3: ( Letter | Digit | UNDERSCOPE | COLON )*
			{
			// parser\\sql\\SQLAnalyzer.g:1038:3: ( Letter | Digit | UNDERSCOPE | COLON )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '0' && LA13_0 <= ':')||(LA13_0 >= '@' && LA13_0 <= 'Z')||LA13_0=='_'||(LA13_0 >= 'a' && LA13_0 <= 'z')||(LA13_0 >= '\u3131' && LA13_0 <= '\u318E')||(LA13_0 >= '\uAC00' && LA13_0 <= '\uD7A3')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= ':')||(input.LA(1) >= '@' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u3131' && input.LA(1) <= '\u318E')||(input.LA(1) >= '\uAC00' && input.LA(1) <= '\uD7A3') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop13;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WordTail"

	// $ANTLR start "NonQuotedIdentifier"
	public final void mNonQuotedIdentifier() throws RecognitionException {
		try {
			int _type = NonQuotedIdentifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1040:21: ( Letter WordTail )
			// parser\\sql\\SQLAnalyzer.g:1040:23: Letter WordTail
			{
			mLetter(); if (state.failed) return;

			mWordTail(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NonQuotedIdentifier"

	// $ANTLR start "QuotedIdentifier"
	public final void mQuotedIdentifier() throws RecognitionException {
		try {
			int _type = QuotedIdentifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1042:18: ( '[' (~ ']' )* ']' ( ']' (~ ']' )* ']' )* | '\"' (~ '\"' )* '\"' ( '\"' (~ '\"' )* '\"' )* | '`' (~ '`' )* '`' )
			int alt21=3;
			switch ( input.LA(1) ) {
			case '[':
				{
				alt21=1;
				}
				break;
			case '\"':
				{
				alt21=2;
				}
				break;
			case '`':
				{
				alt21=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:1043:3: '[' (~ ']' )* ']' ( ']' (~ ']' )* ']' )*
					{
					match('['); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:1043:7: (~ ']' )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( ((LA14_0 >= '\u0000' && LA14_0 <= '\\')||(LA14_0 >= '^' && LA14_0 <= '\uFFFF')) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\\')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop14;
						}
					}

					match(']'); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:1043:19: ( ']' (~ ']' )* ']' )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0==']') ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:1043:20: ']' (~ ']' )* ']'
							{
							match(']'); if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:1043:24: (~ ']' )*
							loop15:
							while (true) {
								int alt15=2;
								int LA15_0 = input.LA(1);
								if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\\')||(LA15_0 >= '^' && LA15_0 <= '\uFFFF')) ) {
									alt15=1;
								}

								switch (alt15) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:
									{
									if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\\')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
										input.consume();
										state.failed=false;
									}
									else {
										if (state.backtracking>0) {state.failed=true; return;}
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									break loop15;
								}
							}

							match(']'); if (state.failed) return;
							}
							break;

						default :
							break loop16;
						}
					}

					}
					break;
				case 2 :
					// parser\\sql\\SQLAnalyzer.g:1044:5: '\"' (~ '\"' )* '\"' ( '\"' (~ '\"' )* '\"' )*
					{
					match('\"'); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:1044:9: (~ '\"' )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( ((LA17_0 >= '\u0000' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= '\uFFFF')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop17;
						}
					}

					match('\"'); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:1044:21: ( '\"' (~ '\"' )* '\"' )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0=='\"') ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:1044:22: '\"' (~ '\"' )* '\"'
							{
							match('\"'); if (state.failed) return;
							// parser\\sql\\SQLAnalyzer.g:1044:26: (~ '\"' )*
							loop18:
							while (true) {
								int alt18=2;
								int LA18_0 = input.LA(1);
								if ( ((LA18_0 >= '\u0000' && LA18_0 <= '!')||(LA18_0 >= '#' && LA18_0 <= '\uFFFF')) ) {
									alt18=1;
								}

								switch (alt18) {
								case 1 :
									// parser\\sql\\SQLAnalyzer.g:
									{
									if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
										input.consume();
										state.failed=false;
									}
									else {
										if (state.backtracking>0) {state.failed=true; return;}
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									break loop18;
								}
							}

							match('\"'); if (state.failed) return;
							}
							break;

						default :
							break loop19;
						}
					}

					}
					break;
				case 3 :
					// parser\\sql\\SQLAnalyzer.g:1045:5: '`' (~ '`' )* '`'
					{
					match('`'); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:1045:9: (~ '`' )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( ((LA20_0 >= '\u0000' && LA20_0 <= '_')||(LA20_0 >= 'a' && LA20_0 <= '\uFFFF')) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '_')||(input.LA(1) >= 'a' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop20;
						}
					}

					match('`'); if (state.failed) return;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QuotedIdentifier"

	// $ANTLR start "Variable"
	public final void mVariable() throws RecognitionException {
		try {
			int _type = Variable;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1056:10: ( ( '@' | ':' ) Letter WordTail )
			// parser\\sql\\SQLAnalyzer.g:1057:3: ( '@' | ':' ) Letter WordTail
			{
			if ( input.LA(1)==':'||input.LA(1)=='@' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			mLetter(); if (state.failed) return;

			mWordTail(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Variable"

	// $ANTLR start "AsciiStringRun"
	public final void mAsciiStringRun() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1062:16: ( ( '\\t' | ' ' .. '&' | '(' .. '~' )+ )
			// parser\\sql\\SQLAnalyzer.g:1064:3: ( '\\t' | ' ' .. '&' | '(' .. '~' )+
			{
			// parser\\sql\\SQLAnalyzer.g:1064:3: ( '\\t' | ' ' .. '&' | '(' .. '~' )+
			int cnt22=0;
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0=='\t'||(LA22_0 >= ' ' && LA22_0 <= '&')||(LA22_0 >= '(' && LA22_0 <= '~')) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( input.LA(1)=='\t'||(input.LA(1) >= ' ' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '~') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt22 >= 1 ) break loop22;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(22, input);
					throw eee;
				}
				cnt22++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AsciiStringRun"

	// $ANTLR start "AsciiStringLiteral"
	public final void mAsciiStringLiteral() throws RecognitionException {
		try {
			int _type = AsciiStringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken s=null;

			// parser\\sql\\SQLAnalyzer.g:1066:20: ( '\\'' (s= AsciiStringRun )? '\\'' ( '\\'' (s= AsciiStringRun )? '\\'' )* )
			// parser\\sql\\SQLAnalyzer.g:1067:3: '\\'' (s= AsciiStringRun )? '\\'' ( '\\'' (s= AsciiStringRun )? '\\'' )*
			{
			match('\''); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:1068:3: (s= AsciiStringRun )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0=='\t'||(LA23_0 >= ' ' && LA23_0 <= '&')||(LA23_0 >= '(' && LA23_0 <= '~')) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:1068:5: s= AsciiStringRun
					{
					int sStart2594 = getCharIndex();
					int sStartLine2594 = getLine();
					int sStartCharPos2594 = getCharPositionInLine();
					mAsciiStringRun(); if (state.failed) return;
					s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart2594, getCharIndex()-1);
					s.setLine(sStartLine2594);
					s.setCharPositionInLine(sStartCharPos2594);

					}
					break;

			}

			match('\''); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:1069:3: ( '\\'' (s= AsciiStringRun )? '\\'' )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0=='\'') ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:1069:5: '\\'' (s= AsciiStringRun )? '\\''
					{
					match('\''); if (state.failed) return;
					// parser\\sql\\SQLAnalyzer.g:1069:10: (s= AsciiStringRun )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0=='\t'||(LA24_0 >= ' ' && LA24_0 <= '&')||(LA24_0 >= '(' && LA24_0 <= '~')) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// parser\\sql\\SQLAnalyzer.g:1069:12: s= AsciiStringRun
							{
							int sStart2614 = getCharIndex();
							int sStartLine2614 = getLine();
							int sStartCharPos2614 = getCharPositionInLine();
							mAsciiStringRun(); if (state.failed) return;
							s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart2614, getCharIndex()-1);
							s.setLine(sStartLine2614);
							s.setCharPositionInLine(sStartCharPos2614);

							}
							break;

					}

					match('\''); if (state.failed) return;
					}
					break;

				default :
					break loop25;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AsciiStringLiteral"

	// $ANTLR start "UnicodeStringRun"
	public final void mUnicodeStringRun() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1089:18: (~ ( '\\u0022' | '\\u005C' | '\\u0027' ) )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UnicodeStringRun"

	// $ANTLR start "UnicodeStringValue"
	public final void mUnicodeStringValue() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1093:20: (~ ( '\\u0023' | '\\u0024' ) )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\"')||(input.LA(1) >= '%' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UnicodeStringValue"

	// $ANTLR start "UicodeValueLiteral"
	public final void mUicodeValueLiteral() throws RecognitionException {
		try {
			int _type = UicodeValueLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1094:20: ( ( '#' | '$' ) ( UnicodeStringValue )+ ( '#' | '$' ) )
			// parser\\sql\\SQLAnalyzer.g:1095:3: ( '#' | '$' ) ( UnicodeStringValue )+ ( '#' | '$' )
			{
			if ( (input.LA(1) >= '#' && input.LA(1) <= '$') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// parser\\sql\\SQLAnalyzer.g:1095:17: ( UnicodeStringValue )+
			int cnt26=0;
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( ((LA26_0 >= '\u0000' && LA26_0 <= '\"')||(LA26_0 >= '%' && LA26_0 <= '\uFFFF')) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\"')||(input.LA(1) >= '%' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt26 >= 1 ) break loop26;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(26, input);
					throw eee;
				}
				cnt26++;
			}

			if ( (input.LA(1) >= '#' && input.LA(1) <= '$') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UicodeValueLiteral"

	// $ANTLR start "UnicodeColumnValue"
	public final void mUnicodeColumnValue() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1099:20: (~ ( '\\u0023' | '\\u0024' | '\\u002E' ) )
			// parser\\sql\\SQLAnalyzer.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\"')||(input.LA(1) >= '%' && input.LA(1) <= '-')||(input.LA(1) >= '/' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UnicodeColumnValue"

	// $ANTLR start "UnicodeStringLiteral"
	public final void mUnicodeStringLiteral() throws RecognitionException {
		try {
			int _type = UnicodeStringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1100:22: ( '\\'' ( UnicodeStringRun )+ '\\'' )
			// parser\\sql\\SQLAnalyzer.g:1101:3: '\\'' ( UnicodeStringRun )+ '\\''
			{
			match('\''); if (state.failed) return;
			// parser\\sql\\SQLAnalyzer.g:1101:8: ( UnicodeStringRun )+
			int cnt27=0;
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( ((LA27_0 >= '\u0000' && LA27_0 <= '!')||(LA27_0 >= '#' && LA27_0 <= '&')||(LA27_0 >= '(' && LA27_0 <= '[')||(LA27_0 >= ']' && LA27_0 <= '\uFFFF')) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt27 >= 1 ) break loop27;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(27, input);
					throw eee;
				}
				cnt27++;
			}

			match('\''); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UnicodeStringLiteral"

	// $ANTLR start "HexLiteral"
	public final void mHexLiteral() throws RecognitionException {
		try {
			// parser\\sql\\SQLAnalyzer.g:1105:12: ()
			// parser\\sql\\SQLAnalyzer.g:1107:3: 
			{
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HexLiteral"

	// $ANTLR start "SingleLineComment"
	public final void mSingleLineComment() throws RecognitionException {
		try {
			int _type = SingleLineComment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1109:2: ( '--' (~ ( '\\r' | '\\n' ) )* )
			// parser\\sql\\SQLAnalyzer.g:1109:4: '--' (~ ( '\\r' | '\\n' ) )*
			{
			match("--"); if (state.failed) return;

			// parser\\sql\\SQLAnalyzer.g:1109:9: (~ ( '\\r' | '\\n' ) )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( ((LA28_0 >= '\u0000' && LA28_0 <= '\t')||(LA28_0 >= '\u000B' && LA28_0 <= '\f')||(LA28_0 >= '\u000E' && LA28_0 <= '\uFFFF')) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop28;
				}
			}

			if ( state.backtracking==0 ) {skip();}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SingleLineComment"

	// $ANTLR start "MultiLineComment"
	public final void mMultiLineComment() throws RecognitionException {
		try {
			int _type = MultiLineComment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1113:2: ( '/*' ( . )* '*/' )
			// parser\\sql\\SQLAnalyzer.g:1113:4: '/*' ( . )* '*/'
			{
			match("/*"); if (state.failed) return;

			// parser\\sql\\SQLAnalyzer.g:1113:9: ( . )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0=='*') ) {
					int LA29_1 = input.LA(2);
					if ( (LA29_1=='/') ) {
						alt29=2;
					}
					else if ( ((LA29_1 >= '\u0000' && LA29_1 <= '.')||(LA29_1 >= '0' && LA29_1 <= '\uFFFF')) ) {
						alt29=1;
					}

				}
				else if ( ((LA29_0 >= '\u0000' && LA29_0 <= ')')||(LA29_0 >= '+' && LA29_0 <= '\uFFFF')) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:1113:9: .
					{
					matchAny(); if (state.failed) return;
					}
					break;

				default :
					break loop29;
				}
			}

			match("*/"); if (state.failed) return;

			if ( state.backtracking==0 ) {skip();}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MultiLineComment"

	// $ANTLR start "MultiLineComment2"
	public final void mMultiLineComment2() throws RecognitionException {
		try {
			int _type = MultiLineComment2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1117:2: ( '<!--' ( . )* '-->' )
			// parser\\sql\\SQLAnalyzer.g:1117:4: '<!--' ( . )* '-->'
			{
			match("<!--"); if (state.failed) return;

			// parser\\sql\\SQLAnalyzer.g:1117:11: ( . )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0=='-') ) {
					int LA30_1 = input.LA(2);
					if ( (LA30_1=='-') ) {
						int LA30_3 = input.LA(3);
						if ( (LA30_3=='>') ) {
							alt30=2;
						}
						else if ( ((LA30_3 >= '\u0000' && LA30_3 <= '=')||(LA30_3 >= '?' && LA30_3 <= '\uFFFF')) ) {
							alt30=1;
						}

					}
					else if ( ((LA30_1 >= '\u0000' && LA30_1 <= ',')||(LA30_1 >= '.' && LA30_1 <= '\uFFFF')) ) {
						alt30=1;
					}

				}
				else if ( ((LA30_0 >= '\u0000' && LA30_0 <= ',')||(LA30_0 >= '.' && LA30_0 <= '\uFFFF')) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:1117:11: .
					{
					matchAny(); if (state.failed) return;
					}
					break;

				default :
					break loop30;
				}
			}

			match("-->"); if (state.failed) return;

			if ( state.backtracking==0 ) {skip();}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MultiLineComment2"

	// $ANTLR start "Whitespace"
	public final void mWhitespace() throws RecognitionException {
		try {
			int _type = Whitespace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// parser\\sql\\SQLAnalyzer.g:1120:12: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// parser\\sql\\SQLAnalyzer.g:1120:14: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// parser\\sql\\SQLAnalyzer.g:1120:14: ( '\\t' | ' ' | '\\r' | '\\n' )+
			int cnt31=0;
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( ((LA31_0 >= '\t' && LA31_0 <= '\n')||LA31_0=='\r'||LA31_0==' ') ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// parser\\sql\\SQLAnalyzer.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
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

			if ( state.backtracking==0 ) { _channel=HIDDEN; }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Whitespace"

	@Override
	public void mTokens() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:1:8: ( ALL | AND | ANY | AS | ASC | AVG | BETWEEN | BY | CASE | CAST | CONNECT | CROSS | CURRENT | CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | DATE | DAY | DECODE | DEFAULT | DELETE | DENSE | DESC | DISTINCT | ELSE | END | ESCAPE | EXISTS | EXTRACT | FETCH | FIRST | FOR | FROM | FULL | GROUP | HAVING | HOUR | IN | INNER | INSERT | INTERVAL | INT | INTO | IS | JOIN | LEFT | LIKE | MATCHED | MAX | MERGE | MIN | MINUS | MINUTE | MONTH | NEXT | NOT | NULL | NULLS | NUMBER | NVL | ON | ONLY | OPTIMIZE | OR | ORDER | OUTER | OVER | PARTITION | PRIOR | RANK | READ | ROW | ROWS | RIGHT | SECOND | SELECT | SET | SOME | START | SUBSTRING | SUM | SYSDATE | TABLE | THEN | TIME | TIMESTAMP | UNION | UPDATE | UR | USING | VALUE | VALUES | WHEN | WHERE | WITH | YEAR | YEARS | DOT_STAR | DOT | COMMA | LPAREN | RPAREN | UNDERSCOPE | DASH | COLON | SEMICOLON | ASSIGNEQUAL | NOTEQUAL1 | NOTEQUAL2 | LESSTHANOREQUALTO1 | LESSTHAN | GREATERTHANOREQUALTO1 | GREATERTHAN | DIVIDE | PLUS | STAR | MOD | STRCONCAT | PLACEHOLDER | MAccessDateTime | Iso8601DateTime | Number | NonQuotedIdentifier | QuotedIdentifier | Variable | AsciiStringLiteral | UicodeValueLiteral | UnicodeStringLiteral | SingleLineComment | MultiLineComment | MultiLineComment2 | Whitespace )
		int alt32=132;
		alt32 = dfa32.predict(input);
		switch (alt32) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:1:10: ALL
				{
				mALL(); if (state.failed) return;

				}
				break;
			case 2 :
				// parser\\sql\\SQLAnalyzer.g:1:14: AND
				{
				mAND(); if (state.failed) return;

				}
				break;
			case 3 :
				// parser\\sql\\SQLAnalyzer.g:1:18: ANY
				{
				mANY(); if (state.failed) return;

				}
				break;
			case 4 :
				// parser\\sql\\SQLAnalyzer.g:1:22: AS
				{
				mAS(); if (state.failed) return;

				}
				break;
			case 5 :
				// parser\\sql\\SQLAnalyzer.g:1:25: ASC
				{
				mASC(); if (state.failed) return;

				}
				break;
			case 6 :
				// parser\\sql\\SQLAnalyzer.g:1:29: AVG
				{
				mAVG(); if (state.failed) return;

				}
				break;
			case 7 :
				// parser\\sql\\SQLAnalyzer.g:1:33: BETWEEN
				{
				mBETWEEN(); if (state.failed) return;

				}
				break;
			case 8 :
				// parser\\sql\\SQLAnalyzer.g:1:41: BY
				{
				mBY(); if (state.failed) return;

				}
				break;
			case 9 :
				// parser\\sql\\SQLAnalyzer.g:1:44: CASE
				{
				mCASE(); if (state.failed) return;

				}
				break;
			case 10 :
				// parser\\sql\\SQLAnalyzer.g:1:49: CAST
				{
				mCAST(); if (state.failed) return;

				}
				break;
			case 11 :
				// parser\\sql\\SQLAnalyzer.g:1:54: CONNECT
				{
				mCONNECT(); if (state.failed) return;

				}
				break;
			case 12 :
				// parser\\sql\\SQLAnalyzer.g:1:62: CROSS
				{
				mCROSS(); if (state.failed) return;

				}
				break;
			case 13 :
				// parser\\sql\\SQLAnalyzer.g:1:68: CURRENT
				{
				mCURRENT(); if (state.failed) return;

				}
				break;
			case 14 :
				// parser\\sql\\SQLAnalyzer.g:1:76: CURRENT_DATE
				{
				mCURRENT_DATE(); if (state.failed) return;

				}
				break;
			case 15 :
				// parser\\sql\\SQLAnalyzer.g:1:89: CURRENT_TIME
				{
				mCURRENT_TIME(); if (state.failed) return;

				}
				break;
			case 16 :
				// parser\\sql\\SQLAnalyzer.g:1:102: CURRENT_TIMESTAMP
				{
				mCURRENT_TIMESTAMP(); if (state.failed) return;

				}
				break;
			case 17 :
				// parser\\sql\\SQLAnalyzer.g:1:120: DATE
				{
				mDATE(); if (state.failed) return;

				}
				break;
			case 18 :
				// parser\\sql\\SQLAnalyzer.g:1:125: DAY
				{
				mDAY(); if (state.failed) return;

				}
				break;
			case 19 :
				// parser\\sql\\SQLAnalyzer.g:1:129: DECODE
				{
				mDECODE(); if (state.failed) return;

				}
				break;
			case 20 :
				// parser\\sql\\SQLAnalyzer.g:1:136: DEFAULT
				{
				mDEFAULT(); if (state.failed) return;

				}
				break;
			case 21 :
				// parser\\sql\\SQLAnalyzer.g:1:144: DELETE
				{
				mDELETE(); if (state.failed) return;

				}
				break;
			case 22 :
				// parser\\sql\\SQLAnalyzer.g:1:151: DENSE
				{
				mDENSE(); if (state.failed) return;

				}
				break;
			case 23 :
				// parser\\sql\\SQLAnalyzer.g:1:157: DESC
				{
				mDESC(); if (state.failed) return;

				}
				break;
			case 24 :
				// parser\\sql\\SQLAnalyzer.g:1:162: DISTINCT
				{
				mDISTINCT(); if (state.failed) return;

				}
				break;
			case 25 :
				// parser\\sql\\SQLAnalyzer.g:1:171: ELSE
				{
				mELSE(); if (state.failed) return;

				}
				break;
			case 26 :
				// parser\\sql\\SQLAnalyzer.g:1:176: END
				{
				mEND(); if (state.failed) return;

				}
				break;
			case 27 :
				// parser\\sql\\SQLAnalyzer.g:1:180: ESCAPE
				{
				mESCAPE(); if (state.failed) return;

				}
				break;
			case 28 :
				// parser\\sql\\SQLAnalyzer.g:1:187: EXISTS
				{
				mEXISTS(); if (state.failed) return;

				}
				break;
			case 29 :
				// parser\\sql\\SQLAnalyzer.g:1:194: EXTRACT
				{
				mEXTRACT(); if (state.failed) return;

				}
				break;
			case 30 :
				// parser\\sql\\SQLAnalyzer.g:1:202: FETCH
				{
				mFETCH(); if (state.failed) return;

				}
				break;
			case 31 :
				// parser\\sql\\SQLAnalyzer.g:1:208: FIRST
				{
				mFIRST(); if (state.failed) return;

				}
				break;
			case 32 :
				// parser\\sql\\SQLAnalyzer.g:1:214: FOR
				{
				mFOR(); if (state.failed) return;

				}
				break;
			case 33 :
				// parser\\sql\\SQLAnalyzer.g:1:218: FROM
				{
				mFROM(); if (state.failed) return;

				}
				break;
			case 34 :
				// parser\\sql\\SQLAnalyzer.g:1:223: FULL
				{
				mFULL(); if (state.failed) return;

				}
				break;
			case 35 :
				// parser\\sql\\SQLAnalyzer.g:1:228: GROUP
				{
				mGROUP(); if (state.failed) return;

				}
				break;
			case 36 :
				// parser\\sql\\SQLAnalyzer.g:1:234: HAVING
				{
				mHAVING(); if (state.failed) return;

				}
				break;
			case 37 :
				// parser\\sql\\SQLAnalyzer.g:1:241: HOUR
				{
				mHOUR(); if (state.failed) return;

				}
				break;
			case 38 :
				// parser\\sql\\SQLAnalyzer.g:1:246: IN
				{
				mIN(); if (state.failed) return;

				}
				break;
			case 39 :
				// parser\\sql\\SQLAnalyzer.g:1:249: INNER
				{
				mINNER(); if (state.failed) return;

				}
				break;
			case 40 :
				// parser\\sql\\SQLAnalyzer.g:1:255: INSERT
				{
				mINSERT(); if (state.failed) return;

				}
				break;
			case 41 :
				// parser\\sql\\SQLAnalyzer.g:1:262: INTERVAL
				{
				mINTERVAL(); if (state.failed) return;

				}
				break;
			case 42 :
				// parser\\sql\\SQLAnalyzer.g:1:271: INT
				{
				mINT(); if (state.failed) return;

				}
				break;
			case 43 :
				// parser\\sql\\SQLAnalyzer.g:1:275: INTO
				{
				mINTO(); if (state.failed) return;

				}
				break;
			case 44 :
				// parser\\sql\\SQLAnalyzer.g:1:280: IS
				{
				mIS(); if (state.failed) return;

				}
				break;
			case 45 :
				// parser\\sql\\SQLAnalyzer.g:1:283: JOIN
				{
				mJOIN(); if (state.failed) return;

				}
				break;
			case 46 :
				// parser\\sql\\SQLAnalyzer.g:1:288: LEFT
				{
				mLEFT(); if (state.failed) return;

				}
				break;
			case 47 :
				// parser\\sql\\SQLAnalyzer.g:1:293: LIKE
				{
				mLIKE(); if (state.failed) return;

				}
				break;
			case 48 :
				// parser\\sql\\SQLAnalyzer.g:1:298: MATCHED
				{
				mMATCHED(); if (state.failed) return;

				}
				break;
			case 49 :
				// parser\\sql\\SQLAnalyzer.g:1:306: MAX
				{
				mMAX(); if (state.failed) return;

				}
				break;
			case 50 :
				// parser\\sql\\SQLAnalyzer.g:1:310: MERGE
				{
				mMERGE(); if (state.failed) return;

				}
				break;
			case 51 :
				// parser\\sql\\SQLAnalyzer.g:1:316: MIN
				{
				mMIN(); if (state.failed) return;

				}
				break;
			case 52 :
				// parser\\sql\\SQLAnalyzer.g:1:320: MINUS
				{
				mMINUS(); if (state.failed) return;

				}
				break;
			case 53 :
				// parser\\sql\\SQLAnalyzer.g:1:326: MINUTE
				{
				mMINUTE(); if (state.failed) return;

				}
				break;
			case 54 :
				// parser\\sql\\SQLAnalyzer.g:1:333: MONTH
				{
				mMONTH(); if (state.failed) return;

				}
				break;
			case 55 :
				// parser\\sql\\SQLAnalyzer.g:1:339: NEXT
				{
				mNEXT(); if (state.failed) return;

				}
				break;
			case 56 :
				// parser\\sql\\SQLAnalyzer.g:1:344: NOT
				{
				mNOT(); if (state.failed) return;

				}
				break;
			case 57 :
				// parser\\sql\\SQLAnalyzer.g:1:348: NULL
				{
				mNULL(); if (state.failed) return;

				}
				break;
			case 58 :
				// parser\\sql\\SQLAnalyzer.g:1:353: NULLS
				{
				mNULLS(); if (state.failed) return;

				}
				break;
			case 59 :
				// parser\\sql\\SQLAnalyzer.g:1:359: NUMBER
				{
				mNUMBER(); if (state.failed) return;

				}
				break;
			case 60 :
				// parser\\sql\\SQLAnalyzer.g:1:366: NVL
				{
				mNVL(); if (state.failed) return;

				}
				break;
			case 61 :
				// parser\\sql\\SQLAnalyzer.g:1:370: ON
				{
				mON(); if (state.failed) return;

				}
				break;
			case 62 :
				// parser\\sql\\SQLAnalyzer.g:1:373: ONLY
				{
				mONLY(); if (state.failed) return;

				}
				break;
			case 63 :
				// parser\\sql\\SQLAnalyzer.g:1:378: OPTIMIZE
				{
				mOPTIMIZE(); if (state.failed) return;

				}
				break;
			case 64 :
				// parser\\sql\\SQLAnalyzer.g:1:387: OR
				{
				mOR(); if (state.failed) return;

				}
				break;
			case 65 :
				// parser\\sql\\SQLAnalyzer.g:1:390: ORDER
				{
				mORDER(); if (state.failed) return;

				}
				break;
			case 66 :
				// parser\\sql\\SQLAnalyzer.g:1:396: OUTER
				{
				mOUTER(); if (state.failed) return;

				}
				break;
			case 67 :
				// parser\\sql\\SQLAnalyzer.g:1:402: OVER
				{
				mOVER(); if (state.failed) return;

				}
				break;
			case 68 :
				// parser\\sql\\SQLAnalyzer.g:1:407: PARTITION
				{
				mPARTITION(); if (state.failed) return;

				}
				break;
			case 69 :
				// parser\\sql\\SQLAnalyzer.g:1:417: PRIOR
				{
				mPRIOR(); if (state.failed) return;

				}
				break;
			case 70 :
				// parser\\sql\\SQLAnalyzer.g:1:423: RANK
				{
				mRANK(); if (state.failed) return;

				}
				break;
			case 71 :
				// parser\\sql\\SQLAnalyzer.g:1:428: READ
				{
				mREAD(); if (state.failed) return;

				}
				break;
			case 72 :
				// parser\\sql\\SQLAnalyzer.g:1:433: ROW
				{
				mROW(); if (state.failed) return;

				}
				break;
			case 73 :
				// parser\\sql\\SQLAnalyzer.g:1:437: ROWS
				{
				mROWS(); if (state.failed) return;

				}
				break;
			case 74 :
				// parser\\sql\\SQLAnalyzer.g:1:442: RIGHT
				{
				mRIGHT(); if (state.failed) return;

				}
				break;
			case 75 :
				// parser\\sql\\SQLAnalyzer.g:1:448: SECOND
				{
				mSECOND(); if (state.failed) return;

				}
				break;
			case 76 :
				// parser\\sql\\SQLAnalyzer.g:1:455: SELECT
				{
				mSELECT(); if (state.failed) return;

				}
				break;
			case 77 :
				// parser\\sql\\SQLAnalyzer.g:1:462: SET
				{
				mSET(); if (state.failed) return;

				}
				break;
			case 78 :
				// parser\\sql\\SQLAnalyzer.g:1:466: SOME
				{
				mSOME(); if (state.failed) return;

				}
				break;
			case 79 :
				// parser\\sql\\SQLAnalyzer.g:1:471: START
				{
				mSTART(); if (state.failed) return;

				}
				break;
			case 80 :
				// parser\\sql\\SQLAnalyzer.g:1:477: SUBSTRING
				{
				mSUBSTRING(); if (state.failed) return;

				}
				break;
			case 81 :
				// parser\\sql\\SQLAnalyzer.g:1:487: SUM
				{
				mSUM(); if (state.failed) return;

				}
				break;
			case 82 :
				// parser\\sql\\SQLAnalyzer.g:1:491: SYSDATE
				{
				mSYSDATE(); if (state.failed) return;

				}
				break;
			case 83 :
				// parser\\sql\\SQLAnalyzer.g:1:499: TABLE
				{
				mTABLE(); if (state.failed) return;

				}
				break;
			case 84 :
				// parser\\sql\\SQLAnalyzer.g:1:505: THEN
				{
				mTHEN(); if (state.failed) return;

				}
				break;
			case 85 :
				// parser\\sql\\SQLAnalyzer.g:1:510: TIME
				{
				mTIME(); if (state.failed) return;

				}
				break;
			case 86 :
				// parser\\sql\\SQLAnalyzer.g:1:515: TIMESTAMP
				{
				mTIMESTAMP(); if (state.failed) return;

				}
				break;
			case 87 :
				// parser\\sql\\SQLAnalyzer.g:1:525: UNION
				{
				mUNION(); if (state.failed) return;

				}
				break;
			case 88 :
				// parser\\sql\\SQLAnalyzer.g:1:531: UPDATE
				{
				mUPDATE(); if (state.failed) return;

				}
				break;
			case 89 :
				// parser\\sql\\SQLAnalyzer.g:1:538: UR
				{
				mUR(); if (state.failed) return;

				}
				break;
			case 90 :
				// parser\\sql\\SQLAnalyzer.g:1:541: USING
				{
				mUSING(); if (state.failed) return;

				}
				break;
			case 91 :
				// parser\\sql\\SQLAnalyzer.g:1:547: VALUE
				{
				mVALUE(); if (state.failed) return;

				}
				break;
			case 92 :
				// parser\\sql\\SQLAnalyzer.g:1:553: VALUES
				{
				mVALUES(); if (state.failed) return;

				}
				break;
			case 93 :
				// parser\\sql\\SQLAnalyzer.g:1:560: WHEN
				{
				mWHEN(); if (state.failed) return;

				}
				break;
			case 94 :
				// parser\\sql\\SQLAnalyzer.g:1:565: WHERE
				{
				mWHERE(); if (state.failed) return;

				}
				break;
			case 95 :
				// parser\\sql\\SQLAnalyzer.g:1:571: WITH
				{
				mWITH(); if (state.failed) return;

				}
				break;
			case 96 :
				// parser\\sql\\SQLAnalyzer.g:1:576: YEAR
				{
				mYEAR(); if (state.failed) return;

				}
				break;
			case 97 :
				// parser\\sql\\SQLAnalyzer.g:1:581: YEARS
				{
				mYEARS(); if (state.failed) return;

				}
				break;
			case 98 :
				// parser\\sql\\SQLAnalyzer.g:1:587: DOT_STAR
				{
				mDOT_STAR(); if (state.failed) return;

				}
				break;
			case 99 :
				// parser\\sql\\SQLAnalyzer.g:1:596: DOT
				{
				mDOT(); if (state.failed) return;

				}
				break;
			case 100 :
				// parser\\sql\\SQLAnalyzer.g:1:600: COMMA
				{
				mCOMMA(); if (state.failed) return;

				}
				break;
			case 101 :
				// parser\\sql\\SQLAnalyzer.g:1:606: LPAREN
				{
				mLPAREN(); if (state.failed) return;

				}
				break;
			case 102 :
				// parser\\sql\\SQLAnalyzer.g:1:613: RPAREN
				{
				mRPAREN(); if (state.failed) return;

				}
				break;
			case 103 :
				// parser\\sql\\SQLAnalyzer.g:1:620: UNDERSCOPE
				{
				mUNDERSCOPE(); if (state.failed) return;

				}
				break;
			case 104 :
				// parser\\sql\\SQLAnalyzer.g:1:631: DASH
				{
				mDASH(); if (state.failed) return;

				}
				break;
			case 105 :
				// parser\\sql\\SQLAnalyzer.g:1:636: COLON
				{
				mCOLON(); if (state.failed) return;

				}
				break;
			case 106 :
				// parser\\sql\\SQLAnalyzer.g:1:642: SEMICOLON
				{
				mSEMICOLON(); if (state.failed) return;

				}
				break;
			case 107 :
				// parser\\sql\\SQLAnalyzer.g:1:652: ASSIGNEQUAL
				{
				mASSIGNEQUAL(); if (state.failed) return;

				}
				break;
			case 108 :
				// parser\\sql\\SQLAnalyzer.g:1:664: NOTEQUAL1
				{
				mNOTEQUAL1(); if (state.failed) return;

				}
				break;
			case 109 :
				// parser\\sql\\SQLAnalyzer.g:1:674: NOTEQUAL2
				{
				mNOTEQUAL2(); if (state.failed) return;

				}
				break;
			case 110 :
				// parser\\sql\\SQLAnalyzer.g:1:684: LESSTHANOREQUALTO1
				{
				mLESSTHANOREQUALTO1(); if (state.failed) return;

				}
				break;
			case 111 :
				// parser\\sql\\SQLAnalyzer.g:1:703: LESSTHAN
				{
				mLESSTHAN(); if (state.failed) return;

				}
				break;
			case 112 :
				// parser\\sql\\SQLAnalyzer.g:1:712: GREATERTHANOREQUALTO1
				{
				mGREATERTHANOREQUALTO1(); if (state.failed) return;

				}
				break;
			case 113 :
				// parser\\sql\\SQLAnalyzer.g:1:734: GREATERTHAN
				{
				mGREATERTHAN(); if (state.failed) return;

				}
				break;
			case 114 :
				// parser\\sql\\SQLAnalyzer.g:1:746: DIVIDE
				{
				mDIVIDE(); if (state.failed) return;

				}
				break;
			case 115 :
				// parser\\sql\\SQLAnalyzer.g:1:753: PLUS
				{
				mPLUS(); if (state.failed) return;

				}
				break;
			case 116 :
				// parser\\sql\\SQLAnalyzer.g:1:758: STAR
				{
				mSTAR(); if (state.failed) return;

				}
				break;
			case 117 :
				// parser\\sql\\SQLAnalyzer.g:1:763: MOD
				{
				mMOD(); if (state.failed) return;

				}
				break;
			case 118 :
				// parser\\sql\\SQLAnalyzer.g:1:767: STRCONCAT
				{
				mSTRCONCAT(); if (state.failed) return;

				}
				break;
			case 119 :
				// parser\\sql\\SQLAnalyzer.g:1:777: PLACEHOLDER
				{
				mPLACEHOLDER(); if (state.failed) return;

				}
				break;
			case 120 :
				// parser\\sql\\SQLAnalyzer.g:1:789: MAccessDateTime
				{
				mMAccessDateTime(); if (state.failed) return;

				}
				break;
			case 121 :
				// parser\\sql\\SQLAnalyzer.g:1:805: Iso8601DateTime
				{
				mIso8601DateTime(); if (state.failed) return;

				}
				break;
			case 122 :
				// parser\\sql\\SQLAnalyzer.g:1:821: Number
				{
				mNumber(); if (state.failed) return;

				}
				break;
			case 123 :
				// parser\\sql\\SQLAnalyzer.g:1:828: NonQuotedIdentifier
				{
				mNonQuotedIdentifier(); if (state.failed) return;

				}
				break;
			case 124 :
				// parser\\sql\\SQLAnalyzer.g:1:848: QuotedIdentifier
				{
				mQuotedIdentifier(); if (state.failed) return;

				}
				break;
			case 125 :
				// parser\\sql\\SQLAnalyzer.g:1:865: Variable
				{
				mVariable(); if (state.failed) return;

				}
				break;
			case 126 :
				// parser\\sql\\SQLAnalyzer.g:1:874: AsciiStringLiteral
				{
				mAsciiStringLiteral(); if (state.failed) return;

				}
				break;
			case 127 :
				// parser\\sql\\SQLAnalyzer.g:1:893: UicodeValueLiteral
				{
				mUicodeValueLiteral(); if (state.failed) return;

				}
				break;
			case 128 :
				// parser\\sql\\SQLAnalyzer.g:1:912: UnicodeStringLiteral
				{
				mUnicodeStringLiteral(); if (state.failed) return;

				}
				break;
			case 129 :
				// parser\\sql\\SQLAnalyzer.g:1:933: SingleLineComment
				{
				mSingleLineComment(); if (state.failed) return;

				}
				break;
			case 130 :
				// parser\\sql\\SQLAnalyzer.g:1:951: MultiLineComment
				{
				mMultiLineComment(); if (state.failed) return;

				}
				break;
			case 131 :
				// parser\\sql\\SQLAnalyzer.g:1:968: MultiLineComment2
				{
				mMultiLineComment2(); if (state.failed) return;

				}
				break;
			case 132 :
				// parser\\sql\\SQLAnalyzer.g:1:986: Whitespace
				{
				mWhitespace(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_SQLAnalyzer
	public final void synpred1_SQLAnalyzer_fragment() throws RecognitionException {
		// parser\\sql\\SQLAnalyzer.g:1029:3: ( ( Digit )+ ( '.' | 'e' ) )
		// parser\\sql\\SQLAnalyzer.g:1029:5: ( Digit )+ ( '.' | 'e' )
		{
		// parser\\sql\\SQLAnalyzer.g:1029:5: ( Digit )+
		int cnt33=0;
		loop33:
		while (true) {
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( ((LA33_0 >= '0' && LA33_0 <= '9')) ) {
				alt33=1;
			}

			switch (alt33) {
			case 1 :
				// parser\\sql\\SQLAnalyzer.g:
				{
				if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
					input.consume();
					state.failed=false;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return;}
					MismatchedSetException mse = new MismatchedSetException(null,input);
					recover(mse);
					throw mse;
				}
				}
				break;

			default :
				if ( cnt33 >= 1 ) break loop33;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(33, input);
				throw eee;
			}
			cnt33++;
		}

		if ( input.LA(1)=='.'||input.LA(1)=='e' ) {
			input.consume();
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			recover(mse);
			throw mse;
		}
		}

	}
	// $ANTLR end synpred1_SQLAnalyzer

	public final boolean synpred1_SQLAnalyzer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_SQLAnalyzer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA12 dfa12 = new DFA12(this);
	protected DFA32 dfa32 = new DFA32(this);
	static final String DFA12_eotS =
		"\1\uffff\1\7\1\uffff\1\7\4\uffff";
	static final String DFA12_eofS =
		"\10\uffff";
	static final String DFA12_minS =
		"\2\56\1\uffff\1\56\4\uffff";
	static final String DFA12_maxS =
		"\1\71\1\170\1\uffff\1\145\4\uffff";
	static final String DFA12_acceptS =
		"\2\uffff\1\2\1\uffff\1\4\2\1\1\3";
	static final String DFA12_specialS =
		"\1\uffff\1\1\1\uffff\1\0\4\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\2\1\uffff\1\1\11\3",
			"\1\5\1\uffff\12\3\53\uffff\1\6\22\uffff\1\4",
			"",
			"\1\5\1\uffff\12\3\53\uffff\1\6",
			"",
			"",
			"",
			""
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1028:1: Number : ( ( ( Digit )+ ( '.' | 'e' ) )=> ( Digit )+ ( '.' ( Digit )* ( Exponent )? | Exponent ) | '.' ( ( Digit )+ ( Exponent )? )? | ( Digit )+ | '0x' ( 'a' .. 'f' | Digit )* );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_3 = input.LA(1);
						 
						int index12_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_3=='.') && (synpred1_SQLAnalyzer())) {s = 5;}
						else if ( (LA12_3=='e') && (synpred1_SQLAnalyzer())) {s = 6;}
						else if ( ((LA12_3 >= '0' && LA12_3 <= '9')) ) {s = 3;}
						else s = 7;
						 
						input.seek(index12_3);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA12_1 = input.LA(1);
						 
						int index12_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_1=='x') ) {s = 4;}
						else if ( (LA12_1=='.') && (synpred1_SQLAnalyzer())) {s = 5;}
						else if ( (LA12_1=='e') && (synpred1_SQLAnalyzer())) {s = 6;}
						else if ( ((LA12_1 >= '0' && LA12_1 <= '9')) ) {s = 3;}
						else s = 7;
						 
						input.seek(index12_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 12, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA32_eotS =
		"\1\uffff\26\56\1\164\4\uffff\1\167\1\170\2\uffff\1\175\1\uffff\1\177\1"+
		"\u0081\6\uffff\2\165\1\56\5\uffff\2\56\1\u008b\2\56\1\u008f\23\56\1\u00a9"+
		"\1\u00ad\13\56\1\u00bb\1\56\1\u00be\22\56\1\u00d5\5\56\20\uffff\1\165"+
		"\1\56\3\uffff\1\u00df\1\u00e0\1\u00e1\1\uffff\1\u00e2\1\u00e3\1\56\1\uffff"+
		"\5\56\1\u00eb\7\56\1\u00f3\5\56\1\u00f9\5\56\1\uffff\2\56\1\u0101\1\uffff"+
		"\4\56\1\u0108\1\56\1\u010a\2\56\1\u010e\2\56\1\u0111\1\uffff\2\56\1\uffff"+
		"\7\56\1\u011b\3\56\1\u0120\3\56\1\u0124\6\56\1\uffff\5\56\1\uffff\1\165"+
		"\1\56\6\uffff\1\56\1\u0134\1\u0135\3\56\1\u0139\1\uffff\4\56\1\u013e\1"+
		"\56\1\u0140\1\uffff\5\56\1\uffff\1\u0146\1\u0147\2\56\1\u014a\2\56\1\uffff"+
		"\1\56\1\u014e\1\u014f\1\u0150\1\u0151\1\56\1\uffff\1\56\1\uffff\2\56\1"+
		"\u0157\1\uffff\1\u0158\1\56\1\uffff\1\u015b\3\56\1\u015f\2\56\1\u0162"+
		"\1\u0163\1\uffff\1\u0164\3\56\1\uffff\1\u0168\2\56\1\uffff\2\56\1\u016d"+
		"\1\u016e\4\56\1\u0174\1\56\1\u0176\1\u0177\1\uffff\1\165\1\56\2\uffff"+
		"\1\56\1\u017d\1\56\1\uffff\3\56\1\u0182\1\uffff\1\56\1\uffff\3\56\1\u0187"+
		"\1\u0188\2\uffff\1\u0189\1\56\1\uffff\1\u018b\2\56\4\uffff\1\56\1\u018f"+
		"\1\u0190\1\56\1\u0192\2\uffff\1\u0193\1\56\1\uffff\1\56\1\u0196\1\u0197"+
		"\1\uffff\1\56\1\u0199\3\uffff\1\u019a\2\56\1\uffff\1\u019d\2\56\1\u01a0"+
		"\2\uffff\1\56\1\u01a2\1\56\1\u01a4\1\u01a5\1\uffff\1\u01a7\2\uffff\1\u01a8"+
		"\2\uffff\2\56\1\uffff\1\56\1\u01ad\1\56\1\u01af\1\uffff\1\56\1\u01b1\1"+
		"\u01b2\1\56\3\uffff\1\u01b4\1\uffff\1\u01b5\2\56\2\uffff\1\u01b8\2\uffff"+
		"\1\u01b9\1\56\2\uffff\1\56\2\uffff\1\u01bc\1\u01bd\1\uffff\2\56\1\uffff"+
		"\1\56\1\uffff\1\u01c1\2\uffff\1\u01c2\3\uffff\1\u01c4\1\u01c5\1\u01c6"+
		"\1\uffff\1\u01c8\1\uffff\1\56\2\uffff\1\u01ca\2\uffff\1\56\1\u01cc\2\uffff"+
		"\2\56\2\uffff\1\56\1\u01d0\1\56\6\uffff\1\56\1\uffff\1\u01d5\1\uffff\1"+
		"\u01d6\1\uffff\1\u01d7\2\56\1\uffff\1\56\1\uffff\2\56\3\uffff\1\u01de"+
		"\1\u01df\1\u01e0\1\uffff\2\56\4\uffff\2\56\1\uffff\1\u01e8\1\u01e9\3\uffff"+
		"\1\56\1\uffff\1\56\1\uffff\1\56\1\uffff\1\56\1\uffff\1\u01f4\7\uffff";
	static final String DFA32_eofS =
		"\u01fa\uffff";
	static final String DFA32_minS =
		"\1\11\1\114\1\105\2\101\1\114\1\105\1\122\1\101\1\116\1\117\1\105\1\101"+
		"\1\105\1\116\2\101\1\105\1\101\1\116\1\101\1\110\1\105\1\52\4\uffff\1"+
		"\55\1\100\2\uffff\1\41\1\uffff\1\75\1\52\5\uffff\1\0\2\60\1\100\2\uffff"+
		"\1\0\2\uffff\1\114\1\104\1\60\1\107\1\124\1\60\1\123\1\116\1\117\1\122"+
		"\1\124\1\103\2\123\1\104\1\103\1\111\1\124\2\122\1\117\1\114\1\117\1\126"+
		"\1\125\2\60\1\111\1\106\1\113\1\124\1\122\2\116\1\130\1\124\2\114\1\60"+
		"\1\124\1\60\1\124\1\105\1\122\1\111\1\116\1\101\1\127\1\107\1\103\1\115"+
		"\1\101\1\102\1\123\1\102\1\105\1\115\1\111\1\104\1\60\1\111\1\114\1\105"+
		"\1\124\1\101\17\uffff\1\0\2\60\1\0\2\uffff\3\60\1\uffff\2\60\1\127\1\uffff"+
		"\1\105\1\116\1\123\1\122\1\105\1\60\1\117\1\101\1\105\1\123\1\103\1\124"+
		"\1\105\1\60\1\101\1\123\1\122\1\103\1\123\1\60\1\115\1\114\1\125\1\111"+
		"\1\122\1\uffff\2\105\1\60\1\uffff\1\116\1\124\1\105\1\103\1\60\1\107\1"+
		"\60\2\124\1\60\1\114\1\102\1\60\1\uffff\1\131\1\111\1\uffff\2\105\1\122"+
		"\1\124\1\117\1\113\1\104\1\60\1\110\1\117\1\105\1\60\1\105\1\122\1\123"+
		"\1\60\1\104\1\114\1\116\1\105\1\117\1\101\1\uffff\1\116\1\125\1\116\1"+
		"\110\1\122\1\0\2\60\6\uffff\1\105\2\60\1\105\1\123\1\105\1\60\1\uffff"+
		"\1\104\1\125\1\124\1\105\1\60\1\111\1\60\1\uffff\1\120\1\124\1\101\1\110"+
		"\1\124\1\uffff\2\60\1\120\1\116\1\60\2\122\1\uffff\1\122\4\60\1\110\1"+
		"\uffff\1\105\1\uffff\1\123\1\110\1\60\1\uffff\1\60\1\105\1\uffff\1\60"+
		"\1\115\2\122\1\60\1\111\1\122\2\60\1\uffff\1\60\1\124\1\116\1\103\1\uffff"+
		"\1\60\2\124\1\uffff\1\101\1\105\2\60\1\116\1\124\1\107\1\105\1\60\1\105"+
		"\2\60\1\0\1\55\1\105\2\uffff\1\103\1\60\1\116\1\uffff\1\105\1\114\1\105"+
		"\1\60\1\uffff\1\116\1\uffff\1\105\1\123\1\103\2\60\2\uffff\1\60\1\107"+
		"\1\uffff\1\60\1\124\1\126\4\uffff\1\105\2\60\1\105\1\60\2\uffff\1\60\1"+
		"\122\1\uffff\1\111\2\60\1\uffff\1\124\1\60\3\uffff\1\60\1\104\1\124\1"+
		"\uffff\1\60\1\122\1\124\1\60\2\uffff\1\124\1\60\1\105\2\60\1\uffff\1\60"+
		"\2\uffff\1\60\1\0\1\uffff\1\116\1\124\1\uffff\1\124\1\60\1\124\1\60\1"+
		"\uffff\1\103\2\60\1\124\3\uffff\1\60\1\uffff\1\60\1\101\1\104\2\uffff"+
		"\1\60\2\uffff\1\60\1\132\2\uffff\1\111\2\uffff\2\60\1\uffff\1\111\1\105"+
		"\1\uffff\1\101\1\uffff\1\60\2\uffff\1\60\2\uffff\1\0\3\60\1\uffff\1\60"+
		"\1\uffff\1\124\2\uffff\1\60\2\uffff\1\114\1\60\2\uffff\1\105\1\117\2\uffff"+
		"\1\116\1\60\1\115\2\uffff\1\0\3\uffff\1\104\1\uffff\1\60\1\uffff\1\60"+
		"\1\uffff\1\60\1\116\1\107\1\uffff\1\120\1\0\1\101\1\111\3\uffff\3\60\1"+
		"\0\1\124\1\115\3\uffff\1\0\2\105\1\0\2\60\1\0\2\uffff\1\124\1\0\1\101"+
		"\1\0\1\115\1\0\1\120\1\0\1\60\1\0\1\uffff\3\0\2\uffff";
	static final String DFA32_maxS =
		"\1\ud7a3\1\166\1\171\1\165\1\151\1\170\1\165\1\162\1\157\1\163\1\157\1"+
		"\151\1\157\2\166\1\162\1\157\1\171\1\151\1\163\1\141\1\151\1\145\1\71"+
		"\4\uffff\1\55\1\ud7a3\2\uffff\1\76\1\uffff\1\75\1\52\5\uffff\1\uffff\2"+
		"\71\1\ud7a3\2\uffff\1\uffff\2\uffff\1\154\1\171\1\ud7a3\1\147\1\164\1"+
		"\ud7a3\1\163\1\156\1\157\1\162\1\171\3\163\1\144\1\143\2\164\2\162\1\157"+
		"\1\154\1\157\1\166\1\165\2\ud7a3\1\151\1\146\1\153\1\170\1\162\2\156\1"+
		"\170\1\164\1\155\1\154\1\ud7a3\1\164\1\ud7a3\1\164\1\145\1\162\1\151\1"+
		"\156\1\141\1\167\1\147\1\164\1\155\1\141\1\155\1\163\1\142\1\145\1\155"+
		"\1\151\1\144\1\ud7a3\1\151\1\154\1\145\1\164\1\141\17\uffff\1\uffff\1"+
		"\71\1\ud7a3\1\uffff\2\uffff\3\ud7a3\1\uffff\2\ud7a3\1\167\1\uffff\1\164"+
		"\1\156\1\163\1\162\1\145\1\ud7a3\1\157\1\141\1\145\1\163\1\143\1\164\1"+
		"\145\1\ud7a3\1\141\1\163\1\162\1\143\1\163\1\ud7a3\1\155\1\154\1\165\1"+
		"\151\1\162\1\uffff\2\145\1\ud7a3\1\uffff\1\156\1\164\1\145\1\143\1\ud7a3"+
		"\1\147\1\ud7a3\2\164\1\ud7a3\1\154\1\142\1\ud7a3\1\uffff\1\171\1\151\1"+
		"\uffff\2\145\1\162\1\164\1\157\1\153\1\144\1\ud7a3\1\150\1\157\1\145\1"+
		"\ud7a3\1\145\1\162\1\163\1\ud7a3\1\144\1\154\1\156\1\145\1\157\1\141\1"+
		"\uffff\1\156\1\165\1\162\1\150\1\162\1\uffff\1\71\1\ud7a3\6\uffff\1\145"+
		"\2\ud7a3\1\145\1\163\1\145\1\ud7a3\1\uffff\1\144\1\165\1\164\1\145\1\ud7a3"+
		"\1\151\1\ud7a3\1\uffff\1\160\1\164\1\141\1\150\1\164\1\uffff\2\ud7a3\1"+
		"\160\1\156\1\ud7a3\2\162\1\uffff\1\162\4\ud7a3\1\150\1\uffff\1\145\1\uffff"+
		"\1\164\1\150\1\ud7a3\1\uffff\1\ud7a3\1\145\1\uffff\1\ud7a3\1\155\2\162"+
		"\1\ud7a3\1\151\1\162\2\ud7a3\1\uffff\1\ud7a3\1\164\1\156\1\143\1\uffff"+
		"\1\ud7a3\2\164\1\uffff\1\141\1\145\2\ud7a3\1\156\1\164\1\147\1\145\1\ud7a3"+
		"\1\145\2\ud7a3\1\uffff\1\55\1\145\2\uffff\1\143\1\ud7a3\1\156\1\uffff"+
		"\1\145\1\154\1\145\1\ud7a3\1\uffff\1\156\1\uffff\1\145\1\163\1\143\2\ud7a3"+
		"\2\uffff\1\ud7a3\1\147\1\uffff\1\ud7a3\1\164\1\166\4\uffff\1\145\2\ud7a3"+
		"\1\145\1\ud7a3\2\uffff\1\ud7a3\1\162\1\uffff\1\151\2\ud7a3\1\uffff\1\164"+
		"\1\ud7a3\3\uffff\1\ud7a3\1\144\1\164\1\uffff\1\ud7a3\1\162\1\164\1\ud7a3"+
		"\2\uffff\1\164\1\ud7a3\1\145\2\ud7a3\1\uffff\1\ud7a3\2\uffff\1\ud7a3\1"+
		"\uffff\1\uffff\1\156\1\164\1\uffff\1\164\1\ud7a3\1\164\1\ud7a3\1\uffff"+
		"\1\143\2\ud7a3\1\164\3\uffff\1\ud7a3\1\uffff\1\ud7a3\1\141\1\144\2\uffff"+
		"\1\ud7a3\2\uffff\1\ud7a3\1\172\2\uffff\1\151\2\uffff\2\ud7a3\1\uffff\1"+
		"\151\1\145\1\uffff\1\141\1\uffff\1\ud7a3\2\uffff\1\ud7a3\2\uffff\1\uffff"+
		"\3\ud7a3\1\uffff\1\ud7a3\1\uffff\1\164\2\uffff\1\ud7a3\2\uffff\1\154\1"+
		"\ud7a3\2\uffff\1\145\1\157\2\uffff\1\156\1\ud7a3\1\155\2\uffff\1\uffff"+
		"\3\uffff\1\164\1\uffff\1\ud7a3\1\uffff\1\ud7a3\1\uffff\1\ud7a3\1\156\1"+
		"\147\1\uffff\1\160\1\uffff\1\141\1\151\3\uffff\3\ud7a3\1\uffff\1\164\1"+
		"\155\3\uffff\1\uffff\2\145\1\uffff\2\ud7a3\1\uffff\2\uffff\1\164\1\uffff"+
		"\1\141\1\uffff\1\155\1\uffff\1\160\1\uffff\1\ud7a3\1\uffff\1\uffff\3\uffff"+
		"\2\uffff";
	static final String DFA32_acceptS =
		"\30\uffff\1\144\1\145\1\146\1\147\2\uffff\1\152\1\153\1\uffff\1\155\2"+
		"\uffff\1\163\1\164\1\165\1\166\1\167\4\uffff\1\174\1\173\1\uffff\1\177"+
		"\1\u0084\101\uffff\1\142\1\143\1\172\1\u0081\1\150\1\151\1\175\1\154\1"+
		"\156\1\u0083\1\157\1\160\1\161\1\u0082\1\162\4\uffff\1\176\1\u0080\3\uffff"+
		"\1\4\3\uffff\1\10\31\uffff\1\46\3\uffff\1\54\15\uffff\1\75\2\uffff\1\100"+
		"\26\uffff\1\131\10\uffff\1\176\1\1\1\2\1\3\1\5\1\6\7\uffff\1\22\7\uffff"+
		"\1\32\5\uffff\1\40\7\uffff\1\52\6\uffff\1\61\1\uffff\1\63\3\uffff\1\70"+
		"\2\uffff\1\74\11\uffff\1\110\4\uffff\1\115\3\uffff\1\121\17\uffff\1\11"+
		"\1\12\3\uffff\1\21\4\uffff\1\27\1\uffff\1\31\5\uffff\1\41\1\42\2\uffff"+
		"\1\45\3\uffff\1\53\1\55\1\56\1\57\5\uffff\1\67\1\71\2\uffff\1\76\3\uffff"+
		"\1\103\2\uffff\1\106\1\107\1\111\3\uffff\1\116\4\uffff\1\124\1\125\5\uffff"+
		"\1\135\1\uffff\1\137\1\140\2\uffff\1\171\2\uffff\1\14\4\uffff\1\26\4\uffff"+
		"\1\36\1\37\1\43\1\uffff\1\47\3\uffff\1\62\1\64\1\uffff\1\66\1\72\2\uffff"+
		"\1\101\1\102\1\uffff\1\105\1\112\2\uffff\1\117\2\uffff\1\123\1\uffff\1"+
		"\127\1\uffff\1\132\1\133\1\uffff\1\136\1\141\4\uffff\1\23\1\uffff\1\25"+
		"\1\uffff\1\33\1\34\1\uffff\1\44\1\50\2\uffff\1\65\1\73\2\uffff\1\113\1"+
		"\114\3\uffff\1\130\1\134\1\uffff\1\7\1\13\1\15\1\uffff\1\24\1\uffff\1"+
		"\35\1\uffff\1\60\3\uffff\1\122\4\uffff\1\30\1\51\1\77\6\uffff\1\104\1"+
		"\120\1\126\7\uffff\1\16\1\17\12\uffff\1\20\3\uffff\2\170";
	static final String DFA32_specialS =
		"\51\uffff\1\16\5\uffff\1\0\122\uffff\1\11\2\uffff\1\17\125\uffff\1\10"+
		"\125\uffff\1\7\107\uffff\1\20\57\uffff\1\6\31\uffff\1\12\16\uffff\1\23"+
		"\10\uffff\1\5\5\uffff\1\15\2\uffff\1\22\2\uffff\1\4\3\uffff\1\13\1\uffff"+
		"\1\21\1\uffff\1\3\1\uffff\1\1\1\uffff\1\25\1\uffff\1\14\1\2\1\24\2\uffff}>";
	static final String[] DFA32_transitionS = {
			"\2\61\2\uffff\1\61\22\uffff\1\61\1\41\1\55\1\51\1\60\1\46\1\uffff\1\57"+
			"\1\31\1\32\1\45\1\44\1\30\1\34\1\27\1\43\1\52\11\53\1\35\1\36\1\40\1"+
			"\37\1\42\1\50\1\54\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\56\1"+
			"\13\1\14\1\15\1\16\1\17\1\56\1\20\1\21\1\22\1\23\1\24\1\25\1\56\1\26"+
			"\1\56\1\55\3\uffff\1\33\1\55\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1"+
			"\12\1\56\1\13\1\14\1\15\1\16\1\17\1\56\1\20\1\21\1\22\1\23\1\24\1\25"+
			"\1\56\1\26\1\56\1\uffff\1\47\u30b4\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\62\1\uffff\1\63\4\uffff\1\64\2\uffff\1\65\25\uffff\1\62\1\uffff\1"+
			"\63\4\uffff\1\64\2\uffff\1\65",
			"\1\66\23\uffff\1\67\13\uffff\1\66\23\uffff\1\67",
			"\1\70\15\uffff\1\71\2\uffff\1\72\2\uffff\1\73\13\uffff\1\70\15\uffff"+
			"\1\71\2\uffff\1\72\2\uffff\1\73",
			"\1\74\3\uffff\1\75\3\uffff\1\76\27\uffff\1\74\3\uffff\1\75\3\uffff\1"+
			"\76",
			"\1\77\1\uffff\1\100\4\uffff\1\101\4\uffff\1\102\23\uffff\1\77\1\uffff"+
			"\1\100\4\uffff\1\101\4\uffff\1\102",
			"\1\103\3\uffff\1\104\5\uffff\1\105\2\uffff\1\106\2\uffff\1\107\17\uffff"+
			"\1\103\3\uffff\1\104\5\uffff\1\105\2\uffff\1\106\2\uffff\1\107",
			"\1\110\37\uffff\1\110",
			"\1\111\15\uffff\1\112\21\uffff\1\111\15\uffff\1\112",
			"\1\113\4\uffff\1\114\32\uffff\1\113\4\uffff\1\114",
			"\1\115\37\uffff\1\115",
			"\1\116\3\uffff\1\117\33\uffff\1\116\3\uffff\1\117",
			"\1\120\3\uffff\1\121\3\uffff\1\122\5\uffff\1\123\21\uffff\1\120\3\uffff"+
			"\1\121\3\uffff\1\122\5\uffff\1\123",
			"\1\124\11\uffff\1\125\5\uffff\1\126\1\127\16\uffff\1\124\11\uffff\1"+
			"\125\5\uffff\1\126\1\127",
			"\1\130\1\uffff\1\131\1\uffff\1\132\2\uffff\1\133\1\134\27\uffff\1\130"+
			"\1\uffff\1\131\1\uffff\1\132\2\uffff\1\133\1\134",
			"\1\135\20\uffff\1\136\16\uffff\1\135\20\uffff\1\136",
			"\1\137\3\uffff\1\140\3\uffff\1\142\5\uffff\1\141\21\uffff\1\137\3\uffff"+
			"\1\140\3\uffff\1\142\5\uffff\1\141",
			"\1\143\11\uffff\1\144\4\uffff\1\145\1\146\3\uffff\1\147\13\uffff\1\143"+
			"\11\uffff\1\144\4\uffff\1\145\1\146\3\uffff\1\147",
			"\1\150\6\uffff\1\151\1\152\27\uffff\1\150\6\uffff\1\151\1\152",
			"\1\153\1\uffff\1\154\1\uffff\1\155\1\156\32\uffff\1\153\1\uffff\1\154"+
			"\1\uffff\1\155\1\156",
			"\1\157\37\uffff\1\157",
			"\1\160\1\161\36\uffff\1\160\1\161",
			"\1\162\37\uffff\1\162",
			"\1\163\5\uffff\12\165",
			"",
			"",
			"",
			"",
			"\1\166",
			"\33\171\6\uffff\32\171\u30b6\uffff\136\171\u7a71\uffff\u2ba4\171",
			"",
			"",
			"\1\174\33\uffff\1\173\1\172",
			"",
			"\1\176",
			"\1\u0080",
			"",
			"",
			"",
			"",
			"",
			"\43\60\2\uffff\13\60\12\u0082\uffc6\60",
			"\12\u0083",
			"\12\u0083",
			"\33\u0084\6\uffff\32\u0084\u30b6\uffff\136\u0084\u7a71\uffff\u2ba4\u0084",
			"",
			"",
			"\11\u0087\1\u0085\26\u0087\2\u0085\1\u0086\4\u0085\1\u0086\64\u0085"+
			"\1\u0086\42\u0085\uff81\u0087",
			"",
			"",
			"\1\u0088\37\uffff\1\u0088",
			"\1\u0089\24\uffff\1\u008a\12\uffff\1\u0089\24\uffff\1\u008a",
			"\13\56\5\uffff\3\56\1\u008c\27\56\4\uffff\1\56\1\uffff\2\56\1\u008c"+
			"\27\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\u008d\37\uffff\1\u008d",
			"\1\u008e\37\uffff\1\u008e",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0090\37\uffff\1\u0090",
			"\1\u0091\37\uffff\1\u0091",
			"\1\u0092\37\uffff\1\u0092",
			"\1\u0093\37\uffff\1\u0093",
			"\1\u0094\4\uffff\1\u0095\32\uffff\1\u0094\4\uffff\1\u0095",
			"\1\u0096\2\uffff\1\u0097\5\uffff\1\u0098\1\uffff\1\u0099\4\uffff\1\u009a"+
			"\17\uffff\1\u0096\2\uffff\1\u0097\5\uffff\1\u0098\1\uffff\1\u0099\4\uffff"+
			"\1\u009a",
			"\1\u009b\37\uffff\1\u009b",
			"\1\u009c\37\uffff\1\u009c",
			"\1\u009d\37\uffff\1\u009d",
			"\1\u009e\37\uffff\1\u009e",
			"\1\u009f\12\uffff\1\u00a0\24\uffff\1\u009f\12\uffff\1\u00a0",
			"\1\u00a1\37\uffff\1\u00a1",
			"\1\u00a2\37\uffff\1\u00a2",
			"\1\u00a3\37\uffff\1\u00a3",
			"\1\u00a4\37\uffff\1\u00a4",
			"\1\u00a5\37\uffff\1\u00a5",
			"\1\u00a6\37\uffff\1\u00a6",
			"\1\u00a7\37\uffff\1\u00a7",
			"\1\u00a8\37\uffff\1\u00a8",
			"\13\56\5\uffff\16\56\1\u00aa\4\56\1\u00ab\1\u00ac\6\56\4\uffff\1\56"+
			"\1\uffff\15\56\1\u00aa\4\56\1\u00ab\1\u00ac\6\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u00ae\37\uffff\1\u00ae",
			"\1\u00af\37\uffff\1\u00af",
			"\1\u00b0\37\uffff\1\u00b0",
			"\1\u00b1\3\uffff\1\u00b2\33\uffff\1\u00b1\3\uffff\1\u00b2",
			"\1\u00b3\37\uffff\1\u00b3",
			"\1\u00b4\37\uffff\1\u00b4",
			"\1\u00b5\37\uffff\1\u00b5",
			"\1\u00b6\37\uffff\1\u00b6",
			"\1\u00b7\37\uffff\1\u00b7",
			"\1\u00b8\1\u00b9\36\uffff\1\u00b8\1\u00b9",
			"\1\u00ba\37\uffff\1\u00ba",
			"\13\56\5\uffff\14\56\1\u00bc\16\56\4\uffff\1\56\1\uffff\13\56\1\u00bc"+
			"\16\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\u00bd\37\uffff\1\u00bd",
			"\13\56\5\uffff\4\56\1\u00bf\26\56\4\uffff\1\56\1\uffff\3\56\1\u00bf"+
			"\26\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\u00c0\37\uffff\1\u00c0",
			"\1\u00c1\37\uffff\1\u00c1",
			"\1\u00c2\37\uffff\1\u00c2",
			"\1\u00c3\37\uffff\1\u00c3",
			"\1\u00c4\37\uffff\1\u00c4",
			"\1\u00c5\37\uffff\1\u00c5",
			"\1\u00c6\37\uffff\1\u00c6",
			"\1\u00c7\37\uffff\1\u00c7",
			"\1\u00c8\10\uffff\1\u00c9\7\uffff\1\u00ca\16\uffff\1\u00c8\10\uffff"+
			"\1\u00c9\7\uffff\1\u00ca",
			"\1\u00cb\37\uffff\1\u00cb",
			"\1\u00cc\37\uffff\1\u00cc",
			"\1\u00cd\12\uffff\1\u00ce\24\uffff\1\u00cd\12\uffff\1\u00ce",
			"\1\u00cf\37\uffff\1\u00cf",
			"\1\u00d0\37\uffff\1\u00d0",
			"\1\u00d1\37\uffff\1\u00d1",
			"\1\u00d2\37\uffff\1\u00d2",
			"\1\u00d3\37\uffff\1\u00d3",
			"\1\u00d4\37\uffff\1\u00d4",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u00d6\37\uffff\1\u00d6",
			"\1\u00d7\37\uffff\1\u00d7",
			"\1\u00d8\37\uffff\1\u00d8",
			"\1\u00d9\37\uffff\1\u00d9",
			"\1\u00da\37\uffff\1\u00da",
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
			"\60\60\12\u00db\uffc6\60",
			"\12\u00dc",
			"\13\u00dd\5\uffff\33\u00dd\4\uffff\1\u00dd\1\uffff\32\u00dd\u30b6\uffff"+
			"\136\u00dd\u7a71\uffff\u2ba4\u00dd",
			"\11\u0087\1\u0085\26\u0087\2\u0085\1\u0086\4\u0085\1\u00de\64\u0085"+
			"\1\u0086\42\u0085\uff81\u0087",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u00e4\37\uffff\1\u00e4",
			"",
			"\1\u00e5\16\uffff\1\u00e6\20\uffff\1\u00e5\16\uffff\1\u00e6",
			"\1\u00e7\37\uffff\1\u00e7",
			"\1\u00e8\37\uffff\1\u00e8",
			"\1\u00e9\37\uffff\1\u00e9",
			"\1\u00ea\37\uffff\1\u00ea",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u00ec\37\uffff\1\u00ec",
			"\1\u00ed\37\uffff\1\u00ed",
			"\1\u00ee\37\uffff\1\u00ee",
			"\1\u00ef\37\uffff\1\u00ef",
			"\1\u00f0\37\uffff\1\u00f0",
			"\1\u00f1\37\uffff\1\u00f1",
			"\1\u00f2\37\uffff\1\u00f2",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u00f4\37\uffff\1\u00f4",
			"\1\u00f5\37\uffff\1\u00f5",
			"\1\u00f6\37\uffff\1\u00f6",
			"\1\u00f7\37\uffff\1\u00f7",
			"\1\u00f8\37\uffff\1\u00f8",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u00fa\37\uffff\1\u00fa",
			"\1\u00fb\37\uffff\1\u00fb",
			"\1\u00fc\37\uffff\1\u00fc",
			"\1\u00fd\37\uffff\1\u00fd",
			"\1\u00fe\37\uffff\1\u00fe",
			"",
			"\1\u00ff\37\uffff\1\u00ff",
			"\1\u0100\37\uffff\1\u0100",
			"\13\56\5\uffff\5\56\1\u0102\11\56\1\u0103\13\56\4\uffff\1\56\1\uffff"+
			"\4\56\1\u0102\11\56\1\u0103\13\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4"+
			"\56",
			"",
			"\1\u0104\37\uffff\1\u0104",
			"\1\u0105\37\uffff\1\u0105",
			"\1\u0106\37\uffff\1\u0106",
			"\1\u0107\37\uffff\1\u0107",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0109\37\uffff\1\u0109",
			"\13\56\5\uffff\25\56\1\u010b\5\56\4\uffff\1\56\1\uffff\24\56\1\u010b"+
			"\5\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\u010c\37\uffff\1\u010c",
			"\1\u010d\37\uffff\1\u010d",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u010f\37\uffff\1\u010f",
			"\1\u0110\37\uffff\1\u0110",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u0112\37\uffff\1\u0112",
			"\1\u0113\37\uffff\1\u0113",
			"",
			"\1\u0114\37\uffff\1\u0114",
			"\1\u0115\37\uffff\1\u0115",
			"\1\u0116\37\uffff\1\u0116",
			"\1\u0117\37\uffff\1\u0117",
			"\1\u0118\37\uffff\1\u0118",
			"\1\u0119\37\uffff\1\u0119",
			"\1\u011a\37\uffff\1\u011a",
			"\13\56\5\uffff\23\56\1\u011c\7\56\4\uffff\1\56\1\uffff\22\56\1\u011c"+
			"\7\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\u011d\37\uffff\1\u011d",
			"\1\u011e\37\uffff\1\u011e",
			"\1\u011f\37\uffff\1\u011f",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0121\37\uffff\1\u0121",
			"\1\u0122\37\uffff\1\u0122",
			"\1\u0123\37\uffff\1\u0123",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0125\37\uffff\1\u0125",
			"\1\u0126\37\uffff\1\u0126",
			"\1\u0127\37\uffff\1\u0127",
			"\1\u0128\37\uffff\1\u0128",
			"\1\u0129\37\uffff\1\u0129",
			"\1\u012a\37\uffff\1\u012a",
			"",
			"\1\u012b\37\uffff\1\u012b",
			"\1\u012c\37\uffff\1\u012c",
			"\1\u012d\3\uffff\1\u012e\33\uffff\1\u012d\3\uffff\1\u012e",
			"\1\u012f\37\uffff\1\u012f",
			"\1\u0130\37\uffff\1\u0130",
			"\60\60\12\u0131\uffc6\60",
			"\12\u0132",
			"\13\u00dd\5\uffff\33\u00dd\4\uffff\1\u00dd\1\uffff\32\u00dd\u30b6\uffff"+
			"\136\u00dd\u7a71\uffff\u2ba4\u00dd",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u0133\37\uffff\1\u0133",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0136\37\uffff\1\u0136",
			"\1\u0137\37\uffff\1\u0137",
			"\1\u0138\37\uffff\1\u0138",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u013a\37\uffff\1\u013a",
			"\1\u013b\37\uffff\1\u013b",
			"\1\u013c\37\uffff\1\u013c",
			"\1\u013d\37\uffff\1\u013d",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u013f\37\uffff\1\u013f",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u0141\37\uffff\1\u0141",
			"\1\u0142\37\uffff\1\u0142",
			"\1\u0143\37\uffff\1\u0143",
			"\1\u0144\37\uffff\1\u0144",
			"\1\u0145\37\uffff\1\u0145",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0148\37\uffff\1\u0148",
			"\1\u0149\37\uffff\1\u0149",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u014b\37\uffff\1\u014b",
			"\1\u014c\37\uffff\1\u014c",
			"",
			"\1\u014d\37\uffff\1\u014d",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0152\37\uffff\1\u0152",
			"",
			"\1\u0153\37\uffff\1\u0153",
			"",
			"\1\u0154\1\u0155\36\uffff\1\u0154\1\u0155",
			"\1\u0156\37\uffff\1\u0156",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\23\56\1\u0159\7\56\4\uffff\1\56\1\uffff\22\56\1\u0159"+
			"\7\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\u015a\37\uffff\1\u015a",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u015c\37\uffff\1\u015c",
			"\1\u015d\37\uffff\1\u015d",
			"\1\u015e\37\uffff\1\u015e",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0160\37\uffff\1\u0160",
			"\1\u0161\37\uffff\1\u0161",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0165\37\uffff\1\u0165",
			"\1\u0166\37\uffff\1\u0166",
			"\1\u0167\37\uffff\1\u0167",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0169\37\uffff\1\u0169",
			"\1\u016a\37\uffff\1\u016a",
			"",
			"\1\u016b\37\uffff\1\u016b",
			"\1\u016c\37\uffff\1\u016c",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\23\56\1\u016f\7\56\4\uffff\1\56\1\uffff\22\56\1\u016f"+
			"\7\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\1\u0170\37\uffff\1\u0170",
			"\1\u0171\37\uffff\1\u0171",
			"\1\u0172\37\uffff\1\u0172",
			"\1\u0173\37\uffff\1\u0173",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0175\37\uffff\1\u0175",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\23\56\1\u0178\7\56\4\uffff\1\56\1\uffff\22\56\1\u0178"+
			"\7\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\60\60\12\u0179\uffc6\60",
			"\1\u017a",
			"\1\u017b\37\uffff\1\u017b",
			"",
			"",
			"\1\u017c\37\uffff\1\u017c",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u017e\37\uffff\1\u017e",
			"",
			"\1\u017f\37\uffff\1\u017f",
			"\1\u0180\37\uffff\1\u0180",
			"\1\u0181\37\uffff\1\u0181",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u0183\37\uffff\1\u0183",
			"",
			"\1\u0184\37\uffff\1\u0184",
			"\1\u0185\37\uffff\1\u0185",
			"\1\u0186\37\uffff\1\u0186",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u018a\37\uffff\1\u018a",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u018c\37\uffff\1\u018c",
			"\1\u018d\37\uffff\1\u018d",
			"",
			"",
			"",
			"",
			"\1\u018e\37\uffff\1\u018e",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0191\37\uffff\1\u0191",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u0194\37\uffff\1\u0194",
			"",
			"\1\u0195\37\uffff\1\u0195",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u0198\37\uffff\1\u0198",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u019b\37\uffff\1\u019b",
			"\1\u019c\37\uffff\1\u019c",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u019e\37\uffff\1\u019e",
			"\1\u019f\37\uffff\1\u019f",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\1\u01a1\37\uffff\1\u01a1",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u01a3\37\uffff\1\u01a3",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\23\56\1\u01a6\7\56\4\uffff\1\56\1\uffff\22\56\1\u01a6"+
			"\7\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\55\60\1\u01a9\uffd2\60",
			"",
			"\1\u01aa\37\uffff\1\u01aa",
			"\1\u01ab\37\uffff\1\u01ab",
			"",
			"\1\u01ac\37\uffff\1\u01ac",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u01ae\37\uffff\1\u01ae",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u01b0\37\uffff\1\u01b0",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u01b3\37\uffff\1\u01b3",
			"",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u01b6\37\uffff\1\u01b6",
			"\1\u01b7\37\uffff\1\u01b7",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u01ba\37\uffff\1\u01ba",
			"",
			"",
			"\1\u01bb\37\uffff\1\u01bb",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u01be\37\uffff\1\u01be",
			"\1\u01bf\37\uffff\1\u01bf",
			"",
			"\1\u01c0\37\uffff\1\u01c0",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\60\60\12\u01c3\uffc6\60",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\u01c7\1\uffff\32\56\u30b6\uffff\136\56"+
			"\u7a71\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\1\u01c9\37\uffff\1\u01c9",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\1\u01cb\37\uffff\1\u01cb",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"",
			"\1\u01cd\37\uffff\1\u01cd",
			"\1\u01ce\37\uffff\1\u01ce",
			"",
			"",
			"\1\u01cf\37\uffff\1\u01cf",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u01d1\37\uffff\1\u01d1",
			"",
			"",
			"\60\60\12\u01d2\uffc6\60",
			"",
			"",
			"",
			"\1\u01d3\17\uffff\1\u01d4\17\uffff\1\u01d3\17\uffff\1\u01d4",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\1\u01d8\37\uffff\1\u01d8",
			"\1\u01d9\37\uffff\1\u01d9",
			"",
			"\1\u01da\37\uffff\1\u01da",
			"\55\60\1\u01db\uffd2\60",
			"\1\u01dc\37\uffff\1\u01dc",
			"\1\u01dd\37\uffff\1\u01dd",
			"",
			"",
			"",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\60\60\12\u01e1\uffc6\60",
			"\1\u01e2\37\uffff\1\u01e2",
			"\1\u01e3\37\uffff\1\u01e3",
			"",
			"",
			"",
			"\60\60\12\u01e4\uffc6\60",
			"\1\u01e5\37\uffff\1\u01e5",
			"\1\u01e6\37\uffff\1\u01e6",
			"\40\60\1\u01e7\uffdf\60",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\13\56\5\uffff\23\56\1\u01ea\7\56\4\uffff\1\56\1\uffff\22\56\1\u01ea"+
			"\7\56\u30b6\uffff\136\56\u7a71\uffff\u2ba4\56",
			"\60\60\12\u01eb\uffc6\60",
			"",
			"",
			"\1\u01ec\37\uffff\1\u01ec",
			"\60\60\12\u01ed\uffc6\60",
			"\1\u01ee\37\uffff\1\u01ee",
			"\72\60\1\u01ef\uffc5\60",
			"\1\u01f0\37\uffff\1\u01f0",
			"\60\60\12\u01f1\uffc6\60",
			"\1\u01f2\37\uffff\1\u01f2",
			"\60\60\12\u01f3\uffc6\60",
			"\13\56\5\uffff\33\56\4\uffff\1\56\1\uffff\32\56\u30b6\uffff\136\56\u7a71"+
			"\uffff\u2ba4\56",
			"\72\60\1\u01f5\uffc5\60",
			"",
			"\60\60\12\u01f6\uffc6\60",
			"\60\60\12\u01f7\uffc6\60",
			"\43\60\1\u01f8\uffdc\60",
			"",
			""
	};

	static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
	static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
	static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
	static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
	static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
	static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
	static final short[][] DFA32_transition;

	static {
		int numStates = DFA32_transitionS.length;
		DFA32_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
		}
	}

	protected class DFA32 extends DFA {

		public DFA32(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 32;
			this.eot = DFA32_eot;
			this.eof = DFA32_eof;
			this.min = DFA32_min;
			this.max = DFA32_max;
			this.accept = DFA32_accept;
			this.special = DFA32_special;
			this.transition = DFA32_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( ALL | AND | ANY | AS | ASC | AVG | BETWEEN | BY | CASE | CAST | CONNECT | CROSS | CURRENT | CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | DATE | DAY | DECODE | DEFAULT | DELETE | DENSE | DESC | DISTINCT | ELSE | END | ESCAPE | EXISTS | EXTRACT | FETCH | FIRST | FOR | FROM | FULL | GROUP | HAVING | HOUR | IN | INNER | INSERT | INTERVAL | INT | INTO | IS | JOIN | LEFT | LIKE | MATCHED | MAX | MERGE | MIN | MINUS | MINUTE | MONTH | NEXT | NOT | NULL | NULLS | NUMBER | NVL | ON | ONLY | OPTIMIZE | OR | ORDER | OUTER | OVER | PARTITION | PRIOR | RANK | READ | ROW | ROWS | RIGHT | SECOND | SELECT | SET | SOME | START | SUBSTRING | SUM | SYSDATE | TABLE | THEN | TIME | TIMESTAMP | UNION | UPDATE | UR | USING | VALUE | VALUES | WHEN | WHERE | WITH | YEAR | YEARS | DOT_STAR | DOT | COMMA | LPAREN | RPAREN | UNDERSCOPE | DASH | COLON | SEMICOLON | ASSIGNEQUAL | NOTEQUAL1 | NOTEQUAL2 | LESSTHANOREQUALTO1 | LESSTHAN | GREATERTHANOREQUALTO1 | GREATERTHAN | DIVIDE | PLUS | STAR | MOD | STRCONCAT | PLACEHOLDER | MAccessDateTime | Iso8601DateTime | Number | NonQuotedIdentifier | QuotedIdentifier | Variable | AsciiStringLiteral | UicodeValueLiteral | UnicodeStringLiteral | SingleLineComment | MultiLineComment | MultiLineComment2 | Whitespace );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA32_47 = input.LA(1);
						s = -1;
						if ( (LA32_47=='\t'||(LA32_47 >= ' ' && LA32_47 <= '!')||(LA32_47 >= '#' && LA32_47 <= '&')||(LA32_47 >= '(' && LA32_47 <= '[')||(LA32_47 >= ']' && LA32_47 <= '~')) ) {s = 133;}
						else if ( (LA32_47=='\"'||LA32_47=='\''||LA32_47=='\\') ) {s = 134;}
						else if ( ((LA32_47 >= '\u0000' && LA32_47 <= '\b')||(LA32_47 >= '\n' && LA32_47 <= '\u001F')||(LA32_47 >= '\u007F' && LA32_47 <= '\uFFFF')) ) {s = 135;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA32_497 = input.LA(1);
						s = -1;
						if ( ((LA32_497 >= '0' && LA32_497 <= '9')) ) {s = 499;}
						else if ( ((LA32_497 >= '\u0000' && LA32_497 <= '/')||(LA32_497 >= ':' && LA32_497 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA32_502 = input.LA(1);
						s = -1;
						if ( ((LA32_502 >= '0' && LA32_502 <= '9')) ) {s = 503;}
						else if ( ((LA32_502 >= '\u0000' && LA32_502 <= '/')||(LA32_502 >= ':' && LA32_502 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA32_495 = input.LA(1);
						s = -1;
						if ( ((LA32_495 >= '0' && LA32_495 <= '9')) ) {s = 497;}
						else if ( ((LA32_495 >= '\u0000' && LA32_495 <= '/')||(LA32_495 >= ':' && LA32_495 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA32_487 = input.LA(1);
						s = -1;
						if ( ((LA32_487 >= '0' && LA32_487 <= '9')) ) {s = 491;}
						else if ( ((LA32_487 >= '\u0000' && LA32_487 <= '/')||(LA32_487 >= ':' && LA32_487 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA32_475 = input.LA(1);
						s = -1;
						if ( ((LA32_475 >= '0' && LA32_475 <= '9')) ) {s = 481;}
						else if ( ((LA32_475 >= '\u0000' && LA32_475 <= '/')||(LA32_475 >= ':' && LA32_475 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA32_425 = input.LA(1);
						s = -1;
						if ( ((LA32_425 >= '0' && LA32_425 <= '9')) ) {s = 451;}
						else if ( ((LA32_425 >= '\u0000' && LA32_425 <= '/')||(LA32_425 >= ':' && LA32_425 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA32_305 = input.LA(1);
						s = -1;
						if ( ((LA32_305 >= '0' && LA32_305 <= '9')) ) {s = 377;}
						else if ( ((LA32_305 >= '\u0000' && LA32_305 <= '/')||(LA32_305 >= ':' && LA32_305 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA32_219 = input.LA(1);
						s = -1;
						if ( ((LA32_219 >= '0' && LA32_219 <= '9')) ) {s = 305;}
						else if ( ((LA32_219 >= '\u0000' && LA32_219 <= '/')||(LA32_219 >= ':' && LA32_219 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA32_130 = input.LA(1);
						s = -1;
						if ( ((LA32_130 >= '0' && LA32_130 <= '9')) ) {s = 219;}
						else if ( ((LA32_130 >= '\u0000' && LA32_130 <= '/')||(LA32_130 >= ':' && LA32_130 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA32_451 = input.LA(1);
						s = -1;
						if ( ((LA32_451 >= '0' && LA32_451 <= '9')) ) {s = 466;}
						else if ( ((LA32_451 >= '\u0000' && LA32_451 <= '/')||(LA32_451 >= ':' && LA32_451 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA32_491 = input.LA(1);
						s = -1;
						if ( ((LA32_491 >= '0' && LA32_491 <= '9')) ) {s = 493;}
						else if ( ((LA32_491 >= '\u0000' && LA32_491 <= '/')||(LA32_491 >= ':' && LA32_491 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA32_501 = input.LA(1);
						s = -1;
						if ( ((LA32_501 >= '0' && LA32_501 <= '9')) ) {s = 502;}
						else if ( ((LA32_501 >= '\u0000' && LA32_501 <= '/')||(LA32_501 >= ':' && LA32_501 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA32_481 = input.LA(1);
						s = -1;
						if ( ((LA32_481 >= '0' && LA32_481 <= '9')) ) {s = 484;}
						else if ( ((LA32_481 >= '\u0000' && LA32_481 <= '/')||(LA32_481 >= ':' && LA32_481 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA32_41 = input.LA(1);
						s = -1;
						if ( ((LA32_41 >= '0' && LA32_41 <= '9')) ) {s = 130;}
						else if ( ((LA32_41 >= '\u0000' && LA32_41 <= '\"')||(LA32_41 >= '%' && LA32_41 <= '/')||(LA32_41 >= ':' && LA32_41 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA32_133 = input.LA(1);
						s = -1;
						if ( (LA32_133=='\'') ) {s = 222;}
						else if ( (LA32_133=='\t'||(LA32_133 >= ' ' && LA32_133 <= '!')||(LA32_133 >= '#' && LA32_133 <= '&')||(LA32_133 >= '(' && LA32_133 <= '[')||(LA32_133 >= ']' && LA32_133 <= '~')) ) {s = 133;}
						else if ( (LA32_133=='\"'||LA32_133=='\\') ) {s = 134;}
						else if ( ((LA32_133 >= '\u0000' && LA32_133 <= '\b')||(LA32_133 >= '\n' && LA32_133 <= '\u001F')||(LA32_133 >= '\u007F' && LA32_133 <= '\uFFFF')) ) {s = 135;}
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA32_377 = input.LA(1);
						s = -1;
						if ( (LA32_377=='-') ) {s = 425;}
						else if ( ((LA32_377 >= '\u0000' && LA32_377 <= ',')||(LA32_377 >= '.' && LA32_377 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA32_493 = input.LA(1);
						s = -1;
						if ( (LA32_493==':') ) {s = 495;}
						else if ( ((LA32_493 >= '\u0000' && LA32_493 <= '9')||(LA32_493 >= ';' && LA32_493 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA32_484 = input.LA(1);
						s = -1;
						if ( (LA32_484==' ') ) {s = 487;}
						else if ( ((LA32_484 >= '\u0000' && LA32_484 <= '\u001F')||(LA32_484 >= '!' && LA32_484 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA32_466 = input.LA(1);
						s = -1;
						if ( (LA32_466=='-') ) {s = 475;}
						else if ( ((LA32_466 >= '\u0000' && LA32_466 <= ',')||(LA32_466 >= '.' && LA32_466 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA32_503 = input.LA(1);
						s = -1;
						if ( (LA32_503=='#') ) {s = 504;}
						else if ( ((LA32_503 >= '\u0000' && LA32_503 <= '\"')||(LA32_503 >= '$' && LA32_503 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA32_499 = input.LA(1);
						s = -1;
						if ( (LA32_499==':') ) {s = 501;}
						else if ( ((LA32_499 >= '\u0000' && LA32_499 <= '9')||(LA32_499 >= ';' && LA32_499 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 32, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
