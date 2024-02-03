package com.tamilcreations.estorepublicaccess.userRoles;

import java.util.List;

public class UserRoleResponse
{
	private UserRole userRole;
	
	private List<UserRole> userRoles;
	
	private String sucessMessage;
	
	private String errorMessage;

	
	
	
	
	public UserRoleResponse(String errorMessage)
	{
		super();
		this.errorMessage = errorMessage;
	}
	
	

	public UserRoleResponse(List<UserRole> userRoles, String sucessMessage)
	{
		super();
		this.userRoles = userRoles;
		this.sucessMessage = sucessMessage;
	}



	public UserRoleResponse(UserRole userRole, String sucessMessage)
	{
		super();
		this.userRole = userRole;
		this.sucessMessage = sucessMessage;
	}

	public UserRole getUserRole()
	{
		return userRole;
	}

	public void setUserRole(UserRole userRole)
	{
		this.userRole = userRole;
	}

	public List<UserRole> getUserRoles()
	{
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles)
	{
		this.userRoles = userRoles;
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
