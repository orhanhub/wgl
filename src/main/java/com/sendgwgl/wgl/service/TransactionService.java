package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Company;
import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getOneById(Long id) {
        return transactionRepository.findById(id).get();
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
