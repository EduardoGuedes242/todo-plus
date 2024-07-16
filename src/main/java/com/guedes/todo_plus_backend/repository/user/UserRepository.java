package com.guedes.todo_plus_backend.repository.user;

import com.guedes.todo_plus_backend.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  public abstract User findByEmail(String email);
}
