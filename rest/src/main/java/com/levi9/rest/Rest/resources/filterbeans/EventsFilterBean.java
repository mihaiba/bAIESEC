package com.levi9.rest.Rest.resources.filterbeans;

import java.time.LocalDate;

import javax.ws.rs.QueryParam;

public class EventsFilterBean {
	@QueryParam("eventDate")
	private LocalDate eventDate;

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
}
