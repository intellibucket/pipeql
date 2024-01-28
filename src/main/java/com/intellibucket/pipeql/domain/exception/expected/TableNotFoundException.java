package com.intellibucket.pipeql.domain.exception.expected;

import com.intellibucket.pipeql.domain.exception.DomainException;

public class TableNotFoundException extends DomainException {
    public TableNotFoundException(String message) {
        super(message);
    }

    public TableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableNotFoundException(Throwable cause) {
        super(cause);
    }
}
