package com.bug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.dto.BoardVO;
import com.bug.service.BoardViewService;

@Controller
public class BoardViewController {
	
	@Autowired
	private BoardViewService service;

	// 게시판 상세보기 start
	@RequestMapping(value = "/boardView.do", method = RequestMethod.GET)
	public String view(String num, String requestPageNum, Model model) {
		String view = "boardView";

		System.out.println("BoardViewController view() >>>>>>>>>>");
		BoardVO bVo = service.selectOneBoardByNum(num); // 글번호로 게시글(BoardVO) 불러오기
		System.out.println(bVo);
		System.out.println("<<<<<<<<<< BoardViewController view()");
		
		model.addAttribute("board", bVo); // model에 뷰에서 보여줄 값 담기
		model.addAttribute("pn", requestPageNum);
		
		return view;
	}
	// 게시판 상세보기 end
	
}
