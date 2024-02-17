package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.label.SimpleValueLabelPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.domain.model.dto.response.project.ProjectModel;
import com.intellibucket.pipeql.view.util.JSeperatorUtils;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HeaderStructurePanel extends AbstractGSimplePanel {


    {
        this.setLayout(new BorderLayout());
    }

    private final AbstractGSimplePanel mainHeaderPanel;

    public HeaderStructurePanel(ProjectModel projectModel) {
        this.mainHeaderPanel = new MainOfHeaderStructurePanel(projectModel);
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainHeaderPanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.mainHeaderPanel, BorderLayout.CENTER);
        this.add(JSeperatorUtils.getHorizontalSeparator(), BorderLayout.SOUTH);
    }

}

class MainOfHeaderStructurePanel extends  AbstractGSimplePanel {

    private final AbstractGPanel projectNamePanel;
    private final AbstractGPanel importPanel;
    private final AbstractGPanel syncPanel;

    {
        this.setLayout(new GridLayout(1, 3));
    }

    public MainOfHeaderStructurePanel(ProjectModel projectModel) {
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
    public void setComponents() {
        this.add(this.projectNamePanel);
        this.add(this.importPanel);
        this.add(this.syncPanel);
    }

}
class InfoBoxPanel extends AbstractGPanel{

    private LeftOfInfoBoxPanel leftOfInfoBoxPanel;
    private RightOfInfoBoxPanel rightOfInfoBoxPanel;


    {
        this.setLayout(new BorderLayout());
    }

    public InfoBoxPanel(ProjectModel projectModel) {
        this.leftOfInfoBoxPanel = new LeftOfInfoBoxPanel(projectModel);
        this.rightOfInfoBoxPanel = new RightOfInfoBoxPanel(projectModel);
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.leftOfInfoBoxPanel,
                this.rightOfInfoBoxPanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.leftOfInfoBoxPanel, BorderLayout.WEST);
        this.add(this.rightOfInfoBoxPanel, BorderLayout.EAST);
    }

    class LeftOfInfoBoxPanel extends AbstractGPanel{

        private final AbstractGPanel projectNameLabel;
        private final AbstractGPanel createdDateLabel;

        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        public LeftOfInfoBoxPanel(ProjectModel projectModel) {
            this.projectNameLabel = new SimpleValueLabelPanel("Project Name", projectModel.getNameOfProject());
            this.createdDateLabel = new SimpleValueLabelPanel("Created Date", projectModel.getCreatedDate().format(DateTimeFormatter.ISO_DATE));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.projectNameLabel,
                    this.createdDateLabel);
        }

        @Override
        public void setComponents() {
            this.add(this.projectNameLabel);
            this.projectNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(Box.createRigidArea(new Dimension(0, 5)));

            this.add(this.createdDateLabel);
            this.createdDateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    class RightOfInfoBoxPanel extends AbstractGPanel{

        private AbstractGPanel versionLabel;
        private AbstractGPanel createdByLabel;

        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        public RightOfInfoBoxPanel(ProjectModel projectModel) {
            this.versionLabel = new SimpleValueLabelPanel("Version", projectModel.getVersion());
            this.createdByLabel = new SimpleValueLabelPanel("Owner", projectModel.getCreatedBy());
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.versionLabel,
                    this.createdByLabel);
        }

        @Override
        public void setComponents() {
            this.add(this.versionLabel);
            this.versionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(Box.createRigidArea(new Dimension(0, 5)));

            this.add(this.createdByLabel);
            this.createdByLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(Box.createRigidArea(new Dimension(0, 5)));
        }
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
    public void setComponents() {
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
    public void setComponents() {
        this.add(this.projectNameLabel);
    }
}