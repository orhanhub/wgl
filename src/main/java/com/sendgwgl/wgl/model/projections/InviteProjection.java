package com.sendgwgl.wgl.model.projections;

import java.util.Date;

public interface InviteProjection {
        String getId();
        String getEmail();
        String getCompletion();
        Date getCreatedat();
        TransactionProjection getTransaction();
}
