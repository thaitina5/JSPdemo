<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error 404</title>
</head>
<body>
	<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
	<%=path %> <br>
	<img style={ height="800", width="1000"} alt="error 404" src="<%=path %>/image/404.jpg">
</body>
</html>