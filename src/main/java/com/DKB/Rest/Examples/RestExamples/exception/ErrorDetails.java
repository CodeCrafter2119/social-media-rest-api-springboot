package com.DKB.Rest.Examples.RestExamples.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime dateTime;
	private String message;
	private String details;
	
	
	public ErrorDetails(LocalDateTime dateTime, String message, String details) {
		super();
		this.dateTime = dateTime;
		this.message = message;
		this.details = details;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
}
