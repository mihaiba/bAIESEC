package com.levi9.rest.TestRest.model;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date creationDate = new Date();
	private String author;
	private Map<Long, Comment> comments = new ConcurrentHashMap<>();
	private Map<Long, Like> likes = new ConcurrentHashMap<>();
	private Map<Long, Share> shares = new ConcurrentHashMap<>();

	public Message() {
	}

	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreationDate() {
		return (Date) creationDate.clone();
	}

	public void setCreationDate(Date date) {
		this.creationDate.setTime(date.getTime());
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	@XmlTransient
	public Map<Long, Like> getLikes() {
		return likes;
	}

	public void setLikes(Map<Long, Like> likes) {
		this.likes = likes;
	}

	@XmlTransient
	public Map<Long, Share> getShares() {
		return shares;
	}

	public void setShares(Map<Long, Share> shares) {
		this.shares = shares;
	}
}
