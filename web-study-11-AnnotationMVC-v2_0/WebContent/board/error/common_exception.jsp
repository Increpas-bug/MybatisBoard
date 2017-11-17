<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%response.setStatus(200); %>
<%@ include file="../header.jsp" %>

요청처리중에 오류 발생 ( <%=exception %> )<br>
<br>
에러타입 : <%= exception.getClass().getName() %><br>
에러메세지 : <%= exception.getMessage() %>

<%@ include file="../footer.jsp" %>