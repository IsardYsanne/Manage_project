package com.doc.manage.mapper;

import com.doc.manage.model.dto.task.TaskCreateDto;
import com.doc.manage.model.dto.task.TaskDto;
import com.doc.manage.model.dto.task.TaskUpdateDto;
import com.doc.manage.model.entity.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T18:25:57+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toDtoTask(Task entity) {
        if ( entity == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setId( entity.getId() );
        taskDto.setDate( entity.getDate() );
        taskDto.setControl( entity.getControl() );
        taskDto.setExecution( entity.getExecution() );
        taskDto.setInstruction( entity.getInstruction() );
        taskDto.setExecutor( entity.getExecutor() );

        return taskDto;
    }

    @Override
    public Task toEntity(TaskCreateDto taskCreateDto) {
        if ( taskCreateDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setExecutor( taskCreateDto.getExecutor() );
        task.setDate( taskCreateDto.getDate() );
        task.setControl( taskCreateDto.getControl() );
        task.setExecution( taskCreateDto.getExecution() );
        task.setInstruction( taskCreateDto.getInstruction() );

        return task;
    }

    @Override
    public Task toUpdateDto(Task entity, TaskUpdateDto taskUpdateDto) {
        if ( taskUpdateDto == null ) {
            return null;
        }

        if ( taskUpdateDto.getExecutor() != null ) {
            entity.setExecutor( taskUpdateDto.getExecutor() );
        }
        if ( taskUpdateDto.getDate() != null ) {
            entity.setDate( taskUpdateDto.getDate() );
        }
        if ( taskUpdateDto.getControl() != null ) {
            entity.setControl( taskUpdateDto.getControl() );
        }
        if ( taskUpdateDto.getExecution() != null ) {
            entity.setExecution( taskUpdateDto.getExecution() );
        }
        if ( taskUpdateDto.getInstruction() != null ) {
            entity.setInstruction( taskUpdateDto.getInstruction() );
        }

        return entity;
    }
}
