package com.intellibucket.pipeql.dao.exception;

import com.intellibucket.pipeql.domain.exception.DomainException;

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
