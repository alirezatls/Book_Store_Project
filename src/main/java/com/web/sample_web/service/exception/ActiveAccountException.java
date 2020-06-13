package com.web.sample_web.service.exception;

public class ActiveAccountException extends RuntimeException {

    public ActiveAccountException() {
    }

    public ActiveAccountException(String message) {
        super(message);
    }
}
