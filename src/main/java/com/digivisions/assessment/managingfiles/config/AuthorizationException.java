package com.digivisions.assessment.managingfiles.config;

public class AuthorizationException extends RuntimeException {

    private String message;

    public AuthorizationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
