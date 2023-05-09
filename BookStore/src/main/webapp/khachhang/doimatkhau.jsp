<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	%>
	<link href="<%=url%>/css/doimatkhau.css" rel="stylesheet">
</head>
<body>
	<%
		String baoLoi = request.getAttribute("baoLoi") + "";
		baoLoi = baoLoi.equals("null") ? "" : baoLoi;
		
		Object obj = session.getAttribute("khachhang");
		KhachHang khachHang = null;
		if (obj!=null){
			khachHang = (KhachHang)obj;
		}
		if(khachHang==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<% }else{ %>
	
	<div class="mainDiv">
		<div class="cardStyle">
			<form action="../khach-hang" method="post" name="signupForm"
				id="signupForm">
				<input type="hidden" name="hanhdong" value="doi-mat-khau"/>
				
				<h2 class="formTitle">Đổi mật khẩu</h2>
				<div style="text-align:center"><span class="red"><%=baoLoi %></span></div>
				<div class="inputDiv">
					<label class="inputLabel" for="password">Mật khẩu hiện tại <span class="red">*</span></label>
					<input type="password" id="matkhauhientai" name="matkhauhientai" required>
				</div>

				<div class="inputDiv">
					<label class="inputLabel" for="password">Mật khẩu mới <span class="red">*</span></label> 
					<input type="password" id="matkhaumoi" name="matkhaumoi" required>
				</div>

				<div class="inputDiv">
					<label class="inputLabel" for="confirmPassword">Xác nhận mật khẩu mới <span class="red">*</span></label> 
					<input type="password" id="xacnhanmatkhau" name="xacnhanmatkhau">
				</div>

				<div class="buttonWrapper">
					<button type="submit" id="submitButton"
						class="submitButton pure-button pure-button-primary">
						<span>Thay đổi</span>
					</button>
				</div>

			</form>
		</div>
	</div>
	<% } %>
</body>
</html>