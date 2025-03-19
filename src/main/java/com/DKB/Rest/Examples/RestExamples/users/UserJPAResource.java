package com.DKB.Rest.Examples.RestExamples.users;

import java.net.URI;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DKB.Rest.Examples.RestExamples.Jpa.PostRepository;
import com.DKB.Rest.Examples.RestExamples.Jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> retriveAllUser() {
		return repository.findAll();
	}

	@GetMapping("/jpa/users/{id}") // adding exception handling
	public EntityModel<User> retriveOneUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id " + id);

		EntityModel<User> entityModel = EntityModel.of(user.get());

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());
		entityModel.add(link.withRel("All-users"));

		return entityModel;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		// /user/4 -> /user/{id} -> /user /user.getId() -> Uri
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	// Rest For post
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPostForOneUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id" + id);

		return user.get().getPost();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> CreatePostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id" + id);
		
		post.setUser(user.get());
		
		postRepository.save(post);
		
		Post savedPost = postRepository.save(post);
		// /user/4 -> /user/{id} -> /user /user.getId() -> Uri
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
		
	}
	
	@DeleteMapping("/jpa/users/{id}/posts")
	@Transactional  //However, if you're calling repository methods from a non-transactional context (e.g., directly from a controller), this error can occur
	public void deleteAllPostsByUser(@PathVariable int id) {
//deleteById is only for primary key  , deleteByUserId is defined method in interface
		postRepository.deleteByUserId(id);
	}
	
	//retrive All posts
	@GetMapping("/jpa/users/posts")
	public List<Post> retriveAllPosts() {
		return postRepository.findAll();
	}

}
