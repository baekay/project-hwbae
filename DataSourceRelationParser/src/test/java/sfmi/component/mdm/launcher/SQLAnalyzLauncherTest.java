package sfmi.component.mdm.launcher;

import org.junit.BeforeClass;
import org.junit.Test;

public class SQLAnalyzLauncherTest {

	/**
	 * Database 초기화
	 */
	@BeforeClass
	public static void setUp(){
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceHelper.getDataSource()); 
//		Resource resource = new ClassPathResource("createTable.sql");
//		JdbcTestUtils.executeSqlScript(jdbcTemplate, resource, true);
		
	}
	
	@Test
	public void launchTest() {
		SQLAnalyzLauncher sqlAnalyzLauncher = new SQLAnalyzLauncher();
		sqlAnalyzLauncher.main(null);	
	}
}
