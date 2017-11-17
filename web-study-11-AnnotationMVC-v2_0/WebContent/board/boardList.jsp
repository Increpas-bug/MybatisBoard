<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 게시글 리스트 페이지(초기화면) -->
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="boardWriteForm.do">게시글 등록1</a></td>
			</tr>
			<tr id="listtitle">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<!-- 결과모델 글목록을 요청영역에서 가져옴  -->
			<c:forEach var="board" items="${boardList}">
				<tr class="record">
					<td>${board.num }</td>
					<td><a href="boardView.do?num=${board.num}"><!-- 게시판 글 번호 넘기는 방식은 고민해보자 -->
							${board.title } </a></td>
					<td>${board.name}</td>
					<td><fmt:formatDate value="${board.writedate }" /></td>
					<td>${board.readcount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%@ include file="footer.jsp" %>