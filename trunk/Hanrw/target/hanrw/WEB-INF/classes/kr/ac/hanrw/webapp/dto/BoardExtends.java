package kr.ac.hanrw.webapp.dto;

/**
 * Created with IntelliJ IDEA.
 * User: standard
 * Date: 13. 9. 26
 * Time: 오후 12:43
 * To change this template use File | Settings | File Templates.
 */
public class BoardExtends extends Board {
	private BoardSearchCondition boardSearchCondition;

	public BoardSearchCondition getBoardSearchCondition() {
		return boardSearchCondition;
	}

	public void setBoardSearchCondition(BoardSearchCondition boardSearchCondition) {
		this.boardSearchCondition = boardSearchCondition;
	}
}
