package com.intellibucket.pipeql.eventlink.model.common;

public record GroupID(String name) {
    public static final GroupID DEFAULT = new GroupID("default");
}
