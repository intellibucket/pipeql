package com.intellibucket.pipeql.view.components.intro.screens;

import com.intellibucket.pipeql.lib.panel.MidGFrame;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.intro.panel.LeftSideIntroductionPanel;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.LeftSideNewProjectPanel;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.NewProjectCenterPanel;

import java.awt.*;
import java.util.List;

public class NewProjectScreen extends MidGFrame {
    private final LeftSideNewProjectPanel leftSideIntroductionPanel = new LeftSideNewProjectPanel();
    private final NewProjectCenterPanel newProjectCenterPanel = new NewProjectCenterPanel();
    {
        leftSideIntroductionPanel.setBackground(Color.BLUE);
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.leftSideIntroductionPanel, this.newProjectCenterPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.leftSideIntroductionPanel, BorderLayout.WEST);
        this.add(this.newProjectCenterPanel, BorderLayout.CENTER);
    }
}
