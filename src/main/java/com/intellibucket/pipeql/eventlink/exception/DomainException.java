package com.intellibucket.pipeql.eventlink.exception;

public class DomainException extends Exception{
    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }


}
