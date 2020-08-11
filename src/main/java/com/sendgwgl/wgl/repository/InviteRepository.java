package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface InviteRepository extends JpaRepository<Invite, Long> {

    Collection<InviteProjection> findByEmailAndCompletion(String email, Boolean completion);

    InviteProjection getById(Long id);

    Collection<InviteProjection> getByTransactionId(Long id);
}
