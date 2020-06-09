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
@JsonRootName(value = "invitation")
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //invitedby
    @ManyToOne
    @JoinColumn(name = "INVITEDBY")
    private Account accountid;

    @JsonProperty(value = "email")
    private String email;

    //transactionid
    @ManyToOne
    @JoinColumn(name = "TRANSACTIONID")
    private Transaction transactionid;

    //companyid
    @ManyToOne
    @JoinColumn(name = "COMPANYID")
    private Company companyid;

    private boolean completion;

    @Generated(GenerationTime.INSERT)
    private Date createdat;

    @Generated(GenerationTime.INSERT)
    private Date updatedat;

    protected Invite() {
    }

    public Invite(Long id) {
        this.id = id;
    }

    public Invite(String email){
        this.email = email;
    }

    public Invite( Transaction transactionid,  String email, boolean completion) {
        this.transactionid = transactionid;
        this.email = email;
        this.completion = completion;
        }

    public Invite(Long id, Account accountid, String email, Transaction transactionid, Company companyid, boolean completion, Date createdat, Date updatedat) {
        this.id = id;
        this.accountid = accountid;
        this.email = email;
        this.transactionid = transactionid;
        this.companyid = companyid;
        this.completion = completion;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Transaction getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Transaction transactionid) {
        this.transactionid = transactionid;
    }

    public Company getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Company companyid) {
        this.companyid = companyid;
    }

    public boolean isCompletion() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
}
