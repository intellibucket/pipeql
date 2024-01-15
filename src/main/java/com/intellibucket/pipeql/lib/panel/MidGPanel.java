package com.intellibucket.pipeql.lib.panel;

import java.awt.*;

public abstract class MidGPanel extends AbstractGPanel{

    {
        this.setSize(new Dimension(1200, 800));
        this.setMaximumSize(new Dimension(1200, 800));
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLayout(new BorderLayout());
    }

    public MidGPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public MidGPanel(LayoutManager layout) {
        super(layout);
    }

    public MidGPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public MidGPanel() {
    }
}
