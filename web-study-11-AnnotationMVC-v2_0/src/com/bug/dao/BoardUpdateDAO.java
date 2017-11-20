package com.bug.dao;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bug.dto.BoardVO;

@Repository
public class BoardUpdateDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void updateBoard(BoardVO vo) {
		sqlSessionTemplate.update("board_ns.updateBoard2", vo);		
	}	
	
}
