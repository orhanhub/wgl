package com.sendgwgl.wgl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sendgwgl.wgl.model.Account;
import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.serialized.CustomInvite;
import com.sendgwgl.wgl.service.AccountService;
import com.sendgwgl.wgl.service.CompanyService;
import com.sendgwgl.wgl.service.InviteService;
import com.sendgwgl.wgl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
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

    //do we need this route? note that it conflicts with company/{name}
//    @GetMapping("/company/{id}")
//    public Company getOneCompany(@PathVariable Long id, HttpServletResponse response) {
//        return companyService.getOneById(id);
//    }

    //input: company name, output, companyid, else null
    @GetMapping("/company/{name}")
    public Long getOneCompanyName(@PathVariable String name, HttpServletResponse response) {
        return companyService.getOneByName(name);
    }

    @PostMapping("/company")
    public Long saveOneCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
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
    public Transaction getOneTransaction(@PathVariable Long id, HttpServletResponse response) {
        return transactionService.getOneById(id);
    }

    @PostMapping("/transaction")
    public void saveOneTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
    }

    @GetMapping("/invite/{id}")
    public CustomInvite getOneInvite(@PathVariable Long id, HttpServletResponse response) {
        return inviteService.getOneById(id);
    }

    @PostMapping("/invite")
    public void savOneInvite(@RequestBody Invite invite) {
        inviteService.saveInvite(invite);
    }

    //This should show the transactions that I was invited to and not yet completed
    @PostMapping("/invitations")
    public List<Invite> getUncompletedInvitations(@RequestBody Invite invite) {
        return inviteService.getOneByEmail(invite.getEmail(), invite.isCompletion());
    }

    //Save in 2 tables example
//    @PostMapping ("/wglrequest")
//    public void requestwgl () {
//        Transaction transaction = new Transaction("codename", "issuername");
//        transactionService.saveTransaction(transaction);
//        Invite invite = new Invite (transaction,"demo@email");
//        inviteService.saveInvite(invite);
//    }

    //Parse JSON
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

    @PostMapping("/wglrequest")
    public void requestwgl(@RequestBody ObjectNode objectNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        String transactionNode = objectNode.get("transaction").toString();
        String invitationNode = objectNode.get("invitation").toString();

        try {
            Transaction transaction = objectMapper.readValue(transactionNode, Transaction.class);
            Invite invite = objectMapper.readValue(invitationNode, Invite.class);
            transactionService.saveTransaction(transaction);
            Invite inviteWithTransactionId = new Invite(transaction, invite.getEmail(), false);
            inviteService.saveInvite(inviteWithTransactionId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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
