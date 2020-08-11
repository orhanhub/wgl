package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Participant;
import com.sendgwgl.wgl.model.projections.ParticipantProjection;
import com.sendgwgl.wgl.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public void saveParticipant(Participant participant) {
        participantRepository.save(participant);
    }

    public ParticipantProjection getOneById(Long id) {
        return participantRepository.getById(id);
    }

    public Collection<ParticipantProjection> findByInviteId(Long id) {
        return participantRepository.findByInviteId(id);
    }

    public void saveAll(List<Participant> participant) {
        participantRepository.saveAll(participant);
    }
}
