package com.intellibucket.pipeql.view.components.databases.panel;

import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.lib.tabbed.AbstractMaximizedGTabbedPane;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.databases.panel.tabbedpane.SettingsLeftTabbedPane;

import java.awt.*;
import java.util.List;

public class LeftSideDatabasesPanel extends SimpleSideGPanel {

    private final AbstractMaximizedGTabbedPane settingsLeftTabbedPane = new SettingsLeftTabbedPane();

    {
        setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.settingsLeftTabbedPane
        );
    }

    @Override
    public void addComponents() {
        add(settingsLeftTabbedPane, BorderLayout.CENTER);
    }
}
