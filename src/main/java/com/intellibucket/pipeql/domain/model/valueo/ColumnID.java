package com.intellibucket.pipeql.domain.model.valueo;

import java.util.UUID;

public class ColumnID extends TableID{

    private final UUID columnId;

    public ColumnID(UUID schemaId, UUID tableId, UUID columnId) {
        super(schemaId, tableId);
        this.columnId = columnId;
    }


    public UUID getColumnId() {
        return columnId;
    }

    public static ColumnID of(UUID schemaId, UUID tableId, UUID columnId) {
        return new ColumnID(schemaId, tableId, columnId);
    }


    @Override
    public String toString() {
        return "ColumnID{" +
                "columnId=" + columnId +
                '}';
    }
}
