package sfmi.component.mdm.common.util;

import java.io.File;
import java.io.FileFilter;

/**
 * fileFilter 클래스
 *  
 * 특정 파일명을 제외하고 수집하기 위해서 구현
 * 
 * @author hwbae
 *
 */
public class SfmiFileFilter implements FileFilter {

	public boolean accept(File pathname) {
		
		boolean isAccept = true;
		if(pathname.getName().equals("lost+found")) {
			isAccept = false;
		}
		return isAccept;
	}
}
