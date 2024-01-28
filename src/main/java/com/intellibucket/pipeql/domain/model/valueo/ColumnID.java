package com.intellibucket.pipeql.domain.model.valueo;

import java.util.Objects;
import java.util.UUID;

public class ColumnID {
    private final UUID schemaId;

    private final UUID tableId;

    private final UUID columnId;

    public ColumnID(UUID schemaId, UUID tableId, UUID columnId) {
        this.schemaId = schemaId;
        this.tableId = tableId;
        this.columnId = columnId;
    }

    public UUID getSchemaId() {
        return schemaId;
    }

    public UUID getTableId() {
        return tableId;
    }

    public UUID getColumnId() {
        return columnId;
    }

    public static ColumnID of(UUID schemaId, UUID tableId, UUID columnId) {
        return new ColumnID(schemaId, tableId, columnId);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColumnID columnID)) return false;
        return Objects.equals(getSchemaId(), columnID.getSchemaId()) && Objects.equals(tableId, columnID.tableId) && Objects.equals(columnId, columnID.columnId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchemaId(), tableId, columnId);
    }
}
