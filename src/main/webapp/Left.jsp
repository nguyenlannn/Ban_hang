<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.liii {
	color: green;
}

.lii:hover {
	background: Green;
	color: white;
}

#message {
	font-size: 60px;
	margin-right: 20px;
	margin-bottom: 20px;
	color: DodgerBlue;
}

#message:hover {
	color: white;
	text-shadow: 1px 1px 2px DodgerBlue, 0 0 30px DodgerBlue, 0 0 5px
		DodgerBlue;
}
</style>
<div class="col-md-3">
	<nav class="card mb-3">
		<!--
		<a href="home" class="navbar-brand">
			<div class="card-header text-white text-uppercase"
				style="background: Green;">
				<i class="bi bi-list-ul"></i>
			</div>
		</a>
		-->
		<div class="footer fixed-bottom text-right">
			<a href="https://m.me/107689588227826" target="_blank"> <i id="message" class="bi bi-messenger"></i></a>
		</div>
		<ul class="list-group">
			<!-- danh muc san pham-->
			<c:forEach items="${listCategary}" var="o">
				<a href="category?cid=${o.ma}" class="navbar-brand">
					<li class="list-group-item lii liii text-center"
					style="color:${tag==o.ma?"
					white":""}; background-color: ${tag==o.ma?"green":"" };"><b>${o.ten}</b></li>
				</a>
			</c:forEach>

		</ul>

	</nav>
	<!-- san pham noi bat -->
	<div class="card mb-3">
		<div class="card-header text-white text-uppercase bg-warning">
			<b>Laptop bán chạy</b>
		</div>
		<div class="card-body">
			<a href="detail?ma=${topLaptop.ma}&theLoai=${topLaptop.theLoai}"
				title="Xem chi tiết sản phẩm" style="color: black;"><span
				style="position: absolute; margin-top: 25px; color: white;"
				class="nhapNhay">Giảm ${topLaptop.giamGia }%</span> <img
				class="img-fluid" src="${topLaptop.anh}">
				<h5 class="card-title">${topLaptop.ten}</h5> </a>
			<p class="card-text">${topLaptop.tieuDe}</p>
			<p class="text-center text-secondary">
				<del>
					<fmt:formatNumber value="${topLaptop.gia}" type="number" />
				</del>
				<sup>đ</sup>
			</p>
			<p class="bloc_left_price">
				<b><fmt:formatNumber
						value="${topLaptop.gia*(100-topLaptop.giamGia)/100}" type="number" /></b><sup>đ</sup>
			</p>
			<!--
			<a href="#" class="btn btn-success btn-block"><i
				class="bi bi-cart-plus-fill"></i> Thêm vào giỏ hàng</a>
			<div style="padding: 15px;"></div>
			-->
		</div>
	</div>
	<div class="card mb-3">
		<div class="card-header text-white text-uppercase bg-warning">
			<b>Camera bán chạy</b>
		</div>
		<div class="card-body">
			<a href="detail?ma=${topCamera.ma}&theLoai=${topCamera.theLoai}"
				title="Xem chi tiết sản phẩm" style="color: black;"><span
				style="position: absolute; margin-top: 25px; color: white;"
				class="nhapNhay">Giảm ${topCamera.giamGia }%</span> <img
				class="img-fluid" src="${topCamera.anh}">
				<h5 class="card-title">${topCamera.ten}</h5> </a>
			<p class="card-text">${topCamera.tieuDe}</p>
			<p class="text-center text-secondary">
				<del>
					<fmt:formatNumber value="${topCamera.gia}" type="number" />
				</del>
				<sup>đ</sup>
			</p>
			<p class="bloc_left_price">
				<b><fmt:formatNumber
						value="${topCamera.gia*(100-topCamera.giamGia)/100}" type="number" /></b><sup>đ</sup>
			</p>
			<!--
			<a href="#" class="btn btn-success btn-block"><i
				class="bi bi-cart-plus-fill"></i> Thêm vào giỏ hàng</a>
			<div style="padding: 15px;"></div>
			-->
		</div>
	</div>
</div>