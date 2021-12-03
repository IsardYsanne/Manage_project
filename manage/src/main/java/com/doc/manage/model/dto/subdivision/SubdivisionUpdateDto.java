package com.doc.manage.model.dto.subdivision;

import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;

public class SubdivisionUpdateDto {

    private Integer id;

    private String name;

    private String contacts;

    private Integer managerId;

    private Integer organizationId;



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

    public Integer getManagerId() {
        return managerId;
    }
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
