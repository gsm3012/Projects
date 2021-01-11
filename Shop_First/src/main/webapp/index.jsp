<%@page import="com.shop_first.connection_provider.TotalPrice"%>
<%@page import="com.shop_first.connection_provider.Cutter"%>
<%@page import="com.shop_first.entities.AddProducts"%>
<%@page import="com.shop_first.entities.AddCatagory"%>
<%@page import="java.util.List"%>
<%@page import="com.shop_first.dao.Operations"%>
<%@page import="com.shop_first.connection_provider.FactoryProvider"%>
<html>
<head>

<title>Shop_First : Index Page</title>

<%@ include file = "Link_Provider.jsp" %>

</head>

<body>

<%@ include file = "Navbar_provider.jsp" %>

<br>
<br>
<br>
<div class="container-fluid">
	<div class="row">	
		<div class="col text-right">
			
			<form>
				<a href="Register.jsp" type="button" class="btn btn-success m-2"><span class="fa fa-child"></span> Register Here!!! its free...</a>
					
				<a href="Login.jsp" type="button" class="btn btn-success m-2"><span class="fa fa-user-circle fa-spin"></span> Log-in</a>
	
			</form>
				
		</div>		
	</div>
</div>

<% 
	String catid = request.getParameter("catagoryname");

	Operations op = new Operations(FactoryProvider.getFactory());
	List <AddProducts> prolist = null;
	
	if(catid == null || catid.trim().equals("All"))
	{
		prolist = op.getProducts();
	}
	else
	{
		int cat = Integer.parseInt(catid.trim());
		prolist = op.getProductsById(cat);
	}
	
	List <AddCatagory> catlist = op.getCatagory();
%>

<div class="Container-fluid">
	<div class="row mx-2">
	</div>
	<br>
	<div class="row mx-2">
		
		<ul class="group-item">
			<li><a onclick="abc(this)" id="c-link" class="list-group-item active" href="index.jsp?catagoryname=All">All Catagory</a></li>
		<% 	
			for(AddCatagory ac : catlist)
			{
		%>
				<li><a onclick="abc(this)" id="c-link" class="list-group-item" href="index.jsp?catagoryname=<%=ac.getCatid()%>"><%=ac.getCattitle()%></a>
				</li>
		<%
			}
		%>
		</ul>
	</div>
	<hr>
</div>

<div class="Container">

	<div class="row">
	<% 
		if(prolist.size() == 0)
		{
	%>
	<div class="container text-center mt-4 text-danger">
		<h3>No Data Found</h3>
	</div>
	<%} %>
	
		<div class="col">
			
			<%
				for(AddProducts pro : prolist)
				{ 
			%>
			
			<div class="card mr-3 mb-3">
				<div class="card-header">
					<h6><%=pro.getPname()%></h6>
				</div>
				
				<div class="card-body">
					<img class="card-img-top" src="src/images/Products/<%=pro.getPpicnmae()%>" alt="Card image cap">
					<h6><%=pro.getPpicnmae()%></h6>
					<h6><%=Cutter.getTenWords(pro.getPspec())%></h6>
					<button class="btn btn-outline-primary btn-sm">Read More...</button>
				</div>
				<div class="card-footer">
					<div class="row">
					<div class="col">
						<h6 class="text-primary"> Price : &#8377; <%=pro.getPprice()%></h6>
						<h6 class="text-primary"> Discount : <%=pro.getPdicount()%>%</h6>					
					</div>
					<div class="col">
						<div class="container text-right">
							<h6 class="text-success"> Final Price : &#8377; <%=TotalPrice.getTotalPrice(pro.getPprice(), pro.getPdicount())%></h6>
							<button class="btn btn-primary btn-sm greenover" onclick="add_cart(<%=pro.getPid()%>,'<%=pro.getPname()%>',<%=TotalPrice.getTotalPrice(pro.getPprice(), pro.getPdicount())%>)">Add to chart</button>
						</div>
					</div>
					</div>
				</div>
			</div>
			<% 	
				}
			%>
		
		</div>
	</div>
</div>

<%@ include file = "CartModal.jsp" %>

</body>
</html>
