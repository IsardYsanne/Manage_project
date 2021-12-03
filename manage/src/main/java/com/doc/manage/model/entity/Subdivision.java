package com.doc.manage.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subdivision")
public class Subdivision {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "subdivision_name", nullable = false)
    private String name;

    @Column(name = "subdivision_contacts", nullable = false)
    private String contacts;

    @PrimaryKeyJoinColumn
    @OneToOne(orphanRemoval = true)
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization org;


    //========================== ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //========================== NAME
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //========================== CONTACTS
    public String getContacts() {
        return contacts;
    }
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    //========================== MANAGER
    public Employee getManager() {
        return manager;
    }
    public void setManager(Employee manager) {
        this.manager = manager;
    }
    //========================== to organization
    public Organization getOrg() {
        return org;
    }
    public void setOrg(Organization org) {
        this.org = org;
    }

}
