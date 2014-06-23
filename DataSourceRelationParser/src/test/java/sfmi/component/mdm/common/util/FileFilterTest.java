package sfmi.component.mdm.common.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 파일 필터 테스트
 * @author hwbae
 *
 */
public class FileFilterTest {
	private FileFilter fileFilter = new SfmiFileFilter();
	private	List<File> fileList = new ArrayList<File>();
	
	@Test
	public void testFileFilter() {
		String targetDir = "src/test/resources/testPJT";
		File testFile = new File(targetDir);
		
		fileList = fileCollector(testFile);
		
		for(File file : fileList){
			System.out.println("file Name : " + file);
		}
		
		Assert.assertTrue(fileList.size() == 32);
		
		
	}

	private List<File> fileCollector(File file){
		if (file.isFile()) {
			fileList.add(file);
			
		} else if (file.isDirectory()) {
			File[] children = file.listFiles(fileFilter);
			
			for(File child : children) {
				this.fileCollector(child);
			} // end of for
		} else { /* Do nothing */ }
		
		return fileList;

	}
	

}
