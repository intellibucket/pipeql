package com.intellibucket.pipeql.application.kernel.abstracts;

import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractLookAndFeelProvider;
import org.apache.log4j.BasicConfigurator;

public abstract class AbstractApplicationKernel {

    private static final AbstractLookAndFeelProvider LOOK_AND_FEEL_PROVIDER = AbstractLookAndFeelProvider.Factory.create();

    static {
        LOOK_AND_FEEL_PROVIDER.initLookAndFeel();
    }

    public void start(){
        BasicConfigurator.configure();
        this.preInit();
        this.initSettings();
        this.run();
    }


    protected abstract void preInit();

    protected abstract void initSettings();

    protected abstract void run();
}
