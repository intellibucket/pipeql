package com.intellibucket.pipeql.eventlink.model.event.concretes;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;

import java.util.List;
import java.util.UUID;

public class FailEvent<T> extends AbstractEvent<T> {

    public FailEvent(UUID transactionId,String processName, List<String> messages, T payload) {
        super(transactionId,processName, EventType.FAILURE, messages, payload);
    }

    public FailEvent(UUID transactionId,String processName, T payload) {
        this(transactionId,processName, List.of(), payload);
    }

    public FailEvent(UUID transactionId,String processName) {
        this(transactionId,processName, List.of(), null);
    }

    public FailEvent(AbstractEvent<?> event) {
        this(event.getTransactionId(), event.getProcessName(), List.of(), null);
    }

    public FailEvent(AbstractEvent<?> event, List<String> messages, T payload) {
        super(event, EventType.FAILURE, messages, payload);
    }

    public FailEvent(AbstractEvent<?> event, T payload) {
        super(event, EventType.FAILURE, payload);
    }
}
