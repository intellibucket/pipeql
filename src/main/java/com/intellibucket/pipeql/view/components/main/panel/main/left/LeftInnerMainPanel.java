package com.intellibucket.pipeql.view.components.main.panel.main.left;

import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.line.LinePanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;

import java.awt.*;
import java.util.List;

public class LeftInnerMainPanel extends InnerResizeablePanel {

    private final LinePanel header = new HeaderOfLeftInnerMainPanel();

    private final AbstractGSimplePanel fileTreePanel = new FileTreePanel();


    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.header,
                this.fileTreePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.header,BorderLayout.NORTH);
        this.add(this.fileTreePanel,BorderLayout.CENTER);
    }
}
