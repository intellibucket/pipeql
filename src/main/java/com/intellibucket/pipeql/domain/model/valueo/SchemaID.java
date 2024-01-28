package com.intellibucket.pipeql.domain.model.valueo;

import java.util.UUID;

public class SchemaID {
    private final UUID schemaId;

    public SchemaID(UUID schemaId) {
        this.schemaId = schemaId;
    }

    public UUID getSchemaId() {
        return schemaId;
    }

    public static SchemaID of(UUID schemaId) {
        return new SchemaID(schemaId);
    }


    @Override
    public String toString() {
        return "SchemaID{" +
                "schemaId=" + schemaId +
                '}';
    }
}
