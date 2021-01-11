package com.shop_first.connection_provider;

public class Cutter 
{
	public static String getTenWords(String spec)
	{
		String [] str = spec.split(" ");
		String res = "";
		if(str.length>10)
		{
			for(int i=0; i<10; i++)
			{
				res = res + str[i];
			}
			
			return res + ("...");
		}
		else
		{
			res = spec;
		}
		return res;
	}
}
