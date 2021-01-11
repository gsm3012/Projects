package com.shop_first.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shop_first.entities.AddCatagory;
import com.shop_first.entities.AddProducts;

public class Operations 
{
	private SessionFactory factory;

	public Operations(SessionFactory factory) 
	{
		super();
		this.factory = factory;
	}
	
	public int addCatagory(AddCatagory ac)
	{
		
		Session ses = this.factory.openSession();
		
		ses.beginTransaction();
		
		int catid = (int) ses.save(ac);
		
		ses.getTransaction().commit();
		
		ses.close();
		
		return catid;
	}
	
	public List <AddCatagory> getCatagory()
	{
		Session ses = this.factory.openSession();
		
		Query query = ses.createQuery("from AddCatagory");
		
		List<AddCatagory> list = query.list();
		
		ses.close();
		
		return list;
	}
	
	public AddCatagory getKey(int cid)
	{
		AddCatagory addcid = null;
		
		try 
		{
			Session s = this.factory.openSession();
			
			addcid = s.get(AddCatagory.class, cid);
			
			s.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		
		return addcid;
	}
	
	public boolean addProduct(AddProducts ap) 
	{
		boolean isSave = false;
		
		try 
		{	
			Session ses = this.factory.openSession();
			
			ses.beginTransaction();
			
			ses.save(ap);
			
			ses.getTransaction().commit();
			
			ses.close();
			
			isSave = true;
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			isSave = false;
		}
		
		return isSave;
	}

	public List<AddProducts> getProducts() throws Exception
	{
		Session s= this.factory.openSession();
		
		s.beginTransaction();
		
		Query q = s.createQuery("from AddProducts");
		
		List<AddProducts>list = q.list();
		
		s.getTransaction().commit();
		
		s.close();
		
		return list;
	}

	public List<AddProducts> getProductsById(int cat)
	{
		List <AddProducts> aps = null;
		
		try 
		{	
			Session s = this.factory.openSession();
			
			Query q = s.createQuery("from AddProducts where catagory.catid =: id");
			
			q.setParameter("id", cat);
			
			aps = q.list();
			
			s.close();			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return aps;
	}

}
