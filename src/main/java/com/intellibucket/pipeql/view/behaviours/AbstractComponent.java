package com.intellibucket.pipeql.view.behaviours;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.util.List;

public interface AbstractComponent {

    List<ComponentInitializer> getComponentInitializers();
    void setComponents();

}
