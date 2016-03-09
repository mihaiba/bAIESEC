package com.levi9.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levi9.rest.memoryDB.Database;
import com.levi9.rest.models.User;

public class UserService {

	private static Map<String, User> users = Database.getUsers();

	public UserService() {
	}

	public User add(User user) {
		if (users.containsKey(user.getUsername())) {
			// TODO: return exception user already exists ???
		}
		users.put(user.getUsername(), user);
		return user;
	}

	public List<User> getAll() {
		return new ArrayList<>(users.values());
	}

	public User get(String userName) {
		return users.get(userName);
	}

	public User update(User user) {
		users.put(user.getUsername(), user);
		return user;
	}

	public User remove(String userName) {
		return users.remove(userName);
	}

}
