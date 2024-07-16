package com.guedes.todo_plus_backend.exceptions;

public class LoginExistenteException extends  RuntimeException {

  public LoginExistenteException() {
    super("Ja existe um usuario com este email informado.");
  }

  public LoginExistenteException(String message) {
    super(message);
  }

}
