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
public class P2TAttachment implements Serializable {
    private int imageId;
    private int reqId;
    private int reqOrder; // 이미지순서.
    private int makeThumbnail;
    private String fileName;
    private String imageType;
    private MultipartFile imageFile;
    private byte[] imageContents;
    private byte[] thumbnailContents;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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

    public int getMakeThumbnail() {
        return makeThumbnail;
    }

    public void setMakeThumbnail(int makeThumbnail) {
        this.makeThumbnail = makeThumbnail;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) throws IOException {
        this.imageFile = imageFile;

        if (this.imageFile != null) {
            this.imageContents = this.imageFile.getBytes();
        }
    }

    public byte[] getImageContents() {
        return imageContents;
    }

    public void setImageContents(byte[] imageContents) {
        this.imageContents = imageContents;
    }

    public byte[] getThumbnailContents() {
        return thumbnailContents;
    }

    public void setThumbnailContents(byte[] thumbnailContents) {
        this.thumbnailContents = thumbnailContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        P2TAttachment that = (P2TAttachment) o;

        if (imageId != that.imageId) return false;
        if (makeThumbnail != that.makeThumbnail) return false;
        if (reqId != that.reqId) return false;
        if (reqOrder != that.reqOrder) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (!Arrays.equals(imageContents, that.imageContents)) return false;
        if (imageType != null ? !imageType.equals(that.imageType) : that.imageType != null) return false;
        if (!Arrays.equals(thumbnailContents, that.thumbnailContents)) return false;
        if (imageFile != null ? !imageFile.equals(that.imageFile) : that.imageFile != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId;
        result = 31 * result + reqId;
        result = 31 * result + reqOrder;
        result = 31 * result + makeThumbnail;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (imageType != null ? imageType.hashCode() : 0);
        result = 31 * result + (imageFile != null ? imageFile.hashCode() : 0);
        result = 31 * result + (imageContents != null ? Arrays.hashCode(imageContents) : 0);
        result = 31 * result + (thumbnailContents != null ? Arrays.hashCode(thumbnailContents) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "P2TAttachment{" +
                "imageId=" + imageId +
                ", reqId=" + reqId +
                ", reqOrder=" + reqOrder +
                ", makeThumbnail=" + makeThumbnail +
                ", fileName='" + fileName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imageFile=" + imageFile +
                ", imageContents=" + Arrays.toString(imageContents) +
                ", thumbnailContents=" + Arrays.toString(thumbnailContents) +
                '}';
    }
}

