package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.MessageModel;
import com.pragma.powerup.domain.spi.IMessagePersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@RequiredArgsConstructor
public class MessageJpaAdapter implements IMessagePersistencePort {

    @Value("${TWILIO_ACCOUNT_SID}")
    private String ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${TWILIO_FROM_PHONE_NUMBER}")
    private String FROM_PHONE_NUMBER;



    @Override
    public void sendMessage(MessageModel messageModel) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber(messageModel.getCelular()),
                new PhoneNumber(FROM_PHONE_NUMBER),
                messageModel.getMensaje())
                .create();

    }
}