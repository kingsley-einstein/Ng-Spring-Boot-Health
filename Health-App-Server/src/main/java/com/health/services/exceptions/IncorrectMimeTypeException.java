package com.health.services.exceptions;

public class IncorrectMimeTypeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IncorrectMimeTypeException(String message) {
        super(message);
    }
}