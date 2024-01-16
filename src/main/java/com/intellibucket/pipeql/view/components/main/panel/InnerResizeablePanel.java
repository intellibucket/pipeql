package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.lib.panel.main.AbstractInnerResizeablePanel;

import java.awt.*;

public abstract class InnerResizeablePanel extends AbstractInnerResizeablePanel {

    {
        this.setBackground(new Color(30,36,40));
    }
    public void open() {
        this.setVisible(!this.isVisible());
        this.getParent().doLayout();
    }

}
