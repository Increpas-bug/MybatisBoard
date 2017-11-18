package com.bug.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bug.dto.BoardVO;

@Repository
public class BoardViewDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// num으로 게시글 조회
	public BoardVO selectOneBoardByNum(String num) {
		return (BoardVO)sqlSessionTemplate.selectOne("board_ns.selectOneBoardByNum", num);
	}
	
	// 조회수 증가
	public void updateReadCount(String num) {
		sqlSessionTemplate.update("board_ns.updateReadCount", num);
	}
}
