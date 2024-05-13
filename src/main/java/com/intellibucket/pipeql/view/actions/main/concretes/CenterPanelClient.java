package com.intellibucket.pipeql.view.actions.main.concretes;

import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractCenterPanelClient;
import com.intellibucket.pipeql.view.actions.main.abstracts.DomainClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CenterPanelClient extends DomainClient implements AbstractCenterPanelClient {

    public static class Topics{
        public static final Topic CLOSE_ALL_SCHEMAS_TOPIC = new Topic("CLOSE_ALL_SCHEMAS");
    }

    @Override
    public void closeAllSchemas() {
        var request = ProducingMessage.Builder
                .builder()
                .topic(Topics.CLOSE_ALL_SCHEMAS_TOPIC)
                .build();
        this.publish(request);
    }

    private void closeAllSchemas(ProducingMessage request){
        log.info("CenterPanelClient executing closeAllSchemas");
        this.publish(request);
    }
    @Override
    public void closeAllSchemas(Callback callback) {
        var request = ProducingMessage.Builder
                .builder()
                .topic(Topics.CLOSE_ALL_SCHEMAS_TOPIC)
                .callback(callback)
                .build();
        this.publish(request);
    }
}
