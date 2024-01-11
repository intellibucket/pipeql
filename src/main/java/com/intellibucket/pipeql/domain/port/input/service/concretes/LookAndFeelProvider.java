package com.intellibucket.pipeql.domain.port.input.service.concretes;

import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractLookAndFeelProvider;

public class LookAndFeelProvider extends AbstractLookAndFeelProvider {

    private static final AbstractLookAndFeelProvider DEFAULT_LOOK_AND_FEEL_PROVIDER = new DefaultLookAndFeelProvider();

    @Override
    public void initLookAndFeel() {
        DEFAULT_LOOK_AND_FEEL_PROVIDER.initLookAndFeel();
    }

}
