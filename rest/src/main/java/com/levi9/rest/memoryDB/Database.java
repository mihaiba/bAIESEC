package com.levi9.rest.memoryDB;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.levi9.rest.models.Contact;
import com.levi9.rest.models.Event;
import com.levi9.rest.models.User;

public class Database {

	private static Map<String, User> users;
	private static Map<String, Map<Long, Contact>> contacts;
	private static Map<String, Map<Long, Event>> events;

	public static Map<String, User> getUsers() {
		if (users == null) {
			initUsers();
		}
		return users;
	}

	private static void initUsers() {
		users = new ConcurrentHashMap<>();
		User u = new User();
		u.setContacts(new ConcurrentHashMap<>());
		u.setEvents(new ConcurrentHashMap<>());
		u.setFirstName("Albert");
		u.setLastName("Chmilevski");
		u.setPassword("A|Es3C");
		u.setUsername("a.chmilevski");
		users.put(u.getUsername(), u);

		u = new User();
		u.setContacts(new ConcurrentHashMap<>());
		u.setEvents(new ConcurrentHashMap<>());
		u.setFirstName("Mihai");
		u.setLastName("Balaniscu");
		u.setPassword("Ai3Sec");
		u.setUsername("m.balaniscu");
		users.put(u.getUsername(), u);
	}

	public static Map<String, Map<Long, Contact>> getContacts() {
		if (contacts == null) {
			initContacts();
		}
		return contacts;
	}

	private static void initContacts() {
		initUsers();
		contacts = new ConcurrentHashMap<>();
		for (User user : users.values()) {
			contacts.put(user.getUsername(), new ConcurrentHashMap<>());
		}
	}

	public static Map<String, Map<Long, Event>> getEvents() {
		if (events == null) {
			initEvents();
		}
		return events;
	}

	private static void initEvents() {
		initUsers();
		events = new ConcurrentHashMap<>();
		for (User user : users.values()) {
			events.put(user.getUsername(), new ConcurrentHashMap<>());
		}
	}

}
