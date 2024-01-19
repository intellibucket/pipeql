package com.intellibucket.pipeql.view.components.intro.screens;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.MidGFrame;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.LeftSideNewProjectPanel;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.NewProjectCenterPanel;

import javax.swing.*;
import java.util.List;

public class NewProjectScreen extends MidGFrame {
    private final LeftSideNewProjectPanel leftSideIntroductionPanel = new LeftSideNewProjectPanel();
    private final NewProjectCenterPanel newProjectCenterPanel = new NewProjectCenterPanel();
    private final JSplitPane splitPane;


    public NewProjectScreen(AbstractGPanel abstractGPanel) {
        this.setLocationRelativeTo(abstractGPanel);
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSideIntroductionPanel, newProjectCenterPanel);
        splitPane.setResizeWeight(0.1);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.leftSideIntroductionPanel, this.newProjectCenterPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.splitPane);
    }
}
