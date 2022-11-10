package pnu.board.dao;

import java.util.List;

import pnu.board.vo.BoardVO;

public interface BoardDAO {
	public int insertBoard(BoardVO board);
	
	public List<BoardVO> selectBoardList();
	
}
