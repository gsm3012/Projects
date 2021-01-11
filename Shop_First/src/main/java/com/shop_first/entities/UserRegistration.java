package com.shop_first.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints =@UniqueConstraint(name="user_email_password", columnNames = {"user_email", "user_mobile"}))
public class UserRegistration 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private String user_mobile;
	private String user_gender;
	private String user_type;
	
	
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegistration(String user_name, String user_email, String user_password, String user_mobile, String user_gender, String user_type) 
	{
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_mobile = user_mobile;
		this.user_gender = user_gender;
		this.user_type = user_type;
	}
	
	public UserRegistration(int user_id, String user_name, String user_email, String user_password, String user_mobile, String user_gender, String user_type) 
	{
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_mobile = user_mobile;
		this.user_gender = user_gender;
		this.user_type = user_type;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "UserRegistration [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_password=" + user_password + ", user_mobile=" + user_mobile + ", user_gender=" + user_gender
				+ ", user_type=" + user_type + "]";
	}
}


