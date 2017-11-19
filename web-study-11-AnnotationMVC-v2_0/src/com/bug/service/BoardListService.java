package com.bug.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.dao.BoardListDAO;
import com.bug.dto.BoardVO;
import com.bug.dto.BoardVOListModel;


@Service
public class BoardListService {
	
	@Autowired
	private BoardListDAO boardListDAO;
	
	public BoardVOListModel list(String pn) {
		
		// 고객이 요청한 페이지 번호
		int requestPageNum = Integer.parseInt(pn);
		// 전체 행 개수(글 개수) 확인
		int totalBoardVOCount = boardListDAO.totalRowCount();
		
		// 전체 페이지 개수
		int totalPageCount = calculateTotalPageCount(totalBoardVOCount);
		
		// 글목록을 가져오기 위한 재료1 (요청한 페이지의 첫 행 번호)
		int firstRow = (requestPageNum - 1)*10 + 1;
		// 글목록을 가져오기 위한 재료2 (요청한 페이지의 마지막 행 번호)
		int endRow = firstRow + 9;
		// 마지막 페이지에서만 발생 가능
		if (endRow > totalBoardVOCount) {
			endRow = totalBoardVOCount;
		}
		
		// 글목록 가져오기
		List<BoardVO> boardVOList
		= boardListDAO.selectList(firstRow, endRow);
		
		// 페이징 ( 페이지를 10개 단위로 끊어서 보여줄 셈)
		// ex) 1 - 10, 11 - 20, 21 - 30 etc
		
		// 페이징을 위한 재료1 ( 페이징 시작 번호 ex) 1, 11, 21 ... )
		int beginPageNum = calculateBeginPageNum(requestPageNum, totalPageCount);
		// 페이징을 위한 재료2 ( 페이징 끝 번호 )
		int endPageNum = beginPageNum + 9;
		if (endPageNum > totalPageCount) {
			endPageNum = totalPageCount;
		}
		
		// boardList 뷰 페이지 구현을 위해 필요한 모든 것들을 아래 모델에 담음.
		BoardVOListModel boardVOListView
		= new BoardVOListModel(boardVOList, requestPageNum, totalPageCount, firstRow, endRow,
				beginPageNum, endPageNum);
		
		return boardVOListView;	
		
	}

	private int calculateTotalPageCount(int totalBoardVOCount) {
		if (totalBoardVOCount == 0) {
			return 0;			
		}
		int pageCount = totalBoardVOCount / 10;
		/*나머지가 있는 경우*/
		if ( totalBoardVOCount % 10 > 0 ) {
			pageCount++;			
		}
		return pageCount;
	}
	
	private int calculateBeginPageNum(int requestPageNum, int totalPageCount) {
		
		if (totalPageCount > 0) {
			return (requestPageNum-1)/10*10 + 1;
		}
		return 0;
	}

	
}
