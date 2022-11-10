package pnu.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pnu.board.service.BoardService;
import pnu.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/boardListPage.do")
	public ModelAndView boardListPage() {
		ModelAndView mav = new ModelAndView("board/boardList.jsp");
		
		List<BoardVO> boardList = boardService.selectBoardList();
		mav.addObject("boardList", boardList);
		
		return mav;
	}
	
	@RequestMapping(value = "/boardInsertPage.do")
	public String boardInsertPage() {
		return "board/boardInsert.jsp";
	}
	
	@RequestMapping(value = "/boardInsert.do", method = RequestMethod.POST)
	public String boardInsert(@ModelAttribute BoardVO board) {
		
		boardService.insertBoard(board);
		
		return "redirect:/boardListPage.do";
	}
	
	@RequestMapping(value = "/boardInfoPage/{boardId}.do")
	public ModelAndView boardInfoPage(@PathVariable("boardId") int boardId) {
		ModelAndView mav = new ModelAndView("\"board/boardInfo.jsp\"");
		
		BoardVO board = boardService.selectBoard(boardId);
		mav.addObject("board", board);
		
		return mav;
	}
}
