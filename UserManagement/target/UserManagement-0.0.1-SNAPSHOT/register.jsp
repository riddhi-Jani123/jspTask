<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.User"%>
<%@ page import="model.Address"%>
<% 
response.setContentType("text/html");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma","no-cache"); 
%>
<% String userId = (String) session.getAttribute("uId"); 
	

%>
<% User userInfo = (User) session.getAttribute("userInfo");  
	
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:choose>
					         
      <c:when test = "${sessionScope.userList!= null }">  
      <c:set var="home" value="${requestScope.home}" scope="session"/>
      <c:set var="fname" value="${sessionScope.firstName}" scope="session"/>
      <c:set var="lname" value="${sessionScope.lastName}" scope="session"/>
      <c:set var="email" value="${sessionScope.email}" scope="session"/>
      <c:set var="gender" value="${sessionScope.gender }" scope="session"/>
	  <c:set var="hobby" value="${sessionScope.hobbies }" scope="session"/>


<c:set var="pass" value="${sessionScope.pass}" scope="session"/>
<c:set var="mobile" value="${sessionScope.mobile}" scope="session"/>

<c:choose>

<c:when  test = "${fname!=null}">
	<c:set var="fname" value="${fname}" scope="request"/>
</c:when>
<c:when  test = "${lname!=null}">
	<c:set var="lname" value="${lname}" scope="session"/>
</c:when>
<c:when  test = "${email!=null}">
	<c:set var="email" value="${email}" scope="session"/>
</c:when>

<c:when  test = "${pass!=null}">
	<c:set var="pass" value="${pass}" scope="session"/>
</c:when>

<c:when  test = "${mobile!=null}">
	<c:set var="mobile" value="${mobile}" scope="session"/>
</c:when>

<c:when  test = "${gender!=null}">
	<c:set var="gender" value="${gender}" scope="session"/>
</c:when>

<c:when  test = "${hobby!=null}">
	<c:set var="hobby" value="${hobby}" scope="session"/>
</c:when>
</c:choose>
</c:when>
</c:choose>

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

<style>
label.error {
	color: red;
	font-size: 1rem;
	width: 100%;
}

#rm[] {
	margin: 5px;
	padding: 5px;
	border: 1px solid #d1d3e2;
	border-radius: 2px;
	paddin: 5px;
}

form.user .form-control-user {
	width: 100%;
}

.validate-error {
	color: red;
}

#email-check{

color:black;
}

</style>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"> </script>
	
<script>



function checkEmail(){

	 var email=document.getElementById("exampleInputEmail").value;

	if(email !=''){
		$.ajax({
			url:"Register",
			type:"get",
			data: {
				user_email:email,
			},
			success : function(response){
				
				
				if(response == "true"){
					
					$("#email-check").html("Email is already exist");
					
					$("#email-check").css("color","red");
				
					 $("#submit").prop('disabled', true);
				}
				else {
				
					$("#email-check").html("");
					 $("#submit").prop('disabled', false);
				}
			}
		});
	}
}



function previewImage(input){
    var file = $("input[type=file]").get(0).files[0];

    if(file){
        var reader = new FileReader();

        reader.onload = function(){
            $("#previewImg").attr("src", reader.result).height(200).width(200);;
        }

        reader.readAsDataURL(file);
    }
} 

