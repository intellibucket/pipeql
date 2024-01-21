package com.intellibucket.pipeql.lib.list;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class GPanelList extends AbstractGPanel implements ComponentInitializer {

    private List<ComponentInitializer> components;
    public GPanelList(List<ComponentInitializer> components) {
        super();
        this.components = components == null ? List.of() : components;
        this.setLayout(new GridLayout(20, 1));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return components;
    }

    @Override
    public void addComponents() {
        for (ComponentInitializer component : components) {
            this.add((Component) component);
        }
    }
}
