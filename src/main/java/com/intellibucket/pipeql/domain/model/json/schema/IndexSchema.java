package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Schema
@Builder
@Getter
public class IndexSchema {
    private final UUID id;
    private final String schemaName;
    private final String tableName;
    private final String indexName;
    private final String description;
    private final String indexType;
    private final String indexCondition;
    private final Boolean isUnique;
}
