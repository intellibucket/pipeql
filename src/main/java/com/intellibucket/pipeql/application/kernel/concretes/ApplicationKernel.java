package com.intellibucket.pipeql.application.kernel.concretes;

import com.intellibucket.pipeql.application.kernel.abstracts.AbstractApplicationContextLoader;
import com.intellibucket.pipeql.application.kernel.abstracts.AbstractApplicationKernel;
import com.intellibucket.pipeql.dao.MockDataProvider;
import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.lib.file.ImageContainer;
import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;
import com.intellibucket.pipeql.view.components.main.screens.MainScreen;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationKernel extends AbstractApplicationKernel {
    private final LoadFrameInterceptor frameInterceptor;
    private final AbstractApplicationContextLoader applicationContextLoader;

    public static AbstractGFrame CURRENT_MAIN_SCREEN = null;

    public ApplicationKernel() {
        super();
        this.frameInterceptor = new LoadFrameInterceptor();
        this.applicationContextLoader = new ApplicationContextLoader();
        MockDataProvider mockDataProvider = new MockDataProvider();
    }

    @Override
    protected void initSettings() {
        log.info("Application is initializing settings...");
    }

    @Override
    protected void preInit() {
        log.info("Application is pre-initializing...");
        log.info("Spring Application Context loading.");
        this.applicationContextLoader.load();
        log.info("Image Container initialize.");
        ImageContainer.initialize();
        log.info("Event Link Broker starting...");
        DefaultEventLinkBroker.Mediator.start();
    }


    @Override
    protected void run() {
        frameInterceptor.run();
        try {
            CURRENT_MAIN_SCREEN = new MainScreen();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CURRENT_MAIN_SCREEN.initialize();
        frameInterceptor.stop();
    }
}
