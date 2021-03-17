package com.bitbucket.list.exception;

public class PositionOutOfBoundListException extends RuntimeException{

    public PositionOutOfBoundListException() {
    }

    public PositionOutOfBoundListException(String message) {
        super(message);
    }

    public PositionOutOfBoundListException(Throwable cause) {
        super(cause);
    }
}
