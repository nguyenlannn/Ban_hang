<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi-VN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title>Admin</title>
</head>
<style>
li:hover {
	background-color: #1E75FF;
}

a:hover {
	color: white;
}

.margin {
	margin-bottom: 10px;
	margin-top: 10px;
}
</style>

<body>
	<c:if test="${loi==1 }">
		<script type="text/javascript">
			alert("Tài khoản bị trùng hoặc sai mật khẩu")
		</script>
	</c:if>
	<div class="container">
		<div class="border">
			<ul class="nav mb-2" role="tablist">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="management-order">Đơn hàng</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="management-laptop">Laptop</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="management-camera">Camera</a></li>
				<li class="nav-item nav-pills" role="presentation"><a
					class="nav-link active" href="set-account-admin">Admin</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="home">Trang chủ</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="logout">Đăng xuất</a></li>
			</ul>
			<div class="card-body card">
				<form action="set-account-admin" onsubmit="return check()"
					method="post">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-sm-4 text-right le margin">
									<label for="taiKhoan">Tài khoản</label>
								</div>
								<div class="col-sm-8 le margin">
									<input value="${sessionScope.acc.taiKhoan }"
										class="form-control" type="text" id="taiKhoan" name="taiKhoan"
										required="required" pattern="^[a-zA-Z]+$">
								</div>
								<div class="col-sm-4 text-right le margin">
									<label for="email">Email</label>
								</div>
								<div class="col-sm-8 le margin">
									<input value="${sessionScope.acc.email}" class="form-control"
										type="email" id="email" name="email" required="required">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-sm-4 text-right le margin">
									<label for="matKhauCu">Mật khẩu cũ</label>
								</div>
								<div class="col-sm-8 le margin">
									<input class="form-control" type="password" id="matKhauCu"
										name="matKhauCu" required="required">
								</div>
								<div class="col-sm-4 text-right le margin">
									<label for="matKhauMoi">Mật khẩu mới</label>
								</div>
								<div class="col-sm-8 le margin">
									<input class="form-control" type="password" id="matKhauMoi"
										name="matKhauMoi" required="required">
								</div>
								<div class="col-sm-4 text-right le margin">
									<label for="xacThuc">Nhập lại mật khẩu</label>
								</div>
								<div class="col-sm-8 le margin">
									<input class="form-control" type="password" id="xacThuc"
										name="xacThuc" required="required"> <span
										class="text-danger" style="display: none;" id="loi"><small>Mật
											khẩu không khớp</small></span>
								</div>
							</div>
						</div>
						<div class="col-2 le" style="margin: auto;">
							<input type="submit" value="Cập nhật" class="btn btn-success"
								id="sua" style="width: 100%;">
						</div>
					</div>
					<script type="text/javascript">
						function check() {
							var matKhau = document.getElementById("matKhauMoi").value;
							var xacThuc = document.getElementById("xacThuc").value;
							if (matKhau != xacThuc) {
								document.getElementById("loi").style.display = "block";
								return false;
							} else {
								document.getElementById("loi").style.display = "none";
								return true;
							}
						}
					</script>
				</form>
			</div>
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