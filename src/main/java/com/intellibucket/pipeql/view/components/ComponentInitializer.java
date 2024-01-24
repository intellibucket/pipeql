package com.intellibucket.pipeql.view.components;

import com.intellibucket.pipeql.view.behaviours.AbstractComponent;

import java.util.List;

public interface ComponentInitializer extends AbstractComponent {
    default void initialize(){
        addComponents();
        initializeComponents(this.getComponentInitializers());
        postInitialize();
    }
    default void initializeComponents(List<ComponentInitializer> componentLoaders){
        if(componentLoaders == null) return;
        componentLoaders.forEach(ComponentInitializer::initialize);
    }


    default void postInitialize(){}
}
