package com.shop_first.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AddCatagory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catid;
	private String cattitle;
	@Column(length=3000)
	private String catdescription;
	
	@OneToMany(mappedBy = "catagory")
	private List<AddProducts> products = new ArrayList<>();
	
	public AddCatagory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddCatagory(String cattitle, String catdescription, List<AddProducts> products) {
		super();
		this.cattitle = cattitle;
		this.catdescription = catdescription;
		this.products = products;
	}

	public AddCatagory(int catid, String cattitle, String catdescription, List<AddProducts> products) {
		super();
		this.catid = catid;
		this.cattitle = cattitle;
		this.catdescription = catdescription;
		this.products = products;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCattitle() {
		return cattitle;
	}

	public void setCattitle(String cattitle) {
		this.cattitle = cattitle;
	}

	public String getCatdescription() {
		return catdescription;
	}

	public void setCatdescription(String catdescription) {
		this.catdescription = catdescription;
	}

	public List<AddProducts> getProducts() {
		return products;
	}

	public void setProducts(List<AddProducts> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "AddCatagory [catid=" + catid + ", cattitle=" + cattitle + ", catdescription=" + catdescription
				+ ", products=" + products + "]";
	}
}
