package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.type.Schema;
import com.intellibucket.pipeql.domain.model.json.draw.DrawSchema;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Schema
@Builder
public class PipeQLSchema {
    private final UUID id;
    private final String version;
    private final String name;
    private final String description;
    private final String owner;
    private final String ownerEmail;
    private final String source;
    private final String schemaName;
    private final List<TableSchema> tables;
    private final DrawSchema draw;
}
