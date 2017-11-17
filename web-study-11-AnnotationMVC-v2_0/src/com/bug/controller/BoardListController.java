package com.bug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.dto.BoardVO;
import com.bug.service.BoardService;

/**
 * BoardListController : 게시판 리스트
 * @author 2-18
 * @version 2.0
 * @since 2017-11-16
 */

@Controller
public class BoardListController {

	@Autowired
	private BoardService boardService;
	
	// 게시판 리스트 start
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String list(Model model) { // String pn v2.1에서 추가
		// 최종모델 : BoardVOListModel(listModel), 페이지시작/끝번호(beginPage/endPage)
		// 뷰 : boardList
		String view = "boardList";
		
		System.out.println("BoardController list() >>>>>>>>>>");
		// 현재는 List로 받았지만, v2.1에서 BoardVOListModel로 변경
		// 메소드명은 미리 변경 : selectAllBoards() -> getBoardVOList(pn)
		List<BoardVO> list = boardService.getBoardVOList(); // 모든 게시판글(BoardVO)을 리스트로 불러옴
		System.out.println(list);
		System.out.println("<<<<<<<<<< BoardController list()");
		
		model.addAttribute("boardList", list); // model에 뷰에서 보여줄 값 담기
		
		return view;
	}
	// 게시판 리스트 end
	
}
