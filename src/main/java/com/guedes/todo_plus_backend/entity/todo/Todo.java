package com.guedes.todo_plus_backend.entity.todo;

import jakarta.persistence.*;

@Entity
@Table(name = "tdp$todo")
public class Todo {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String title;
  String description;
  String numberPhone;
  boolean concluded;
  int priority;

  public Todo() {}

  public Todo(Long id, String title, String description, String numberPhone, boolean concluded, int priority) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.numberPhone = numberPhone;
    this.concluded = concluded;
    this.priority = priority;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getNumberPhone() {
    return numberPhone;
  }
  public void setNumberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
  }

  public boolean isConcluded() {
    return concluded;
  }
  public void setConcluded(boolean concluded) {
    this.concluded = concluded;
  }

  public int getPriority() {
    return priority;
  }
  public void setPriority(int priority) {
    this.priority = priority;
  }
}
