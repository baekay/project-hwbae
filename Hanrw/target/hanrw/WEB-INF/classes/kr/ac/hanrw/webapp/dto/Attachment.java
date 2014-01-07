package kr.ac.hanrw.webapp.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 14.
 * Time: 오후 11:47
 */
public class Attachment implements Serializable{
    int fileId;
    String fileNameSrc;
    String fileNameSaved;
    String filePath;
    Date createTime;
    byte[] fileData;
    int articleId;

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileNameSrc() {
        return fileNameSrc;
    }

    public void setFileNameSrc(String fileNameSrc) {
        this.fileNameSrc = fileNameSrc;
    }

    public String getFileNameSaved() {
        return fileNameSaved;
    }

    public void setFileNameSaved(String fileNameSaved) {
        this.fileNameSaved = fileNameSaved;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (fileId != that.fileId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return fileId;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "fileId=" + fileId +
                ", fileNameSrc='" + fileNameSrc + '\'' +
                ", fileNameSaved='" + fileNameSaved + '\'' +
                ", filePath='" + filePath + '\'' +
                ", createTime=" + createTime +
                ", articleId=" + articleId +
                '}';
    }
}
