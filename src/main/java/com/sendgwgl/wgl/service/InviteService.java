package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import com.sendgwgl.wgl.repository.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class InviteService {
    @Autowired
    private InviteRepository inviteRepository;

    public InviteProjection getOneById(Long id) {
        return inviteRepository.getById(id);
    }

    public Collection<InviteProjection> getAllByEmailandCompletion(String email, Boolean completion) {
        return inviteRepository.findByEmailAndCompletion(email, completion);
    }

    public Collection<InviteProjection> getInvitationsByTransactionId (Long id) {
        return inviteRepository.getByTransactionId(id);
    }
    public void saveInvite(Invite invite) {
        inviteRepository.save(invite);
    }
}

