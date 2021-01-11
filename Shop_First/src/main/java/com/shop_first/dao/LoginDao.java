package com.shop_first.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shop_first.entities.UserRegistration;

public class LoginDao 
{
	private SessionFactory factory;
	
	public LoginDao(SessionFactory factory) 
	{
		this.factory = factory;
	}

	public UserRegistration getUser(String email, String password) 
	{
		
		UserRegistration user = null;
		
		try 
		{
			String query = "from UserRegistration where user_email=:e and user_password=:p";
			
			Session ses = this.factory.openSession();
			
			Query q = ses.createQuery(query);
			
			q.setParameter("e", email);
			q.setParameter("p", password);
			
			user = (UserRegistration) q.uniqueResult();
			
			ses.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return user;
	}
	
}
