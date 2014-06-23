package sfmi.component.mdm.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 프로퍼티 정보를 읽어온다
 * 
 * @author 이윤걸
 *
 */
public class PropertyLoader {
    private static final String PROPERTY_NAME = "sqlAnalyzer.properties";
    private static Properties properties;

    /**
     * 디폴트 프로퍼티 파일을 읽어온다.
     */
    public static synchronized Properties load() {
        if(properties == null) {
            properties = load(PROPERTY_NAME);
        }

        return properties;
    }

    /**
     * 지정한 프로퍼티 파일을 읽어온다.
     */
    public static Properties load(String propertyFileName) {
        Properties prop = new Properties();
        InputStream is = null;

        try {
             //prop.load(getFileResourceAsStream(propertyFileName));
        	is = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFileName);
        	prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if (is !=null)
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
        return prop;
    }
    
    /**
     * 지정한 XML 파일을 읽어온다.
     */
    public static Properties loadFromXML(String xmlFileName) {
    	Properties prop = new Properties();
    	InputStream is = null;
    	
    	try {
    		//prop.load(getFileResourceAsStream(propertyFileName));
    		is = Thread.currentThread().getContextClassLoader().getResourceAsStream(xmlFileName);
    		prop.loadFromXML(is);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		if (is !=null)
    			try {
    				is.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    	}
    	return prop;
    }

    /**
     * 클래스패스에 없는 프로퍼티 파일을 읽어온다.
     */
    public static Properties loadExternalProperty(String propertyFullPath) {
        Properties prop = new Properties();
        FileInputStream fileInputStream = null;

        try {
            //FileInputStream fileInputStream = new FileInputStream(new File(propertyFullPath));
        	fileInputStream = new FileInputStream(new File(propertyFullPath));
            prop.load(fileInputStream);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
        	if (fileInputStream != null)
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
        return prop;
    }

    /**
     * InputStream을 생성하여 반환한다.
     */
//    private static InputStream getFileResourceAsStream(String fileName) {
//        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
//        return is;
//    }
}
