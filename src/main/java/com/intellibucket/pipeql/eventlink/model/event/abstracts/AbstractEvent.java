package com.intellibucket.pipeql.eventlink.model.event.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.EventType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public abstract class AbstractEvent<T> {
    private final UUID transactionId;
    private final String processName;
    private final LocalDateTime timestamp;
    private final EventType eventType;
    private final List<String> messages;
    private final T payload;

    public AbstractEvent(UUID transactionId,
                         String processName,
                         LocalDateTime timestamp,
                         EventType eventType,
                         List<String> messages,
                         T payload) {
        this.transactionId = transactionId == null ? UUID.randomUUID() : transactionId;
        this.processName = processName;
        this.timestamp = timestamp == null ? LocalDateTime.now() : timestamp;
        this.eventType = eventType;
        this.messages = messages == null ? List.of() : messages;
        this.payload = payload;
    }

    public AbstractEvent(UUID transactionId,
                         String processName,
                         EventType eventType,
                         List<String> messages,
                         T payload) {
        this(transactionId, processName, LocalDateTime.now(), eventType, messages, payload);
    }

    public AbstractEvent(AbstractEvent<?> event,
                         EventType eventType,
                         List<String> messages,
                         T payload) {
        this(event.transactionId, event.processName, LocalDateTime.now(), eventType, messages, payload);
    }

    public AbstractEvent(UUID transactionId,
                         String processName,
                         EventType eventType,
                         T payload) {
        this(transactionId, processName, eventType, List.of(), payload);
    }

    public AbstractEvent(AbstractEvent<?> event,
                         EventType eventType,
                         T payload) {
        this(event.transactionId, event.processName, eventType, List.of(), payload);
    }


    public Boolean isSuccessful() {
        return eventType.equals(EventType.SUCCESS);
    }

    public Boolean isFailure() {
        return eventType.equals(EventType.FAILURE);
    }

    public Boolean isWarning() {
        return eventType.equals(EventType.WARNING);
    }

    public Boolean isInfo() {
        return eventType.equals(EventType.INFO);
    }

    public Boolean isStart() {
        return eventType.equals(EventType.START);
    }

    public Boolean hasMessages() {
        return !messages.isEmpty();
    }

    public String fetchFirstMessage() {
        return messages.get(0);
    }

    public String fetchFirstMessageElse(String elseMessage) {
        return this.hasMessages() ? this.fetchFirstMessage() : elseMessage;
    }

}
