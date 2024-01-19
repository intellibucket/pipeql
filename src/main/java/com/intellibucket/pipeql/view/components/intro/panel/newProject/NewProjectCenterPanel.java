package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.SimpleGTextField;
import com.intellibucket.pipeql.view.client.main.concretes.IntroductionPanelClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NewProjectCenterPanel extends ChangeablePanel {
    private final AbstractGLabel projectNameLabel = new SimpleGLabel("Name:");
    private final AbstractGTextField projectNameTextField = new SimpleGTextField();
    private final AbstractGLabel projectPathLabel = new SimpleGLabel("Path");
    private final SimpleGButton selectDirectoryButton = new SimpleGButton("", UIManager.getIcon("FileView.directoryIcon"));

    private final AbstractGTextField projectPathTextField = new SimpleGTextField();
    private final IntroductionPanelClient introductionPanelClient = new IntroductionPanelClient();


    {
        setLayout(new FlowLayout());
        projectPathTextField.setColumns(20);
        projectNameTextField.setColumns(20);
        selectDirectoryButton.setFocusPainted(false);
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectNameLabel,
                this.projectNameTextField,
                this.projectPathLabel,
                this.projectPathTextField,
                this.selectDirectoryButton
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectNameLabel);
        this.add(this.projectNameTextField);
        this.add(this.projectPathLabel);
        this.add(this.projectPathTextField);
        this.add(this.selectDirectoryButton);
    }

    @Override
    public void setActions() {

        this.selectDirectoryButton.addActionListener(e -> {
            this.introductionPanelClient.selectDirectory(this, projectPathTextField);
        });
    }


}
