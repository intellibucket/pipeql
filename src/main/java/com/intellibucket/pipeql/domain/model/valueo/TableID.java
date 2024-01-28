package com.intellibucket.pipeql.domain.model.valueo;

import java.util.Objects;
import java.util.UUID;

public class TableID {
    private final UUID schemaId;

    private final UUID tableId;

    public TableID(UUID schemaId, UUID tableId) {
        this.schemaId = schemaId;
        this.tableId = tableId;
    }

    public UUID getSchemaId() {
        return schemaId;
    }

    public UUID getTableId() {
        return tableId;
    }

    public static TableID of(UUID schemaId,UUID tableId) {
        return new TableID(schemaId, tableId);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableID tableID)) return false;
        return Objects.equals(getSchemaId(), tableID.getSchemaId()) && Objects.equals(tableId, tableID.tableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchemaId(), tableId);
    }
}
