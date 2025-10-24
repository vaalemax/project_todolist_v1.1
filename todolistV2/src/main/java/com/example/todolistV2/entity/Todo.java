package com.example.todolistV2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name="todo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SQLRestriction("delete = false")


public class Todo {
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long id;

  @Column(name="title")
  private String title;

  @Column(name="toggle", columnDefinition="boolean default false")
  private boolean toggle;

  @Column(name="delete", columnDefinition="boolean default false")
  private boolean delete;

  @Column(name="createdAt", nullable = false, updatable = false)
  private LocalDateTime createdAt;
/*
    @ManyToOne
    @JoinColumn(name = "todolist")
    private TDList toDoList;*/
}
