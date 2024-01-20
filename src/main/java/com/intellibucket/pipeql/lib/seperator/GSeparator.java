package com.intellibucket.pipeql.lib.seperator;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.util.List;

public class GSeparator extends JSeparator implements ComponentInitializer {
    {
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
