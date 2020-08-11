package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.dto.InviteDto;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import com.sendgwgl.wgl.repository.InviteDtoRepository;
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

    @Autowired
    private InviteDtoRepository inviteDtoRepository;

    //TODO: IMPROVE ON THIS
    public InviteDto customGetEmail(String email) {
        return inviteDtoRepository.myCustomEmailFinder(email);
    }

    public Collection<InviteProjection> getAllByEmailandCompletion(String email, Boolean completion) {
        return inviteRepository.findByEmailAndCompletion(email, completion);
    }

    public Collection<InviteProjection> getInvitationsByTransactionId(Long id) {
        return inviteRepository.getByTransactionId(id);
    }

    public void saveInvite(Invite invite) {
        inviteRepository.save(invite);
    }
}

/*
    public InviteProjection getOneById(Long id) {
        return inviteRepository.getById(id);
    }

 */