package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.view.components.ActionInitializer;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGPanel extends JPanel implements ComponentInitializer, ActionInitializer {

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

    @Override
    public void postInitialize() {
        this.setActions();
    }

    @Override
    public void refresh() {
        this.removeAll();
        this.addComponents();
        this.revalidate();
        this.repaint();
        this.updateUI();
    }
}
