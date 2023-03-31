package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.MessageModel;

public interface IMessagePersistencePort {

    void sendMessage(MessageModel messageModel);
}