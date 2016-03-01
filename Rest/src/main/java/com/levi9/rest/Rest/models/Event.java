package com.levi9.rest.Rest.models;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

public class Event {
	private int id;
	private List<Contact> contacts;
	private Date eventDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlTransient
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
}
