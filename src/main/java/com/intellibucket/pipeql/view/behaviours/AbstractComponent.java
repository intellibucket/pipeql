package com.intellibucket.pipeql.view.behaviours;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.util.List;

public interface AbstractComponent {

    List<ComponentInitializer> getComponentInitializers();
    void addComponents();

}
