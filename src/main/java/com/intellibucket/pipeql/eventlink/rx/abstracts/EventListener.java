package com.intellibucket.pipeql.eventlink.rx.abstracts;

import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.domain.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.consumer.ConsumingMessage;
import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.InfoEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.WarningEvent;
import com.intellibucket.pipeql.eventlink.model.payload.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class EventListener<T extends Payload,S extends SuccessPayload>  {

    private final List<Topic> topics;

    protected EventListener(List<Topic> topics) {
        this.topics = topics;
        DefaultEventLinkBroker.Mediator.registerConsumer(new ArrayList<>(this.topics), this);
    }

    @SuppressWarnings("unchecked")
    public void consume(ConsumingMessage message){
        log.info("Consuming message start pushing {}",message);
        var event = message.getEvent();
        try {
            var result = this.listen((T) event.getPayload());
            if (result instanceof WarningPayload)
                this.onWarning(new WarningEvent(event.getTransactionId(),event.getProcessName(),(WarningPayload) result));
            else if (result instanceof InfoPayload)
                this.onInfo(new InfoEvent(event.getTransactionId(),event.getProcessName(),(InfoPayload) result));
            this.onSuccess(message,new SuccessEvent(event,result));
        }catch (DomainException e){
            log.error("Domain exception with transaction id {} and process name {}. Exception : {}",event.getTransactionId(),event.getProcessName(), e.getMessage());
            this.onFail(message,new FailureEvent(event.getTransactionId(),event.getProcessName(),e.getMessage(),e));
        }catch (Exception e){
            log.error("Unknown exception with transaction id {} and process name {}. Exception : {}",event.getTransactionId(),event.getProcessName(), e.getMessage());
            var failureEvent = new FailureEvent(event.getTransactionId(),event.getProcessName(), "Unknown error",e);
            this.onFail(message,failureEvent);
            this.onError(failureEvent);
        }
    }

    protected abstract S listen(T message) throws DomainException;

    void onWarning(WarningEvent event){
        log.warn("Warning event {}",event);
    }

    void onInfo(InfoEvent event){
        log.info("Info event {}",event);
    }

    void onError(FailureEvent event){
        log.error("Callback error event {}",event);
    }

    public void onFail(ConsumingMessage message, FailureEvent event) {
        log.error("Callback fail event {}",event);
        message.callback().onFail(event);
    }

    public void onSuccess(ConsumingMessage message, SuccessEvent event) {
        log.info("Callback success event {}",event);
        message.callback().onSuccess(event);
    }

    protected List<Topic> mustBeRegistryTopics(){return List.of();}
}
