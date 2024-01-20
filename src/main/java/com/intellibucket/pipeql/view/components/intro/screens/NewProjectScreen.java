package com.intellibucket.pipeql.view.components.intro.screens;

import com.intellibucket.pipeql.view.components.enums.CustomBorderProvider;
import com.intellibucket.pipeql.splitPane.CustomSplitPane;
import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.SmallGFrame;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.NewProjectLeftSidePanel;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.NewProjectCenterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NewProjectScreen extends SmallGFrame {
    private final NewProjectLeftSidePanel leftSideIntroductionPanel = new NewProjectLeftSidePanel();
    private final NewProjectCenterPanel newProjectCenterPanel = new NewProjectCenterPanel();
    private final JSplitPane splitPane;

    {
        this.setIconImage(IconProvider.getLogo().getImage());
        this.setTitle("New Project");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    public NewProjectScreen(AbstractGPanel abstractGPanel) {
        this.setLocationRelativeTo(abstractGPanel);
        this.splitPane = new CustomSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                leftSideIntroductionPanel,
                newProjectCenterPanel,
                CustomBorderProvider.ONE_LINE_RIGHT_BORDER.getBorder(Color.BLACK));
        splitPane.setResizeWeight(0.25);



    }



    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.leftSideIntroductionPanel, this.newProjectCenterPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.splitPane, BorderLayout.CENTER);
    }
}
