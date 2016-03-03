package com.levi9.rest.Rest.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.levi9.rest.Rest.memoryDB.Database;
import com.levi9.rest.Rest.models.Event;
import com.levi9.rest.Rest.models.User;
import com.levi9.rest.Rest.resources.filterbeans.EventsFilterBean;

public class EventService {

	private static Map<String, User> users = Database.getUsers();

	public Event addEvent(String userName, Event event) {
		Map<LocalDate, Event> events = users.get(userName).getEvents();
		event.setId(events.size() + 1);
		events.put(event.getEventDate(), event);
		return event;
	}

	public List<Event> getEvents(String userName, EventsFilterBean filter) {
		Map<LocalDate, Event> events = users.get(userName).getEvents();
		return new ArrayList<>(events.values());
	}

	public Event updateEvent(String userName, Event event) {
		Map<LocalDate, Event> events = users.get(userName).getEvents();
		Iterator<Event> iterator = events.values().iterator();
		while (iterator.hasNext()) {
			Event currentEvent = iterator.next();
			if (currentEvent.getId() == event.getId()) {
				if (!event.getEventDate().equals(currentEvent.getEventDate())) {
					iterator.remove();
				}
				events.put(event.getEventDate(), event);
			}
		}
		return event;
	}

	public Event removeEvent(String userName, int eventId) {
		Map<LocalDate, Event> events = users.get(userName).getEvents();
		Iterator<Event> iterator = events.values().iterator();
		Event currentEvent = null;
		while (iterator.hasNext()) {
			currentEvent = iterator.next();
			if (currentEvent.getId() == eventId) {
				iterator.remove();
				break;
			}
		}
		return currentEvent;
	}

}
