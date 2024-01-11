package com.intellibucket.pipeql.domain.port.input.service.abstracts;

import com.intellibucket.pipeql.domain.port.input.service.concretes.LookAndFeelProvider;

public abstract class AbstractLookAndFeelProvider {

    public abstract void initLookAndFeel();


    public static class Factory {
        public static AbstractLookAndFeelProvider create() {
            return new LookAndFeelProvider();
        }
    }
}
