<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 게시글 수정폼 페이지 -->
	<div id="wrap" align="center">
		<h1>게시글 수정오겹살</h1>
		<form:form commandName="board" name="frm" method="post" action="boardUpdate.do">
			<input type="hidden" name="num" value="${board.num}">
			<table>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" size="12" name="name" value="${board.name}"> * 필수
						<form:errors path="name" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" size="12" name="pass"> * 필수 (게시물 수정/삭제시 필요합니다.)
						<form:errors path="pass" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" size="40" maxlength="50" name="email" value="${board.email}">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" size="70" name="title" value="${board.title}"> * 필수
						<form:errors path="title" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content">${board.content}</textarea></td>
				</tr>
			</table>
			<br>
			<br>
			<input type="submit" value="등록">
			<input type="reset" value="다시 작성">
			<input type="button" value="목록" onclick="location.href='boardList.do'">
		</form:form>
	</div>
<%@ include file="footer.jsp" %>