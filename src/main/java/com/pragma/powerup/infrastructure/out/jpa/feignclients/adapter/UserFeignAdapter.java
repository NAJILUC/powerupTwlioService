package com.pragma.powerup.infrastructure.out.jpa.feignclients.adapter;

import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.domain.spi.feignCLient.IUserFeignClientPort;
import com.pragma.powerup.infrastructure.out.jpa.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFeignAdapter implements IUserFeignClientPort {

    private final UserFeignClient userFeignClient;

    @Override
    public Boolean userExist(Long id) {
        return userFeignClient.userExist(id);
    }

    @Override
    public UserResponseDto getUserByEmail(String correo) {
        return userFeignClient.getUserByEmail(correo);
    }
}
