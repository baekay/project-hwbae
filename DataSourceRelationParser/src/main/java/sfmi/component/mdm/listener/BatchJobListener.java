package sfmi.component.mdm.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import sfmi.component.mdm.context.BatchJobContext;


/**
 * 작업 중 필요한 정보 저장 
 * @author hwbae
 *
 */
public class BatchJobListener {
	private static BatchJobContext jobContext = BatchJobContext.getJobContext();
	
	
	/**
	 * 시작시간 및 종료시간 저장 Listener
	 * @param 
	 */
	public static void timeListener(String contextKey){
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date();
		
		jobContext.setContextValue(contextKey, mSimpleDateFormat.format (currentTime));
	}
	
	
	/**
	 * BATCH JOB LISTENER
	 * 파라미터를 key로 받아 각 카운트를 증가 시켜서 저장한다.
	 * @param targetInfo 
	 */
	public static void countListener(String contextKey){
		
		int count = (Integer) jobContext.getContextValue(contextKey);
		
		jobContext.setContextValue(contextKey, ++count);
			
	}
}
