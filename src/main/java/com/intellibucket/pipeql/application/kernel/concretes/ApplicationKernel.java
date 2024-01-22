package com.intellibucket.pipeql.application.kernel.concretes;

import com.intellibucket.pipeql.application.kernel.abstracts.AbstractApplicationKernel;
import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.lib.file.ImageContainer;
import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;
import com.intellibucket.pipeql.view.components.intro.screens.IntroductionScreen;
import com.intellibucket.pipeql.view.components.main.screens.MainScreen;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationKernel extends AbstractApplicationKernel {
    private final LoadFrameInterceptor FRAME_INTERCEPTOR;

    public static AbstractGFrame CURRENT_MAIN_SCREEN = null;

    public ApplicationKernel() {
        super();
        FRAME_INTERCEPTOR = new LoadFrameInterceptor();
    }

    @Override
    protected void initSettings() {
        log.info("Application is initializing settings...");
    }

    @Override
    protected void preInit() {
        log.info("Application is pre-initializing...");
        ImageContainer.initialize();
        DefaultEventLinkBroker.Mediator.start();
    }


    @Override
    protected void run() {
        FRAME_INTERCEPTOR.run();
        try {
            CURRENT_MAIN_SCREEN = new MainScreen();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CURRENT_MAIN_SCREEN.initialize();
        FRAME_INTERCEPTOR.stop();
    }
}
