<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi-VN">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title>Đăng nhập</title>
</head>
<style>
#screen {
	width: 400px;
	margin: auto;
	background-color: white;
	margin-top: 50px;
}

body {
	background-image:
		url('https://images.pexels.com/photos/1287142/pexels-photo-1287142.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
}

.top10 {
	margin-top: 20px;
	'
}

@media screen and (max-width: 400px) {
	#screen {
		width: 100%;
		margin-top: 0;
	}
}

</style>
<body>
	<div id="screen">
		<div class="text-center bg-warning text-white" style="padding: 5px 0;">
			<h1>Đăng nhập</h1>
		</div>
		<form action="login" method="post">
			<div class="row">
				<div class="col-1"></div>
				<div class="col-10 top10"
					style="background-color: red; color: white;">${loi }</div>
				<div class="col-1"></div>
				<div class="col-1"></div>
				<div class="col-10 top10">
					<label for="taiKhoan">Tài khoản:</label>
				</div>
				<div class="col-1"></div>

				<div class="col-1"></div>
				<div class="col-10">
					<input class="form-control" type="text" name="taiKhoan"
						id="taiKhoan" required="required" pattern="^[a-zA-Z]+$">
				</div>
				<div class="col-1"></div>

				<div class="col-1"></div>
				<div class="col-10 top10">
					<label for="matKhau">Mật khẩu:</label>
				</div>
				<div class="col-1"></div>
				<div class="col-1"></div>
				<div class="col-10">
					<input class="form-control" type="password" name="matKhau"
						required="required" id="matKhau">
				</div>
				<div class="col-1"></div>

				<div class="col-1"></div>
				<div class="col-10 top10">
					<input class="btn btn-success btn-block" type="submit" id="dangKy"
						value="Đăng nhập">
				</div>
				<div class="col-1"></div>
			</div>
		</form>

		<div class="text-center top10">
			<small>Chưa có tài khoản?<a href="logup"> Đăng ký</a></small>
		</div>
		<div class="text-center">
			<small><a href="get-password">Quên mật khẩu</a></small>
		</div>
		<div class="text-center" style="padding-bottom: 20px;">
			<small>Quay lại <a href="home">trang chủ</a></small>
		</div>
	</div>
	<!--
		<footer>
			<span class="text-center footer fixed-bottom bg-secondary"
				style="height: 25px;">
				<p>© 2021 | Thiết kế bởi Nguyễn Hữu Cường</p>
			</span>
		</footer>
		-->
</body>
</html>
