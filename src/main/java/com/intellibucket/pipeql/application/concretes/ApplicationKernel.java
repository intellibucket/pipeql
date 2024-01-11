package com.intellibucket.pipeql.application.concretes;

import com.intellibucket.pipeql.application.abstracts.AbstractApplicationKernel;
import com.intellibucket.pipeql.view.components.main.screens.MainScreen;

public class ApplicationKernel extends AbstractApplicationKernel {
    private final MainScreen mainScreen = new MainScreen();

    @Override
    protected void initSettings() {
    }

    @Override
    protected void run() {

    }
}
