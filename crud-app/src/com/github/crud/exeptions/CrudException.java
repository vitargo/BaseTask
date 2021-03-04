package com.github.crud.exeptions;


public class CrudException extends RuntimeException {

    public CrudException() {
    }

    public CrudException(String message) {
        super(message);
    }
}
