package com.levi9.rest.TestRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.levi9.rest.TestRest.memoryDB.Database;
import com.levi9.rest.TestRest.model.Comment;
import com.levi9.rest.TestRest.model.ErrorMessage;
import com.levi9.rest.TestRest.model.Message;

public class CommentService {

	private Map<Long, Message> messages = Database.getMessages();

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMsg = new ErrorMessage("Not found", Status.NOT_FOUND.getStatusCode(), "http://www.google.ro");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMsg).build();
		Message msg = messages.get(messageId);
		if (msg == null) {
			throw new NotFoundException(response);
		}
		Map<Long, Comment> comments = msg.getComments();
		Comment comment = comments.get(commentId);
		if (comment == null) {
			throw new NotFoundException(response);
		}
		return comment;
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0 || !comments.containsKey(comment.getId())) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long id, long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(id);
	}
}