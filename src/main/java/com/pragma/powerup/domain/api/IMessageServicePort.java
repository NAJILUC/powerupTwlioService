package com.pragma.powerup.domain.api;

import com.pragma.powerup.application.dto.request.MessageRequestDto;
import com.pragma.powerup.domain.model.MessageModel;

import java.util.List;

public interface IMessageServicePort {

    void sendMessage(MessageModel messageModel);
}