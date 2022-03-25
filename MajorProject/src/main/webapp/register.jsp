<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home Page</title>

<!-- Custom fonts for this template-->
<link href="assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="assets/css/sb-admin-2.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	
	$(".add_item").click(function(e){
		/* alert("hello"); */
		
		
		e.preventDefault();
		$("#show_item").append(`
				<div id="rm">
				<div class="form-group row">
					<div class="col-sm-6 mb-3 mb-sm-0">
						<input type="text" class="form-control form-control-user"
							name="address" placeholder="Enter street address">
					</div>
					<div class="col-sm-6">
						<input type="text" name="pin"
							class="form-control form-control-user"
							placeholder="Enter pincode">
					</div>
					<div class="col-sm-6 mb-3 mb-sm-0 pt-2">
						<select name="city" id="isTitles">
							<option value="" selected="selected" hidden="hidden">Choose
								city</option>
							<option value="ahmedabad">ahmedabad</option>
							<option value="gandhinagar">gandhinagar</option>
							<option value="rajkot">rajkot</option>
						</select>
					</div>
					<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
						<select name="state" id="isTitles">
							<option value="" selected="selected" hidden="hidden">Choose
								state</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="uttar Pradesh">uttar Pradesh</option>
						</select>
					</div>
					<div class="col-sm-6 mb-3 mb-sm-0  pl-2 pt-2">
					
							<button class="btn btn-danger btn-user btn-block remove_item" id="remove"> remove</button>
					</div>
				</div>
			</div>
				
					`);
		$(".remove_item").click(function(e){
			
			e.preventDefault();
			let row_item = $(this).parent().parent();
			$(row_item).remove();
		
		}) 
		

	})
	
	
	
})
</script>

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-12">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
							</div>
							<form class="user" method="post" action="Register"
								enctype="multipart/form-data">

								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" name="fname" placeholder="First Name">
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" name="lname" placeholder="Last Name">
									</div>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										id="exampleInputEmail" name="email"
										placeholder="Email Address">
								</div>
								<div class="form-group">

									<input type="tel" class="form-control form-control-user"
										id="mNo" name="mNo" placeholder="mobile no">

								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											id="exampleInputPassword" name="pass" placeholder="Password">
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											id="exampleRepeatPassword" name="cpass"
											placeholder="Confirm Password">
									</div>
								</div>
								<%-- <div class="col-sm-6 mb-3 mb-sm-0 pt-2">
										
												<select name="relation" >
													<option value="" selected="selected" hidden="hidden">Choose
														relative</option>
													<option > </option>
													
												</select>
											</div> --%>
								<div id="show_item"
									style="bborder: 1px solid #d1d3e2; padding: 10px; border-radius: 2px;">

									<div id="rm">
										<div class="form-group row">
											<div class="col-sm-6 mb-3 mb-sm-0">
												<input type="text" class="form-control form-control-user"
													name="address" placeholder="Enter street address">
											</div>
											<div class="col-sm-6">
												<input type="text" name="pin"
													class="form-control form-control-user"
													placeholder="Enter pincode">
											</div>
											<div class="col-sm-6 mb-3 mb-sm-0 pt-2">
												<select name="city" id="isTitles">
													<option value="" selected="selected" hidden="hidden">Choose
														city</option>
													<option value="ahmedabad">ahmedabad</option>
													<option value="gandhinagar">gandhinagar</option>
													<option value="rajkot">rajkot</option>
												</select>
											</div>
											<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
												<select name="state" id="isTitles">
													<option value="" selected="selected" hidden="hidden">Choose
														state</option>
													<option value="Gujarat">Gujarat</option>
													<option value="Maharashtra">Maharashtra</option>
													<option value="uttar Pradesh">uttar Pradesh</option>
												</select>
											</div>
											<div class="col-sm-6 mb-3 mb-sm-0  pl-2 pt-2">
												<button class="btn btn-user btn-primary btn-block add_item"
													id="add">add</button>
													
											</div>
										</div>
									</div>
								</div>


								<input type="radio" value="female" name="gender"> <label>
									Female</label> <input type="radio" value="male" name="gender">
								<label> Male</label>
								<!--  <label>Hobbies</label> <input
									type="checkbox" id="sing" value="singing" name="checked">
								<label> singing</label> <input type="checkbox" id="read"
									value="reading" name="checked"> <label> reading</label> -->

								<!-- <div class="form-group">
									<label>Photo:</label> <input type="file" id="img" name="image">

								</div>-->
								
								<input type="submit" class="btn btn-primary btn-user btn-block"
									value="Register Account" />
								<hr>

								<div class="text-center">
									<a class="small" href="index.jsp">Already have an account?
										Login!</a>
								</div>
								</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	

	<!-- Bootstrap core JavaScript-->
	<!-- <script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	Core plugin JavaScript
	<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	Custom scripts for all pages
	<script src="assets/js/sb-admin-2.min.js"></script>

	Page level plugins
	<script src="assets/vendor/chart.js/Chart.min.js"></script>

	Page level custom scripts
	<script src="assets/js/demo/chart-area-demo.js"></script>
	<script src="assets/js/demo/chart-pie-demo.js"></script> -->

	<!-- <script type="text/javascript" >
		
		document.getElementById("add").addEventListener("click", function(e) {
	
			e.preventDefault();
	  let div = document.getElementById("show_item");
	  var elem = document.createElement("div");
	
				elem.innerHTML += `<input type="text" class="form-control form-control-user"
				placeholder="Enter street address">  <input type="text"
					class="form-control form-control-user"
					placeholder="Enter street address">
					
				<select name=city id="isTitles">
				 <option value="" selected="selected" hidden="hidden">Choose city</option>
				 <option value="amd">ahmedabad</option>
		 		<option value="gandhinagar">gandhinagar</option>
		 		<option value="rajkot">rajkot</option>
				</select>
				<select name=state id="isTitles">
				 <option value="" selected="selected" hidden="hidden">Choose state</option>
				 <option value="amd">Gujarat</option>
		 		<option value="gandhinagar">Maharashtra</option>
		 		<option value="rajkot">uttar Pradesh</option>
				</select>
				<input type="text" class="form-control form-control-user"
					placeholder="Enter pincode"> 
					<button class="remove_item" id="remove"> remove</button>`;

			div.append(elem);
			
		})
		const boxes = document.querySelectorAll('.remove_item');

boxes.forEach(box => {
  box.addEventListener('click', function (event) {
	  event.preventDefault();
		this.closest().remove();
  });
});
 -->



</body>

</html>
</body>
</html>