package com.bug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.dto.BoardVOListModel;
import com.bug.service.BoardListService;


/**
 * BoardListController : 게시판 리스트
 * @author 2-18
 * @version 2.0
 * @since 2017-11-16
 */

@Controller
public class BoardListController {

	@Autowired
	private BoardListService boardListService;
	
	// 게시판 리스트 start
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String list(String pn, Model model) { // String pn v2.1에서 추가
		// 최종모델 : BoardVOListModel(listModel), 페이지시작/끝번호(beginPage/endPage)
		// 뷰 : boardList
		String view = "boardList";
		
		System.out.println("BoardController list() >>>>>>>>>>");
		
		BoardVOListModel boardVOListView = boardListService.list(pn);
		
		System.out.println(boardVOListView);
		System.out.println("<<<<<<<<<< BoardController list()");
		
		model.addAttribute("boardVOListView", boardVOListView); // model에 뷰에서 보여줄 값 담기
		
		return view;
	}
	// 게시판 리스트 end
	
}
