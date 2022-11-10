package pnu.board.dao;

import java.util.List;

import pnu.board.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> selectBoardList();
	public BoardVO selectBoard(int boardId);
	public int insertBoard(BoardVO board);
}
