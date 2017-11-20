package com.bug.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.dao.BoardViewDAO;
import com.bug.dto.BoardVO;

@Service
public class BoardCheckPassService {
	
	@Autowired
	private BoardViewDAO dao;
	
	// 게시글 조회 및 조회수 증가
		@Transactional
		public BoardVO selectOneBoardByNum(String num) {
			return dao.selectOneBoardByNum(num);
		}
	
	// 비밀번호 일치 여부
		public boolean isCheckPass(BoardVO bVo, String pass) {
			if (bVo.getPass().equals(pass)) {
				return true; // 일치
			} else {
				return false; // 불일치
			}
		}

}
