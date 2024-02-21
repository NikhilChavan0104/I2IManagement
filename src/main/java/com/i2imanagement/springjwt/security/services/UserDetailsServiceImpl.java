package com.i2imanagement.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.i2imanagement.modeladmin.Admin;
import com.i2imanagement.repository.AdminApplicationRepository;






@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  AdminApplicationRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    Admin user = userRepository.findUserById(Long.parseLong(userId));
    
    return UserDetailsImpl.build(user);
  }

}
