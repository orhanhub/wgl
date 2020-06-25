package com.sendgwgl.wgl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.repository.InviteRepository;
import com.sendgwgl.wgl.serialized.CustomInvite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InviteService {
    @Autowired
    private InviteRepository inviteRepository;

    //TODO: Null pointer exception handling, if there's no result
    //TODO: createdAt serialization as Date instead of integer
    //TODO: onebyId is complete as single object, how about array of objects for getOneByEmail?

    public CustomInvite getOneById(Long id) throws JsonProcessingException {
        //query result (or an empty result);
        Invite invite = inviteRepository.findById(id).orElse(new Invite(0L));

        //convert query result to jsonNode
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(invite);
        System.out.println(node.toPrettyString());

        //edit the query to peel off confidential/unnecessary parts
        // by fitting into customInvite class
        CustomInvite customInvite = new CustomInvite();
        customInvite.setId(node.get("id").asText());
        customInvite.setCodename(node.get("transactionid").get("codename").asText());
        customInvite.setIssuername(node.get("transactionid").get("issuername").asText());
        customInvite.setCreatedat(node.get("createdat").asText());
        customInvite.setFirstname(node.get("transactionid").get("account").get("firstname").asText());
        customInvite.setLastname(node.get("transactionid").get("account").get("lastname").asText());
        customInvite.setCompany(node.get("transactionid").get("account").get("companyid").get("name").asText());

        return customInvite;
    }

    public List<Invite> getOneByEmail(String email, Boolean completion) {
        return inviteRepository.findByEmailAndCompletion(email, completion);
    }

    public void saveInvite(Invite invite) {
        inviteRepository.save(invite);
    }
}

