package com.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.entities.User;
import com.jpa.test.repository.UserRepository;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("Swapnil");
		user.setCity("Kolkata");
		user.setStatus("Java Dev");
		
		User user1 = new User();
		user1.setName("Ravi");
		user1.setCity("Ahmedabad");
		user1.setStatus("Python Dev");
		
		User user2 = new User();
		user2.setName("Rohan");
		user2.setCity("Mumbai");
		user2.setStatus("DE");
		
		User user3 = new User();
		user3.setName("Rohan");
		user3.setCity("Mumbai");
		user3.setStatus("DE");
		
		//userRepository.deleteAll();
		List<User> users= List.of(user,user1,user2,user3);
		
		userRepository.saveAll(users);
		
		List<User> userByName = userRepository.getUserByName("Swapnil");
		userByName.forEach(e->{System.out.println(e);});
		
		System.out.println("-----------------------------------------------");
		
		List<User> userLists = userRepository.getUsers();
		userLists.forEach(e->{System.out.println(e);});
		
	}

}
