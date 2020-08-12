package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Transaction;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//    @Query(value="SELECT Acc.FIRSTNAME, Acc.LASTNAME, C.NAME, T.ID, T.CREATEDAT, T.CODENAME, T.ISSUERNAME FROM TRANSACTION T LEFT JOIN ACCOUNT Acc ON Acc.ID = T.CREATORID LEFT JOIN COMPANY C ON C.ID = Acc.COMPANYID WHERE Acc.ID=?1", nativeQuery = true)
    Collection<TransactionProjection> findByAccountId(Long accountId);


}
/*
TransactionProjection findByCodename(String codename);
TransactionProjection getById(Long id);
 */
