package com.digivisions.assessment.managingfiles.config;

import com.digivisions.assessment.managingfiles.dto.GenericResponse;
import com.digivisions.assessment.managingfiles.enums.ResponseStatus;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity handleConstraintViolationException(ConstraintViolationException ex) {

        GenericResponse genericResponse = new GenericResponse(ResponseStatus.FAIL, ex.getCause().toString());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(genericResponse);
    }

    @ExceptionHandler(BusinessRuleException.class)
    protected ResponseEntity handleBusinessRuleException(BusinessRuleException ex) {

        GenericResponse genericResponse = new GenericResponse(ResponseStatus.FAIL, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
    }


    @ExceptionHandler(AuthorizationException.class)
    protected ResponseEntity handleAuthorizationException(AuthorizationException ex) {

        GenericResponse genericResponse = new GenericResponse(ResponseStatus.FAIL, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {

        GenericResponse genericResponse = new GenericResponse(ResponseStatus.FAIL, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
    }


}
