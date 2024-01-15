package com.intellibucket.pipeql.eventlink.model.common;

import java.util.Locale;

public record Topic(String name) {
    public static final Topic SYSTEM = new Topic("system");

    @Override
    public String name() {
        return name.toLowerCase(Locale.ROOT);
    }
}
