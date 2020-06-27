package com.sendgwgl.wgl.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import com.sendgwgl.wgl.model.projections.TransactionProjection;
import com.sendgwgl.wgl.repository.InviteRepository;
import com.sendgwgl.wgl.serialized.CustomInvite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InviteService {
    @Autowired
    private InviteRepository inviteRepository;

    //TODO: onebyId is complete as single object, how about array of objects for getOneByEmail?

    public InviteProjection getOneById(Long id) {
        return inviteRepository.getById(id);
    }
//    //Below is a way to redact JSON before sending it, other option is to use JPA Projections:
//    public CustomInvite getOneById(Long id) {
//
//        //query result
//        //note that findById is optional class
//        Optional<Invite> invite = inviteRepository.findById(id);
//
//        //if value found:
//        if (invite.isPresent()) {
//
//            //convert query result to jsonNode
//            ObjectMapper mapper = new ObjectMapper();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm");
//            mapper.setDateFormat(dateFormat);
//            JsonNode node = mapper.valueToTree(invite.get());
//
//            //redact the query result for confidential/unnecessary parts
//            // by fitting into customInvite class
//            CustomInvite customInvite = new CustomInvite();
//
//            customInvite.setId(node.get("id").asText());
//            customInvite.setCodename(node.get("transactionid").get("codename").asText());
//            customInvite.setIssuername(node.get("transactionid").get("issuername").asText());
//            customInvite.setCreatedat(node.get("createdat").asText());
//            customInvite.setFirstname(node.get("transactionid").get("account").get("firstname").asText());
//            customInvite.setLastname(node.get("transactionid").get("account").get("lastname").asText());
//            customInvite.setCompany(node.get("transactionid").get("account").get("companyid").get("name").asText());
//
//            return customInvite;
//        }
//        //if value not found, return a blank custominvite object with id 0;
//        else {
//            return new CustomInvite("0");
//        }
//    }

    public List<Invite> getOneByEmail(String email, Boolean completion) {
        return inviteRepository.findByEmailAndCompletion(email, completion);

    }

    public void saveInvite(Invite invite) {
        inviteRepository.save(invite);
    }
}

