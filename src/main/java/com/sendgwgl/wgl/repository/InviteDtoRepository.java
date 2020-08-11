package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.dto.InviteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InviteDtoRepository extends JpaRepository<InviteDto, Long> {

//    @Query( value= "SELECT I.id, email, codename FROM INVITE I LEFT JOIN TRANSACTION t ON t.id=i.transactionid WHERE I.id= ?1", nativeQuery = true)
    @Query( value= "SELECT I.id, email FROM INVITE I WHERE I.email= ?1", nativeQuery = true)
    InviteDto myCustomEmailFinder(String email);
}
