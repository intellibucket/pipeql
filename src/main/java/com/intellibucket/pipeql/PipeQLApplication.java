package com.intellibucket.pipeql;

import com.intellibucket.pipeql.application.kernel.concretes.ApplicationKernel;
import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationEnvironmentInitializer;
import com.intellibucket.pipeql.application.profile.concretes.ApplicationEnvironmentInitializer;

public class PipeQLApplication {
    private static final AbstractApplicationEnvironmentInitializer ENVIRONMENT_INITIALIZER = new ApplicationEnvironmentInitializer();

    public static void main(String[] args) {
        ENVIRONMENT_INITIALIZER.initialize();
        new ApplicationKernel().start();
    }
}