package com.guedes.todo_plus_backend.entity;

public class ErrorException {
  private int statusCode;
  private String error;
  private String descripition;

  public ErrorException(int statusCode, String error, String descripition) {
    this.statusCode = statusCode;
    this.error = error;
    this.descripition = descripition;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getDescripition() {
    return descripition;
  }

  public void setDescripition(String descripition) {
    this.descripition = descripition;
  }
}
