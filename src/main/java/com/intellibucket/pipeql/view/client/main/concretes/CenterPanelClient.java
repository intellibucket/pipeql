package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractCenterPanelClient;
import com.intellibucket.pipeql.view.client.main.abstracts.DomainClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CenterPanelClient extends DomainClient implements AbstractCenterPanelClient {

    public static class Topics{
        public static final Topic CLOSE_ALL_SCHEMAS_TOPIC = new Topic("CLOSE_ALL_SCHEMAS");
    }

    @Override
    public void closeAllSchemas() {
        log.info("CenterPanelClient executing closeAllSchemas");
        var request = ProducingMessage.Builder
                .builder()
                .topic(Topics.CLOSE_ALL_SCHEMAS_TOPIC)
                .build();
        this.publish(request);
    }
}
