package com.sendgwgl.wgl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="PARTICIPANTS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //inviteid
    @ManyToOne
    @JoinColumn(name = "INVITEID")
    private Invite invite;

    private Long entryorder;

    private String firstname;

    private String lastname;

    private String title;

    private String groupname;

    private String telephone;

    private String email;

    //explicit no args constructor
    public Participant() {};

    public Participant(Long id, Invite invite, Long entryorder, String firstname, String lastname, String title, String groupname, String telephone, String email) {
        this.id = id;
        this.invite = invite;
        this.entryorder = entryorder;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.groupname = groupname;
        this.telephone = telephone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invite getInvite() {
        return invite;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }

    public Long getEntryorder() {
        return entryorder;
    }

    public void setEntryorder(Long entryorder) {
        this.entryorder = entryorder;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
