package com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.label.SimpleValueLabelPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HeaderStructurePanel extends AbstractGSimplePanel {

    private final AbstractGPanel projectNamePanel= new InfoBoxPanel();
    private final AbstractGPanel importPanel = new ImportBoxPanel();

    private final AbstractGPanel syncPanel = new SyncBoxPanel();

    {
        this.setLayout(new GridLayout(1, 2));
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


    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public InfoBoxPanel() {
         this.projectNameLabel = new SimpleValueLabelPanel("Project Name", "UNKNOWN");
         this.createdDateLabel = new SimpleValueLabelPanel("Created Date", LocalDateTime.now().toString());
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectNameLabel
                ,this.createdDateLabel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectNameLabel);
        this.projectNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(this.createdDateLabel);
        this.createdDateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}

class ImportBoxPanel extends AbstractGPanel{

    private AbstractGPanel projectNameLabel;


    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public ImportBoxPanel() {
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

    public SyncBoxPanel() {
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