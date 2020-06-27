package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    //input: company name, output, companyid, else null
    @GetMapping("/company/{name}")
    public Long getOneCompanyName(@PathVariable String name, HttpServletResponse response) {
        return companyService.getOneByName(name);
    }

    @PostMapping("/company")
    public Long saveOneCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

}