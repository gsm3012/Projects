package com.shop_first.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop_first.connection_provider.FactoryProvider;
import com.shop_first.dao.LoginDao;
import com.shop_first.entities.UserRegistration;


public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html"); 
		
		try 
		{
			
			
			String user_email = request.getParameter("user_email");
			String user_password = request.getParameter("user_password");
			
			LoginDao dao = new LoginDao(FactoryProvider.getFactory());
			UserRegistration user = dao.getUser(user_email, user_password);
			
			System.out.println(user.getUser_name());
			
			HttpSession session = request.getSession();
			
			if(user != null)
			{	
				session.setAttribute("currentuser", user);
				
				if(user.getUser_type().equals("admin"))
				{
					response.sendRedirect("AdminPage.jsp");
				}
				else
				{
					response.sendRedirect("HomePage.jsp");
				}
			}
			else
			{
				session.setAttribute("message", "Invalid User!!! Please Check your Email & Password.");
				response.sendRedirect("Login.jsp");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
