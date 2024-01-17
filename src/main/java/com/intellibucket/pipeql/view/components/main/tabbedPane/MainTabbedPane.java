package com.intellibucket.pipeql.view.components.main.tabbedPane;

import com.intellibucket.pipeql.lib.tabbed.AbstractMaximizedGTabbedPane;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.tabbedPane.panels.DrawSimplePanel;
import com.intellibucket.pipeql.view.components.main.tabbedPane.panels.EnvironmentPanel;
import com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure.StructurePanel;

import java.util.List;

public class MainTabbedPane extends AbstractMaximizedGTabbedPane {


    private final DrawSimplePanel drawSimplePanel = new DrawSimplePanel();
    private final EnvironmentPanel environmentPanel = new EnvironmentPanel();
    private final StructurePanel structurePanel = new StructurePanel();

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.drawSimplePanel, this.structurePanel, this.environmentPanel);
    }

    @Override
    public void addComponents() {
        this.add("Draw", drawSimplePanel);
        this.add("Structure", structurePanel);
        this.add("Environment", environmentPanel);
    }

    @Override
    public void postInitialize() {
        this.setSelectedIndex(1);
    }
}
