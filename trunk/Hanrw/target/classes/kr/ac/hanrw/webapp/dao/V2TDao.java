package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.V2T;
import kr.ac.hanrw.webapp.dto.SearchCondition;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 23
 * Time: 오후 7:34
 * To change this template use File | Settings | File Templates.
 */
public interface V2TDao {

    /**
     * 작업요청
     * @param v2t
     * @return
     */
    public int requestV2T(V2T v2t);

    /**
     * 작업진행
     * @param v2t
     */
    public void processV2T(V2T v2t);


    /**
     * 총 요청 수
     * @param condition
     * @return
     */
    public int getV2TTotalCnt(SearchCondition condition);
    /**
     * 작업요청 목록
     * @param condition
     * @return
     */
    public List<V2T> getV2TList(SearchCondition condition);

    /**
     * 작업요청 조회
     * @param reqId
     * @return
     */
    public V2T getV2TBy(int reqId);

    /**
     * 작업요청 수정
     * @param v2t
     */
    public void updateV2T(V2T v2t);

    /**
     * 작업요청 삭제
     * @param reqId
     */
    public void deleteV2T(int reqId);

}
