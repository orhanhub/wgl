package com.sendgwgl.wgl.model.projections;

import com.sendgwgl.wgl.model.Company;

import java.util.Date;

//used for select specific columns of the db query;
public interface TransactionProjection {
    String getCodename();

    Date getCreatedat();

    String getId();

    String getIssuername();

    Account getAccount();

    interface Account {
        String getFirstname();
        String getLastname();
        Company getCompanyid();

        interface Company {
            String getName();
        }
    }
}
