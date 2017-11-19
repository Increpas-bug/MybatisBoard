package com.bug.dto;

import java.util.List;

public class BoardVOListModel {
	
	// 글목록
	private List<BoardVO> boardVOList;
	// 고객이 요청한 페이지 번호
	private int requestPageNum;
	private int totalPageCount;
	private int firstRow;
	private int endRow;
	private int beginPageNum;
	private int endPageNum;
	
	public BoardVOListModel(List<BoardVO> boardVOList, int requestPageNum, int totalPageCount, int firstRow, int endRow,
			int beginPageNum, int endPageNum) {
		super();
		this.boardVOList = boardVOList;
		this.requestPageNum = requestPageNum;
		this.totalPageCount = totalPageCount;
		this.firstRow = firstRow;
		this.endRow = endRow;
		this.beginPageNum = beginPageNum;
		this.endPageNum = endPageNum;
	}
	public List<BoardVO> getBoardVOList() {
		return boardVOList;
	}
	public void setBoardVOList(List<BoardVO> boardVOList) {
		this.boardVOList = boardVOList;
	}
	public int getRequestPageNum() {
		return requestPageNum;
	}
	public void setRequestPageNum(int requestPageNum) {
		this.requestPageNum = requestPageNum;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getBeginPageNum() {
		return beginPageNum;
	}
	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	
	
	

}
