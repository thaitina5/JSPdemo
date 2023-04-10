<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Success page</title>
	<style>
		.text_color{
			color:white;
		}
	</style>
</head>
<body style="background-color: blue">
	<%
		String username = (String)session.getAttribute("username");
	%>
	<div class="text_color">
		Hello <%= username %> <br>
		<hr>
		<h1>This is login success page</h1>
		<a class="text_color" href="page1.jsp">page 1</a> | <a class="text_color" href="page2.jsp">page 2</a>
	</div>
	
</body>
</html>