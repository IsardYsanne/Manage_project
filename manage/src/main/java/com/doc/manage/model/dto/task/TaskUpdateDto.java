package com.doc.manage.model.dto.task;

import java.util.Date;

public class TaskUpdateDto {

    private Integer id;

    private Integer type;

    private Integer author;

    private Integer executor;

    private Date date;

    private Boolean control;

    private Boolean execution;

    private String instruction;

    private Integer state;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAuthor() {
        return author;
    }
    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getExecutor() {
        return executor;
    }
    public void setExecutor(Integer executor) {
        this.executor = executor;
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

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
}
