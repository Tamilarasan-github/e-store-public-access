package com.tamilcreations.estorepublicaccess.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController
{
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	@QueryMapping
	public User getUser(@Argument long userId) throws Exception
	{
		return userService.getUser(userId);
	}
	
	@QueryMapping
	public UserResponse login(@Argument  String phoneNumber, @Argument String password) throws Exception
	{
		return userService.authenticateUser(phoneNumber, password);
	}
	
//	@QueryMapping
//	public User authenticateUser(@Argument  UserInput userInput) throws Exception
//	{
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String phoneNumber = userInput.getPhoneNumber();
//		String encyptedPassword = encoder.encode(userInput.getPassword());
//		return null;
//	}
	
	@MutationMapping
	public UserResponse registerNewUser(@Argument  UserInput userInput) throws Exception
	{
		return userService.registerNewUser(userInput);
	}
	
}
