package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IMessageServicePort;
import com.pragma.powerup.domain.model.MessageModel;
import com.pragma.powerup.domain.spi.IMessagePersistencePort;

import java.util.List;

public class MessageUseCase implements IMessageServicePort {

    private final IMessagePersistencePort messagePersistencePort;

    public MessageUseCase(IMessagePersistencePort objectPersistencePort) {
        this.messagePersistencePort = objectPersistencePort;
    }

    @Override
    public void sendMessage(MessageModel messageModel) {
        messagePersistencePort.sendMessage(messageModel);
    }
}