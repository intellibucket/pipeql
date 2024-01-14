package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Schema
@Builder
@Getter
public class SynonymSchema {
    private final UUID id;
    private final String schemaName;
    private final String synonymName;
    private final String description;
    private final String targetSchemaName;
    private final String targetObjectName;
    private final Boolean isPublic;
}
