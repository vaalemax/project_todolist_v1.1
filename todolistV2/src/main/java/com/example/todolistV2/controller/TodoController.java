package com.example.todolistV2.controller;

import com.example.todolistV2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TodoApi;
import org.openapitools.model.TodoFormDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TodoController implements TodoApi {

  private final TodoService service;

  @GetMapping("/")
  public String getPage(Model model) {
    model.addAttribute("todos", service.findAllTodo());
    model.addAttribute("todoForm", new TodoFormDto());
    return "template";
  }

  @Override
  public ResponseEntity<String> getAllTodos(){
    service.findAllTodo();
    return ResponseEntity.ok().build();
  }

  @Override
  @PostMapping(value = "/todo", consumes = {"application/x-www-form-urlencoded", "text/plain"})
  public ResponseEntity<Void> createTodo(@RequestParam String title){
    service.addTodo(title);
    return ResponseEntity.status(302).header("Location", "/").build();
  }

  @Override
  @PatchMapping(value = "/todo/{id}", consumes = {"application/x-www-form-urlencoded", "text/plain"})
  public ResponseEntity<Void> updateTitle(@PathVariable Long id, @RequestParam String title) throws Exception {
    service.updateTitle(id, title);
    return ResponseEntity.status(302).header("Location", "/").build();
  }

  @Override
  @PatchMapping(value = "/todo/toggle/{id}", consumes = "application/x-www-form-urlencoded")
  public ResponseEntity<Void> updateToggle(@PathVariable Long id) throws Exception {
    service.updateToggle(id);
    return ResponseEntity.status(302).header("Location", "/").build();
  }

  @Override
  @DeleteMapping(value = "/todo/{id}", consumes = {"application/x-www-form-urlencoded", "text/plain"})
  public ResponseEntity<Void> updateDelete(@PathVariable Long id) throws Exception {
    service.updateDelete(id);
    return ResponseEntity.status(302).header("Location", "/").build();
  }


}
