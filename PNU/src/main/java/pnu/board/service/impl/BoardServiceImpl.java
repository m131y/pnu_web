package pnu.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnu.board.dao.BoardDAO;
import pnu.board.service.BoardService;
import pnu.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> selectBoardList() {
		return boardDAO.selectBoardList();
	}
	
	@Override
	public int insertBoard(BoardVO board) {
		return boardDAO.insertBoard(board);
	}

	@Override
	public BoardVO selectBoard(int boardId) {
		return boardDAO.selectBoard(boardId);
	}

}
