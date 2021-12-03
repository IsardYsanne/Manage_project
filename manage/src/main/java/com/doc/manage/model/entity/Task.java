package com.doc.manage.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_type")
    private Categories category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_author")
    private Employee employeeAuthor;

    @Column(name = "task_executor", nullable = true)
    private Integer executor;

    @Column(name = "task_date", nullable = true)
    private Date date;

    @Column(name = "task_control_sign", nullable = true)
    private Boolean control;

    @Column(name = "task_execution_sign", nullable = true)
    private Boolean execution;

    @Column(name = "task_instruction", nullable = false)
    private String instruction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private States status;

    @ManyToMany(mappedBy = "tasks")
    private List<Employee> employees = new ArrayList<>();

    @ManyToMany(mappedBy = "taskExec")
    private List<Employee> employeeExecutor = new ArrayList<>();

    //========================== ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //========================== TYPE to Category
    public Categories getCategory() {
        return category;
    }
    public void setCategory(Categories category) {
        this.category = category;
    }
    //========================== AUTHOR
    public Employee getEmployeeAuthor() {
        return employeeAuthor;
    }
    public void setEmployeeAuthor(Employee employeeAuthor) {
        this.employeeAuthor = employeeAuthor;
    }
    //========================== EXECUTOR
    public Integer getExecutor() {
        return executor;
    }
    public void setExecutor(Integer executor) {
        this.executor = executor;
    }
    //========================== DATE
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    //========================== CONTROL
    public Boolean getControl() {
        return control;
    }
    public void setControl(Boolean control) {
        this.control = control;
    }
    //========================== EXECUTION
    public Boolean getExecution() {
        return execution;
    }
    public void setExecution(Boolean execution) {
        this.execution = execution;
    }
    //========================== INSTRUCTION
    public String getInstruction() {
        return instruction;
    }
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    //========================== STATE
    public States getStatus() {
        return status;
    }
    public void setStatus(States status) {
        this.status = status;
    }
    //==========================
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    //==========================
    public List<Employee> getEmployeeExecutor() {
        return employeeExecutor;
    }
    public void setEmployeeExecutor(List<Employee> employeeExecutor) {
        this.employeeExecutor = employeeExecutor;
    }
}
