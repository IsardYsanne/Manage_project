package com.doc.manage.model.dto.employee;

import com.doc.manage.model.entity.Organization;
import com.doc.manage.model.entity.Subdivision;

public class EmployeeUpdateDto {

    private Integer id;

    private String surname;

    private String name;

    private String patronymic;

    private String position;

    private Integer subdivisionId;

    private Integer organizationId;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSubdivisionId() {
        return subdivisionId;
    }
    public void setSubdivisionId(Integer subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
