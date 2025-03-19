package com.DKB.Rest.Examples.RestExamples.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioning {
//URI Versioning=Twitter
	@GetMapping("/v1/person")
	public PersonV1 getFirstPerson() {
		return new PersonV1("Dahal kungur");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondPerson() {
		return new PersonV2(new Person("Dahal","Kungur"));
	}
//Request Parameter=Amazon	
	@GetMapping(path="/person",params="version=1")
	public PersonV1 getFirstPersonRequestParam() {
		return new PersonV1("Dahal kungur");
	}
	
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getSecondPersonRequestParam() {
		return new PersonV2(new Person("Dahal","Kungur"));
	}
//Headers--Microsoft
	@GetMapping(path="/person/headers",headers="X-API-VERSION=1")
	public PersonV1 getFirstPersonRequestHeaders() {
		return new PersonV1("Dahal kungur");
	}
	
	@GetMapping(path="/person/headers",headers="X-API-VERSION=2")
	public PersonV2 getSecondPersonRequestHeaders() {
		return new PersonV2(new Person("Dahal","Kungur"));
	}
	
//Accept header--Github
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstPersonAcceptHeaders() {
		return new PersonV1("Dahal kungur");
	}
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondPersonAcceptHeaders() {
		return new PersonV2(new Person("Dahal","Kungur"));
	}
}
