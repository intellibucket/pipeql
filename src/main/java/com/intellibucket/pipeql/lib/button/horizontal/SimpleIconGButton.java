package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.util.List;

public class SimpleIconGButton extends AbstractGButton{

    public SimpleIconGButton(String iconName) {
        super(IconProvider.getIcon(iconName));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
