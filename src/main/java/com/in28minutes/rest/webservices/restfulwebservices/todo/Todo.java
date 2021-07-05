package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.Date;

public class Todo {

	private long id;
	private String userName;
	private String description;
	private Date completionDate;
	private boolean done;

	public Todo(long id, String userName, String description, Date completionDate, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.completionDate = completionDate;
		this.done = done;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
