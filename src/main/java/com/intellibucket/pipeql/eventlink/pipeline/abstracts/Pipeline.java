package com.intellibucket.pipeql.eventlink.pipeline.abstracts;

import com.intellibucket.pipeql.eventlink.model.consumer.ConsumerAggregate;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;

public interface Pipeline {
    void send(ProducingMessage message);
    void subscribe(ConsumerAggregate consumerAggregate);
}
