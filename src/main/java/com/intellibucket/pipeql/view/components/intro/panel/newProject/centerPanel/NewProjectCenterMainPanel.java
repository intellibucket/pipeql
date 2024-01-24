package com.intellibucket.pipeql.view.components.intro.panel.newProject.centerPanel;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class NewProjectCenterMainPanel extends ChangeablePanel {
    private final NewProjectCenterUpDirectoryInfoPanel newProjectCenterUpDirectoryInfoPanel = new NewProjectCenterUpDirectoryInfoPanel();
    private final NewProjectCenterDownRightPanel newProjectCenterDownRightPanel = new NewProjectCenterDownRightPanel();
    private final static ImageIcon BACKGROUND_IMAGE = new ImageIcon("pngs" + File.separator + "newProjectFileDirectoryBacground.png");

    {
        setOpaque(false);
        setMinimumSize(new Dimension(430, 1));
        setLayout(new GridBagLayout());

    }

    public NewProjectCenterMainPanel() {

    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(newProjectCenterUpDirectoryInfoPanel, newProjectCenterDownRightPanel);
    }

    @Override
    public void setComponents() {

        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 150, 10);
        add(newProjectCenterUpDirectoryInfoPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.insets = new Insets(150, 10, 0, 0);
        add(newProjectCenterDownRightPanel, gbc);
    }
}
