package com.levi9.baisec.web.controllers.models;

import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
	private int id;
	private LocalDate eventDate;
	private List<Contact> contacts = new ArrayList<>();

	public Event() {

	}

	public Event(int id, LocalDate eventDate) {
		this.id = id;
		this.eventDate = eventDate;
	}

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

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
}
