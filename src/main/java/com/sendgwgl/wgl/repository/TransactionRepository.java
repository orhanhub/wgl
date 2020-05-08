package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
