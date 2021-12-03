package com.doc.manage.model.dto.employee;

public class EmployeeDto {

    private Integer id;

    private String surname;

    private String name;

    private String patronymic;

    private String position;

    private SubdivDto subdivDto;

    private OrgDto orgDto;



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

    public SubdivDto getSubdivDto() {
        return subdivDto;
    }
    public void setSubdivDto(SubdivDto subdivDto) {
        this.subdivDto = subdivDto;
    }

    public OrgDto getOrgDto() {
        return orgDto;
    }
    public void setOrgDto(OrgDto orgDto) {
        this.orgDto = orgDto;
    }
}
