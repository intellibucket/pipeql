package com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.model.ProjectModel;
import com.intellibucket.pipeql.view.util.BordersUtil;

import java.awt.*;
import java.util.List;

public class StructurePanel extends AbstractGSimplePanel {

    private AbstractGSimplePanel headerStructurePanel;
    private AbstractGSimplePanel leftSideStructurePanel;
    private AbstractGSimplePanel rightSideStructurePanel;
    private AbstractGSimplePanel bottomStructurePanel;

    private AbstractGSimplePanel centerStructurePanel;

    {
        this.setLayout(new BorderLayout());
        this.setBorder(BordersUtil.EMPTY_BORDER_5_5_5_5);
    }

    public StructurePanel(ProjectModel projectModel) {
        this.headerStructurePanel = new HeaderStructurePanel(projectModel);
        this.leftSideStructurePanel = new LeftSideStructurePanel(projectModel);
        this.rightSideStructurePanel = new RightSideStructurePanel(projectModel);
        this.bottomStructurePanel = new BottomStructurePanel(projectModel);
        this.centerStructurePanel = new EmptyCenterStructurePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.headerStructurePanel,
                this.leftSideStructurePanel,
                this.rightSideStructurePanel,
                this.bottomStructurePanel,
                this.centerStructurePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.headerStructurePanel, BorderLayout.NORTH);
        this.add(this.leftSideStructurePanel, BorderLayout.WEST);
        this.add(this.rightSideStructurePanel, BorderLayout.EAST);
        this.add(this.bottomStructurePanel, BorderLayout.SOUTH);
        this.add(this.centerStructurePanel, BorderLayout.CENTER);
    }
}
