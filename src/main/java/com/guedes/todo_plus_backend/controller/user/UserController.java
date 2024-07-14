package com.guedes.todo_plus_backend.controller.user;

import com.guedes.todo_plus_backend.entity.user.User;
import com.guedes.todo_plus_backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public List<User> getAll() {
    return  userService.getAllUsers();
  }

  @PostMapping
  public String createUser(@RequestBody User user) {
    userService.createUser(user);
    return "Usuario criado com sucesso";
  }

}
