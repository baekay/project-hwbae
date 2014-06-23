package sfmi.component.mdm.context;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hwbae
 *
 */
public class SqlMapResourceContextHolder {
	private static final List<String> contextHolder = new ArrayList<String>();
	
	public static void setSqlMapResource(String location) {
		contextHolder.add(location);
	}
	
	public static List<String> getSqlMapResourceContext() {
		return contextHolder;
	}
}
