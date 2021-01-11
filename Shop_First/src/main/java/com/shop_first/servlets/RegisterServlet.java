package com.shop_first.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shop_first.connection_provider.FactoryProvider;
import com.shop_first.entities.UserRegistration;

public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		String user_mobile = request.getParameter("user_mobile");
		String user_gender = request.getParameter("user_gender");
		String user_check = request.getParameter("user_check");
		
		try
		{
			if(user_gender==null)
			{
				HttpSession httpses = request.getSession();
				
				httpses.setAttribute("message", "Please Select Gender !!!");
				
				response.sendRedirect("Register.jsp");
			}
			else if(user_check==null)
			{
				HttpSession httpses = request.getSession();
				
				httpses.setAttribute("message", "Please Accept the Terms & Condiotions !!!");
				
				response.sendRedirect("Register.jsp");
			}	
			else
			{

				UserRegistration user = new UserRegistration(user_name, user_email, user_password, user_mobile, user_gender, "normal");
				
				SessionFactory fact = FactoryProvider.getFactory();
				
				Session ses = fact.openSession();
				
				ses.beginTransaction();
				
				int user_id = (Integer) ses.save(user);
				
				ses.getTransaction().commit();
				
				ses.close();
				
				if(user_id != 0)
				{
					HttpSession httpses = request.getSession();
								
					httpses.setAttribute("message", "Successfully Register.");
					
					response.sendRedirect("Register.jsp");
				}
				else
				{
					HttpSession httpses = request.getSession();
										
					httpses.setAttribute("message", "Oops !!! Something wents wrong...");
					
					response.sendRedirect("Register.jsp");
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
