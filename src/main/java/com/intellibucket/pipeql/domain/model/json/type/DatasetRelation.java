package com.intellibucket.pipeql.domain.model.json.type;

import com.intellibucket.pipeql.domain.model.json.Schema;
import lombok.Builder;

import java.util.UUID;

@Schema
@Builder
public class DatasetRelation {
    private final UUID id;
    private final UUID datasetId;
}
