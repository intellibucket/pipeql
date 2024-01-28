package com.intellibucket.pipeql.domain.model.valueo;

import java.util.UUID;

public class TableID extends SchemaID{

    private final UUID tableId;

    public TableID(UUID schemaId, UUID tableId) {
        super(schemaId);
        this.tableId = tableId;
    }


    public UUID getTableId() {
        return tableId;
    }

    public static TableID of(UUID schemaId,UUID tableId) {
        return new TableID(schemaId, tableId);
    }


    @Override
    public String toString() {
        return "TableID{" +
                "tableId=" + tableId +
                '}';
    }
}
