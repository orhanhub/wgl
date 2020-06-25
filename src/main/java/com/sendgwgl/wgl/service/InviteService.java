package com.sendgwgl.wgl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.repository.InviteRepository;
import com.sendgwgl.wgl.serializer.InviteSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InviteService {
    @Autowired
    private InviteRepository inviteRepository;

    public String getOneById(Long id) throws JsonProcessingException {
        Invite myInvite = inviteRepository.findById(id).orElse(new Invite(0L));

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Invite.class, new InviteSerializer());
        mapper.registerModule(module);

        return mapper.writeValueAsString(myInvite);
    }

    public List<Invite> getOneByEmail(String email, Boolean completion){
        return inviteRepository.findByEmailAndCompletion(email, completion);
    }

    public void saveInvite(Invite invite) {
        inviteRepository.save(invite);
    }
}
