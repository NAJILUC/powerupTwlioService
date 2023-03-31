package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.MessageRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.domain.model.MessageModel;

import java.util.List;

public interface IMessageHandler {

    void sendMessage(MessageRequestDto messageRequestDto);
}