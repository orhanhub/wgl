package com.sendgwgl.wgl.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private String mobilenumber;

    @ManyToOne
    @JoinColumn(name="COMPANYID")
    private Company companyid;

    private Boolean activestatus;

    @Generated(GenerationTime.INSERT)
    private Date createdat;

    protected Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    public Account(Long id, String email, String password, String firstname, String lastname, String mobilenumber, Company companyid, Boolean activestatus, Date createdat) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilenumber = mobilenumber;
        this.companyid = companyid;
        this.activestatus = activestatus;
        this.createdat = createdat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public Company getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Company companyid) {
        this.companyid = companyid;
    }

    public Boolean getActivestatus() {
        return activestatus;
    }

    public void setActivestatus(Boolean activestatus) {
        this.activestatus = activestatus;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
}


