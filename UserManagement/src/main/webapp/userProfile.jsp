<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="assets/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="assets/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<!-- Nav Item - Charts -->
			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				>
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">User</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="userDashboard.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<li class="nav-item"><a class="nav-link" href="ViewAdmin?userName=user">
					<i class="fas fa-fw fa-chart-area"></i> <span>View Profile</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider">


			<li class="nav-item"><a class="nav-link" href="register.jsp?profile=user">
					<i class="fas fa-fw fa-chart-area"></i> <span>Edit Profile</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider">

			<li class="nav-item"><a class="nav-link" href="index.jsp">
					<i class="fas fa-fw fa-chart-area"></i> <span>Logout</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider">
		</ul>

		<!-- search bar -->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					User Management System
				</nav>
				<!-- End of Topbar -->


				<div class="container-fluid">

					<!-- Page Heading -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div
							class="align-items-center justify-content-between mb-4">
							<c:forEach items="${admin}" var="user">
							
							<td> 
  							<img src="data:image/png;base64, ${user.base64image }" alt="Red dot" /></td>
							<h3> First Name: </h3> 
							<h3> ${user.userFName} </h3><br><br>
							<h3> Last Name : </h3>
							<h3> ${user.userLName }</h3><br><br>
							<h3>  Email </h3>
							<h3> ${user.userEmail } </h3><br><br>
				
							<h3> Gender: </h3>
							<h3> ${user.userGender }</h3><br><br>
							<h3> Hobby:</h3>
							<h3> ${user.userHobby } </h3><br><br>
							<h3> Mobile No : </h3>
							<h3> ${user.userMobile }</h3><br><br>
							<h3> Profile </h3>
							
							</c:forEach>

							<c:forEach items="${userAddress }" var="user">
							<h3> ${user.addressType }</h3> <h3>  Address: </h3>
							<h3> ${user.sAddress }  ${user.city } ${user.state }  ${user.pincode }</h3>	
							<br>
								
							</c:forEach>
						</div>
					</div>
				</div>
				
				<footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>

				<script src="assets/vendor/jquery/jquery.min.js"></script>
				<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

				<!-- Core plugin JavaScript-->
				<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

				<!-- Custom scripts for all pages-->
				<script src="assets/js/sb-admin-2.min.js"></script>

				<!-- Page level plugins -->
				<script src="assets/vendor/chart.js/Chart.min.js"></script>

				<!-- Page level custom scripts -->
				<script src="assets/js/demo/chart-area-demo.js"></script>
				<script src="assets/js/demo/chart-pie-demo.js"></script>
</body>
</html>