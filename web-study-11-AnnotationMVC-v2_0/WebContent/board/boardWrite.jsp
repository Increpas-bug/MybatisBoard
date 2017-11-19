<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 게시글 등록폼 페이지 -->
	<div id="wrap" align="center">
		<h1>게시글 등록</h1>
		<form:form commandName="board" method="post" action="boardWrite.do" enctype="multipart/form-data">
		<input type="hidden" name="requestPageNum" value="${requestPageNum}">
			<table>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="name"> * 필수
						<form:errors path="name" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pass"> * 필수 (게시물 수정/삭제시 필요합니다.)
						<form:errors path="pass" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" size="70" name="title"> * 필수
						<form:errors path="title" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
				<tr>
					<th>첨부 파일</th>
					<td><input type="file" name="mfile"></td>
				</tr>
			</table>
			<br>
			<br>
			<input type="submit" value="등록"/>
			<input type="reset" value="다시 작성" />
			<input type="button" value="목록" onclick="location.href='boardList.do?pn=${requestPageNum}'" />
		</form:form>
	</div>

<%@ include file="footer.jsp" %>