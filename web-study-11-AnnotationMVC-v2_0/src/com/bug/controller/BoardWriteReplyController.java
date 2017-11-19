package com.bug.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bug.dto.BoardVO;
import com.bug.service.BoardViewService;

@Controller
public class BoardWriteReplyController {

	@Autowired
	private BoardViewService service;
	
	// 답글 등록 start
	@RequestMapping(value = "boardWriteReplyForm.do", method = RequestMethod.GET)
	public String writeReplyForm(String num, Model model) {
		String view = "boardWriteReply";
		BoardVO vo = service.selectOneBoardByNum(num);
		model.addAttribute("board", vo);
		return view;
	}

	@RequestMapping(value = "boardWriteReply.do", method = RequestMethod.POST)
	public String writeReply(@Valid @ModelAttribute("board") BoardVO boardVO) {
		MultipartFile mfile = boardVO.getMfile();
		boardVO.setUploadpath(mfile.getOriginalFilename());
		service.insertReplyBoard(boardVO);
		
		return "redirect:boardList.do";
	}
	// 답글 등록 end
}
