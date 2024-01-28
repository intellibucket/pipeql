package com.intellibucket.pipeql.dao.exception;

import com.intellibucket.pipeql.eventlink.exception.DomainException;

public class DataAccessException extends DomainException {
    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
