package com.guedes.todo_plus_backend.exceptions;

public class UserNaoAutenticado extends RuntimeException {

  public UserNaoAutenticado() {
    super("O Usuario nao foi identificado");
  }

  public UserNaoAutenticado(String message) {
    super(message);
  }
}
