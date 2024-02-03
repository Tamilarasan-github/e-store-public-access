package com.tamilcreations.estorepublicaccess.roles;

import java.util.List;

public class RoleResponse
{
	private Role user;
	
	private List<Role> users;
	
	private String sucessMessage;
	
	private String errorMessage;
	
	
	
	

	public RoleResponse(List<Role> users, String sucessMessage)
	{
		super();
		this.users = users;
		this.sucessMessage = sucessMessage;
	}

	public RoleResponse(Role user, String sucessMessage)
	{
		super();
		this.user = user;
		this.sucessMessage = sucessMessage;
	}

	public RoleResponse(String errorMessage)
	{
		super();
		this.errorMessage = errorMessage;
	}

	public Role getRole()
	{
		return user;
	}

	public void setRole(Role user)
	{
		this.user = user;
	}

	public List<Role> getRoles()
	{
		return users;
	}

	public void setRoles(List<Role> users)
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
