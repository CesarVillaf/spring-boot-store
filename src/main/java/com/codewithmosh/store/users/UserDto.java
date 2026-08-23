package com.codewithmosh.store.users;

public record UserDto(
    Long id,
    String name,
    String email
) {}