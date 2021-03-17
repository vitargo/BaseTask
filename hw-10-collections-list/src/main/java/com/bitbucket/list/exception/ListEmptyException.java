package com.bitbucket.list.exception;

public class ListEmptyException extends RuntimeException {

    public ListEmptyException() {
    }

    public ListEmptyException(String message) {
        super(message);
    }
}
