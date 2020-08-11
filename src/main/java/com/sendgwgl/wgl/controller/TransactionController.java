package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import com.sendgwgl.wgl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    //When a lead manager wants to view which transactions it is working on, this path should be used
    //This endpoint should only show the transactions with the authenticated user id
    //When the user is authenticated, creator id should be in UserPrincipal object (Spring Security concept)
    @GetMapping("/transactioncreator/{creatorId}")
    public Collection<TransactionProjection> getTransactionsByCreatorId(@PathVariable Long creatorId){
        return transactionService.getByCreatorId(creatorId);
    }

}

/*
    @GetMapping("/transaction/{id}")
    public TransactionProjection getOneTransaction(@PathVariable Long id, HttpServletResponse response) {
        return transactionService.getOneById(id);
    }

    @PostMapping("/transaction")
    public void saveOneTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
    }

 */