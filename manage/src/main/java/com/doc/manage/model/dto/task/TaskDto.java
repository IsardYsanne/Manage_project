package com.doc.manage.model.dto.task;

import com.doc.manage.model.entity.Categories;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.States;

import java.util.ArrayList;
import java.util.Date;

public class TaskDto {

    private Integer id;

    private TaskCategoriesDto taskCategoriesDto;

    private AuthorEmployeeDto author;

    private Integer executor;

    private Date date;

    private Boolean control;

    private Boolean execution;

    private String instruction;

    private TaskStatesDto taskStatesDto;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getControl() {
        return control;
    }
    public void setControl(Boolean control) {
        this.control = control;
    }

    public Boolean getExecution() {
        return execution;
    }
    public void setExecution(Boolean execution) {
        this.execution = execution;
    }

    public String getInstruction() {
        return instruction;
    }
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public TaskCategoriesDto getTaskCategoriesDto() {
        return taskCategoriesDto;
    }
    public void setTaskCategoriesDto(TaskCategoriesDto taskCategoriesDto) {
        this.taskCategoriesDto = taskCategoriesDto;
    }

    public AuthorEmployeeDto getAuthor() {
        return author;
    }
    public void setAuthor(AuthorEmployeeDto author) {
        this.author = author;
    }

    public Integer getExecutor() {
        return executor;
    }
    public void setExecutor(Integer executor) {
        this.executor = executor;
    }

    public TaskStatesDto getTaskStatesDto() {
        return taskStatesDto;
    }
    public void setTaskStatesDto(TaskStatesDto taskStatesDto) {
        this.taskStatesDto = taskStatesDto;
    }
}
