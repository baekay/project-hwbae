package sfmi.component.mdm.common.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sfmi.component.mdm.common.constant.SQLAnalyzerConstants;

/**
 * 파일 수집 클래스
 * @author hwbae
 *
 */
public class FileCollector {
	private List<File> fileList = new ArrayList<File>();
	private int collectMode;	// 수집 모드 1 : XML, 2: JAVA
	private FileFilter fileFilter = new SfmiFileFilter();
	
	public FileCollector(int collectMode) {
		this.collectMode = collectMode;
	}

	/**
	 * 파일 확장자 검사 후 수집 
	 */
	public void collectFiles(File file) {
		if (file.isFile()) {
			
			// 확장자 검사 후  add
			if(this.extChecker(file, collectMode)){
				this.fileList.add(file);
			} else { /* DO NOTHING */ }
			
		} else if (file.isDirectory()) {
			File[] children = file.listFiles(fileFilter);
			for(File child : children) {
				this.collectFiles(child);
			} // end of for
		} else { /* Do nothing */ }
	} // end of searchingFiles(...)
	
	
	/**
	 * 확장자 검사
	 */
	public boolean extChecker(File file, int collectMode){
		
		String checkExt = null;
		boolean extResult;
		
		// java 확장자 체크 모드
		if(collectMode == SQLAnalyzerConstants.JAVA_FILE_COLLECT_MODE){
			checkExt = SQLAnalyzerConstants.FILE_EXTENSION_JAVA;
		// xml  확장자 체크 모드
		} else if(collectMode == SQLAnalyzerConstants.XML_FILE_COLLECT_MODE){
			checkExt = SQLAnalyzerConstants.FILE_EXTENSION_XML;
		} else {/* DO NOTHING */}
		
		// 정규식 set
		String regex = "^\\S+.(?i)("+ checkExt +")$";
		
		// 확장자 check
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(file.getName());
		extResult = m.matches();
		
		return extResult;
	}
	
	public List<File> getFileList() {
		return fileList;
	}

	public void setFileList(List<File> fileList) {
		this.fileList = fileList;
	}
	
	public int getCollectMode() {
		return collectMode;
	}

	public void setCollectMode(int collectMode) {
		this.collectMode = collectMode;
	}

	
}
