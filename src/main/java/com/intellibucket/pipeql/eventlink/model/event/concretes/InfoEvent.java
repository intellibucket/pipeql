package com.intellibucket.pipeql.eventlink.model.event.concretes;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.payload.InfoPayload;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class InfoEvent extends AbstractEvent<InfoPayload> {

    public InfoEvent(UUID transactionId, String processName, List<String> messages, InfoPayload payload) {
        super(transactionId,processName, EventType.WARNING, messages, payload);
    }

    public InfoEvent(UUID transactionId, String processName, InfoPayload payload) {
        this(transactionId,processName, List.of(), payload);
    }

    public InfoEvent(UUID transactionId, String processName) {
        this(transactionId,processName, List.of(), new InfoPayload());
    }

    public InfoEvent(StartEvent<?> event) {
        this(event.getTransactionId(), event.getProcessName(), List.of(), new InfoPayload());
    }

    public InfoEvent(StartEvent<?> event, List<String> messages, InfoPayload payload) {
        super(event, EventType.WARNING, messages, payload);
    }

    public InfoEvent(StartEvent<?> event, List<String> messages) {
        this(event, messages, null);
    }

    public InfoEvent(UUID transactionId, String processName, String message) {
        this(transactionId, processName, List.of(message), new InfoPayload());
    }

    public InfoEvent(StartEvent<?> event, InfoPayload payload) {
        super(event, EventType.WARNING, payload);
    }
}
