package com.intellibucket.pipeql.domain.exception;

public class ColumnNotFoundException extends DomainException {
    public ColumnNotFoundException(String message) {
        super(message);
    }

    public ColumnNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColumnNotFoundException(Throwable cause) {
        super(cause);
    }
}
