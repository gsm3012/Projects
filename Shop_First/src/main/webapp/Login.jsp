<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Shop_First : Log-in</title>

<%@ include file = "Link_Provider.jsp" %>
</head>
<body>

<%@ include file = "Navbar_provider.jsp" %>

<header class="header">
	<div class="container-fluid center-top m-0 p-0">
		<div class="row center-top align-items-center">	
			<div class="col-md-6 text-center">
			
				<form>
					
					<a href="Register.jsp" type="button" class="btn btn-outline-success m-2"><span class="fa fa-child"></span> Register Here!!! its free...</a>
					
					<a href="Login.jsp" type="button" class="btn btn-success m-2"><span class="fa fa-user-circle"></span> Log-in</a>
	
				</form>
				
			</div>
				
			<div class="col-md-6">
			
				<div class="card">
					<div class="card-header text-center p-2" style="background-color: #e0e0e0">
						<h3><span class="fa fa-user-circle"></span> Login</h3>
					</div>
			
					<div class="card-body">
					
						<%@ include file = "Message_Provider.jsp" %>

							<form action="LoginServlet" method="post">
								
								<div class="form-group">
									<label for="email-input">Email address</label> 
									<input type="email" class="form-control" name="user_email" id="email-input" aria-describedby="emailHelp" placeholder="Enter Your email">
									<small id="email-small" class="form-text text-muted ml-1"></small>
								</div>
								
								<div class="form-group">
									<label for="Password-input">Password</label> 
									<input type="password" name="user_password" class="form-control" id="Password-input" placeholder="Enter Your Password">
									<small id="password-small" class="form-text text-muted ml-1"></small>
								</div>
								
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="check_me" name="checkit" onclick="check()">
									<label class="form-check-label" for="check_me">Show Password</label>
								</div>
								</div>
								
							<div class="card-footer" style="background-color: #e0e0e0">
								<div>
									<button type="submit" class="btn btn-dark">Submit</button>
									<button type="reset" class="btn btn-outline-dark ml-2">Reset</button>						`
								</div>
								
							</form>

						</div>					
					</div>
				</div>			
			</div>
				
		</div>
	</div>
</header>

</body>
</html>