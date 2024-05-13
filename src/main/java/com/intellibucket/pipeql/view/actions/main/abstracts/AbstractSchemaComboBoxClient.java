package com.intellibucket.pipeql.view.actions.main.abstracts;

import com.intellibucket.pipeql.domain.model.dto.response.schema.SchemaItemModel;

public interface AbstractSchemaComboBoxClient {
    void changeSchema(SchemaItemModel schema);
}
