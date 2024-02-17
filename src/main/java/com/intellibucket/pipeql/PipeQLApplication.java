package com.intellibucket.pipeql;

import com.intellibucket.pipeql.application.kernel.concretes.ApplicationKernel;
import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;
import com.intellibucket.pipeql.application.profile.concretes.ApplicationProfileInitializer;

public class PipeQLApplication {
    private static final AbstractApplicationProfileInitializer PROFILE_INITIALIZER = new ApplicationProfileInitializer();
    public static void main(String[] args) {
        PROFILE_INITIALIZER.initialize();
        new ApplicationKernel().start();
    }
}