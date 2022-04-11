
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Forgot Password</title>

<style>

label.error {
	color: red;
	font-size: 1rem;
	width: 100%;
}

.email-err{

color:red;
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



$(document).ready(function(){
	
	
	
	$("#exampleInputEmail").on('change', function(){
		 
		
		var id = $(this).val();
		
		if(id==""){
			
			$(".email-err").html("email is required");
		}
		else(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(id)))
		  {
		   
			$(".email-err").html("Please provide valid email address");
		  }
		 
	});
	
$('#exampleInputPassword').on('change',function(){
	
	var id = $(this).val();
	
	if(id==""){
		
		$(".pass-err").html("password is required");
	}
	else if (id.length>=8)
	
	  {
	   
		$(".pass-err").html("Password should be atleast 8 character");
	  }
	 



})

$('#exampleRepeatPassword').on('change',function(){
	
	var id = $(this).val();
	var pId = $('#exampleInputPassword').val();
	
	if(id === pId){
		
		$(".cpass-err").html("password and confirm password must be same");
	}
	
	 
})

	
/* $("#form-validate").validate(

		 {
			    rules: {
			    	
			     email: {
				        required: true,
				        email: true
				      },
				 
				      password:{
					  required: true,
					  minlength: 8
					
					  
				  },
				  cpass:{
					  
					  required:true,
					  equalTo: '[name="password"]'
				  }
			    },
			    messages : {
			    	
			      email: {
			    	  required:"Email  is required", 
				       email: "The email should be in the format: abc@domain.tld"
				      
			      },
			      
			      password:{
			    	  required:"Password is required", 
			    	  minlegth:"Password should be atleast 8 character"
			      },
			      
			      cpass:{
			    	  
			    	  required:"Confirm Password is required", 
			    	  equalTo:"Password and Confirm Password must be same "
			      }
			    }
				
			    });  
 */	
});

</script>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                          
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">Forgot Your Password?</h1>
                                       
                                    </div>
                                    <form class="user" method="post" action="ForgotPass" id="form-validate">
                                        <div class="form-group">
                                            <input type="email" name="email" class="form-control form-control-user"
                                                id="exampleInputEmail" aria-describedby="emailHelp"
                                                placeholder="Email Address...">
                                                <span class="email-err"> </span>
                                          </div>
                                            <div class="form-group">     
                                                  <input type="password" class="form-control form-control-user" name="password"
                                                id="exampleInputPassword"
                                                placeholder="New Password...">
                                                </div>
                                                 <div class="form-group">
                                                  <input type="password" class="form-control form-control-user" name="cpass"
                                                id="exampleRepeatPassword" 
                                                placeholder="Confirm Password...">
                                                <span class=".cpass-err"></span>
                                                </div>
                                        
                                        <input type="submit" class="btn btn-primary btn-user btn-block" value="Reset Password">
                                          
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="getUserName">Create an Account!</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="index.jsp">Already have an account? Login!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
<script src="assets/vendor/jquery/jquery.min.js"> </script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="assets/js/sb-admin-2.min.js"></script>
</body>

</html>