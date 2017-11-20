package com.bug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.dto.BoardVO;
import com.bug.service.BoardCheckPassService;


@Controller
public class BoardCheckPassController {
	
			@Autowired
			private BoardCheckPassService boardCheckPassService;
		
	
	// 비밀번호 체크 start
		@RequestMapping(value = "/boardCheckPassForm.do", method = RequestMethod.GET)
		public String checkPassForm() {
			return "boardCheckPass"; // 비밀번호 확인 팝업 페이지
		}

		@RequestMapping(value = "/boardCheckPass.do", method = RequestMethod.GET)
		public String checkPass(String num, String pass, Model model) {
			String view = "checkSuccess";

			System.out.println("BoardController checkPass() >>>>>>>>>>");
			BoardVO bVo = boardCheckPassService.selectOneBoardByNum(num); // 글 번호로 게시글(BoardVO) 조회
			System.out.println(bVo);
			System.out.println("<<<<<<<<<< BoardController checkPass()");
			
			// 서비스로 분리(서비스를 만들어서 사용해보기위해.. 간단한 코드이지만 분리하였다)
			// 비밀번호 일치 여부
			boolean isPass = boardCheckPassService.isCheckPass(bVo, pass); // isCheckPass() : 일치하면 true, 불일치하면 false 리턴하는 메소드
			if (!isPass) { // 불일치하면 메세지를 model에 담아 다시 비밀번호 확인 팝업 페이지로 이동
				model.addAttribute("message", "비밀번호가 틀렸습니다.");
				return "boardCheckPass";
			}
			
			return view; // 일치시 성공처리 페이지로 이동
		}
		// 비밀번호 체크 end

}
