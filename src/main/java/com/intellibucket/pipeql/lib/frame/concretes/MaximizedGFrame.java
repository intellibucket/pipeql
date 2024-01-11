package com.intellibucket.pipeql.lib.frame.concretes;

import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;

import java.awt.*;

public class MaximizedGFrame extends AbstractGFrame {

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
