package com.DKB.Rest.Examples.RestExamples.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<User>();
	private static int count=0;
	static {
		users.add(new User(++count,"Dahal",LocalDate.now().minusYears(21)));
		users.add(new User(++count,"KGp",LocalDate.now().minusYears(20)));
		users.add(new User(++count,"BTy",LocalDate.now().minusYears(34)));
	}
	
	//finding all users
	public List<User> findAllUser(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
	
	//find one user
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	//delete
	public void DeleteUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
        
		users.removeIf(predicate);
	}
}
