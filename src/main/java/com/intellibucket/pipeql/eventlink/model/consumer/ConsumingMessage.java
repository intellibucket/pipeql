package com.intellibucket.pipeql.eventlink.model.consumer;

import com.intellibucket.pipeql.eventlink.model.event.concretes.StartEvent;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;

public final class ConsumingMessage<T extends Payload>  {
    private final StartEvent<T> event;
    private final Callback callback;

    public ConsumingMessage(StartEvent<T> event, Callback callback) {
        this.event = event;
        this.callback = callback;
    }

    public StartEvent<T> getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "ConsumingMessage{" +
                "event=" + event +
                '}';
    }

    public Callback callback() {
        return callback;
    }
}
