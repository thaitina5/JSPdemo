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
		String sAmount = request.getParameter("amount");
		int amount = 0;
		try{
			amount = Integer.parseInt(sAmount);	
		}catch(Exception e){
			
		}
	%>
	Thank you User: <b><%= email %></b><br>
	Password: <b><%= pass %></b><br>
	Have order: <b><%= amount %></b> product<br>
	Total price: <b><%= amount*100 %></b> 
</body>
</html>