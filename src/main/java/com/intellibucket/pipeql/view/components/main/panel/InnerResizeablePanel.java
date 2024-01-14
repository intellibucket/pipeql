package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.lib.panel.main.AbstractInnerResizeablePanel;

import java.awt.*;

public abstract class InnerResizeablePanel extends AbstractInnerResizeablePanel {

    public void open() {
        this.setVisible(!this.isVisible());
        this.getParent().doLayout();
    }

}
