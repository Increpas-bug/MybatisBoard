package com.bug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.dao.BoardDAO;
import com.bug.dto.BoardVO;

/*
 * 1. @Service 선언
 * 2. BoardController 에 @Autowired 선언
 * 두가지 어노테이션 선언을 해주면 컨트롤러(BoardController)에서 Service에 있는 메소드를 호출하는 방식이 간단해진다
 * 사용은 BoardController클래스를 참고하도록 한다
 */
@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	// 비밀번호 일치 여부
	public boolean isCheckPass(BoardVO bVo, String pass) {
		if (bVo.getPass().equals(pass)) {
			return true; // 일치
		} else {
			return false; // 불일치
		}
	}
	
	// 게시판 리스트
	public List<BoardVO> getBoardVOList() { // List -> BoardVOListModel, 매개변수 int requestPageNumber
		// 페이징 처리 v2.1에서 추가 -> 많이 변경될것 테이블도
		
		// 리스트 받아오기
		List<BoardVO> boardVOList = boardDAO.selectAllBoards();
		
		return boardVOList;
	}
	// 게시글 등록 
	@Transactional
	public void insertBoard(BoardVO vo){
		boardDAO.insert(vo);
	}
	
}
