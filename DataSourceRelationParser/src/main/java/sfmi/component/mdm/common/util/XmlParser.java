package sfmi.component.mdm.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ibm.icu.text.CharsetDetector;

/**
 * XML 파일 Doc파싱
 * @author hwbae
 *
 */
public class XmlParser {

	/**
	 * XML DOCUMENT 파싱
	 * 
	 * @param xmlFile
	 * @return Document
	 */
	public static Document getDocument(File xmlFile) throws SAXException, ParserConfigurationException, IOException {
		// XML file DOM Parsing
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;
		
		//encoding Type parsing
		String encoding = getEncodingString(xmlFile);
		dBuilder = dbFactory.newDocumentBuilder();

		InputStream inputStream= new FileInputStream(xmlFile);
		
		BOMInputStream bomInputStream = new BOMInputStream(inputStream);
		ByteOrderMark bom = bomInputStream.getBOM();
		String charsetName = bom == null ? encoding : bom.getCharsetName();
		
//        Reader reader = new InputStreamReader(inputStream,encoding);
		Reader reader = new InputStreamReader(new BufferedInputStream(bomInputStream),charsetName);
        InputSource inputSource = new InputSource(reader);
        inputSource.setEncoding(encoding);
        
		// 스키마 체트 하지 않는다.
		dBuilder.setEntityResolver(new EntityResolver() {
			public InputSource resolveEntity(String publicId, String systemId)
					throws SAXException, IOException {
				return new InputSource(new StringReader(""));
			}
		});
		
		dBuilder.setErrorHandler(null);
		
		doc = dBuilder.parse(inputSource);

		return doc;
	}
	
	/**
     * Parameter 로 전달된 파일의 인코딩 형식을 문자열로 반환한다.
     * @param file
     * @return 인코딩 형식
     */
    private static String getEncodingString (File file) throws IOException {
        String encoding = "";
        RandomAccessFile randomAccessFile = null;
        CharsetDetector detector;
        byte[] fileByteArray = null;
        randomAccessFile = new RandomAccessFile(file.getAbsoluteFile(), "r");
        fileByteArray = new byte[(int)randomAccessFile.length()];
        detector = new CharsetDetector();
        randomAccessFile.read(fileByteArray);
        detector.setText(fileByteArray);
        encoding = detector.detect().getName();
        fileByteArray = null;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            randomAccessFile = null;
        }
        return encoding;
    } // end of method
	

}
