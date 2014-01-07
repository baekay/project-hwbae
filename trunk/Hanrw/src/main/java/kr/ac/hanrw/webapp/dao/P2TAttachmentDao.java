package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.P2TAttachment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 8.
 * Time: 오후 9:04
 * To change this template use File | Settings | File Templates.
 */
public interface P2TAttachmentDao {

    public void insertImage(P2TAttachment attachment);
    public List<P2TAttachment> getReqImageListBy(int imageId);
    public P2TAttachment getImageBy(int imageId);
    public P2TAttachment getThumbnailBy(int imageId);
    public void deleteImage(int imageId);
    public void deleteImages(int reqId);

}
