package com.example.todolistV2.service;

import com.example.todolistV2.entity.Todo;
import com.example.todolistV2.mapper.TodoMapper;
import com.example.todolistV2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.TodoFullDataDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.todolistV2.constant.ApplicationCostants.TODO_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TodoService{

  private final TodoRepository repository;

  private final TodoMapper mapper;


  public void addTodo(String title){
    Todo entity = new Todo();
    if(title.isEmpty())
      title = "New Task";
    entity.setTitle(title);
    entity.setCreatedAt(LocalDateTime.now());
    repository.save(entity);
  }

  public TodoFullDataDto updateTitle(Long id, String title) throws Exception {
    Todo entity = repository.findById(id)
      .orElseThrow(()-> new Exception(TODO_NOT_FOUND));
    if(title.isEmpty())
      title = "Edited Task";
    entity.setTitle(title);

    repository.save(entity);
    return mapper.toDto(entity);
  }

  public TodoFullDataDto updateToggle(Long id) throws Exception {
    Todo entity = repository.findById(id)
      .orElseThrow(()-> new Exception(TODO_NOT_FOUND));

    entity.setToggle(!entity.isToggle());

    repository.save(entity);
    return mapper.toDto(entity);
  }

  public TodoFullDataDto updateDelete(Long id) throws Exception {
    Todo entity = repository.findById(id)
      .orElseThrow(()-> new Exception(TODO_NOT_FOUND));

    if(!entity.isDelete()){
      entity.setDelete(true);
    }
    repository.save(entity);
    return mapper.toDto(entity);
  }


  public List<TodoFullDataDto> findAllTodo(){
    List<Todo> entities = repository.findAllOrdered();
    List<TodoFullDataDto> dtos = new ArrayList<>();
    for(Todo entity : entities){
      dtos.add(mapper.toDto(entity));
    }
    return dtos;
  }

}
