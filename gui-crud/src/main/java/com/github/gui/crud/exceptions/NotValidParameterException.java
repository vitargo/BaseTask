package com.github.gui.crud.exceptions;

public class NotValidParameterException extends RuntimeException {

    public NotValidParameterException() {
    }

    public NotValidParameterException(String message) {
        super(message);
    }
}
