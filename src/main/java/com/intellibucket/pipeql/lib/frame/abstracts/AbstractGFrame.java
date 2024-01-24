package com.intellibucket.pipeql.lib.frame.abstracts;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGFrame extends JFrame  implements ComponentInitializer {

    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public AbstractGFrame() {
        super();
    }

    public AbstractGFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public AbstractGFrame(String title) {
        super(title);
    }

    public AbstractGFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }


    @Override
    public void initialize() {
        ComponentInitializer.super.initialize();
        this.setVisible(true);
    }
}
