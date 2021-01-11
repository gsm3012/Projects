package com.shop_first.connection_provider;

public class TotalPrice 
{
	public static double getTotalPrice(double price, double discount)
	{
		double finalPrice=0;
		double tempPrice=0;
		if(discount == 0)
		{
			finalPrice = price;
		}
		else
		{
			tempPrice = price*discount/100;
			finalPrice = price-tempPrice;
		}
		return finalPrice;
	}
}
