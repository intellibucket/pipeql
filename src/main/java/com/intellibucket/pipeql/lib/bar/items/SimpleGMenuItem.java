package com.intellibucket.pipeql.lib.bar.items;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.util.List;

public class SimpleGMenuItem extends GMenuItem{

    public SimpleGMenuItem(String text) {
        super(text);
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {}
}
