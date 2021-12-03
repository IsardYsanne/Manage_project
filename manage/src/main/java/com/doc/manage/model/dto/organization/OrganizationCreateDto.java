package com.doc.manage.model.dto.organization;

import javax.persistence.Column;

public class OrganizationCreateDto {

    private String name;

    private String physAddress;

    private String legAddress;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //========================== PHYS ADDRESS
    public String getPhysAddress() {
        return physAddress;
    }
    public void setPhysAddress(String physAddress) {
        this.physAddress = physAddress;
    }
    //========================== LEGAL ADDRESS
    public String getLegAddress() {
        return legAddress;
    }
    public void setLegAddress(String legAddress) {
        this.legAddress = legAddress;
    }
}
