<%@page import="com.shop_first.entities.AddCatagory"%>
<%@page import="java.util.List"%>
<%@page import="com.shop_first.dao.Operations"%>
<%@page import="com.shop_first.connection_provider.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.shop_first.entities.UserRegistration"%>

<% 
	UserRegistration admin = (UserRegistration) session.getAttribute("currentuser");
	if(admin == null)
	{
		session.setAttribute("message", "Please login first...");
		response.sendRedirect("Login.jsp");
		return;
	}
	else 
	{
		if(admin.getUser_type().equals("normal"))			
		{
			session.setAttribute("message", "Your are not authoriesed user.");
			response.sendRedirect("Login.jsp");	
			return;
		}
	}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=admin.getUser_name()%> : Admin-Shop_First </title>

<%@ include file = "Link_Provider.jsp"%>

<style type="text/css">

.admin
{	
	border:1px solid gray;
}

.admin .card
{	
	border:1px solid gray;
}

.admin .card:hover
{
	background-color:#b9f6ca;
	cursor:pointer;
}


</style>
</head>
<body>

<%@ include file = "Navbar_provider.jsp"%>

<br>
<br>
<br>

<div class="container admin">
	
	<%@ include file = "Message_Provider.jsp" %>
	
	<div class="row mt-3">
		
		<div class="col-sm-4 text-center">
			
			<div class="card btn-sm">
				<div class="card-header text-uppercase text-muted">
					<h4>User</h4>
				</div>
				<div class="card-body">
					<img src="images/Others/default_profile_image.jpg" class="img-fluid rounded" style="max-width:23%" ></img>
				</div>
				<div class="card-footer text-uppercase text-muted">
					<h4>123</h4>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4 text-center">
			
			<div class="card btn-sm">
				<div class="card-header text-uppercase text-muted">
					<h4>Category</h4>
				</div>
				<div class="card-body">
					<img src="images/Others/howard.jpg" class="img-fluid rounded" style="max-width:35%"></img>
				</div>
				<div class="card-footer text-uppercase text-muted">
					<h4>5</h4>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4 text-center">
			<div class="card btn-sm">
				<div class="card-header text-uppercase text-muted">
					<h4>Products</h4>
				</div>
				<div class="card-body">
					<img src="images/Others/ian.jpg" class="img-fluid rounded" style="max-width:35%"></img>
				</div>
				<div class="card-footer text-uppercase text-muted">
					<h4>100</h4>
				</div>
			</div>
		</div>
	</div>

	<div class="row mt-3">
		
		<div class="col-sm-6 text-center">
			
			<div class="card mb-3" data-toggle="modal" data-target="#AddCatagoryModal">
				<div class="card-header text-uppercase text-muted">
					<h4>Add Catogory</h4>
				</div>
				<div class="card-body btn-sm">
					<img src="images/Others/lilly.jpg"
						class="img-fluid rounded" style="max-width: 20%"></img>
					</div>
				<div class="card-footer text-uppercase text-muted">
				</div>
			</div>
		</div>
		
		<div class="col-sm-6 text-center">
	
			<div class="card mb-3 btn-sm" data-toggle="modal" data-target="#AddProductModal">
				<div class="card-header text-uppercase text-muted">
					<h4>Add Products</h4>
				</div>
				<div class="card-body">
					<img src="images/Others/post-it.png" class="img-fluid rounded"
						style="max-width: 13%"></img>
				</div>
				<div class="card-footer text-uppercase text-muted">
				</div>
			</div>
		</div>
	</div>	
</div>
	
	
	
	
	
	<!--Catagory Modal -->

<div class="modal fade" id="AddCatagoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header bg-success text-white">
        <h5 class="modal-title" id="exampleModalLabel">Add Catagory</h5>
        <button type="button" class="close btn btn-outline-danger" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container">
        	
        	<form action="AddOperationServlet" method="post">
        	
        	<input type="hidden" name="addoperation" value="catagory"/>
        	
        	<div class="form-goup">
        		<label for="ctitle">Title</label>
        		<input type="text" class="form-control" name="cattitle" id="ctitle" placeholder="Enter Catagory Title">
        	</div>
        	
        	<div class="form-goup">
        		<label for="cdescription">Description</label>
        		<textarea class="form-control" name="catdesc" id="cdescription" placeholder="Enter Catagory Description" style="height:210px"></textarea>
        	</div>
        	<br>
        	<div class="container text-right">
		        <button type="submit" class="btn btn-outline-success mr-1">Add Catagory</button>
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        	</div>
       
        </form>
       
       </div>
      </div>
    </div>
  </div>
</div>	
	
	
	
	
	<!--Catagory Modal end -->
	
	
	<!--Product Modal -->
	
	<!-- Modal -->

<div class="modal fade" id="AddProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  
  <div class="modal-dialog modal-lg" role="document">
   
    <div class="modal-content">
    
      <div class="modal-header bg-success text-white">
        <h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
        <button type="button" class="close btn btn-outline-danger" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
        
        <div class="container">
        
        	<form action="AddOperationServlet" method="post" enctype="multipart/form-data"/>
        	
	        	<input type="hidden" name="addoperation" value="product" >
	        	
	        	<div class="form-group">
	        		<label>Name</label>
	        		<input type="text" class="form-control" name="proname" placeholder="Enter Product Name"/>
	        	</div>
	        	
	        	<div class="form-group">
	        		<label>Specification</label>
	 				<textarea class="form-control" name="prospeci" placeholder="Enter Product Specification"></textarea>
	        	</div>
	        	
	        	<% 
	        		Operations o = new Operations(FactoryProvider.getFactory());
	        		List<AddCatagory> list = o.getCatagory();
	        	%>
	        	
	        		<div class="form-group">
	        		<label>Select Catagory</label>
	        		<select class="form-control" name="proselectcat">
	        		<% 
	        			for(AddCatagory ac : list)
	        			{
	        		%>
	        		<option value="<%=ac.getCatid()%>"><%=ac.getCattitle()%></option>
	        		<% 
	        			}
	        		%>
	        		</select>
	        		</div>
	        		
	        		<div class="form-group">
	        			<label>Price</label>
	        			<input type="text" class="form-control" name="proprice" placeholder="Enter Price"/>
	        		</div>
	        		
	        		<div class="form-group">
	        			<label>Discount</label>
	        			<input type="text" class="form-control" name="prodisc" placeholder="Enter Discount"/>
	        		</div>
	        		
					<div class="form-group">
					<input type="file" name="propic"/>
					</div>
	        		
	        		<div class="container text-right">
		        		<button type="submit" class="btn btn-outline-success">Add Product</button>
		        		<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	      			</div>

     	 	</form>
        </div>      
      </div>
   
    </div>
  </div>
</div>	
		


	
	<!--Product Modal end -->
	
</body>
</html>