package com.dj.boot.student;

import java.util.Date;

public class ExceptionResponseBean {
	
	private Date time;
	private String message;
	private String details;
	public ExceptionResponseBean(Date time, String message, String details) {
		super();
		this.time = time;
		this.message = message;
		this.details = details;
	}
	public Date getTime() {
		return time;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	

}
