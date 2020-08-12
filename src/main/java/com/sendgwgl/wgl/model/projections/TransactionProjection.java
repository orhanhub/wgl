package com.sendgwgl.wgl.model.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//used for select specific columns of the db query;
public interface TransactionProjection {
    String getCodename();

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date getCreatedat();

    String getId();

    String getIssuername();

    Account getAccount();

    interface Account {
        String getId();
        String getFirstname();
        String getLastname();
        Company getCompanyid();

        interface Company {
            String getName();
        }
    }
}
