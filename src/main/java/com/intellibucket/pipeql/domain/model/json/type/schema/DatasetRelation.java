package com.intellibucket.pipeql.domain.model.json.type.schema;

import com.intellibucket.pipeql.domain.model.json.type.Schema;
import lombok.Builder;

import java.util.UUID;

@Schema
@Builder
public class DatasetRelation {
    private final UUID id;
    private final UUID datasetId;
}
