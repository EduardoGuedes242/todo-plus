package com.guedes.todo_plus_backend.service.user;

import com.guedes.todo_plus_backend.entity.user.User;
import com.guedes.todo_plus_backend.exceptions.LoginExistenteException;
import com.guedes.todo_plus_backend.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;




  public void createUser(User user) {
    Optional<User> userFind = userRepository.findByEmail(user.getEmail());
    if(userFind != null) {
      throw new LoginExistenteException();
    }
    userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

}
