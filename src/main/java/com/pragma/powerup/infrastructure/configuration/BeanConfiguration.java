package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IMessageServicePort;
import com.pragma.powerup.domain.spi.IMessagePersistencePort;
import com.pragma.powerup.domain.spi.feignCLient.IUserFeignClientPort;
import com.pragma.powerup.domain.spi.token.IToken;
import com.pragma.powerup.domain.usecase.MessageUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.MessageJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.feignclients.UserFeignClient;
import com.pragma.powerup.infrastructure.out.jpa.feignclients.adapter.UserFeignAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IMessageEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IMessageRepository;
import com.pragma.powerup.infrastructure.out.jpa.token.TokenAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IMessageRepository objectRepository;
    private final IMessageEntityMapper objectEntityMapper;
    private final UserFeignClient userFeignClient;

    @Bean
    public IMessagePersistencePort objectPersistencePort() {
        return new MessageJpaAdapter();
    }

    @Bean
    public IMessageServicePort objectServicePort() {
        return new MessageUseCase(objectPersistencePort());
    }

    @Bean
    public IUserFeignClientPort userFeignClientPort() {
        return new UserFeignAdapter(userFeignClient);
    }
    @Bean
    public IToken token(){return new TokenAdapter();
    }
}