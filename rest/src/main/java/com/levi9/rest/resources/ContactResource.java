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

@Path("/users/{userName}/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

	private static ContactService contactService = new ContactService();

	@POST
	public Contact createContact(@PathParam("userName") String userName, Contact contact) {
		return contactService.add(userName, contact);
	}

	@GET
	public List<Contact> getContacts(@PathParam("userName") String userName, @BeanParam ContactsFilterBean filter) {
		return contactService.getAll(userName, filter);
	}

	@GET
	@Path("/{contactId}")
	public Contact getContact(@PathParam("userName") String userName, @PathParam("contactId") Long contactId) {
		return contactService.get(userName, contactId);
	}

	@PUT
	@Path("/{contactId}")
	public Contact updateContact(@PathParam("userName") String userName, @PathParam("contactId") Long contactId,
			Contact contact) {
		contact.setId(contactId);
		return contactService.update(userName, contact);
	}

	@DELETE
	@Path("/{contactId}")
	public Contact deleteContact(@PathParam("userName") String userName, @PathParam("contactId") Long contactId) {
		return contactService.removeContact(userName, contactId);
	}
}
