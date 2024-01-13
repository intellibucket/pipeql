package com.intellibucket.pipeql.eventlink.model.common;

public record Topic(String name) {
    public static final Topic SYSTEM = new Topic("system");
}
