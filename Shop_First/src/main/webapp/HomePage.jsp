<%@page import="com.shop_first.entities.UserRegistration"%>

<%
	UserRegistration user = (UserRegistration) session.getAttribute("currentuser");
	if(user == null)
	{
		session.setAttribute("message", "Please login First");
		response.sendRedirect("Login.jsp");
		return;
	}
	else 
	{
		if(user.getUser_type().equals("admin"))
		{
			session.setAttribute("message", "login as User");
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
<title>Shop_First : Home Page<%=user.getUser_name() %></title>

<%@ include file = "Link_Provider.jsp" %>

</head>
<body>

<%@ include file = "Navbar_provider.jsp" %>
<br>
<br>
<br>

<h3>Home Page</h3>

</body>
</html>