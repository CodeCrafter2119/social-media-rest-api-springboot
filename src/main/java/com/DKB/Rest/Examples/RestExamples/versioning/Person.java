package com.DKB.Rest.Examples.RestExamples.versioning;

public class Person {

	private String firstName;
	private String secondName;
	public Person(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", secondName=" + secondName + "]";
	}
	
}
