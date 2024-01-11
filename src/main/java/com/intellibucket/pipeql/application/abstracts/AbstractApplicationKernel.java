package com.intellibucket.pipeql.application.abstracts;

import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractLookAndFeelProvider;

public abstract class AbstractApplicationKernel {

    private static final AbstractLookAndFeelProvider LOOK_AND_FEEL_PROVIDER = AbstractLookAndFeelProvider.Factory.create();

    static {
        LOOK_AND_FEEL_PROVIDER.initLookAndFeel();
    }
    public void start(){
        this.initSettings();
        this.run();
    }

    protected abstract void initSettings();

    protected abstract void run();
}
