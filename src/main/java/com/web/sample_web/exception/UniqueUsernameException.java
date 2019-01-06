package com.web.sample_web.exception;


public class UniqueUsernameException extends RuntimeException{
    public UniqueUsernameException() {
    }

    public UniqueUsernameException(String message) {
        super(message);
    }
}
