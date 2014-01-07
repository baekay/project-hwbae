package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.dto.P2T;
import kr.ac.hanrw.webapp.dto.P2TAttachment;
import kr.ac.hanrw.webapp.dto.SearchCondition;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 24
 * Time: 오후 1:02
 * To change this template use File | Settings | File Templates.
 */
public interface P2TService {

    public int getP2TTotalCnt(SearchCondition searchCondition);
    public List<P2T> getP2TList(SearchCondition searchCondition);
    public P2T getP2TBy(int reqId);
    public void processP2T(P2T p2t);
    public void updateP2T(P2T p2t);
    public void requestP2T(P2T p2t);
    public List<P2TAttachment> getP2TImageListBy(int reqId);
    public byte[] getP2TThumbBy(int imageId);
    public byte[] getP2TImageBy(int imageId);
    public byte[] makeThumb(byte[] image, String type, int width, int height);
    public int uploadImage(P2TAttachment image);

}
