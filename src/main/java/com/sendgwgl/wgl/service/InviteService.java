package com.sendgwgl.wgl.service;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.repository.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InviteService {
    @Autowired
    private InviteRepository inviteRepository;

    public Invite getOneById(Long id) {
        return inviteRepository.findById(id).get();
    }

    public void saveInvite(Invite invite) {
        inviteRepository.save(invite);
    }
}
