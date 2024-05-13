package com.intellibucket.pipeql.lib.panel;

import javax.swing.*;
import java.awt.*;

public abstract class BorderGSimplePanel extends AbstractGSimplePanel {
    {
        this.setLayout(new BorderLayout());
    }

    public BorderGSimplePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public BorderGSimplePanel(LayoutManager layout) {
        super(layout);
    }

    public BorderGSimplePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public BorderGSimplePanel() {
    }
}