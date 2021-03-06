package com.levi9.rest.TestRest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levi9.rest.TestRest.model.Comment;
import com.levi9.rest.TestRest.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private static CommentService service = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return service.getAllComments(messageId);
	}

	@GET
	@Path("{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return service.getComment(messageId, commentId);
	}

	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		comment.setMessageId(messageId);
		return service.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId,
			Comment comment) {
		comment.setId(commentId);
		comment.setMessageId(messageId);
		return service.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public Comment removeComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return service.removeComment(commentId, messageId);
	}

}
