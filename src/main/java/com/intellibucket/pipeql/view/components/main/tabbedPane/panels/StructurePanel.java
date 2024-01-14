package com.intellibucket.pipeql.view.components.main.tabbedPane.panels;

import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.util.List;

public class StructurePanel extends AbstractGSimplePanel {
    public StructurePanel() {
        super("Structure");
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {
    }
}
