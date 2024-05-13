package com.intellibucket.pipeql.lib;

import com.intellibucket.pipeql.view.components.AbstractComponent;

import java.util.List;

public interface ComponentInitializer extends AbstractComponent ,ActionInitializer, ListenerInitializer, PostInitializer {
    default void initialize(){
        this.setComponents();
        this.initializeComponents(this.getComponentInitializers());
        this.setEventPublisher();
        this.setEventListener();
        this.postInitialize();
    }
    default void initializeComponents(List<ComponentInitializer> componentLoaders){
        if(componentLoaders == null) return;
        componentLoaders.forEach(ComponentInitializer::initialize);
    }

}
