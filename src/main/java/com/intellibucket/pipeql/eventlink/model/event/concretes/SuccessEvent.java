package com.intellibucket.pipeql.eventlink.model.event.concretes;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class SuccessEvent extends AbstractEvent<SuccessPayload> {

    public SuccessEvent(UUID transactionId, String processName, List<String> messages, SuccessPayload payload) {
        super(transactionId,processName, EventType.SUCCESS, messages, payload);
    }

    public SuccessEvent(UUID transactionId, String processName, String message, SuccessPayload payload) {
        this(transactionId, processName, List.of(message), payload);
    }

    public SuccessEvent(UUID transactionId, String processName, SuccessPayload payload) {
        this(transactionId,processName, List.of(), payload);
    }

    public SuccessEvent(UUID transactionId, String processName) {
        this(transactionId,processName, List.of(), null);
    }

    public SuccessEvent(AbstractEvent<?> event) {
        this(event.getTransactionId(),event.getProcessName(), List.of(), null);
    }

    public SuccessEvent(AbstractEvent<?> event, List<String> messages, SuccessPayload payload) {
        this(event.getTransactionId(), event.getProcessName(), messages, payload);
    }

    public SuccessEvent(AbstractEvent<?> event, String message, SuccessPayload payload) {
        this(event, List.of(message), payload);
    }

    public SuccessEvent(AbstractEvent<?> event, SuccessPayload payload) {
        this(event, List.of(), payload);
    }
}
