package com.intellibucket.pipeql.application.kernel.concretes;

import com.intellibucket.pipeql.application.kernel.abstracts.AbstractApplicationKernel;
import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;
import com.intellibucket.pipeql.application.profile.concretes.ApplicationProfileInitializer;
import com.intellibucket.pipeql.view.components.main.screens.MainScreen;

public class ApplicationKernel extends AbstractApplicationKernel {
    private static final MainScreen MAIN_SCREEN = new MainScreen();
    private static final AbstractApplicationProfileInitializer PROFILE_INITIALIZER = new ApplicationProfileInitializer();

    @Override
    protected void initSettings() {
        PROFILE_INITIALIZER.initialize();
    }

    @Override
    protected void run() {
        ApplicationKernel.MAIN_SCREEN.initialize();
    }
}
