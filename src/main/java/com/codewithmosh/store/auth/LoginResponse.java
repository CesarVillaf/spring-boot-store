package com.codewithmosh.store.auth;

public record LoginResponse(
    Jwt accessToken,
    Jwt refreshToken,
    int refreshTokenExpiration
) {}
