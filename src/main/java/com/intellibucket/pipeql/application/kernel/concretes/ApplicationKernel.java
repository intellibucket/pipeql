package com.intellibucket.pipeql.application.kernel.concretes;

import com.intellibucket.pipeql.application.kernel.abstracts.AbstractApplicationKernel;
import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;
import com.intellibucket.pipeql.application.profile.concretes.ApplicationProfileInitializer;
import com.intellibucket.pipeql.lib.file.IconContainer;
import com.intellibucket.pipeql.view.components.main.screens.MainScreen;

public class ApplicationKernel extends AbstractApplicationKernel {
    private static final AbstractApplicationProfileInitializer PROFILE_INITIALIZER = new ApplicationProfileInitializer();

    @Override
    protected void initSettings() {
        PROFILE_INITIALIZER.initialize();
        IconContainer.initialize();
    }

    @Override
    protected void run() {
        new MainScreen().initialize();
    }
}
