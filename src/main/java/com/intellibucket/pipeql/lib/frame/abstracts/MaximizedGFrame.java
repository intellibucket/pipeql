package com.intellibucket.pipeql.lib.frame.abstracts;

import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;

import java.awt.*;

public abstract class MaximizedGFrame extends AbstractGFrame {

    {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }
    public MaximizedGFrame()   {
        super();
    }

    public MaximizedGFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public MaximizedGFrame(String title)   {
        super(title);
    }

    public MaximizedGFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }
}
