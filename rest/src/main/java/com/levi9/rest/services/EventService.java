package com.levi9.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.levi9.rest.memoryDB.Database;
import com.levi9.rest.models.Event;
import com.levi9.rest.resources.filterbeans.EventsFilterBean;

public class EventService {

	public static Map<String, Long> eventIdsByUser = new HashMap<>();

	private static Map<String, Map<Long, Event>> events = Database.getEvents();

	public Event add(String userName, Event event) {
		Map<Long, Event> currentUserEvents = events.get(userName);
		long currentEventId = 0;
		if (eventIdsByUser.containsKey(userName)) {
			currentEventId = eventIdsByUser.get(userName);
		} else {
			currentEventId = eventIdsByUser.size();
		}
		eventIdsByUser.put(userName, ++currentEventId);
		event.setId(currentEventId);
		currentUserEvents.put(event.getId(), event);
		return event;
	}

	public List<Event> getAll(String userName, EventsFilterBean filter) {
		Map<Long, Event> currentUserEvents = events.get(userName);
		return new ArrayList<>(currentUserEvents.values());
	}

	public Event update(String userName, Event event) {
		events.get(userName).put(event.getId(), event);
		return event;
	}

	public Event remove(String userName, Long eventId) {
		return events.get(userName).remove(eventId);
	}

}
