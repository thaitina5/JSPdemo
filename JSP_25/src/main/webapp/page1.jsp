<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page1</title>
</head>
<body style="background-color: yellow">
	<%
		String username = (String)session.getAttribute("username");
	%>
	Hello <%= username %> <br>
	<hr>
	<h1>This is page1</h1>
	<a href="success.jsp">success page</a> | <a href="page2.jsp">page 2</a>
</body>
</html>