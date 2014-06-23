package sfmi.component.mdm.common.constant;

/**
 * 공통으로 사용하는 상수 클래스
 * 
 * @author  이윤걸
 *
 */
public interface SQLAnalyzerConstants {
	public static final int POSITIVE_INTEGER = 1;

    public static final int NEGATIVE_INTEGER = -1;

    public static final int ZERO_INTEGER = 0;
    
    public static final String DIR_DELIMITER = "/";
    
    public static final String DOT = ".";
    
    public static final String FILE_EXTENSION_JAVA = "java";

    public static final String FILE_EXTENSION_XML = "xml";
    
    public static final int XML_FILE_COLLECT_MODE = 1;
    
    public static final int JAVA_FILE_COLLECT_MODE = 2;
    
    public static final String EXTENDS_NAME_PROCESSOR = "SfmiProcessor";
    public static final String EXTENDS_NAME_READER = "SfmiDbReaderHelper";
    public static final String EXTENDS_NAME_WRITER = "SfmiDbWriterTemplate";
    public static final String EXTENDS_NAME_DAOSUPPORT = "SfmiSimpleJdbcDaoSupport";
    
    public static final String EXTENDS_NAME = "EXTENDS_NAME";
    
    public static final String IMPLEMENTS_NAME = "IMPLEMENTS_NAME";
    
    // JOB CONTEXT에 저장위한 KEY값 선언
    /*
     * 대상 자바 파일 수 
     */
    public static final String JAVA_FILE_CNT = "JAVA_CNT";
    /*
     * 대상 XML 파일 수 
     */
    public static final String XML_FILE_CNT = "XML_CNT";
    /*
     * XML에 선언된 SQL ID 수
     */
    public static final String SQL_ID_CNT = "SQL_ID_CNT";
    /*
     * JAVA에 선언된 SQL ID 수
     */
    public static final String JAVA_SQL_ID_CNT = "JAVA_SQL_ID_CNT";
    /*
     * XML에 선언된 SQL ID 수
     */
    public static final String XML_SQL_ID_CNT = "XML_SQL_ID_CNT";
    /*
     * DYNAMIC SQL ID 수
     */
    public static final String DYNAMIC_SQL_ID_CNT = "DYNAMIC_SQL_ID_CNT";
    /*
     * 분석 성공 SQL ID 수
     */
    public static final String SQL_ANALYZE_SUCESS_CNT = "SQL_ANALYZE_SUCESS_CNT";
    /* 
     * XML에 매칭되는 SQL ID가 미존재
     */
    public static final String NOT_EXIST_SQL_CNT = "NOT_EXIST_SQL_CNT";
    /*
     * 분석 실패 SQL ID 수
     */
    public static final String SQL_ANALYZE_FAIL_CNT = "SQL_ANALYZE_FAIL_CNT";
    /*
     * 매칭 된 SQL ID 수
     */
    public static final String MATCH_SQL_ID_CNT = "MATCH_SQL_ID_CNT";
    /*
     * JAVA 파일 파싱 실패 수 
     */
    public static final String JAVA_PARSE_FAIL_CNT = "JAVA_PARSE_FAIL_CNT";
    /*
     * XML 파일 파싱 실패 수 
     */
    public static final String XML_PARSE_FAIL_CNT = "XML_PARSE_FAIL_CNT";
    /*
     * 기타 오류 수 
     */
    public static final String ETC_FAIL_CNT = "ETC_FAIL_CNT";
    /*
     * 시작 시간
     */
    public static final String START_TIME = "START_TIME";
    /*
     * 종료 시간
     */
    public static final String END_TIME = "END_TIME";
    /*
     * BATCH JOB파일 개수 
     */
    public static final String JOB_XML_FILE_CNT = "JOB_XML_FILE_CNT";
    /*
     * REPORT 개수 
     */
    public static final String REPORT_CNT = "REPORT_CNT";
    /*
     * Insert 쿼리 수 
     */
    public static final String INSERT_SQL_CNT = "INSERT_SQL_CNT";
    /*
     * Select 쿼리 수 
     */
    public static final String SELECT_SQL_CNT = "SELECT_SQL_CNT";
    /*
     * Merge 쿼리 수 
     */
    public static final String MERGE_SQL_CNT = "MERGE_SQL_CNT";
    /*
     * Update 쿼리 수 
     */
    public static final String UPDATE_SQL_CNT = "UPDATE_SQL_CNT";
    /*
     * Delete 쿼리 수 
     */
    public static final String DELETE_SQL_CNT = "DELETE_SQL_CN";
    
    /*
     *  SQLFinderException 구분자
     */
    
    /*
     * file 또는 sqlId가 없다
     */
    public static final int NO_FILE_SQLID = 1;
    /*
     * XML FILE이 존재하지 않는다. 
     */
    public static final int NO_FILE = 2;
    /*
     * QUERY가 존재하지 않는다.
     */
    public static final int NO_SQL_STATEMENT = 3;

    /*
     * BATCH Class 타입
     */
    public static final String BATCH_GENERAL_CLASS = "GENERAL"; 
    public static final String BATCH_PROCESSOR_CLASS = "PROCESSOR"; 
    public static final String BATCH_DAO_CLASS = "DAO"; 
    		
    /*
     * BATCH 파일 타입
     */
    public static final String BATCH_EXECUTE_STEP = "SQL_EXECUTE_STEP";
    public static final String BATCH_READER = "01";
    public static final String BATCH_PROCESSOR = "02";
    public static final String BATCH_WRITER = "03";
    
    /*
     * 소스 타입
     */
    public static final String PRG_TYPE_ONLINE = "01";
    public static final String PRG_TYPE_BATCH = "02";
    public static final String PRG_TYPE = "PRG_TYPE";
    /*
     * SQL 타입
     */
    public static final String SQL_TYPE_INSERT = "01";
    public static final String SQL_TYPE_SELECT = "02";
    public static final String SQL_TYPE_UPDATE = "03";
    public static final String SQL_TYPE_DELETE = "04";
    public static final String SQL_TYPE_MERGE = "05";
     
    /*
     * 오류 구분
     */
    public static final String EXCEPTION_SQL_ERR = "01";
    public static final String EXCEPTION_XML_ERR = "02";
    public static final String EXCEPTION_JAVA_ERR = "03";
    public static final String EXCEPTION_UNKOWN_ERR = "04";
    
    /*
     * 시스템 아이디 또는 VOB명
     */
    public static final String SYSTEM_ID = "SYSTEM_ID";
    public static final String VOB_NAME = "VOB_NAME";
    /*
     * SQL분석 Exception종류
     */
    public static final int SQL_EXCEPTION_NO_SQL = 1;
    public static final int SQL_EXCEPTION_MANY_DEPTH = 2;
    public static final int SQL_EXCEPTION_ETC = 3;
    
    /*
     * 수행이력 SEQ 저장
     */
    public static final String DATA_RLT_SEQ = "DATA_RLT_SEQ";
    		
}
