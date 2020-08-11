package com.sendgwgl.wgl.controller;

import com.sendgwgl.wgl.model.Participant;
import com.sendgwgl.wgl.model.projections.ParticipantProjection;
import com.sendgwgl.wgl.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ParticipantsController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping("/participant")
    public String saveParticipants (@RequestBody List<Participant> participant) {
        //participantService.saveParticipant(participant);
        participantService.saveAll(participant);
        return "ok";
    }

    @GetMapping("/participant/{id}")
    public ParticipantProjection getParticipantById(@PathVariable Long id){
        return participantService.getOneById(id);
    }

    @GetMapping("/participantinvite/{id}")
    public Collection<ParticipantProjection> getParticipantByInviteId(@PathVariable Long id) {
        return participantService.findByInviteId(id);
    }
}
