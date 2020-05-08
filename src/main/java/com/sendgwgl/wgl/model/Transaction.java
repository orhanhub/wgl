package com.sendgwgl.wgl.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codename;
    private String issuername;
    @ManyToOne
    @JoinColumn(name="CREATORID")
    private Account account;
    @Generated(GenerationTime.INSERT)
    private Date createdat;

    protected  Transaction () {}

    public Transaction(Long id) {
        this.id = id;
    }

    public Transaction(Long id, String codename, String issuername, Account account, Date createdat) {
        this.id = id;
        this.codename = codename;
        this.issuername = issuername;
        this.account = account;
        this.createdat = createdat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getIssuername() {
        return issuername;
    }

    public void setIssuername(String issuername) {
        this.issuername = issuername;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
}
