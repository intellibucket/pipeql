package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.type.Schema;
import com.intellibucket.pipeql.domain.model.json.type.schema.ColumnRelation;
import com.intellibucket.pipeql.domain.model.json.type.schema.DatasetRelation;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Schema
@Builder
@Getter
public class ColumnSchema {
    private final UUID id;
    private final ColumnRelation columnRelation;
    private final DatasetRelation datasetRelation;
    private final String columnName;
    private final String description;
    private final String dataType;
    private final Integer length;
    private final Integer precision;
    private final Integer scale;
    private final Boolean isNullable;
    private final Boolean isPrimaryKey;
    private final Boolean isForeignKey;
    private final Boolean isUnique;
    private final Boolean isIndexed;
    private final Boolean isAutoIncrement;
    private final Boolean isGenerated;
    private final Boolean isVirtual;
    private final Boolean isHidden;
    private final Boolean isReadOnly;
    private final Boolean isUpdatable;
    private final Boolean isInsertable;
    private final Boolean isDeletable;
    private final Boolean isSelectable;

    public Boolean hasColumnRelation() {
        return columnRelation != null;
    }

    public Boolean hasDatasetRelation() {
        return datasetRelation != null;
    }

    public Boolean isHidden() {
        return isHidden;
    }

    public Boolean isReadOnly() {
        return isReadOnly;
    }

    public Boolean isUpdatable() {
        return isUpdatable;
    }

    public Boolean isInsertable() {
        return isInsertable;
    }

    public Boolean isDeletable() {
        return isDeletable;
    }

    public Boolean isSelectable() {
        return isSelectable;
    }

    public Boolean isAutoIncrement() {
        return isAutoIncrement;
    }

    public Boolean isGenerated() {
        return isGenerated;
    }

    public Boolean isVirtual() {
        return isVirtual;
    }

    public Boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public Boolean isForeignKey() {
        return isForeignKey;
    }

    public Boolean isUnique() {
        return isUnique;
    }

    public Boolean isIndexed() {
        return isIndexed;
    }

    public Boolean isNullable() {
        return isNullable;
    }

    public Boolean hasLength() {
        return length != null;
    }

    public Boolean hasPrecision() {
        return precision != null;
    }

    public Boolean hasScale() {
        return scale != null;
    }

    public Boolean hasDescription() {
        return description != null;
    }

    public Boolean hasDataType() {
        return dataType != null;
    }

    public Boolean hasColumnName() {
        return columnName != null;
    }



}
