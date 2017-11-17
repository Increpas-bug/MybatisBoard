<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 게시글 상세 페이지 -->
<div id="wrap" align="center">
	<h1>게시글 상세보기</h1>
	<table>
		<tr>
			<th>작성자</th>
			<td>${board.name}</td>
			<th>이메일</th>
			<td>${board.email}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${board.writedate}" /></td>
			<th>조회수</th>
			<td>${board.readcount}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><pre>${board.content}</pre></td>
		</tr>
	</table>
	<br/><br/>
	<input type="button" value="게시글 수정" onclick="open_win('boardCheckPassForm.do?num=${board.num}', 'update')"/>
	<input type="button" value="게시글 삭제" onclick="open_win('boardCheckPassForm.do?num=${board.num}', 'delete')"/>
	<input type="button" value="게시글 리스트" onclick="location.href='boardList.do'"/>
	<input type="button" value="게시글 등록" onclick="location.href='boardWriteForm.do'"/>
	
</div>

<%@ include file="footer.jsp" %>
