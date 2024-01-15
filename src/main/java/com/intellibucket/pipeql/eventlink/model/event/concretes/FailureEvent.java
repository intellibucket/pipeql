package com.intellibucket.pipeql.eventlink.model.event.concretes;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.payload.FailPayload;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class FailureEvent extends AbstractEvent<FailPayload> {

    private final Exception exception;

    public FailureEvent(UUID transactionId, String processName, List<String> messages, FailPayload payload, Exception exception) {
        super(transactionId,processName, EventType.FAILURE, messages, payload);
        this.exception = exception;
    }

    public FailureEvent(UUID transactionId, String processName, FailPayload payload, Exception exception) {
        this(transactionId,processName, List.of(), payload,exception);
    }

    public FailureEvent(UUID transactionId, String processName,Exception exception) {
        this(transactionId,processName, List.of(), new FailPayload(),exception);
    }

    public FailureEvent(StartEvent<?> event, Exception exception) {
        this(event.getTransactionId(), event.getProcessName(), List.of(), new FailPayload(),exception);
    }

    public FailureEvent(StartEvent<?> event, List<String> messages, FailPayload payload, Exception exception) {
        super(event, EventType.FAILURE, messages, payload);
        this.exception = exception;
    }

    public FailureEvent(StartEvent<?> event, List<String> messages, Exception exception) {
        this(event, messages, null,exception);
    }

    public FailureEvent(UUID transactionId, String processName, String message,Exception exception) {
        this(transactionId, processName, List.of(message), new FailPayload(),exception);
    }

    public FailureEvent(StartEvent<?> event, FailPayload payload, Exception exception) {
        super(event, EventType.FAILURE, payload);
        this.exception = exception;
    }


}
