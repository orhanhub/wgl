package com.sendgwgl.wgl.repository;

import com.sendgwgl.wgl.model.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepository  extends JpaRepository<Invite, Long> {
}
