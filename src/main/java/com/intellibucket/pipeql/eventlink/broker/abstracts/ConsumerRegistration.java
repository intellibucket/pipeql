package com.intellibucket.pipeql.eventlink.broker.abstracts;

import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.consumer.ConsumerAggregate;

public interface ConsumerRegistration {
    void registerConsumer(Topic topic, ConsumerAggregate consumer);
}