$(document).ready(function(){


	$(".add_item").click(function(e){

		e.preventDefault();
		
		console.log("in add");
		
		$("#show_item").append(`
				
				<div id="rm[]" name="limit[]" >
				<div class="form-group row">
				<input type="hidden"
					class="address form-control form-control-user"
					name="addressId[]" placeholder="Enter street address"
					value="${address.addressId }" >
					<div class="col-sm-6 mb-3 mb-sm-0">
						<input type="text" class="address form-control form-control-user"
							name="address[]" id="address[]" placeholder="Enter street address"  id="add" >
						<span class="err"> </span>
					</div>
					<div class="col-sm-6">
						<input type="text" name="pin[]"
							class="form-control form-control-user"
							placeholder="Enter pincode">
					</div>
					<div class="col-sm-6 mb-3 mb-sm-0 pt-2">
						<select name="city[]" >
							<option value="" selected="selected" hidden="hidden">Choose
								city</option> 
							<option value="ahmedabad">ahmedabad</option>
							<option value="gandhinagar">gandhinagar</option>
							<option value="rajkot">rajkot</option>
						</select>
					</div>
					<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
						<select name="state[]" >
							<option value="" selected="selected" hidden="hidden">Choose
								state</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="uttar Pradesh">uttar Pradesh</option>
						</select>
					</div>
					<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
						<select name="addressType[]" >
							<option value="" selected="selected" hidden="hidden">Choose
								address</option> 
							 <c:choose>
					         
					         <c:when test = "${home != true}">
					         <option value="Home">Home</option>
					        
					         </c:when>
					         
					         
					      </c:choose>
					      
							
							<option value="Office">Office</option>
							<option value="Temporary">Temporary</option>
						</select>
					</div>
					
					<div class="col-sm-6 mb-3 mb-sm-0  pl-2 pt-2">
					
							<button class="btn btn-danger btn-user btn-block remove_item" id="remove"> remove</button>
					</div>
				</div>
			</div>`);
		
		
	
	})
	
	$(document).on('click', '.remove_item', function () {
		let row_item = $(this).parent().parent();
		$(row_item).remove();
        });
	
	  $("#user").change(function(){
		    
		
		  var id = $(this).children("option:selected").val();
		  
		  window.location.href = 'getUserName?userId='+id;
		  
		  
		  }); 
	
	
	
	$("#form-validate").validate(

			 {
			
				 
				    rules: {
				    	firstName : {
				        required: true,
				        minlength: 3
				      },
				    lname:{
				    	  required: true,
				    	  minlength: 3
				      } ,
				     email: {
					        required: true,
					        email: true
					      },
					  mNo:{
					    	  
				    	  required: true,
				    	  number: true,
				    	  minlength:10,
				    	  maxlength:10
					  
					  } ,
					  pass:{
						  required: true,
						  minlength: 8
						
						  
					  },
					  cpass:{
						  
						  required:true,
						  equalTo: '[name="pass"]'
					  },
					  
					  gender:{
						  
						  required:true
					  },
					
					  checked:{
						  
						  required:true
					  }
					  /*  $("[id^=address]"):{
						  
						  required:true;
					  } */ 
				    },
				    messages : {
				    	firstName: {
				    		required:"First Name is required", 
				    		
				        minlength: "First Name should be at least 3 characters"
				      },
				       lname:{
				    	   required:"Last Name is required", 
				    	  minlength: "Last Name should be at least 3 characters"
				      } ,
				      
				      email: {
				    	  required:"Email  is required", 
					       email: "The email should be in the format: abc@domain.tld"
					      
				      },
				      mNo:{
				    	  required:"Mobile Number is required", 
				    	  number:"Please enter valid mobile number"
				    	 
				    	  
				      } ,
				      pass:{
				    	  required:"Password is required", 
				    	  minlegth:"Password should be atleast 8 character"
				      },
				      
				      cpass:{
				    	  
				    	  required:"Confirm Password is required", 
				    	  equalTo:"Password and Confirm Password must be same "
				      }
				    }
					
				    });  
	
	/* $('form').find('#address').each(function() {
	    $(this).rules('add', {
	        required: true
	        messages: {
	            required: "Required input"
	        }
	    });
	}); */
	/* $("form[id^=address]").each(function() {
	    $(this).validate();
	});

	// the following method must come AFTER .validate()
	$('form').find('.myclass').each(function() {
	    $(this).rules('add', {
	        required: true,
	        digits: true, // just another example rule
	        messages: {
	            required: "Required input",
	            digits: "Please only enter digits"
	        }
	    });
	});
	 */
	 
				    	 
});
	 
</script>

</head>

