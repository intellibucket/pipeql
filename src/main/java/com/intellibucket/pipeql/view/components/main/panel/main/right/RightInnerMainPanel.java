package com.intellibucket.pipeql.view.components.main.panel.main.right;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;

import java.awt.*;
import java.util.List;

public class RightInnerMainPanel extends InnerResizeablePanel {

    private final ChangeablePanel panel;

    public RightInnerMainPanel() {
        this.panel = new EmptyChangeableSideBarPanel();
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                panel
        );
    }

    @Override
    public void setComponents() {
        add(panel, BorderLayout.CENTER);
    }
}
