package com.intellibucket.pipeql.view.components.databases.panel.tabbedpane.panels;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DataSourcesSettingsTabbedPanePanel extends AbstractGSimplePanel {
    private final HeaderDataSourcesSettingsTabbedPanePanel headerDataSourcesSettingsTabbedPanePanel;

    {
        this.setBackground(new Color(62,67,76));
        this.setLayout(new BorderLayout());
    }

    public DataSourcesSettingsTabbedPanePanel() {
        this.headerDataSourcesSettingsTabbedPanePanel = new HeaderDataSourcesSettingsTabbedPanePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.headerDataSourcesSettingsTabbedPanePanel);
    }

    @Override
    public void addComponents() {
        this.add(this.headerDataSourcesSettingsTabbedPanePanel, BorderLayout.NORTH);
    }
}


class HeaderDataSourcesSettingsTabbedPanePanel extends AbstractGSimplePanel {

    private final HeaderLeftDataSourcesSettingsTabbedPanePanel headerLeftDataSourcesSettingsTabbedPanePanel = new HeaderLeftDataSourcesSettingsTabbedPanePanel();
    private final HeaderRightDataSourcesSettingsTabbedPanePanel headerRightDataSourcesSettingsTabbedPanePanel = new HeaderRightDataSourcesSettingsTabbedPanePanel();

    {
        this.setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                headerLeftDataSourcesSettingsTabbedPanePanel,
                headerRightDataSourcesSettingsTabbedPanePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.headerLeftDataSourcesSettingsTabbedPanePanel, BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(50,0)), BorderLayout.CENTER);
        this.add(this.headerRightDataSourcesSettingsTabbedPanePanel, BorderLayout.EAST);
    }


}

class HeaderLeftDataSourcesSettingsTabbedPanePanel extends  AbstractGSimplePanel {
    private final AbstractGButton addButton = new SimpleIconGButton("addBlankLine");
    private final AbstractGButton deleteButton = new SimpleIconGButton("remove");
    private final AbstractGButton duplicateButton = new SimpleIconGButton("duplicate");
    private final AbstractGButton goToDriverButton = new SimpleIconGButton("settings");
    private final AbstractGButton makeGlobal = new SimpleIconGButton("rspecSharedGroupRef");

    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.addButton,
                this.deleteButton,
                this.duplicateButton,
                this.goToDriverButton,
                this.makeGlobal
        );
    }

    @Override
    public void addComponents() {
        this.add(this.addButton);
        this.add(this.deleteButton);
        this.add(this.duplicateButton);
        this.add(this.goToDriverButton);
        this.add(this.makeGlobal);
    }

    @Override
    public void setActions() {
        //must be implemented
    }
}


class HeaderRightDataSourcesSettingsTabbedPanePanel extends  AbstractGSimplePanel {
    private final AbstractGButton undoButton = new SimpleIconGButton("undo");
    private final AbstractGButton redoButton = new SimpleIconGButton("redo");
    {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.undoButton,
                this.redoButton
        );
    }

    @Override
    public void addComponents() {
        this.add(this.undoButton);
        this.add(this.redoButton);
    }

    @Override
    public void setActions() {
        //must be implemented
    }
}