<body class="bg-gradient-primary">
<c:set var="goesInto" value="${param.goesInto }" scope="request" />
<c:set var="profilee" value="${goesInto }" scope="session" />
	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-12">
						<div class="p-5">
						
							<c:set var="profile" value="${param.profile }" scope="request" />

							<c:choose>

								<c:when test="${profile == 'user'}">
									<c:set var="action" value="updateData" />
									<c:set var="heading" value="Update Profile" />
									<c:set var="submit" value="Update" />

								</c:when>
								
								
								<c:otherwise>

									<c:set var="heading" value="Create an Account!" />
									<c:set var="action" value="Register" />
									<c:set var="submit" value="Register Account" />
								</c:otherwise>
							</c:choose>
							
							
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">${heading}</h1>
							</div>

							<form class="user" method="post" action="${action }" 
								id="form-validate" enctype="multipart/form-data">

								<c:choose>

								<c:when test="${profile == 'user'}">
																
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">

										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" name="firstName"
											placeholder="First Name" value="${userInfo.userFName}">



										<span class="validate-error"> ${message.fname}</span>



									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" name="lname"
											value="${userInfo.userLName}" placeholder="Last Name">
										<span> ${message.lname}</span>

									</div>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										id="exampleInputEmail" name="email" 
										value="${userInfo.userEmail}" placeholder="Email Address" readonly>
										<span id="email-check"> </span>
									<span> ${message.email}</span>

								</div>
								<div class="form-group">

									<input type="tel" class="form-control form-control-user"
										id="mNo" name="mNo" placeholder="mobile no"
										value="${userInfo.userMobile }"> <span>
										${message.mNo}</span>


								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										
												<input type="password"
													class="form-control form-control-user"
													id="exampleInputPassword" name="pass"
													placeholder="Password" value="${userInfo.userPass}"
													readonly>
												<span> ${message.pass}</span>

									
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											id="exampleRepeatPassword" name="cpass"
											value="${userInfo.userPass}" placeholder="Confirm Password" readonly>
										<span> ${message.cpass}</span>

									</div>
								</div>


								<c:set var="count" value="0" scope="page" />
								<c:forEach items="${addr}" var="address">
									<div id="show_item" 
										style="bborder: 1px solid #d1d3e2; padding: 10px; border-radius: 2px;">
										
										<c:set var="count" value="${count + 1}" scope="page"/>
										<div id="rm[]" name="limit[]" class="add${count}">
											<div class="form-group row">
											
											<input type="hidden"
																class="address form-control form-control-user"
																name="addressId[]" id="address[]" placeholder="Enter street address"
																value="${address.addressId }">
											
												<div class="col-sm-6 mb-3 mb-sm-0">

															<input type="text"
																class="address form-control form-control-user" 
																name="address[]" id="address[]" placeholder="Enter street address"
																value="${address.sAddress }">
														

												</div>
												<div class="col-sm-6">
                                         
													
															<input type="text" name="pin[]"
																class="form-control form-control-user"
																placeholder="Enter pincode" value="${ address.pincode }">
														
 

												</div>
												<div class="col-sm-6 mb-3 mb-sm-0 pt-2">
													<select name="city[]">
													

														
														<option value="" ${address.city  eq '' ? 'selected' : ''}>choose
															city</option>
														<option value="gandhinagar"
															${address.city  eq 'gandhinagar' ? 'selected' : ''}>
															gandhinagar</option>
														<option value="ahmedabad"
															${address.city  eq 'ahmedabad' ? 'selected' : ''}>ahmedabad</option>

														<option value="rajkot"
															${address.city  eq 'rajkot' ? 'selected' : ''}>rajkot</option>



													</select>
												</div>
												<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
													<select name="state[]">

														
														<option value="" ${address.state  eq '' ? 'selected' : ''}>choose
															state</option>
														<option value="Gujarat"
															${address.state  eq 'Gujarat' ? 'selected' : ''}>Gujarat</option>
														<option value="Maharashtra"
															${address.state  eq 'Maharashtra' ? 'selected' : ''}>Maharashtra</option>
														<option value="uttar Pradesh"
															${address.state  eq 'uttar Pradesh' ? 'selected' : ''}>uttar
															Pradesh</option>


													</select>
												</div>
												<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
													<select name="addressType[]">

														<option value="${address.addressType }">${address.addressType }</option>

													</select>
												</div>

											</div>
											<div class="col-sm-6 mb-3 mb-sm-0  pl-2 pt-2">
					
							<button class="btn btn-danger btn-user btn-block remove_item" id="remove"> remove</button>
					</div>
										</div>
									</div>
									

								</c:forEach>
								<div class="col-sm-6 mb-3 mb-sm-0  pl-2 pt-2">
									<button class="btn btn-user btn-primary btn-block add_item"
										id="add">add</button>

								</div>
									
								

								<label> Female</label> <input type="radio" value="female"
									name="gender"
									${userInfo.userGender  == 'female' ? 'checked' : ''}> <br>
								<label> Male</label><input type="radio" value="male"
									name="gender"
									${userInfo.userGender   == 'male' ? 'checked' : ''}> <br>
								<label>Hobbies</label> <br> <label> singing</label> <input
									type="checkbox" id="sing" value="singing" name="checked">
								<br> <label> reading</label><input type="checkbox"
									id="read" value="reading" name="checked">



								<div class="form-group">
									<label>Photo:</label> <input type="file" name="image"
										onchange="previewImage()"> <br> <img
										id="previewImg"
										src="data:image/png;base64, ${userInfo.base64image }"
										alt="Red dot" /> <br>

								</div>



								</c:when>
								<c:otherwise>
								
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">

										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" name="firstName"
											placeholder="First Name" value="${fname}">



										<span class="validate-error"> ${message.fname}</span>



									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" name="lname"
											value="${lname}" placeholder="Last Name">
										<span> ${message.lname}</span>

									</div>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										id="exampleInputEmail" name="email"
										value="${email}" placeholder="Email Address"  onkeyup="checkEmail()">
										<span id="email-check"> </span>
									<span> ${message.email}</span>

								</div>
								<div class="form-group">

									<input type="tel" class="form-control form-control-user"
										id="mNo" name="mNo" placeholder="mobile no"
										value="${mobile}"> <span>
										${message.mNo}</span>


								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										
												<input type="password"
													class="form-control form-control-user"
													id="exampleInputPassword" name="pass"
													placeholder="Password" value="${pass}">
												<span> ${message.pass}</span>
											

									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											id="exampleRepeatPassword" name="cpass"
											value="${cpass}" placeholder="Confirm Password">
										<span> ${message.cpass}</span>

									</div>
								</div>



								<div class="col-sm-6 mb-3 mb-sm-0 pt-2">

									<select name="relation" id="user">
										<c:forEach items="${users}" var="user">
											<option value="" selected="selected" hidden="hidden">Choose
												relative</option>
											<option id="${user.userId}" name="id" value="${user.userId}">

												${user.userFName }</option>

										</c:forEach>
									</select>
								</div>

								
								<div id="show_item" 
										style="bborder: 1px solid #d1d3e2; padding: 10px; border-radius: 2px;">
								<c:forEach items="${addr}" var="address">
								<c:set var="count" value="${count + 1}" scope="page"/>
									

										<div id="rm[]" name="limit[]" >
											<div class="form-group row">
												<div class="col-sm-6 mb-3 mb-sm-0">

													
															<input type="text"
																class="address form-control form-control-user" id="add" 
																name="address[]" placeholder="Enter street address"
																value="${address.sAddress }" id="address[]"  readonly>

														

												</div>
												<div class="col-sm-6">

													
															<input type="text" name="pin[]"
																class="form-control form-control-user"
																placeholder="Enter pincode" value="${address.pincode }"
																readonly>

														

												</div>
												<div class="col-sm-6 mb-3 mb-sm-0 pt-2">
													<select name="city[]">

														<option value="${address.city }">${address.city }</option>
														
														
														


													</select>
												</div>
												<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
													<select name="state[]">

													<option value="${address.state }">${address.state }</option> 
														

													</select>
												</div>
												<div class="col-sm-6 mb-3 mb-sm-0  pt-2">
													<select name="addressType[]">

														<option value="${address.addressType }">${address.addressType }</option>

													</select>
												</div>

											</div>
										</div>
									</div>
</c:forEach>
								
	</div>
	<div class="col-sm-6 mb-3 mb-sm-0  pl-2 pt-2">
									<button class="btn btn-user btn-primary btn-block add_item"
										id="add">add</button>
	

								<label> Female</label> <input type="radio" value="female"
									name="gender"
									${gender == 'female' ? 'checked' : ''}> <br>
								<label> Male</label><input type="radio" value="male"
									name="gender"
									${gender  == 'male' ? 'checked' : ''}> <br>
								<label>Hobbies</label> <br> <label> singing</label> <input
									type="checkbox" id="sing" value="singing" name="checked">
								<br> <label> reading</label><input type="checkbox"
									id="read" value="reading" name="checked">



								<div class="form-group">
									<label>Photo:</label> <input type="file" name="image"
										onchange="previewImage()"> <br> <img
										id="previewImg"
										src=""
										 /> <br>

								</div>

								
								</c:otherwise>
								
						
								</c:choose>
								<input type="submit" id="submit"
											class="btn btn-primary btn-user btn-block" value="${submit }" />

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


</body>

</html>
</body>
</html>