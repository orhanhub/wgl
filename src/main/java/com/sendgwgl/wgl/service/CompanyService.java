package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    //find the company name if you know the id;
    public Company getOneById(Long id) {
        return companyRepository.findById(id).orElse(new Company(0L));
    }

    //find the company id if you know the name; -1L if not found
    public Long getOneByName(String name) {
        try {

            Company companyobj = companyRepository.findByName(name);
            return companyobj.getId();
        } catch (NullPointerException e) {
            return -1L;
        }
    }

    //Save the company and return company id;
    public Long saveCompany(Company company) {
        companyRepository.save(company);
        return company.getId();
    }

    public void saveAll(List<Company> company) {
        companyRepository.saveAll(company);
    }

}
