package com.intellibucket.pipeql.view.components;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.util.List;

public interface AbstractComponent {

    List<ComponentInitializer> getComponentInitializers();
    void setComponents();

}
