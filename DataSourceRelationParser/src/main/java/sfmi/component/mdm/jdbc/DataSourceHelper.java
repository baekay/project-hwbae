package sfmi.component.mdm.jdbc;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.transaction.support.TransactionTemplate;

import sfmi.component.mdm.common.util.PropertyLoader;

/**
 * 데이터소스 관련 헬퍼클래스
 * 
 * @author 이윤걸
 *
 */
public class DataSourceHelper {
	
	private static DataSource dataSource; 
	private static BasicDataSource basicDataSource; 
	
	public static DataSource getDataSource() {
		if(basicDataSource == null) {
			setDataSource();
		}
		dataSource =basicDataSource;
		
		return dataSource;
	}
	
	private static void setDataSource() {
		basicDataSource = new BasicDataSource(); 

		basicDataSource.setDriverClassName(PropertyLoader.load().getProperty("jdbc.driver"));
		basicDataSource.setUrl(PropertyLoader.load().getProperty("jdbc.url"));
		basicDataSource.setUsername(PropertyLoader.load().getProperty("jdbc.user"));
		basicDataSource.setPassword(PropertyLoader.load().getProperty("jdbc.password"));
		
	}
}
