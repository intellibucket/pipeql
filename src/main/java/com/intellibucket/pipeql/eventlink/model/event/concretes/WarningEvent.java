package com.intellibucket.pipeql.eventlink.model.event.concretes;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.payload.FailPayload;
import com.intellibucket.pipeql.eventlink.model.payload.WarningPayload;

import java.util.List;
import java.util.UUID;

public class WarningEvent extends AbstractEvent<WarningPayload> {

    public WarningEvent(UUID transactionId, String processName, List<String> messages, WarningPayload payload) {
        super(transactionId,processName, EventType.WARNING, messages, payload);
    }

    public WarningEvent(UUID transactionId, String processName, WarningPayload payload) {
        this(transactionId,processName, List.of(), payload);
    }

    public WarningEvent(UUID transactionId, String processName) {
        this(transactionId,processName, List.of(), new WarningPayload());
    }

    public WarningEvent(StartEvent<?> event) {
        this(event.getTransactionId(), event.getProcessName(), List.of(), new WarningPayload());
    }

    public WarningEvent(StartEvent<?> event, List<String> messages, WarningPayload payload) {
        super(event, EventType.WARNING, messages, payload);
    }

    public WarningEvent(StartEvent<?> event, List<String> messages) {
        this(event, messages, null);
    }

    public WarningEvent(UUID transactionId, String processName, String message) {
        this(transactionId, processName, List.of(message), new WarningPayload());
    }

    public WarningEvent(StartEvent<?> event, WarningPayload payload) {
        super(event, EventType.WARNING, payload);
    }
}
