package com.digivisions.assessment.managingfiles.dto;


import com.digivisions.assessment.managingfiles.enums.ResponseStatus;

import java.time.Instant;

public class GenericResponse {

    private ResponseStatus status = ResponseStatus.SUCCESS;
    private Object result;
    private String timestamp = Instant.now().toString();
    private Object errorMessages;
    private Object developerError;

    public GenericResponse(Object result) {
        this.result = result;
    }

    public GenericResponse(ResponseStatus status, Object developerError) {
        this.status = status;
        this.developerError = developerError;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Object errorMessages) {
        this.errorMessages = errorMessages;
    }

    public Object getDeveloperError() {
        return developerError;
    }

    public void setDeveloperError(Object developerError) {
        this.developerError = developerError;
    }
}


