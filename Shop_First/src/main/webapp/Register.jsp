<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Shop_First : User Register</title>

<%@ include file = "Link_Provider.jsp" %>
</head>
<body>

<%@ include file = "Navbar_provider.jsp" %>
	<br>
	<br>
	<br>


<header class="header">
	<div class="container-fluid center-top m-0 p-0">
		<div class="row center-top align-items-center">	
			<div class="col-md-6 text-center">
			
				<form>
					
					<a href="Register.jsp" type="button" class="btn btn-success m-2"><span class="fa fa-child"></span> Register Here!!! its free...</a>
					
					<a href="Login.jsp" type="button" class="btn btn-outline-success m-2"><span class="fa fa-user-circle"></span> Log-in</a>
	
				</form>
				
			</div>
				
			<div class="col-md-5 offset-md-1">
			
				<div class="card">
					<div class="card-header text-center p-2" style="background-color: #e0e0e0">
						<h3><span class="fa fa-child"></span> &nbsp Register Here !!! </h3>
					</div>
			
					<div class="card-body">
						
						<%@ include file = "Message_Provider.jsp" %>
						
							<form action="RegisterServlet" method="post" onsubmit="return validation()" novalidate>
							
								<div class="form-group">
									<label for="name-input">Name</label> 
									<input type="text" class="form-control btn-sm" name="user_name" id="name_input" aria-describedby="emailHelp" placeholder="Enter Your Name">
									<small id="name-small" class="form-text ml-1"></small>
								</div>
								
								<div class="form-group">
									<label for="email-input">Email address</label> 
									<input type="email" class="form-control btn-sm" name="user_email" id="email-input" aria-describedby="emailHelp" placeholder="Enter Your email">
									<small id="email-small" class="form-text ml-1"></small>
								</div>
								
								<div class="form-group">
									<label for="Password-input">Password</label> 
									<input type="password" name="user_password" class="form-control btn-sm pass" id="password-input" placeholder="Enter Your Password">
									<small id="password-small" class="form-text ml-1 pass-small"></small>
								</div>
								
								<div class="form-group">
									<label for="conf_Paaword-input">Confirm Password</label> 
									<input type="Password" class="form-control btn-sm" name="user_conf_password" id="conf_password_input" aria-describedby="emailHelp" placeholder="Confirm Your Password">
									<small id="confirm_password-small" class="form-text ml-1"></small>
								</div>
								
								<div class="form-group">
									<label for="mobile-input">Mobile</label> 
									<input type="text" class="form-control btn-sm" name="user_mobile" id="mobilel_input" aria-describedby="emailHelp" placeholder="Enter Your Mobile">
									<small id="mobile-small" class="form-text ml-1"></small>
								</div>
								
									<div class="custom-control custom-radio custom-control-inline">
	  									<input type="radio" id="radio_input1" name="user_gender" class="custom-control-input" value="female">
										<label class="custom-control-label" for="radio_input1">Female</label>
									</div>
									<div class="custom-control custom-radio custom-control-inline">
										<input type="radio" id="radio_input2" name="user_gender" class="custom-control-input" value="male">
										<label class="custom-control-label" for="radio_input2">Male</label>
									</div>
									<div class="custom-control custom-radio custom-control-inline">
										<input type="radio" id="radio_input3" name="user_gender" class="custom-control-input" value="others">
										<label class="custom-control-label" for="radio_input3">Others</label>
									</div>
								<br>
								<br>							
								
								<div class="form-check">
									<input type="checkbox" name="user_check" class="form-check-input" id="check_input"> <label class="form-check-label" for="exampleCheck1">Accept Terms & Conditions</label>
									<small id="check-small" class="form-text ml-1"></small>
								</div>
									
									<button type="submit" class="btn btn-dark btn-sm">Submit</button>
									<button type="reset" class="btn btn-outline-dark btn-sm ml-2">Reset</button>						`
								
							</form>
					</div>
				</div>			
			</div>
				
		</div>
	</div>
</header>

</body>
</html>