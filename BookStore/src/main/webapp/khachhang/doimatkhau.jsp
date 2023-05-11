<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
	<title>Insert title here</title>
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	%>
	<link href="<%=url%>/css/doimatkhau.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp" />
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
	<%@include file="../footer.jsp" %>
</body>
</html>