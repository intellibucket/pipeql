package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.eventlink.rx.concretes.EmptyCallback;
import com.intellibucket.pipeql.lib.button.vertical.AbstractVerticalGButton;
import com.intellibucket.pipeql.lib.button.vertical.SimpleVerticalGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.panel.side.InnerSideGPanel;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractLeftSidePanelClient;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import lombok.extern.slf4j.Slf4j;

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
    public void setComponents() {
        this.add(this.topLeftSideInnerPanel, BorderLayout.NORTH);
        this.add(this.bottomLeftSideInnerPanel, BorderLayout.SOUTH);
    }

}

@Slf4j
class TopLeftSideInnerPanel extends InnerSideGPanel {


    private final AbstractLeftSidePanelClient leftSidePanelClient = AbstractLeftSidePanelClient.INSTANCE;

    private final AbstractVerticalGButton projectsButton;
    private final AbstractVerticalGButton environmentButton;
    private final AbstractVerticalGButton schemasButton;

    TopLeftSideInnerPanel() {
        this.projectsButton = new SimpleVerticalGButton("", ImageToolKit.getIcon("projectStructure"));
        this.environmentButton = new SimpleVerticalGButton("", ImageToolKit.getIcon("value"));
        this.schemasButton = new SimpleVerticalGButton("", ImageToolKit.getIcon("json"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.projectsButton, this.environmentButton, this.schemasButton);
    }

    @Override
    public void setComponents() {
        this.add(this.projectsButton);
        this.add(this.environmentButton);
        this.add(this.schemasButton);
    }

    @Override
    public void setEventPublisher() {
        this.projectsButton.addActionListener(e -> {
            this.leftSidePanelClient.openProjectsLeftBarScreen(EmptyCallback.INSTANCE);
        });
    }
}

class BottomLeftSideInnerPanel extends InnerSideGPanel {

    private final AbstractLeftSidePanelClient leftSidePanelClient = AbstractLeftSidePanelClient.INSTANCE;

    private final AbstractVerticalGButton dataSourcesButton;

    BottomLeftSideInnerPanel() {
        this.dataSourcesButton = new SimpleVerticalGButton("", ImageToolKit.getIcon("sql"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.dataSourcesButton);
    }

    @Override
    public void setComponents() {
        this.add(this.dataSourcesButton);
    }

    @Override
    public void setEventPublisher() {
        this.dataSourcesButton.addActionListener(e -> {
            this.leftSidePanelClient.openDatabasesScreen(EmptyCallback.INSTANCE);
        });
    }
}