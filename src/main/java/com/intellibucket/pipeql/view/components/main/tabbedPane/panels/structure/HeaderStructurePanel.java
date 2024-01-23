package com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.label.SimpleValueLabelPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.model.ProjectModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HeaderStructurePanel extends AbstractGSimplePanel {

    private final AbstractGPanel projectNamePanel;
    private final AbstractGPanel importPanel;
    private final AbstractGPanel syncPanel;

    {
        this.setLayout(new GridLayout(1, 2));
    }

    public HeaderStructurePanel(ProjectModel projectModel) {
        this.projectNamePanel = new InfoBoxPanel(projectModel);
        this.importPanel = new ImportBoxPanel(projectModel);
        this.syncPanel = new SyncBoxPanel(projectModel);
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectNamePanel,
                this.importPanel,
                this.syncPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectNamePanel);
        this.add(this.importPanel);
        this.add(this.syncPanel);
    }

}

class InfoBoxPanel extends AbstractGPanel{

    private AbstractGPanel projectNameLabel;
    private AbstractGPanel createdDateLabel;
    private AbstractGPanel modifiedDateLabel;
    private AbstractGPanel versionLabel;
    private AbstractGPanel createdByLabel;


    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public InfoBoxPanel(ProjectModel projectModel) {
         this.projectNameLabel = new SimpleValueLabelPanel("Project Name", projectModel.getNameOfProject());
         this.createdDateLabel = new SimpleValueLabelPanel("Created Date", projectModel.getCreatedDate().format(DateTimeFormatter.ISO_DATE));
         this.modifiedDateLabel = new SimpleValueLabelPanel("Modified Date", projectModel.getLastModifiedDate().format(DateTimeFormatter.ISO_DATE));
         this.versionLabel = new SimpleValueLabelPanel("Version", projectModel.getVersion());
         this.createdByLabel = new SimpleValueLabelPanel("Created By", projectModel.getCreatedBy());
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectNameLabel,
                this.createdDateLabel,
                this.modifiedDateLabel,
                this.versionLabel,
                this.createdByLabel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectNameLabel);
        this.projectNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, 5)));

        this.add(this.createdDateLabel);
        this.createdDateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, 5)));

        this.add(this.modifiedDateLabel);
        this.modifiedDateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, 5)));

        this.add(this.versionLabel);
        this.versionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, 5)));

        this.add(this.createdByLabel);
        this.createdByLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
    }
}

class ImportBoxPanel extends AbstractGPanel{

    private AbstractGPanel projectNameLabel;


    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public ImportBoxPanel(ProjectModel projectModel) {
        this.projectNameLabel = new SimpleValueLabelPanel("Dataset Import", "____");
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectNameLabel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectNameLabel);
    }
}

class SyncBoxPanel extends AbstractGPanel{

    private AbstractGPanel projectNameLabel;


    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public SyncBoxPanel(ProjectModel projectModel) {
        this.projectNameLabel = new SimpleValueLabelPanel("Synchronization", "____");
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectNameLabel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectNameLabel);
    }
}