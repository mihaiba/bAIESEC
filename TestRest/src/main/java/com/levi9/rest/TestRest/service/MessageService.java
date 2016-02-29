package com.levi9.rest.TestRest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.levi9.rest.TestRest.memoryDB.Database;
import com.levi9.rest.TestRest.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = Database.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "1st", "mihai"));
		messages.put(2L, new Message(2, "2nd", "mihai"));
		messages.put(3L, new Message(3, "1st", "albert"));
		messages.put(4L, new Message(4, "2nd", "albert"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
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

	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> filteredMsgs = new ArrayList<>(messages.values());
		if (start > messages.size() || start + size > messages.size()) {
			return null;
		}
		return filteredMsgs.subList(start, start + size);
	}

	public Message getMessage(long id) {
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