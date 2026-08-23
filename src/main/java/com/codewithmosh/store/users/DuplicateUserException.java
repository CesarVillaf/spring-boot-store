package com.codewithmosh.store.users;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException() {
        super("User already exists");
    }
}
