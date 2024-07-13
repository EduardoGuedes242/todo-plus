package com.guedes.todo_plus_backend.repository;

import com.guedes.todo_plus_backend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
