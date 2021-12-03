package com.doc.manage.service;

import com.doc.manage.mapper.StatesMapper;
import com.doc.manage.mapper.TaskMapper;
import com.doc.manage.model.dto.states.StatesDto;
import com.doc.manage.model.entity.States;
import com.doc.manage.repository.StatesRepository;
import com.doc.manage.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StatesService {

    @Autowired
    public StatesRepository statesRepository;

    @Autowired
    public StatesMapper statesMapper;

    @Autowired
    public TaskRepository taskRepository;

    @Autowired
    public TaskMapper taskMapper;


    public StatesDto findById(Integer id){

        final States states = statesRepository.findById(id).orElse(new States());
        final StatesDto statesDto = statesMapper.toDto(states);

        return statesDto;
    }
}
