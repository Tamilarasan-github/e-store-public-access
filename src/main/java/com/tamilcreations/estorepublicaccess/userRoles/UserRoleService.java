package com.tamilcreations.estorepublicaccess.userRoles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService
{
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	public List<UserRole> getUserRoleByUserId(Long userId)
	{
		List<UserRole> userRolesList = userRoleRepo.findUserRoleByUserId(userId);
		return userRolesList;
	}
	
	public Long getRoleIdByUserId(Long userId)
	{
		Optional<Long> userRoleOptional = userRoleRepo.findRoleIdByUserId(userId);
		
		if(userRoleOptional.isPresent())
		{
			return userRoleOptional.get();
		}
		else
		{
			throw new RuntimeException("User Role is not found");
		}
	}
	
	public UserRole addRoleToUser(UserRole userRole)
	{		
		return userRoleRepo.saveAndFlush(userRole);
	}
}
