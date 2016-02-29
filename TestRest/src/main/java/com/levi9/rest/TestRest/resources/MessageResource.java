package com.levi9.rest.TestRest.resources;

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

import com.levi9.rest.TestRest.model.Message;
import com.levi9.rest.TestRest.resources.beans.MessageFilterBean;
import com.levi9.rest.TestRest.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	private static MessageService service = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filter) {
		if (filter.getYear() > 0) {
			return service.getAllMessagesForYear(filter.getYear());
		}
		if (filter.getStart() >= 0 && filter.getSize() >= 0) {
			return service.getAllMessagesPaginated(filter.getStart(), filter.getSize());
		}
		return service.getAllMessages();
	}

	@GET
	@Path("/{id}")
	public Message getMessage(@PathParam("id") long id) {
		return service.getMessage(id);
	}

	@POST
	public Message addMessage(Message msg) {
		return service.addMessage(msg);
	}

	@PUT
	@Path("{id}")
	public Message updateMessage(@PathParam("id") long id, Message msg) {
		msg.setId(id);
		return service.updateMessage(msg);
	}

	@DELETE
	@Path("{id}")
	public Message removeMessage(@PathParam("id") long id) {
		return service.removeMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource handleCommentResource() {
		return new CommentResource();
	}

}
