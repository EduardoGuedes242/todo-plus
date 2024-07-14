package com.guedes.todo_plus_backend.service.todo;

import com.guedes.todo_plus_backend.actions.FunctionsWhatsapp;
import com.guedes.todo_plus_backend.entity.todo.Todo;
import com.guedes.todo_plus_backend.repository.todo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  private FunctionsWhatsapp functionsWhatsapp = new FunctionsWhatsapp();

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> gelAllTodos() {

    return todoRepository.findAll();
  }

  public List<Todo> createTodo(Todo todo) {
    todoRepository.save(todo);

    functionsWhatsapp.sendMessage(
            todo.getNumberPhone(),
            "Foi criada uma nova tarefa para voce com o titulo: *" + todo.getTitle() + "*");
    return gelAllTodos();
  }

  public List<Todo> updateTodo(Todo todo) {
    todoRepository.save(todo);
    functionsWhatsapp.sendMessage(
            todo.getNumberPhone(),
            "A Tarefa *" + todo.getTitle() + "* teve atualizações");
    return gelAllTodos();
  }

  public List<Todo> deleteTodo(Long id) {
    todoRepository.deleteById(id);
    return gelAllTodos();
  }
}
