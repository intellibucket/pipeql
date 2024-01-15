package com.intellibucket.pipeql.eventlink.model.common;

import java.util.UUID;

public record GroupID(String name) {
    public static final GroupID DEFAULT = new GroupID("default");

    public static GroupID random() {
        return new GroupID(UUID.randomUUID().toString());
    }
}
