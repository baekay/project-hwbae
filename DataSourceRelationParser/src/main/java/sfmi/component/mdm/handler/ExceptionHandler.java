
package sfmi.component.mdm.handler;

import japa.parser.ParseException;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;
import sfmi.component.mdm.common.util.AnalyzerStringUtil;
import sfmi.component.mdm.common.util.JavaSourceParser;
import sfmi.component.mdm.common.util.SqlFinder;
import sfmi.component.mdm.dto.ErrorDTO;
import sfmi.component.mdm.exception.SqlFinderException;
import sfmi.component.mdm.listener.ExceptionListener;

import com.sun.xml.internal.xsom.parser.XMLParser;

/**
 * Exception 발생시 처리 핸들러
 * 
 * @author  hwbae
 * 
 */
public class ExceptionHandler {
	private static Logger logger = Logger.getLogger(ExceptionHandler.class);
	private static Map<String ,ErrorDTO> errorDTOMap = new HashMap<String, ErrorDTO>();
	
	/**
	 * 익셉션 로그와 stackTrace 출력
	 * @param e
	 * @param sqlId 
	 */
	public static void handle(Exception e, String classfilePath, String methodName,
			String xmlFilePath, String sqlId, String sql, Class<?> clazz) {
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date();
		
		
		
		ErrorDTO errorDTO = null;
		String dot = ".";
		// SQL 분석중 오류시 중복 제거를 위한 key 생성
		String key = classfilePath + dot + xmlFilePath + dot + sqlId + dot + sql;
				
		if (e instanceof RecognitionException) {
			errorDTO = new ErrorDTO();
			errorDTO.setSqlId(sqlId);
			errorDTO.setExceptionClassify(SQLAnalyzerConstants.EXCEPTION_SQL_ERR);
			errorDTO.setSqlStatement(sql);
			errorDTO.setClassName(classfilePath);
			errorDTO.setMethodName(methodName);
			errorDTO.setXmlFilePath(xmlFilePath);
			errorDTO.setStatus("R");
			errorDTO.setExceptionMsg(getExceptionMessage(e));
			errorDTO.setOccurTime(mSimpleDateFormat.format (currentTime));

			if(errorDTOMap.get(key) == null || errorDTOMap.get(key).equals("")){

				/*
				 * Exception메세지 비교
				 */
				int result = recognizeExcetpionAnalzyer(getExceptionMessage(e));
				String errorMsg;
				
				if(result == SQLAnalyzerConstants.SQL_EXCEPTION_NO_SQL){
					errorMsg = "분석할 SQL이 존재하지 않습니다.";
					ExceptionListener.errorCntListener(SQLAnalyzerConstants.NOT_EXIST_SQL_CNT);
//				} else if(result == SQLAnalyzerConstants.SQL_EXCEPTION_MANY_DEPTH){
//					ExceptionListener.errorCntListener(SQLAnalyzerConstants.SQL_ANALYZE_FAIL_CNT);
//					errorMsg = "FUNCTION의 DEPTH가 22이상입니다.";
				} else {
					ExceptionListener.errorCntListener(SQLAnalyzerConstants.SQL_ANALYZE_FAIL_CNT);
					errorMsg = "SQL 분석중 오류가 발생하였습니다.";
				}
				
				// SQL 분석 오류
				logger.error(errorMsg+" SQL ID : "+sqlId+", " + getExceptionMessage(e));
				
				/*
				 * 로그 파일에 찍는 내용
				 */
				logger.error("------------------------------- SQL ERROR ---------------------------------");
				logger.error("--- CLASS NAME : " + errorDTO.getClassName());
				logger.error("--- XML NAME : " + errorDTO.getXmlFilePath());
				logger.error("--- SQL ID : " + errorDTO.getSqlId());
				logger.error("--- SQL : " + errorDTO.getSqlStatement());
				logger.error("---------------------------------------------------------------------------");
				
//				outPutFile(errorDTO);
			} else {
				logger.error("이미 존재하는 SQL분석 오류");
			}
			
			
		} else if((e instanceof ParserConfigurationException) || 
					(e instanceof SAXException) ||
					(e instanceof IOException && clazz.equals(XMLParser.class) )){
			
			errorDTO = new ErrorDTO();
			errorDTO.setExceptionClassify(SQLAnalyzerConstants.EXCEPTION_XML_ERR);
			errorDTO.setXmlFilePath(AnalyzerStringUtil.setFileRootDir(xmlFilePath));
			errorDTO.setStatus("R");
			errorDTO.setExceptionMsg(getExceptionMessage(e));
			errorDTO.setOccurTime(mSimpleDateFormat.format (currentTime));
			
			// XML 파싱 오류  
			ExceptionListener.errorCntListener(SQLAnalyzerConstants.XML_PARSE_FAIL_CNT);
			
			logger.error("XML 파일 파싱중 오류가 발생하였습니다. FILE : " + xmlFilePath + ", " + getExceptionMessage(e));
			
		} else if((e instanceof ParseException) ||
			(e instanceof IOException && clazz.equals(JavaSourceParser.class) ||
					(e instanceof IOException && clazz.equals(SqlFinder.class)) ||
					(e instanceof NullPointerException && clazz.equals(JavaSourceParser.class)))){
			
			errorDTO = new ErrorDTO();
			errorDTO.setExceptionClassify(SQLAnalyzerConstants.EXCEPTION_JAVA_ERR);
			errorDTO.setClassName(classfilePath);
			errorDTO.setStatus("R");
			errorDTO.setExceptionMsg(getExceptionMessage(e));
			errorDTO.setOccurTime(mSimpleDateFormat.format (currentTime));
			
			// java 파일 파싱 오류
			ExceptionListener.errorCntListener(SQLAnalyzerConstants.JAVA_PARSE_FAIL_CNT);
			
			logger.error("자바 파일 파싱중 오류가 발생하였습니다. FILE :" + classfilePath + ", " + getExceptionMessage(e));
			
		}  else if(e instanceof FileNotFoundException){
			logger.error("파일을 찾을 수 없습니다. FILE" + xmlFilePath + ", " + getExceptionMessage(e));
			ExceptionListener.errorCntListener(SQLAnalyzerConstants.ETC_FAIL_CNT);
			
		} else if(e instanceof SqlFinderException){
			
			logger.error(" SqlFinder 클래스 사용도중 에러가 발생하였습니다. \n" +
					((SqlFinderException) e).getExceptionMsg() + ", \n" + 
					"JAVA FILE : " + classfilePath + 
					getExceptionMessage(e));
			ExceptionListener.errorCntListener(SQLAnalyzerConstants.ETC_FAIL_CNT);
			
		} else if (e instanceof Exception){
			errorDTO = new ErrorDTO();
			errorDTO.setExceptionClassify(SQLAnalyzerConstants.EXCEPTION_UNKOWN_ERR);
			errorDTO.setClassName(classfilePath);
			errorDTO.setXmlFilePath(xmlFilePath);
			errorDTO.setStatus("R");
			errorDTO.setExceptionMsg(getExceptionMessage(e));
			errorDTO.setOccurTime(mSimpleDateFormat.format (currentTime));
			
			logger.error("알 수 없는 에러발생 \n"
					+ "JAVA FILE : " + classfilePath);
			ExceptionListener.errorCntListener(SQLAnalyzerConstants.ETC_FAIL_CNT);
		
		} else {
			/*
			 * TODO :: javaParser사용중 에러 수정필요
			 */
			errorDTO = new ErrorDTO();
			errorDTO.setExceptionClassify(SQLAnalyzerConstants.EXCEPTION_UNKOWN_ERR);
			errorDTO.setClassName(classfilePath);
			errorDTO.setXmlFilePath(xmlFilePath);
			errorDTO.setStatus("R");
//			errorDTO.setExceptionMsg(getExceptionMessage(e));
			errorDTO.setOccurTime(mSimpleDateFormat.format (currentTime));
			
			logger.error("javaParser사용중 에러  \n"
					+ "JAVA FILE : " + classfilePath);
			ExceptionListener.errorCntListener(SQLAnalyzerConstants.ETC_FAIL_CNT);
		}
		
		if(errorDTO != null){
			errorDTOMap.put(key, errorDTO);
		}
	}
	

