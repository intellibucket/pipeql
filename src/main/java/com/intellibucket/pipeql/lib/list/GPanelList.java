package com.intellibucket.pipeql.lib.list;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GPanelList extends AbstractGPanel implements ComponentInitializer {
    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    private List<ComponentInitializer> components = List.of();
    public GPanelList(List<ComponentInitializer> components) {
        super();
        this.components = components;
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
