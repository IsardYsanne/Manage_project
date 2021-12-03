package com.doc.manage.mapper;

import com.doc.manage.model.dto.task.TaskCreateDto;
import com.doc.manage.model.dto.task.TaskDto;
import com.doc.manage.model.dto.task.TaskUpdateDto;
import com.doc.manage.model.entity.Task;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDtoTask(Task entity);

    Task toEntity(TaskCreateDto taskCreateDto);

    @Mapping(target = "executor")
    @Mapping(target = "date")
    @Mapping(target = "control")
    @Mapping(target = "execution")
    @Mapping(target = "instruction")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, ignoreByDefault = true)
    Task toUpdateDto(@MappingTarget Task entity, TaskUpdateDto taskUpdateDto);

}