	/**
	 * 예외에 대한 StackTrace를 문자열로 변환.
	 * 
	 * @param exception
	 * @return
	 */
	public static String getExceptionMessage(Exception exception) {
		String newLine = System.getProperty("line.separator");
		StringBuilder message = new StringBuilder();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		exception.printStackTrace(ps);
		int firstEnter = os.toString().indexOf(newLine);
		int endOfIndex = os.toString().indexOf(newLine, firstEnter + 1);
		message.append("\n\t").append(os.toString().substring(0, endOfIndex));
		if (ps != null) {
			ps.close();
			ps = null;
		}
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				os = null;
			}
		}
		return message.toString();
	}


	public static Map<String, ErrorDTO> getErrorDTOMap() {
		return errorDTOMap;
	}
	public static void setInitErrorDTOMap(){
		errorDTOMap.clear();
	}
	
	
	/**
	 * SQL 오류 메시지 분석하여 
	 * 분석할 SQL이 존재하지 않으면 false return
	 * @param exceptionMsg
	 */
	private static int recognizeExcetpionAnalzyer(String exceptionMsg){
		// 분석할 SQL이 없는 경우 항상 이 메세지
		String noSQLErrMsg = "NoViableAltException(-1@[])	at parser.sql.SQLAnalyzerParser.statement(SQLAnalyzerParser.java:343)";
		// groupFunction depth가 22초과하여 exception발생 했을 경우 
//		String manyDepthErrMsg = "org.antlr.runtime.RecognitionException	at parser.sql.SQLAnalyzerParser.groupFunction(SQLAnalyzerParser.java:10541)";
		
		// 스페이스 및 개행 제거 
		exceptionMsg = exceptionMsg.replace(System.getProperty("line.separator"), "");
		exceptionMsg = exceptionMsg.trim();
		
		if(exceptionMsg.equals(noSQLErrMsg)){
			return SQLAnalyzerConstants.SQL_EXCEPTION_NO_SQL;
		} else {
			return SQLAnalyzerConstants.SQL_EXCEPTION_ETC;
		}
	}
	/**
	 * SQL 분석 오류를 파일로 쓴다.
	 * @param errorDto
	 */
//	private static void outPutFile(ErrorDTO errorDto){
//		
//		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMdd_HHmm", Locale.KOREA );
//		Date currentTime = new Date();
//		String dateTime = mSimpleDateFormat.format (currentTime);
//		
//		String newLine = System.getProperty("line.separator");
//		
//		try {
//			
//			StringBuilder msg = new StringBuilder();
//			File errorSqlFile = new File("D:\\ANTLR_WORK\\doc\\sqlError\\SQLError_" + dateTime + ".txt");
//
//			msg.append("------------------------------- SQL ERROR ---------------------------------").append(newLine);
//			msg.append("--- CLASS NAME : " + errorDto.getClassName()).append(newLine);
//			msg.append("--- XML NAME : " + errorDto.getXmlFilePath()).append(newLine);
//			msg.append("--- SQL ID : " + errorDto.getSqlId()).append(newLine);
//			msg.append("--- SQL : " + errorDto.getSqlStatement()).append(newLine);
//			msg.append("---------------------------------------------------------------------------").append(newLine);
//			
//			PrintWriter fileWriter = new PrintWriter(new FileWriter(errorSqlFile,true));
//			fileWriter.write(msg.toString());
//			fileWriter.write(newLine);
//			fileWriter.close();
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	}

}
