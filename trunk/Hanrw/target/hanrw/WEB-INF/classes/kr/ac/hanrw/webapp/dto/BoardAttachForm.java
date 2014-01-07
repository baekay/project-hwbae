package kr.ac.hanrw.webapp.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 용이
 * Date: 13. 9. 27
 * Time: 오전 12:09
 * To change this template use File | Settings | File Templates.
 */
public class BoardAttachForm {
    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
