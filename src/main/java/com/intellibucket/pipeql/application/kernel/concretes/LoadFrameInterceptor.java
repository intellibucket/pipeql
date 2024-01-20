package com.intellibucket.pipeql.application.kernel.concretes;

import com.intellibucket.pipeql.lib.frame.concretes.LoadGFrame;
import com.intellibucket.pipeql.view.components.load.screens.LoadScreen;

public class LoadFrameInterceptor {
    private final LoadGFrame loadGFrame;
    private volatile Boolean flag = true;

    public LoadFrameInterceptor() {
        this.loadGFrame = new LoadScreen();
    }
    public void run() {
        loadGFrame.initialize();
        new Thread(()->{
            while (flag) {
                try {
                    Thread.sleep(1);
                    this.loadGFrame.incrementProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stop() {
        this.flag = false;
        this.loadGFrame.dispose();
    }
}
