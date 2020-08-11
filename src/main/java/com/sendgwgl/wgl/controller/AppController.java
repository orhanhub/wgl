package com.sendgwgl.wgl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.service.InviteService;
import com.sendgwgl.wgl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AppController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private InviteService inviteService;

    //Save in 2 tables example
//    @PostMapping ("/wglrequest")
//    public void requestwgl () {
//        Transaction transaction = new Transaction("codename", "issuername");
//        transactionService.saveTransaction(transaction);
//        Invite invite = new Invite (transaction,"demo@email");
//        inviteService.saveInvite(invite);
//    }

    //Parse JSON example
//    @PostMapping ("/wglrequest")
//    public void requestwgl (@RequestBody ObjectNode objectNode) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonNode = objectNode.get("str2").toString();
//        try {
//            Invite invite = objectMapper.readValue(jsonNode, Invite.class );
//            inviteService.saveInvite(invite);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    //FIXME: SEE REQUESTWGLCONTROLLER
    @PostMapping("/redundantwglrequest")
    public void requestwgl(@RequestBody String s) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String transactionNode = objectNode.get("transaction").toString();
//        String invitationNode = objectNode.get("invitation").toString();
//
//        try {
//            Transaction transaction = objectMapper.readValue(transactionNode, Transaction.class);
//            Invite invite = objectMapper.readValue(invitationNode, Invite.class);
//            transactionService.saveTransaction(transaction);
//            Invite inviteWithTransactionId = new Invite(transaction, invite.getEmail(), false);
//            inviteService.saveInvite(inviteWithTransactionId);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        Transaction transaction = new Transaction("codename_here", "issuername_here");
        transactionService.saveTransaction(transaction);
        Invite invite1 = new Invite(transaction, "test1@mail.com", false);
        Invite invite2 = new Invite(transaction, "test2@mail.com", false);
        inviteService.saveInvite(invite1);
        inviteService.saveInvite(invite2);
    }

}

