package com.doc.manage.service;

import com.doc.manage.mapper.*;
import com.doc.manage.model.dto.task.*;
import com.doc.manage.model.entity.Categories;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.States;
import com.doc.manage.model.entity.Task;
import com.doc.manage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;

    @Autowired
    public TaskMapper taskMapper;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeMapper employeeMapper;

    @Autowired
    public OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationMapper organizationMapper;

    @Autowired
    public SubdivisionRepository subdivisionRepository;

    @Autowired
    public SubdivisionMapper subdivisionMapper;

    @Autowired
    public CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesMapper categoriesMapper;

    @Autowired
    public StatesRepository statesRepository;

    @Autowired
    public StatesMapper statesMapper;

    public TaskDto findById(Integer id){

        final Task task = taskRepository.findById(id).orElse(new Task());
        final Employee taskAuthor = task.getEmployeeAuthor();
        final Categories category = task.getCategory();
        final States state = task.getStatus();

        final AuthorEmployeeDto authorEmployeeDto = employeeMapper.toAuthorDto(taskAuthor);
        final TaskCategoriesDto taskCategoriesDto = categoriesMapper.toCategory(category);
        final TaskStatesDto taskStatesDto = statesMapper.toStates(state);

        final TaskDto taskDto = taskMapper.toDtoTask(task);
        taskDto.setAuthor(authorEmployeeDto);
        taskDto.setTaskCategoriesDto(taskCategoriesDto);
        taskDto.setTaskStatesDto(taskStatesDto);

        return taskDto;
    }

    public void createTask(Integer authorId, Integer typeId, Integer stateId, TaskCreateDto taskCreateDto){

        final Employee author = employeeRepository.findById(authorId).orElse(null);
        final Categories type = categoriesRepository.findById(typeId).orElse(null);
        final States state = statesRepository.findById(stateId).orElse(null);

        final Task task = taskMapper.toEntity(taskCreateDto);
        task.setEmployeeAuthor(author);
        task.setCategory(type);
        task.setStatus(state);
        taskRepository.save(task);
    }

    public TaskDto updateTask(Integer id, TaskUpdateDto taskUpdateDto){

        final Task task = taskRepository.findById(id).orElse(null);
        final Employee author = task.getEmployeeAuthor();
        final AuthorEmployeeDto authorDto = employeeMapper.toAuthorDto(author);

        final Categories type = task.getCategory();
        final Integer typeId = type.getId();
        final Categories category = categoriesRepository.findById(typeId).orElse(null);
        final TaskCategoriesDto taskCategoriesDto = categoriesMapper.toCategory(category);

        final States state = task.getStatus();
        final Integer stateId = state.getId();
        final States states = statesRepository.findById(stateId).orElse(null);
        final TaskStatesDto taskStatesDto = statesMapper.toStates(states);

        final Task taskUpdated = taskMapper.toUpdateDto(task, taskUpdateDto);
        if(category != null) taskUpdated.setCategory(category);
        if(states != null) taskUpdated.setStatus(states);

        final Task taskUp = taskRepository.save(taskUpdated);
        final TaskDto taskDto = taskMapper.toDtoTask(taskUp);
        taskDto.setAuthor(authorDto);
        taskDto.setTaskCategoriesDto(taskCategoriesDto);
        taskDto.setTaskStatesDto(taskStatesDto);

        return taskDto;
    }

    public void deleteTask(Integer id){

        final Task task = taskRepository.findById(id).orElse(new Task());
        taskRepository.delete(task);
    }

    public TaskDto findByExecutor(Integer executor){
        final Task task = taskRepository.findByExecutor(executor).orElse(new Task());
        final Categories type = task.getCategory();
        final TaskCategoriesDto taskCategoriesDto = categoriesMapper.toCategory(type);
        final States states = task.getStatus();
        final TaskStatesDto taskStatesDto = statesMapper.toStates(states);
        final Employee authorEmpl = task.getEmployeeAuthor();
        final AuthorEmployeeDto authorDto = employeeMapper.toAuthorDto(authorEmpl);
        final TaskDto taskDto = taskMapper.toDtoTask(task);
        taskDto.setTaskCategoriesDto(taskCategoriesDto);
        taskDto.setTaskStatesDto(taskStatesDto);
        taskDto.setAuthor(authorDto);

        return taskDto;
    }
}
