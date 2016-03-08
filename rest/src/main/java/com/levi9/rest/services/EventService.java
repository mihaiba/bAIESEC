package com.levi9.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.levi9.rest.memoryDB.Database;
import com.levi9.rest.models.Event;
import com.levi9.rest.resources.filterbeans.EventsFilterBean;

public class EventService {

	public static Map<Long, Long> eventIdsByUser = new HashMap<>();

	private static Map<Long, Map<Long, Event>> events = Database.getEvents();

	public Event add(Long userId, Event event) {
		Map<Long, Event> currentUserEvents = events.get(userId);
		long currentEventId = 0;
		if (eventIdsByUser.containsKey(userId)) {
			currentEventId = eventIdsByUser.get(userId);
		} else {
			currentEventId = eventIdsByUser.size();
		}
		eventIdsByUser.put(userId, ++currentEventId);
		event.setId(currentEventId);
		currentUserEvents.put(event.getId(), event);
		return event;
	}

	public List<Event> getAll(Long userId, EventsFilterBean filter) {
		Map<Long, Event> currentUserEvents = events.get(userId);
		return new ArrayList<>(currentUserEvents.values());
	}

	public Event update(Long userId, Event event) {
		events.get(userId).put(event.getId(), event);
		return event;
	}

	public Event remove(Long userId, Long eventId) {
		return events.get(userId).remove(eventId);
	}

}
