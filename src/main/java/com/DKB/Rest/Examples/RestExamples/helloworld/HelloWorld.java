package com.DKB.Rest.Examples.RestExamples.helloworld;

public class HelloWorld {

	private String message;

	public HelloWorld(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}
	
	
	
	
}
