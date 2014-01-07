package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.dto.Attachment;
import kr.ac.hanrw.webapp.dto.Board;
import kr.ac.hanrw.webapp.dto.BoardSearchCondition;
import kr.ac.hanrw.webapp.dto.SearchCondition;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 17.
 * Time: 오후 11:03
 */
public interface BoardService {

    public void registBoard(String boardId,Board board);

    public Board getBoardDetailById(int articleId);

    public List<Board> getBoardListByCondition(String boardId, BoardSearchCondition condition);

    public void updateBoard(Board board);

    public void deleteBoardById(int articleId);

    public void deleteBoardByList(List<Integer> articleIds);

    public int getTotalCountByCondition(String boardId, BoardSearchCondition condition);

    public Attachment getAttachementFile(int fileId);


}
