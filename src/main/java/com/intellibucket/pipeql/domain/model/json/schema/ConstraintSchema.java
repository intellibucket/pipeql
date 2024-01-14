package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.type.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Schema
@Builder
@Getter
public class ConstraintSchema {
    private final UUID id;
    private final String schemaName;
    private final String tableName;
    private final String constraintName;
    private final String description;
    private final String constraintType;
    private final String constraintCondition;
}
