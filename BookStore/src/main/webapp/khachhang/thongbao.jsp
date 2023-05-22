<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông báo xác thực</title>
</head>
<body>
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	<jsp:include page="<%=url%>/header.jsp"/>
	<%=request.getAttribute("baoLoi")+"" %>
	<script>
		setTimeout(() => {
			window.location.href = "index.jsp";
		}, 7000);
	</script>
	<jsp:include page="<%=url%>/footer.jsp"/>
</body>
</html>