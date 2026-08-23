package com.codewithmosh.store.auth;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.SecretKey;

@ConfigurationProperties(prefix = "spring.jwt")
public record JwtConfig(
        String secret,
        int accessTokenExpiration,
        int refreshTokenExpiration
) {
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
