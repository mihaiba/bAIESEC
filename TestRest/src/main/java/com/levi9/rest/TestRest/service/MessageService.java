package com.levi9.rest.TestRest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.levi9.rest.TestRest.exception.DataNotFoundException;
import com.levi9.rest.TestRest.memoryDB.Database;
import com.levi9.rest.TestRest.model.Comment;
import com.levi9.rest.TestRest.model.Message;
import com.levi9.rest.TestRest.resources.beans.MessageFilterBean;

public class MessageService {

	private Map<Long, Message> messages = Database.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "1st", "mihai"));
		messages.put(2L, new Message(2, "2nd", "mihai"));
		messages.put(3L, new Message(3, "1st", "albert"));
		messages.put(4L, new Message(4, "2nd", "albert"));

		for (Message msg : messages.values()) {
			for (long commentId = 0; commentId < 10; commentId++) {
				msg.getComments().put(commentId, new Comment(commentId, msg.getId(), "Hello World!"));
			}
		}
	}

	public List<Message> getAllMessages(MessageFilterBean filter) {
		if (filter.getYear() != null) {
			return getAllMessagesForYear(filter.getYear());
		}
		if (filter.getSize() != null && filter.getStart() != null) {
			return getAllMessagesPaginated(filter.getStart(), filter.getSize());
		}
		return new ArrayList<>(messages.values());
	}

	private List<Message> getAllMessagesForYear(int year) {
		List<Message> filteredMsgs = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message msg : messages.values()) {
			cal.setTime(msg.getCreationDate());
			if (cal.get(Calendar.YEAR) == year) {
				filteredMsgs.add(msg);
			}
		}
		return filteredMsgs;
	}

	private List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> list = new ArrayList<Message>(messages.values());
		return list.subList(start, start + size > list.size() ? list.size() : start + size);
	}

	public Message getMessage(long id) {
		if (!messages.containsKey(id)) {
			throw new DataNotFoundException("Message with id: " + id + " not found.");
		}
		return messages.get(id);
	}

	public Message addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}

	public Message updateMessage(Message msg) {
		if (msg.getId() <= 0) {
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}