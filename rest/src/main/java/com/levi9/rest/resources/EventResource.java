package com.levi9.rest.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levi9.rest.models.Event;
import com.levi9.rest.resources.filterbeans.EventsFilterBean;
import com.levi9.rest.services.EventService;

/**
 * Sub resource of User resource.
 */
@Path("/users/{userName}/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {
	private static EventService eventService = new EventService();

	@POST
	public Event createEvent(@PathParam("userName") String userName, Event event) {
		return eventService.add(userName, event);
	}

	@GET
	public List<Event> getEvents(@PathParam("userName") String userName, @BeanParam EventsFilterBean filter) {
		return eventService.getAll(userName, filter);
	}

	@PUT
	@Path("{eventId}")
	public Event updateEvent(@PathParam("userName") String userName, @PathParam("eventId") Long eventId, Event event) {
		event.setId(eventId);
		return eventService.update(userName, event);
	}

	@DELETE
	@Path("{eventId}")
	public Event deleteEvent(@PathParam("userId") String userName, @PathParam("eventId") Long eventId) {
		return eventService.remove(userName, eventId);
	}
}
