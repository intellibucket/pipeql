package com.intellibucket.pipeql.eventlink.model.event.concretes;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;

import java.util.List;
import java.util.UUID;

public class SuccessEvent<T> extends AbstractEvent<T> {

    public SuccessEvent(UUID transactionId, String processName, List<String> messages, T payload) {
        super(transactionId,processName, EventType.SUCCESS, messages, payload);
    }

    public SuccessEvent(UUID transactionId, String processName, String message, T payload) {
        this(transactionId, processName, List.of(message), payload);
    }

    public SuccessEvent(UUID transactionId, String processName, T payload) {
        this(transactionId,processName, List.of(), payload);
    }

    public SuccessEvent(UUID transactionId, String processName) {
        this(transactionId,processName, List.of(), null);
    }

    public SuccessEvent(AbstractEvent<?> event) {
        this(event.getTransactionId(),event.getProcessName(), List.of(), null);
    }

    public SuccessEvent(AbstractEvent<?> event, List<String> messages, T payload) {
        this(event.getTransactionId(), event.getProcessName(), messages, payload);
    }

    public SuccessEvent(AbstractEvent<?> event, String message, T payload) {
        this(event, List.of(message), payload);
    }

    public SuccessEvent(AbstractEvent<?> event, T payload) {
        this(event, List.of(), payload);
    }
}
