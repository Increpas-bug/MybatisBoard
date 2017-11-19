package com.bug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.service.BoardViewService;

@Controller
public class BoardWriteReplyController {

	@Autowired
	private BoardViewService service;
	
	// 답글 등록 start
	@RequestMapping(value = "boardWriteReplyForm.do", method = RequestMethod.GET)
	public String writeReplyForm() {
		return "boardWriteReply";
	}

	@RequestMapping(value = "boardWriteReply.do", method = RequestMethod.POST)
	public String writeReply() {
		return "redirect:boardList.do";
	}
	// 답글 등록 end
}
