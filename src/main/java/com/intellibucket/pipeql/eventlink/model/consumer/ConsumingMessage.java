package com.intellibucket.pipeql.eventlink.model.consumer;

import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;

public final class ConsumingMessage  {
    private final StartEvent<?> event;
    private final Callback callback;

    public ConsumingMessage(StartEvent<?> event, Callback callback) {
        this.event = event;
        this.callback = callback;
    }

    public StartEvent<?> getEvent() {
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
