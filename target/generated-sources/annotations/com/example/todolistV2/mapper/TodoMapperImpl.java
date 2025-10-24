package com.example.todolistV2.mapper;

import com.example.todolistV2.entity.Todo;
import javax.annotation.processing.Generated;
import org.openapitools.model.TodoFullDataDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-24T09:38:04+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public TodoFullDataDto toDto(Todo entity) {
        if ( entity == null ) {
            return null;
        }

        TodoFullDataDto todoFullDataDto = new TodoFullDataDto();

        todoFullDataDto.setTitle( entity.getTitle() );
        todoFullDataDto.setToggle( entity.isToggle() );
        todoFullDataDto.setDelete( entity.isDelete() );
        todoFullDataDto.setId( entity.getId() );

        return todoFullDataDto;
    }
}
