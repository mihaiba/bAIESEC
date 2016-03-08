package com.levi9.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levi9.rest.memoryDB.Database;
import com.levi9.rest.models.User;

public class UserService {

	private static Long currentUserId = 0L;

	private static Map<Long, User> users = Database.getUsers();

	public UserService() {
	}

	public User add(User user) {
		if (users.containsKey(currentUserId)) {
			currentUserId = (long) (users.size() + 1);
		}
		user.setId(currentUserId);
		users.put(user.getId(), user);
		return user;
	}

	public List<User> getAll() {
		return new ArrayList<>(users.values());
	}

	public User get(Long userId) {
		return users.get(userId);
	}

	public User update(User user) {
		users.put(user.getId(), user);
		return user;
	}

	public User remove(Long userId) {
		return users.remove(userId);
	}

}
