package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.MessageRequestDto;
import com.pragma.powerup.application.handler.IMessageHandler;
import com.pragma.powerup.application.mapper.IMessageRequestMapper;
import com.pragma.powerup.domain.api.IMessageServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageHandler implements IMessageHandler {

    private final IMessageServicePort messageServicePort;
    private final IMessageRequestMapper messageRequestMapper;


    @Override
    public void sendMessage(MessageRequestDto messageRequestDto) {
        messageServicePort.sendMessage(messageRequestMapper.toModel(messageRequestDto));
    }
}