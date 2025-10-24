package com.example.todolistV2.mapper;

import com.example.todolistV2.entity.Todo;
import org.mapstruct.Mapper;
import org.openapitools.model.TodoFullDataDto;

@Mapper(componentModel="spring")
public interface TodoMapper {

   TodoFullDataDto toDto(Todo entity);
}
