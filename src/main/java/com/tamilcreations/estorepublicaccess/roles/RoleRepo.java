package com.tamilcreations.estorepublicaccess.roles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>
{
	Optional<Role> findByRoleId(long roleId);
	
	@Query(value ="SELECT * from Roles u WHERE u.uuid= :roleUuid ", nativeQuery =true)
	Optional<Role> findRoleByRoleUuid(String roleUuid);
	
	@Query(value ="SELECT * from Roles u WHERE u.role_id= :roleId ", nativeQuery =true)
	Optional<Role> findRoleByRoleId(Long roleId);
	
	@Query(value ="SELECT u.role_name from Roles u WHERE u.role_id= :roleId ", nativeQuery =true)
	Optional<String> findRoleNameByRoleId(Long roleId);
	
	
	
}
