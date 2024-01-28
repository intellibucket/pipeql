package com.intellibucket.pipeql.domain.model.dto.response.table;

import com.intellibucket.pipeql.domain.model.dto.response.IDReference;
import com.intellibucket.pipeql.domain.model.valueo.TableID;

import java.util.UUID;

public record TableItemModel(UUID id,UUID schemaId, String name, Boolean isValid) implements IDReference<TableID> {
    public String toString() {
        return schemaId + "." + name;
    }

    @Override
    public TableID getDomainId() {
        return TableID.of(this.schemaId(),this.id());
    }
}
