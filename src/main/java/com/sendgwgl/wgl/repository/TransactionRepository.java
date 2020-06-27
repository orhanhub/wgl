package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    TransactionProjection findByCodename(String codename);
}
