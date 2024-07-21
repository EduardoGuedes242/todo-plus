package com.guedes.todo_plus_backend.service.user;

import com.guedes.todo_plus_backend.entity.user.User;
import com.guedes.todo_plus_backend.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public void createUser(User user) {
    userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

}
