package com.levi9.rest.Rest.models;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlTransient;

public class User {
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Map<String, Contact> contacts = new ConcurrentHashMap<>();
	private Map<Date, Event> events = new ConcurrentHashMap<>();
	private boolean isAuthenticated = false;

	public User() {

	}

	public User(int id, String username, String password, String firstName, String lastName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	public Map<String, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Map<String, Contact> contacts) {
		this.contacts = contacts;
	}

	@XmlTransient
	public Map<Date, Event> getEvents() {
		return events;
	}

	public void setEvents(Map<Date, Event> events) {
		this.events = events;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
}
