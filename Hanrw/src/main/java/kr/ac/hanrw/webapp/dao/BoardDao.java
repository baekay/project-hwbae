package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.Attachment;
import kr.ac.hanrw.webapp.dto.Board;
import kr.ac.hanrw.webapp.dto.BoardSearchCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 14.
 * Time: 오후 11:39
 */
public interface BoardDao {
    public void insertBoard(Board board);

    public void insertAttachments(@Param("articleId") int articleId,@Param("attachmentList") List<Attachment> attachmentList);

    public Board getBoardById(int articleId);

    public List<Board> getBoardListByCondition(@Param("boardId") String boardId, @Param("searchCondition") BoardSearchCondition searchCondition);

    public int getBoardTotalCntByCondition(@Param("boardId") String boardId, @Param("searchCondition") BoardSearchCondition searchCondition);

    public List<Board> getReplyListByCondition(@Param("parentArticleId") int parentArticleId,@Param("searchCondition") BoardSearchCondition searchCondition );

    public void updateBoard(Board board);

    public int deleteById(int articleId);

    public int deleteByList(List<Integer> articleIds);

    public int getReplyCntById(int articleId);

    public Attachment getAttachementFile(int fileId);
}
