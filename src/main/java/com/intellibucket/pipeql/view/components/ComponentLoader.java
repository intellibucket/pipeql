package com.intellibucket.pipeql.view.components;

import java.util.List;

public interface ComponentLoader {
    default void load(){
        getChildren().forEach(ComponentLoader::load);
        addComponents();
    }

    List<ComponentLoader> getChildren();

    void addComponents();

}
