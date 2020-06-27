package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    List<Invite> findByEmailAndCompletion(String email, Boolean completion);

    InviteProjection getById(Long id);
}
