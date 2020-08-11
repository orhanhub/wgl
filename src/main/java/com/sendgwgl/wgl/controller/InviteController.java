package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import com.sendgwgl.wgl.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class InviteController {
    @Autowired
    private InviteService inviteService;


    //TODO: SEE BELOW
    //Get one invite (Doesn't sound like it is secured, unauth. person can query this?)
    @GetMapping("/invite/{id}")
    public InviteProjection getOneInvite(@PathVariable Long id, HttpServletResponse response) {
        return inviteService.getOneById(id);
    }

    @PostMapping("/invite")
    public void savOneInvite(@RequestBody Invite invite) {
        inviteService.saveInvite(invite);
    }

    //This should show the transactions that I was invited to and not yet completed
    //FIXME: WHY HIBERNATE IS SENDING 2 SELECT STATEMENTS TO THE DB, WHERE IT CAN BE DONE ONCE?
    //MANUALLY I CAN QUERY ON POSTGRES LIKE THIS, FOR BREVITY, ONLY ONE/TWO COLUMNS SELECTED FROM EACH TABLE, BUT CAN BE EASILY ADDED
    //demowgl=> select i.id, i.email, codename, firstname, lastname from invite i left join transaction t on t.id=i.transactionid left join account a on a.id=t.creatorid where i.email='analyst@wfs.com';
    @PostMapping("/invitations")
    public Collection<InviteProjection> getUncompletedInvitations(@RequestBody Invite invite) {
        return inviteService.getAllByEmailandCompletion(invite.getEmail(), invite.isCompletion());
    }

    //for requested end-point, get me the invitations for transaction id=#;
    @GetMapping("/requested/{id}")
    public Collection<InviteProjection> getInvitationsByTransactionId(@PathVariable Long id) {
        return inviteService.getInvitationsByTransactionId(id);
    }
}
