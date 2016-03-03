package com.levi9.rest.Rest.memoryDB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.levi9.rest.Rest.models.Contact;
import com.levi9.rest.Rest.models.Event;
import com.levi9.rest.Rest.models.User;

public class Database {

	private static Map<String, User> users;
	private static DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static Map<String, User> getUsers() {
		if (users == null) {
			initUsers();
		}
		return users;
	}

	private static Map<String, User> initUsers() {
		users = new ConcurrentHashMap<>();
		users.put("m.balaniscu", new User(1, "m.balaniscu", "123", "Mihai", "Balaniscu"));
		users.put("a.chmilevski", new User(2, "a.chmilevski", "234", "Albert", "Chmilevski"));
		users.put("g.asimionesei", new User(3, "g.asimionesei", "345", "Ghiocel", "Asimionesei"));

		for (User user : users.values()) {
			user.getContacts().put("1234",
					new Contact(1, "Mihai", "Balaniscu", "1234", LocalDate.parse("01-01-1988", f)));
			user.getContacts().put("2345",
					new Contact(2, "Albert", "Chmilevski", "2345", LocalDate.parse("02-02-1990", f)));
			user.getContacts().put("3456",
					new Contact(3, "Ghiocel", "Asimionesei", "3456", LocalDate.parse("03-03-1968", f)));
			user.getEvents().put(LocalDate.parse("03-10-2016", f), new Event(1, LocalDate.parse("03-10-2016", f)));
			user.getEvents().get(LocalDate.parse("03-10-2016", f)).getContacts().addAll(user.getContacts().values());
			user.getEvents().put(LocalDate.parse("10-10-2016", f), new Event(2, LocalDate.parse("10-10-2016", f)));
			user.getEvents().get(LocalDate.parse("10-10-2016", f)).getContacts().addAll(user.getContacts().values());
			user.getEvents().put(LocalDate.parse("05-06-2016", f), new Event(2, LocalDate.parse("05-06-2016", f)));
			user.getEvents().get(LocalDate.parse("05-06-2016", f)).getContacts().addAll(user.getContacts().values());
		}
		return users;
	}

}
