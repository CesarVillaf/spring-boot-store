package com.codewithmosh.store.users;

public record UpdateUserRequest(
        String name,
        String email
) {}
