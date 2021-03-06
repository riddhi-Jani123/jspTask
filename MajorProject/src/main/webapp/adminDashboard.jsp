<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
			<a class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Admin</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="adminDashboard.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<li class="nav-item"><a class="nav-link" href="ViewAdmin">
					<i class="fas fa-fw fa-chart-area"></i> <span>View Profile</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider">


			<li class="nav-item"><a class="nav-link" href="editProfile.jsp">
					<i class="fas fa-fw fa-chart-area"></i> <span>Edit Profile</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider">


			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link" href="DisplayUser">
					<i class="fas fa-fw fa-table"></i> <span>View User</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider">

			<li class="nav-item"><a class="nav-link" href="register.jsp">
					<i class="fas fa-fw fa-chart-area"></i> <span>Add User</span>
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

					
				</nav>
				<!-- End of Topbar -->


				<div class="container-fluid">

					<!-- Page Heading -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div
							class="d-sm-flex align-items-center justify-content-between mb-4">
							<h1 class="h3 mb-0 text-gray-800">Welcome</h1>

						</div>
					</div>
				</div>

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