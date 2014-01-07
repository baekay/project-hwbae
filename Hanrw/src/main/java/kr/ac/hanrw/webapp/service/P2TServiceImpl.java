package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.dao.P2TAttachmentDao;
import kr.ac.hanrw.webapp.dao.P2TDao;
import kr.ac.hanrw.webapp.dto.P2T;
import kr.ac.hanrw.webapp.dto.P2TAttachment;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 24
 * Time: 오후 2:00
 * To change this template use File | Settings | File Templates.
 */
public class P2TServiceImpl implements P2TService {
    @Autowired
    P2TDao p2tDao;
    @Autowired
    P2TAttachmentDao p2tAttachmentDao;

    @Override
    public int getP2TTotalCnt(SearchCondition searchCondition) {
        return p2tDao.getP2TTotalCnt(searchCondition);
    }

    @Override
    public List<P2T> getP2TList(SearchCondition searchCondition) {
        List<P2T> p2tList = p2tDao.getP2TList(searchCondition);
        return p2tList;
    }

    @Override
    public P2T getP2TBy(int reqId) {
        P2T p2t = p2tDao.getP2TBy(reqId);
        return p2t;
    }

    @Override
    public void updateP2T(P2T p2t) {
        p2tDao.updateP2T(p2t);
    }

    @Override
    public void processP2T(P2T p2t)
    {
        p2tDao.processP2T(p2t);
    }
    @Override
    public void requestP2T(P2T p2t) {
        p2tDao.requestP2T(p2t);
    }

    @Override
    public List<P2TAttachment> getP2TImageListBy(int reqId) {
        List<P2TAttachment> imageList = p2tAttachmentDao.getReqImageListBy(reqId);
        return imageList;
    }

    @Override
    public byte[] getP2TThumbBy(int imageId) {
        P2TAttachment attachment = p2tAttachmentDao.getThumbnailBy(imageId);
        return attachment.getThumbnailContents();
    }

    @Override
    public byte[] getP2TImageBy(int imageId) {
        P2TAttachment attachment = p2tAttachmentDao.getImageBy(imageId);
        return attachment.getImageContents();
    }

    @Override
    public int uploadImage(P2TAttachment image) {
        p2tAttachmentDao.insertImage(image);
        return image.getImageId();
    }

    @Override
    public byte[] makeThumb(byte[] image, String type, int width, int height) {
        InputStream is = new ByteArrayInputStream(image);
        byte[] imageBytes = null;
        try {
            BufferedImage orgImg = ImageIO.read(is);
            BufferedImage scaledImage = Scalr.resize(orgImg, Method.QUALITY, width, height, Scalr.OP_ANTIALIAS);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(scaledImage, type, baos);
            imageBytes = baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageBytes;
    }
}
