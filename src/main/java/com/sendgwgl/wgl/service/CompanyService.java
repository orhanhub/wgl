package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company getOneById(Long id) {
        return companyRepository.findById(id).get();
    }

    public void saveCompany(Company company) {

        companyRepository.save(company);
    }

}
