package com.levi9.baisec.web.controllers.models;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Event {
	private Long id;
	private String eventDate;
	private Map<Long, Contact> contacts = new ConcurrentHashMap<>();

	public Event() {

	}

	public Event(Long id, String eventDate) {
		this.id = id;
		this.eventDate = eventDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlTransient
	public Map<Long, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Map<Long, Contact> contacts) {
		this.contacts = contacts;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
}
