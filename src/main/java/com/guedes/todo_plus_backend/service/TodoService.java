package com.guedes.todo_plus_backend.service;

import com.guedes.todo_plus_backend.entity.Todo;
import com.guedes.todo_plus_backend.repository.TodoRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> gelAllTodos() {
    return todoRepository.findAll();
  }

  public List<Todo> createTodo(Todo todo) {
    todoRepository.save(todo);
    return gelAllTodos();
  }

  public List<Todo> updateTodo(Todo todo) {
    todoRepository.save(todo);
    return gelAllTodos();
  }

  public List<Todo> deleteTodo(Long id) {
    todoRepository.deleteById(id);
    return gelAllTodos();
  }
}
