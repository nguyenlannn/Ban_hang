<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.div:hover {
	background: white;
	color: orange;
}

.div {
	padding: 5px;
}

.le {
	margin: 10px 0;
}
</style>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-warning">
	<div class="container">
		<a class="navbar-brand" href="home"><i class="bi bi-house-fill"></i><b>
				L&C</b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<c:if
					test="${sessionScope.acc!=null && sessionScope.acc.isAdmin==0 }">
					<a class="navbar-brand" data-toggle="modal"
						data-target="#exampleModal">
						<div class="div">
							<li>Quản lý tài khoản</li>
						</div>
					</a>
				</c:if>
				<c:if test="${sessionScope.acc==null}">
					<a class="navbar-brand" href="logup">
						<div class="div">
							<li>Đăng ký</li>
						</div>
					</a>
				</c:if>
				<c:if test="${sessionScope.acc==null}">
					<a class="navbar-brand" href="login">
						<div class="div">
							<li>Đăng nhập</li>
						</div>
					</a>
				</c:if>
				<c:if
					test="${sessionScope.acc!=null && sessionScope.acc.isAdmin==0}">
					<a class="navbar-brand" href="logout">
						<div class="div">
							<li>Đăng xuất</li>
						</div>
					</a>
				</c:if>

			</ul>

			<form class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input oninput="searchByName(this)" type="text"
						class="form-control">
					<div class="input-group-append bg-success">
						<div class="btn btn-number">
							<i class="bi bi-search text-white"></i>
						</div>
					</div>
				</div>
				<!--
				<a class="btn btn-success btn-sm ml-3" href="show"><i
					class="bi bi-cart-fill"></i> Giỏ hàng<span
					class="badge badge-light">3</span> </a>
					-->
			</form>
		</div>
	</div>
</nav>
<div style="width: 100%; height: 40px;"></div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-header bg-warning text-white">
				<h5 class="modal-title" id="exampleModalLabel">Xin chào
					${sessionScope.acc.taiKhoan}</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="set-account" onsubmit="return check()" method="post">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-sm-4 text-right le">
									<label for="taiKhoan">Tài khoản</label>
								</div>
								<div class="col-sm-8 le">
									<input value="${sessionScope.acc.taiKhoan }"
										class="form-control" type="text" id="taiKhoan" name="taiKhoan"
										required="required" pattern="^[a-zA-Z]+$">
								</div>
								<div class="col-sm-4 text-right le">
									<label for="email">Email</label>
								</div>
								<div class="col-sm-8 le">
									<input value="${sessionScope.acc.email}" class="form-control"
										type="email" id="email" name="email" required="required">
								</div>
								<div class="col-sm-4 text-right le">
									<lable for="diaChi">Địa chỉ</lable>
								</div>
								<div class="col-sm-8 le">
									<textarea id="diaChi" name="diaChi" class="form-control"
										required="required">${sessionScope.acc.diaChi}</textarea>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-sm-4 text-right le">
									<label for="matKhau">Mật khẩu</label>
								</div>
								<div class="col-sm-8 le">
									<input value="${sessionScope.acc.matKhau}" class="form-control"
										type="password" id="matKhau" name="matKhau"
										required="required">
								</div>
								<div class="col-sm-4 text-right le">
									<label for="xacThuc">Nhập lại mật khẩu</label>
								</div>
								<div class="col-sm-8 le">
									<input value="${sessionScope.acc.matKhau}" class="form-control"
										type="password" id="xacThuc" name="xacThuc"
										required="required"> <span class="text-danger"
										style="display: none;" id="loi"><small>Mật khẩu
											không khớp</small></span>
								</div>
								<div class="col-sm-4 text-right le">
									<label for="sdt">Số điện thoại</label>
								</div>
								<div class="col-sm-8 le">
									<input value="${sessionScope.acc.sdt}" class="form-control"
										type="text" id="sdt" name="sdt" required="required"
										pattern="^0[0-9]{9}$">
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
							var matKhau = document.getElementById("matKhau").value;
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
				<c:if test="${sessionScope.acc!=null&&sessionScope.acc.isAdmin==0}">
					<table style="width: 100%; margin-top: 30px;" class="border">
						<tr class="bg-primary text-white">
							<th class="text-center border">Mã đơn hàng</th>
							<th class="text-center border">Tên sản phẩm</th>
							<th class="text-center border">Ảnh</th>
							<th class="text-center border">Số lượng</th>
							<th class="text-center border">Tổng thanh toán</th>
							<th class="text-center border">Số điện thoại</th>
							<th class="text-center border">Địa chỉ</th>
							<th class="text-center border">Thời gian</th>
							<th class="text-center border">Trạng thái</th>
							<th class="text-center border">Xóa</th>
						</tr>
						<c:forEach items="${orderAccount}" var="o">
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
								<td class="text-center border" style="width: 8%;"><i
									class="bi bi-trash-fill text-danger" data-toggle="modal"
									data-target="#deleteO${o.ma }"></i></td>

								<!-- Xoa -->
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
												<form action="delete-order-user" method="post">
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
				</c:if>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>
<!--
<section class="jumbotron text-center">
	<div class="container">
		 <h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
		<p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn
			10 năm cung cấp các sản phầm giày nhập từ Trung Quốc</p>
	</div>
</section>
-->
<!--end of menu-->