package com.intellibucket.pipeql.application.profile.concretes;

import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;

import java.util.Locale;

public class ApplicationProfileInitializer extends AbstractApplicationProfileInitializer {
    private static ApplicationProfile PROFILE;

    @Override
    public void initialize() {
        var profile = System.getenv("pipeql.profile.active");
        PROFILE = ApplicationProfile.valueOf(profile.toUpperCase(Locale.ROOT));
    }
}
