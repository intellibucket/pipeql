package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.borders.CustomBorderProvider;
import com.intellibucket.pipeql.lib.compundComponents.LabelTextFieldCompoundComponent;
import com.intellibucket.pipeql.lib.customAdapters.MouseAdapterForTextField;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.view.client.main.concretes.IntroductionPanelClient;
import com.intellibucket.pipeql.view.components.Colors;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.File;
import java.util.List;

public class NewProjectDirectoryInfoPanel extends AbstractGSimplePanel {

    private final LabelTextFieldCompoundComponent projectNamePanel = new LabelTextFieldCompoundComponent("Name: ", "untitled");
    private final LabelTextFieldCompoundComponent projectPathFieldPanel = new LabelTextFieldCompoundComponent(
            "Path: ",
            UIManager.getIcon("FileView.directoryIcon"));

    private final IntroductionPanelClient introductionPanelClient = new IntroductionPanelClient();
    private final AbstractGLabel createdDirectory = new SimpleGLabel();

    {
        setMinimumSize(new Dimension(360, 1));
        setLayout(new GridBagLayout());
        createdDirectory.setForeground(Color.DARK_GRAY);
        projectNamePanel.getTextField().setBorder(CustomBorderProvider.BOLD_BORDER.getBorder(
                Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR.getColor()));
        projectPathFieldPanel.getTextField().setBorder(CustomBorderProvider.BOLD_BORDER.getBorder(
                Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR.getColor()));
        addListeners(projectNamePanel.getTextField());
        addListeners(projectPathFieldPanel.getTextField());
    }

    public NewProjectDirectoryInfoPanel() {
        this("undefined");
    }

    public NewProjectDirectoryInfoPanel(String defaultPath) {
        this.projectPathFieldPanel.getTextField().setText(defaultPath);
        setPath();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                projectNamePanel,
                projectPathFieldPanel,
                createdDirectory
        );
    }

    @Override
    public void addComponents() {
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH;
        addComponentWithLabel(projectNamePanel, gbc, 0, 1, 2);
        addComponentWithLabel(projectPathFieldPanel, gbc, 0, 2, 2);
        addComponentWithLabel(createdDirectory, gbc, 1, 3, 2);
    }

    @Override
    public void setActions() {
        projectPathFieldPanel.getTextField().getButton().addActionListener(
                e -> introductionPanelClient.selectDirectory(
                        this, projectPathFieldPanel.getTextField()));
    }

    private String getPath() {
        var projectName = projectNamePanel.getTextField().getText();
        var projectPath = projectPathFieldPanel.getTextField().getText();

        return projectPath.concat(File.separator).concat(projectName);

    }

    private void setPath() {
        this.createdDirectory.setText("Project will be created in: " + getPath());
    }


    private void addListeners(AbstractGTextField textField) {
        textField.getDocument().addDocumentListener(new ChangePathListener());
        textField.addMouseListener(new MouseAdapterForTextField(textField,
                CustomBorderProvider.BOLD_BORDER.getBorder(
                        Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_ENTERED_COLOR.getColor()),
                CustomBorderProvider.BOLD_BORDER.getBorder(
                        Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR.getColor())
        ));
    }


    private void addComponentWithLabel(Component component, GridBagConstraints gbc, int x, int y, int gridWidth) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gridWidth;
        add(component, gbc);
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
