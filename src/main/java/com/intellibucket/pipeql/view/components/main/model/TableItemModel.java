package com.intellibucket.pipeql.view.components.main.model;

import java.util.UUID;

public record TableItemModel(UUID id,String schema, String name, Boolean isValid) {
    public String toString() {
        return schema + "." + name;
    }
}
