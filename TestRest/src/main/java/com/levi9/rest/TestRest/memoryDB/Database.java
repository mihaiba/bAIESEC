package com.levi9.rest.TestRest.memoryDB;

import java.util.HashMap;
import java.util.Map;

import com.levi9.rest.TestRest.model.Message;
import com.levi9.rest.TestRest.model.Profile;

public class Database {

	private Database() {

	}

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}