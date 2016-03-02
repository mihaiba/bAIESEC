package com.levi9.rest.Rest.resources;

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

import com.levi9.rest.Rest.models.Event;
import com.levi9.rest.Rest.resources.filterbeans.EventsFilterBean;
import com.levi9.rest.Rest.services.EventService;

/**
 * Sub resource of User resource.
 */
@Path("/{userName}/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {
	private static EventService service = new EventService();

	// RUD
	@POST
	public Event createEvent(@PathParam("userName") String userName, Event event) {
		return service.addEvent(userName, event);
	}

	@GET
	// TODO: I want to be able to filter results.
	public List<Event> getEvents(@PathParam("userName") String userName, @BeanParam EventsFilterBean filter) {
		return service.getEvents(userName, filter);
	}

	@PUT
	@Path("{eventId}")
	public Event updateEvent(@PathParam("userName") String userName, @PathParam("eventId") int eventId, Event event) {
		event.setId(eventId);
		return service.updateEvent(userName, event);
	}

	@DELETE
	@Path("{eventId}")
	public Event deleteEvent(@PathParam("userName") String userName, @PathParam("eventId") int eventId) {
		return service.removeEvent(userName, eventId);
	}
}
