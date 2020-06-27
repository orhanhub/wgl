package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Invite;
import com.sendgwgl.wgl.model.projections.InviteProjection;
import com.sendgwgl.wgl.serialized.CustomInvite;
import com.sendgwgl.wgl.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


//FIXME: for react axios get
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class InviteController {
    @Autowired
    private InviteService inviteService;

    @GetMapping("/invite/{id}")
    public InviteProjection getOneInvite(@PathVariable Long id, HttpServletResponse response) {
        return inviteService.getOneById(id);
    }

    @PostMapping("/invite")
    public void savOneInvite(@RequestBody Invite invite) {
        inviteService.saveInvite(invite);
    }

    //This should show the transactions that I was invited to and not yet completed
    @PostMapping("/invitations")
    public List<Invite> getUncompletedInvitations(@RequestBody Invite invite) {
        return inviteService.getOneByEmail(invite.getEmail(), invite.isCompletion());
    }
}
