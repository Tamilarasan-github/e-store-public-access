package com.tamilcreations.estorepublicaccess.roles;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamilcreations.estorepublicaccess.userRoles.UserRoleRepo;

@Service
public class RoleService
{
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	public Role getRoleByRoleUuid(String roleUuid)
	{
		Optional<Role> roleOptional = roleRepo.findRoleByRoleUuid(roleUuid);
		
		if(roleOptional.isPresent())
		{
			return roleOptional.get();
		}
		else
		{
			throw new RuntimeException("Role UUID is not found");
		}
	}
	
	public Role getRoleByRoleId(Long roleId)
	{
		Optional<Role> roleOptional = roleRepo.findRoleByRoleId(roleId);
		
		if(roleOptional.isPresent())
		{
			return roleOptional.get();
		}
		else
		{
			throw new RuntimeException("Role ID is not found");
		}
	}
	
	public String getRoleNameByRoleId(Long roleId)
	{
		Optional<String> roleOptional = roleRepo.findRoleNameByRoleId(roleId);
		
		if(roleOptional.isPresent())
		{
			return roleOptional.get();
		}
		else
		{
			throw new RuntimeException("Role ID is not found");
		}
	}
	
		
	public Role addNewRole(Role role)
	{		
		return roleRepo.saveAndFlush(role);
	}
}
