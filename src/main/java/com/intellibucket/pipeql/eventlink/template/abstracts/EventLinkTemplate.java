package com.intellibucket.pipeql.eventlink.template.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.template.concretes.LinearEventLinkTemplate;

public interface EventLinkTemplate {
    void publish(ProducingMessage message);

    static LinearEventLinkTemplate linear() {
        return LinearEventLinkTemplate.INSTANCE;
    }
}
