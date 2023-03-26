<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<title>JSP_20</title>
</head>
<body>
	<div class="container">
		<h1>BUY COMPUTER</h1>
		<form action="datMuaMayTinh.jsp" method="Get">
			<h1>Processor</h1>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					value="Core I9" id="i9"> <label class="form-check-label"
					for="i9"> Core I9 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					value="Core I7" id="i7"> <label class="form-check-label"
					for="i7"> Core I7 </label>
			</div>

			<h1>RAM</h1>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram"
					value="Ram 8gb" id="ram8gb"> <label
					class="form-check-label" for="ram8gb"> Ram 8gb </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram"
					value="Ram 16gb" id="ram16gb"> <label
					class="form-check-label" for="ram16gb"> Ram 16gb </label>
			</div>

			<h1>Monitor</h1>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="monitor"
					value="Monitor" id="monitor"> <label
					class="form-check-label" for="monitor"> Monitor </label>
			</div>

			<h1>Accessories</h1>
			<!-- <div class="form-check">
				<input class="form-check-input" type="checkbox" value="Printer"
					name="accessories" id="printer"> <label
					class="form-check-label" for="printer"> Printer </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="Speaker"
					name="accessories" id="speaker"> <label
					class="form-check-label" for="speaker"> Speaker </label>
			</div> -->

			<select name="accessories" class="form-select" multiple aria-label="multiple select example">
				<option value="camera">Camera</option>
				<option value="printer">Printer</option>
				<option value="speaker">Speaker</option>
			</select>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</body>
</html>