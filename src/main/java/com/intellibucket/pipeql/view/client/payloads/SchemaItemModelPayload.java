package com.intellibucket.pipeql.view.client.payloads;

import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.view.components.main.model.SchemaItemModel;
import lombok.Getter;

@Getter
public class SchemaItemModelPayload implements Payload {
    private SchemaItemModel schema;

    public SchemaItemModelPayload(SchemaItemModel schema) {
        this.schema = schema;
    }

}
