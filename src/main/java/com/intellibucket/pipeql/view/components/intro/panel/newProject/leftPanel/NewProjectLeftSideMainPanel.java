package com.intellibucket.pipeql.view.components.intro.panel.newProject.leftPanel;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class NewProjectLeftSideMainPanel extends ChangeablePanel {
    private final NewProjectLeftUpSearchPanel newProjectLeftUpSearchPanel = new NewProjectLeftUpSearchPanel();
    private final NewProjectLeftDownPanel newProjectLeftDownPanel = new NewProjectLeftDownPanel();

    {
       // this.newProjectLeftUpSideSearchPanel.setBorder(CustomBorderProvider.ONE_LINE_BORDER.getBorder(Color.BLACK));
      //  this.newProjectLeftDownPanel.setBorder(CustomBorderProvider.ONE_LINE_BORDER.getBorder(Color.BLACK));
        setMinimumSize(new Dimension(150, 1));
        this.setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.newProjectLeftUpSearchPanel, this.newProjectLeftDownPanel);
    }

    @Override
    public void setComponents() {
        this.add(this.newProjectLeftUpSearchPanel, BorderLayout.NORTH);
        this.add(this.newProjectLeftDownPanel, BorderLayout.CENTER);
    }
}
