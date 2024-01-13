package com.intellibucket.pipeql.eventlink.template.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.producer.Topic;

public interface EventLinkTemplate {
    void send(Topic topic, AbstractEvent event);

}
