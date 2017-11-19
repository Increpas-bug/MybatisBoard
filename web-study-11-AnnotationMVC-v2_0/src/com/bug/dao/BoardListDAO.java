package com.bug.dao;



import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bug.dto.BoardVO;


/*
 * 1. @Component 선언
 * 2. BoardController 에 @Resource 선언
 * 두가지 어노테이션 선언을 해주면 컨트롤러(BoardController)에서 DAO에 있는 메소드를 호출하는 방식이 간단해진다
 * 사용은 BoardController클래스를 참고하도록 한다
 */
@Component("boardListDAO")
public class BoardListDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int totalRowCount() {
		return sqlSessionTemplate.selectOne("board_ns.totalRowCount");
	}

	public List<BoardVO> selectList(int firstRow, int endRow) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("firstRow", firstRow);
		map.put("endRow", endRow);		
		return sqlSessionTemplate.selectList("board_ns.selectAllBoards", map);
	}

}
