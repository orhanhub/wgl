package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import com.sendgwgl.wgl.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionProjection getOneByCodename(String codename) {
        return transactionRepository.findByCodename(codename);
    }

    public TransactionProjection getOneById(Long id) {
//        return transactionRepository.findById(id).orElse(new Transaction(0L));
        return transactionRepository.getById(id);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
