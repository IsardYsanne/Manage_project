package com.doc.manage.model.dto.organization;

import com.doc.manage.model.entity.Employee;

public class OrganizationGetDto {

    private String name;

    private String physAddress;

    private String legAddress;

    private DirectorDto director;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhysAddress() {
        return physAddress;
    }
    public void setPhysAddress(String physAddress) {
        this.physAddress = physAddress;
    }

    public String getLegAddress() {
        return legAddress;
    }
    public void setLegAddress(String legAddress) {
        this.legAddress = legAddress;
    }

    public DirectorDto getDirector() {
        return director;
    }
    public void setDirector(DirectorDto director) {
        this.director = director;
    }
}
