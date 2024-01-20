package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.compundComponents.LabelTextFieldCompoundComponent;
import com.intellibucket.pipeql.lib.customAdapters.MouseAdapterForTextField;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.view.client.main.concretes.IntroductionPanelClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.enums.Colors;
import com.intellibucket.pipeql.view.components.enums.CustomBorderProvider;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.File;
import java.util.List;

public class NewProjectDirectoryInfoPanel extends AbstractGSimplePanel {

    private final ExceptionPanel exceptionPanel = new ExceptionPanel();
    private final LabelTextFieldCompoundComponent projectNamePanel = new LabelTextFieldCompoundComponent("Name: ", "untitled");
    private final LabelTextFieldCompoundComponent projectPathDirectoryPanel = new LabelTextFieldCompoundComponent("Project will be created in:", "undifined");
    private final LabelTextFieldCompoundComponent projectPathPanel = new LabelTextFieldCompoundComponent(
            "Path: ",
            UIManager.getIcon("FileView.directoryIcon"));

    private final IntroductionPanelClient introductionPanelClient = new IntroductionPanelClient();


    {
        setLayout(new GridBagLayout());
        configProjectPathDirectoryPanel();
        projectNamePanel.getTextField().setBorder(CustomBorderProvider.BOLD_BORDER.getBorder(
                Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR.getColor()));
        projectPathPanel.getTextField().setBorder(CustomBorderProvider.BOLD_BORDER.getBorder(
                Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR.getColor()));

        addListeners(projectNamePanel.getTextField());
        addListeners(projectPathPanel.getTextField());
    }

    public NewProjectDirectoryInfoPanel() {
        this("undefined");
    }

    public NewProjectDirectoryInfoPanel(String defaultPath) {
        this.projectPathPanel.getTextField().setText(defaultPath);
        setPath();
    }

    public void configProjectPathDirectoryPanel() {
        projectPathDirectoryPanel.setBorder(null);
        projectPathDirectoryPanel.getTextField().setEnabled(false);
        projectPathDirectoryPanel.getTextField().setBackground(this.getBackground());
        projectPathDirectoryPanel.getTextField().setBorder(BorderFactory.createEmptyBorder());
        projectPathDirectoryPanel.getTextField().setForeground(Color.DARK_GRAY);
        projectPathDirectoryPanel.getLabel().setForeground(Color.DARK_GRAY);
        projectPathDirectoryPanel.setBackground(this.getBackground());

    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                exceptionPanel,
                projectNamePanel,
                projectPathPanel,
                projectPathDirectoryPanel
        );
    }

    @Override
    public void addComponents() {

        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH;
        addComponentWithLabel(exceptionPanel,gbc,0,0);
        addComponentWithLabel(projectNamePanel, gbc, 0, 1);
        addComponentWithLabel(projectPathPanel, gbc, 0, 2);
        addComponentWithLabel(projectPathDirectoryPanel, gbc, 1, 3);


    }

    @Override
    public void setActions() {
        projectPathPanel.getTextField().getButton().addActionListener(
                e -> introductionPanelClient.selectDirectory(
                        this, projectPathPanel.getTextField()));
    }

    private String getPath() {
        var projectName = projectNamePanel.getTextField().getText();
        var projectPath = projectPathPanel.getTextField().getText();

        return projectPath.concat(File.separator).concat(projectName);

    }

    private void setPath() {
        checkInvalidFields();
        this.projectPathDirectoryPanel.getTextField().setText(getPath());
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

    private void checkInvalidFields() {
        var valid = introductionPanelClient.checkPath(
                this.projectPathPanel.getTextField().getText(),
                this.projectNamePanel.getTextField().getText());
        if (valid.isPresent())
            this.exceptionPanel.message(valid.get());
        else
            this.exceptionPanel.close();


    }


    private void addComponentWithLabel(Component component, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 2;
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
