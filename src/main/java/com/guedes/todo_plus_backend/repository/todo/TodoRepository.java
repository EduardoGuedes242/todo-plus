package com.guedes.todo_plus_backend.repository.todo;

import com.guedes.todo_plus_backend.entity.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
