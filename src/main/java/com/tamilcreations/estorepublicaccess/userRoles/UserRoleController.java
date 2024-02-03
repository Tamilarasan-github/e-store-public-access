package com.tamilcreations.estorepublicaccess.userRoles;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.tamilcreations.estorepublicaccess.roles.Role;
import com.tamilcreations.estorepublicaccess.roles.RoleService;
import com.tamilcreations.estorepublicaccess.security.JwtAuthenticationFilter;
import com.tamilcreations.estorepublicaccess.users.User;
import com.tamilcreations.estorepublicaccess.users.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserRoleController
{
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@MutationMapping
	public UserRoleResponse addNewUserRole(@Argument UserRoleInput userRoleInput) throws Exception
	{
		User user = JwtAuthenticationFilter.getAuthorizationHeaderValueAndValidate(request);
		
		Role roleToMap = roleService.getRoleByRoleUuid(userRoleInput.getRoleUuid());
		User userToMap = userService.findUserByUserUuid(userRoleInput.getUserUuid());
		
		UserRole userRole = userRoleInput.toUserRole();
		userRole.setUuid(UUID.randomUUID().toString());
		userRole.setUser(userToMap);
		userRole.setRole(roleToMap);
		userRole.setDeleteFlag(false);
		userRole.setCreatedBy(user.getPhoneNumber());
		userRole.setCreatedDate(new Date());
		
		UserRole savedUserRole = userRoleService.addRoleToUser(userRole);
		
		return new UserRoleResponse(savedUserRole, "New UserRole Saved Successfully.");
	}
}
