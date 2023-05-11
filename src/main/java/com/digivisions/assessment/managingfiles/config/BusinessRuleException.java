package com.digivisions.assessment.managingfiles.config;

public class BusinessRuleException extends RuntimeException {

    private String message;

    public BusinessRuleException(String message) {
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
