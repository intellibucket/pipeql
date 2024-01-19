package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;

import java.awt.*;

public abstract class SmallGFrame extends AbstractGFrame {

    {
        this.setMinimumSize(new Dimension(800, 550));
        this.setLayout(new BorderLayout());
    }


    public SmallGFrame() {
        super();
    }

    public SmallGFrame(String title) {
        super(title);
    }
}
