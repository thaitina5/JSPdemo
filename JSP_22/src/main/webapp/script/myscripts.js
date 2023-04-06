function my_submit(){
	error = "";
	
	maSanPham = document.getElementById("maSanPham").value;
	giaBan = document.getElementById("giaBan").value;
	if(maSanPham.length == 0){
		error = "Bạn phải nhập mã sản phẩm";
	}
	if(giaBan <= 0){
		error_giaBan = document.getElementById("error_giaBan");
		error_giaBan.innerHTML = "<span class='rq'>Bạn phải nhập giá bán</span>";
	}
	if(error.length > 0){
		alert(error);
		return;
	}else{
		my_form = document.getElementById("my_form");
		my_form.submit();
	}
	
}
