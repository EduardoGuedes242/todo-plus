package com.guedes.todo_plus_backend.service.auth;

import com.guedes.todo_plus_backend.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthorizationService {
  @Autowired
  UserRepository userRepository;

  public UserDetails loadUserByUsername(String username) {
    return userRepository.findByEmail(username);
  }
}
