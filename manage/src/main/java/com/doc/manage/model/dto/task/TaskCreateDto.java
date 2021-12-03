package com.doc.manage.model.dto.task;

import java.util.Date;

public class TaskCreateDto {

    private Date date;

    private Boolean control;

    private Boolean execution;

    private String instruction;

    private Integer executor; //


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

    public Integer getExecutor() {
        return executor;
    }
    public void setExecutor(Integer executor) {
        this.executor = executor;
    }
}
