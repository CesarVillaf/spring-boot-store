package com.codewithmosh.store.auth;

public class CurrentUserNotFound extends RuntimeException {
    public CurrentUserNotFound() {
        super("Current user not found");
    }
}
