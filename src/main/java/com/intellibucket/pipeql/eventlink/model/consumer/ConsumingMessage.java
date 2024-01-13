package com.intellibucket.pipeql.eventlink.model.consumer;

import com.intellibucket.pipeql.eventlink.rx.Callback;
import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.StartEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.payload.FailPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;

public class ConsumingMessage<T extends Payload,S extends SuccessPayload,F extends FailPayload> implements Callback<S,F> {
    private final StartEvent<T> event;
    private final Callback<S,F> callback;

    public ConsumingMessage(StartEvent<T> event, Callback<S, F> callback) {
        this.event = event;
        this.callback = callback;
    }

    public StartEvent<T> getEvent() {
        return event;
    }

    @Override
    public void onSuccess(SuccessEvent event) {
        callback.onSuccess(event);
    }

    @Override
    public void onFail(FailureEvent event) {
        callback.onFail(event);
    }
}
