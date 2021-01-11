package com.shop_first.connection_provider;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

public class ImageSave 
{
	public static boolean save(String path, Part pic)
	{
		boolean imgsave = false;
		
		try 
		{
			 InputStream is = pic.getInputStream();
			 byte img [] = new byte [is.available()];
			 is.read(img);
			 
			 FileOutputStream fos = new FileOutputStream(path);
			 fos.write(img);
			 fos.close();
			 is.close();
			 
			 imgsave=true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			imgsave=false;
		}
		return imgsave;
	}
}
