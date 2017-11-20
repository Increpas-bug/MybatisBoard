package com.bug.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bug.dao.BoardUpdateDAO;
import com.bug.dto.BoardVO;

@Service
public class BoardUpdateService {
	
	@Autowired
	private BoardUpdateDAO dao;

	public void updateBoard(BoardVO bVo) {
		dao.updateBoard(bVo);
		
	}

}
