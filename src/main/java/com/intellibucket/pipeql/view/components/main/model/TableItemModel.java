package com.intellibucket.pipeql.view.components.main.model;

import java.util.UUID;

public record TableItemModel(UUID id,String schema, String name) {
    public String toString() {
        return schema + "." + name;
    }
}
