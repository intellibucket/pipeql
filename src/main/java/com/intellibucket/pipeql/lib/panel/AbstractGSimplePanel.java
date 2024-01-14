package com.intellibucket.pipeql.lib.panel;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGSimplePanel extends AbstractGPanel {
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public AbstractGSimplePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public AbstractGSimplePanel(LayoutManager layout) {
        super(layout);
    }

    public AbstractGSimplePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public AbstractGSimplePanel() {
    }
}
