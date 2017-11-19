<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 답글 등록폼 페이지 -->
	<div id="wrap" align="center">
		<h1>답글 등록</h1>
		<form:form commandName="board" method="post" action="boardWriteReply.do" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${board.num}">
			<input type="hidden" name="bref" value="${board.bref}">
			<input type="hidden" name="bstep" value="${board.bstep}">
			<input type="hidden" name="blevel" value="${board.blevel}">
			<input type="hidden" name="titleBackup" value="${board.title}">
			<input type="hidden" name="pn" value="${pn}">
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
						<input type="text" size="70" name="title" value="RE: ${board.title}"> * 필수
						<form:errors path="title" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="mfile"></td>
				</tr>
			</table>
			<br>
			<br>
			<input type="submit" value="등록"/>
			<input type="reset" value="다시 작성" />
			<input type="button" value="목록" onclick="location.href='boardList.do?pn=${pn}'" />
		</form:form>
	</div>

<%@ include file="footer.jsp" %>