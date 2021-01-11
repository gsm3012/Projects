package com.shop_first.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AddProducts 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	
	@Column(length=3000)
	private String pspec;
	private int pprice;
	private int pdicount;
	private String ppicnmae;
	
	@ManyToOne
	private AddCatagory catagory;
	
	public AddProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddProducts(String pname, String pspec, int pprice, int pdicount, String ppicnmae, AddCatagory catagory) {
		super();
		this.pname = pname;
		this.pspec = pspec;
		this.pprice = pprice;
		this.pdicount = pdicount;
		this.ppicnmae = ppicnmae;
		this.catagory = catagory;
	}

	public AddProducts(int pid, String pname, String pspec, int pprice, int pdicount, String ppicnmae,
			AddCatagory catagory) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pspec = pspec;
		this.pprice = pprice;
		this.pdicount = pdicount;
		this.ppicnmae = ppicnmae;
		this.catagory = catagory;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPspec() {
		return pspec;
	}

	public void setPspec(String pspec) {
		this.pspec = pspec;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPdicount() {
		return pdicount;
	}

	public void setPdicount(int pdicount) {
		this.pdicount = pdicount;
	}

	public String getPpicnmae() {
		return ppicnmae;
	}

	public void setPpicnmae(String ppicnmae) {
		this.ppicnmae = ppicnmae;
	}

	public AddCatagory getCatagory() {
		return catagory;
	}

	public void setCatagory(AddCatagory catagory) {
		this.catagory = catagory;
	}

	@Override
	public String toString() {
		return "AddProducts [pid=" + pid + ", pname=" + pname + ", pspec=" + pspec + ", pprice=" + pprice
				+ ", pdicount=" + pdicount + ", ppicnmae=" + ppicnmae + ", catagory=" + catagory + "]";
	}
}
