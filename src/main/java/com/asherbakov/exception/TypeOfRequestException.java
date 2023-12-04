package com.asherbakov.exception;

public class TypeOfRequestException extends RuntimeException {
    public TypeOfRequestException() {
    }

    public TypeOfRequestException(String message) {
        super(message);
    }
}

