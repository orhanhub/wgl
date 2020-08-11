package com.sendgwgl.wgl.dto;

import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class InviteDto {

    @Id
    Long id;
    String email;

    public InviteDto(){}

    public InviteDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InviteDto)) return false;
        InviteDto inviteDto = (InviteDto) o;
        return Objects.equals(id, inviteDto.id) &&
                Objects.equals(email, inviteDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
