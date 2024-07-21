package com.guedes.todo_plus_backend.repository.user;

import com.guedes.todo_plus_backend.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
