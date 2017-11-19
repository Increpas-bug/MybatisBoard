package com.bug.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
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
	public String writeReply(HttpServletRequest request, @Valid @ModelAttribute("board") BoardVO boardVO) {
		MultipartFile mfile = boardVO.getMfile();
		boardVO.setUploadpath(mfile.getOriginalFilename());
		service.insertReplyBoard(boardVO);
		System.out.println("mfile = " + mfile); // 파일미선택도 객체 생성
		
		if (mfile != null && mfile.getSize() != 0) {
			String fileName = mfile.getOriginalFilename();
			String upath = request.getServletContext().getRealPath("/upload");
			System.out.println("upath = " + upath);
			
			File file = new File(upath + "/" + fileName); // File 객체 생성
			try {
				mfile.transferTo(file);
			} catch (Exception e) {
				return "boardWriteReply";
			} // 파일로 복사
			System.out.println(fileName + " upath에 저장");
			System.out.println("파일크기 = " + mfile.getSize() + "바이트");
		}
		
		return "redirect:boardList.do?pn=1";
	}
	// 답글 등록 end
}
