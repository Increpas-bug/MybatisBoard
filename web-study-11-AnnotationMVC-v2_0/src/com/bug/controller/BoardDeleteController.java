package com.bug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.service.BoardService;


@Controller
public class BoardDeleteController {

	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/boardDelete.do")
	public String handleRequest(String num, String blevel){
		
		// blevel 검증 구문 
		if(blevel == null){
			blevel = "0";
		}
		service.deleteBoard(num, blevel);
		return "redirect:boardList.do?pn=1";
		
	}
	
	
}
