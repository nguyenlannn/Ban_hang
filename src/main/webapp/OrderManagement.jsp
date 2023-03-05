<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>Quản lý đơn hàng</title>
</head>
<style>
li:hover {
	background-color: #1E75FF;
}

a:hover {
	color: white;
}
</style>

<body>
	<div class="container">
		<div class="border">
			<ul class="nav mb-2" role="tablist">
				<li class="nav-item nav-pills" role="presentation"><a
					class="nav-link active" href="management-order">Đơn hàng</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="management-laptop">Laptop</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="management-camera">Camera</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="set-account-admin">Admin</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="home">Trang chủ</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="logout">Đăng xuất</a></li>
			</ul>
			<div class="card-body">
				<p>
					Chờ xác nhận: <b>${choXacNhan }</b><br>Đang giao: <b>${dangGiao }</b><br>Thành
					công: <b>${thanhCong}</b>
				</p>
				<table style="width: 100%;" class="border">
					<tr>
						<th class="text-center border">Mã đơn hàng</th>
						<th class="text-center border">Tên sản phẩm</th>
						<th class="text-center border">Ảnh</th>
						<th class="text-center border">Số lượng</th>
						<th class="text-center border">Tổng thanh toán</th>
						<th class="text-center border">Số điện thoại</th>
						<th class="text-center border">Địa chỉ</th>
						<th class="text-center border">Thời gian</th>
						<th class="text-center border">Trạng thái</th>
						<th class="text-center border">Thao tác</th>
					</tr>
					<c:forEach items="${listOrder}" var="o">
						<tr>
							<td class="text-center border" style="width: 5%;">${o.ma}</td>
							<td class="text-center border" style="width: 15%;"><a
								href="detail?ma=${o.maSP}&theLoai=${o.theLoai}"
								title="Xem chi tiết sản phẩm" style="color: black;">${o.ten }</a></td>
							<td class="text-center border" style="width: 15%;"><a
								href="detail?ma=${o.maSP}&theLoai=${o.theLoai}"
								title="Xem chi tiết sản phẩm"><img class="img-fluid"
									src="${o.anh}"></a></td>
							<td class="text-center border" style="width: 5%;">${o.soLuong }</td>
							<td class="text-center border text-danger" style="width: 15%;"><b><fmt:formatNumber
										value="${o.gia}" type="number" /></b><sup>đ</sup></td>
							<td class="text-center border" style="width: 8%;">${o.sdt }</td>
							<td class="text-center border" style="width: 15%;">${o.diaChi }</td>
							<td class="text-center border" style="width: 8%;">${o.thoiGian }</td>
							<td class="text-center border text-white ${(o.trangThai==cxn)?"
								text-danger":(o.trangThai==dg)?
								"text-warning":"text-success" }" style="width: 8%;"><b>${o.trangThai}</b></td>
							<td class="text-center border">
								<div class="row">
									<div class="col-sm-6">
										<i class="bi bi-pencil-fill text-primary" data-toggle="modal"
											data-target="#editO${o.ma }"></i>
									</div>
									<div class="col-sm-6">
										<i class="bi bi-trash-fill text-danger" data-toggle="modal"
											data-target="#deleteO${o.ma }"></i>
									</div>
								</div>
							</td>
							<!-- Sua order -->
							<div class="modal fade" id="editO${o.ma }" data-backdrop="static"
								data-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<form action="edit-order" method="post">
											<div class="modal-header">
												<label for="cars">Trạng thái:</label> <select id="cars"
													name="trangThai" class="form-control">
													<option value="${o.trangThai }">${o.trangThai }</option>
													<option value="Chờ xác nhận">Chờ xác nhận</option>
													<option value="Đang giao">Đang giao</option>
													<option value="Thành công">Thành công</option>
												</select>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Đóng</button>
												<!-- dung post cho tang bao mat -->
												<div style="display: none;">
													<input type="text" name="ma" value="${o.ma }">
												</div>
												<button type="submit" class="btn btn-primary">Sửa</button>

											</div>
										</form>
									</div>
								</div>
							</div>


							<!-- xoa order -->
							<div class="modal fade" id="deleteO${o.ma }"
								data-backdrop="static" data-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="staticBackdropLabel">
												Có muốn xóa đơn hàng có mã <span class="bg-warning">${o.ma}</span>
												không?
											</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Không</button>
											<!-- dung post cho tang bao mat -->
											<form action="delete-order" method="post">
												<div style="display: none;">
													<input type="text" name="ma" value="${o.ma }"> <input
														type="text" name="theLoai" value="${o.theLoai }">
													<input type="text" name="maSP" value="${o.maSP }">
													<input type="text" name="soLuong" value="${o.soLuong}">
												</div>
												<button type="submit" class="btn btn-primary">Có</button>
											</form>
										</div>
									</div>
								</div>
							</div>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>