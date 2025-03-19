package com.DKB.Rest.Examples.RestExamples.users;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min =2,message="Name should have atleast 2 characters ")
	@JsonProperty("User_name")
	private String name;
	@Past(message="Date Of Birth should be in the Past ")
	@JsonProperty("Date_Of_Birth")
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> post;
	
	public User(Integer id, String name, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	public User() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	//post
	
	public List<Post> getPost() {
		return post;
	}
	
	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

	
	
}
