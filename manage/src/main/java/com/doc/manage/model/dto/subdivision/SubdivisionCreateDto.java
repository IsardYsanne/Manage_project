package com.doc.manage.model.dto.subdivision;

import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;

import javax.persistence.*;

public class SubdivisionCreateDto {


    private String name;

    private String contacts;



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

}
