package com.levi9.rest.Rest.resources.filterbeans;

import javax.ws.rs.QueryParam;

public class ContactsFilterBean {
	@QueryParam("phoneNumber")
	private String phoneNumber;
	@QueryParam("name")
	private String name;
	@QueryParam("userName")
	private String userName;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
