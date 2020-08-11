package com.sendgwgl.wgl.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * @param name as company name
     * @return companyid
     */
    @GetMapping("/company/{name}")
    public Long getOneCompanyName(@PathVariable String name) {
        return companyService.getOneByName(name);
    }

    @PostMapping("/company")
    public Long saveOneCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @GetMapping("/companies")
    public Collection<Company> getAllCompanies(){
        return companyService.getAll();
    }

    @PostMapping("/companies")
    public void saveAllCompanies(@RequestBody Collection<Company> company) {
        companyService.saveAll(company);
    }


}