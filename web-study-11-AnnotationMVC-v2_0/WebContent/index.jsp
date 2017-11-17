<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 페이지 실행시 boardList.do 명령으로 바로 넘어감 -->
<!-- src > com.bug.controller > BoardContoller.java 에서 boardList.do 명령을 받는다 -->
<!-- 게시판 리스트, 등록, 수정, 삭제를 모두 BoardContoller 클래스에서 관리하는 구조 -->
<%
response.sendRedirect("boardList.do");
%>

</body>
</html>