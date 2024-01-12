package com.intellibucket.pipeql.lib.panel;

import java.awt.*;

public abstract class LinePanel extends AbstractGPanel{

    public LinePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public LinePanel(LayoutManager layout) {
        this(layout, false);
    }

    public LinePanel(boolean isDoubleBuffered) {
        this(new BorderLayout(), isDoubleBuffered);
    }

    public LinePanel() {
        this(new BorderLayout());
    }

}

