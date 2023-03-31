<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>LOGIN</title>
</head>
<body>
	<div class="container">
		<h1>LOGIN</h1>
		<form action="dang-nhap" method="POST">
			<div class="mb-3">
				<label for="id_username" class="form-label"> User name:</label> 
				<input type="text" class="form-control" id="id_username" name="username">
			</div>
			<div class="mb-3">
				<label for="id_pass" class="form-label">Password:</label>
				<input type="password" class="form-control"
					id="id_pass" name="password">
			</div>
			
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>