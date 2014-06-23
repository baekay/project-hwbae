package sfmi.component.mdm.listener;

import sfmi.component.mdm.context.BatchJobContext;

/**
 * Exception 관련 처리 Listener
 * @author hwbae
 *
 */
public class ExceptionListener {
	private static BatchJobContext jobContext = BatchJobContext.getJobContext();
	
	/**
	 * 파라미터를 key로 받아 각 exception 카운트를 증가 시켜서 저장한다.
	 * @param targetInfo 
	 */
	public static void errorCntListener(String contextKey){
		
		int count = (Integer) jobContext.getContextValue(contextKey);
		
		jobContext.setContextValue(contextKey, ++count);
	}
}
