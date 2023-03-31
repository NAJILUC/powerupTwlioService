package com.pragma.powerup.domain.spi.feignCLient;


import com.pragma.powerup.application.dto.response.UserResponseDto;

public interface IUserFeignClientPort {

    Boolean userExist( Long id);
    UserResponseDto getUserByEmail(String correo);
}
