<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page2</title>
</head>
<body style="background-color: pink">
	<%
		String username = (String)session.getAttribute("username");
	%>
	Hello <%= username %> <br>
	
	<h1>This is login success page</h1>
	<a href="success.jsp">success page</a> <hr> <a href="trang1.jsp">page 1</a>
</body>
</html>