package com.intellibucket.pipeql.eventlink.behavirol.abstracts;

import com.intellibucket.pipeql.eventlink.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.consumer.ConsumingMessage;
import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.payload.FailPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;

public abstract class Consumer<T extends Payload,F extends FailPayload,S extends SuccessPayload> {

    void push(ConsumingMessage<T,S,F> message){
        var event = message.getEvent();
        try {
            var result = this.consume(event.getPayload());
            message.onSuccess(new SuccessEvent(event,result));
        }catch (DomainException e){
            message.onFail(new FailureEvent(event.getTransactionId(),event.getProcessName(),e.getMessage()));
        }catch (Exception e){
            message.onFail(new FailureEvent(event.getTransactionId(),event.getProcessName(), "Unknown error"));
        }
    }

    abstract S consume(T message) throws DomainException;

}
