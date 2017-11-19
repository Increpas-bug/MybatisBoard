<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 게시글 리스트 페이지(초기화면) -->
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="boardWriteForm.do">게시글 등록 악플러 환영!!!</a></td>
			</tr>
			<tr id="listtitle">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<!-- 결과모델 글목록을 요청영역에서 가져옴  -->
			<c:forEach var="board" items="${boardVOListView.boardVOList}">
				<tr class="record">
					<td>${board.num }</td>
					<td>
					<c:if test="${board.blevel > 0}">
						<!-- 답글이면 -를 추가 -->
					<c:forEach begin="1" end="${board.blevel}">-</c:forEach>&gt;
					</c:if>
					<a href="boardView.do?num=${board.num}"><!-- 게시판 글 번호 넘기는 방식은 고민해보자 -->
							${board.title } </a></td>
					<td>${board.name}</td>
					<td><fmt:formatDate value="${board.writedate }" /></td>
					<td>${board.readcount}</td>
				</tr>
			</c:forEach>
			<tr>
					
					<td colspan="5"><c:if test="${boardVOListView.beginPageNum > 10}">
							<a href='<c:url value="/boardList.do?pn=${boardVOListView.beginPageNum-1}"/>'>이전</a>
						</c:if> <c:forEach var="pno" begin="${boardVOListView.beginPageNum}" end="${boardVOListView.endPageNum}">
							<a href='<c:url value="/boardList.do?pn=${pno}" />'>[${pno}]</a>
						</c:forEach> <c:if test="${boardVOListView.endPageNum < boardVOListView.totalPageCount}">
							<a href='<c:url value="/boardList.do?pn=${boardVOListView.endPageNum + 1}"/>'>다음</a>
						</c:if></td>
					
				</tr>
		</table>
	</div>
<%@ include file="footer.jsp" %>