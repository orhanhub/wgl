package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import com.sendgwgl.wgl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction/{id}")
    public TransactionProjection getOneTransaction(@PathVariable Long id, HttpServletResponse response) {
        return transactionService.getOneById(id);
    }

    @GetMapping("/ttest/{code}")
    public TransactionProjection getCodeTest(@PathVariable String code, HttpServletResponse response) {
        return transactionService.getOneByCodename(code);
    }

    @PostMapping("/transaction")
    public void saveOneTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
    }

}
