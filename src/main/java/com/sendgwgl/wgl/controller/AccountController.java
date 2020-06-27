package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Account;
import com.sendgwgl.wgl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/account/{id}")
    public Account getOneAcount(@PathVariable Long id, HttpServletResponse response) {
        return accountService.getOneById(id);
    }

    @PostMapping("/account")
    public void saveOneAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }

}
