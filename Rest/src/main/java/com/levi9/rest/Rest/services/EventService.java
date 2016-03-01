package com.levi9.rest.Rest.services;

import java.util.Date;
import java.util.Map;

import com.levi9.rest.Rest.memoryDB.Database;
import com.levi9.rest.Rest.models.Event;
import com.levi9.rest.Rest.models.User;

public class EventService {

	private static Map<String, User> users = Database.getUsers();

	public Event addEvent(String userName, Event event) {
		Map<Date, Event> events = users.get(userName).getEvents();
		event.setId(events.size() + 1);
		events.put(event.getEventDate(), event);
		return event;
	}

}
