<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<!-- CSS only -->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>L&C</title>
</head>
<style>
@-webkit-keyframes glowing {
  0% { background-color: #004A7F; -webkit-box-shadow: 0 0 3px #004A7F; }
  50% { background-color: #0094FF; -webkit-box-shadow: 0 0 10px #0094FF; }
  100% { background-color: #004A7F; -webkit-box-shadow: 0 0 3px #004A7F; }
}
 
@-moz-keyframes glowing {
  0% { background-color: #004A7F; -moz-box-shadow: 0 0 3px #004A7F; }
  50% { background-color: #0094FF; -moz-box-shadow: 0 0 10px #0094FF; }
  100% { background-color: #004A7F; -moz-box-shadow: 0 0 3px #004A7F; }
}
 
@-o-keyframes glowing {
  0% { background-color: #004A7F; box-shadow: 0 0 3px #004A7F; }
  50% { background-color: #0094FF; box-shadow: 0 0 10px #0094FF; }
  100% { background-color: #004A7F; box-shadow: 0 0 3px #004A7F; }
}
 
@keyframes glowing {
  0% { background-color: #004A7F; box-shadow: 0 0 3px #004A7F; }
  50% { background-color: #0094FF; box-shadow: 0 0 10px #0094FF; }
  100% { background-color: #004A7F; box-shadow: 0 0 3px #004A7F; }
}
 
.nhapNhay {
  -webkit-animation: glowing 1500ms infinite;
  -moz-animation: glowing 1500ms infinite;
  -o-animation: glowing 1500ms infinite;
  animation: glowing 1500ms infinite;
}
</style>
<body>

	<!-- Menu -->
	<jsp:include page="Menu.jsp"></jsp:include>
	<!--
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Category</a></li>
						<li class="breadcrumb-item active" aria-current="#">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	-->
	<div class="container">
		<div class="row">
			<!-- Left -->
			<jsp:include page="Left.jsp"></jsp:include>
			<div class="col-md-9">

				<div class="col-12">
					<div id="search" class="row"></div>
					<div class="row">
						<div class="col-12">
							<c:forEach begin="0" end="0" items="${listLaptop}" var="o">
								<c:if test="${o.theLoai==1}">
									<div style="padding: 10px" class="col-12"></div>
									<div class="col-12">
										<h1>
											<p
												style="width: 100%; text-align: center; border-bottom: 3px solid green; line-height: 0.1em; background-color: white; padding: 0 10px;">
												<span
													style="background-color: white; padding: 0 10px; color: green"><b>Laptop</b></span>
											</p>
										</h1>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<div style="padding: 10px" class="col-12"></div>
						<div class="col-12">
							<div id="laptop" class="row">
								<c:forEach items="${listLaptop}" var="o">
									<div class='laptop col-12 col-sm-6 col-lg-4'>
										<div class='card card-body'>
											<a href='detail?ma=${o.ma}&theLoai=${o.theLoai}'
												title='Xem chi tiết sản phẩm' style='color: black;'><span
									style="position: absolute;  margin-top: 25px; color: white;" class="nhapNhay">Giảm ${o.giamGia }%</span> <img
												class='img-fluid' src='${o.anh}'>
												<h5 class='card-title'>${o.ten}</h5>
											</a>
											<p class="text-center text-secondary"><del><fmt:formatNumber value = "${o.gia}" 
         type = "number"/></del><sup>đ</sup></p>
											<p class='bloc_left_price'><b><fmt:formatNumber value = "${o.gia*(100-o.giamGia)/100}" 
         type = "number"/></b><sup>đ</sup>
											</p>
										</div>
									</div>
								</c:forEach>
							</div>
							<c:forEach begin="0" end="0" items="${listLaptop}" var="o">
								<c:if test="${o.theLoai==1}">
									<span style="margin: 20px;"><p
											onclick="loadMoreLaptop()" class="text-primary text-center"
											style="font-size: 30px;">Xem thêm</p></span>
								</c:if>
							</c:forEach>
						</div>

						<div class="col-12">
							<c:forEach begin="0" end="0" items="${listCamera}" var="o">
								<c:if test="${o.theLoai==2}">
									<div class="col-12">
										<h1>
											<p
												style="width: 100%; text-align: center; border-bottom: 3px solid green; line-height: 0.1em; background-color: white; padding: 0 10px;">
												<span
													style="background-color: white; padding: 0 10px; color: green"><b>Camera</b></span>
											</p>
										</h1>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<div style="padding: 10px" class="col-12"></div>
						<div class="col-12">
							<div id="camera" class="row">
								<c:forEach items="${listCamera}" var="o">
									<div class="camera col-12 col-sm-6 col-lg-4">
										<div class="card card-body">
											<a href="detail?ma=${o.ma}&theLoai=${o.theLoai}"
												title="Xem chi tiết sản phẩm" style="color: black;"><span
									style="position: absolute;  margin-top: 25px; color: white;" class="nhapNhay">Giảm ${o.giamGia }%</span> <img
												class="img-fluid" src="${o.anh}">
												<h5 class="card-title">${o.ten}</h5>
											</a>
											<p class="text-center text-secondary"><del><fmt:formatNumber value = "${o.gia}" 
         type = "number"/></del><sup>đ</sup></p>
											<p class="bloc_left_price"><b><fmt:formatNumber value = "${o.gia*(100-o.giamGia)/100}" 
         type = "number"/></b><sup>đ</sup>
											</p>

										</div>
									</div>
								</c:forEach>
							</div>
							<c:forEach begin="0" end="0" items="${listCamera}" var="o">
								<c:if test="${o.theLoai==2}">
									<span style="margin: 20px;"><p
											onclick="loadMoreCamera()" class="text-primary text-center"
											style="font-size: 30px;">Xem thêm</p></span>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		function loadMoreLaptop() {
			var dem1 = document.getElementsByClassName("laptop").length;
			$.ajax({
				url : "/LC/loadLaptop",
				type : "get",
				data : {
					laptop : dem1
				},
				success : function(data) {
					var row1 = document.getElementById("laptop");
					row1.innerHTML += data;
				}

			});
		}
		function loadMoreCamera() {
			var dem2 = document.getElementsByClassName("camera").length;
			$.ajax({
				url : "/LC/loadCamera",
				type : "get",
				data : {
					camera : dem2
				},
				success : function(data) {
					var row2 = document.getElementById("camera");
					row2.innerHTML += data;
				}

			});
		}

		function searchByName(param) {
			var txtSearch = param.value;
			$.ajax({
				url : "/LC/search",
				type : "get",
				data : {
					txt : txtSearch
				},
				success : function(data) {
					var row3 = document.getElementById("search");
					row3.innerHTML = data;
				}

			});
		}
	</script>
</body>
</html>

