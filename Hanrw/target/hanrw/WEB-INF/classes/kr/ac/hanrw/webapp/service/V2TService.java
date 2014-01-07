package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.dto.V2T;
import kr.ac.hanrw.webapp.dto.V2TAttachment;
import kr.ac.hanrw.webapp.dto.SearchCondition;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 24
 * Time: 오후 1:02
 * To change this template use File | Settings | File Templates.
 */
public interface V2TService {

    public List<V2T> getV2TList(SearchCondition searchCondition);
    public int getV2TTotalCnt(SearchCondition searchCondition);
    public V2T getV2TBy(int reqId);
    public void processV2T(V2T V2T);
    public void updateV2T(V2T V2T);
    public void requestV2T(V2T V2T);
    public List<V2TAttachment> getV2TAudioListBy(int reqId);
    public byte[] getV2TAudioBy(int audioId);
    public int uploadAudio(V2TAttachment audio);

}
