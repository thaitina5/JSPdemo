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
</head>
<body>
	<div class="main">
		<!-- Navbar -->
		<jsp:include page="header.jsp" />
	
		<!-- Page content -->
		<div class="container mt-4">
			<div class="row">
				<!-- Menu left -->
				<jsp:include page="left.jsp" />
	
				<!-- Slider and Products -->
				<div class="col-lg-9">
					<!-- Slider -->
					<div id="carouselExampleIndicators" class="carousel slide mb-4"
						data-bs-ride="true">
						<div class="carousel-indicators">
							<button type="button" data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
						</div>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="image/slider/1.png" class="d-block w-100" alt="...">
							</div>
							<div class="carousel-item">
								<img src="image/slider/2.png" class="d-block w-100" alt="...">
							</div>
							<div class="carousel-item">
								<img src="image/slider/3.png" class="d-block w-100" alt="...">
							</div>
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
					<!-- End Slider -->
					<!-- Products -->
					<div class="row">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top" src="image/product/1.png"
									alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">Áo thun Pro-S1</a>
									</h4>
									<h5>50.000</h5>
									<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
										màu sắc tốt.</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
	
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top" src="image/product/2.png"
									alt="" ></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">Áo thun Pro-S1</a>
									</h4>
									<h5>50.000</h5>
									<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
										màu sắc tốt.</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
	
	
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top" src="image/product/3.png"
									alt="" ></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">Áo thun Pro-S1</a>
									</h4>
									<h5>50.000</h5>
									<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
										màu sắc tốt.</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
	
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top" src="image/product/1.png"
									alt="" ></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">Áo thun Pro-S1</a>
									</h4>
									<h5>50.000</h5>
									<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
										màu sắc tốt.</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
					</div>
					<!-- End Products -->
				</div>
				<!-- End Slider and Products -->
			</div>
		</div>
		<!-- End Page content -->
	
		<!-- Footer -->
		<%@include file="footer.jsp" %>
	
	</div>
</body>
</html>