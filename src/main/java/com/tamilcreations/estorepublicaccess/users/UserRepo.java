package com.tamilcreations.estorepublicaccess.users;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;



public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>
{
	Optional<User> findByUserId(long userId);
	
	@Query(value ="SELECT * from Users u WHERE u.uuid= :userUuid ", nativeQuery =true)
	Optional<User> findUserByUserUuid(String userUuid);
	
	@Query(value ="SELECT * from Users u WHERE u.phone_number= :phoneNumber ", nativeQuery =true)
	Optional<User> findUserByPhoneNumber(String phoneNumber);
	
	@Query(value ="SELECT * from Users u WHERE u.email_id= :emailId ", nativeQuery =true)
	Optional<User> findUserByEmailId(String emailId);
	
	@Query(value ="SELECT * from Users u WHERE u.user_name= :userName ", nativeQuery =true)
	Optional<User> findUserByUserName(String userName);
}
