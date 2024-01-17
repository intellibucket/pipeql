package com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class StructurePanel extends AbstractGSimplePanel {

    private AbstractGSimplePanel headerStructurePanel = new HeaderStructurePanel();
    private AbstractGSimplePanel leftSideStructurePanel = new LeftSideStructurePanel();
    private AbstractGSimplePanel rightSideStructurePanel = new RightSideStructurePanel();
    private AbstractGSimplePanel bottomStructurePanel = new BottomStructurePanel();

    {
        this.setLayout(new BorderLayout());
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.headerStructurePanel,
                this.leftSideStructurePanel,
                this.rightSideStructurePanel,
                this.bottomStructurePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.headerStructurePanel, BorderLayout.NORTH);
        this.add(this.leftSideStructurePanel, BorderLayout.WEST);
        this.add(this.rightSideStructurePanel, BorderLayout.EAST);
        this.add(this.bottomStructurePanel, BorderLayout.SOUTH);
    }
}
