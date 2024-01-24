package com.intellibucket.pipeql.view.components.databases.panel.tabbedpane;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.tabbed.AbstractMaximizedGTabbedPane;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.databases.panel.tabbedpane.panels.DDLMappingsSettingsTabbedPanePanel;
import com.intellibucket.pipeql.view.components.databases.panel.tabbedpane.panels.DataSourcesSettingsTabbedPanePanel;
import com.intellibucket.pipeql.view.components.databases.panel.tabbedpane.panels.DriversSettingsTabbedPanePanel;

import java.awt.*;
import java.util.List;

public class SettingsLeftTabbedPane extends AbstractMaximizedGTabbedPane {
    private final AbstractGPanel dataSourcesPanel = new DataSourcesSettingsTabbedPanePanel();
    private final AbstractGPanel driversPanel = new DriversSettingsTabbedPanePanel();

    private final AbstractGPanel ddlMappingsPanel = new DDLMappingsSettingsTabbedPanePanel();

    {
        this.setMinimumSize(new Dimension(200,this.getPreferredSize().height));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.dataSourcesPanel,
                this.driversPanel,
                this.ddlMappingsPanel
        );
    }

    @Override
    public void setComponents() {
        this.add("Data Sources", this.dataSourcesPanel);
        this.add("Drivers", this.driversPanel);
        this.add("DDL Mappings", this.ddlMappingsPanel);
    }
}
