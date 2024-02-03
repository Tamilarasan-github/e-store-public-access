package com.tamilcreations.estorepublicaccess.roles;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.tamilcreations.estorepublicaccess.security.JwtAuthenticationFilter;
import com.tamilcreations.estorepublicaccess.users.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RoleController
{
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private RoleService roleService;
	
	@MutationMapping
	public RoleResponse addNewRole(@Argument RoleInput roleInput) throws Exception
	{
		User user = JwtAuthenticationFilter.getAuthorizationHeaderValueAndValidate(request);
		
		Role role = roleInput.toRole();
		role.setUuid(UUID.randomUUID().toString());
		role.setDeleteFlag(false);
		role.setCreatedBy(user.getPhoneNumber());
		role.setCreatedDate(new Date());
		
		Role savedRole = roleService.addNewRole(role);
		
		return new RoleResponse(savedRole, "New Role Saved Successfully.");
	}
}
