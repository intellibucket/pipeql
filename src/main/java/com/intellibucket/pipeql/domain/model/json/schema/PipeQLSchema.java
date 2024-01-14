package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.Schema;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Schema
@Builder
public class PipeQLSchema {
    private final UUID id;
    private final String schemaName;
    private final List<TableSchema> tables;
    private final DrawSchema draw;
}
