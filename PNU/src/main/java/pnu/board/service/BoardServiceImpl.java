package pnu.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnu.board.vo.BoardVO;
import pnu.board.dao.BoardDAO;
import pnu.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO; 
	
	@Override
	public int insertBoard(BoardVO board) {
		return boardDAO.insertBoard(board);
	}

	@Override
	public List<BoardVO> selectBoardList() {
		return boardDAO.selectBoardList();
	}

}
