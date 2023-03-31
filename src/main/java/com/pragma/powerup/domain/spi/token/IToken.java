package com.pragma.powerup.domain.spi.token;

public interface IToken {

    String getBearerToken();

    String getUserAuthenticatedEmail(String token);

    Long getUserAuthenticatedId(String token);
}
