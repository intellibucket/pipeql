package com.intellibucket.pipeql.application.profile.abstracts;

import com.intellibucket.pipeql.application.profile.concretes.ApplicationProfile;

public abstract class AbstractApplicationProfileInitializer {
    public static ApplicationProfile PROFILE;
    public abstract void initialize();
}
