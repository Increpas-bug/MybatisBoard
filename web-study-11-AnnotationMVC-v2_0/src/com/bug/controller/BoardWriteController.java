package com.bug.controller;

import java.io.File;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bug.dto.BoardVO;
import com.bug.service.BoardService;

/**
 * BoardWriteController : 글 등록
 * 
 * @author GGongnanE
 * @since 2017-11-19
 */

@Controller
public class BoardWriteController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value="boardWriteForm.do", method = RequestMethod.GET)
	public String form(String requestPageNum, Model model) {
		model.addAttribute("requestPageNum", requestPageNum);
		return "boardWrite";
	}

	@RequestMapping(value="boardWrite.do", method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, @Valid @ModelAttribute("board") BoardVO bVo
			, Errors errors, String requestPageNum, Model model) {
		
		if (errors.hasErrors()) {
			model.addAttribute("requestPageNum", requestPageNum);
			return "boardWrite";
		}
		
		try {
			// 파일 업로드
			MultipartFile mfile = bVo.getMfile();
			// 파일 명을 VO에 설정
			bVo.setUploadpath(mfile.getOriginalFilename());
			// Service 메소드를 호출
			boardService.insertBoard(bVo);
			System.out.println("mfile = " + mfile);

			if (mfile != null && mfile.getSize() != 0) {
				String filename = mfile.getOriginalFilename(); // 업로드 파일명
				// upload 폴더의 물리적인 폴더 경로 지정 (물리경로 -> 알아서 잡아줌)			
				/*String upath = "C:/myjava17gi/workspace_jh/web-study-11-AnnotationMVC-v2_0/WebContent/upload";*/
				String upath = request.getServletContext().getRealPath("/upload");
				System.out.println(upath + "경로 설정 완료");
				// upload폴더 File 객체 생성
				File file = new File(upath + "/" + filename);
				mfile.transferTo(file); // 파일을 업로드 폴더에 복사

			}

			return "redirect:boardList.do?pn=1";
			
		} catch (Exception e) {
			return "boardWrite";
		}
	}

}
