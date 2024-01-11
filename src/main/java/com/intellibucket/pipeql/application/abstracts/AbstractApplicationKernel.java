package com.intellibucket.pipeql.application.abstracts;

import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractLookAndFeelProvider;

public abstract class AbstractApplicationKernel {

    private final AbstractLookAndFeelProvider lookAndFeelProvider = AbstractLookAndFeelProvider.Factory.create();

    public void start(){
        this.lookAndFeelProvider.initLookAndFeel();
        this.initSettings();
        this.run();
    }

    protected abstract void initSettings();

    protected abstract void run();
}
