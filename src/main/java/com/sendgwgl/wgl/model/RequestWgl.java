package com.sendgwgl.wgl.model;

import java.util.List;

public class RequestWgl {
    private Transaction transaction;
    private Invite invite;

    protected RequestWgl () {};

    public RequestWgl(Transaction transaction, Invite invite) {
        this.transaction = transaction;
        this.invite = invite;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Invite getInvite() {
        return invite;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }
}
