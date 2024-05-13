package com.intellibucket.pipeql.view.actions.payloads;

import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.domain.model.dto.response.schema.SchemaItemModel;
import lombok.Getter;

@Getter
public class SchemaItemModelPayload implements Payload {
    private SchemaItemModel schema;

    public SchemaItemModelPayload(SchemaItemModel schema) {
        this.schema = schema;
    }

}
