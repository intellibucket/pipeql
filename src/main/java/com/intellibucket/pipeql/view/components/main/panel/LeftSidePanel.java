package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.lib.button.vertical.AbstractVerticalGButton;
import com.intellibucket.pipeql.lib.button.vertical.SimpleVerticalGButton;
import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.lib.panel.side.InnerSideGPanel;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class LeftSidePanel extends SimpleSideGPanel {

    private final InnerSideGPanel topLeftSideInnerPanel;

    private final InnerSideGPanel bottomLeftSideInnerPanel;

    public LeftSidePanel() {
        this.topLeftSideInnerPanel = new TopLeftSideInnerPanel();
        this.bottomLeftSideInnerPanel = new BottomLeftSideInnerPanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.topLeftSideInnerPanel, this.bottomLeftSideInnerPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.topLeftSideInnerPanel, BorderLayout.NORTH);
        this.add(this.bottomLeftSideInnerPanel, BorderLayout.SOUTH);
    }

}

class TopLeftSideInnerPanel extends InnerSideGPanel{

    private final AbstractVerticalGButton projectsButton;
    private final AbstractVerticalGButton environmentButton;
    private final AbstractVerticalGButton schemasButton;

    TopLeftSideInnerPanel() {
        this.projectsButton = new SimpleVerticalGButton("", IconProvider.getIcon("projectStructure"));
        this.environmentButton = new SimpleVerticalGButton("", IconProvider.getIcon("value"));
        this.schemasButton = new SimpleVerticalGButton("", IconProvider.getIcon("json"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.projectsButton,this.environmentButton,this.schemasButton);
    }

    @Override
    public void addComponents() {
        this.add(this.projectsButton);
        this.add(this.environmentButton);
        this.add(this.schemasButton);
    }
}

class BottomLeftSideInnerPanel extends InnerSideGPanel{

    private final AbstractVerticalGButton dataSourcesButton;

    BottomLeftSideInnerPanel() {
        this.dataSourcesButton = new SimpleVerticalGButton("", IconProvider.getIcon("sql"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.dataSourcesButton);
    }

    @Override
    public void addComponents() {
        this.add(this.dataSourcesButton);
    }
}