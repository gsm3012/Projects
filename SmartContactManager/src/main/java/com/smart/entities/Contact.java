package com.smart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	private String contactName;
	private String contactNickName;
	private String contactWork;
	private String contactEmail;
	private String contactPhoneNumber;
	private String contactImage;
	private String contactDescription;
	
	@ManyToOne
	private User user;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int contactId, String contactName, String contactNickName, String contactWork, String contactEmail,
			String contactPhoneNumber, String contactImage, String contactDescription, User user) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNickName = contactNickName;
		this.contactWork = contactWork;
		this.contactEmail = contactEmail;
		this.contactPhoneNumber = contactPhoneNumber;
		this.contactImage = contactImage;
		this.contactDescription = contactDescription;
		this.user = user;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNickName() {
		return contactNickName;
	}

	public void setContactNickName(String contactNickName) {
		this.contactNickName = contactNickName;
	}

	public String getContactWork() {
		return contactWork;
	}

	public void setContactWork(String contactWork) {
		this.contactWork = contactWork;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getContactImage() {
		return contactImage;
	}

	public void setContactImage(String contactImage) {
		this.contactImage = contactImage;
	}

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
