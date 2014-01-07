package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.dao.BoardDao;
import kr.ac.hanrw.webapp.dto.Attachment;
import kr.ac.hanrw.webapp.dto.Board;
import kr.ac.hanrw.webapp.dto.BoardSearchCondition;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 18.
 * Time: 오전 12:01
 */

public class BoardServiceImpl implements BoardService {
    final static int SHOW_ITEM_CNT = 10;

    @Autowired
    private BoardDao boardDao;

    @Override
    public void registBoard(String boardId,Board board) {

        board.setMenuId(boardId);
        boardDao.insertBoard(board);

        if (board.getAttachmentList() != null && board.getAttachmentList().size() > 0) {
            int articleId = board.getArticleId();
            boardDao.insertAttachments(articleId, board.getAttachmentList());
        }
    }

    @Override
    public Board getBoardDetailById(int articleId) {

        return boardDao.getBoardById(articleId);
    }

    private void composeReplyList(Board boardItem,BoardSearchCondition condition) {
        if ( boardItem.getReplyCnt() > 0) {
            List<Board> replies = boardDao.getReplyListByCondition(boardItem.getArticleId(), condition);
            if (replies != null && replies.size() > 0) {
                boardItem.setReplies(new ArrayList<Board>());
            }
            for (int j = 0; j < replies.size(); j++) {
                Board replyItem = replies.get(j);
                boardItem.getReplies().add(replyItem);
                composeReplyList(replyItem,condition);
            }
        }
        return;

    }

    @Override
    public List<Board> getBoardListByCondition(String boardId, BoardSearchCondition condition) {



        if (condition.getCurPage() == null || condition.getCurPage() == 0) {
            condition.setCurPage(1);
        }


        int curPage = condition.getCurPage();
        int limitStart = ( curPage * SHOW_ITEM_CNT ) - SHOW_ITEM_CNT;
        int limitEnd = SHOW_ITEM_CNT;

        /* 웹에서의 요청은 limitStart, limitEnd 가 비어서 오지만, 어플에서는 두 값이 설정되어서 온다. */
        condition.setLimitStart(limitStart);
        condition.setLimitEnd(limitEnd);

        List<Board> boardList = boardDao.getBoardListByCondition(boardId, condition);

        for (int i = 0; i < boardList.size(); i++) {
            Board boardItem = boardList.get(i);
            composeReplyList(boardItem, condition);
        }

        return boardList;
    }

    @Override
    public void updateBoard(Board board) {
        boardDao.updateBoard(board);
    }

    @Override
    public void deleteBoardById(int articleId) {

        int replyCnt = boardDao.getReplyCntById(articleId);
        if (replyCnt > 0) {
            throw new DataIntegrityViolationException("답글이 "+ replyCnt + "개 달려있어 삭제할 수 없습니다.");
        }

        boardDao.deleteById(articleId);
    }

    @Override
    public int getTotalCountByCondition(String boardId, BoardSearchCondition condition) {
        return boardDao.getBoardTotalCntByCondition(boardId, condition);
    }

    @Override
    public void deleteBoardByList(List<Integer> articleIds) {
        boardDao.deleteByList(articleIds);
    }

    @Override
    public Attachment getAttachementFile(int fileId) {
        Attachment attachment = boardDao.getAttachementFile(fileId);
        return attachment;
    }
}
