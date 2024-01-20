package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class NewProjectCenterPanel extends ChangeablePanel {
    private final NewProjectDirectoryInfoPanel newProjectDirectoryInfoPanel = new NewProjectDirectoryInfoPanel();
    private final NewProjectButtonPanel newProjectButtonPanel = new NewProjectButtonPanel();

    {
        setMinimumSize(new Dimension(430,1));
        setLayout(new GridBagLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(newProjectDirectoryInfoPanel, newProjectButtonPanel);
    }

    @Override
    public void addComponents() {

        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 150, 10);
        add(newProjectDirectoryInfoPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.insets = new Insets(150, 10, 0, 0);
        add(newProjectButtonPanel, gbc);
    }
}
