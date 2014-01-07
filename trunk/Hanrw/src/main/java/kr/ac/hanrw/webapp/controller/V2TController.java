package kr.ac.hanrw.webapp.controller;

import kr.ac.hanrw.webapp.dto.HanrwError;
import kr.ac.hanrw.webapp.dto.V2T;
import kr.ac.hanrw.webapp.dto.V2TAttachment;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import kr.ac.hanrw.webapp.service.V2TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
public class V2TController extends AbstractHanrwController {

    @Autowired
    V2TService v2tService;
    // API
    @RequestMapping(value="/app/v2t/req", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> reqJob(@RequestBody V2T v2t, HttpServletResponse response) {
        Map<String, Integer> resultObj = new HashMap<String, Integer>();

        String loginId = super.getLoginId();
        v2t.setReqUserId(loginId);

        v2tService.requestV2T(v2t);
        resultObj.put("reqId", Integer.valueOf(v2t.getReqId()));

        return resultObj;
    }

    @RequestMapping(value="/app/v2t/process", method=RequestMethod.POST)
    public void processV2T(@RequestBody V2T v2t, HttpServletResponse response) throws IOException {
        try {
            v2t.setPrcUserId(super.getLoginId());
            v2tService.processV2T(v2t);
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

    @RequestMapping(value="/app/v2t/update", method=RequestMethod.POST)
    public void updateV2T(@RequestBody V2T v2t, HttpServletResponse response) throws IOException {
        try {
            v2t.setPrcUserId(super.getLoginId());
            v2tService.updateV2T(v2t);
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

    @RequestMapping(value="/app/v2t/upload", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Number> uploadAudio(V2TAttachment audio, HttpServletResponse response) {
        Map<String, Number> returnObj = new HashMap<String, Number>();
        audio.setAudioType("mp4");
        v2tService.uploadAudio(audio);
        returnObj.put("audioId", audio.getAudioId());
        return returnObj;
    }

    @RequestMapping(value="/app/v2t/list/total", method=RequestMethod.GET)
    @ResponseBody
    public int getV2TTotalCnt(HttpServletRequest request, HttpServletResponse response) {
        String qColumn = request.getParameter("column");
        String qQstr = request.getParameter("qstr");

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setColumn(qColumn);
        searchCondition.setQueryString(qQstr);

        return v2tService.getV2TTotalCnt(searchCondition);
    }

    @RequestMapping(value="/app/v2t/list", method=RequestMethod.GET)
    @ResponseBody
    public List<V2T> getV2TList(HttpServletRequest request, HttpServletResponse response) {
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
        List<V2T> v2tList = v2tService.getV2TList(searchCondition);
        return v2tList;
    }

    @RequestMapping(value="/app/v2t/{reqId:.+}", method=RequestMethod.GET)
    @ResponseBody
    public V2T getV2TBy(@PathVariable int reqId, HttpServletResponse response) {
        V2T v2t = v2tService.getV2TBy(reqId);
        return v2t;
    }


    @RequestMapping(value="/app/v2t/audio/{audioId:.+}", method=RequestMethod.GET)
    public  void getAudio(@PathVariable int audioId, HttpServletResponse res) throws IOException {
        byte[] audioContents = v2tService.getV2TAudioBy(audioId);
        res.setContentType("audio/jpeg");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setContentLength((int)audioContents.length);
        res.getOutputStream().write(audioContents);
    }

    @RequestMapping(value="/app/v2t/audio/download/{audioId:.+}", method=RequestMethod.GET)
    public void downloadImage(@PathVariable int audioId, HttpServletResponse res) throws IOException {
        byte[] imageContents = v2tService.getV2TAudioBy(audioId);

        StringBuilder fileName = new StringBuilder();

        fileName.append("hanrw.ac.kr-audio-").append("-").append(audioId).append(".mp4");

        res.setContentType("video/mp4");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Content-Disposition", "attachment;filename="+ fileName.toString() +";");
        res.setContentLength((int) imageContents.length);
        res.getOutputStream().write(imageContents);
    }

    @RequestMapping(value="/app/v2t/audio/list/{reqId:.+}", method=RequestMethod.GET)
    @ResponseBody
    public int[] getAudioIds(@PathVariable int reqId, HttpServletResponse res) {
        List<V2TAttachment> audioList = v2tService.getV2TAudioListBy(reqId);
        int[] idList = new int[audioList.size()];

        for (int idx = 0, len = idList.length; idx < len; idx++) {
            idList[idx] = audioList.get(idx).getAudioId();
        }

        return idList;
    }


    // VIEW
    @RequestMapping(value="/view/v2t/list", method=RequestMethod.GET)
    public String login(HttpServletResponse response) {
        return "v2t/list";
    }

    @RequestMapping(value="/view/v2t/write", method=RequestMethod.GET)
    public String write(HttpServletResponse response){
        return "v2t/write";
    }

}
