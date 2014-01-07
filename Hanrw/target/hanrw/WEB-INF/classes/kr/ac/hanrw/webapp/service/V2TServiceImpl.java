package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.dao.V2TAttachmentDao;
import kr.ac.hanrw.webapp.dao.V2TDao;
import kr.ac.hanrw.webapp.dto.V2T;
import kr.ac.hanrw.webapp.dto.V2TAttachment;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 24
 * Time: 오후 2:00
 * To change this template use File | Settings | File Templates.
 */
public class V2TServiceImpl implements V2TService {
    @Autowired
    V2TDao v2tDao;
    @Autowired
    V2TAttachmentDao v2tAttachmentDao;

    @Override
    public List<V2T> getV2TList(SearchCondition searchCondition) {
        List<V2T> p2tList = v2tDao.getV2TList(searchCondition);
        return p2tList;
    }

    @Override
    public int getV2TTotalCnt(SearchCondition searchCondition) {
        return v2tDao.getV2TTotalCnt(searchCondition);
    }

    @Override
    public V2T getV2TBy(int reqId) {
        V2T p2t = v2tDao.getV2TBy(reqId);
        return p2t;
    }

    @Override
    public void updateV2T(V2T p2t) {
        v2tDao.updateV2T(p2t);
    }

    @Override
    public void processV2T(V2T p2t)
    {
        v2tDao.processV2T(p2t);
    }
    @Override
    public void requestV2T(V2T p2t) {
        v2tDao.requestV2T(p2t);
    }

    @Override
    public List<V2TAttachment> getV2TAudioListBy(int reqId) {
        List<V2TAttachment> audioList = v2tAttachmentDao.getReqAudioListBy(reqId);
        return audioList;
    }

    @Override
    public byte[] getV2TAudioBy(int audioId) {
        V2TAttachment attachment = v2tAttachmentDao.getAudioBy(audioId);
        return attachment.getAudioContents();
    }

    @Override
    public int uploadAudio(V2TAttachment audio) {
        v2tAttachmentDao.insertAudio(audio);
        return audio.getAudioId();
    }

}
