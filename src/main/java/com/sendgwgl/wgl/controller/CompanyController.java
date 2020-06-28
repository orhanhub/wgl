package com.sendgwgl.wgl.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.util.Arrays;
import java.util.List;


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

    @PostMapping("/companies")
    public void saveAllCompanies(@RequestBody List<Company> company) {
        companyService.saveAll(company);
    }
}