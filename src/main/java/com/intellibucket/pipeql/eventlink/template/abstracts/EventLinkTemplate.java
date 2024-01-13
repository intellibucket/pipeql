package com.intellibucket.pipeql.eventlink.template.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;

public interface EventLinkTemplate {
    void publish(ProducingMessage message);
}
