package com.intellibucket.pipeql;

import com.intellibucket.pipeql.application.abstracts.AbstractApplicationKernel;
import com.intellibucket.pipeql.application.concretes.ApplicationKernel;

public class PipeQLApplication {
    private final static AbstractApplicationKernel APPLICATION_KERNEL = new ApplicationKernel();
    public static void main(String[] args) {
        PipeQLApplication.APPLICATION_KERNEL.start();
    }
}