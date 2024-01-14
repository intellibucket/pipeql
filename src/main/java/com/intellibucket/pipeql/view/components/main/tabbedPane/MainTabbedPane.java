package com.intellibucket.pipeql.view.components.main.tabbedPane;

import com.intellibucket.pipeql.lib.frame.abstracts.MaximizedGFrame;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.lib.tabbed.AbstractMaximizedGTabbedPane;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.tabbedPane.panels.DrawSimplePanel;
import com.intellibucket.pipeql.view.components.main.tabbedPane.panels.EnvironmentPanel;
import com.intellibucket.pipeql.view.components.main.tabbedPane.panels.StructurePanel;

import javax.swing.*;
import java.awt.*;
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
        this.add("Draw",drawSimplePanel);
        this.add("Structure",structurePanel);
        this.add("Environment",environmentPanel);


    }
}
