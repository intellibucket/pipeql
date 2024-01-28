package com.intellibucket.pipeql.domain.exception.expected;

import com.intellibucket.pipeql.domain.exception.DomainException;

public class SchemaNotFoundException extends DomainException {
    public SchemaNotFoundException(String message) {
        super(message);
    }

    public SchemaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SchemaNotFoundException(Throwable cause) {
        super(cause);
    }
}
