package com.doc.manage.mapper;

import com.doc.manage.model.dto.states.StatesDto;
import com.doc.manage.model.dto.task.TaskStatesDto;
import com.doc.manage.model.entity.States;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatesMapper {

    TaskStatesDto toStates(States entity);

    StatesDto toDto(States entity);

}
