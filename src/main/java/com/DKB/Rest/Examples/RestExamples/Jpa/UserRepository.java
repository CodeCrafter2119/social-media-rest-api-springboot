package com.DKB.Rest.Examples.RestExamples.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DKB.Rest.Examples.RestExamples.users.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
