package com.intellibucket.pipeql.domain.exception.unexpected;

import com.intellibucket.pipeql.domain.exception.UnexpectedException;

public class ConcurrentModifyException extends UnexpectedException {
    public ConcurrentModifyException(String message) {
        super(message);
    }

    public ConcurrentModifyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConcurrentModifyException(Throwable cause) {
        super(cause);
    }

    public ConcurrentModifyException() {
        super("Concurrent modification detected");
    }
}
