package com.DKB.Rest.Examples.RestExamples.versioning;

public class PersonV2 {

	private Person person;
	
	public PersonV2(Person person) {
		this.person=person;
	}
	
	public Person getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "PersonV2 [person=" + person + "]";
	}
	
	


	
	
}
