package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.dto.InviteDto;
import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import com.sendgwgl.wgl.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class InviteController {
    @Autowired
    private InviteService inviteService;

    //TODO: IMRPOVE ON THIS INSTEAD OF /INVITATIONS ENDPOINT
    //BECAUSE HYBERNATE SENDS MULTIPLE SELECT REQUESTS
    @GetMapping("/dtotest/{email}")
    public InviteDto getDto(@PathVariable String email){
        return inviteService.customGetEmail(email);
    }


    //This should show the transactions that I was invited to and not yet completed
    //FIXME: WHY HIBERNATE IS SENDING 2 SELECT STATEMENTS TO THE DB, WHERE IT CAN BE DONE ONCE?
    //MANUALLY I CAN QUERY ON POSTGRES LIKE THIS, FOR BREVITY, ONLY ONE/TWO COLUMNS SELECTED FROM EACH TABLE, BUT CAN BE EASILY ADDED
    //demowgl=> select i.id, i.email, codename, firstname, lastname from invite i left join transaction t on t.id=i.transactionid left join account a on a.id=t.creatorid where i.email='analyst@wfs.com';
    @PostMapping("/invitations")
    public Collection<InviteProjection> getUncompletedInvitations(@RequestBody Invite invite) {
        return inviteService.getAllByEmailandCompletion(invite.getEmail(), invite.isCompletion());
    }

    //Get the invitations for transaction id=#;
    //This endpoint serves the WGL Requestor the invitations he had sent given a transaction
    //Transactions should be fetched to user based on userAccount identifier, therefore endpoint seems to be secure
    @GetMapping("/requested/{id}")
    public Collection<InviteProjection> getInvitationsByTransactionId(@PathVariable Long id) {
        return inviteService.getInvitationsByTransactionId(id);
    }
}

/*

    //Get one invite (Doesn't sound like it is secured, unauth. person can query this?)
    @GetMapping("/invite/{id}")
    public InviteProjection getOneInvite(@PathVariable Long id, HttpServletResponse response) {
        return inviteService.getOneById(id);
    }

    @PostMapping("/invite")
    public void savOneInvite(@RequestBody Invite invite) {
        inviteService.saveInvite(invite);
    }

 */