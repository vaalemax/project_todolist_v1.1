package com.example.todolistV2.repository;


import com.example.todolistV2.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  @Query("SELECT t FROM Todo t ORDER BY t.toggle ASC, t.createdAt DESC")
  List<Todo> findAllOrdered();
}
