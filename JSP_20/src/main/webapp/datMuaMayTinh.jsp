<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<title>JSP_20</title>
</head>
<body>
  <%
  	double tongTien = 0;
  	
  	//Radio
  	String processor = request.getParameter("processor");
  	double processorPrice = 0;
  	if(processor!=null){
  		if(processor.equals("Core I9")){
  			processorPrice+=500;
  		}else if(processor.equals("Core I7")){
  			processorPrice+=400;
  		}
  		tongTien+=processorPrice;
  	}
  	
  	String ram = request.getParameter("ram");
  	double ramPrice = 0;
  	if(ram!=null){
  		if(ram.equals("Ram 8gb")){
  			ramPrice+=100;
  		}else if(ram.equals("Ram 16gb")){
  			ramPrice+=200;
  		}
  		tongTien+=ramPrice;
  	}
  	
  	//Checkbox
  	String monitor = request.getParameter("monitor");
  	double monitorPrice = 0;
  	if(monitor!=null){
  		monitorPrice+=600;
  	}
  	tongTien+=monitorPrice;
  	
  	//Select
  	String[] accessories = request.getParameterValues("accessories");
  	if(accessories!=null){
	  	for(String i: accessories){
	  		if(i.equals("camera")){
	  			tongTien+=200;
	  		}
	  		if(i.equals("printer")){
	  			tongTien+=250;
	  		}
	  		if(i.equals("speaker")){
	  			tongTien+=220;
	  		} 		
	  	}  		
  	}
  %>

	<div class="container">
		<h1>HÓA ĐƠN</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Giá tiền</th>
				</tr>
			</thead>
			<tbody>
				<%if(processor!=null){ %>
					<tr>
						<td><%=processor%></td>
						<td><%=processorPrice%>$</td>
					</tr>
				<% } %>
				<%if(ram!=null){ %>
					<tr>
						<td><%=ram%></td>
						<td><%=ramPrice%>$</td>
					</tr>
				<% } %>
				<%if(monitor!=null){ %>
					<tr>
						<td><%=monitor%></td>
						<td><%=monitorPrice%>$</td>
					</tr>
				<% } %>
				<%
				if(accessories!=null)
				  	for(String i: accessories){
				  		double price = 0;
						if (i.equals("camera")) {
							price += 200;
						}
						if (i.equals("printer")) {
							price += 250;
						}
						if (i.equals("speaker")) {
							price += 220;
						}
				%>
						<tr>
							<td><%=i%></td>
							<td><%=price%>$</td>
						</tr>
				<% } %>
				<tr>
					<td><b>Tổng tiền:</b></td>
					<td><b><%=tongTien%>$</b></td>
				</tr>
			</tbody>
		</table>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</body>
</html>