<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_Example2</title>
</head>
<body>
	<%
		String email = request.getParameter("inputEmail");
		String pass = request.getParameter("inputPassword");
	%>
	
	<%
		if(email.equalsIgnoreCase("bukudao@gmail.com")&& pass.equals("123")) {
	%>
		<h1>Login success!</h1>
	<% } else { %>
		<h1>Account not exist!</h1>
	<% } %>
</body>
</html>