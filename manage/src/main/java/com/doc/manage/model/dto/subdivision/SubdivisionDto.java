package com.doc.manage.model.dto.subdivision;

import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;

import java.util.ArrayList;
import java.util.List;

public class SubdivisionDto {

    private Integer id;

    private String name;

    private String contacts;

    private ManagerDto manager;

    private OrganizationSubdivisionDto organizationSubdivisionDto;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public ManagerDto getManager() {
        return manager;
    }
    public void setManager(ManagerDto manager) {
        this.manager = manager;
    }

    public OrganizationSubdivisionDto getOrganizationSubdivisionDto() {
        return organizationSubdivisionDto;
    }

    public void setOrganizationSubdivisionDto(OrganizationSubdivisionDto organizationSubdivisionDto) {
        this.organizationSubdivisionDto = organizationSubdivisionDto;
    }
}
