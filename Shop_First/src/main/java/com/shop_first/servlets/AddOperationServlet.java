package com.shop_first.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shop_first.connection_provider.FactoryProvider;
import com.shop_first.connection_provider.ImageSave;
import com.shop_first.dao.Operations;
import com.shop_first.entities.AddCatagory;
import com.shop_first.entities.AddProducts;

@MultipartConfig
public class AddOperationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		try 
		{
			String operation = request.getParameter("addoperation");
						
			if(operation.trim().equals("catagory"))
			{
				
				String ctitle = request.getParameter("cattitle");
				String cdesc = request.getParameter("catdesc");

				if(ctitle != "" || cdesc != "")
				{
				
					AddCatagory addcat = new AddCatagory();
					addcat.setCattitle(ctitle);
					addcat.setCatdescription(cdesc);
				
					Operations operations = new Operations(FactoryProvider.getFactory());
					int catid = operations.addCatagory(addcat);
					
					HttpSession s = request.getSession();
					s.setAttribute("message", "Added Successfully");
					response.sendRedirect("AdminPage.jsp");
				}
				else
				{
					HttpSession s = request.getSession();
					s.setAttribute("message", "Dont Enter a blank Values");
					response.sendRedirect("AdminPage.jsp");
				}
			}
			
			else if(operation.trim().equals("product"))
			{
				
				String name = request.getParameter("proname");
				String specification = request.getParameter("prospeci");
				int price = Integer.parseInt(request.getParameter("proprice"));
				int discount = Integer.parseInt(request.getParameter("prodisc"));
				
				Part pic = request.getPart("propic");
			    String picname = pic.getSubmittedFileName();						
				
				int catid = Integer.parseInt(request.getParameter("proselectcat"));
				Operations op = new Operations(FactoryProvider.getFactory());
				AddCatagory pcid = op.getKey(catid);
				
				AddProducts ap = new AddProducts();
				ap.setPname(name);
				ap.setPspec(specification);
				ap.setPprice(price);
				ap.setPdicount(discount);
				ap.setPpicnmae(picname);
				ap.setCatagory(pcid);
				
				String path = request.getRealPath("images") + File.separator + "Products" + ap.getPpicnmae();
				boolean imgsave = ImageSave.save(path, pic);
				
				if(imgsave)
				{
					Operations opera = new Operations(FactoryProvider.getFactory());
					boolean isSave = opera.addProduct(ap);				
					
					if(isSave)
					{	
						HttpSession s = request.getSession();
						s.setAttribute("message", "Product added Successfully");
						response.sendRedirect("AdminPage.jsp");
					}
					else
					{
						HttpSession s = request.getSession();
						s.setAttribute("message", "Oops !! Something wents Wrong Product not added");
						response.sendRedirect("AdminPage.jsp");
					}
				}
				else
				{
					HttpSession s = request.getSession();
					s.setAttribute("message", "Something Wrong while uploading Image");
					response.sendRedirect("AdminPage.jsp");
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
