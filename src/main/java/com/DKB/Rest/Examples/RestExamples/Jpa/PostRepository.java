package com.DKB.Rest.Examples.RestExamples.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DKB.Rest.Examples.RestExamples.users.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	//created this because it can use in case if a post has primary key and foreign key they are connected
	void deleteByUserId(int id);
}
