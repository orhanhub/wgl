package com.sendgwgl.wgl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "codename")
    private String codename;

    @JsonProperty(value = "issuername")
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

    public Transaction(String codename, String issuername) {
        this.codename = codename;
        this.issuername = issuername;
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
