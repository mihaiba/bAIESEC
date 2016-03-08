package com.levi9.rest.memoryDB;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.levi9.rest.models.Contact;
import com.levi9.rest.models.Event;
import com.levi9.rest.models.User;

public class Database {

	private static Map<Long, User> users;
	private static Map<Long, Map<Long, Contact>> contacts;
	private static Map<Long, Map<Long, Event>> events;

	public static Map<Long, User> getUsers() {
		if (users == null) {
			initUsers();
		}
		return users;
	}

	private static void initUsers() {
		users = new ConcurrentHashMap<>();
		User u = new User();
		u.setId(1L);
		u.setContacts(new ConcurrentHashMap<>());
		u.setEvents(new ConcurrentHashMap<>());
		u.setFirstName("Albert");
		u.setLastName("Chmilevski");
		u.setPassword("A|Es3C");
		u.setUsername("albert");
		users.put(u.getId(), u);

		u = new User();
		u.setId(2L);
		u.setContacts(new ConcurrentHashMap<>());
		u.setEvents(new ConcurrentHashMap<>());
		u.setFirstName("Mihai");
		u.setLastName("Balaniscu");
		u.setPassword("Ai3Sec");
		u.setUsername("albert");
		users.put(u.getId(), u);
	}

	public static Map<Long, Map<Long, Contact>> getContacts() {
		if (contacts == null) {
			initContacts();
		}
		return contacts;
	}

	private static void initContacts() {
		initUsers();
		contacts = new ConcurrentHashMap<>();
		for (User user : users.values()) {
			contacts.put(user.getId(), new ConcurrentHashMap<>());
		}
	}

	public static Map<Long, Map<Long, Event>> getEvents() {
		if (events == null) {
			initEvents();
		}
		return events;
	}

	private static void initEvents() {
		initUsers();
		events = new ConcurrentHashMap<>();
		for (User user : users.values()) {
			events.put(user.getId(), new ConcurrentHashMap<>());
		}
	}

}
