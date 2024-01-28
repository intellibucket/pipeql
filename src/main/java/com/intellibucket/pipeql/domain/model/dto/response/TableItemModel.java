package com.intellibucket.pipeql.domain.model.dto.response;

import java.util.UUID;

public record TableItemModel(UUID id,String schema, String name, Boolean isValid) {
    public String toString() {
        return schema + "." + name;
    }
}
