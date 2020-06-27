package com.sendgwgl.wgl.model.projections;

//used for select specific columns of the db query;
public interface TransactionProjection {
    String getCodename();
    String getIssuername();
}
