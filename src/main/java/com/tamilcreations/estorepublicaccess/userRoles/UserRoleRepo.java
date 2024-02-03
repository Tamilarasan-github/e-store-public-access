package com.tamilcreations.estorepublicaccess.userRoles;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface UserRoleRepo extends JpaRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole>
{
	@Query(value ="SELECT * from UserRoles u WHERE u.role_id= :roleId ", nativeQuery =true)
	Optional<UserRole> findByRoleId(long roleId);
	
	@Query(value ="SELECT * from UserRoles u WHERE u.user_id= :userId ", nativeQuery =true)
	List<UserRole> findUserRoleByUserId(Long userId);
	
	@Query(value ="SELECT u.role_id from UserRoles u WHERE u.user_id= :userId ", nativeQuery =true)
	Optional<Long> findRoleIdByUserId(Long userId);
}
