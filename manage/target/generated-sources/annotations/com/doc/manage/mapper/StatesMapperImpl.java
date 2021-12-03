package com.doc.manage.mapper;

import com.doc.manage.model.dto.states.StatesDto;
import com.doc.manage.model.dto.task.TaskStatesDto;
import com.doc.manage.model.entity.States;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T18:25:57+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class StatesMapperImpl implements StatesMapper {

    @Override
    public TaskStatesDto toStates(States entity) {
        if ( entity == null ) {
            return null;
        }

        TaskStatesDto taskStatesDto = new TaskStatesDto();

        taskStatesDto.setStateName( entity.getStateName() );

        return taskStatesDto;
    }

    @Override
    public StatesDto toDto(States entity) {
        if ( entity == null ) {
            return null;
        }

        StatesDto statesDto = new StatesDto();

        statesDto.setId( entity.getId() );
        statesDto.setStateName( entity.getStateName() );

        return statesDto;
    }
}
