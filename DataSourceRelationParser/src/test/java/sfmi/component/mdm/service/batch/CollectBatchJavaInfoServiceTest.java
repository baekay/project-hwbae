package sfmi.component.mdm.service.batch;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollectBatchJavaInfoServiceTest {

	@Test
	public void test() {
		
		CollectBatchJavaInfoService service = new CollectBatchJavaInfoService();
		
		service.collectJavaFile();
	}

}
