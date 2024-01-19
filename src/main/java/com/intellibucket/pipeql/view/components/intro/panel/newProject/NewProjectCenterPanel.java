package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.mixComponents.LabelTextField;
import com.intellibucket.pipeql.lib.mixComponents.LabelTextFieldButton;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.view.client.main.concretes.IntroductionPanelClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.File;
import java.util.List;

public class NewProjectCenterPanel extends ChangeablePanel {

    private final LabelTextField projectNamePanel = new LabelTextField("Name: ", "untitled");
    private final LabelTextFieldButton projectPathFieldPanel = new LabelTextFieldButton(
            "Path: ",
            UIManager.getIcon("FileView.directoryIcon"));

    private final AbstractGLabel projectNameValidationLabel = new SimpleGLabel();
    private final AbstractGLabel projectPathValidationLabel = new SimpleGLabel();

    private final IntroductionPanelClient introductionPanelClient = new IntroductionPanelClient();
    private final AbstractGLabel createdDirectory = new SimpleGLabel();

    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        createdDirectory.setVisible(true);
        projectPathFieldPanel.getButton().setFocusPainted(false);


        projectNameValidationLabel.setForeground(Color.RED);
        projectPathValidationLabel.setForeground(Color.RED);

    }

    public NewProjectCenterPanel( ) {
        this("undefined");
    }

    public NewProjectCenterPanel(String defaultPath) {
        this.projectPathFieldPanel.getTextField().setText(defaultPath);
        setPath();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectNameValidationLabel,
                this.projectPathValidationLabel,
                this.projectNamePanel,
                this.projectPathFieldPanel,
                this.createdDirectory
        );
    }

    @Override
    public void addComponents() {
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(projectNameValidationLabel);
        this.add(projectPathValidationLabel);
        this.add(this.projectNamePanel);
        this.add(this.projectPathFieldPanel);
        this.add(this.createdDirectory);
    }

    @Override
    public void setActions() {
        var listener = new ChangePathListener();
        this.projectNamePanel.getTextField().getDocument().addDocumentListener(listener);
        this.projectPathFieldPanel.getTextField().getDocument().addDocumentListener(listener);
        this.projectPathFieldPanel.getButton().addActionListener(
                e -> this.introductionPanelClient.selectDirectory(this, this.projectPathFieldPanel.getTextField()));
    }

    void setPath() {
        var projectName = NewProjectCenterPanel.this.projectNamePanel.getTextField().getText();
        var projectPath = NewProjectCenterPanel.this.projectPathFieldPanel.getTextField().getText();

        if (projectName.isEmpty()) {
            projectNameValidationLabel.setText("Name cannot be empty");
        } else {
            projectNameValidationLabel.setText("");
        }

        if (projectPath.isEmpty()) {
            projectPathValidationLabel.setText("Path cannot be empty");
        } else {
            projectPathValidationLabel.setText("");
        }

        var projectDirectory = projectPath.concat(File.separator).concat(projectName);
        createdDirectory.setText("Project will be created in: " + projectDirectory);
        createdDirectory.initialize();
    }

    class ChangePathListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            setPath();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            setPath();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            setPath();
        }
    }
}
