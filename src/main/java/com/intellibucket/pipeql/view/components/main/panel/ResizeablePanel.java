package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.lib.panel.main.AbstractResizeablePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class ResizeablePanel extends AbstractResizeablePanel {

    public ResizeablePanel() {
        super(new InnerResizeablePanel(), new InnerResizeablePanel(), new InnerResizeablePanel());
        this.getLeftPanel().setBackground(Color.BLUE);
        this.getCenterPanel().setBackground(Color.GREEN);
        this.getRightPanel().setBackground(Color.RED);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.getLeftPanel(),
                this.getCenterPanel(),
                this.getRightPanel()
        );
    }

    @Override
    public void addComponents() {
        this.add(this.getCenterRightSplitPanel(), BorderLayout.CENTER);
    }
}
