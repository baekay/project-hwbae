package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.V2TAttachment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 8.
 * Time: 오후 9:04
 * To change this template use File | Settings | File Templates.
 */
public interface V2TAttachmentDao {

    public void insertAudio(V2TAttachment attachment);
    public List<V2TAttachment> getReqAudioListBy(int audioId);
    public V2TAttachment getAudioBy(int audioId);
    public V2TAttachment getThumbnailBy(int audioId);
    public void deleteAudio(int audioId);
    public void deleteAudios(int reqId);

}
