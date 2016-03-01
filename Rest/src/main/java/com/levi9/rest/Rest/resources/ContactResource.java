package com.levi9.rest.Rest.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levi9.rest.Rest.models.Contact;
import com.levi9.rest.Rest.resources.filterbeans.ContactsFilterBean;
import com.levi9.rest.Rest.services.ContactService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

	private static ContactService service = new ContactService();

	// UD

	@POST
	public Contact createContact(@PathParam("userName") String userName, Contact contact) {
		return service.addContact(userName, contact);
	}

	@GET
	public List<Contact> getContacts(@PathParam("userName") String userName, @BeanParam ContactsFilterBean filter) {
		if (!filter.getName().isEmpty()) {
			return service.getContactsByName(userName, filter.getName());
		}

		if (!filter.getPhoneNumber().isEmpty()) {
			return service.getContactsByPhoneNumber(userName, filter.getPhoneNumber());
		}

		return service.getContacts(userName);
	}

	@GET
	@Path("/{contactId}")
	public Contact getContact(@PathParam("userName") String userName, @PathParam("contactId") int contactId) {
		return service.getContact(userName, contactId);
	}
}
