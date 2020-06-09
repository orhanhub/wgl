package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByName (String name);
}
