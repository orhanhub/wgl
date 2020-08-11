package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.RequestWgl;
import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.service.InviteService;
import com.sendgwgl.wgl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RequestWglController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private InviteService inviteService;

    @PostMapping("/wglrequest")
    public void nested(@RequestBody RequestWgl json) {

        Transaction jsonTransaction = json.getTransaction();
        List<Invite> jsonInvite = json.getInvite();

        transactionService.saveTransaction(jsonTransaction);
        for (Invite invite : jsonInvite) {
            invite.setTransaction(jsonTransaction);
            inviteService.saveInvite(invite);
        }
    }
}
