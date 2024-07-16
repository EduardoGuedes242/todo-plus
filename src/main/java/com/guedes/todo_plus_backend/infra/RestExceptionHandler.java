package com.guedes.todo_plus_backend.infra;

import com.guedes.todo_plus_backend.entity.ErrorException;
import com.guedes.todo_plus_backend.entity.user.User;
import com.guedes.todo_plus_backend.exceptions.LoginExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(LoginExistenteException.class)
  private ResponseEntity<ErrorException> userLoginExistente(LoginExistenteException ex){
    ErrorException erro = new ErrorException(422, "Login existente",
            "Não foi possivel cadastrar o usuario pois ja existe um usuario cadastrado com memso email");

    return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(erro);
  }


}
