package com.levi9.rest.models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlTransient;

public class User {
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Map<Long, Contact> contacts = new ConcurrentHashMap<>();
	private Map<Long, Event> events = new ConcurrentHashMap<>();

	public User() {

	}

	public User(Long id, String username, String password, String firstName, String lastName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlTransient
	public Map<Long, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Map<Long, Contact> contacts) {
		this.contacts = contacts;
	}

	@XmlTransient
	public Map<Long, Event> getEvents() {
		return events;
	}

	public void setEvents(Map<Long, Event> events) {
		this.events = events;
	}
}
