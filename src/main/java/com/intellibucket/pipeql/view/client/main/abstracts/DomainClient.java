package com.intellibucket.pipeql.view.client.main.abstracts;

import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;

public abstract class DomainClient {
    protected final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.linear();

    public void publish(ProducingMessage request){
        this.eventLinkTemplate.publish(request);
    }
}
