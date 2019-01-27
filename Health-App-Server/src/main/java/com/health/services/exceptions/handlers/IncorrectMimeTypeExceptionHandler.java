package com.health.services.exceptions.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.health.services.exceptions.IncorrectMimeTypeException;

@ControllerAdvice
public class IncorrectMimeTypeExceptionHandler {
    @ExceptionHandler(value = IncorrectMimeTypeException.class)
    public ResponseEntity<Object> exception(IncorrectMimeTypeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}