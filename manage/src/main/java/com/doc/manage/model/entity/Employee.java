package com.doc.manage.model.entity;

import javax.persistence.*;

@Entity
@Table (name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ManyToOne //что сюда можно добавить?
    private Subdivision id;

    @Column(name = "employee_surname", nullable = false)
    private String surname;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "employee_patronymic", nullable = false)
    private String patronymic;

    @Column(name = "employee_position", nullable = false)
    private String position;

    //========================== ID
    public Subdivision getId() {
        return id;
    }
    public void setId(Subdivision id) {
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
}
