package com.levi9.rest.Rest.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levi9.rest.Rest.memoryDB.Database;
import com.levi9.rest.Rest.models.Contact;
import com.levi9.rest.Rest.models.Event;
import com.levi9.rest.Rest.models.User;

public class UserService {

	private Map<String, User> users = Database.getUsers();

	public UserService() {
		users.put("m.balaniscu", new User(1, "m.balaniscu", "123", "Mihai", "Balaniscu"));
		users.put("a.chmilevski", new User(2, "a.chmilevski", "234", "Albert", "Chmilevski"));
		users.put("g.asimionesei", new User(3, "g.asimionesei", "345", "Ghiocel", "Asimionesei"));

		for (User user : users.values()) {
			user.getContacts().put("1234", new Contact(1, "Mihai", "Balaniscu", "1234", LocalDate.parse("1/1/1988")));
			user.getContacts().put("2345", new Contact(2, "Albert", "Chmilevski", "2345", LocalDate.parse("2/2/1990")));
			user.getContacts().put("3456",
					new Contact(3, "Ghiocel", "Asimionesei", "3456", LocalDate.parse("3/3/1968")));
			user.getEvents().put(LocalDate.parse("3/10/2016"), new Event(1, LocalDate.parse("3/10/2016")));
			user.getEvents().get(LocalDate.parse("3/10/2016")).getContacts().addAll(user.getContacts().values());
			user.getEvents().put(LocalDate.parse("10/10/2016"), new Event(2, LocalDate.parse("10/10/2016")));
			user.getEvents().get(LocalDate.parse("10/10/2016")).getContacts().addAll(user.getContacts().values());
			user.getEvents().put(LocalDate.parse("5/6/2016"), new Event(2, LocalDate.parse("5/6/2016")));
			user.getEvents().get(LocalDate.parse("5/6/2016")).getContacts().addAll(user.getContacts().values());
		}
	}

	public User addUser(User user) {
		user.setId(users.size() + 1);
		users.put(user.getUsername(), user);
		return user;
	}

	public List<User> getUsers() {
		return new ArrayList<>(users.values());
	}

	public User getUser(String userName) {
		return users.get(userName);
	}

	public User updateUser(String userName, User user) {
		if (!users.containsKey(userName)) {
			return null;
		}
		User oldUser = users.get(userName);
		user.setId(oldUser.getId());
		user.setContacts(oldUser.getContacts());
		user.setEvents(oldUser.getEvents());
		users.put(user.getUsername(), user);
		return user;
	}

	public User deleteUser(String userName) {
		return users.remove(userName);
	}

}
