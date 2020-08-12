package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //TODO: The query below returns a flat table and cannot be mapped to Transaction Projection; it shows account: as null
    //    @Query(value="SELECT acc.firstname, acc.lastname, c.name, t.id, t.createdat, t.codename, t.issuername FROM transaction t " +
    //    "LEFT JOIN account acc ON acc.id = t.creatorid LEFT JOIN COMPANY c ON c.id = acc.companyid WHERE acc.id=?1", nativeQuery = true)
    Collection<TransactionProjection> findByAccountId(Long accountId);


}
/*
TransactionProjection findByCodename(String codename);
TransactionProjection getById(Long id);
 */
