package com.sendgwgl.wgl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
//When a JSON is unmarshalled, i.e. converted to class, ignore unmatched JSON keys
@JsonIgnoreProperties(ignoreUnknown = true)
//In a nested JSON, the key will be invitation and the value will be the class below
@JsonRootName(value = "invitation")
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //transactionid
    @ManyToOne
    @JoinColumn(name = "TRANSACTIONID")
    private Transaction transactionid;

    //@JsonProperty(value = "email")
    private String email;

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

    public Invite(Long id, Transaction transactionid, String email, boolean completion, Date createdat, Date updatedat) {
        this.id = id;
        this.transactionid = transactionid;
        this.email = email;
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
