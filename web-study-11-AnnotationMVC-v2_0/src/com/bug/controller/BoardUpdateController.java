package com.bug.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.dto.BoardVO;
import com.bug.service.BoardCheckPassService;
import com.bug.service.BoardUpdateService;


@Controller
public class BoardUpdateController {
	
	@Autowired
	private BoardCheckPassService boardCheckPassService;
	
	@Autowired
	private BoardUpdateService boardUpdateService;
	// 게시판 수정 start
		@RequestMapping(value = "/boardUpdateForm.do", method = RequestMethod.GET)
		public String updateForm(String num, String pn, Model model) {
			String view = "boardUpdate";

			System.out.println("BoardController updateForm() >>>>>>>>>>");
			BoardVO bVo = boardCheckPassService.selectOneBoardByNum(num); // 등록된 게시글(BoardVO)을 불러옴
			System.out.println(bVo);
			System.out.println("<<<<<<<<<< BoardController updateForm()");
			
			model.addAttribute("board", bVo); // model에 뷰에서 보여줄 값 담기
			model.addAttribute("pn", pn);
			return view;
		}
		
		@RequestMapping(value = "/boardUpdate.do", method = RequestMethod.POST)
		public String update(@Valid @ModelAttribute("board") BoardVO bVo, Errors errors, String pn, Model model) {

			System.out.println("BoardController update() >>>>>>>>>>");
			System.out.println("error : " + errors.getAllErrors()); // 오류 정보 확인(디버그 코드)
			System.out.println(bVo);
			System.out.println("<<<<<<<<<< BoardController update()");
			
			if (errors.hasErrors()) {
				System.out.println("오류발생 boardUpdate로 돌아감");
				return "boardUpdate";
			}
			
			boardUpdateService.updateBoard(bVo); // 글수정
			
			return "redirect:boardView.do?num=" + bVo.getNum() + "&requestPageNum=" + pn; // 게시글 상세보기 페이지로 이동
		}
		// 게시판 수정 end

}
