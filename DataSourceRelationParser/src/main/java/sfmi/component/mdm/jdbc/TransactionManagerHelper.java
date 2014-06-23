package sfmi.component.mdm.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 트랜잭션 매니저 헬퍼 클래스 
 * @author hwbae
 *
 */
public class TransactionManagerHelper {
	private static DataSourceTransactionManager dataSourceTransactionManager;
	
	public static DataSourceTransactionManager getTransactionManager(DataSource dataSource){
		if(dataSourceTransactionManager == null){
			dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		}
		
		return dataSourceTransactionManager;
	}
}
