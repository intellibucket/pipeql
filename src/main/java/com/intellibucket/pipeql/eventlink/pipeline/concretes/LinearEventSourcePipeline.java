package com.intellibucket.pipeql.eventlink.pipeline.concretes;

import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.consumer.ConsumerAggregate;
import com.intellibucket.pipeql.eventlink.model.consumer.ConsumingMessage;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.pipeline.abstracts.AbstractPipeline;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class LinearEventSourcePipeline extends AbstractPipeline {

    public LinearEventSourcePipeline(Topic topic) {
        super(topic);
    }

    @Override
    public void send(ProducingMessage message) {
        log.info("Sending message to consumers for topic: {} , message : {}",this.topic().name(),message);
        this.groupingConsumers().values().parallelStream().forEach(consumers -> {
            var consumingMessage = new ConsumingMessage(message.getEvent(),message.getCallback());
            consumers.forEach(consumer -> consumer.consume(consumingMessage));
        });
        log.info("Message sent to consumers for topic: {} , message : {}",this.topic().name(),message);
    }

    @Override
    public void subscribe(ConsumerAggregate consumerAggregate) {
        log.info("Subscribing consumer for topic: {} , consumer : {}",this.topic().name(), consumerAggregate);
        if(!this.groupingConsumers().containsKey(consumerAggregate.groupId()))
            this.groupingConsumers().put(consumerAggregate.groupId(), List.of(consumerAggregate.consumer()));
        else this.groupingConsumers().get(consumerAggregate.groupId()).add(consumerAggregate.consumer());
        log.info("Consumer subscribed for topic: {} , consumer : {}",this.topic().name(), consumerAggregate);
    }

}
