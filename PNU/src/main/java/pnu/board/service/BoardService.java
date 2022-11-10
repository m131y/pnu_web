package pnu.board.service;

import java.util.List;

import pnu.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> selectBoardList();
	public int insertBoard(BoardVO board);
	public BoardVO selectBoard(int boardId);
}
