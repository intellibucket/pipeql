package com.intellibucket.pipeql.eventlink.model.event.concretes;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.payload.FailPayload;

import java.util.List;
import java.util.UUID;

public class FailureEvent extends AbstractEvent<FailPayload> {

    public FailureEvent(UUID transactionId, String processName, List<String> messages, FailPayload payload) {
        super(transactionId,processName, EventType.FAILURE, messages, payload);
    }

    public FailureEvent(UUID transactionId, String processName, FailPayload payload) {
        this(transactionId,processName, List.of(), payload);
    }

    public FailureEvent(UUID transactionId, String processName) {
        this(transactionId,processName, List.of(), new FailPayload());
    }

    public FailureEvent(StartEvent<?> event) {
        this(event.getTransactionId(), event.getProcessName(), List.of(), new FailPayload());
    }

    public FailureEvent(StartEvent<?> event, List<String> messages, FailPayload payload) {
        super(event, EventType.FAILURE, messages, payload);
    }

    public FailureEvent(StartEvent<?> event, List<String> messages) {
        this(event, messages, null);
    }

    public FailureEvent(UUID transactionId, String processName, String message) {
        this(transactionId, processName, List.of(message), new FailPayload());
    }

    public FailureEvent(StartEvent<?> event, FailPayload payload) {
        super(event, EventType.FAILURE, payload);
    }
}
