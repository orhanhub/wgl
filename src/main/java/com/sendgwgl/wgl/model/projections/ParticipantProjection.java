package com.sendgwgl.wgl.model.projections;

public interface ParticipantProjection {
    String getId();

    String getEntryorder();

    String getFirstname();

    String getLastname();

    String getTitle();

    String getGroupname();

    String getTelephone();

    String getEmail();

    InviteProjection getInvite();


}
