<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_Example</title>
</head>
<body>
	<%
		String email = request.getParameter("inputEmail");
		String pass = request.getParameter("inputPassword");
		String check = request.getParameter("inputCheck");
	%>
	Welcome User: <%= email %> <br>
	Password: <%= pass %> <br>
	Status: <%= check %> <br>
	login success! 
</body>
</html>