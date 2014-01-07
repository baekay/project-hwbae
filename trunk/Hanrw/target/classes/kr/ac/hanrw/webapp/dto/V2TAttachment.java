package kr.ac.hanrw.webapp.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 24
 * Time: 오전 9:24
 * To change this template use File | Settings | File Templates.
 */
public class V2TAttachment implements Serializable {
    private int audioId;
    private int reqId;
    private int reqOrder; // 이미지순서.
    private String fileName;
    private String audioType;
    private MultipartFile audioFile;
    private byte[] audioContents;

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public int getReqOrder() {
        return reqOrder;
    }

    public void setReqOrder(int reqOrder) {
        this.reqOrder = reqOrder;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public MultipartFile getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(MultipartFile audioFile) throws IOException {
        this.audioFile = audioFile;

        if (this.audioFile != null) {
            this.audioContents = this.audioFile.getBytes();
        }
    }

    public byte[] getAudioContents() {
        return audioContents;
    }

    public void setAudioContents(byte[] audioContents) {
        this.audioContents = audioContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        V2TAttachment that = (V2TAttachment) o;

        if (audioId != that.audioId) return false;
        if (reqId != that.reqId) return false;
        if (reqOrder != that.reqOrder) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (!Arrays.equals(audioContents, that.audioContents)) return false;
        if (audioType != null ? !audioType.equals(that.audioType) : that.audioType != null) return false;
        if (audioFile != null ? !audioFile.equals(that.audioFile) : that.audioFile != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = audioId;
        result = 31 * result + reqId;
        result = 31 * result + reqOrder;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (audioType != null ? audioType.hashCode() : 0);
        result = 31 * result + (audioFile != null ? audioFile.hashCode() : 0);
        result = 31 * result + (audioContents != null ? Arrays.hashCode(audioContents) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "P2TAttachment{" +
                "audioId=" + audioId +
                ", reqId=" + reqId +
                ", reqOrder=" + reqOrder +
                ", fileName='" + fileName + '\'' +
                ", audioType='" + audioType + '\'' +
                ", audioFile=" + audioFile +
                ", audioContents=" + Arrays.toString(audioContents) +
                '}';
    }
}

