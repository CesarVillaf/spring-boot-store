package com.codewithmosh.store.users;

public record ChangePasswordRequest(
        String oldPassword,
        String newPassword
) {
}
