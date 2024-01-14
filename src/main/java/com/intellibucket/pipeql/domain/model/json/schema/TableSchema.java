package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.type.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Schema
@Builder
@Getter
public class TableSchema {
    private final UUID id;
    private final String schemaName;
    private final String tableName;
    private final String description;
    private final List<ColumnSchema> columns;
    private final List<ConstraintSchema> constraints;
    private final List<IndexSchema> indexes;
    private final List<TriggerSchema> triggers;
    private final List<PrivilegeSchema> privileges;
    private final List<SynonymSchema> synonyms;
}
