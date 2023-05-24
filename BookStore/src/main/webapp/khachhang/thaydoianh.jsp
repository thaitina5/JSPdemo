<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Thông Tin</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>
	<style>
		.red {
			color: red;
		}
		
		.avatar {
			vertical-align: middle;
			width: 50px;
			height: 50px;
			border-radius: 50%;
			object-fit:cover;
		}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<%
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = (baoLoi.equals("null"))?"":baoLoi;
		
		Object obj = session.getAttribute("khachhang");
		KhachHang khachHang = null;
		
		if (obj!=null){
			khachHang = (KhachHang)obj;
		}
		if(khachHang==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<% }else{ %>
	<%
		String duongDanAnh = khachHang.getDuongDanAnh();
	%>
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	%>
	<div class="container">
		<div class="text-center">
			<h1>AVATAR TÀI KHOẢN</h1>
		</div>

		<div class="red" id="baoLoi">
			<%=baoLoi%>
		</div>
		<form class="form" action="<%=url%>/khach-hang-thay-doi-anh" method="post" enctype="multipart/form-data">
			<input type="hidden" name="hanhdong" value="thay-doi-anh"/>
			<div class="row justify-content-center">
				<div class="col-sm-6">
					<img class="avatar" alt="Ảnh avatar" src="<%=url%>/avatar/<%=duongDanAnh%>" />
					<div class="mb-3">
						<label for="duongdananh" class="form-label">Đường dẫn ảnh</label> 
						<input type="file" class="form-control" id="duongdananh" name="duongdananh">
					</div>
					
					<input class="btn btn-primary form-control" type="submit"
						 name="submit" id="submit" value="Lưu ảnh" />
				</div>
			</div>
		</form>
	</div>
	<% } %>
	
	<%@include file="../footer.jsp" %>
</body>
</html>