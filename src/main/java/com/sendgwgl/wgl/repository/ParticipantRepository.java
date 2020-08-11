package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Participant;
import com.sendgwgl.wgl.model.projections.ParticipantProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    ParticipantProjection getById(Long id);
    Collection<ParticipantProjection> findByInviteId(Long id);
}
