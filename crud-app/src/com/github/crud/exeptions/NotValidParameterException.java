package com.github.crud.exeptions;

public class NotValidParameterException extends RuntimeException {

    public NotValidParameterException() {

    }

    public NotValidParameterException(String message) {
        super(message);
    }
}
