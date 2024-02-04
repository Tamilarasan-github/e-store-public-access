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
	private UserService userService;
	
	@QueryMapping
	public User getUser(@Argument long userId)
	{
		return userService.getUser(userId);
	}
	
	@QueryMapping
	public UserResponse login(@Argument  String phoneNumber, @Argument String password) throws Exception
	{
		return userService.authenticateUser(phoneNumber, password);
	}
		
	@MutationMapping
	public UserResponse registerNewUser(@Argument  UserInput userInput) throws Exception
	{
		return userService.registerNewUser(userInput);
	}
	
}
