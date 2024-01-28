package com.intellibucket.pipeql.dao.exception;

import com.intellibucket.pipeql.eventlink.exception.DomainException;

public class DataNotFoundException extends DataAccessException {
    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}
