package com.doc.manage.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "org_name", nullable = false)
    private String name;

    @Column(name = "org_phys_address", nullable = false)
    private String physAddress;

    @Column(name = "org_legal_address", nullable = false)
    private String legAddress;

    @PrimaryKeyJoinColumn
    @OneToOne(orphanRemoval = true)
    private Employee director;

    //========================== ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //========================== ORG NAME
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
    //========================== DIRECTOR
    public Employee getDirector() {
        return director;
    }
    public void setDirector(Employee director) {
        this.director = director;
    }

}
