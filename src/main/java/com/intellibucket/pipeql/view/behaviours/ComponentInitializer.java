package com.intellibucket.pipeql.view.behaviours;

import java.util.List;

public interface ComponentInitializer {

    List<ComponentLoader> getComponentLoaders();

    default void initialize(){
        addComponents();
        initializeComponents(this.getComponentLoaders());
    }
    void addComponents();
    default void initializeComponents(List<ComponentLoader> componentLoaders){
        componentLoaders.forEach(ComponentLoader::load);
    }
}
