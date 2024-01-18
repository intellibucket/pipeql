package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class LeftSideNewProjectPanel  extends ChangeablePanel {
    private LeftUpSideSearchPanel leftUpSideSearchPanel = new LeftUpSideSearchPanel();
    private LeftDownNewProjectPanel leftDownNewProjectPanel = new LeftDownNewProjectPanel();

    {
setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.leftUpSideSearchPanel, this.leftDownNewProjectPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.leftUpSideSearchPanel, BorderLayout.SOUTH);
        this.add(this.leftDownNewProjectPanel, BorderLayout.CENTER);
    }
}
