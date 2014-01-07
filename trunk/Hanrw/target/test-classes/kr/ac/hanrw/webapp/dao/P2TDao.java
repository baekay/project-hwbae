package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.P2T;
import kr.ac.hanrw.webapp.dto.SearchCondition;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 23
 * Time: 오후 7:34
 * To change this template use File | Settings | File Templates.
 */
public interface P2TDao {

    /**
     * 작업요청
     * @param p2t
     * @return
     */
    public int requestP2T(P2T p2t);

    /**
     * 작업진행
     * @param p2t
     */
    public void processP2T(P2T p2t);

    /**
     * 총 요청갯수
     * @param condition
     * @return
     */
    public int getP2TTotalCnt(SearchCondition condition);

    /**
     * 총 요청 수
     * @param condition
     * @return
     */
    public List<P2T> getP2TList(SearchCondition condition);

    /**
     * 작업요청 조회
     * @param reqId
     * @return
     */
    public P2T getP2TBy(int reqId);

    /**
     * 작업요청 수정
     * @param p2t
     */
    public void updateP2T(P2T p2t);

    /**
     * 작업요청 삭제
     * @param reqId
     */
    public void deleteP2T(int reqId);

}
