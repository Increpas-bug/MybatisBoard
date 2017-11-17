<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 비밀번호 확인후 처리 페이지(화면 출력 X) -->
	<script type="text/javascript">
		if (window.name == "update") {
			window.opener.parent.location.href = "boardUpdateForm.do?num=${param.num}";
		} else if (window.name == 'delete') {
			alert('삭제되었습니다.');
			window.opener.parent.location.href = "boardDelete.do?num=${param.num}";
		}
		window.close();
	</script>
<%@ include file="footer.jsp" %>