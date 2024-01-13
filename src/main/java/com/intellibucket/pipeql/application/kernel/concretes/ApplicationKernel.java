package com.intellibucket.pipeql.application.kernel.concretes;

import com.intellibucket.pipeql.application.kernel.abstracts.AbstractApplicationKernel;
import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;
import com.intellibucket.pipeql.application.profile.concretes.ApplicationProfileInitializer;
import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.lib.file.IconContainer;
import com.intellibucket.pipeql.view.components.main.screens.MainScreen;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

@Slf4j
public class ApplicationKernel extends AbstractApplicationKernel {
    private static final AbstractApplicationProfileInitializer PROFILE_INITIALIZER = new ApplicationProfileInitializer();

    @Override
    protected void initSettings() {
        log.info("Application is initializing settings...");
    }

    @Override
    protected void preInit() {
        log.info("Application is pre-initializing...");
        PROFILE_INITIALIZER.initialize();
        IconContainer.initialize();
        DefaultEventLinkBroker.Mediator.start();
    }

    @Override
    protected void run() {
        new MainScreen().initialize();
    }
}
