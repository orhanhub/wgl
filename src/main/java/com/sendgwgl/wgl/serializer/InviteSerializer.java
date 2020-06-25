package com.sendgwgl.wgl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sendgwgl.wgl.model.Invite;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class InviteSerializer extends StdSerializer<Invite> {
    public InviteSerializer() {
        this(null);
    }

    public InviteSerializer(Class<Invite> t) {
        super(t);
    }

    private SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public void serialize(
            Invite invite, JsonGenerator generator, SerializerProvider provider
    ) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeNumberField("id", invite.getId());
        generator.writeStringField("createdat", formatter.format(invite.getCreatedat()));
        generator.writeNumberField("transactionid", invite.getTransactionid().getId());
        generator.writeObjectField("codename", invite.getTransactionid().getCodename());
        generator.writeObjectField("issuername", invite.getTransactionid().getIssuername());
        generator.writeObjectField("firstname", invite.getTransactionid().getAccount().getFirstname());
        generator.writeObjectField("lastname", invite.getTransactionid().getAccount().getLastname());
        generator.writeEndObject();
    }
}
