package com.levi9.rest.resources.filterbeans;

import javax.ws.rs.QueryParam;

public class EventsFilterBean {
	@QueryParam("eventDate")
	private String eventDate;

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
}
