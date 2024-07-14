package com.guedes.todo_plus_backend.controller;

import com.guedes.todo_plus_backend.entity.todo.Todo;
import com.guedes.todo_plus_backend.service.todo.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public List<Todo> get() {
    return todoService.gelAllTodos();
  }

  @PostMapping
  public List<Todo> createTodo(@RequestBody Todo todo){
    return todoService.createTodo(todo);
  }

  @PutMapping
  public List<Todo> updateTodo(@RequestBody Todo todo) {
    return todoService.updateTodo(todo);
  }

  @DeleteMapping("{id}")
  public List<Todo> deleteTodo( @PathVariable("id") Long id) {
    return todoService.deleteTodo(id);
  }

}
