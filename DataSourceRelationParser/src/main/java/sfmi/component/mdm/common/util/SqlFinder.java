package sfmi.component.mdm.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.SqlFinder.Statement.Fragment;
import sfmi.component.mdm.exception.SqlFinderException;


/**
 * JDBC API를 사용하여 SQL 쿼리를 분리할 경우 사용한다.
 * Batch 어플리케이션에서 SQL 정보를 추출할 경우 사용
 * 
 * @author hwbae
 */
public class SqlFinder {

    private static final String XML_DAO_STATEMENTS = "DAOStatements";
    private static final String XML_SQL_STATEMENT = "SQLStatement";
    private static final String XML_METHOD = "method";
    private static final String XML_SQL_FRAGMENT = "SQLFragment";

    private static Map<String, Statement> sqlStatements = new HashMap<String, Statement>();
    private static Logger logger = Logger.getLogger(SqlFinder.class);
    private static Map<String, Map<String, Statement>> mappingInfo = new HashMap<String, Map<String, Statement>>();

    public static final String SQLFILE_IDENTIFIER = "-- sqlFile : ";
	public static final String SQLID_IDENTIFIER = "-- sqlId : ";
	public static final String SQL_LINE_DELEMETER = "\n";

    /**
     * Sql Query가 기술되어있는 Dao(XML) configuration파일을 Parsing하여
     * Sql statement를 load한다.
     * @param sqlFile
     * @throws ParserConfigurationException 
     * @throws IOException 
     * @throws SAXException 
     * @throws Exception 
     */
    private static void begin(String file) throws SqlFinderException, SAXException, IOException, ParserConfigurationException, FileNotFoundException {
    	File sqlFile = new File(file);
        
    	if(!sqlFile.exists()) {
    		throw new SqlFinderException(SQLAnalyzerConstants.NO_FILE, file, null);
    	}
    	
    	InputStream is = new FileInputStream(sqlFile);

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(true);
        parserFactory.setNamespaceAware(true);

		loadSQLStatements(parserFactory.newSAXParser(), new InputSource(is));

    }

    /**
     * Sql 파일로부터 지정된 SqlId에 해당 하는 Sql문을 반환한다.
     * @param sqlFile
     * @param sqlId
     * @return String
     * @throws ParserConfigurationException 
     * @throws IOException 
     * @throws SAXException 
     * @throws Exception 
     */
    public static String getSql(String sqlFile, String sqlId) throws SqlFinderException, SAXException, IOException, ParserConfigurationException, FileNotFoundException {
    	String modifiedSql;
    	if(sqlFile == null || sqlId == null || sqlFile.equals("") || sqlId.equals(""))
    		throw new SqlFinderException(SQLAnalyzerConstants.NO_FILE_SQLID, sqlFile, sqlId);

    	if(mappingInfo.get(sqlFile) == null) {
    		begin( sqlFile);
    		Map<String, Statement> statements = new HashMap<String, Statement>();
    		statements.putAll(sqlStatements);
    		mappingInfo.put(sqlFile, statements);
    	}
    	sqlStatements.clear();
		Map<String, Statement> sqlStatementsMap = mappingInfo.get(sqlFile);
		if(sqlStatementsMap == null || sqlStatementsMap.size() == 0 )
			throw new SqlFinderException(SQLAnalyzerConstants.NO_FILE, sqlFile, sqlId);

		Statement statement = sqlStatementsMap.get(sqlId);

		if(statement == null)
			throw new SqlFinderException(SQLAnalyzerConstants.NO_SQL_STATEMENT, sqlFile, sqlId);

//		modifiedSql = SQLFILE_IDENTIFIER + sqlFile + SQL_LINE_DELEMETER + SQLID_IDENTIFIER + sqlId + SQL_LINE_DELEMETER + statement.toString();
		modifiedSql = statement.toString();
		return modifiedSql;
    }

    /**
     * InputStream을 SAXParser로 Parsing한다.
     * @param parser SAXParser
     * @param source InputStream
     * @throws SAXException
     * @throws IOException
     */
    private static void loadSQLStatements(SAXParser parser,
                                         InputSource source) throws SAXException, IOException {
        parser.parse(source, new DefaultHandler() {
            private boolean foundEntry = false;
            private String operation = null;

            List<Fragment> fragments = new ArrayList<Fragment>();
            Statement.Fragment fragment;

            private StringBuffer buffer = new StringBuffer();

            public void startElement(String namespace, String name, String qName, Attributes attrs)
                throws SAXException {

                if (!foundEntry) {
                    if (name.equals(XML_DAO_STATEMENTS)  ) {
                        foundEntry = true;
                    }
                }
                else if (operation != null) {
                    if (name.equals(XML_SQL_FRAGMENT)) {
                        fragment = new Statement.Fragment();
                        buffer.setLength(0);
                    }
                }
                else {
                    if (name.equals(XML_SQL_STATEMENT)) {
                        operation = attrs.getValue(XML_METHOD);
                        fragments.clear();
                    }
                }
            }

            public void characters(char[] chars, int start, int length) throws SAXException {
                if (foundEntry && operation != null) {
                	buffer.append(chars, start, length);
                }
            }

			public void endElement(String namespace, String name, String qName) throws SAXException {
                if (foundEntry) {
                    if (name.equals(XML_DAO_STATEMENTS)) {
                        foundEntry = false;
                    }
                    else if (name.equals(XML_SQL_STATEMENT)) {
                        Statement statement = new Statement();
                        statement.fragments = (Statement.Fragment[]) fragments.toArray(new Statement.Fragment[0]);

                    	sqlStatements.put(operation, statement);
                        operation = null;
                    }
                    else if (name.equals(XML_SQL_FRAGMENT)) {
                        fragment.text = buffer.toString().trim();
                        fragments.add(fragment);
                        fragment = null;
                    }
                }
            }

            public void warning(SAXParseException exception) {
                logger.error("[Warning]: " + exception.getMessage());
            }

            public void error(SAXParseException exception) {
                logger.error("[Error]: " + exception.getMessage());
            }

            public void fatalError(SAXParseException exception) throws SAXException {
                logger.error("[Fatal Error]: " + exception.getMessage());
                throw exception;
            }
        });
    }

    /**
     * SqlFinder에서 사용하기 위한 Statitc Inner Class
     */
    public static class Statement {
        Fragment[] fragments;

        static class Fragment {

            String text;

            public String toString() {
            	return new StringBuffer(text).toString();
            }

        }

        public String toString() {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < fragments.length; i++) {
                buffer.append(fragments[i].toString()).append("\n\t");
            }
            return buffer.toString();
        }
    }
}
