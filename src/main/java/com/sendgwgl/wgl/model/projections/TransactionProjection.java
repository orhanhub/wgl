package com.sendgwgl.wgl.model.projections;

import java.util.Date;

//used for select specific columns of the db query;
public interface TransactionProjection {
    String getId();

    String getCodename();

    String getIssuername();

    Date getCreatedat();

    AccountProjection getAccount();
}
