package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGPanel extends JPanel implements ComponentInitializer {

    public AbstractGPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public AbstractGPanel(LayoutManager layout) {
        super(layout);
    }

    public AbstractGPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public AbstractGPanel() {
    }
}
