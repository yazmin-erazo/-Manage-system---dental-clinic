package com.managesystem.dentalclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processResourceNotFound(ResourceNotFoundException resourceNotFoundEx){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFoundEx.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> progressErrorBadRequest(BadRequestException badRequestEx){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestEx.getMessage());
    }


}
