package com.levi9.rest.TestRest.model;

import java.util.Date;

public class Comment {
	private long id;
	private long messageId;
	private String content;
	private Date creationDate = new Date();

	public Comment() {

	}

	public Comment(long id, long messageId, String content) {
		this.id = id;
		this.messageId = messageId;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return (Date) creationDate.clone();
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate.setTime(creationDate.getTime());
	}
}
