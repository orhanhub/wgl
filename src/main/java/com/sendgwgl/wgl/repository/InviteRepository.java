package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InviteRepository  extends JpaRepository<Invite, Long> {
    List<Invite> findByEmailAndCompletion(String email, Boolean completion);
}
