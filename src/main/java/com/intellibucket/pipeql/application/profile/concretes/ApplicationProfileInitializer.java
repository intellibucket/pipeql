package com.intellibucket.pipeql.application.profile.concretes;

import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;

import java.util.Locale;
import java.util.Objects;

public class ApplicationProfileInitializer extends AbstractApplicationProfileInitializer {


    @Override
    public void initialize() {
        var profile = Objects.requireNonNullElse(System.getenv("pipeql.profile.active"),"development");
        PROFILE = ApplicationProfile.valueOf(profile.toUpperCase(Locale.ROOT));
    }
}
