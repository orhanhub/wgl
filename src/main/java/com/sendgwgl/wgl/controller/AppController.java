package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Account;
import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.service.AccountService;
import com.sendgwgl.wgl.service.CompanyService;
import com.sendgwgl.wgl.service.InviteService;
import com.sendgwgl.wgl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class AppController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private InviteService inviteService;


    @GetMapping("/company/{id}")
    public Company getOneCompany(@PathVariable Long id, HttpServletResponse response) {
        return companyService.getOneById(id);
    }

    @PostMapping("/company")
    public void saveOneCompany(@RequestBody Company company) {
        companyService.saveCompany(company);
    }

    @GetMapping("/account/{id}")
    public Account getOneAcount(@PathVariable Long id, HttpServletResponse response) {
        return accountService.getOneById(id);
    }

    @PostMapping("/account")
    public void saveOneAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }

    @GetMapping("/transaction/{id}")
    public Transaction  getOneTransaction (@PathVariable Long id, HttpServletResponse response) {
        return transactionService.getOneById(id);
    }

    @PostMapping("/transaction")
    public void saveOneTransaction (@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
    }

    @GetMapping("/invite/{id}")
    public Invite getOneInvite(@PathVariable Long id, HttpServletResponse response){
        return inviteService.getOneById(id);
    }

    @PostMapping("/invite")
    public void savOneInvite (@RequestBody Invite invite){
        inviteService.saveInvite(invite);
    }

//    @Autowired
//    private ProductService service;
//
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/product/{id}")
//    public Product one(@PathVariable Long id, HttpServletResponse response) {
//        return service.getOne(id);
//    }
//
//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/product")
//    public void saveOne(@RequestBody Product product){
//        service.save(product);
//    }
////    NOTE: Also possible to directly handover the CRUD to JpaRepository but the benefit of the service above is to add more complicated CRUD if necessary in the future
////    @Autowired
////    private ProductRepository repo;
////
////    /**
////     * Return a single product
////     *
////     * @param id
////     * @return
////     */
////    @GetMapping("/product/{id}")
////    public long one(@PathVariable Long id) {
////        return repo.count();
//    }
}
