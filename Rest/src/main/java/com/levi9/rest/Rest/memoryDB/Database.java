package com.levi9.rest.Rest.memoryDB;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.levi9.rest.Rest.models.User;

public class Database {

	private static Map<String, User> users = new ConcurrentHashMap<>();

	public static Map<String, User> getUsers() {
		return users;
	}

}
