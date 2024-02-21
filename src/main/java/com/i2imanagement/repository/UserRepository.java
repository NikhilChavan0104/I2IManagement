package com.i2imanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.i2imanagement.modeladmin.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "Select u from User u where u.email=:email")
	User fetchUserByEmail(String email);

	

//	@Query(value = "Select new com.employeemanagement.modeladmin.UserResponse(COUNT(u.id),v.vote)From User u LEFT JOIN Voating v ON u.id=v.userId Group By v.vote")
//	List<UserResponse> getUsers();
	
	

}
