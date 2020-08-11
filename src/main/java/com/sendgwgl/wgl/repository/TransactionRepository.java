package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Collection<TransactionProjection> findByAccountId(Long accountId);
}
/*
TransactionProjection findByCodename(String codename);
TransactionProjection getById(Long id);
 */
