package com.sendgwgl.wgl.dto;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.Transaction;

import java.util.List;

public class RequestWglDto {
    private Transaction transaction;
    private List<Invite> invite;

    protected RequestWglDto() {};

    public RequestWglDto(Transaction transaction, List<Invite> invite) {
        this.transaction = transaction;
        this.invite = invite;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<Invite> getInvite() {
        return invite;
    }

    public void setInvite(List<Invite> invite) {
        this.invite = invite;
    }
}
