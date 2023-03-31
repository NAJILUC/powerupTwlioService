package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.MessageRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.handler.IMessageHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageRestController {

    private final IMessageHandler messageHandler;

    @Operation(summary = "Add a new Message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Message created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Message already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> proccesMessage(@RequestBody MessageRequestDto messageRequestDto) {
        messageHandler.sendMessage(messageRequestDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}