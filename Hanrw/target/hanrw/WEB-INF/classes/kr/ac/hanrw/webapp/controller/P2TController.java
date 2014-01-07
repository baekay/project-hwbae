package kr.ac.hanrw.webapp.controller;

import kr.ac.hanrw.webapp.dto.HanrwError;
import kr.ac.hanrw.webapp.dto.P2T;
import kr.ac.hanrw.webapp.dto.P2TAttachment;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import kr.ac.hanrw.webapp.service.P2TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 8. 30
 * Time: 오후 2:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class P2TController extends AbstractHanrwController {

    @Autowired
    P2TService p2tService;

    // API
    @RequestMapping(value="/app/p2t/req", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> reqJob(@RequestBody P2T p2t, HttpServletResponse response) {
        Map<String, Integer> resultObj = new HashMap<String, Integer>();

        String loginId = super.getLoginId();
        p2t.setReqUserId(loginId);

        p2tService.requestP2T(p2t);
        resultObj.put("reqId", Integer.valueOf(p2t.getReqId()));

        return resultObj;
    }

    @RequestMapping(value="/app/p2t/process", method=RequestMethod.POST)
    public void processP2T(@RequestBody P2T p2t, HttpServletResponse response) throws IOException {
        try {
            p2t.setPrcUserId(super.getLoginId());
            p2tService.processP2T(p2t);
            response.setStatus(HttpStatus.OK.value());

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.NOT_FOUND.value());
            HanrwError error = new HanrwError();
            error.setErrorCode(HanrwError.ERROR_WRONG_PARAM);
            error.setErrorMessage("정보를 수정하지 못하였습니다.");
            super.ErrorHandler(error, response, HttpStatus.BAD_REQUEST.value());
        }
    }

    @RequestMapping(value="/app/p2t/update", method=RequestMethod.POST)
    public void updateP2T(@RequestBody P2T p2t, HttpServletResponse response) throws IOException {
        try {
            p2t.setPrcUserId(super.getLoginId());
            p2tService.updateP2T(p2t);
            response.setStatus(HttpStatus.OK.value());

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.NOT_FOUND.value());
            HanrwError error = new HanrwError();
            error.setErrorCode(HanrwError.ERROR_WRONG_PARAM);
            error.setErrorMessage("정보를 수정하지 못하였습니다.");
            super.ErrorHandler(error, response, HttpStatus.BAD_REQUEST.value());
        }

    }

    @RequestMapping(value="/app/p2t/upload", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Number> uploadImage(P2TAttachment image, HttpServletResponse response) {
        Map<String, Number> returnObj = new HashMap<String, Number>();
        if(image.getMakeThumbnail() == 1) {
            String imageType;
            String mimeType = image.getImageType();
            if (mimeType == "image/jpeg") imageType = "jpg";
            else if (mimeType == "image/jpg") imageType = "jpg";
            else if (mimeType == "image/png") imageType = "png";
            else if (mimeType == "image/gif") imageType = "gif";
            else imageType = "jpg";
            image.setThumbnailContents(p2tService.makeThumb(image.getImageContents(), imageType, 160, 160));
        }
        p2tService.uploadImage(image);
        returnObj.put("imageId", image.getImageId());
        return returnObj;
    }

    @RequestMapping(value="/app/p2t/list/total", method=RequestMethod.GET)
    @ResponseBody
    public int getP2TTotalCnt(HttpServletRequest request, HttpServletResponse response) {
        String qColumn = request.getParameter("column");
        String qQstr = request.getParameter("qstr");

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setColumn(qColumn);
        searchCondition.setQueryString(qQstr);

        return p2tService.getP2TTotalCnt(searchCondition);
    }

    @RequestMapping(value="/app/p2t/list", method=RequestMethod.GET)
    @ResponseBody
    public List<P2T> getP2TList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String qPage = request.getParameter("page");
        String qPageSize = request.getParameter("pageSize");
        String qColumn = request.getParameter("column");
        String qQstr = request.getParameter("qstr");
        int page = (qPage == null) ? 1 : Integer.parseInt(qPage);
        int pageSize = (qPageSize == null) ? 10 : Integer.parseInt(qPageSize);

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setColumn(qColumn);
        searchCondition.setQueryString(qQstr);
        searchCondition.setLimitStart((page - 1) * pageSize);
        searchCondition.setLimitEnd(pageSize);
        List<P2T> p2tList = p2tService.getP2TList(searchCondition);
        return p2tList;
    }

    @RequestMapping(value="/app/p2t/{reqId:.+}", method=RequestMethod.GET)
    @ResponseBody
    public P2T getP2TBy(@PathVariable int reqId, HttpServletResponse response) {
        P2T p2t = p2tService.getP2TBy(reqId);
        return p2t;
    }


    @RequestMapping(value="/app/p2t/image/{imageId:.+}", method=RequestMethod.GET)
    public  void getImage(@PathVariable int imageId, HttpServletResponse res) throws IOException {
        byte[] imageContents = p2tService.getP2TImageBy(imageId);
        res.setContentType("image/jpeg");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setContentLength((int)imageContents.length);
        res.getOutputStream().write(imageContents);
    }

    @RequestMapping(value="/app/p2t/image/download/{imageId:.+}", method=RequestMethod.GET)
    public void downloadImage(@PathVariable int imageId, HttpServletResponse res) throws IOException {
        byte[] imageContents = p2tService.getP2TImageBy(imageId);

        StringBuilder fileName = new StringBuilder();

        fileName.append("hanrw.ac.kr-image-").append("-").append(imageId).append(".jpg");

        res.setContentType("image/jpeg");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Content-Disposition", "attachment;filename="+ fileName.toString() +";");
        res.setContentLength((int) imageContents.length);
        res.getOutputStream().write(imageContents);
    }

    @RequestMapping(value="/app/p2t/image/list/{reqId:.+}", method=RequestMethod.GET)
    @ResponseBody
    public int[] getImageIds(@PathVariable int reqId, HttpServletResponse res) {
        List<P2TAttachment> imageList = p2tService.getP2TImageListBy(reqId);
        int[] idList = new int[imageList.size()];

        for (int idx = 0, len = idList.length; idx < len; idx++) {
            idList[idx] = imageList.get(idx).getImageId();
        }

        return idList;
    }

    // VIEW
    @RequestMapping(value="/view/p2t/list", method=RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response) {
        return "p2t/list";
    }

    /*
    @RequestMapping(value="/view/p2t/view", method=RequestMethod.GET)
    public String view(HttpServletRequest request, HttpServletResponse response){
        return "p2t/view";
    }
    */

    @RequestMapping(value="/view/p2t/write", method=RequestMethod.GET)
    public String write(HttpServletRequest request, HttpServletResponse response){
        return "p2t/write";
    }

}
