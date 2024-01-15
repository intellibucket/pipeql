package com.intellibucket.pipeql.eventlink.model.common;

import java.util.Locale;

public record Topic(String name) {
    public static final Topic SYSTEM = new Topic("system");

    public static Topic of(String value) {
        return new Topic(value);
    }

    @Override
    public String name() {
        return name.toLowerCase(Locale.ROOT);
    }
}
