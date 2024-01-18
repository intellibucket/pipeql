package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.util.List;

public class SimplePanel extends AbstractGSimplePanel{
    private List<ComponentInitializer> componentInitializers = List.of();

    public SimplePanel() {
        super();
    }

    public SimplePanel(List<ComponentInitializer> componentInitializers) {
        super();
        this.componentInitializers = componentInitializers;
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return this.componentInitializers;
    }

    @Override
    public void addComponents() {
        this.componentInitializers.forEach(ComponentInitializer::initialize);
    }
}
