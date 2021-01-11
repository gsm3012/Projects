package com.shop_first.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		try 
		{
			HttpSession sesi = request.getSession();
			sesi.removeAttribute("currentuser");
			
			sesi.setAttribute("message", "Successfully Logout !!!");
			
			response.sendRedirect("Login.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
