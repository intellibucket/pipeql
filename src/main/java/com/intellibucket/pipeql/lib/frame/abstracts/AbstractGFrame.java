package com.intellibucket.pipeql.lib.frame.abstracts;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGFrame extends JFrame {

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
}
