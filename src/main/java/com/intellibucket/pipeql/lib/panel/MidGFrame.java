package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.application.kernel.concretes.ApplicationKernel;
import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;

import java.awt.*;

public abstract class MidGFrame extends AbstractGFrame {

    {
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(ApplicationKernel.CURRENT_MAIN_SCREEN);
    }


    public MidGFrame() {
        super();
    }

    public MidGFrame(String title) {
        super(title);
    }
}
