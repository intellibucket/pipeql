package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class NewProjectLeftSidePanel extends ChangeablePanel {
    private final NewProjectLeftUpSideSearchPanel newProjectLeftUpSideSearchPanel = new NewProjectLeftUpSideSearchPanel();
    private final NewProjectLeftDownPanel newProjectLeftDownPanel = new NewProjectLeftDownPanel();

    {
       // this.newProjectLeftUpSideSearchPanel.setBorder(CustomBorderProvider.ONE_LINE_BORDER.getBorder(Color.BLACK));
      //  this.newProjectLeftDownPanel.setBorder(CustomBorderProvider.ONE_LINE_BORDER.getBorder(Color.BLACK));
        setMinimumSize(new Dimension(150, 1));
        this.setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.newProjectLeftUpSideSearchPanel, this.newProjectLeftDownPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.newProjectLeftUpSideSearchPanel, BorderLayout.NORTH);
        this.add(this.newProjectLeftDownPanel, BorderLayout.CENTER);
    }
}
