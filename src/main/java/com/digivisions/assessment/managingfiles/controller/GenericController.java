package com.digivisions.assessment.managingfiles.controller;


import com.digivisions.assessment.managingfiles.dto.GenericResponse;
import com.digivisions.assessment.managingfiles.enums.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.http.ResponseEntity;

public abstract class GenericController {

    protected ResponseEntity<?> getResponse(Object data) {

        if (data instanceof Boolean) {

            if (Boolean.FALSE.equals(data)) {
                return ResponseEntity.ok().body(new GenericResponse(ResponseStatus.FAIL, data));
            }
        }

        return ResponseEntity.ok().body(new GenericResponse(data));
    }

}
