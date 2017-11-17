<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 비밀번호 확인 팝업 페이지 -->
	<div align="center">
		<h1 style="width: 200px ">비밀번호 확인</h1>
		<form action="boardCheckPass.do" name="frm" method="get">
			<input type="hidden" name="num" value="${param.num}">
			<table style="width: 64% ">
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pass" size="20">
					</td>
				</tr>
			</table>
			<br> <input type="submit" value=" 확 인 " onclick="return passCheck()"> <br>
			<br>${message}
		</form>
	</div>
<%@ include file="footer.jsp" %>