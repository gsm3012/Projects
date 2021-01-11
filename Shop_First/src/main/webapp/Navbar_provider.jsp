<%@page import="com.shop_first.entities.UserRegistration"%>
<%
	UserRegistration adminuser = (UserRegistration) session.getAttribute("currentuser");
%>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-success btn-sm">
	<% 
    	if(adminuser == null)
    	{
    %>
  <a class=" btn btn-light btn-sm" href="index.jsp">Return</a>
  <% 
  		}	
    	else
    	{
   %>
    <div>
    	<a class="btn btn-light btn-sm" href="LogoutServlet">Logout</a>
    </div>
   <% 
    	}
   %> 
   
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li> 
    
    	<span><i class="fa fa-cart-plus fa-2x text-white ml-5 cart-count cart" data-toggle="modal" data-target="#cartModal"></i></span>
    
    </ul>
      
     <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2 btn-sm" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-light my-2 my-sm-0 btn-sm" type="submit">Search</button>
    </form>
  </div>
</nav>