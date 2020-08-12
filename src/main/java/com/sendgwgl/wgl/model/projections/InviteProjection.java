package com.sendgwgl.wgl.model.projections;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface InviteProjection {
    String getId();

    String getEmail();

    String getCompletion();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    Date getCreatedat();

    TransactionProjection getTransaction();
}
