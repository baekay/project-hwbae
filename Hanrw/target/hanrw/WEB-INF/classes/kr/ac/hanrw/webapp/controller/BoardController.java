package kr.ac.hanrw.webapp.controller;

import kr.ac.hanrw.webapp.dto.*;
import kr.ac.hanrw.webapp.service.BoardService;
import kr.ac.hanrw.webapp.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 8. 30
 * Time: 오후 2:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BoardController extends AbstractHanrwController {

    @Qualifier("boardService")
    @Autowired
    BoardService boardService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/view/board/{boardId}/list", method = RequestMethod.GET)
    public ModelAndView getListView(@PathVariable("boardId") String boardId
            , @ModelAttribute("condition") BoardSearchCondition condition
            , Model model) {

        model.addAttribute("boardId", boardId);
        User loginUser = getLoginUser();

        model.addAttribute("loginUser", loginUser);
        int totalCount = boardService.getTotalCountByCondition(boardId, condition);
        model.addAttribute("totalCount", totalCount);

        List<Board> boardList = boardService.getBoardListByCondition(boardId, condition);
        model.addAttribute("boardList", boardList);


        return new ModelAndView("board/list");
    }

    @RequestMapping(value = "/view/board/{boardId}/write", method = RequestMethod.GET)
    public ModelAndView writeBoard(@PathVariable("boardId") String boardId
                                   ,@ModelAttribute("board") Board board
                                   ,@ModelAttribute("condition") BoardSearchCondition condition
                                   ,@ModelAttribute("boardAttach") BoardAttachForm boardAttachForm

                                   ,Model model) {

        model.addAttribute("boardId", boardId);
        String loginUserId = getLoginUser().getUserId();

        User loginUser = userService.getUserBy(loginUserId);

        model.addAttribute("loginUser", loginUser);

        return new ModelAndView("board/write");
    }

	/*
	게시물 등록 버튼 클릭할 때 호출되는 컨트롤러 메소드
	 */
	@RequestMapping(value = "/view/board/{boardId}/write", method = RequestMethod.POST)
	public ModelAndView writeBoardPost(@PathVariable("boardId") String boardId
			, @ModelAttribute("board") Board board
			, @ModelAttribute("condition") BoardSearchCondition condition
            , @RequestParam("files") List<MultipartFile> files
			, Model model) throws IOException {

        if ( files != null && files.size() >0) {

            //board.setAttachmentList(new ArrayList<Attachment>());
            List<Attachment> attachments = new ArrayList<Attachment>();

            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();

                Attachment attachment = new Attachment();
//                attachment.setArticleId(articleId);
                attachment.setFileData(multipartFile.getBytes());
                attachment.setFileNameSrc(fileName);
                attachment.setFilePath("db");
                attachment.setFileNameSaved(fileName);
                attachments.add(attachment);
                //fileNames.add(fileName);
            }
            board.setAttachmentList(attachments);
        }
        boardService.registBoard(boardId, board);
        model.addAttribute("boardId", boardId);
		String loginUserId = getLoginUser().getUserId();

        board = boardService.getBoardDetailById(board.getArticleId());

        model.addAttribute("board", board);
        User loginUser = userService.getUserBy(loginUserId);
		model.addAttribute("loginUser", loginUser);

		return new ModelAndView("board/view");
	}

    @RequestMapping(value = "/view/board/update/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView viewUpdate(@PathVariable int articleId
		                        , @ModelAttribute("condition") BoardSearchCondition condition
		                        , Model model) {
        Board board = boardService.getBoardDetailById(articleId);

        model.addAttribute("boardId", board.getMenuId());
        String loginUserId = getLoginUser().getUserId();

        User loginUser = userService.getUserBy(loginUserId);

        model.addAttribute("loginUser", loginUser);
        model.addAttribute("board", board);
        model.addAttribute("viewMode", "updateView");

        return new ModelAndView("board/write");
    }

    @RequestMapping(value = "/view/board/{boardId}/reply/{parentArticleId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView viewReply(@PathVariable String boardId
            , @ModelAttribute("condition") BoardSearchCondition condition
            , @ModelAttribute("board") Board board
            , @PathVariable int parentArticleId, Model model) {

        String loginUserId = getLoginUser().getUserId();

        User loginUser = userService.getUserBy(loginUserId);

        model.addAttribute("loginUser", loginUser);
        model.addAttribute("viewMode", "replyView");
        model.addAttribute("boardId", boardId);
        model.addAttribute("parentArticleId",parentArticleId);

        return new ModelAndView("board/write");
    }

    @RequestMapping(value="/view/board/attachment/{fileId}", method=RequestMethod.GET)
    public  void getAttachFile(@PathVariable int fileId, HttpServletResponse res) throws IOException {
        Attachment attachment = boardService.getAttachementFile(fileId);;
        byte[] attachmentFile = attachment.getFileData();

        String fileName = URLEncoder.encode(attachment.getFileNameSrc(), "UTF-8");

        InputStream is = new ByteArrayInputStream(attachmentFile);

        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/download");
        res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        IOUtils.copy(is, res.getOutputStream());
        res.flushBuffer();
//        res.setContentType("application/octet-stream");
//        res.setHeader("Pragma", "no-cache");
//        res.setHeader("Cache-Control", "no-cache");
//        res.setContentLength((int)attachmentFile.length);
//        res.getOutputStream().write(attachmentFile);
    }

    @RequestMapping(value = "/view/board/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getView(@PathVariable int articleId
            , @ModelAttribute("condition") BoardSearchCondition condition
            , Model model) {
        Board board = boardService.getBoardDetailById(articleId);

        model.addAttribute("boardId", board.getMenuId());
        String loginUserId = getLoginUser().getUserId();

        User loginUser = userService.getUserBy(loginUserId);

        model.addAttribute("loginUser", loginUser);
        model.addAttribute("board", board);

        return new ModelAndView("board/view");
    }



    @RequestMapping(value = "/app/board/{boardId}/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Board> getBoardListByCondition(@PathVariable String boardId,
                                               @ModelAttribute("condition") BoardSearchCondition condition,
                                               HttpServletResponse response) {

        /*
        SearchCondition cond = new SearchCondition();

        if (StringUtils.isNotEmpty(column)) cond.setColumn(StringUtils.lowerCase(column));
        if (StringUtils.isNotEmpty(qStr)) cond.setQueryString(StringUtils.lowerCase(qStr));
        if (limitStart != null && limitStart > 0) cond.setLimitStart(limitStart);
        if (limitEnd != null && limitEnd > 0) cond.setLimitEnd(limitEnd);
        */

        List<Board> boardList = boardService.getBoardListByCondition(boardId, condition);

        return boardList;

    }

    @RequestMapping(value = "/app/board/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public Board view(@PathVariable int articleId, HttpServletResponse response) {

        Board board = boardService.getBoardDetailById(articleId);
        return board;
    }

    @RequestMapping(value = "/app/board/{boardId}/regist", method = RequestMethod.POST)
    @ResponseBody
    public Board write(@PathVariable String boardId
            , @ModelAttribute("condition") BoardSearchCondition condition
            , @RequestBody Board board, HttpServletResponse response) {
        User loginUser = getLoginUser();
        String loginId = loginUser.getUserId();

        board.setUser(loginUser);
        board.setUserId(loginId);

        boardService.registBoard(boardId, board);

        return board;
    }

    @RequestMapping(value = "/app/board/update", method = RequestMethod.POST)
    @ResponseBody
    public Board update(@RequestBody Board board, HttpServletResponse response) {

        User loginUser = getLoginUser();
        String loginId = loginUser.getUserId();
        Board tBoard = boardService.getBoardDetailById(board.getArticleId());

        if (!loginUser.getRoleId().equals("ADMIN") && !loginId.equals(tBoard.getUserId())) {

            try {
                ErrorHandler(new HanrwError(403, "수정할 권한이 없습니다."), response, HttpStatus.UNAUTHORIZED.value());
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        boardService.updateBoard(board);

        return board;
    }

    @RequestMapping(value = "/app/board/delete",method = RequestMethod.POST)
    public void deleteByList(@RequestBody List<Integer> articleIds,HttpServletResponse response) throws IOException
    {
        try {
            boardService.deleteBoardByList(articleIds);
        } catch (DataIntegrityViolationException e) {
            ErrorHandler(new HanrwError(HttpStatus.BAD_REQUEST.value(), e.getMessage())
                    , response
                    , HttpStatus.BAD_REQUEST.value());
            return;
        }
    }

    @RequestMapping(value = "/app/board/delete/{articleId}", method = RequestMethod.POST)
    public void delete(@PathVariable int articleId, HttpServletResponse response) throws IOException {

        User loginUser = getLoginUser();

        if (!loginUser.getRoleId().equals("ADMIN")) {
            String loginId = loginUser.getUserId();
            Board tBoard = boardService.getBoardDetailById(articleId);
            if (!loginId.equals(tBoard.getUserId())) {
                ErrorHandler(new HanrwError(403, "수정할 권한이 없습니다."), response, HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }

        try {
            boardService.deleteBoardById(articleId);
        } catch (DataIntegrityViolationException e) {
            ErrorHandler(new HanrwError(HttpStatus.BAD_REQUEST.value(), e.getMessage())
                    , response
                    , HttpStatus.BAD_REQUEST.value());
            return;
        }

    }


}
