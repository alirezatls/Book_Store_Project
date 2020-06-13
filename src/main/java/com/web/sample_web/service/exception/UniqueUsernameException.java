package com.web.sample_web.service.exception;


public class UniqueUsernameException extends RuntimeException{
    public UniqueUsernameException() {
    }

    public UniqueUsernameException(String message) {
        super(message);
    }
}
