<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- 게시글 리스트 페이지(초기화면) -->
<div id="wrap" align="center">
	<h1>게시글 리스트</h1>
	<table class="list">
		<tr>
			<td colspan="5" style="border: white; text-align: right"><a
				href="boardWriteForm.do?requestPageNum=${boardVOListView.requestPageNum}">게시글
					등록 악플러 환영!!!</a></td>
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
				<td style="text-align: left;padding-left:20px;"><c:if test="${board.blevel > 0}">
						<!-- 답글이면 -를 추가 -->
						<c:forEach begin="1" end="${board.blevel}">-</c:forEach>&gt;
					</c:if> <a
					href="boardView.do?num=${board.num}&requestPageNum=${boardVOListView.requestPageNum}">
						${board.title } </a></td>
				<td>${board.name}</td>
				<td><fmt:formatDate value="${board.writedate }" pattern="yyyy.MM.dd HH:mm:ss"/></td>
				<td>${board.readcount}</td>
			</tr>
		</c:forEach>
		<tr>

			<td colspan="5" style="text-align: center;"><c:if
					test="${boardVOListView.beginPageNum > 10}">
					<a
						href='<c:url value="/boardList.do?pn=${boardVOListView.beginPageNum-1}"/>'>이전</a>
				</c:if> <c:forEach var="pno" begin="${boardVOListView.beginPageNum}"
					end="${boardVOListView.endPageNum}">

					<c:choose>
						<c:when test="${pno == boardVOListView.requestPageNum}">
							<a style="color: blue; font-size:larger; font-weight: bolder;" href='<c:url value="/boardList.do?pn=${pno}" />' >[${pno}]
							</a>
						</c:when>
						<c:otherwise>
							<a href='<c:url value="/boardList.do?pn=${pno}" />'>[${pno}]
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <c:if
					test="${boardVOListView.endPageNum < boardVOListView.totalPageCount}">
					<a
						href='<c:url value="/boardList.do?pn=${boardVOListView.endPageNum + 1}"/>'>다음</a>
				</c:if></td>

		</tr>
	</table>
</div>
<%@ include file="footer.jsp"%>