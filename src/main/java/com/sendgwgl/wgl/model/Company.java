package com.sendgwgl.wgl.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


//TODO: unique company name case and error if duplicate;
//TODO: error catching;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable= true)
    private Long parentid;

    protected Company(){}

    public Company(Long id) {
        this.id = id;
    }

    public Company(Long id, String name, Long parentid) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

}


