package com.intellibucket.pipeql.domain.exception.expected;

import com.intellibucket.pipeql.domain.exception.DomainException;

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
