package com.DKB.Rest.Examples.RestExamples.users;

import java.net.URI;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retriveAllUser(){
		return userDaoService.findAllUser();
	}
	
	@GetMapping("/users/{id}") //adding exception handling
	public EntityModel<User> retriveOneUser(@PathVariable int id){
		User user=userDaoService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id "+id);
		
		EntityModel<User> entityModel=EntityModel.of(user);
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retriveAllUser());
		entityModel.add(link.withRel("All-users"));
		
		return entityModel;
	}
	
	@DeleteMapping("/users/{id}") 
	public void deleteUser(@PathVariable int id){
		userDaoService.DeleteUser(id);
	}
	
	@PostMapping("/users")  
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		User savedUser=userDaoService.save(user);
		// /user/4 -> /user/{id} -> /user /user.getId() -> Uri
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
}
