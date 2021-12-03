package com.doc.manage.model.entity;

import com.doc.manage.model.dto.employee.SubdivDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_surname", nullable = false)
    private String surname;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "employee_patronymic", nullable = false)
    private String patronymic;

    @Column(name = "employee_position", nullable = false)
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivision_id")
    private Subdivision subdivision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_task",
    joinColumns = @JoinColumn(name = "empl_id"),
    inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employees_executors",
    joinColumns = @JoinColumn(name = "em_id"),
    inverseJoinColumns = @JoinColumn(name = "execut_id"))
    private List<Task> taskExec = new ArrayList<>();

    //========================== ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //========================== SURNAME
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    //========================== NAME
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //========================== PATRONYMIC
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    //========================== POSITION
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    //========================== Subdivision (работник принадлежит отделу)
    public Subdivision getSubdivision() {
        return subdivision;
    }
    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }
    //==========================
    public Organization getOrganization() {
        return organization;
    }
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    //==========================
    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    //==========================
    public List<Task> getTaskExec() {
        return taskExec;
    }
    public void setTaskExec(List<Task> taskExec) {
        this.taskExec = taskExec;
    }

}
