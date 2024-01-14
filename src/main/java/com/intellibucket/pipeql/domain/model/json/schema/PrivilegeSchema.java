package com.intellibucket.pipeql.domain.model.json.schema;

import com.intellibucket.pipeql.domain.model.json.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Schema
@Builder
@Getter
public class PrivilegeSchema {
    private final UUID id;
    private final String schemaName;
    private final String tableName;
    private final String privilegeName;
    private final String description;
    private final String privilegeType;
    private final String privilegeCondition;
}
