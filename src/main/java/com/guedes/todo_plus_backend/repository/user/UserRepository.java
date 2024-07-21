package com.guedes.todo_plus_backend.repository.user;

import com.guedes.todo_plus_backend.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  public abstract User findByEmail(String email);
  //Optional<User> findByEmail(String email);
}
