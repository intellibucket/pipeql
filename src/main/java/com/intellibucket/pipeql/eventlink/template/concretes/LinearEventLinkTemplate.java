package com.intellibucket.pipeql.eventlink.template.concretes;

import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;

public class LinearEventLinkTemplate implements EventLinkTemplate {
    @Override
    public void publish(ProducingMessage message) {
        DefaultEventLinkBroker.Mediator.send(message);
    }
}
