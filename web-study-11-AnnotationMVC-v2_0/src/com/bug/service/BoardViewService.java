package com.bug.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.dao.BoardViewDAO;
import com.bug.dto.BoardVO;

@Service
public class BoardViewService {

	@Autowired
	private BoardViewDAO dao;

	// 게시글 조회 및 조회수 증가
	@Transactional
	public BoardVO selectOneBoardByNum(String num) {
		dao.updateReadCount(num);
		return dao.selectOneBoardByNum(num);
	}

}
