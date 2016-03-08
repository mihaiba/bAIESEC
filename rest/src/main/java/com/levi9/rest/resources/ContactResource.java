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

import com.levi9.rest.models.Contact;
import com.levi9.rest.resources.filterbeans.ContactsFilterBean;
import com.levi9.rest.services.ContactService;

@Path("/users/{userId}/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

	private static ContactService contactService = new ContactService();

	@POST
	public Contact createContact(@PathParam("userId") Long userId, Contact contact) {
		return contactService.add(userId, contact);
	}

	@GET
	public List<Contact> getContacts(@PathParam("userId") Long userId, @BeanParam ContactsFilterBean filter) {
		return contactService.getAll(userId, filter);
	}

	@GET
	@Path("/{contactId}")
	public Contact getContact(@PathParam("userId") Long userId, @PathParam("contactId") Long contactId) {
		return contactService.get(userId, contactId);
	}

	@PUT
	@Path("/{contactId}")
	public Contact updateContact(@PathParam("userId") Long userId, @PathParam("contactId") Long contactId,
			Contact contact) {
		contact.setId(contactId);
		return contactService.update(userId, contact);
	}

	@DELETE
	@Path("/{contactId}")
	public Contact deleteContact(@PathParam("userId") Long userId, @PathParam("contactId") Long contactId) {
		return contactService.removeContact(userId, contactId);
	}
}
