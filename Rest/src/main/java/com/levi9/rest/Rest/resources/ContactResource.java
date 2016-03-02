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

import com.levi9.rest.Rest.models.Contact;
import com.levi9.rest.Rest.resources.filterbeans.ContactsFilterBean;
import com.levi9.rest.Rest.services.ContactService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

	private static ContactService service = new ContactService();

	@POST
	public Contact createContact(@PathParam("userName") String userName, Contact contact) {
		return service.addContact(userName, contact);
	}

	@GET
	public List<Contact> getContacts(@BeanParam ContactsFilterBean filter) {
		return service.getContacts(filter);
	}

	@GET
	@Path("/{phoneNumber}")
	public Contact getContact(@PathParam("userName") String userName, @PathParam("phoneNumber") String phoneNumber) {
		return service.getContact(userName, phoneNumber);
	}

	@PUT
	@Path("/{phoneNumber}")
	public Contact updateContact(@PathParam("userName") String userName, @PathParam("phoneNumber") String phoneNumber,
			Contact contact) {
		contact.setPhoneNumber(phoneNumber);
		return service.updateContact(userName, contact);
	}

	@DELETE
	@Path("/{phoneNumber}")
	public Contact deleteContact(@PathParam("userName") String userName, @PathParam("phoneNumber") String phoneNumber) {
		return service.removeContact(userName, phoneNumber);
	}
}
