package com.intellibucket.pipeql.eventlink.model.event.concretes.start;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class StartEvent <T extends Payload> extends AbstractEvent<T> {

    public StartEvent(UUID transactionId, String processName, List<String> messages, T payload) {
        super(transactionId, processName, EventType.START, messages, payload);
    }

    public StartEvent(String processName, List<String> messages, T payload) {
        this(UUID.randomUUID(), processName, messages, payload);
    }

    public StartEvent(UUID transactionId, String processName, T payload) {
        this(transactionId, processName, List.of(), payload);
    }

    public StartEvent( String processName, T payload) {
        this(UUID.randomUUID(), processName, List.of(), payload);
    }

    public StartEvent(UUID transactionId, String processName) {
        this(transactionId, processName,  List.of(), null);
    }

    public StartEvent(String processName) {
        this(UUID.randomUUID(),processName);
    }

}
