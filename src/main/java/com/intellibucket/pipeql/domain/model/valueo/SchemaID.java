package com.intellibucket.pipeql.domain.model.valueo;

import java.util.Objects;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchemaID schemaID)) return false;
        return Objects.equals(getSchemaId(), schemaID.getSchemaId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchemaId());
    }
}
