package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.button.custom.BeautifulButton;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class NewProjectCreateAndCancelButtonPanel extends AbstractGSimplePanel {
    private final BeautifulButton createButton;
    private final BeautifulButton cancelButton;

    {
        setLayout(new GridBagLayout());
        var backgroundColor = new Color(11, 148, 217);
        var mouseEnteredColor = new Color(13, 119, 227);
        this.createButton = new BeautifulButton("Create", Color.WHITE, backgroundColor, mouseEnteredColor);
        this.cancelButton = new BeautifulButton("Cancel", Color.WHITE, backgroundColor, mouseEnteredColor);
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 20); // Adjust the right inset to add space between buttons
        add(createButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 20, 0, 0); // Adjust the left inset to add space between buttons
        add(cancelButton, gbc);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(createButton, cancelButton);
    }

    @Override
    public void addComponents() {
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        add(createButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(cancelButton, gbc);

    }
}
