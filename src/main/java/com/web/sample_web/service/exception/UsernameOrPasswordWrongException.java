package com.web.sample_web.service.exception;

public class UsernameOrPasswordWrongException extends RuntimeException {
    public UsernameOrPasswordWrongException() {
    }

    public UsernameOrPasswordWrongException(String message) {
        super(message);
    }
}
