package com.tamilcreations.estorepublicaccess.users;

import java.util.List;

public class UserResponse
{
	private User user;
	
	private List<User> users;
	
	private String sucessMessage;
	
	private String errorMessage;
	
	
	
	

	public UserResponse(List<User> users, String sucessMessage)
	{
		super();
		this.users = users;
		this.sucessMessage = sucessMessage;
	}

	public UserResponse(User user, String sucessMessage)
	{
		super();
		this.user = user;
		this.sucessMessage = sucessMessage;
	}

	public UserResponse(String errorMessage)
	{
		super();
		this.errorMessage = errorMessage;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	public String getSucessMessage()
	{
		return sucessMessage;
	}

	public void setSucessMessage(String sucessMessage)
	{
		this.sucessMessage = sucessMessage;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	
	
	
}
