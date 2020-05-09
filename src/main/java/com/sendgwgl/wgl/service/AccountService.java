package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Account;
import com.sendgwgl.wgl.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//TODO what is transactional, why use it here?
@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getOneById(Long id) {
            return accountRepository.findById(id).orElse(new Account(0L));
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
