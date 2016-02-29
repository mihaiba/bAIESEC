package com.levi9.rest.Rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levi9.rest.Rest.memoryDB.Database;
import com.levi9.rest.Rest.models.User;

public class UserService {

	private Map<String, User> users = Database.getUsers();

	public UserService() {
		users.put("m.balaniscu", new User(1, "m.balaniscu", "123", "Mihai", "Balaniscu"));
		users.put("a.chmilevski", new User(2, "a.chmilevski", "234", "Albert", "Chmilevski"));
		users.put("g.asimionesei", new User(3, "g.asimionesei", "345", "Ghiocel", "Asimionesei"));
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
