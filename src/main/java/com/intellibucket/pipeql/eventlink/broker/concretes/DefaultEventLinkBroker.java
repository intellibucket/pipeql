package com.intellibucket.pipeql.eventlink.broker.concretes;

import com.intellibucket.pipeql.eventlink.broker.abstracts.AbstractEventLinkBroker;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.consumer.ConsumerAggregate;
import com.intellibucket.pipeql.eventlink.model.event.concretes.StartEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.pipeline.abstracts.Pipeline;
import com.intellibucket.pipeql.eventlink.pipeline.concretes.LinearEventSourcePipeline;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class DefaultEventLinkBroker implements AbstractEventLinkBroker {


    private final Map<Topic,Pipeline> pipelines = new HashMap<>();

    @Override
    public void registerConsumer(Topic topic, ConsumerAggregate consumer) {
        log.info("Registering consumer {} for topic {}", consumer, topic);
        try {
            pipelines.get(topic).subscribe(consumer);
        }catch (NullPointerException e){
            log.error("Error while registering consumer {} for topic {} because of {}", consumer, topic, e.getMessage());
            log.info("Creating new pipeline for topic {}", topic);
            pipelines.put(topic, new LinearEventSourcePipeline(topic));
            log.info("Created new pipeline for topic {}", topic);
            log.info("Registering consumer {} for topic {}", consumer, topic);
            pipelines.get(topic).subscribe(consumer);
            log.info("Registered consumer {} for topic {}", consumer, topic);
        }
        log.info("Registered consumer {} for topic {}", consumer, topic);
    }

    @Override
    public void registerPipeline(Topic topic, Pipeline pipeline) {
        log.info("Registering pipeline {} for topic {}", pipeline, topic);
        this.pipelines.put(topic, pipeline);
        log.info("Registered pipeline {} for topic {}", pipeline, topic);
    }

    public static class Mediator {
        private static final DefaultEventLinkBroker BROKER = new DefaultEventLinkBroker();

        public static DefaultEventLinkBroker broker() {
            return BROKER;
        }

        public static void registerConsumer(Topic topic, ConsumerAggregate consumer) {
            BROKER.registerConsumer(topic, consumer);
        }

        public static void registerPipeline(Topic topic, Pipeline pipeline) {
            BROKER.registerPipeline(topic, pipeline);
        }

        public static void send(Topic topic, ProducingMessage message) {
            log.info("Sending event {} to topic {}", message, topic);
            var pipeline = BROKER.pipelines.get(topic);
            if (Objects.nonNull(pipeline)) pipeline.send(message);
            else {
                log.info("For {} no pipeline found, creating a new one linear pipeline", topic);
                BROKER.registerPipeline(topic, new LinearEventSourcePipeline(topic));
                log.info("Pipeline created, sending event {} to topic {}", message, topic);
                BROKER.pipelines.get(topic).send(message);
                log.info("Event sent to topic {}", topic);
            }
        }
    }
}
