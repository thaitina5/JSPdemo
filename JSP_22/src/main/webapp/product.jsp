<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="script/myscripts.js"></script>
	<title>Product</title>
	<style type="text/css">
		.rq{
			color: red;
		}
	</style>
</head>
<body>
	<% 
		String e_maSanPham = request.getAttribute("e_maSanPham")+"";
		e_maSanPham = e_maSanPham.equals("null")? "":e_maSanPham;
	
		String maSanPham = request.getAttribute("maSanPham")+"";
		String tenSanPham = request.getAttribute("tenSanPham")+"";
		String giaBan_String = request.getAttribute("giaBan_String")+"";
		String giaNhap_String = request.getAttribute("giaNhap_String")+"";
		String hanSuDung_String = request.getAttribute("hanSuDung_String")+"";
		String vat_String = request.getAttribute("vat_String")+"";
		String moTa = request.getAttribute("moTa")+"";
		
		maSanPham = maSanPham.equals("null")? "":maSanPham;
		tenSanPham = tenSanPham.equals("null")? "":tenSanPham;
		giaBan_String = giaBan_String.equals("null")? "":giaBan_String;
		giaNhap_String = giaNhap_String.equals("null")? "":giaNhap_String;
		hanSuDung_String = hanSuDung_String.equals("null")? "":hanSuDung_String;
		vat_String = vat_String.equals("null")? "":vat_String;
		moTa = moTa.equals("null")? "":moTa;
	%>
	
	<div class="container mt-4">
		<form id="my_form" class="row g-3" action="save-product" method="GET">
			<div class="row">
				<div class="col-6">
					<label for="maSanPham" class="form-label">Mã sản phẩm<span class="rq">*</span></label> 
					<input type="text" class="form-control" id="maSanPham" name="maSanPham" value="<%= maSanPham %>" required>
					<div class="rq"><%= e_maSanPham %></div>
				</div>
				<div class="col-6">
					<label for="tenSanPham" class="form-label">Tên sản phẩm<span class="rq">*</span></label> 
					<input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value="<%= tenSanPham %>" required>
				</div>
			</div>
			<div class="row">
					<div class="col-6">
					<label for="giaNhap" class="form-label">Giá nhập<span class="rq">*</span></label> 
					<input type="number" step="0.01" class="form-control" id="giaNhap" name="giaNhap" value="<%= giaNhap_String %>" required>
				</div>
				<div class="col-6">
					<label for="giaBan" class="form-label">Giá bán<span class="rq">*</span></label> 
					<input type="number" step="0.01" class="form-control" id="giaBan" name="giaBan" value="<%= giaBan_String %>" required>
					<div id="error_giaBan" ></div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="hanSuDung" class="form-label">Hạn sử dụng</label> 
					<input type="datetime-local" class="form-control" id="hanSuDung" name="hanSuDung" value="<%= hanSuDung_String%>">
				</div>
				<div class="col-6">
					<label for="giaBan" class="form-label">VAT</label> 
					<input type="number" step="0.01" class="form-control" id="vat" name="vat" value="<%=vat_String%>">
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<label for="moTa" class="form-label">Mô tả sản phẩm</label>
					<textarea id="moTa" name="moTa" class="form-control" rows="10" cols="20"><%=moTa %></textarea> 
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<button type="button" onclick="my_submit()" class="btn btn-primary">Lưu sản phẩm</button>
				</div>
			</div>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>