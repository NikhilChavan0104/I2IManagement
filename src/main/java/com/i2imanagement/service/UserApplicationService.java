package com.i2imanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2imanagement.modeladmin.User;
import com.i2imanagement.repository.UserRepository;

@Service
public class UserApplicationService {

	@Autowired
	UserRepository userRepository;
	
	public  User fetchByEmailId(String email) {
		
		return userRepository.fetchUserByEmail(email);
	}

	public  void saveUser(User user) {
		userRepository.save(user);
		
	}

	
	
}
