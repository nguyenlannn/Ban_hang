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
<title>Quản lý sản phẩm</title>
</head>
<style>
.li:hover {
	background-color: #1E75FF;
}

.a:hover {
	color: white;
}

label {
	font-weight: bold;
}
</style>

<body>
	<div class="container">
		<div class="border">
			<ul class="nav mb-3" role="tablist">
				<li class="nav-item li" role="presentation"><a
					class="nav-link a active" href="management-order">Đơn hàng</a></li>
				<c:forEach items="${listCategory }" var="o">
					<li class="nav-item li ${tag==o.ten?"
						nav-pills":"" }" role="presentation"><a
						class="nav-link active a" href="${o.ma==1?"management-laptop":"management-camera"}">${o.ten }</a></li>
				</c:forEach>
				<li class="nav-item li" role="presentation"><a
					class="nav-link a active" href="set-account-admin">Admin</a></li>
				<li class="nav-item li" role="presentation"><a
					class="nav-link a active" href="home">Trang chủ</a></li>
				<li class="nav-item li" role="presentation"><a
					class="nav-link a active" href="logout">Đăng xuất</a></li>
			</ul>
			<div class="card-body">
				<div class="text-right">
					<button class="btn btn-success" data-toggle="modal"
						data-target="#add${tag}">
						<i class="bi bi-plus-circle"></i> Thêm sản phẩm
					</button>
				</div>

				<p>
					Tổng số laptop: <b>${sumL}</b>
				</p>
				<p>
					Tổng số camera: <b>${sumC}</b>
				</p>
				<div style="float: right; margin-bottom: 10px;">
					<form action="search-admin" method="get"
						class="form-inline my-2 my-lg-0">
						<div class="input-group input-group-sm">
							<input type="text" name="txt" value="${txt }"
								class="form-control">
							<div class="input-group-append bg-success">
							
									<button class="btn btn-number" type="submit">
										<i class="bi bi-search text-white"></i>
									</button>
								
							</div>
						</div>
					</form>
				</div>
				<!-- Them latop -->
				<div class="modal fade" id="addLaptop" data-backdrop="static"
					data-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Thêm
									laptop</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form action="add-laptop" method="post">
								<div class="modal-body">
									<label for="ten">Tên laptop:</label> <input type="text"
										name="ten" id="ten" required="required" class="form-control">
									<label for="anh">Ảnh:</label> <input type="text" name="anh"
										id="anh" required="required" class="form-control"> <label
										for="gia">Giá gốc:</label> <input type="number" value="0"
										name="gia" id="gia" min="0" class="form-control"><label
										for="giamGia">Giảm giá ... %:</label> <input type="number"
										value="0" min="0" max="100" name="giamGia" id="giamGia"
										class="form-control"> <label for="soLuong">Số
										lượng:</label> <input type="number" value="0" min="0" name="soLuong"
										id="soLuong" class="form-control"> <label
										for="dongMay">Dòng máy:</label> <select id="dongMay"
										name="dongMay" class="form-control">
										<option value="Gaming">Gaming</option>
										<option value="Học tập - Văn phòng">Học tập - Văn
											phòng</option>
										<option value="Cao cấp - Sang trọng">Cao cấp - Sang
											trọng</option>
										<option value="Kỹ thuật - Đồ họa">Kỹ thuật - Đồ họa</option>
									</select> <label for="thuongHieu">Thương hiệu:</label> <select
										id="thuongHieu" name="thuongHieu" class="form-control">
										<option value="Asus">Asus</option>
										<option value="LG">LG</option>
										<option value="Acer">Acer</option>
										<option value="Apple">Apple</option>
										<option value="Dell">Dell</option>
										<option value="HP">HP</option>
										<option value="Nenovo">Nenovo</option>
										<option value="Microsoft">Microsoft</option>
										<option value="MSI">MSI</option>
										<option value="Xiaomi">Xiaomi</option>
									</select> <label for="baoHanh">Bảo hành ... tháng:</label> <input
										type="number" id="baoHanh" name="baoHanh" value="12" min="0"
										class="form-control"> <label for="tieuDe">Tiêu
										đề:</label> <input type="text" name="tieuDe" id="tieuDe"
										class="form-control"> <label for="chip">CPU:</label> <input
										type="text" name="chip" id="chip" class="form-control">
									<label for="manHinh">Màn hình:</label> <input type="text"
										name="manHinh" id="manHinh" class="form-control"> <label
										for="ram">Ram:</label> <input type="text" name="ram" id="ram"
										class="form-control"> <label for="oCung">Ổ
										cứng:</label> <input type="text" name="oCung" id="oCung"
										class="form-control"> <label for="cardDoHoa">Card
										đồ họa:</label> <input type="text" name="cardDoHoa" id="cardDoHoa"
										class="form-control"> <label for="webcam">Webcam:</label>
									<input type="text" name="webcam" id="webcam"
										class="form-control"> <label for="ketNoiKhongDay">Kết
										nối không dây:</label> <input type="text" name="ketNoiKhongDay"
										id="ketNoiKhongDay" class="form-control"> <label
										for="congGiaoTiep">Cổng giao tiếp:</label> <input type="text"
										name="congGiaoTiep" id="congGiaoTiep" class="form-control">
									<label for="pin">Pin:</label> <input type="text" name="pin"
										id="pin" class="form-control"> <label for="trongLuong">Trọng
										lượng:</label> <input type="text" name="trongLuong" id="trongLuong"
										class="form-control"> <label for="chatLieu">Chất
										liệu:</label> <input type="text" name="chatLieu" id="chatLieu"
										class="form-control"> <label for="mauSac">Màu
										sắc:</label> <input type="text" name="mauSac" id="mauSac"
										class="form-control">
									<div style="display: none;">
										<input type="text" name="theLoai" value="1">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Đóng</button>
									<button type="submit" class="btn btn-primary">Thêm</button>
								</div>
							</form>
						</div>
					</div>
				</div>

				<!-- Them Camera -->
				<div class="modal fade" id="addCamera" data-backdrop="static"
					data-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Thêm
									Camera</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form action="add-camera" method="post">
								<div class="modal-body">
									<label for="ten">Tên camera:</label> <input type="text"
										name="ten" id="ten" required="required" class="form-control">
									<label for="anh">Ảnh:</label> <input type="text" name="anh"
										id="anh" required="required" class="form-control"><label
										for="gia">Giá gốc:</label> <input type="number" value="0"
										name="gia" id="gia" min="0" class="form-control"><label
										for="giamGia">Giảm giá ... %:</label> <input type="number"
										value="0" min="0" max="100" name="giamGia" id="giamGia"
										class="form-control"> <label for="soLuong">Số
										lượng:</label> <input type="number" value="0" min="0" name="soLuong"
										id="soLuong" class="form-control"> <label
										for="noiLapDat">Nơi lắp đặt:</label> <select id="noiLapDat"
										name="noiLapDat" class="form-control">
										<option value="Trong nhà">Trong nhà</option>
										<option value="Ngoài trời">Ngoài trời</option>
									</select> <label for="thuongHieu">Thương hiệu:</label> <select
										id="thuongHieu" name="thuongHieu" class="form-control">
										<option value="Tp-Link">Tp-Link</option>
										<option value="Xiaomi">Xiaomi</option>
										<option value="IMOU">IMOU</option>
										<option value="Dahua">Dahua</option>
										<option value="Hikvision">Hikvision</option>
										<option value="Ezviz">Ezviz</option>
										<option value="Kbone">Kbone</option>
										<option value="KBvision">KBvision</option>
										<option value="Yoosee">Yoosee</option>
										<option value="CareCam">CareCam</option>
										<option value="Vantech">Vantech</option>
										<option value="Ebitcam">Ebitcam</option>
										<option value="Hilook">Hilook</option>
									</select> <label for="baoHanh">Bảo hành ... tháng:</label> <input
										type="number" id="baoHanh" name="baoHanh" value="12" min="0"
										class="form-control"><label for="tieuDe">Tiêu
										đề:</label> <input type="text" name="tieuDe" id="tieuDe"
										class="form-control"> <label for="camBienAnh">Cảm
										biến ảnh:</label> <input type="text" name="camBienAnh" id="camBienAnh"
										class="form-control"> <label for="doPhanGiai">Độ
										phân giải:</label> <input type="text" name="doPhanGiai"
										id="doPhanGiai" class="form-control"> <label
										for="ongKinh">Ống kính:</label> <input type="text"
										name="ongKinh" id="ongKinh" class="form-control"> <label
										for="gocNhin">Góc nhìn:</label> <input type="text"
										name="gocNhin" id="gocNhin" class="form-control"> <label
										for="chuanNenVideo">Chuẩn nén video:</label> <input
										type="text" name="chuanNenVideo" id="chuanNenVideo"
										class="form-control"> <label for="camBien">Cảm
										biến:</label> <input type="text" name="camBien" id="camBien"
										class="form-control"> <label for="luuTru">Lưu
										trữ:</label> <input type="text" name="luuTru" id="luuTru"
										class="form-control"> <label for="ketNoi">Kết
										nối:</label> <input type="text" name="ketNoi" id="ketNoi"
										class="form-control"> <label for="nguonDien">Nguồn
										điện:</label> <input type="text" name="nguonDien" id="nguonDien"
										class="form-control"> <label for="hongNgoaiTamNhin">Hồng
										ngoại tầm nhìn:</label> <input type="text" name="hongNgoaiTamNhin"
										id="hongNgoaiTamNhin" class="form-control"> <label
										for="trongLuong">Trọng lượng:</label> <input type="text"
										name="trongLuong" id="trongLuong" class="form-control">
									<label for="nhietDoHoatDong">Nhiệt độ hoạt động:</label> <input
										type="text" name="nhietDoHoatDong" id="nhietDoHoatDong"
										class="form-control"> <label for="xuatXu">Xuất
										xứ:</label> <input type="text" name="xuatXu" id="xuatXu"
										class="form-control">
									<div style="display: none;">
										<input type="text" name="theLoai" value="2">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Đóng</button>
									<button type="submit" class="btn btn-primary">Thêm</button>
								</div>
							</form>
						</div>
					</div>
				</div>

				<table style="width: 100%;" class="border">
					<tr>
						<th class="border text-center">Mã sản phẩm</th>
						<th class="border text-center">Tên sản phẩm</th>
						<th class="border text-center">Ảnh</th>
						<th class="border text-center">Giá</th>
						<th class="border text-center">Số lượng</th>
						<th class="border text-center">Thao tác</th>
					</tr>
					<c:forEach items="${listLaptop}" var="o">
						<tr>
							<td class="border text-center" style="width: 10%;">${o.ma }</td>

							<td class="border text-center" style="width: 30%;"><a
								href="detail?ma=${o.ma }&theLoai=1" style="color: black">${o.ten }</a></td>
							<td class="border text-center" style="width: 30%;"><a
								href="detail?ma=${o.ma }&theLoai=1"><img class="img-fluid"
									src="${o.anh}"> </a></td>
							<td class="border text-center text-danger" style="width: 10%;"><b><fmt:formatNumber
										value="${o.gia*(100-o.giamGia)/100}" type="number" /></b><sup>đ</sup></td>
							<td class="border text-center" style="width: 10%;">${o.soLuong}</td>
							<td class="border text-center" style="width: 10%;">
								<div class="row">
									<div class="col-sm-6 text-center text-primary">
										<i data-toggle="modal" data-target="#editL${o.ma}"
											class="bi bi-pencil-fill"></i>
									</div>
									<div class="col-sm-6 text-center text-danger">
										<i data-toggle="modal" data-target="#deleteL${o.ma}"
											class="bi bi-trash-fill"></i>
									</div>
								</div>
							</td>
							<!-- Sua latop -->
							<div class="modal fade" id="editL${o.ma}" data-backdrop="static"
								data-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="staticBackdropLabel">Chỉnh
												sửa laptop</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<form action="edit-laptop" method="post">
											<div class="modal-body">
												<label for="ten">Tên laptop:</label> <input value="${o.ten}"
													type="text" name="ten" id="ten" required="required"
													class="form-control"> <label for="anh">Ảnh:</label>
												<input value="${o.anh}" type="text" name="anh" id="anh"
													required="required" class="form-control"><label
													for="gia">Giá gốc:</label> <input type="number"
													value="${o.gia }" name="gia" id="gia" min="0"
													class="form-control"><label for="giamGia">Giảm
													giá ... %:</label> <input type="number" value="${o.giamGia }"
													min="0" max="100" name="giamGia" id="giamGia"
													class="form-control"> <label for="soLuong">Số
													lượng:</label> <input type="number" value="${o.soLuong }" min="0"
													name="soLuong" id="soLuong" class="form-control"> <label
													for="dongMay">Dòng máy:</label> <select id="dongMay"
													name="dongMay" class="form-control">
													<option value="${o.dongMay }">${o.dongMay }</option>
													<option value="Gaming">Gaming</option>
													<option value="Học tập - Văn phòng">Học tập - Văn
														phòng</option>
													<option value="Cao cấp - Sang trọng">Cao cấp -
														Sang trọng</option>
													<option value="Kỹ thuật - Đồ họa">Kỹ thuật - Đồ
														họa</option>
												</select> <label for="thuongHieu">Thương hiệu:</label> <select
													id="thuongHieu" name="thuongHieu" class="form-control">
													<option value="${o.thuongHieu }">${o.thuongHieu }</option>
													<option value="Asus">Asus</option>
													<option value="LG">LG</option>
													<option value="Acer">Acer</option>
													<option value="Apple">Apple</option>
													<option value="Dell">Dell</option>
													<option value="HP">HP</option>
													<option value="Nenovo">Nenovo</option>
													<option value="Microsoft">Microsoft</option>
													<option value="MSI">MSI</option>
													<option value="Xiaomi">Xiaomi</option>
												</select> <label for="baoHanh">Bảo hành ... tháng:</label> <input
													type="number" id="baoHanh" name="baoHanh"
													value="${o.baoHanh }" min="0" class="form-control">
												<label for="tieuDe">Tiêu đề:</label> <input
													value="${o.tieuDe}" type="text" name="tieuDe" id="tieuDe"
													class="form-control"> <label for="chip">CPU:</label>
												<input value="${o.chip}" type="text" name="chip" id="chip"
													class="form-control"> <label for="manHinh">Màn
													hình:</label> <input value="${o.manHinh}" type="text"
													name="manHinh" id="manHinh" class="form-control"> <label
													for="ram">Ram:</label> <input value="${o.ram}" type="text"
													name="ram" id="ram" class="form-control"> <label
													for="oCung">Ổ cứng:</label> <input value="${o.oCung}"
													type="text" name="oCung" id="oCung" class="form-control">
												<label for="cardDoHoa">Card đồ họa:</label> <input
													value="${o.cardDoHoa}" type="text" name="cardDoHoa"
													id="cardDoHoa" class="form-control"> <label
													for="webcam">Webcam:</label> <input value="${o.webcam}"
													type="text" name="webcam" id="webcam" class="form-control">
												<label for="ketNoiKhongDay">Kết nối không dây:</label> <input
													value="${o.ketNoiKhongDay}" type="text"
													name="ketNoiKhongDay" id="ketNoiKhongDay"
													class="form-control"> <label for="congGiaoTiep">Cổng
													giao tiếp:</label> <input value="${o.congGiaoTiep}" type="text"
													name="congGiaoTiep" id="congGiaoTiep" class="form-control">
												<label for="pin">Pin:</label> <input value="${o.pin}"
													type="text" name="pin" id="pin" class="form-control">
												<label for="trongLuong">Trọng lượng:</label> <input
													value="${o.trongLuong}" type="text" name="trongLuong"
													id="trongLuong" class="form-control"> <label
													for="chatLieu">Chất liệu:</label> <input
													value="${o.chatLieu}" type="text" name="chatLieu"
													id="chatLieu" class="form-control"> <label
													for="mauSac">Màu sắc:</label> <input value="${o.mauSac}"
													type="text" name="mauSac" id="mauSac" class="form-control">
												<div style="display: none;">
													<input type="text" name="theLoai" value="1">
												</div>
												<div style="display: none;">
													<input type="text" name="ma" value="${o.ma}">
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Đóng</button>
												<button type="submit" class="btn btn-primary">Sửa</button>
											</div>
										</form>
									</div>
								</div>
							</div>

							<!-- xoa latop -->
							<div class="modal fade" id="deleteL${o.ma }"
								data-backdrop="static" data-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="staticBackdropLabel">
												Có muốn xóa latop có mã <span class="bg-warning">${o.ma}</span>
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
											<form action="delete-laptop" method="post">
												<div style="display: none;">
													<input type="text" name="ma" value="${o.ma }">
												</div>
												<button type="submit" class="btn btn-primary">Có</button>
											</form>
										</div>
									</div>
								</div>
							</div>

						</tr>
					</c:forEach>
					<c:forEach items="${listCamera}" var="o">
						<tr>
							<td class="border text-center" style="width: 10%;">${o.ma }</td>

							<td class="border text-center" style="width: 30%;"><a
								href="detail?ma=${o.ma }&theLoai=2" style="color: black">${o.ten }</a></td>
							<td class="border text-center" style="width: 30%;"><a
								href="detail?ma=${o.ma }&theLoai=2"><img class="img-fluid"
									src="${o.anh}"></a></td>


							<td class="border text-center text-danger" style="width: 10%;"><b><fmt:formatNumber
										value="${o.gia*(100-o.giamGia)/100}" type="number" /></b><sup>đ</sup></td>
							<td class="border text-center" style="width: 10%;">${o.soLuong}</td>
							<td class="border text-center" style="width: 10%;">
								<div class="row">
									<div class="col-sm-6 text-center text-primary">
										<i data-toggle="modal" data-target="#editC${o.ma}"
											class="bi bi-pencil-fill"></i>
									</div>
									<div class="col-sm-6 text-center text-danger">
										<i data-toggle="modal" data-target="#deleteC${o.ma}"
											class="bi bi-trash-fill"></i>
									</div>
								</div>
							</td>
							<!-- Sua camera -->
							<div class="modal fade" id="editC${o.ma}" data-backdrop="static"
								data-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="staticBackdropLabel">Chỉnh
												sửa camera</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<form action="edit-camera" method="post">
											<div class="modal-body">
												<label for="ten">Tên camera:</label> <input value="${o.ten}"
													type="text" name="ten" id="ten" required="required"
													class="form-control"> <label for="anh">Ảnh:</label>
												<input value="${o.anh}" type="text" name="anh" id="anh"
													required="required" class="form-control"><label
													for="gia">Giá gốc:</label> <input type="number"
													value="${o.gia }" name="gia" id="gia" min="0"
													class="form-control"><label for="giamGia">Giảm
													giá ... %:</label> <input type="number" value="${o.giamGia }"
													min="0" max="100" name="giamGia" id="giamGia"
													class="form-control"> <label for="soLuong">Số
													lượng:</label> <input type="number" value="${o.soLuong }" min="0"
													name="soLuong" id="soLuong" class="form-control"> <label
													for="noiLapDat">Nơi lắp đặt:</label> <select id="noiLapDat"
													name="noiLapDat" class="form-control">
													<option value="${o.noiLapDat }">${o.noiLapDat }</option>
													<option value="Trong nhà">Trong nhà</option>
													<option value="Ngoài trời">Ngoài trời</option>
												</select> <label for="thuongHieu">Thương hiệu:</label> <select
													id="thuongHieu" name="thuongHieu" class="form-control">
													<option value="${o.thuongHieu }">${o.thuongHieu }</option>
													<option value="Tp-Link">Tp-Link</option>
													<option value="Xiaomi">Xiaomi</option>
													<option value="Imou">Imou</option>
													<option value="Dahua">Dahua</option>
													<option value="Hikvision">Hikvision</option>
													<option value="Ezviz">Ezviz</option>
													<option value="Kbone">Kbone</option>
													<option value="KBvision">KBvision</option>
													<option value="Yoosee">Yoosee</option>
													<option value="CareCam">CareCam</option>
													<option value="Vantech">Vantech</option>
													<option value="Ebitcam">Ebitcam</option>
													<option value="Hilook">Hilook</option>
												</select> <label for="baoHanh">Bảo hành ... tháng:</label> <input
													type="number" id="baoHanh" name="baoHanh"
													value="${o.baoHanh }" min="0" class="form-control"><label
													for="tieuDe">Tiêu đề:</label> <input value="${o.tieuDe}"
													type="text" name="tieuDe" id="tieuDe" class="form-control">
												<label for="camBienAnh">Cảm biến ảnh:</label> <input
													value="${o.camBienAnh}" type="text" name="camBienAnh"
													id="camBienAnh" class="form-control"> <label
													for="doPhanGiai">Độ phân giải:</label> <input
													value="${o.doPhanGiai}" type="text" name="doPhanGiai"
													id="doPhanGiai" class="form-control"> <label
													for="ongKinh">Ống kính:</label> <input value="${o.ongKinh}"
													type="text" name="ongKinh" id="ongKinh"
													class="form-control"> <label for="gocNhin">Góc
													nhìn:</label> <input value="${o.gocNhin}" type="text"
													name="gocNhin" id="gocNhin" class="form-control"> <label
													for="chuanNenVideo">Chuẩn nén video:</label> <input
													value="${o.chuanNenVideo}" type="text" name="chuanNenVideo"
													id="chuanNenVideo" class="form-control"> <label
													for="camBien">Cảm biến:</label> <input value="${o.camBien}"
													type="text" name="camBien" id="camBien"
													class="form-control"> <label for="luuTru">Lưu
													trữ:</label> <input value="${o.luuTru}" type="text" name="luuTru"
													id="luuTru" class="form-control"> <label
													for="ketNoi">Kết nối:</label> <input value="${o.ketNoi}"
													type="text" name="ketNoi" id="ketNoi" class="form-control">
												<label for="nguonDien">Nguồn điện:</label> <input
													value="${o.nguonDien}" type="text" name="nguonDien"
													id="nguonDien" class="form-control"> <label
													for="hongNgoaiTamNhin">Hồng ngoại tầm nhìn:</label> <input
													value="${o.hongNgoaiTamNhin}" type="text"
													name="hongNgoaiTamNhin" id="hongNgoaiTamNhin"
													class="form-control"> <label for="trongLuong">Trọng
													lượng:</label> <input value="${o.trongLuong}" type="text"
													name="trongLuong" id="trongLuong" class="form-control">
												<label for="nhietDoHoatDong">Nhiệt độ hoạt động:</label> <input
													value="${o.nhietDoHoatDong}" type="text"
													name="nhietDoHoatDong" id="nhietDoHoatDong"
													class="form-control"> <label for="xuatXu">Xuất
													xứ:</label> <input value="${o.xuatXu}" type="text" name="xuatXu"
													id="xuatXu" class="form-control">

												<div style="display: none;">
													<input type="text" name="theLoai" value="2">
												</div>
												<div style="display: none;">
													<input type="text" name="ma" value="${o.ma}">
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Đóng</button>
												<button type="submit" class="btn btn-primary">Sửa</button>
											</div>
										</form>
									</div>
								</div>
							</div>

							<!-- xoa camera -->
							<div class="modal fade" id="deleteC${o.ma }"
								data-backdrop="static" data-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="staticBackdropLabel">
												Có muốn xóa camera có mã <span class="bg-warning">${o.ma}</span>
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
											<form action="delete-camera" method="post">
												<div style="display: none;">
													<input type="text" name="ma" value="${o.ma }">
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