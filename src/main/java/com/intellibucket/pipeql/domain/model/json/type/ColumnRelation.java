package com.intellibucket.pipeql.domain.model.json.type;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ColumnRelation {
    private final UUID id;
    private final RelationType relationType;
    private final UUID tableId;
    private final UUID columnId;
}
