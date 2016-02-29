package com.levi9.rest.TestRest.memoryDB;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.levi9.rest.TestRest.model.Message;
import com.levi9.rest.TestRest.model.Profile;

public class Database {

	private Database() {

	}

	private static Map<Long, Message> messages = new ConcurrentHashMap<>();
	private static Map<String, Profile> profiles = new ConcurrentHashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}