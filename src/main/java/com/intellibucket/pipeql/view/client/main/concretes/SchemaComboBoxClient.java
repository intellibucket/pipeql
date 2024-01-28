package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractSchemaComboBoxClient;
import com.intellibucket.pipeql.view.client.payloads.SchemaItemModelPayload;
import com.intellibucket.pipeql.domain.model.dto.response.schema.SchemaItemModel;
import com.intellibucket.pipeql.view.topics.SchemaComboBoxTopics;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchemaComboBoxClient implements AbstractSchemaComboBoxClient {
    private final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.INSTANCE;

    @Override
    public void changeSchema(SchemaItemModel schema) {
        log.info("SchemaComboBoxClient executed changeSchema and published message to topic: {}", SchemaComboBoxTopics.CHANGED_SELECTED_SCHEMA_ON_COMBOBOX);
        var message =  ProducingMessage.Builder
                .builder()
                .topic(SchemaComboBoxTopics.CHANGED_SELECTED_SCHEMA_ON_COMBOBOX)
                .event(new StartEvent<>(new SchemaItemModelPayload(schema)))
                .build();
        this.eventLinkTemplate.publish(message);
    }
}
