package com.intellibucket.pipeql.eventlink.rx.abstracts;


import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;

@FunctionalInterface
public interface Publisher {
    void publish(ProducingMessage message);
}
